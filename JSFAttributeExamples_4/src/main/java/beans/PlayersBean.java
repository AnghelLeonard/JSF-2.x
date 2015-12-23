package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private UIInput htmlInputText= null;    
   
    /**
     * Creates a new instance of PlayersBean
     */
    public PlayersBean() {
    }

    public UIInput getHtmlInputText() {
        return htmlInputText;
    }

    public void setHtmlInputText(UIInput htmlInputText) {
        this.htmlInputText = htmlInputText;
    }    
    
    public String getPlayerNameSurname() {
        return (String) htmlInputText.getAttributes().get("playerNameAttr");
    }    
}
