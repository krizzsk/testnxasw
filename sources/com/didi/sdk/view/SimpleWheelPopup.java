package com.didi.sdk.view;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SimpleWheelPopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f40590a;

    /* renamed from: b */
    private String f40591b;

    /* renamed from: c */
    private String f40592c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Wheel f40593d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<String> f40594e;

    /* renamed from: f */
    private List<String> f40595f;

    /* renamed from: g */
    private int f40596g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View.OnClickListener f40597h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f40598i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnSelectListener f40599j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SimpleWheelAdapter f40600k;

    /* renamed from: l */
    private String f40601l;

    /* renamed from: m */
    private String f40602m;

    public interface OnSelectListener {
        void onSelect(int i, Object obj);
    }

    public interface SimpleWheelAdapter {
        int getCount();

        String getItemForUI(int i);

        Object getItemForUse(int i);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.simple_wheel_popup;
    }

    public CommonPopupTitleBar getTitleBar() {
        return this.f40590a;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Wheel wheel = (Wheel) this.mRootView.findViewById(R.id.wheel_simple);
        this.f40593d = wheel;
        wheel.setData(this.f40595f);
        m30479a();
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f40590a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f40591b);
        if (!TextUtils.isEmpty(this.f40592c)) {
            this.f40590a.setMessage(this.f40592c);
        }
        this.f40593d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                SimpleWheelPopup.this.f40593d.setContentDescription(SimpleWheelPopup.this.f40593d.getSelectedValue());
                SimpleWheelPopup.this.f40593d.sendAccessibilityEvent(128);
            }
        });
        this.f40590a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SimpleWheelPopup.this.f40598i != null) {
                    SimpleWheelPopup.this.f40598i.onClick(view);
                }
                SimpleWheelPopup.this.dismiss();
            }
        });
        if (!TextUtil.isEmpty(this.f40601l)) {
            this.f40590a.setLeftText(this.f40601l);
        }
        if (!TextUtil.isEmpty(this.f40602m)) {
            this.f40590a.setRightText(this.f40602m);
        }
        this.f40590a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SimpleWheelPopup.this.f40597h != null) {
                    SimpleWheelPopup.this.f40597h.onClick(view);
                }
                if (SimpleWheelPopup.this.f40599j != null) {
                    int selectedIndex = SimpleWheelPopup.this.f40593d.getSelectedIndex();
                    if (SimpleWheelPopup.this.f40600k != null) {
                        SimpleWheelPopup.this.f40599j.onSelect(selectedIndex, SimpleWheelPopup.this.f40600k.getItemForUse(selectedIndex));
                    } else if (SimpleWheelPopup.this.f40594e != null) {
                        SimpleWheelPopup.this.f40599j.onSelect(selectedIndex, SimpleWheelPopup.this.f40594e.get(selectedIndex));
                    }
                }
                SimpleWheelPopup.this.dismiss();
            }
        });
    }

    public void setLeftText(String str) {
        this.f40601l = str;
    }

    public void setRightText(String str) {
        this.f40602m = str;
    }

    public void setTitle(String str) {
        this.f40591b = str;
    }

    public void setMessage(String str) {
        this.f40592c = str;
    }

    public void setWheelData(SimpleWheelAdapter simpleWheelAdapter) {
        this.f40600k = simpleWheelAdapter;
        int count = simpleWheelAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            arrayList.add(i, simpleWheelAdapter.getItemForUI(i));
        }
        setWheelData((List<String>) arrayList);
    }

    public void setWheelData(List<String> list) {
        this.f40594e = list;
        this.f40595f = list;
    }

    public void setWheelData(List<String> list, String str, String str2) {
        this.f40594e = list;
        if (TextUtil.isEmpty(str) && TextUtil.isEmpty(str2)) {
            this.f40595f = list;
        } else if (list != null) {
            this.f40595f = new ArrayList(list.size());
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> list2 = this.f40595f;
                list2.add(i, str + list.get(i) + str2);
            }
        }
    }

    public void setLastSelected(int i) {
        this.f40596g = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f40597h = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f40598i = onClickListener;
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.f40599j = onSelectListener;
    }

    public String getSelectedValue() {
        return this.f40594e.get(getSelectedIndex());
    }

    public int getSelectedIndex() {
        Wheel wheel = this.f40593d;
        if (wheel != null) {
            return wheel.getSelectedIndex();
        }
        int i = this.f40596g;
        if (i > -1) {
            return i;
        }
        return 0;
    }

    /* renamed from: a */
    private void m30479a() {
        Wheel wheel;
        if (m30480b() > -1 && (wheel = this.f40593d) != null) {
            wheel.setSelectedIndex(this.f40596g);
        }
    }

    /* renamed from: b */
    private int m30480b() {
        int i;
        List<String> list = this.f40594e;
        if (list == null || (i = this.f40596g) < 0 || i >= list.size()) {
            return -1;
        }
        return this.f40596g;
    }
}
