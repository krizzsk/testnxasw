package com.didi.beatles.p101im.views.popup;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.popup.IMDeletePopup */
public class IMDeletePopup {

    /* renamed from: d */
    private static final int f12240d = 45;

    /* renamed from: e */
    private static final int f12241e = 60;

    /* renamed from: f */
    private static final int f12242f = 40;

    /* renamed from: a */
    private PopupWindow f12243a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PopupOnClickListener f12244b;

    /* renamed from: c */
    private Context f12245c;

    /* renamed from: com.didi.beatles.im.views.popup.IMDeletePopup$PopupOnClickListener */
    public interface PopupOnClickListener {
        void onClick();
    }

    public IMDeletePopup(Context context) {
        this.f12245c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_delete_popup, (ViewGroup) null);
        this.f12243a = new PopupWindow(inflate, IMViewUtil.dp2px(context, 60.0f), IMViewUtil.dp2px(context, 45.0f));
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMDeletePopup.this.f12244b != null) {
                    IMDeletePopup.this.f12244b.onClick();
                }
                IMDeletePopup.this.dismiss();
            }
        });
        this.f12243a.setOutsideTouchable(true);
        this.f12243a.setBackgroundDrawable(new BitmapDrawable());
    }

    public void dismiss() {
        this.f12243a.dismiss();
    }

    public void show(View view, PopupOnClickListener popupOnClickListener) {
        if (view != null) {
            this.f12244b = popupOnClickListener;
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            this.f12243a.showAtLocation(view, 48, (iArr[0] + (view.getMeasuredWidth() / 2)) - (IMViewUtil.getWindowWidth(this.f12245c) / 2), iArr[1] - IMViewUtil.dp2px(this.f12245c, 40.0f));
        }
    }
}
