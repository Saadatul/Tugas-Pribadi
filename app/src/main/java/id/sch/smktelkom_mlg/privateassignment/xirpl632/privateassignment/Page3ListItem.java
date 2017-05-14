package id.sch.smktelkom_mlg.privateassignment.xirpl632.privateassignment;

/**
 * Created by -asus- on 5/14/2017.
 */

public class Page3ListItem {

    private String imageUrl;
    private String title;
    private String content;

    public Page3ListItem(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
