package beans;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.omnifaces.util.Callback;
import static org.omnifaces.util.Events.subscribeToRequestAfterPhase;
import static org.omnifaces.util.Events.subscribeToRequestBeforePhase;
import org.omnifaces.util.Faces;

@FacesComponent(value = MyInput.COMPONENT_TYPE, createTag = true)
public class MyInput extends UIInput { 

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    public static final String COMPONENT_TYPE = "jsf.my.input.MyInput";

    private String submittedValue = "";
    private String localValue = "";   

    public MyInput() {       
        
        // void Callback no argument
        subscribeToRequestBeforePhase(PhaseId.PROCESS_VALIDATIONS, new Callback.Void() {
            @Override
            public void invoke() {
                System.out.println("BEFORE PROCESS_VALIDATIONS PHASE");
                submittedValue = (String)getSubmittedValue();
            }
        });  
        
        /*
        // void Callback with argument
        subscribeToRequestBeforePhase(PhaseId.PROCESS_VALIDATIONS, new Callback.WithArgument<PhaseEvent>() {
            @Override
            public void invoke(PhaseEvent event) {                
                //do something ...
            }
        });
        */
        
        // void Callback no argument
        subscribeToRequestAfterPhase(PhaseId.PROCESS_VALIDATIONS, new Callback.Void() {
            @Override
            public void invoke() {
                System.out.println("AFTER PROCESS_VALIDATIONS PHASE");
                localValue = (String)getLocalValue();
            }
        });          
        
        /*
        // void Callback with argument
        subscribeToRequestAfterPhase(PhaseId.PROCESS_VALIDATIONS, new Callback.WithArgument<PhaseEvent>() {
            @Override
            public void invoke(PhaseEvent event) {                
                //do something ...
            }
        });
        */        
    }   

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        System.out.println("CURRENT PHASE = " + Faces.getContext().getCurrentPhaseId());
        System.out.println("SUBMITTED VALUE = " + submittedValue+ " | " + getSubmittedValue());
        System.out.println("LOCAL VALUE = " + localValue+ " | " + getLocalValue());
        super.encodeEnd(context); 
    }
}
