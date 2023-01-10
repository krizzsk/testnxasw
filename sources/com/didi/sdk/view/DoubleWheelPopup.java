package com.didi.sdk.view;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoubleWheelPopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f40488a;

    /* renamed from: b */
    private String f40489b;

    /* renamed from: c */
    private String f40490c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Wheel f40491d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f40492e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f40493f;

    /* renamed from: g */
    private List<String> f40494g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<String> f40495h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public HashMap<String, List<String>> f40496i;

    /* renamed from: j */
    private int f40497j = -1;

    /* renamed from: k */
    private int f40498k = -1;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View.OnClickListener f40499l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View.OnClickListener f40500m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public OnDoubleWheelSelectListener f40501n;

    /* renamed from: o */
    private SimpleWheelPopup.SimpleWheelAdapter f40502o;

    public interface OnDoubleWheelSelectListener {
        void onSelect(int i, Object obj, int i2, Object obj2);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.double_wheel_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Wheel wheel = (Wheel) this.mRootView.findViewById(R.id.wheel_first);
        this.f40491d = wheel;
        wheel.setData(this.f40494g);
        this.f40492e = (Wheel) this.mRootView.findViewById(R.id.wheel_second);
        m30427a();
        m30429b();
        m30431c();
    }

    /* renamed from: a */
    private void m30427a() {
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f40488a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f40489b);
        if (!TextUtils.isEmpty(this.f40489b) && !TextUtils.isEmpty(this.f40490c)) {
            this.f40488a.setMessage(this.f40490c);
        }
        this.f40488a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DoubleWheelPopup.this.f40500m != null) {
                    DoubleWheelPopup.this.f40500m.onClick(view);
                }
                DoubleWheelPopup.this.dismiss();
            }
        });
        this.f40488a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DoubleWheelPopup.this.f40499l != null) {
                    DoubleWheelPopup.this.f40499l.onClick(view);
                }
                if (DoubleWheelPopup.this.f40501n != null) {
                    int selectedIndex = DoubleWheelPopup.this.f40491d.getSelectedIndex();
                    int selectedIndex2 = DoubleWheelPopup.this.f40492e.getSelectedIndex();
                    if (DoubleWheelPopup.this.f40493f != null) {
                        if (DoubleWheelPopup.this.f40495h != null) {
                            DoubleWheelPopup.this.f40501n.onSelect(selectedIndex, DoubleWheelPopup.this.f40493f.get(selectedIndex), selectedIndex2, DoubleWheelPopup.this.f40495h.get(selectedIndex2));
                        } else {
                            DoubleWheelPopup.this.f40501n.onSelect(selectedIndex, DoubleWheelPopup.this.f40493f.get(selectedIndex), 0, (Object) null);
                        }
                    }
                }
                DoubleWheelPopup.this.dismiss();
            }
        });
    }

    /* renamed from: b */
    private void m30429b() {
        this.f40491d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                List list = (List) DoubleWheelPopup.this.f40496i.get((String) DoubleWheelPopup.this.f40493f.get(i));
                if (list == null) {
                    list = new ArrayList();
                    list.add("");
                }
                DoubleWheelPopup.this.f40492e.setData(list);
                List unused = DoubleWheelPopup.this.f40495h = list;
                DoubleWheelPopup.this.f40491d.setContentDescription(DoubleWheelPopup.this.getFirstWheelSelectedValue());
                DoubleWheelPopup.this.f40491d.sendAccessibilityEvent(128);
            }
        });
        List<String> list = this.f40496i.get(this.f40493f.get(0));
        this.f40492e.setData(list);
        this.f40495h = list;
        this.f40492e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                DoubleWheelPopup.this.f40492e.setContentDescription(DoubleWheelPopup.this.getSecondWheelSelectedValue());
                DoubleWheelPopup.this.f40492e.sendAccessibilityEvent(128);
            }
        });
    }

    public void setTitle(String str) {
        this.f40489b = str;
    }

    public void setSubTitle(String str) {
        this.f40490c = str;
    }

    public void setFirstWheelData(SimpleWheelPopup.SimpleWheelAdapter simpleWheelAdapter) {
        this.f40502o = simpleWheelAdapter;
        int count = simpleWheelAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            arrayList.add(i, simpleWheelAdapter.getItemForUI(i));
        }
        setFirstWheelData((List<String>) arrayList);
    }

    public void setFirstWheelData(List<String> list) {
        this.f40493f = list;
        this.f40494g = list;
    }

    public void joinData(HashMap<String, List<String>> hashMap) {
        this.f40496i = hashMap;
    }

    public void setFirstWheelData(List<String> list, String str, String str2) {
        this.f40493f = list;
        if (TextUtil.isEmpty(str) && TextUtil.isEmpty(str2)) {
            this.f40494g = list;
        } else if (list != null) {
            this.f40494g = new ArrayList(list.size());
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> list2 = this.f40494g;
                list2.add(i, str + list.get(i) + str2);
            }
        }
    }

    public void setFirstWheelLastSelected(int i) {
        this.f40497j = i;
    }

    public void setSecondWheelLastSelected(int i) {
        this.f40498k = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f40499l = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f40500m = onClickListener;
    }

    public void setOnSelectListener(OnDoubleWheelSelectListener onDoubleWheelSelectListener) {
        this.f40501n = onDoubleWheelSelectListener;
    }

    public String getFirstWheelSelectedValue() {
        return this.f40493f.get(getFirstWheelSelectedIndex());
    }

    public String getSecondWheelSelectedValue() {
        List<String> list = this.f40495h;
        if (list == null) {
            return "";
        }
        return list.get(getSecondWheelSelectedIndex());
    }

    public int getFirstWheelSelectedIndex() {
        return this.f40491d.getSelectedIndex();
    }

    public int getSecondWheelSelectedIndex() {
        return this.f40492e.getSelectedIndex();
    }

    /* renamed from: c */
    private void m30431c() {
        int i;
        int i2;
        List<String> list = this.f40493f;
        if (list != null && (i2 = this.f40497j) >= 0 && i2 < list.size()) {
            this.f40491d.setSelectedIndex(this.f40497j);
            List<String> list2 = this.f40496i.get(this.f40493f.get(this.f40497j));
            this.f40495h = list2;
            this.f40492e.setData(list2);
        }
        List<String> list3 = this.f40495h;
        if (list3 != null && (i = this.f40498k) >= 0 && i < list3.size()) {
            this.f40492e.setSelectedIndex(this.f40498k);
        }
    }
}
