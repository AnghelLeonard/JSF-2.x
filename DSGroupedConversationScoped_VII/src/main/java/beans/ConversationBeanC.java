package beans;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ConversationGroup;
import org.apache.deltaspike.core.api.scope.GroupedConversation;
import org.apache.deltaspike.core.api.scope.GroupedConversationScoped;

@Named
@GroupedConversationScoped
@ConversationGroup(ConversationCDInterface.class)
public class ConversationBeanC implements Serializable {

    @Inject
    private GroupedConversation conversation;
    
    @Inject @ConversationGroup(ConversationABInterface.class)
    private ConversationBeanA ConversationBeana;

    private int C;

    public ConversationBeanC() {
        C = 0;
    }

    public void increaseC() {
        C++;
    }

    public void increaseCWithA() {
        C+=ConversationBeana.getA();
    }
    
    public void finish() {
        this.conversation.close();
    }

    public int getC() {
        return C;
    }

    public void setC(int C) {
        this.C = C;
    }
}
