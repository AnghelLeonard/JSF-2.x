package beans;

import java.io.File;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.model.tree.SortedTreeModel;
import org.omnifaces.model.tree.TreeModel;
import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class TreeBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private TreeModel<ItemEntity> tree;
    private String selected = "none";
    
    @PostConstruct
    public void init() {
        tree = new SortedTreeModel<>();
        // current application folder
        walk(Faces.getRealPath("."), tree);
        // some local folder
        //walk("D:\\Omnifaces\\blog", tree);        
    }
    
    public TreeModel<ItemEntity> getTree() {
        return tree;
    }
    
    public void showHideItems(TreeModel<ItemEntity> node) {
        ItemEntity folderData = node.getData();
        for (TreeModel<ItemEntity> children : node.getChildren()) {
            ItemEntity fileData = children.getData();
            fileData.setVisible(!folderData.isExpanded());
        }
        folderData.setExpanded(!folderData.isExpanded());             
    }
    
    public void selectedFile(String selected){
        this.selected = selected;
    }

    public String getSelected() {
        return selected;
    } 
    
    private void walk(String path, TreeModel<ItemEntity> treem) {
        
        File root = new File(path);
        File[] list = root.listFiles();
        
        if (list == null) {
            return;
        }
        
        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println("Directory: " + f.getName());
                walk(f.getAbsolutePath(), treem.addChild(new ItemEntity(f.getAbsolutePath(), f.getName(), "folder", true, true)));
            } else {
                treem.addChild(new ItemEntity(f.getAbsolutePath(), f.getName(), "file", " (" + String.valueOf(f.length()) + " bytes)", true));
                System.out.println("File: " + f.getName());
            }
        }
    }
}
