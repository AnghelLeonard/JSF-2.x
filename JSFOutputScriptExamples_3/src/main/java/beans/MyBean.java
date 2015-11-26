package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MyBean {

    private final String jqueryJS = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js";

    public MyBean() {
    }

    public String getJqueryJS() {
        return jqueryJS;
    }   
}
