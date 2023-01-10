package com.didi.sdk.view.picker;

import android.view.LayoutInflater;
import com.didi.sdk.view.picker.IPickerData;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.view.picker.a */
/* compiled from: PickerBaseFree */
abstract class C14068a<T extends IPickerData> extends PickerBase<T> {

    /* renamed from: a */
    private List<List<T>> f40863a;

    /* renamed from: b */
    private IPickerDataInject<T>[] f40864b;

    C14068a() {
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        m30636a();
        this.mHasInit = true;
    }

    public void setPickerData(List<List<T>> list) {
        if (this.f40864b == null && this.f40863a == null && list != null) {
            this.f40863a = list;
            this.mColumnCount = list.size();
            this.mCurAllIndex = new int[this.mColumnCount];
        }
    }

    public void setPickerData(IPickerDataInject<T>... iPickerDataInjectArr) {
        if (this.f40863a == null && this.f40864b == null && iPickerDataInjectArr != null) {
            this.f40864b = iPickerDataInjectArr;
            this.mColumnCount = iPickerDataInjectArr.length;
            this.mCurAllIndex = new int[this.mColumnCount];
        }
    }

    /* renamed from: a */
    private void m30636a() {
        if (this.f40863a != null || this.f40864b != null) {
            this.mPickerViews = new NumberPickerView[this.mColumnCount];
            for (int i = 0; i < this.mColumnCount; i++) {
                this.mPickerViews[i] = (NumberPickerView) LayoutInflater.from(getContext()).inflate(R.layout.picker_wheel, this.mPickerLayout, false);
                this.mPickerLayout.addView(this.mPickerViews[i]);
                this.mPickerViews[i].setOnValueChangedListener(new PickerBaseFree$1(this, i));
            }
            applyStyle(this.mStyleInner);
            applyStyle(this.mStyle);
            if (!this.mHasInit) {
                setInitialSelect((T[]) this.mInitialSelect);
                setInitialSelect(this.mInitialIndex);
                setVisibility(this.mVisibility, this.mVisibilityColumns);
            }
            m30640b();
        }
    }

    public void setInitialSelect(T... tArr) {
        if (!this.mHasInit) {
            if (this.f40863a == null && this.f40864b == null) {
                this.mInitialSelect = tArr;
            } else if (tArr != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < Math.min(tArr.length, this.mColumnCount)) {
                    T t = tArr[i];
                    int i2 = -1;
                    IPickerDataInject<T>[] iPickerDataInjectArr = this.f40864b;
                    if (iPickerDataInjectArr != null) {
                        List<T> data = iPickerDataInjectArr[i].getData(arrayList);
                        if (data != null && !data.isEmpty()) {
                            i2 = m30635a(data, t);
                            arrayList.add((IPickerData) (i2 >= 0 ? data.get(i2) : data.get(0)));
                        }
                    } else {
                        i2 = this.f40863a.get(i).indexOf(t);
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
            if (this.f40863a == null && this.f40864b == null) {
                this.mInitialIndex = iArr;
            } else if (iArr != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < Math.min(iArr.length, this.mColumnCount); i++) {
                    IPickerDataInject<T>[] iPickerDataInjectArr = this.f40864b;
                    if (iPickerDataInjectArr != null) {
                        List<T> data = iPickerDataInjectArr[i].getData(arrayList);
                        if (data != null && iArr[i] >= 0 && iArr[i] < data.size()) {
                            this.mCurAllIndex[i] = iArr[i];
                            arrayList.add(data.get(iArr[i]));
                        } else {
                            return;
                        }
                    } else if (iArr[i] >= 0 && iArr[i] < this.f40863a.get(i).size()) {
                        this.mCurAllIndex[i] = iArr[i];
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m30640b() {
        List<T> list;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mColumnCount; i++) {
            IPickerDataInject<T>[] iPickerDataInjectArr = this.f40864b;
            if (iPickerDataInjectArr != null) {
                list = iPickerDataInjectArr[i].getData(arrayList);
            } else {
                list = this.f40863a.get(i);
            }
            arrayList.add(list.get(this.mCurAllIndex[i]));
            this.mPickerViews[i].refreshByNewDisplayedValues(m30639a(list));
            this.mPickerViews[i].setValue(this.mCurAllIndex[i]);
        }
        onWheelChanged(arrayList, this.mCurAllIndex);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30637a(int i) {
        if (this.f40864b != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(this.f40864b[i2].getData(arrayList).get(this.mCurAllIndex[i2]));
            }
            while (i < this.mColumnCount) {
                this.mCurAllIndex[i] = 0;
                List<T> data = this.f40864b[i].getData(arrayList);
                this.mPickerViews[i].refreshByNewDisplayedValues(m30639a(data));
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
            IPickerDataInject<T>[] iPickerDataInjectArr = this.f40864b;
            if (iPickerDataInjectArr != null) {
                list = iPickerDataInjectArr[i].getData(arrayList);
            } else {
                list = this.f40863a.get(i);
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
    private String[] m30639a(List<T> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = ((IPickerData) list.get(i)).getSimpleData();
        }
        return strArr;
    }

    /* renamed from: a */
    private int m30635a(List<T> list, T t) {
        for (int i = 0; i < list.size(); i++) {
            if (((IPickerData) list.get(i)).getSimpleData().equals(t.getSimpleData())) {
                return i;
            }
        }
        return -1;
    }
}
