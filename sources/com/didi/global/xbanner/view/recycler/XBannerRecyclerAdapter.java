package com.didi.global.xbanner.view.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.xbanner.utils.CollectionsUtils;
import com.didi.global.xbanner.utils.DisplayUtils;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class XBannerRecyclerAdapter extends RecyclerView.Adapter<XBannerBaseHolder> {
    public static final int TYPE_DIY = 2;
    public static final int TYPE_TEMPLATE = 0;
    public static final int TYPE_XML = 1;

    /* renamed from: a */
    private static final float f24877a = 0.85f;

    /* renamed from: b */
    private List<XBannerItemBean> f24878b;

    /* renamed from: c */
    private Context f24879c;

    public XBannerRecyclerAdapter(List<XBannerItemBean> list, Context context) {
        this.f24878b = list;
        this.f24879c = context;
    }

    public XBannerBaseHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new XBannerBaseHolder(LayoutInflater.from(this.f24879c).inflate(R.layout.xbanner_normal_adapter_item, viewGroup, false), this);
    }

    public void onBindViewHolder(XBannerBaseHolder xBannerBaseHolder, int i) {
        if (this.f24879c != null && xBannerBaseHolder != null && !CollectionsUtils.isEmptyList(this.f24878b)) {
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            if (getItemCount() == 1) {
                layoutParams.width = XBannerUtil.getFullItemWidthWithoutMargin(this.f24879c);
                layoutParams.height = XBannerUtil.getDefaultItemHeight(this.f24879c);
                layoutParams.setMargins(DisplayUtils.dip2px(this.f24879c, 10.0f), 0, DisplayUtils.dip2px(this.f24879c, 10.0f), 0);
                xBannerBaseHolder.itemView.setLayoutParams(layoutParams);
            } else {
                layoutParams.setMargins(DisplayUtils.dip2px(this.f24879c, 10.0f), 0, i == getItemCount() - 1 ? DisplayUtils.dip2px(this.f24879c, 10.0f) : 0, 0);
                layoutParams.width = XBannerUtil.getItemWidth(this.f24879c);
                layoutParams.height = XBannerUtil.getDefaultItemHeight(this.f24879c);
                xBannerBaseHolder.itemView.setLayoutParams(layoutParams);
            }
            xBannerBaseHolder.bindData(this.f24878b.get(i), layoutParams.width);
        }
    }

    public int getItemCount() {
        List<XBannerItemBean> list = this.f24878b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<XBannerItemBean> list) {
        this.f24878b.clear();
        if (list != null) {
            this.f24878b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public List<XBannerItemBean> getData() {
        ArrayList arrayList = new ArrayList();
        List<XBannerItemBean> list = this.f24878b;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public void addData(List<XBannerItemBean> list) {
        this.f24878b.addAll(list);
        notifyDataSetChanged();
    }

    public void removeItem(int i) {
        List<XBannerItemBean> list = this.f24878b;
        if (list != null && list.size() >= i && i >= 0) {
            this.f24878b.remove(i);
            notifyDataSetChanged();
        }
    }

    public void removeItemByCardId(String str) {
        if (this.f24878b != null && !TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                if (i >= this.f24878b.size()) {
                    i = -1;
                    break;
                }
                XBannerItemBean xBannerItemBean = this.f24878b.get(i);
                if (xBannerItemBean != null) {
                    SystemUtils.log(6, "dongxt", "cardid =" + xBannerItemBean.cardId, (Throwable) null, "com.didi.global.xbanner.view.recycler.XBannerRecyclerAdapter", 107);
                }
                if (xBannerItemBean != null && str.equals(xBannerItemBean.cardId)) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                removeItem(i);
            }
        }
    }
}
