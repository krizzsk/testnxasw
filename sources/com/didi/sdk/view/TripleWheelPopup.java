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

public class TripleWheelPopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f40622a;

    /* renamed from: b */
    private String f40623b;

    /* renamed from: c */
    private String f40624c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Wheel f40625d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f40626e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Wheel f40627f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<String> f40628g;

    /* renamed from: h */
    private List<String> f40629h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public HashMap<String, List<String>> f40630i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<String> f40631j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<String> f40632k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public HashMap<String, List<String>> f40633l;

    /* renamed from: m */
    private int f40634m = -1;

    /* renamed from: n */
    private int f40635n = -1;

    /* renamed from: o */
    private int f40636o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View.OnClickListener f40637p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public View.OnClickListener f40638q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnTripleWheelSelectListener f40639r;

    /* renamed from: s */
    private SimpleWheelPopup.SimpleWheelAdapter f40640s;

    public interface OnTripleWheelSelectListener {
        void onSelect(int i, Object obj, int i2, Object obj2, int i3, Object obj3);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.triple_wheel_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        Wheel wheel = (Wheel) this.mRootView.findViewById(R.id.wheel_first);
        this.f40625d = wheel;
        wheel.setData(this.f40629h);
        this.f40626e = (Wheel) this.mRootView.findViewById(R.id.wheel_second);
        this.f40627f = (Wheel) this.mRootView.findViewById(R.id.wheel_third);
        m30501a();
        m30504b();
    }

    /* renamed from: a */
    private void m30501a() {
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f40622a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f40623b);
        if (!TextUtils.isEmpty(this.f40623b)) {
            this.f40622a.setMessage(this.f40624c);
        }
        this.f40622a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TripleWheelPopup.this.f40638q != null) {
                    TripleWheelPopup.this.f40638q.onClick(view);
                }
                TripleWheelPopup.this.dismiss();
            }
        });
        this.f40622a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TripleWheelPopup.this.f40637p != null) {
                    TripleWheelPopup.this.f40637p.onClick(view);
                }
                if (TripleWheelPopup.this.f40639r != null) {
                    int selectedIndex = TripleWheelPopup.this.f40625d.getSelectedIndex();
                    int selectedIndex2 = TripleWheelPopup.this.f40626e.getSelectedIndex();
                    int selectedIndex3 = TripleWheelPopup.this.f40627f.getSelectedIndex();
                    String str = (String) TripleWheelPopup.this.f40628g.get(selectedIndex);
                    String str2 = (String) TripleWheelPopup.this.f40631j.get(selectedIndex2);
                    String str3 = (String) TripleWheelPopup.this.f40632k.get(selectedIndex3);
                    if (TripleWheelPopup.this.f40628g != null) {
                        if (TripleWheelPopup.this.f40631j == null) {
                            TripleWheelPopup.this.f40639r.onSelect(selectedIndex, str, 0, "", 0, "");
                        } else if (TripleWheelPopup.this.f40632k == null) {
                            TripleWheelPopup.this.f40639r.onSelect(selectedIndex, str, selectedIndex2, str2, 0, "");
                        } else {
                            TripleWheelPopup.this.f40639r.onSelect(selectedIndex, str, selectedIndex2, str2, selectedIndex3, str3);
                        }
                    }
                }
                TripleWheelPopup.this.dismiss();
            }
        });
    }

    /* renamed from: b */
    private void m30504b() {
        List<String> list = this.f40628g;
        if (list != null) {
            String str = list.get(0);
            HashMap<String, List<String>> hashMap = this.f40630i;
            if (hashMap != null) {
                List<String> list2 = hashMap.get(str);
                this.f40626e.setData(list2);
                this.f40631j = list2;
                if (this.f40633l != null) {
                    List<String> list3 = this.f40633l.get(list2.get(0));
                    this.f40632k = list3;
                    this.f40627f.setData(list3);
                }
            }
        }
        this.f40625d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                String str = (String) TripleWheelPopup.this.f40628g.get(i);
                if (TripleWheelPopup.this.f40630i != null) {
                    List list = (List) TripleWheelPopup.this.f40630i.get(str);
                    if (list == null) {
                        list = new ArrayList();
                        list.add("");
                    }
                    TripleWheelPopup.this.f40626e.setData(list);
                    List unused = TripleWheelPopup.this.f40631j = list;
                    if (TripleWheelPopup.this.f40633l != null) {
                        List list2 = (List) TripleWheelPopup.this.f40633l.get((String) list.get(0));
                        if (list2 == null) {
                            list2 = new ArrayList();
                            list2.add("");
                        }
                        TripleWheelPopup.this.f40627f.setData(list2);
                    }
                }
                TripleWheelPopup.this.f40625d.setContentDescription(TripleWheelPopup.this.getFirstWheelSelectedValue());
                TripleWheelPopup.this.f40625d.sendAccessibilityEvent(128);
            }
        });
        this.f40626e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (!(TripleWheelPopup.this.f40631j == null || TripleWheelPopup.this.f40633l == null)) {
                    TripleWheelPopup tripleWheelPopup = TripleWheelPopup.this;
                    List unused = tripleWheelPopup.f40632k = (List) tripleWheelPopup.f40633l.get((String) TripleWheelPopup.this.f40631j.get(i));
                    if (TripleWheelPopup.this.f40632k == null) {
                        List unused2 = TripleWheelPopup.this.f40632k = new ArrayList();
                        TripleWheelPopup.this.f40632k.add("");
                    }
                    TripleWheelPopup.this.f40627f.setData(TripleWheelPopup.this.f40632k);
                }
                TripleWheelPopup.this.f40626e.setContentDescription(TripleWheelPopup.this.getSecondWheelSelectedValue());
                TripleWheelPopup.this.f40626e.sendAccessibilityEvent(128);
            }
        });
        this.f40627f.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                TripleWheelPopup.this.f40627f.setContentDescription(TripleWheelPopup.this.getThirdWheelSelectedValue());
                TripleWheelPopup.this.f40627f.sendAccessibilityEvent(128);
            }
        });
        m30506c();
    }

    public void setTitle(String str) {
        this.f40623b = str;
    }

    public void setSubTitle(String str) {
        this.f40624c = str;
    }

    public void setFirstWheelData(SimpleWheelPopup.SimpleWheelAdapter simpleWheelAdapter) {
        this.f40640s = simpleWheelAdapter;
        int count = simpleWheelAdapter.getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            arrayList.add(i, simpleWheelAdapter.getItemForUI(i));
        }
        setFirstWheelData((List<String>) arrayList);
    }

    public void setFirstWheelData(List<String> list) {
        this.f40628g = list;
        this.f40629h = list;
    }

    public void joinDataToSecondWheel(HashMap<String, List<String>> hashMap) {
        this.f40630i = hashMap;
    }

    public void joinDataToThirdWheel(HashMap<String, List<String>> hashMap) {
        this.f40633l = hashMap;
    }

    public void setFirstWheelData(List<String> list, String str, String str2) {
        this.f40628g = list;
        if (TextUtil.isEmpty(str) && TextUtil.isEmpty(str2)) {
            this.f40629h = list;
        } else if (list != null) {
            this.f40629h = new ArrayList(list.size());
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> list2 = this.f40629h;
                list2.add(i, str + list.get(i) + str2);
            }
        }
    }

    public void setFirstWheelLastSelected(int i) {
        this.f40634m = i;
    }

    public void setSecondWheelLastSelected(int i) {
        this.f40635n = i;
    }

    public void setThirdWheelLastSelected(int i) {
        this.f40636o = i;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f40637p = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f40638q = onClickListener;
    }

    public void setOnSelectListener(OnTripleWheelSelectListener onTripleWheelSelectListener) {
        this.f40639r = onTripleWheelSelectListener;
    }

    public int getFirstWheelSelectedIndex() {
        return this.f40625d.getSelectedIndex();
    }

    public String getFirstWheelSelectedValue() {
        return this.f40628g.get(getFirstWheelSelectedIndex());
    }

    public int getSecondWheelSelectedIndex() {
        return this.f40626e.getSelectedIndex();
    }

    public String getSecondWheelSelectedValue() {
        return this.f40631j.get(getSecondWheelSelectedIndex());
    }

    public int getThirdWheelSelectedIndex() {
        return this.f40627f.getSelectedIndex();
    }

    public String getThirdWheelSelectedValue() {
        return this.f40632k.get(getThirdWheelSelectedIndex());
    }

    /* renamed from: c */
    private void m30506c() {
        int i;
        int i2;
        int i3;
        List<String> list = this.f40628g;
        if (list != null && (i3 = this.f40634m) >= 0 && i3 < list.size()) {
            this.f40625d.setSelectedIndex(this.f40634m);
            List<String> list2 = this.f40630i.get(this.f40628g.get(this.f40634m));
            this.f40631j = list2;
            this.f40626e.setData(list2);
        }
        List<String> list3 = this.f40631j;
        if (list3 != null && (i2 = this.f40635n) >= 0 && i2 < list3.size()) {
            this.f40626e.setSelectedIndex(this.f40635n);
            List<String> list4 = this.f40633l.get(this.f40631j.get(this.f40635n));
            this.f40632k = list4;
            this.f40627f.setData(list4);
        }
        List<String> list5 = this.f40632k;
        if (list5 != null && (i = this.f40636o) >= 0 && i < list5.size()) {
            this.f40627f.setSelectedIndex(this.f40636o);
        }
    }
}
