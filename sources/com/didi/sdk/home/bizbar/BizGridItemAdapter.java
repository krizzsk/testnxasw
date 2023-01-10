package com.didi.sdk.home.bizbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.CarGrop;
import com.taxis99.R;
import java.util.List;

public class BizGridItemAdapter extends BaseAdapter {

    /* renamed from: a */
    BizNavItemMgr f39125a;

    /* renamed from: b */
    List<TopCarGroupWrapper> f39126b;

    public long getItemId(int i) {
        return (long) i;
    }

    public void setData(List<TopCarGroupWrapper> list) {
        this.f39126b = list;
    }

    public int getCount() {
        return this.f39126b.size();
    }

    public Object getItem(int i) {
        return this.f39126b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            viewHolder = new ViewHolder();
            viewHolder.view = new BizNavItemView(viewGroup.getContext(), false);
            view2 = viewHolder.view;
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.f39125a.getList() != null) {
            CarGrop carGrop = this.f39126b.get(i).carGrop;
            LinearLayout linearLayout = (LinearLayout) viewHolder.view.findViewById(R.id.biz_bar_item);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.height = UiUtils.dip2px(viewGroup.getContext(), 98.0f);
            linearLayout.setLayoutParams(layoutParams);
            viewHolder.view.setIcon(carGrop.getGroupIcon());
            viewHolder.view.setIconAlpha(0.7f);
            viewHolder.view.setText(carGrop.getName());
            if (this.f39125a.hasRedPoint(carGrop.getGroupType(), carGrop.getNavTag()) && this.f39125a.isRedPointNeedShow()) {
                viewHolder.view.setRedPoint(this.f39125a.getHotInfo().hotUrl);
            }
        }
        return view2;
    }

    private static class ViewHolder {
        BizNavItemView view;

        private ViewHolder() {
        }
    }
}
