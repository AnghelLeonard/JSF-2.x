package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.spi.scope.conversation.GroupedConversationManager;

@Named
@RequestScoped
public class CloseABCDGroupBean implements Serializable {

    @Inject
    private GroupedConversationManager conversationManager;

    public void finish() {
        this.conversationManager.closeConversationGroup(ConversationABCDGroup.class);
    }
}
