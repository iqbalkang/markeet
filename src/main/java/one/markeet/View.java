package one.markeet;

import one.markeet.controllers.BookmarkController;
import one.markeet.entities.Bookmark;
import one.markeet.entities.User;

public class View {

    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getFirstName() + " is browsing...");
        int bookmarkCount = 0;

        for(Bookmark[] bookmarkList : bookmarks) {
            for(Bookmark bookmark : bookmarkList) {
                if(bookmarkCount == DataStore.USER_BOOKMARK_LIMIT) break;

                boolean shouldBookmark = shouldBookmarkDecision();
                if(!shouldBookmark) continue;

                BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                System.out.println(bookmark);
                bookmarkCount++;
            }
        }
    }

    private static boolean shouldBookmarkDecision() {
        return Math.random() > 0.5;
    }
}
