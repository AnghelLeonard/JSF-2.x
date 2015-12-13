package beans;

import org.apache.deltaspike.core.api.scope.ConversationSubGroup;

@ConversationSubGroup(subGroup = {ConversationBeanC.class, ConversationBeanD.class})
public class ConversationCDSubgroup extends ConversationABCDGroup {
    // NOPE
}
