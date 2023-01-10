package com.didiglobal.comp.carmodellist.optionarea.rideoption;

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
    private Context f52399a;

    /* renamed from: b */
    private TextView f52400b;

    /* renamed from: c */
    private PopupSelectRecyclerView f52401c;

    /* renamed from: d */
    private List<PopupSelectModel> f52402d;

    /* renamed from: e */
    private RideOptionNewUiAdapter f52403e;

    /* renamed from: f */
    private PopupSelectView.OnPopupSelectListClickListener f52404f;

    public RideOptionSelectView(Context context) {
        super(context);
        this.f52399a = context;
        m39376a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52399a = context;
        m39376a();
    }

    public RideOptionSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f52399a = context;
        m39376a();
    }

    /* renamed from: a */
    private void m39376a() {
        View inflate = LayoutInflater.from(this.f52399a).inflate(R.layout.car_model_ride_option_list_layout, (ViewGroup) null);
        this.f52401c = (PopupSelectRecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f52400b = (TextView) inflate.findViewById(R.id.title);
        addView(inflate);
        this.f52403e = new RideOptionNewUiAdapter(this.f52399a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f52399a);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.f52401c.setLayoutManager(linearLayoutManager);
        this.f52401c.setAdapter(this.f52403e);
    }

    public void setTitle(String str) {
        TextView textView = this.f52400b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.f52400b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f52402d = list;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f52403e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.updateItems(list);
        }
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f52404f = onPopupSelectListClickListener;
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f52403e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
        }
    }

    public void setSelectedPosition(int i) {
        List<PopupSelectModel> list;
        if (this.f52403e != null && (list = this.f52402d) != null && list.size() > i) {
            this.f52403e.setSelectItem(this.f52402d.get(i).f40884id);
        }
    }

    public void setSelectedId(String str) {
        if (this.f52403e != null && this.f52402d != null && !TextUtils.isEmpty(str)) {
            this.f52403e.setSelectItem(str);
        }
    }

    public void setMaxHeight(int i) {
        PopupSelectRecyclerView popupSelectRecyclerView = this.f52401c;
        if (popupSelectRecyclerView != null) {
            popupSelectRecyclerView.setMaxHeight(i);
        }
    }

    public void notifyDataSetChanged() {
        RideOptionNewUiAdapter rideOptionNewUiAdapter = this.f52403e;
        if (rideOptionNewUiAdapter != null) {
            rideOptionNewUiAdapter.notifyDataSetChanged();
        }
    }
}
