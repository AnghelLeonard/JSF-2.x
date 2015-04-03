package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class ContactBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size.List({
        @Size(min = 3, max = 20, message = "(member)# please enter a valid name (between 3-20 characters)", groups = beans.MemberContactValidationGroup.class),
        @Size(min = 6, max = 10, message = "(admin)# please enter a valid name (between 6-10 characters)", groups = beans.AdminContactValidationGroup.class)
    })
    @Pattern(regexp = "(admin)[a-zA-Z0-9]*", message = "(admin)# please enter a valid name (it should start with admin...)", groups = beans.AdminContactValidationGroup.class)
    private String name;

    @Size(min = 1, message = "Please enter the e-mail !")
    @Pattern.List({
        @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "(member)# please enter a valid formated e-mail", groups = beans.MemberContactValidationGroup.class),
        @Pattern(regexp = "(admin)+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "(admin)# please enter a valid e-mail (it should start with admin@...)", groups = beans.AdminContactValidationGroup.class)
    })
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

}
