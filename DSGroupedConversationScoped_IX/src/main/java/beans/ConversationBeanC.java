package beans;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ConversationGroup;
import org.apache.deltaspike.core.api.scope.GroupedConversation;
import org.apache.deltaspike.core.api.scope.GroupedConversationScoped;

@Named
@GroupedConversationScoped
@ConversationGroup(ConversationABCDGroup.class)
public class ConversationBeanC implements Serializable, CDInterface {

    @Inject
    private GroupedConversation conversation;

    private int C;

    public ConversationBeanC() {
        C = 0;
    }

    public void increaseC() {
        C++;
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
