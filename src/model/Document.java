package model;

public class Document {
    private int documentId;
    private String title;
    private int publisherId;
    private int publicationYear;
    private String category;
    private int totalCopies;
    private int availableCopies;
    private double price;

    public Document() {}

    public Document(int documentId, String title, int publisherId, int publicationYear,
                    String category, int totalCopies, int availableCopies, double price) {
        this.documentId = documentId;
        this.title = title;
        this.publisherId = publisherId;
        this.publicationYear = publicationYear;
        this.category = category;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.price = price;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Document{" +
               "ID=" + documentId +
               ", Title='" + title + '\'' +
               ", Publisher ID=" + publisherId +
               ", Year=" + publicationYear +
               ", Category='" + category + '\'' +
               ", Total Copies=" + totalCopies +
               ", Available Copies=" + availableCopies +
               ", Price=" + price +
               '}';
    }
}
