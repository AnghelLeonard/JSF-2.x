package beans;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

/**
 *
 * @author Anghel Leonard
 */
public class GenericBehaviorTagHandler extends TagHandler {

    private final GenericBehaviorHandler onmouseout = new GenericBehaviorHandler();
    private final GenericBehaviorHandler onmouseover = new GenericBehaviorHandler();
    private final GenericBehaviorHandler onclick = new GenericBehaviorHandler();
    private final GenericBehaviorHandler onmousedown = new GenericBehaviorHandler();
    private final GenericBehaviorHandler onmouseup = new GenericBehaviorHandler();

    public GenericBehaviorTagHandler(TagConfig tagConfig) {
        super(tagConfig);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {

        if (parent instanceof ClientBehaviorHolder) {
            ClientBehaviorHolder clientBehaviorHolder = (ClientBehaviorHolder) parent;

            Map<String, List<ClientBehavior>> behaviors = clientBehaviorHolder.getClientBehaviors();

            if (!(behaviors.containsKey("mouseout"))
                    && !(behaviors.containsKey("click"))
                    && !(behaviors.containsKey("mouseover"))
                    && !(behaviors.containsKey("mousedown"))
                    && !(behaviors.containsKey("mouseup"))) {

                clientBehaviorHolder.addClientBehavior("mouseout", onmouseout);
                clientBehaviorHolder.addClientBehavior("mouseover", onmouseover);
                clientBehaviorHolder.addClientBehavior("click", onclick);
                clientBehaviorHolder.addClientBehavior("mousedown", onmousedown);
                clientBehaviorHolder.addClientBehavior("mouseup", onmouseup);
            }
        }
    }
}
