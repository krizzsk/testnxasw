package com.didi.dimina.container.p065ui.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.didi.dimina.container.p065ui.pickerview.adapter.ArrayWheelAdapter;
import com.didi.dimina.container.p065ui.pickerview.listener.OnOptionsSelectChangeListener;
import com.didi.dimina.container.p065ui.wheelview.listener.OnItemSelectedListener;
import com.didi.dimina.container.p065ui.wheelview.view.WheelView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.WheelOptions */
public class WheelOptions<T> {

    /* renamed from: a */
    private View f19503a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final WheelView f19504b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final WheelView f19505c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WheelView f19506d;

    /* renamed from: e */
    private List<T> f19507e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<List<T>> f19508f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<List<List<T>>> f19509g;

    /* renamed from: h */
    private boolean f19510h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final boolean f19511i;

    /* renamed from: j */
    private OnItemSelectedListener f19512j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnItemSelectedListener f19513k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnOptionsSelectChangeListener f19514l;

    /* renamed from: a */
    private void m16555a() {
    }

    public View getView() {
        return this.f19503a;
    }

    public void setView(View view) {
        this.f19503a = view;
    }

    public WheelOptions(View view, boolean z) {
        this.f19511i = z;
        this.f19503a = view;
        this.f19504b = (WheelView) view.findViewById(R.id.options1);
        this.f19505c = (WheelView) view.findViewById(R.id.options2);
        this.f19506d = (WheelView) view.findViewById(R.id.options3);
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f19507e = list;
        this.f19508f = list2;
        this.f19509g = list3;
        this.f19504b.setAdapter(new ArrayWheelAdapter(list));
        this.f19504b.setCurrentItem(0);
        List<List<T>> list4 = this.f19508f;
        if (list4 != null) {
            this.f19505c.setAdapter(new ArrayWheelAdapter(list4.get(0)));
        }
        WheelView wheelView = this.f19505c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list5 = this.f19509g;
        if (list5 != null) {
            this.f19506d.setAdapter(new ArrayWheelAdapter((List) list5.get(0).get(0)));
        }
        WheelView wheelView2 = this.f19506d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f19504b.setIsOptions(true);
        this.f19505c.setIsOptions(true);
        this.f19506d.setIsOptions(true);
        if (this.f19508f == null) {
            this.f19505c.setVisibility(8);
        } else {
            this.f19505c.setVisibility(0);
        }
        if (this.f19509g == null) {
            this.f19506d.setVisibility(8);
        } else {
            this.f19506d.setVisibility(0);
        }
        this.f19512j = new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                if (WheelOptions.this.f19508f != null) {
                    int min = !WheelOptions.this.f19511i ? Math.min(WheelOptions.this.f19505c.getCurrentItem(), ((List) WheelOptions.this.f19508f.get(i)).size() - 1) : 0;
                    WheelOptions.this.f19505c.setAdapter(new ArrayWheelAdapter((List) WheelOptions.this.f19508f.get(i)));
                    WheelOptions.this.f19505c.setCurrentItem(min);
                    if (WheelOptions.this.f19509g != null) {
                        WheelOptions.this.f19513k.onItemSelected(min);
                    } else if (WheelOptions.this.f19514l != null) {
                        WheelOptions.this.f19514l.onOptionsSelectChanged(i, min, 0);
                    }
                } else if (WheelOptions.this.f19514l != null) {
                    WheelOptions.this.f19514l.onOptionsSelectChanged(WheelOptions.this.f19504b.getCurrentItem(), 0, 0);
                }
            }
        };
        this.f19513k = new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = 0;
                if (WheelOptions.this.f19509g != null) {
                    int min = Math.min(WheelOptions.this.f19504b.getCurrentItem(), WheelOptions.this.f19509g.size() - 1);
                    int min2 = Math.min(i, ((List) WheelOptions.this.f19508f.get(min)).size() - 1);
                    if (!WheelOptions.this.f19511i) {
                        i2 = Math.min(WheelOptions.this.f19506d.getCurrentItem(), ((List) ((List) WheelOptions.this.f19509g.get(min)).get(min2)).size() - 1);
                    }
                    WheelOptions.this.f19506d.setAdapter(new ArrayWheelAdapter((List) ((List) WheelOptions.this.f19509g.get(WheelOptions.this.f19504b.getCurrentItem())).get(min2)));
                    WheelOptions.this.f19506d.setCurrentItem(i2);
                    if (WheelOptions.this.f19514l != null) {
                        WheelOptions.this.f19514l.onOptionsSelectChanged(WheelOptions.this.f19504b.getCurrentItem(), min2, i2);
                    }
                } else if (WheelOptions.this.f19514l != null) {
                    WheelOptions.this.f19514l.onOptionsSelectChanged(WheelOptions.this.f19504b.getCurrentItem(), i, 0);
                }
            }
        };
        if (list != null && this.f19510h) {
            this.f19504b.setOnItemSelectedListener(this.f19512j);
        }
        if (list2 != null && this.f19510h) {
            this.f19505c.setOnItemSelectedListener(this.f19513k);
        }
        if (list3 != null && this.f19510h && this.f19514l != null) {
            this.f19506d.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f19514l.onOptionsSelectChanged(WheelOptions.this.f19504b.getCurrentItem(), WheelOptions.this.f19505c.getCurrentItem(), i);
                }
            });
        }
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.f19504b.setAdapter(new ArrayWheelAdapter(list));
        this.f19504b.setCurrentItem(0);
        if (list2 != null) {
            this.f19505c.setAdapter(new ArrayWheelAdapter(list2));
        }
        WheelView wheelView = this.f19505c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list3 != null) {
            this.f19506d.setAdapter(new ArrayWheelAdapter(list3));
        }
        WheelView wheelView2 = this.f19506d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f19504b.setIsOptions(true);
        this.f19505c.setIsOptions(true);
        this.f19506d.setIsOptions(true);
        if (this.f19514l != null) {
            this.f19504b.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f19514l.onOptionsSelectChanged(i, WheelOptions.this.f19505c.getCurrentItem(), WheelOptions.this.f19506d.getCurrentItem());
                }
            });
        }
        if (list2 == null) {
            this.f19505c.setVisibility(8);
        } else {
            this.f19505c.setVisibility(0);
            if (this.f19514l != null) {
                this.f19505c.setOnItemSelectedListener(new OnItemSelectedListener() {
                    public void onItemSelected(int i) {
                        WheelOptions.this.f19514l.onOptionsSelectChanged(WheelOptions.this.f19504b.getCurrentItem(), i, WheelOptions.this.f19506d.getCurrentItem());
                    }
                });
            }
        }
        if (list3 == null) {
            this.f19506d.setVisibility(8);
            return;
        }
        this.f19506d.setVisibility(0);
        if (this.f19514l != null) {
            this.f19506d.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelOptions.this.f19514l.onOptionsSelectChanged(WheelOptions.this.f19504b.getCurrentItem(), WheelOptions.this.f19505c.getCurrentItem(), i);
                }
            });
        }
    }

    public void setTextContentSize(int i) {
        float f = (float) i;
        this.f19504b.setTextSize(f);
        this.f19505c.setTextSize(f);
        this.f19506d.setTextSize(f);
    }

    public void setLabels(String str, String str2, String str3) {
        if (str != null) {
            this.f19504b.setLabel(str);
        }
        if (str2 != null) {
            this.f19505c.setLabel(str2);
        }
        if (str3 != null) {
            this.f19506d.setLabel(str3);
        }
    }

    public void setTextXOffset(int i, int i2, int i3) {
        this.f19504b.setTextXOffset(i);
        this.f19505c.setTextXOffset(i2);
        this.f19506d.setTextXOffset(i3);
    }

    public void setCyclic(boolean z) {
        this.f19504b.setCyclic(z);
        this.f19505c.setCyclic(z);
        this.f19506d.setCyclic(z);
    }

    public void setTypeface(Typeface typeface) {
        this.f19504b.setTypeface(typeface);
        this.f19505c.setTypeface(typeface);
        this.f19506d.setTypeface(typeface);
    }

    public void setCyclic(boolean z, boolean z2, boolean z3) {
        this.f19504b.setCyclic(z);
        this.f19505c.setCyclic(z2);
        this.f19506d.setCyclic(z3);
    }

    public int[] getCurrentItems() {
        int[] iArr = new int[3];
        int i = 0;
        iArr[0] = this.f19504b.getCurrentItem();
        List<List<T>> list = this.f19508f;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f19505c.getCurrentItem();
        } else {
            iArr[1] = this.f19505c.getCurrentItem() > this.f19508f.get(iArr[0]).size() - 1 ? 0 : this.f19505c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f19509g;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.f19506d.getCurrentItem();
        } else {
            if (this.f19506d.getCurrentItem() <= ((List) this.f19509g.get(iArr[0]).get(iArr[1])).size() - 1) {
                i = this.f19506d.getCurrentItem();
            }
            iArr[2] = i;
        }
        return iArr;
    }

    public void setCurrentItems(int i, int i2, int i3) {
        if (this.f19510h) {
            m16556a(i, i2, i3);
            return;
        }
        this.f19504b.setCurrentItem(i);
        this.f19505c.setCurrentItem(i2);
        this.f19506d.setCurrentItem(i3);
    }

    /* renamed from: a */
    private void m16556a(int i, int i2, int i3) {
        if (this.f19507e != null) {
            this.f19504b.setCurrentItem(i);
        }
        List<List<T>> list = this.f19508f;
        if (list != null) {
            this.f19505c.setAdapter(new ArrayWheelAdapter(list.get(i)));
            this.f19505c.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f19509g;
        if (list2 != null) {
            this.f19506d.setAdapter(new ArrayWheelAdapter((List) list2.get(i).get(i2)));
            this.f19506d.setCurrentItem(i3);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.f19504b.setLineSpacingMultiplier(f);
        this.f19505c.setLineSpacingMultiplier(f);
        this.f19506d.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.f19504b.setDividerColor(i);
        this.f19505c.setDividerColor(i);
        this.f19506d.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.f19504b.setDividerType(dividerType);
        this.f19505c.setDividerType(dividerType);
        this.f19506d.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.f19504b.setTextColorCenter(i);
        this.f19505c.setTextColorCenter(i);
        this.f19506d.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.f19504b.setTextColorOut(i);
        this.f19505c.setTextColorOut(i);
        this.f19506d.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.f19504b.isCenterLabel(z);
        this.f19505c.isCenterLabel(z);
        this.f19506d.isCenterLabel(z);
    }

    public void setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f19514l = onOptionsSelectChangeListener;
    }

    public void setLinkage(boolean z) {
        this.f19510h = z;
    }

    public void setItemsVisible(int i) {
        this.f19504b.setItemsVisibleCount(i);
        this.f19505c.setItemsVisibleCount(i);
        this.f19506d.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.f19504b.setAlphaGradient(z);
        this.f19505c.setAlphaGradient(z);
        this.f19506d.setAlphaGradient(z);
    }
}
