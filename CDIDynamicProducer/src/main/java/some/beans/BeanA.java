package some.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BeanA {

    @Inject
    private Integer rndA;

    public void randomNumberA() {
        System.out.println("Injected random number in BeanA: " + rndA);
    }
}
