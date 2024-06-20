package one.markeet.entities;

import one.markeet.constants.BookGenre;
import one.markeet.constants.MovieGenre;
import one.markeet.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void isKidFriendly() {
        // test 1: philosophy books -> false
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();
        Book book = bookmarkManagerInstance.createBook(4000, "Walden", 1854, "", "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        boolean isKidFriendly = book.isKidFriendly();
        assertFalse(isKidFriendly, "for philosophy books, isKidFriendly() must return false");

        // test 2: romance books -> false
        book = bookmarkManagerInstance.createBook(4000, "Walden", 1854, "", "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.ROMANCE, 4.3);
        isKidFriendly = book.isKidFriendly();
        assertFalse(isKidFriendly, "for romance books, isKidFriendly() must return false");
    }
}