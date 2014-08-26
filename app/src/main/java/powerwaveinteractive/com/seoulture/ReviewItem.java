package powerwaveinteractive.com.seoulture;

import java.io.Serializable;

/**
 * Created by vincenthanna on 8/26/14.
 */
public class ReviewItem implements Serializable{
    String name;
    String reviewText;
    double rating;

    ReviewItem() {
        name = "";
        reviewText = "";
        rating = 0.0;
    }

    ReviewItem(String name, String review, double rating) {
        this.name = name;
        this.reviewText = review;
        this.rating = rating;
    }
}
