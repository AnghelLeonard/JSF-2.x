package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.inject.Named;
import org.omnifaces.util.Components;

@Named
@SessionScoped
public class CompositeBean implements Serializable {

    public void addWelcomeCompositeComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        ViewDeclarationLanguage vdl = context.getApplication().getViewHandler().getViewDeclarationLanguage(context, context.getViewRoot().getViewId());

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("value", Components.createValueExpression("#{welcomeBean.value}", java.lang.String.class).getExpressionString());
        attributes.put("to", Components.createValueExpression("#{welcomeBean.to}", java.lang.String.class).getExpressionString());
        UINamingContainer welcomeComponent = (UINamingContainer) vdl.createComponent(context, "http://xmlns.jcp.org/jsf/composite/customs", "welcome", attributes);
        UIComponent parent = context.getViewRoot().findComponent("welcomeId");
        welcomeComponent.setId(parent.getClientId(context) + "_" + "welcomeMsgId");
        parent.getChildren().add(welcomeComponent);
    }
}
