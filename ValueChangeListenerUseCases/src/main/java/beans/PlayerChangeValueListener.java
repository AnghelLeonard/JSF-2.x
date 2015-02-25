package beans;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class PlayerChangeValueListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        System.out.println("PlayerChangeValueListener: [PLAYER CHANGE]" + "  " + event.getOldValue() + " IN " + event.getNewValue());
    }

}
