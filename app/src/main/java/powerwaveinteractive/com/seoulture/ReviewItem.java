package powerwaveinteractive.com.seoulture;

import java.io.Serializable;

/**
 * Created by vincenthanna on 8/26/14.
 */
public class ReviewItem implements Serializable{
    int id;
    int cultureItemId;
    String name;
    String title;
    String reviewText;
    double rating;

    ReviewItem() {
        id = 0;
        cultureItemId = 0;
        name = "";
        reviewText = "";
        rating = 0.0;
    }

    ReviewItem(int id, int cultureItemId, String name,String title, String review, double rating) {
        this.id = id;
        this.cultureItemId = cultureItemId;
        this.name = name;
        this.title = title;
        this.reviewText = review;
        this.rating = rating;
    }
}
