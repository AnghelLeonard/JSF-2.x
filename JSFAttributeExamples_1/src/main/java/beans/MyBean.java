package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MyBean {

    private final String hello = "Hello world!";
    private final String style = "color:green";

    public MyBean() {
    }

    public String getHello() {
        return hello;
    }

    public String getStyle() {
        return style;
    }   
}
