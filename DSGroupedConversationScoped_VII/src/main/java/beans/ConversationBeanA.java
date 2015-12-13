package beans;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ConversationGroup;
import org.apache.deltaspike.core.api.scope.GroupedConversation;
import org.apache.deltaspike.core.api.scope.GroupedConversationScoped;

@Named
@GroupedConversationScoped
@ConversationGroup(ConversationABInterface.class)
public class ConversationBeanA implements Serializable {

    @Inject
    private GroupedConversation conversation;
    
    @Inject @ConversationGroup(ConversationCDInterface.class)
    private ConversationBeanC ConversationBeanc;

    private int A;

    public ConversationBeanA() {
        A = 0;
    }

    public void increaseA() {
        A++;        
    }
    
    public void increaseAWithC() {
        A+=ConversationBeanc.getC();
    }

    public void finish() {
        this.conversation.close();
    }

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }
}
