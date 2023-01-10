package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {

    /* renamed from: a */
    private float f54901a = 2.5f;
    protected float mMaxSize;
    protected boolean mNormalizeSize = true;

    public BubbleDataSet(List<BubbleEntry> list, String str) {
        super(list, str);
    }

    public void setHighlightCircleWidth(float f) {
        this.f54901a = Utils.convertDpToPixel(f);
    }

    public float getHighlightCircleWidth() {
        return this.f54901a;
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(BubbleEntry bubbleEntry) {
        super.calcMinMax(bubbleEntry);
        float size = bubbleEntry.getSize();
        if (size > this.mMaxSize) {
            this.mMaxSize = size;
        }
    }

    public DataSet<BubbleEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((BubbleEntry) this.mValues.get(i)).copy());
        }
        BubbleDataSet bubbleDataSet = new BubbleDataSet(arrayList, getLabel());
        copy(bubbleDataSet);
        return bubbleDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(BubbleDataSet bubbleDataSet) {
        bubbleDataSet.f54901a = this.f54901a;
        bubbleDataSet.mNormalizeSize = this.mNormalizeSize;
    }

    public float getMaxSize() {
        return this.mMaxSize;
    }

    public boolean isNormalizeSizeEnabled() {
        return this.mNormalizeSize;
    }

    public void setNormalizeSizeEnabled(boolean z) {
        this.mNormalizeSize = z;
    }
}
