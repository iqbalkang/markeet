package one.markeet.controllers;

import one.markeet.entities.Bookmark;
import one.markeet.entities.User;
import one.markeet.managers.BookmarkManager;

public class BookmarkController {
    private BookmarkController() {}

    private static final BookmarkController instance = new BookmarkController();

    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }
}
