package powerwaveinteractive.com.seoulture;

import java.io.Serializable;

/**
 * 모든 행사 아이템의 베이스가 되는 클래스
 */
public class CultureItem implements Serializable {
    String title;
    String description;

    CultureItem() {
        title = "";
        description = "";
    }

    CultureItem(String title, String desc) {
        this.title = title;
        this.description = desc;
    }
}
