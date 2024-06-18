package one.markeet.DAOs;

import one.markeet.DataStore;
import one.markeet.entities.Bookmark;
import one.markeet.entities.UserBookmark;

public class BookmarkDAO {
    public Bookmark[][] getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
