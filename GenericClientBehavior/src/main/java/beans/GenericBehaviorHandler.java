package beans;

import javax.faces.component.behavior.ClientBehaviorBase;

/**
 *
 * @author Anghel Leonard
 */
public class GenericBehaviorHandler extends ClientBehaviorBase {

    @Override
    public String getRendererType() {           
        return "genericbehaviorrenderer";
    }
}
