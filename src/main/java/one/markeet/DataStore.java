package one.markeet;

import one.markeet.constants.BookGenre;
import one.markeet.constants.Gender;
import one.markeet.constants.MovieGenre;
import one.markeet.constants.UserType;
import one.markeet.entities.Bookmark;
import one.markeet.entities.User;
import one.markeet.entities.UserBookmark;
import one.markeet.managers.BookmarkManager;
import one.markeet.managers.UserManager;

public class DataStore {
    public static final int USER_BOOKMARK_LIMIT = 5;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int TOTAL_USER_COUNT = 5;


    private static User[] users = new User[TOTAL_USER_COUNT];
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];

    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
    private static int bookmarkCount;


    public static User[] getUsers() {
        return users;
    }

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    public static UserBookmark[] getUserBookmarks() {
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

        users[0] = userManagerInstance.createUser(1000, Gender.MALE, "user0@semanticsquare.com", "test", "John", "M", UserType.USER);
        users[1] = userManagerInstance.createUser(1001, Gender.MALE, "user1@semanticsquare.com", "test", "Sam", "M", UserType.USER);
        users[2] = userManagerInstance.createUser(1002, Gender.FEMALE, "user2@semanticsquare.com", "test", "Anita", "M", UserType.EDITOR);
        users[3] = userManagerInstance.createUser(1003, Gender.FEMALE, "user3@semanticsquare.com", "test", "Sara", "M", UserType.EDITOR);
        users[4] = userManagerInstance.createUser(1004, Gender.MALE, "user4@semanticsquare.com", "test", "Dheeru", "M", UserType.CHIEF_EDITOR);
    }

    private static void loadWebLinks() {
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();
        bookmarks[0][0] = bookmarkManagerInstance.createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com", "unknown");
        bookmarks[0][1] = bookmarkManagerInstance.createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com", "unknown");
        bookmarks[0][2] = bookmarkManagerInstance.createWebLink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com", "unknown");
        bookmarks[0][3] = bookmarkManagerInstance.createWebLink(2003, "NIO tutorial by Greg Travis", "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu", "unknown");
        bookmarks[0][4] = bookmarkManagerInstance.createWebLink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org", "unknown");
    }

    private static void loadMovies() {
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();
        bookmarks[1][0] = bookmarkManagerInstance.createMovie(3000, "Citizen Kane", 1941, "", new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
        bookmarks[1][1] = bookmarkManagerInstance.createMovie(3001, "The Grapes of Wrath", 1940, "", new String[]{"Henry Fonda", "Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 8.2);
        bookmarks[1][2] = bookmarkManagerInstance.createMovie(3002, "A Touch of Greatness", 2004, "", new String[]{"Albert Cullum"}, new String[]{"Leslie Sullivan"}, MovieGenre.DOCUMENTARY, 7.3);
        bookmarks[1][3] = bookmarkManagerInstance.createMovie(3003, "The Big Bang Theory", 2007, "", new String[]{"Kaley Cuoco", "Jim Parsons"}, new String[]{"Chuck Lorre", "Bill Prady"}, MovieGenre.TELEVISION, 8.7);
        bookmarks[1][4] = bookmarkManagerInstance.createMovie(3004, "Ikiru", 1952, "", new String[]{"Takashi Shimura", "Minoru Chiaki"}, new String[]{"Akira Kurosawa"}, MovieGenre.COMEDY, 8.4);

    }

    private static void loadBooks() {
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();
        bookmarks[2][0] = bookmarkManagerInstance.createBook(4000, "Walden", 1854, "", "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = bookmarkManagerInstance.createBook(4001, "Self-Reliance and Other Essays", 1993, "", "Dover Publications", new String[]{"Ralph Waldo Emerson"}, BookGenre.PHILOSOPHY, 4.5);
        bookmarks[2][2] = bookmarkManagerInstance.createBook(4002, "Light From Many Lamps", 1988, "", "Touchstone", new String[]{"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][3] = bookmarkManagerInstance.createBook(4003, "Light From Many Lamps", 1988, "", "Touchstone", new String[]{"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][4] = bookmarkManagerInstance.createBook(4004, "Effective Java Programming Language Guide", 2007, "", "Prentice Hall", new String[]{"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);
    }


    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkCount] = userBookmark;
        bookmarkCount++;
    }
}
