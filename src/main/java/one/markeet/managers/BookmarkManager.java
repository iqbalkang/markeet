package one.markeet.managers;

import one.markeet.DAOs.BookmarkDAO;
import one.markeet.DataStore;
import one.markeet.entities.*;

public class BookmarkManager {
    private static final BookmarkManager instance = new BookmarkManager();
    private final BookmarkDAO bookmarkDAO = new BookmarkDAO();

    private BookmarkManager() {}

    public static BookmarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long id, String title, int releaseYear, String profileUrl, String[] cast, String[] directors, String genre, double imdbRating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setImdbRating(imdbRating);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);

        return movie;
    }

    public Book createBook(long id, String title, int releaseYear, String profileUrl, String publication, String[] authors, String genre, double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setProfileUrl(profileUrl);
        book.setReleaseYear(releaseYear);
        book.setAmazonRating(amazonRating);
        book.setPublication(publication);
        book.setAuthors(authors);
        book.setGenre(genre);

        return book;
    }

    public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setProfileUrl(profileUrl);
        webLink.setUrl(url);
        webLink.setHost(host);

        return webLink;
    }

    public Bookmark[][] getBookmarks() {
        return bookmarkDAO.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        bookmarkDAO.saveUserBookmark(userBookmark);
    }


}
