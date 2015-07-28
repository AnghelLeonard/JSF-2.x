package beans;

import java.io.Serializable;

public class CheckItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String label;
    private boolean value;

    public CheckItem(String label, boolean value) {
        this.label = label;
        this.value = value;
    }        

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }            
}
