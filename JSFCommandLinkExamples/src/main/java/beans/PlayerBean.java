package beans;

import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private String name;
    private String email;
    private String weburl;
    private String countrycode;    
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }      

    public void save() {
        System.out.println("Saving data [save()] ...");
    }

    public void save(ActionEvent e) {
        System.out.println("Saving data [save(ActionEvent)] ...");
    }

    public String saveAndGo() {
        System.out.println("Saving data [saveAndGo()] ...");
        return "data";
    }

    public String saveAndParam() {
        System.out.println("Saving data [saveAndParam()] ...");
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        this.countrycode = params.get("playerCountryCode");
        this.weburl = params.get("playerWeburl");
        return "data";
    }

    public void saveAndAttributes(ActionEvent e) {
        System.out.println("Saving data [save(saveAndAttributes)] ...");
        this.countrycode = (String) e.getComponent().getAttributes().get("playerCountryCodeAttr");
        this.weburl = (String) e.getComponent().getAttributes().get("playerWeburlAttr");
    }

    public void reset() {
        this.name = "";
        this.email = "";
        this.age = "";
    }

    public String resetWithImmediate() {
        this.name = "";
        this.email = "";        
        return "index";
    }
}
