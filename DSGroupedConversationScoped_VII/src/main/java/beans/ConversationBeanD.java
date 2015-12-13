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
public class ConversationBeanD implements Serializable {

    @Inject
    private GroupedConversation conversation;
    
    @Inject @ConversationGroup(ConversationABInterface.class)
    private ConversationBeanB ConversationBeanb;

    private int D;

    public ConversationBeanD() {
        D = 0;
    }

    public void increaseD() {
        D++;
    }
    
    public void increaseDWithB() {
        D+=ConversationBeanb.getB();
    }

    public void finish() {
        this.conversation.close();
    }

    public int getD() {
        return D;
    }

    public void setD(int D) {
        this.D = D;
    }
}
