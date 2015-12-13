package beans;

import org.apache.deltaspike.core.api.scope.ConversationSubGroup;

@ConversationSubGroup(of = ConversationABCDGroup.class, subGroup = CDInterface.class)
public class ConversationCDImplicitSubgroup {
    // NOPE
}
