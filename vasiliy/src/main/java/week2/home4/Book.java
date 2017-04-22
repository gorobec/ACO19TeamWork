package week2.home4;

public class Book extends Edition {
    private String author;
    private Genre genre;

    public Book(String title, int year, String author, Genre genre, int count) {
        super(title, year, count);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return genre == book.genre;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", author='" + author +
                ", genre=" + genre;
    }
}
