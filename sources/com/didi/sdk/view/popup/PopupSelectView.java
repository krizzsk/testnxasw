package com.didi.sdk.view.popup;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.List;

public class PopupSelectView extends FrameLayout {

    /* renamed from: a */
    private Context f40876a;

    /* renamed from: b */
    private TextView f40877b;

    /* renamed from: c */
    private TextView f40878c;

    /* renamed from: d */
    private PopupSelectRecyclerView f40879d;

    /* renamed from: e */
    private List<PopupSelectModel> f40880e;

    /* renamed from: f */
    private PopupSelectRecyclerViewAdapter f40881f;

    /* renamed from: g */
    private ImageView f40882g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnPopupSelectListClickListener f40883h;

    public interface OnPopupSelectListClickListener {
        void onCloseButtonClick();

        void onItemClick(int i);
    }

    public PopupSelectView(Context context) {
        super(context);
        this.f40876a = context;
        m30651a();
    }

    public PopupSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40876a = context;
        m30651a();
    }

    public PopupSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40876a = context;
        m30651a();
    }

    /* renamed from: a */
    private void m30651a() {
        LayoutInflater.from(this.f40876a).inflate(R.layout.global_popup_select_view_layout, this);
        this.f40879d = (PopupSelectRecyclerView) findViewById(R.id.recycler_view);
        this.f40877b = (TextView) findViewById(R.id.title);
        this.f40878c = (TextView) findViewById(R.id.content);
        this.f40882g = (ImageView) findViewById(R.id.close_button);
        this.f40881f = new PopupSelectRecyclerViewAdapter(this.f40876a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f40876a);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.f40879d.setLayoutManager(linearLayoutManager);
        this.f40879d.setAdapter(this.f40881f);
        m30652b();
    }

    /* renamed from: b */
    private void m30652b() {
        ImageView imageView = this.f40882g;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (PopupSelectView.this.f40883h != null) {
                        PopupSelectView.this.f40883h.onCloseButtonClick();
                    }
                }
            });
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f40877b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.f40877b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f40878c;
        if (textView != null) {
            textView.setText(str);
            if (TextUtils.isEmpty(str)) {
                this.f40878c.setVisibility(8);
            } else {
                this.f40878c.setVisibility(0);
            }
        }
    }

    public void setContent(int i) {
        TextView textView = this.f40878c;
        if (textView != null) {
            textView.setText(i);
            this.f40878c.setVisibility(0);
        }
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f40880e = list;
        PopupSelectRecyclerViewAdapter popupSelectRecyclerViewAdapter = this.f40881f;
        if (popupSelectRecyclerViewAdapter != null) {
            popupSelectRecyclerViewAdapter.updateItems(list);
        }
    }

    public void setOnPopupSelectListClickListener(OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f40883h = onPopupSelectListClickListener;
        PopupSelectRecyclerViewAdapter popupSelectRecyclerViewAdapter = this.f40881f;
        if (popupSelectRecyclerViewAdapter != null) {
            popupSelectRecyclerViewAdapter.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
        }
    }

    public void setSelectedPosition(int i) {
        List<PopupSelectModel> list;
        if (this.f40881f != null && (list = this.f40880e) != null && list.size() > i) {
            this.f40881f.setSelectItem(this.f40880e.get(i).f40884id);
        }
    }

    public void setSelectedId(String str) {
        if (this.f40881f != null && this.f40880e != null && !TextUtils.isEmpty(str)) {
            this.f40881f.setSelectItem(str);
        }
    }

    public void setMaxHeight(int i) {
        PopupSelectRecyclerView popupSelectRecyclerView = this.f40879d;
        if (popupSelectRecyclerView != null) {
            popupSelectRecyclerView.setMaxHeight(i);
        }
    }

    public void notifyDataSetChanged() {
        PopupSelectRecyclerViewAdapter popupSelectRecyclerViewAdapter = this.f40881f;
        if (popupSelectRecyclerViewAdapter != null) {
            popupSelectRecyclerViewAdapter.notifyDataSetChanged();
        }
    }
}
