package one.markeet;

import one.markeet.entities.Bookmark;
import one.markeet.entities.User;
import one.markeet.managers.BookmarkManager;
import one.markeet.managers.UserManager;

import java.util.Arrays;
import java.util.List;

public class Launch {
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;

    private static void loadData() {
//        System.out.println("1. Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

//        printUsers();
//        printBookmarks();
    }

    private static void printUsers() {
        for(User user : users)
            System.out.println(user);
    }

    private static void printBookmarks() {
        for(List<Bookmark> bookmarkList : bookmarks)
            for(Bookmark bookmark : bookmarkList)
                System.out.println(bookmark);
    }

    public static void startBrowsing() {
         for(User user : users)
            View.browse(user, bookmarks);
    }

    public static void main(String[] args) {
        loadData();
        startBrowsing();
    }
}
