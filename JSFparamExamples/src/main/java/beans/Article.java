package beans;

import java.io.Serializable;

public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;
    private Integer id;

    public Article() {
    }

    public Article(String name, Integer id) {
        this.url = name;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Article[%s, %d]", url, id);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ? (this.getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Article) && (id != null)
                ? id.equals(((Article) obj).id)
                : (obj == this);
    }

}
