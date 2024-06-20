package one.markeet.entities;

import one.markeet.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest {

    @Test
    public void isKidFriendly() {
        // test 1: porn in url -> false
        BookmarkManager bookmarkManagerInstance = BookmarkManager.getInstance();
        WebLink weblink = bookmarkManagerInstance.createWebLink(2000, "Taming Tiger, Part 2", " ","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com");
        boolean isKidFriendly = weblink.isKidFriendly();
        assertFalse(isKidFriendly, "for porn in url, isKidFriendly() must return false");

        // test 2: porn in title -> false
        weblink = bookmarkManagerInstance.createWebLink(2000, "Taming porn, Part 2", " ","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        isKidFriendly = weblink.isKidFriendly();
        assertFalse(isKidFriendly, "for porn in title, isKidFriendly() must return false");

        // test 3: adult in host -> false
        weblink = bookmarkManagerInstance.createWebLink(2000, "Taming Tiger, Part 2", " ","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");
        isKidFriendly = weblink.isKidFriendly();
        assertFalse(isKidFriendly, "for adult in host, isKidFriendly() must return false");

        // test 4: adult in url, but not in host -> true
        weblink = bookmarkManagerInstance.createWebLink(2000, "Taming Tiger, Part 2", " ","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");
        isKidFriendly = weblink.isKidFriendly();
        assertTrue(isKidFriendly, "for adult in url, but not host, isKidFriendly() must return true");

        // test 5: adult in title only -> true
        weblink = bookmarkManagerInstance.createWebLink(2000, "Taming adult, Part 2", " ","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        isKidFriendly = weblink.isKidFriendly();
        assertTrue(isKidFriendly, "for adult in title only, isKidFriendly() must return true");
    }
}