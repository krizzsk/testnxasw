package com.didi.sdk.view.timepicker;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.List;

@Deprecated
public class TimePickerSinglePopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f40934a;

    /* renamed from: b */
    private TextView f40935b;

    /* renamed from: c */
    private TextView f40936c;

    /* renamed from: d */
    private Wheel f40937d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnTimeSelectedListener f40938e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f40939f;

    /* renamed from: g */
    private String f40940g;

    /* renamed from: h */
    private String f40941h;

    /* renamed from: i */
    private String f40942i;

    /* renamed from: j */
    private String f40943j;

    /* renamed from: k */
    private List<String> f40944k;

    /* renamed from: l */
    private int f40945l = 0;

    public interface OnTimeSelectedListener {
        void onTimeSelected(int i);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.time_picker_data_str;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        m30696a(this.mRootView);
    }

    /* renamed from: a */
    private void m30696a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerSinglePopup.this.dismiss();
            }
        });
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        this.f40934a = commonPopupTitleBar;
        String str = this.f40940g;
        if (str != null) {
            commonPopupTitleBar.setTitle(str);
        }
        if (!TextUtils.isEmpty(this.f40940g) && !TextUtils.isEmpty(this.f40941h)) {
            this.f40934a.setMessage(this.f40941h);
        }
        this.f40934a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TimePickerSinglePopup.this.f40939f != null) {
                    TimePickerSinglePopup.this.f40939f.onClick(view);
                }
                TimePickerSinglePopup.this.dismiss();
            }
        });
        this.f40934a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TimePickerSinglePopup.this.f40938e != null) {
                    TimePickerSinglePopup.this.f40938e.onTimeSelected(TimePickerSinglePopup.this.getSelectIndex());
                }
                TimePickerSinglePopup.this.dismiss();
            }
        });
        this.f40935b = (TextView) view.findViewById(R.id.prefix_tv);
        this.f40936c = (TextView) view.findViewById(R.id.suffix_tv);
        this.f40935b.setText(this.f40942i);
        this.f40936c.setText(this.f40943j);
        Wheel wheel = (Wheel) view.findViewById(R.id.wheel_simple);
        this.f40937d = wheel;
        wheel.setData(this.f40944k);
        this.f40937d.setSelectedIndex(this.f40945l);
        this.f40935b = (TextView) view.findViewById(R.id.prefix_tv);
        this.f40936c = (TextView) view.findViewById(R.id.suffix_tv);
    }

    public void setLeftText(String str) {
        this.f40942i = str;
        TextView textView = this.f40935b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setRightText(String str) {
        this.f40943j = str;
        TextView textView = this.f40936c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.f40934a == null || TextUtils.isEmpty(str)) {
            this.f40940g = str;
        } else {
            this.f40934a.setTitle(str);
        }
    }

    public void setMessage(String str) {
        if (this.f40934a == null || TextUtils.isEmpty(str)) {
            this.f40941h = str;
        } else {
            this.f40934a.setMessage(str);
        }
    }

    public void setData(List<String> list) {
        this.f40944k = list;
        Wheel wheel = this.f40937d;
        if (wheel != null) {
            wheel.setData(list);
        }
    }

    public void setSelectIndex(int i) {
        this.f40945l = i;
        Wheel wheel = this.f40937d;
        if (wheel != null) {
            wheel.setSelectedIndex(i);
        }
    }

    public int getSelectIndex() {
        Wheel wheel = this.f40937d;
        if (wheel != null) {
            return wheel.getSelectedIndex();
        }
        return 0;
    }

    public void setConfirmListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.f40938e = onTimeSelectedListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f40939f = onClickListener;
    }
}
