package powerwaveinteractive.com.seoulture;

/**
 * 모든 행사 아이템의 베이스가 되는 클래스
 */
public class CultureItem {
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
