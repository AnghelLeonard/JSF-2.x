package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import org.omnifaces.util.Callback;
import static org.omnifaces.util.Events.subscribeToViewAfterPhase;
import static org.omnifaces.util.Events.subscribeToViewBeforePhase;
import org.omnifaces.util.Faces;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private String name;
    private String submittedValue = "";
    private String localValue = "";

    @PostConstruct
    public void initPlayerBean() {
        // void Callback no argument
        subscribeToViewBeforePhase(PhaseId.PROCESS_VALIDATIONS, new Callback.Void() {
            @Override
            public void invoke() {
                System.out.println("BEFORE PROCESS_VALIDATIONS PHASE");
                UIInput uiInput = (UIInput) Faces.getViewRoot().findComponent("formId:nameId");
                submittedValue = (String) uiInput.getSubmittedValue();
            }
        });

        /*
         // void Callback with argument
         subscribeToViewBeforePhase(PhaseId.PROCESS_VALIDATIONS, new Callback.WithArgument<PhaseEvent>() {
         @Override
         public void invoke(PhaseEvent event) {                
         //do something ...
         }
         });
         */
        
        // void Callback no argument
        subscribeToViewAfterPhase(PhaseId.PROCESS_VALIDATIONS, new Callback.Void() {
            @Override
            public void invoke() {
                System.out.println("AFTER PROCESS_VALIDATIONS PHASE");
                UIInput uiInput = (UIInput) Faces.getViewRoot().findComponent("formId:nameId");
                localValue = (String) uiInput.getLocalValue();
            }
        });

        /*
         // void Callback with argument
         subscribeToViewAfterPhase(PhaseId.PROCESS_VALIDATIONS, new Callback.WithArgument<PhaseEvent>() {
         @Override
         public void invoke(PhaseEvent event) {                
         //do something ...
         }
         });
         */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save() {
        System.out.println("CURRENT PHASE = " + Faces.getContext().getCurrentPhaseId());
        System.out.println("SUBMITTED VALUE = " + submittedValue);
        System.out.println("LOCAL VALUE = " + localValue);
        System.out.println("SAVING = " + name);
    }
}
