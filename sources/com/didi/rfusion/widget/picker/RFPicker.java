package com.didi.rfusion.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.rfusion.widget.picker.RFPickerView;
import java.util.ArrayList;
import java.util.List;

public class RFPicker extends RFPickerViewGroup {

    /* renamed from: a */
    private final List<RFPickerView> f36373a = new ArrayList();

    /* renamed from: b */
    private OnSelectedValueChangedListener f36374b;

    public interface OnSelectedValueChangedListener {
        void onSelectedItemChanged(List<RFPickerItem> list);
    }

    public RFPicker(Context context) {
        super(context);
    }

    public RFPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPicker(List<RFPickerAdapter<? extends RFPickerItem>> list) {
        clear();
        for (RFPickerAdapter<? extends RFPickerItem> addPicker : list) {
            addPicker(addPicker);
        }
    }

    public void setPicker(RFPickerAdapter<? extends RFPickerItem>... rFPickerAdapterArr) {
        clear();
        for (RFPickerAdapter<? extends RFPickerItem> addPicker : rFPickerAdapterArr) {
            addPicker(addPicker);
        }
    }

    public void addPicker(RFPickerAdapter<? extends RFPickerItem> rFPickerAdapter) {
        addPicker(this.f36373a.size(), rFPickerAdapter);
    }

    public void addPicker(int i, RFPickerAdapter<? extends RFPickerItem> rFPickerAdapter) {
        RFPickerView rFPickerView = new RFPickerView(getContext());
        this.f36373a.add(i, rFPickerView);
        rFPickerView.setAdapter(rFPickerAdapter);
        rFPickerView.setOnSelectedItemChangedListener(new RFPickerView.OnSelectedItemChangedListener() {
            public final void onSelectedItemChanged(RFPickerView rFPickerView, int i, int i2) {
                RFPicker.this.m27410a(rFPickerView, i, i2);
            }
        });
        addPickerView(rFPickerView);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27410a(RFPickerView rFPickerView, int i, int i2) {
        OnSelectedValueChangedListener onSelectedValueChangedListener = this.f36374b;
        if (onSelectedValueChangedListener != null) {
            onSelectedValueChangedListener.onSelectedItemChanged(getSelectedItems());
        }
    }

    public void removePicker(int i) {
        removePickerView(this.f36373a.remove(i));
    }

    public void setSelectedItem(int i, int i2) {
        this.f36373a.get(i).setSelectedItemPosition(i2);
    }

    public void clear() {
        this.f36373a.clear();
        removeAllPickerViews();
    }

    public void setSelectedItems(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            setSelectedItem(i, list.get(i).intValue());
        }
    }

    public List<RFPickerItem> getSelectedItems() {
        ArrayList arrayList = new ArrayList(this.f36373a.size());
        for (RFPickerView selectedItem : this.f36373a) {
            arrayList.add(selectedItem.getSelectedItem(RFPickerItem.class));
        }
        return arrayList;
    }

    public void setOnSelectedValueChangeListener(OnSelectedValueChangedListener onSelectedValueChangedListener) {
        this.f36374b = onSelectedValueChangedListener;
    }
}
