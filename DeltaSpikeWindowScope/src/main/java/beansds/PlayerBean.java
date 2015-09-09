package beansds;

import java.io.Serializable;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.WindowScoped;

@Named
@WindowScoped  // for comparison, you can switch to SessionScoped and test again 
public class PlayerBean implements Serializable{
    
    private String name = "-";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }            
}
