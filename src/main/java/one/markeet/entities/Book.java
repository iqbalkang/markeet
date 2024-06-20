package one.markeet.entities;

import one.markeet.constants.BookGenre;
import one.markeet.partner.Shareable;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Book extends Bookmark implements Shareable {
    private int releaseYear;

    private double amazonRating;

    private String publication;
    private String[] authors;
    private String genre;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean isKidFriendly() {
        if(genre.equals(BookGenre.ROMANCE) || genre.equals(BookGenre.PHILOSOPHY)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "releaseYear=" + releaseYear +
                ", amazonRating=" + amazonRating +
                ", publication='" + publication + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
            builder.append("<type> book </type>");
            builder.append("<title>").append(getTitle()).append("</title>");
            builder.append("<publication>").append(publication).append("</publication>");
            builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
            builder.append("<releaseYear>").append(StringUtils.join(authors, ",")).append("</releaseYear>");
            builder.append("<genre>").append(genre).append("</genre>");
        builder.append("</item>");

        return builder.toString();
    }
}
