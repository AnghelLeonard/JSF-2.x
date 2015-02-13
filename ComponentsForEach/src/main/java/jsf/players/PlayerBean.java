package jsf.players;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.visit.VisitHint;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.util.Callback;
import org.omnifaces.util.Components;
import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class PlayerBean implements Serializable {

    private String name;
    private String surname;
    private String age;
    private String title;

    private UIForm uiForm;

    public UIForm getUiForm() {
        return uiForm;
    }

    public PlayerBean() {
    }

    public void setUiForm(UIForm uiForm) {
        this.uiForm = uiForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void someAction(byte usecase) {

        FacesContext fc = Faces.getContext();

        switch (usecase) {
            case 1:
                useCase_1(fc); // use Callback.WithArgument<UIComponent>()
                break;
            case 2:
                useCase_2(fc); // use Callback.WithArgument<UIComponent>()
                break;
            case 3:
                useCase_3(fc); // use Callback.WithArgument<UIComponent>()
                break;
            case 4:
                useCase_4(fc); // use Callback.WithArgument<UIComponent>()
                break;
            default:
                useCase_1(fc); // use Callback.WithArgument<UIComponent>()
                break;
        }
    }

    // 1 - suppress page rendering; visit from root
    // use Callback.WithArgument<UIComponent>()
    public void useCase_1(FacesContext fc) {
        // is like using fromRoot(fc.getViewRoot())
        Components.forEachComponent(fc).invoke(new Callback.WithArgument<UIComponent>() {
            @Override
            public void invoke(UIComponent component) {
                component.setRendered(false); // invoke any other operation
            }
        });
    }

    // 2 - suppress surnameLabelId, surnameId ,ageLabelId, ageId rendering; visit from form, myFormId
    // use Callback.WithArgument<UIComponent>()
    public void useCase_2(FacesContext fc) {
        // use havingIds(String... ids) if you don't like to use a collection
        Collection<String> ids = Arrays.asList("myFormId:surnameId", "myFormId:ageId", "myFormId:surnameLabelId", "myFormId:ageLabelId");
        Components.forEachComponent(fc).fromRoot(uiForm).havingIds(ids).invoke(new Callback.WithArgument<UIComponent>() {
            @Override
            public void invoke(UIComponent component) {
                component.setRendered(false); // invoke any other operation
            }
        });
    }

    // 3 - display IDs only of rendered components (will skip titleLabelId and titleId); visit from form, myFormId, with VisitHint.SKIP_UNRENDERED
    // use Callback.WithArgument<UIComponent>()
    public void useCase_3(FacesContext fc) {
        // use withHints(VisitHint... hints) if you don't like to use a set
        Set<VisitHint> vhs = new HashSet<>(Arrays.asList(VisitHint.SKIP_UNRENDERED));
        Components.forEachComponent(fc).fromRoot(uiForm).withHints(vhs).invoke(new Callback.WithArgument<UIComponent>() {
            @Override
            public void invoke(UIComponent component) {
                // you should not see listed: titleLabelId and titleId                
                System.out.println(component.getClientId()); // invoke any other operation
            }
        });
    }

    // 4 - suppress the rendering of all components of type UIInput and HtmlOutputLabel; visit from form, myFormId, with VisitHint.SKIP_UNRENDERED
    // use Callback.WithArgument<UIComponent>()
    public void useCase_4(FacesContext fc) {
        // use withHints(VisitHint... hints) if you don't like to use a set
        Set<VisitHint> vhs = new HashSet<>(Arrays.asList(VisitHint.SKIP_UNRENDERED));
        Components.forEachComponent(fc).fromRoot(uiForm).withHints(vhs).ofTypes(UIInput.class, HtmlOutputLabel.class).invoke(new Callback.WithArgument<UIComponent>() {
            @Override
            public void invoke(UIComponent component) {
                component.setRendered(false); // invoke any other operation
            }
        });
    }
}
