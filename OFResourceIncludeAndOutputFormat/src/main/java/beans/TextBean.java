package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TextBean {

    public String decorate(String text) {
        return "***" + text + "***";
    }

}
