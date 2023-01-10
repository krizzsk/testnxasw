package com.didi.addressnew.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.ArrayList;

public class NetErrorView<T> extends FrameLayout {

    /* renamed from: a */
    private View f9509a;

    /* renamed from: b */
    private TextView f9510b;

    /* renamed from: c */
    private TextView f9511c;

    /* renamed from: d */
    private ListView f9512d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f9513e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnSelectAddressListener f9514f;

    /* renamed from: g */
    private ArrayList<EmptyViewItem> f9515g;

    public interface OnSelectAddressListener<T> {
        void onSelect(T t);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public NetErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NetErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9509a = null;
        this.f9510b = null;
        this.f9511c = null;
        this.f9512d = null;
        this.f9513e = null;
        this.f9514f = null;
        this.f9515g = null;
        LayoutInflater.from(context).inflate(R.layout.poi_one_address_view_net_error, this);
        View findViewById = findViewById(R.id.layout_error);
        this.f9509a = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NetErrorView.this.f9513e != null) {
                    NetErrorView.this.f9513e.onClick(view);
                }
            }
        });
        this.f9510b = (TextView) findViewById(R.id.text_error_title);
        this.f9511c = (TextView) findViewById(R.id.retry);
        ListView listView = (ListView) findViewById(R.id.list_error);
        this.f9512d = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick((android.widget.AdapterView) r1, (android.view.View) r2, (int) r3)
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ Exception -> 0x0057 }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.EmptyViewItem r1 = (com.didi.addressnew.widget.EmptyViewItem) r1     // Catch:{ Exception -> 0x0057 }
                    if (r1 == 0) goto L_0x0057
                    int r3 = r1.emptyViewType     // Catch:{ Exception -> 0x0057 }
                    r4 = 2
                    if (r3 != r4) goto L_0x0026
                    com.didi.addressnew.widget.NetErrorView r1 = com.didi.addressnew.widget.NetErrorView.this     // Catch:{ Exception -> 0x0057 }
                    android.view.View$OnClickListener r1 = r1.f9513e     // Catch:{ Exception -> 0x0057 }
                    if (r1 == 0) goto L_0x0057
                    com.didi.addressnew.widget.NetErrorView r1 = com.didi.addressnew.widget.NetErrorView.this     // Catch:{ Exception -> 0x0057 }
                    android.view.View$OnClickListener r1 = r1.f9513e     // Catch:{ Exception -> 0x0057 }
                    r1.onClick(r2)     // Catch:{ Exception -> 0x0057 }
                    goto L_0x0057
                L_0x0026:
                    int r2 = r1.emptyViewType     // Catch:{ Exception -> 0x0057 }
                    r3 = 1
                    if (r2 != r3) goto L_0x003f
                    com.didi.addressnew.widget.NetErrorView r2 = com.didi.addressnew.widget.NetErrorView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.NetErrorView$OnSelectAddressListener r2 = r2.f9514f     // Catch:{ Exception -> 0x0057 }
                    if (r2 == 0) goto L_0x0057
                    com.didi.addressnew.widget.NetErrorView r2 = com.didi.addressnew.widget.NetErrorView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.NetErrorView$OnSelectAddressListener r2 = r2.f9514f     // Catch:{ Exception -> 0x0057 }
                    T r1 = r1.address     // Catch:{ Exception -> 0x0057 }
                    r2.onSelect(r1)     // Catch:{ Exception -> 0x0057 }
                    goto L_0x0057
                L_0x003f:
                    int r2 = r1.emptyViewType     // Catch:{ Exception -> 0x0057 }
                    r3 = 3
                    if (r2 != r3) goto L_0x0057
                    com.didi.addressnew.widget.NetErrorView r2 = com.didi.addressnew.widget.NetErrorView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.NetErrorView$OnSelectAddressListener r2 = r2.f9514f     // Catch:{ Exception -> 0x0057 }
                    if (r2 == 0) goto L_0x0057
                    com.didi.addressnew.widget.NetErrorView r2 = com.didi.addressnew.widget.NetErrorView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.NetErrorView$OnSelectAddressListener r2 = r2.f9514f     // Catch:{ Exception -> 0x0057 }
                    T r1 = r1.address     // Catch:{ Exception -> 0x0057 }
                    r2.onSelect(r1)     // Catch:{ Exception -> 0x0057 }
                L_0x0057:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.widget.NetErrorView.C39342.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
    }

    public void setEmptyClickListener(View.OnClickListener onClickListener) {
        this.f9513e = onClickListener;
    }

    public void setSelectAddressListener(OnSelectAddressListener onSelectAddressListener) {
        this.f9514f = onSelectAddressListener;
    }

    public void showError(CharSequence charSequence) {
        this.f9509a.setVisibility(0);
        this.f9510b.setText(charSequence);
        this.f9512d.setVisibility(8);
    }

    public View getRetryBtn() {
        return this.f9511c;
    }
}
