package id.sch.smktelkom_mlg.privateassignment.xirpl632.privateassignment;

import java.io.Serializable;

public class OfflineListItem implements Serializable {
    public String imageUrl;
    public String head;
    // private String desc;

    public OfflineListItem(String imageUrl, String head) {
        this.imageUrl = imageUrl;
        this.head = head;

    }


//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public String getHead() {
//        return head;
//    }

    // public String getDesc() {
    // return desc;
    //}
}