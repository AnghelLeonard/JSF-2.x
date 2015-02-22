package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.inject.Named;
import org.omnifaces.util.Components;
import org.omnifaces.util.Faces;

@Named
@SessionScoped
public class CompositeBean implements Serializable {

    public void addWelcomeCompositeComponent() {
        UIComponent parent = Faces.getViewRoot().findComponent("welcomeId");
        UIComponent composite = Components.includeCompositeComponent(parent, "customs", "/welcome.xhtml", "welcomeMsgId");
        composite.setValueExpression("value", Components.createValueExpression("#{welcomeBean.value}", java.lang.String.class));
        composite.setValueExpression("to", Components.createValueExpression("#{welcomeBean.to}", java.lang.String.class));
    }
}
