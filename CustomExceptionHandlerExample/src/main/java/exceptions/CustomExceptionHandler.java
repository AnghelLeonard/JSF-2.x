package exceptions;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author Anghel Leonard
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private static final Logger LOG = Logger.getLogger(CustomExceptionHandler.class.getName());

    private ExceptionHandler exceptionHandler;

    CustomExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;

        LOG.info("JSF uses the CustomExceptionHandler ...");
    }

    @Override
    public ExceptionHandler getWrapped() {
        return exceptionHandler;
    }

    @Override
    public void handle() throws FacesException {

        LOG.info("JSF invoked CustomExceptionHandler#handle() method ...");

        final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

        // If there's no unhandled exception simply return.
        if (!queue.hasNext()) {
            return;
        }

        /////////////////////////////////////
        // HANDLE THE FIRST EXCEPTION ONLY //
        /////////////////////////////////////
        Throwable throwable = queue.next().getContext().getException();

        // Handle the exception, throwable.
        LOG.log(Level.INFO, "Handling exception: {0}", throwable);

        // Let JSF handle exceptions of type AbortProcessingException.
        if (throwable instanceof AbortProcessingException) {
            return;
        }

        // Remove the exception from the queue.
        queue.remove();

        // in order to find the exception root cause, maybe use here 
        // the org.omnifaces.util.Exceptions utilities such as:
        // Exceptions#is() or/and Exceptions#unwrap() methods
        //... HANDLE THE EXCEPTION ...
        
        // Remove all remaining exceptions if you want to fix only the first.
        while (queue.hasNext()) {
            queue.next();
            queue.remove();
        }

        // Give control to the default (or other) exception handler.
        getWrapped().handle();

        //////////////////////////////////////
        // HANDLE ALL OR A CERTAIN EXCEPTION //
        ///////////////////////////////////////
        while (queue.hasNext()) {
            ExceptionQueuedEvent item = queue.next();
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) item.getSource();

            // Get the excpetion from current iteration.
            Throwable throwable_item = exceptionQueuedEventContext.getException();

            // If you know that you want to handle all exceptions from queue 
            // then you can remove the exception from this iteration from the queue.
            queue.remove();

            // Handle the exception at this iteration, throwable_item.
            LOG.log(Level.INFO, "Handling exception: {0}", throwable_item);

            // In order to find the exception root cause, maybe use here 
            // the org.omnifaces.util.Exceptions utilities such as:
            // Exceptions#is() or/and Exceptions#unwrap() methods
            //...
            // If you want to handle a certain exception place here the conditions to
            // identify it. Also, remove from the queue only this exception
            // (pay attention to not remove unhandled exceptions, only if you intend to do so):
            queue.remove();
            //... HANDLE THE EXCEPTION OF THIS ITERATION ... 
            
            // Eventually, if you don't want to handle more exception then break the loop.
            break;
        }

        // Give control to the default (or other) exception handler.
        getWrapped().handle();
    }
}
