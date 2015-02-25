package beansds;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SomeBean implements Serializable {

    private int submit = 0;
   
    public void dummyLongAction() {        
        submit++;
        for (int i = 0; i < 1000000; i++) {
            System.out.println("I'm a dummy action ! Submit: " + submit);
        }        
    }

    public int getSubmit() {
        return submit;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }        
}
