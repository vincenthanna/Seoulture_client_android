package powerwaveinteractive.com.seoulture;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 모든 행사 아이템의 베이스가 되는 클래스
 */
public class CultureItem implements Serializable {
    int id;
    String title;
    String description;
    ArrayList<Bitmap> bitmaps;

    CultureItem() {
        bitmaps = new ArrayList<Bitmap>();
        id = 0;
        title = "";
        description = "";
    }

    CultureItem(CultureItem item) {
        this.id = item.id;
        this.title = item.title;
    }

    CultureItem(int id, String title, String desc) {
        bitmaps = new ArrayList<Bitmap>();
        this.id = id;
        this.title = title;
        this.description = desc;
    }

    public int getId() {
        return id;
    }
}
