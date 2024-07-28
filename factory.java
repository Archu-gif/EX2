interface Document {
    void create();
}

class WordDocument implements Document {
    @Override
    public void create() {
        System.out.println("Word document created.");
    }
}

class PDFDocument implements Document {
    @Override
    public void create() {
        System.out.println("PDF document created.");
    }
}

class DocumentFactory {
    public static Document createDocument(String docType) {
        if (docType.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (docType.equalsIgnoreCase("pdf")) {
            return new PDFDocument();
        } else {
            throw new IllegalArgumentException("Unknown document type");
        }
    }
}

// Usage
public class factory {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("word");
        doc1.create();

        Document doc2 = DocumentFactory.createDocument("pdf");
        doc2.create();
    }
}
