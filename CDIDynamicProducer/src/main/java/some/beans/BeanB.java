package some.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BeanB {
    
     @Inject
    private Integer rndB;
     
     public void randomNumberB() {
        System.out.println("Injected random number in BeanB: " + rndB);
    }
    
}
