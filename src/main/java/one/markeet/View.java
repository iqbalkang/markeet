package one.markeet;

import one.markeet.constants.KidFriendlyStatus;
import one.markeet.constants.UserType;
import one.markeet.controllers.BookmarkController;
import one.markeet.entities.Bookmark;
import one.markeet.entities.User;
import one.markeet.partner.Shareable;

import java.util.List;

public class View {

    public static void browse(User user, List<List<Bookmark>> bookmarks) {
        System.out.println("\n" + user.getFirstName() + "(" + user.getUserType() + ")" + " is browsing...");
        int bookmarkCount = 0;

        for(List<Bookmark> bookmarkList : bookmarks) {
            for(Bookmark bookmark : bookmarkList) {

//                bookmarking
                boolean shouldBookmark = shouldBookmarkDecision();
                if(!shouldBookmark) continue;

                BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                System.out.println("new item bookmarked: " + bookmark);
                bookmarkCount++;

//                setting kid friendly status
                if(user.getUserType().equals(UserType.USER)) continue;
                if(!(bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN))) continue;
                String kidFriendlyStatusDecision = getKidFriendlyStatusDecision();

                if(kidFriendlyStatusDecision.equals(KidFriendlyStatus.UNKNOWN)) continue;
                BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatusDecision, bookmark);

//                sharing the bookmark
                if(!(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable)) continue;
                if(!getShareDecision()) continue;;
                BookmarkController.getInstance().share(user, bookmark);

            }
        }
    }

    private static boolean getShareDecision() {
        return Math.random() > 0.5;
    }

    private static boolean shouldBookmarkDecision() {
        return Math.random() >= 0.5;
    }

    private static String getKidFriendlyStatusDecision() {
        double random = Math.random();
        return random < 0.4 ? "approved" : random >= 0.5 && random <=0.75 ? "rejected" : "unknown";
    }

}
