package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MyBean {

    private final String animateCSS = "https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.css";

    public MyBean() {
    }

    public String getAnimateCSS() {
        return animateCSS;
    }
}
