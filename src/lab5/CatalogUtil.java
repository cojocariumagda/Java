package lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save (Catalog catalog) throws IOException {
            try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath())))
            {
                oos.writeObject(catalog);
            }
    }

    public static Catalog load(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream catalogInput = new ObjectInputStream(new FileInputStream(path));
        Catalog catalog = (Catalog) catalogInput.readObject();
        return catalog;
    }

    public static void view (Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        if (doc.getLocation().startsWith("http"))
            desktop.browse(new URI(doc.getLocation()));
        else
            desktop.open(new File((doc.getLocation())));
        // browse or open, depending of the location type
    }
}
