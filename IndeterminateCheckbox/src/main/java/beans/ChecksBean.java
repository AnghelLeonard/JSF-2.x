package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.omnifaces.model.tree.ListTreeModel;
import org.omnifaces.model.tree.TreeModel;

@Named
@SessionScoped
public class ChecksBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private TreeModel<CheckItem> tree;

    @PostConstruct
    public void init() {
        tree = new ListTreeModel<>();

        tree.addChild(new CheckItem("Install", false))
                .addChild(new CheckItem("Demos", false))
                .getParent().addChild(new CheckItem("Development", false))
                .addChild(new CheckItem("Simple", false))
                .getParent().addChild(new CheckItem("Advanced", false))
                .getParent().getParent().addChild(new CheckItem("Debug", false))
                .getParent().getParent().addChild(new CheckItem("Repair", false))
                .addChild(new CheckItem("Demos", false))
                .getParent().addChild(new CheckItem("Tools", false))
                .getParent().addChild(new CheckItem("Kit", false));
    }

    public TreeModel<CheckItem> getTree() {
        return tree;
    }

}
