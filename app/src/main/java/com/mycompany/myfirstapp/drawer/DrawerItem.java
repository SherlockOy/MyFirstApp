package com.mycompany.myfirstapp.drawer;

/**
 * Created by SherlockOy on 15/2/4.
 */
public class DrawerItem {
    String itemName;
    String title;
    int imgResID;
    int coverPicID;


    boolean isCoverPic;

    // constructor for coverImageItem
    public DrawerItem(boolean isCoverPic, int coverPicID) {
        this.isCoverPic = isCoverPic;
        this.coverPicID = coverPicID;
    }

    // constructor for headerItem
    public DrawerItem(String title) {
        this.title = title;
    }

    // constructor for normalItem
    public DrawerItem(String itemName, int imgResID) {
        this.itemName = itemName;
        this.imgResID = imgResID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCoverPicID() {
        return coverPicID;
    }

    public void setCoverPicID(int coverPicID) {
        this.coverPicID = coverPicID;
    }

    public int getImgResID() {
        return imgResID;
    }

    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }

    public boolean isCoverPic() {
        return isCoverPic;
    }

}
