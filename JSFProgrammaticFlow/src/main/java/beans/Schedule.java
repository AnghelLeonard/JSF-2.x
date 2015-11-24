package beans;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class Schedule implements Serializable {

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {

        String flowId = "schedule";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
        flowBuilder.viewNode("success-id", "/" + flowId + "/success.xhtml");

        flowBuilder.returnNode("taskFlowReturnThanks").fromOutcome("/registration/thanks.xhtml");
        
        flowBuilder.inboundParameter("playernameparam", "#{flowScope.name}");
        flowBuilder.inboundParameter("playersurnameparam", "#{flowScope.surname}");
        flowBuilder.inboundParameter("playerregistrationcode", "#{scheduleBean.regcode}");

        return flowBuilder.getFlow();
    }
}
