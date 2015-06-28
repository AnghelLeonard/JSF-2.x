package custom.tags;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;
import org.omnifaces.util.Components;

public class SimpleAjax extends TagHandler {

    private static final Logger LOG = Logger.getLogger(SimpleAjax.class.getName());

    public SimpleAjax(TagConfig tagConfig) {
        super(tagConfig);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {

        if (!ComponentHandler.isNew(parent)) {
            return;
        }

        if (!(parent instanceof ClientBehaviorHolder)) {
            return;
        }

        LOG.log(Level.INFO, "Processing tag handler  ...{0}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        AjaxBehavior ajaxBehavior = Components.createAjaxBehavior("#{commandBean.save}");
        ClientBehaviorHolder clientBehaviorHolder = (ClientBehaviorHolder) parent;
        // clientBehaviorHolder.addClientBehavior("action", ajaxBehavior);
        List<ClientBehavior> behaviors = clientBehaviorHolder.getClientBehaviors().get("action");
        // Guard against adding ourselves twice
        if (behaviors == null || !behaviors.contains(ajaxBehavior)) {
            clientBehaviorHolder.addClientBehavior("action", ajaxBehavior);
        }
    }

}
