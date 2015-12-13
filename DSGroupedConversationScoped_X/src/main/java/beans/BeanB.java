package beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class BeanB implements Serializable {

    @Inject
    private ConversationBeanA ConversationBeana;
        
    private int B;

    public BeanB() {
        B = 0;
    }
    
    public void increaseB() {
        B++;       
    }

    public void increaseBWithA() {
        B+=ConversationBeana.getA();       
    }
    
    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }    
}
