package com.didi.beatles.p101im.views.popup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.popup.IMSessionDeletePopup */
public class IMSessionDeletePopup {

    /* renamed from: a */
    private ViewGroup f12270a;

    /* renamed from: b */
    private PopupWindow f12271b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PopupOnClickListener f12272c;

    /* renamed from: d */
    private Context f12273d;

    /* renamed from: com.didi.beatles.im.views.popup.IMSessionDeletePopup$PopupOnClickListener */
    public interface PopupOnClickListener {
        void onItemClick(int i);
    }

    /* renamed from: com.didi.beatles.im.views.popup.IMSessionDeletePopup$TextConfig */
    public static abstract class TextConfig {
        public abstract String getContent();

        public abstract int getTextColor();
    }

    public IMSessionDeletePopup(Context context) {
        this.f12273d = context;
        this.f12270a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.im_session_delete_popup, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(this.f12270a, -2, -2);
        this.f12271b = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f12271b.setBackgroundDrawable(new BitmapDrawable());
    }

    public void dismiss() {
        this.f12271b.dismiss();
    }

    public void show(View view, List<TextConfig> list, PopupOnClickListener popupOnClickListener) {
        if (view != null && !list.isEmpty()) {
            this.f12272c = popupOnClickListener;
            this.f12270a.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                this.f12270a.addView(m10485a(list.get(i), i));
                if (i != list.size() - 1) {
                    this.f12270a.addView(m10484a());
                }
            }
            this.f12270a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (iArr[1] < IMViewUtil.getWindowHeight(this.f12273d) / 2) {
                this.f12271b.showAtLocation(view, 0, IMViewUtil.getWindowWidth(this.f12273d) / 2, iArr[1] + (view.getHeight() / 2));
            } else {
                this.f12271b.showAtLocation(view, 0, IMViewUtil.getWindowWidth(this.f12273d) / 2, (iArr[1] - this.f12270a.getMeasuredHeight()) + (view.getHeight() / 2));
            }
        }
    }

    /* renamed from: a */
    private View m10485a(TextConfig textConfig, final int i) {
        TextView textView = new TextView(this.f12273d);
        textView.setLayoutParams(new ViewGroup.LayoutParams(IMViewUtil.dp2px(this.f12273d, 100.0f), IMViewUtil.dp2px(this.f12273d, 45.0f)));
        textView.setText(textConfig.getContent());
        textView.setTextColor(textConfig.getTextColor());
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMSessionDeletePopup.this.f12272c != null) {
                    IMSessionDeletePopup.this.f12272c.onItemClick(i);
                }
                IMSessionDeletePopup.this.dismiss();
            }
        });
        return textView;
    }

    /* renamed from: a */
    private View m10484a() {
        View view = new View(this.f12273d);
        view.setLayoutParams(new ViewGroup.LayoutParams(IMViewUtil.dp2px(this.f12273d, 100.0f), 1));
        view.setBackgroundColor(Color.parseColor("#19000000"));
        return view;
    }
}
