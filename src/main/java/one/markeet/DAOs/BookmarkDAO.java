package one.markeet.DAOs;

import one.markeet.DataStore;
import one.markeet.entities.Bookmark;
import one.markeet.entities.UserBookmark;

import java.util.List;

public class BookmarkDAO {
    public List<List<Bookmark>> getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
