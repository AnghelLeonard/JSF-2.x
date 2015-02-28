package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private String name = "Rafael Nadal";
    private String age = "0";

    public String save1() {
        // extract the hidden value from request parameter map
        String playerage = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formId3:playerage3");
        // print the extracted value
        System.out.println("Player age: " + playerage);
        // set the bean field, 'age', equal to the extracted value
        this.age = playerage;
        // navigate to 'data.xhtml' page
        return "data";
    }

    public String save2() {
        // extract the hidden value from request parameter map
        String playerage = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("playerage4");
        // print the extracted value
        System.out.println("Player age: " + playerage);
        // set the bean field, 'age', equal to the extracted value
        this.age = playerage;
        // navigate to 'data.xhtml' page
        return "data";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
