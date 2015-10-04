package phaselistener;

import java.util.logging.Logger;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyPhaseListener implements PhaseListener {
    
    private static final Logger LOG = Logger.getLogger(MyPhaseListener.class.getName());        

    @Override
    public void afterPhase(PhaseEvent event) {        
        LOG.info("After phase: " + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        LOG.info("Before phase: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
