package one.markeet.entities;

import one.markeet.constants.MovieGenre;
import one.markeet.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void isKidFriendly() {
        // test 1: horror movies -> false
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();
        Movie movie = bookmarkManagerInstance.createMovie(3000, "Citizen Kane", 1941, "", new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.HORROR, 8.5);
        boolean isKidFriendly = movie.isKidFriendly();
        assertFalse(isKidFriendly, "for horror movies, isKidFriendly() must return false");

        // test 2: thriller movies -> false
        movie = bookmarkManagerInstance.createMovie(3000, "Citizen Kane", 1941, "", new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.THRILLER, 8.5);
        isKidFriendly = movie.isKidFriendly();
        assertFalse(isKidFriendly, "for thriller movies, isKidFriendly() must return false");
    }
}