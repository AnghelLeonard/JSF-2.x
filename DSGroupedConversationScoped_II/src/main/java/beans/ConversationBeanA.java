package beans;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.GroupedConversation;
import org.apache.deltaspike.core.api.scope.GroupedConversationScoped;

@Named
@GroupedConversationScoped
public class ConversationBeanA implements Serializable {

    @Inject
    private GroupedConversation conversation;

    private int A;

    public ConversationBeanA() {
        A = 0;
    }

    public void increaseA() {
        A++;        
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
