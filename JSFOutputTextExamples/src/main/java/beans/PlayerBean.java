package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable{
    
    private String name="Rafael Nadal";
    private String coolname="<font face=\"verdana\" color=\"green\">Rafael Nadal</font>";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoolname() {
        return coolname;
    }

    public void setCoolname(String coolname) {
        this.coolname = coolname;
    }
              
}