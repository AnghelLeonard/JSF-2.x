package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class WelcomeBean implements Serializable {

    private String page = "welcome";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}
