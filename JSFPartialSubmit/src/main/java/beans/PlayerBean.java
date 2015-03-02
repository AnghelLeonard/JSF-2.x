package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable{
    
    private String name;
    private String email;
    private String weburl; 
    private String countrycode;    
    private String invoked = "not-invoked";

    public String getInvoked() {
        return invoked;
    }

    public void setInvoked(String invoked) {
        this.invoked = invoked;
    }        
    
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

    public void save(){
        invoked = "invoked";
        System.out.println("Name: " + name);
        System.out.println("email: " + email);
        System.out.println("Country code: " + countrycode);
        System.out.println("Website: " + weburl);
    }
          
}
