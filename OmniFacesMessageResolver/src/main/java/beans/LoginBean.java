package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String LOGIN_MESSAGE = "Welcome, {email}! Your current rank on our website is {rank}.";

    private String email;
    private String password;

    public void loginAction() {
        // some login stuff
        Map params = new HashMap();
        params.put("email", email);
        params.put("rank", "329");
        Messages.addInfo(null, LOGIN_MESSAGE, params);        
    }

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

}
