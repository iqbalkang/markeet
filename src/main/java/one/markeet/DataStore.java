package one.markeet;

import one.markeet.constants.BookGenre;
import one.markeet.constants.Gender;
import one.markeet.constants.MovieGenre;
import one.markeet.constants.UserType;
import one.markeet.entities.Book;
import one.markeet.entities.Bookmark;
import one.markeet.entities.User;
import one.markeet.entities.UserBookmark;
import one.markeet.managers.BookmarkManager;
import one.markeet.managers.UserManager;
import one.markeet.utils.IOUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore {

    private static List<User> users = new ArrayList<>();
    private static List<List<Bookmark>> bookmarks = new ArrayList<>();

    private static List<UserBookmark> userBookmarks = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<List<Bookmark>> getBookmarks() {
        return bookmarks;
    }

    public static List<UserBookmark> getUserBookmarks() {
        return userBookmarks;
    }

    private DataStore() {
    }

    public static void loadData() {
        loadUsers();
        loadBooks();
        loadMovies();
        loadWebLinks();
    }


    private static void loadUsers() {
        UserManager userManagerInstance = UserManager.getInstance();

        List<String> data = new ArrayList<>();
        IOUtil.read(data, "/Users/iqbal-kang/IdeaProjects/Markeet/User.txt");

        for(String row : data) {

            String[] rowValues = row.split("\t");
            long userId = Long.parseLong(rowValues[0]);

            int gender = Gender.MALE;
            if(rowValues[5].equals("f")) gender = Gender.FEMALE;
            else if(rowValues[5].equals("t")) gender = Gender.TRANSGENDER;

            User user = userManagerInstance.createUser(userId, gender, rowValues[1], rowValues[2], rowValues[3], rowValues[4], rowValues[6]);
            users.add(user);

        }

    }

    private static void loadWebLinks() {
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();

        List<String> data = new ArrayList<>();
        IOUtil.read(data, "/Users/iqbal-kang/IdeaProjects/Markeet/WebLink.txt");

        List<Bookmark> bookmarkList = new ArrayList<>();
        for(String row : data) {

            String[] rowValues = row.split("\t");
            long webLinkId = Long.parseLong(rowValues[0]);

            Bookmark bookmark = bookmarkManagerInstance.createWebLink(webLinkId, rowValues[1], "url", rowValues[2], rowValues[3]);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }

    private static void loadBooks() {
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();

        List<String> data = new ArrayList<>();
        IOUtil.read(data, "/Users/iqbal-kang/IdeaProjects/Markeet/Book.txt");

        List<Bookmark> bookmarkList = new ArrayList<>();
        for(String row : data) {

            String[] rowValues = row.split("\t");
            long bookId = Long.parseLong(rowValues[0]);
            int releaseYear = Integer.parseInt(rowValues[2]);
            double amazonRating = Double.parseDouble(rowValues[6]);

            String[] authors = rowValues[4].split(",");

            Bookmark bookmark = bookmarkManagerInstance.createBook(bookId, rowValues[1], releaseYear, " ", rowValues[3], authors, rowValues[5], amazonRating);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }

    private static void loadMovies() {
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();

        List<String > data = new ArrayList<>();
        IOUtil.read(data, "/Users/iqbal-kang/IdeaProjects/Markeet/Movie.txt");

        List<Bookmark> bookmarkList = new ArrayList<>();
        for(String row : data) {

            String[] rowValues = row.split("\t");
            long movieId = Long.parseLong(rowValues[0]);
            int releaseYear = Integer.parseInt(rowValues[2]);
            double imdbRating = Double.parseDouble(rowValues[6]);

            String[] cast = rowValues[3].split(",");
            String[] directors = rowValues[4].split(",");

            Bookmark bookmark = bookmarkManagerInstance.createMovie(movieId, rowValues[1], releaseYear, " ", cast, directors, rowValues[5], imdbRating);
            bookmarkList.add(bookmark);
        }
        bookmarks.add(bookmarkList);
    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks.add(userBookmark);
    }
}
