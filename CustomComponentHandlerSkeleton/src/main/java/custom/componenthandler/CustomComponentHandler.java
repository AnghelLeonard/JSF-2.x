package custom.componenthandler;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;

public class CustomComponentHandler extends ComponentHandler {

    private static final Logger logger = Logger.getLogger(CustomComponentHandler.class.getName());

    public CustomComponentHandler(ComponentConfig config) {
        super(config);
    }

    //only in JSF 2.2
    @Override
    public UIComponent createComponent(FaceletContext ctx) {
        logger.info("Inside 'createComponent' method");
        return super.createComponent(ctx);
    }

    @Override
    public void onComponentCreated(FaceletContext ctx, UIComponent c, UIComponent parent) {
        logger.info("Inside 'onComponentCreated' method");
        super.onComponentCreated(ctx, c, parent);
    }

    @Override
    public void onComponentPopulated(FaceletContext ctx, UIComponent c, UIComponent parent) {
        logger.info("Inside 'onComponentPopulated' method");
        super.onComponentPopulated(ctx, c, parent);
    }
}
