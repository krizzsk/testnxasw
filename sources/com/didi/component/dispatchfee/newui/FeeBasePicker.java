package com.didi.component.dispatchfee.newui;

import android.view.LayoutInflater;
import com.didi.sdk.view.picker.IPickerData;
import com.didi.sdk.view.picker.IPickerDataInject;
import com.didi.sdk.view.picker.NumberPickerView;
import com.didi.sdk.view.picker.PickerBase;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public abstract class FeeBasePicker<T extends IPickerData> extends PickerBase<T> {

    /* renamed from: a */
    private List<List<T>> f14645a;

    /* renamed from: b */
    private IPickerDataInject<T>[] f14646b;

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        m12141a();
        this.mHasInit = true;
    }

    public void setPickerData(List<List<T>> list) {
        if (this.f14646b == null && this.f14645a == null && list != null) {
            this.f14645a = list;
            this.mColumnCount = list.size();
            this.mCurAllIndex = new int[this.mColumnCount];
        }
    }

    public void setPickerData(IPickerDataInject<T>... iPickerDataInjectArr) {
        if (this.f14645a == null && this.f14646b == null && iPickerDataInjectArr != null) {
            this.f14646b = iPickerDataInjectArr;
            this.mColumnCount = iPickerDataInjectArr.length;
            this.mCurAllIndex = new int[this.mColumnCount];
        }
    }

    /* renamed from: a */
    private void m12141a() {
        if (this.f14645a != null || this.f14646b != null) {
            this.mPickerViews = new NumberPickerView[this.mColumnCount];
            for (final int i = 0; i < this.mColumnCount; i++) {
                this.mPickerViews[i] = (NumberPickerView) LayoutInflater.from(getContext()).inflate(R.layout.global_dispatch_fee_picker_wheel, this.mPickerLayout, false);
                this.mPickerLayout.addView(this.mPickerViews[i]);
                this.mPickerViews[i].setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() {
                    public void onValueChange(NumberPickerView numberPickerView, int i, int i2) {
                        if (FeeBasePicker.this.isAdded()) {
                            int[] a = FeeBasePicker.this.mCurAllIndex;
                            int i3 = i;
                            a[i3] = i2;
                            FeeBasePicker.this.m12142a(i3 + 1);
                            FeeBasePicker feeBasePicker = FeeBasePicker.this;
                            feeBasePicker.onWheelChanged(feeBasePicker.getSelectedData(), FeeBasePicker.this.getSelectedIndex());
                            if (FeeBasePicker.this.mIsResultRealTime) {
                                FeeBasePicker.this.confirmSelectAndCallback();
                            }
                        }
                    }
                });
            }
            applyStyle(this.mStyleInner);
            applyStyle(this.mStyle);
            if (!this.mHasInit) {
                setInitialSelect((T[]) this.mInitialSelect);
                setInitialSelect(this.mInitialIndex);
                setVisibility(this.mVisibility, this.mVisibilityColumns);
            }
            m12147b();
        }
    }

    public void setInitialSelect(T... tArr) {
        if (!this.mHasInit) {
            if (this.f14645a == null && this.f14646b == null) {
                this.mInitialSelect = tArr;
            } else if (tArr != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < Math.min(tArr.length, this.mColumnCount)) {
                    T t = tArr[i];
                    int i2 = -1;
                    IPickerDataInject<T>[] iPickerDataInjectArr = this.f14646b;
                    if (iPickerDataInjectArr != null) {
                        List<T> data = iPickerDataInjectArr[i].getData(arrayList);
                        if (data != null && !data.isEmpty()) {
                            i2 = m12140a(data, t);
                            arrayList.add((IPickerData) (i2 >= 0 ? data.get(i2) : data.get(0)));
                        }
                    } else {
                        i2 = this.f14645a.get(i).indexOf(t);
                    }
                    if (i2 >= 0) {
                        this.mCurAllIndex[i] = i2;
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setInitialSelect(int... iArr) {
        if (!this.mHasInit) {
            if (this.f14645a == null && this.f14646b == null) {
                this.mInitialIndex = iArr;
            } else if (iArr != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < Math.min(iArr.length, this.mColumnCount); i++) {
                    IPickerDataInject<T>[] iPickerDataInjectArr = this.f14646b;
                    if (iPickerDataInjectArr != null) {
                        List<T> data = iPickerDataInjectArr[i].getData(arrayList);
                        if (data != null && iArr[i] >= 0 && iArr[i] < data.size()) {
                            this.mCurAllIndex[i] = iArr[i];
                            arrayList.add(data.get(iArr[i]));
                        } else {
                            return;
                        }
                    } else if (iArr[i] >= 0 && iArr[i] < this.f14645a.get(i).size()) {
                        this.mCurAllIndex[i] = iArr[i];
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m12147b() {
        List<T> list;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mColumnCount; i++) {
            IPickerDataInject<T>[] iPickerDataInjectArr = this.f14646b;
            if (iPickerDataInjectArr != null) {
                list = iPickerDataInjectArr[i].getData(arrayList);
            } else {
                list = this.f14645a.get(i);
            }
            arrayList.add(list.get(this.mCurAllIndex[i]));
            this.mPickerViews[i].refreshByNewDisplayedValues(m12146a(list));
            this.mPickerViews[i].setValue(this.mCurAllIndex[i]);
        }
        onWheelChanged(arrayList, this.mCurAllIndex);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12142a(int i) {
        if (this.f14646b != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(this.f14646b[i2].getData(arrayList).get(this.mCurAllIndex[i2]));
            }
            while (i < this.mColumnCount) {
                this.mCurAllIndex[i] = 0;
                List<T> data = this.f14646b[i].getData(arrayList);
                this.mPickerViews[i].refreshByNewDisplayedValues(m12146a(data));
                this.mPickerViews[i].setValue(this.mCurAllIndex[i]);
                arrayList.add(data.get(this.mCurAllIndex[i]));
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<T> getSelectedData() {
        List<T> list;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mColumnCount; i++) {
            IPickerDataInject<T>[] iPickerDataInjectArr = this.f14646b;
            if (iPickerDataInjectArr != null) {
                list = iPickerDataInjectArr[i].getData(arrayList);
            } else {
                list = this.f14645a.get(i);
            }
            arrayList.add(list.get(this.mCurAllIndex[i]));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int[] getSelectedIndex() {
        return this.mCurAllIndex;
    }

    /* renamed from: a */
    private String[] m12146a(List<T> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = ((IPickerData) list.get(i)).getSimpleData();
        }
        return strArr;
    }

    /* renamed from: a */
    private int m12140a(List<T> list, T t) {
        for (int i = 0; i < list.size(); i++) {
            if (((IPickerData) list.get(i)).getSimpleData().equals(t.getSimpleData())) {
                return i;
            }
        }
        return -1;
    }
}
