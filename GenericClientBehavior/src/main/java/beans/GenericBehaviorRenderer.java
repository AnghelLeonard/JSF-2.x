package beans;

import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.render.ClientBehaviorRenderer;
import javax.faces.render.FacesBehaviorRenderer;

/**
 *
 * @author Anghel Leonard
 */
@FacesBehaviorRenderer(rendererType = "genericbehaviorrenderer")
public class GenericBehaviorRenderer extends ClientBehaviorRenderer {
 
    @Override
    public String getScript(ClientBehaviorContext behaviorContext, ClientBehavior behavior) {
        return "document.getElementById('behaviorsId').innerHTML += '" + behaviorContext.getEventName() + " |';";
    }
}
