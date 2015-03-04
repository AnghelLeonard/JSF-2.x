package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginBean implements Serializable{
        
    private String email;
    private String password; 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {    
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
    public String login(){
        System.out.println("Checking: " + email + "        " + password);
        return "welcome";
    }
        
}
