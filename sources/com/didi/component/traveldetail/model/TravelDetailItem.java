package com.didi.component.traveldetail.model;

public class TravelDetailItem {
    public static final int ITEM_STATUS_CURRENT = 0;
    public static final int ITEM_STATUS_HISTORY = 1;
    public static final int ITEM_STATUS_NORMAL = 2;
    public static final int ITEM_TYPE_END_POINT = 3;
    public static final int ITEM_TYPE_PICKUP_POINT = 1;
    public static final int ITEM_TYPE_START_POINT = 0;
    public static final int ITEM_TYPE_VIA_POINT = 2;
    public int status;
    public String subTitle;
    public String title;
    public int viewType;
}
