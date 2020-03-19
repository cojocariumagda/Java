package lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable { //The class contains only methods that are related to the concept of "catalog", regardless of its external representation!

    private String name;
    private String path;

    private List<Document> documents = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add (Document doc)
    {
        documents.add(doc);
    }

    public Document findById (String id)
    {
        return documents.stream()
                .filter(d->d.getId().equals(id)).findFirst().orElse(null);
    }
}
