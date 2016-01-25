package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class ContactBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ValidContact(message = "The name should be used in e-mail as name@domain.com!")
    private String name;
    @ValidContact(message = "The e-mail should be of type name@domain.com!")
    private String email;

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

    public void someAction() {
        Messages.addGlobalInfo("Thank you for your contacts!");
    }
}
