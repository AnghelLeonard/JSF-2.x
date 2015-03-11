package beans;

import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private String age;  

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void info() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an info message 
        context.addMessage("IformId:ageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message !", "This message is just a dummy info message to see how it works !"));
    }

    public void warn() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an warning message
        context.addMessage("WformId:ageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "This is an warning message !", "This message is just a dummy warning message to see how it works !"));
    }

    public void error() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an error message
        context.addMessage("EformId:ageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is an error message !", "This message is just a dummy error message to see how it works !"));
    }

    public void fatal() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an error message
        context.addMessage("FformId:ageId", new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is an fatal message !", "This message is just a dummy fatal message to see how it works !"));
    }

    public void randomMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        Random rnd = new Random();
        int msgtype = 1+rnd.nextInt(4);

        switch (msgtype) {
            case 1:
                context.addMessage("ALLformId:ageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message !", "This message is just a dummy info message to see how it works !"));
                break;
            case 2:
                context.addMessage("ALLformId:ageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "This is an warning message !", "This message is just a dummy warning message to see how it works !"));
                break;
            case 3:
                context.addMessage("ALLformId:ageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is an error message !", "This message is just a dummy error message to see how it works !"));
                break;
            case 4:
                context.addMessage("ALLformId:ageId", new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is an fatal message !", "This message is just a dummy fatal message to see how it works !"));
                break;
        }
    }
}
