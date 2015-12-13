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
public class ConversationBeanB implements Serializable {

    @Inject
    private GroupedConversation conversation;

    private int B;

    public ConversationBeanB() {
        B = 0;
    }

    public void increaseB() {
        B++;       
    }

    public void finish() {
        this.conversation.close();
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }    
}
