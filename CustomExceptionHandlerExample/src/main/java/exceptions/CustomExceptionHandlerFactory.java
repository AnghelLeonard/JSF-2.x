package exceptions;

import java.util.logging.Logger;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author Anghel Leonard
 */
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

    private static final Logger LOG = Logger.getLogger(CustomExceptionHandlerFactory.class.getName());   
    
    private ExceptionHandlerFactory exceptionHandlerFactory;

    public CustomExceptionHandlerFactory(){        
    }
    
    public CustomExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
        this.exceptionHandlerFactory = exceptionHandlerFactory;
        
        LOG.info("JSF has successfully configured CustomExceptionHandlerFactory ...");
    }

    @Override
    public ExceptionHandler getExceptionHandler() {  
        
        LOG.info("JSF requires an instance of our CustomExceptionHandler ...");
        
        ExceptionHandler handler = new CustomExceptionHandler(exceptionHandlerFactory.getExceptionHandler());

        return handler;
    }
}
