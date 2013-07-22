package com.deviceinfoapp.viewable;

import com.deviceinfoapp.R;

/**
 * Created by Jake on 7/17/13.
 */
public class DrawerItem extends AbsItem1 {

    public DrawerItem(CharSequence text) {
        super(text, R.layout.drawer_list_item);
    }

    @Override
    public int getViewType() {
        return Item.TYPE_DRAWER_ITEM;
    }
}
