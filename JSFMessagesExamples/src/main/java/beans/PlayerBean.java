package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private String age;
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an info message 
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message !", "This message is just a dummy info message to see how it works !"));
    }

    public void warn() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an warning message
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "This is an warning message !", "This message is just a dummy warning message to see how it works !"));
    }

    public void error() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an error message
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is an error message !", "This message is just a dummy error message to see how it works !"));
    }

    public void fatal() {
        FacesContext context = FacesContext.getCurrentInstance();
        // add an error message
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is an fatal message !", "This message is just a dummy fatal message to see how it works !"));
    }

    public void allMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message !", "This message is just a dummy info message to see how it works !"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "This is an warning message !", "This message is just a dummy warning message to see how it works !"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is an error message !", "This message is just a dummy error message to see how it works !"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is an fatal message !", "This message is just a dummy fatal message to see how it works !"));
    }

    public void oneGlobalOneNot() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("formId:ageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message (not global)!", "This message is just a dummy info message to see how it works (not global)!"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message (global)!", "This message is just a dummy info message to see how it works (global)!"));
    }
    
    public void moreGlobalAndNotGlobal() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("form2Id:ageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message (not global)!", "This message is just a dummy info message to see how it works (not global)!"));
        context.addMessage("form2Id:ageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "This is an warning message (not global)!", "This message is just a dummy warning message to see how it works (not global)!"));
        context.addMessage("form2Id:ageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is an error message (not global)!", "This message is just a dummy error message to see how it works (not global)!"));
        context.addMessage("form2Id:ageId", new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is an fatal message (not global)!", "This message is just a dummy fatal message to see how it works (not global)!"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "This is an info message (global)!", "This message is just a dummy info message to see how it works (global)!"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "This is an warning message (global)!", "This message is just a dummy warning message to see how it works (global)!"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is an error message (global)!", "This message is just a dummy error message to see how it works (global)!"));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is an fatal message (global)!", "This message is just a dummy fatal message to see how it works (global)!"));
    }
}
