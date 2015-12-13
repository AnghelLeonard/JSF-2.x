package beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ConversationGroup;

@Named
@ViewScoped
public class BeanC implements Serializable {

    private int C;

    @Inject @ConversationGroup(ConversationABInterface.class)
    private ConversationBeanA ConversationBeana;

    @Inject @ConversationGroup(ConversationABInterface.class)
    private ConversationBeanB ConversationBeanb;

    public BeanC() {
        C = 0;
    }

    public void increaseC() {
        C++;
    }

    public void increaseCWithAandB() {
        C += ConversationBeana.getA() + ConversationBeanb.getB();
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }
}
