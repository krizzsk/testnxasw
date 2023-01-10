package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {

    /* renamed from: a */
    private float f54932a = 0.0f;

    /* renamed from: b */
    private boolean f54933b;

    /* renamed from: c */
    private float f54934c = 18.0f;

    /* renamed from: d */
    private ValuePosition f54935d = ValuePosition.INSIDE_SLICE;

    /* renamed from: e */
    private ValuePosition f54936e = ValuePosition.INSIDE_SLICE;

    /* renamed from: f */
    private boolean f54937f = false;

    /* renamed from: g */
    private int f54938g = -16777216;

    /* renamed from: h */
    private float f54939h = 1.0f;

    /* renamed from: i */
    private float f54940i = 75.0f;

    /* renamed from: j */
    private float f54941j = 0.3f;

    /* renamed from: k */
    private float f54942k = 0.4f;

    /* renamed from: l */
    private boolean f54943l = true;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
    }

    public DataSet<PieEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((PieEntry) this.mValues.get(i)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        copy(pieDataSet);
        return pieDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(PieDataSet pieDataSet) {
        super.copy(pieDataSet);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(PieEntry pieEntry) {
        if (pieEntry != null) {
            calcMinMaxY(pieEntry);
        }
    }

    public void setSliceSpace(float f) {
        if (f > 20.0f) {
            f = 20.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f54932a = Utils.convertDpToPixel(f);
    }

    public float getSliceSpace() {
        return this.f54932a;
    }

    public void setAutomaticallyDisableSliceSpacing(boolean z) {
        this.f54933b = z;
    }

    public boolean isAutomaticallyDisableSliceSpacingEnabled() {
        return this.f54933b;
    }

    public void setSelectionShift(float f) {
        this.f54934c = Utils.convertDpToPixel(f);
    }

    public float getSelectionShift() {
        return this.f54934c;
    }

    public ValuePosition getXValuePosition() {
        return this.f54935d;
    }

    public void setXValuePosition(ValuePosition valuePosition) {
        this.f54935d = valuePosition;
    }

    public ValuePosition getYValuePosition() {
        return this.f54936e;
    }

    public void setYValuePosition(ValuePosition valuePosition) {
        this.f54936e = valuePosition;
    }

    public boolean isUsingSliceColorAsValueLineColor() {
        return this.f54937f;
    }

    public void setUsingSliceColorAsValueLineColor(boolean z) {
        this.f54937f = z;
    }

    public int getValueLineColor() {
        return this.f54938g;
    }

    public void setValueLineColor(int i) {
        this.f54938g = i;
    }

    public float getValueLineWidth() {
        return this.f54939h;
    }

    public void setValueLineWidth(float f) {
        this.f54939h = f;
    }

    public float getValueLinePart1OffsetPercentage() {
        return this.f54940i;
    }

    public void setValueLinePart1OffsetPercentage(float f) {
        this.f54940i = f;
    }

    public float getValueLinePart1Length() {
        return this.f54941j;
    }

    public void setValueLinePart1Length(float f) {
        this.f54941j = f;
    }

    public float getValueLinePart2Length() {
        return this.f54942k;
    }

    public void setValueLinePart2Length(float f) {
        this.f54942k = f;
    }

    public boolean isValueLineVariableLength() {
        return this.f54943l;
    }

    public void setValueLineVariableLength(boolean z) {
        this.f54943l = z;
    }
}
