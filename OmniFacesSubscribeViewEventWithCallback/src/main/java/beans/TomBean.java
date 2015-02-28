package beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.PreRenderViewEvent;
import javax.inject.Named;
import org.omnifaces.util.Callback;
import static org.omnifaces.util.Events.subscribeToViewEvent;

@Named
@RequestScoped
public class TomBean {

    private String enemy;
    private String advice;

    @PostConstruct
    public void adviceForTom() {
        
        //the enemy value is not available in @PostConstruct, but we can
        //subscribe with a callback to PreRenderViewEvent, when the enemy is available
        subscribeToViewEvent(PreRenderViewEvent.class, new Callback.Void() {
            @Override
            public void invoke() {
                if (enemy != null) {
                    if (enemy.equals("jerry")) {
                        advice = "Tom, watch the dog while you are chasing Jerry!";
                    } else if (enemy.equals("dog")) {
                        advice = "Tom, be careful to Jerry traps!";
                    } else {
                        advice = "Tom, you have a new enemy ?!!";
                    }
                }
            }
        });

        /* Callback.WithArgument()
        subscribeToViewEvent(PreRenderViewEvent.class, new Callback.WithArgument<SystemEvent>() {
            @Override
            public void invoke(SystemEvent event) {
                if (enemy != null) {
                    if (enemy.equals("jerry")) {
                        advice = "Tom, watch the dog while you are chasing Jerry!";
                    } else if (enemy.equals("dog")) {
                        advice = "Tom, be careful to Jerry traps!";
                    } else {
                        advice = "Tom, you have a new enemy ?!!";
                    }
                }
            }
        });
         */
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
