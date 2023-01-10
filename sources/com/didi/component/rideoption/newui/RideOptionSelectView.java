package com.didi.component.rideoption.newui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.sdk.view.popup.PopupSelectRecyclerView;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.List;

public class RideOptionSelectView extends FrameLayout {

    /* renamed from: a */
    private Context f17177a;

    /* renamed from: b */
    private TextView f17178b;

    /* renamed from: c */
    private PopupSelectRecyclerView f17179c;

    /* renamed from: d */
    private List<PopupSelectModel> f17180d;

    /* renamed from: e */
    private RideOptionNewUiAdapter f17181e;

    /* renamed from: f */
    private PopupSelectView.OnPopupSelectListClickListener f17182f;

    public RideOptionSelectView(Context context) {
        super(context);
        this.f17177a = context;
        m14393a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17177a = context;
        m14393a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17177a = context;
        m14393a();
    }

    /* renamed from: a */
    private void m14393a() {
        View inflate = LayoutInflater.from(this.f17177a).inflate(R.layout.global_ride_option_new_ui_list_layout, (ViewGroup) null);
        this.f17179c = (PopupSelectRecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f17178b = (TextView) inflate.findViewById(R.id.title);
        addView(inflate);
        this.f17181e = new RideOptionNewUiAdapter(this.f17177a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f17177a);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.f17179c.setLayoutManager(linearLayoutManager);
        this.f17179c.setAdapter(this.f17181e);
    }

    public void setTitle(String str) {
        TextView textView = this.f17178b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.f17178b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f17180d = list;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f17181e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.updateItems(list);
        }
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f17182f = onPopupSelectListClickListener;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f17181e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
        }
    }

    public void setSelectedPosition(int i) {
        List<PopupSelectModel> list;
        if (this.f17181e != null && (list = this.f17180d) != null && list.size() > i) {
            this.f17181e.setSelectItem(this.f17180d.get(i).f40884id);
        }
    }

    public void setSelectedId(String str) {
        if (this.f17181e != null && this.f17180d != null && !TextUtils.isEmpty(str)) {
            this.f17181e.setSelectItem(str);
        }
    }

    public void setMaxHeight(int i) {
        PopupSelectRecyclerView popupSelectRecyclerView = this.f17179c;
        if (popupSelectRecyclerView != null) {
            popupSelectRecyclerView.setMaxHeight(i);
        }
    }

    public void notifyDataSetChanged() {
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f17181e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.notifyDataSetChanged();
        }
    }
}
