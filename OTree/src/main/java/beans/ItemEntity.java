package beans;

import java.io.Serializable;
import java.util.Objects;

public class ItemEntity implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;

    private String path;      // the absolute path of the folder/file
    private String name;      // the file/folder name
    private String size;      // the file size in bytes
    private String type;      // the artifact type: folder or file
    private boolean visible;  // specific to files for indicating visibility
    private boolean expanded; // specific to folders for indicating collapse/expand

    public ItemEntity() {
    }

    // for a folder
    public ItemEntity(String path, String name, String type, boolean expanded, boolean visible) {
        this.path = path;
        this.expanded = expanded;
        this.visible = visible;
        this.name = name;
        this.type = type;
    }

    // for a file
    public ItemEntity(String path, String name, String type, String size, boolean visible) {
        this.path = path;
        this.visible = visible;
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public int compareTo(Object o) {
        ItemEntity it = (ItemEntity) o;
        if (it.getType().equals("folder")) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemEntity other = (ItemEntity) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "(" + size + ")";
    }
}
