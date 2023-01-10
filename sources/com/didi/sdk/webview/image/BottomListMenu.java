package com.didi.sdk.webview.image;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.WindowUtil;
import com.taxis99.R;

public class BottomListMenu {

    /* renamed from: a */
    private OnDismissListener f41127a;

    /* renamed from: b */
    private Activity f41128b;

    /* renamed from: c */
    private View f41129c;

    /* renamed from: d */
    private PopupWindow f41130d;

    /* renamed from: e */
    private View f41131e;

    /* renamed from: f */
    private TextView f41132f;

    /* renamed from: g */
    private ListView f41133g = ((ListView) this.f41131e.findViewById(R.id.menu_list));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayAdapter<String> f41134h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ListMenuListener f41135i;

    public interface ListMenuListener {
        void onItemSelected(int i, String str);
    }

    public interface OnDismissListener {
        void dismiss();
    }

    public BottomListMenu(Activity activity, View view, String[] strArr) {
        this.f41128b = activity;
        this.f41129c = view;
        View inflate = View.inflate(activity, R.layout.v_bottom_list_menu, (ViewGroup) null);
        this.f41131e = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.cancel_text);
        this.f41132f = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BottomListMenu.this.onCancel();
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.f41128b, R.layout.v_bottom_list_menu_item, strArr);
        this.f41134h = arrayAdapter;
        this.f41133g.setAdapter(arrayAdapter);
        this.f41133g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                BottomListMenu.this.dismiss();
                if (BottomListMenu.this.f41135i != null) {
                    BottomListMenu.this.f41135i.onItemSelected(i, (String) BottomListMenu.this.f41134h.getItem(i));
                }
            }
        });
        this.f41130d = m30863a(this.f41131e);
    }

    /* renamed from: a */
    private PopupWindow m30863a(View view) {
        PopupWindow popupWindow = new PopupWindow(view, WindowUtil.getWindowWidth(view.getContext()), -2, true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        return popupWindow;
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f41130d;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f41130d.dismiss();
        }
    }

    public void showDialog() {
        PopupWindow popupWindow = this.f41130d;
        if (popupWindow != null && !popupWindow.isShowing()) {
            this.f41130d.showAtLocation(this.f41129c, 80, 0, 0);
        }
    }

    public void setListMenuListener(ListMenuListener listMenuListener) {
        this.f41135i = listMenuListener;
    }

    public void onCancel() {
        dismiss();
        OnDismissListener onDismissListener = this.f41127a;
        if (onDismissListener != null) {
            onDismissListener.dismiss();
        }
    }

    public void setDismissListener(OnDismissListener onDismissListener) {
        this.f41127a = onDismissListener;
    }
}
