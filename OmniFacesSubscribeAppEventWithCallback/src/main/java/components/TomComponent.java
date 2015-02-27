package components;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.SystemEvent;
import org.omnifaces.util.Callback;
import static org.omnifaces.util.Events.subscribeToApplicationEvent;

@FacesComponent(value = TomComponent.COMPONENT_TYPE, createTag = true)
public class TomComponent extends UIComponentBase {

    public static final String COMPONENT_FAMILY = "jsf.callback.with.argument";
    public static final String COMPONENT_TYPE = "jsf.callback.with.argument.TomComponent";

    @PostConstruct
    public void initTomComponent() {

        // void Callback with argument
        subscribeToApplicationEvent(PostAddToViewEvent.class, new Callback.WithArgument<SystemEvent>() {
            @Override
            public void invoke(SystemEvent event) {
                System.out.println("..: PostAddToViewEvent event emitted by UIViewRoot :.."
                        + event.getSource());
                //do something ...
            }
        });

        // void Callback
        subscribeToApplicationEvent(PostAddToViewEvent.class, new Callback.Void() {
            @Override
            public void invoke() {
                System.out.println("..: PostAddToViewEvent event emitted by UIViewRoot :..");
                //do something ...
            }
        });
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.write("I'm Tom the cat!");
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }
}
