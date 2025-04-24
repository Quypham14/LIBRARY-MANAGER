package model;

public class Author {
    private int authorId;
    private String fullName;
    private String biography;

    public Author() {}

    public Author(int authorId, String fullName, String biography) {
        this.authorId = authorId;
        this.fullName = fullName;
        this.biography = biography;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" +
               "ID=" + authorId +
               ", Full Name='" + fullName + '\'' +
               ", Biography='" + biography + '\'' +
               '}';
    }
}
