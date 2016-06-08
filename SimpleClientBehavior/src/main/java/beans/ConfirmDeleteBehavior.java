package beans;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;

/**
 *
 * @author Anghel Leonard
 */
@FacesBehavior(value = "confirm")
public class ConfirmDeleteBehavior extends ClientBehaviorBase {   
    
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return "return confirm('Are you sure you want to delete this file ?');";
    }
}
