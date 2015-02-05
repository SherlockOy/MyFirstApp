package com.mycompany.myfirstapp.drawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;

import java.util.List;

/**
 * Created by SherlockOy on 15/2/4.
 */
public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem> {


    Context context;
    List<DrawerItem> drawerItemList;
    int layoutResID;

    public CustomDrawerAdapter(Context context, int layoutResID, List<DrawerItem> drawerItemList) {
        super(context, layoutResID, drawerItemList);
        this.context = context;
        this.drawerItemList = drawerItemList;
        this.layoutResID = layoutResID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrawerItemHolder drawerHolder;
        View view = convertView;

        // first use, check if the convertView is null, you should always check if the convertView is non-null, says the API guide.
        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            drawerHolder = new DrawerItemHolder();
            // to inflate the view
            view = inflater.inflate(layoutResID, parent, false);
            drawerHolder.itemName = (TextView) view.findViewById(R.id.drawer_itemName);
            drawerHolder.title = (TextView) view.findViewById(R.id.drawer_title);
            drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);
            drawerHolder.coverPic = (ImageView) view.findViewById(R.id.drawer_cover_pic);
            drawerHolder.coverLayout = (LinearLayout) view.findViewById(R.id.cover_layout);
            drawerHolder.headerLayout = (LinearLayout) view.findViewById(R.id.header_layout);
            drawerHolder.itemLayout = (LinearLayout) view.findViewById(R.id.item_layout);

            view.setTag(drawerHolder);
        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();
        }

        DrawerItem drawerItem = (DrawerItem) this.drawerItemList.get(position);

        if (drawerItem.isCoverPic()) {

            // to set the item of cover picture
            drawerHolder.headerLayout.setVisibility(LinearLayout.GONE);
            drawerHolder.itemLayout.setVisibility(LinearLayout.GONE);
            drawerHolder.coverLayout.setVisibility(LinearLayout.VISIBLE);
//            drawerHolder.coverPic.setImageDrawable(view.getResources().getDrawable(drawerItem.getCoverPicID()));
            drawerHolder.coverLayout.setBackground(view.getResources().getDrawable(drawerItem.getCoverPicID()));


        } else if (drawerItem.getTitle() != null) {

            // to set the item of header
            drawerHolder.itemLayout.setVisibility(LinearLayout.GONE);
            drawerHolder.coverLayout.setVisibility(LinearLayout.GONE);
            drawerHolder.headerLayout.setVisibility(LinearLayout.VISIBLE);
            drawerHolder.title.setText(drawerItem.getTitle());
        } else {

            // to set the normal items
            drawerHolder.headerLayout.setVisibility(LinearLayout.GONE);
            drawerHolder.coverLayout.setVisibility(LinearLayout.GONE);
            drawerHolder.itemLayout.setVisibility(LinearLayout.VISIBLE);
            drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(drawerItem.getImgResID()));
            drawerHolder.itemName.setText(drawerItem.getItemName());
        }
        return view;
    }

    private static class DrawerItemHolder {
        TextView itemName, title;
        ImageView icon;
        ImageView coverPic;
        LinearLayout coverLayout, headerLayout, itemLayout;
    }
}
