package lab5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Compulsory {

    private void testCreateSave()
    {
        Catalog catalog = new Catalog("Java Resuorces", "D:\\FII\\Git\\FII\\AnII\\Sem2\\PA\\CatalogLab5\\catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        Document docNew = new Document( "newId", "Magda", "https://google.ro");
        Document docFileNew = new Document("fileId", "MagdaFile", "D:\\FII\\Git\\FII\\AnII\\Sem2\\PA\\CatalogLab5\\File.new.txt");
        doc.addTag("type", "Slides");

        catalog.add(docFileNew);
        catalog.add(docNew);
        catalog.add(doc);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void testLoadView()
    {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("D:\\FII\\Git\\FII\\AnII\\Sem2\\PA\\CatalogLab5\\catalog.ser");
        } catch (IOException e ) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Document doc = null;
        if (catalog != null) {
            doc = catalog.findById("java1");
        }

        try {
            CatalogUtil.view(Objects.requireNonNull(doc));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document docNew = null;
        if (catalog != null) {
            docNew = catalog.findById("newId");
        }

        try {
            CatalogUtil.view(Objects.requireNonNull(docNew));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document docFileNew = null;
        if (catalog != null) {
            docFileNew = catalog.findById("fileId");
        }

        try {
            CatalogUtil.view(Objects.requireNonNull(docFileNew));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Compulsory app = new Compulsory();
        app.testCreateSave();
        app.testLoadView();
    }
}
