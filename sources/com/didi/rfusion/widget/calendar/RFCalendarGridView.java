package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFViewUtils;
import com.taxis99.R;
import java.util.Calendar;
import java.util.Iterator;

public final class RFCalendarGridView extends GridView {

    /* renamed from: a */
    private final Calendar f36195a;

    /* renamed from: b */
    private final boolean f36196b;

    /* renamed from: c */
    private final RectF f36197c;

    public RFCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36195a = C12368e.m27295c();
        this.f36197c = new RectF();
        this.f36196b = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public void setSelection(int i) {
        if (i < getAdapter().mo94090a()) {
            super.setSelection(getAdapter().mo94090a());
        } else {
            super.setSelection(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().mo94090a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().mo94090a());
        return true;
    }

    public C12366c getAdapter() {
        return (C12366c) super.getAdapter();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof C12366c) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{RFCalendarGridView.class.getCanonicalName(), C12366c.class.getCanonicalName()}));
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        super.onDraw(canvas);
        C12366c adapter = getAdapter();
        RFDateSelector<?> rFDateSelector = adapter.f36238c;
        RFCalendarStyle rFCalendarStyle = adapter.f36239d;
        Long a = adapter.getItem(adapter.mo94090a());
        Long a2 = adapter.getItem(adapter.mo94094b());
        Iterator<Pair<Long, Long>> it = rFDateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (next.first != null) {
                if (next.second != null) {
                    long longValue = ((Long) next.first).longValue();
                    long longValue2 = ((Long) next.second).longValue();
                    if (!m27237a(a, a2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean isLayoutRtl = RFViewUtils.INSTANCE.isLayoutRtl(this);
                        if (longValue < a.longValue()) {
                            i2 = adapter.mo94090a();
                            if (adapter.mo94098e(i2)) {
                                i = 0;
                            } else if (!isLayoutRtl) {
                                i = getChildAt(i2 - 1).getRight();
                            } else {
                                i = getChildAt(i2 - 1).getLeft();
                            }
                        } else {
                            this.f36195a.setTimeInMillis(longValue);
                            i2 = adapter.mo94096c(this.f36195a.get(5));
                            i = m27235a(getChildAt(i2));
                        }
                        if (longValue2 > a2.longValue()) {
                            i4 = Math.min(adapter.mo94094b(), getChildCount() - 1);
                            if (adapter.mo94099f(i4)) {
                                i3 = getWidth();
                            } else if (!isLayoutRtl) {
                                i3 = getChildAt(i4).getRight();
                            } else {
                                i3 = getChildAt(i4).getLeft();
                            }
                        } else {
                            this.f36195a.setTimeInMillis(longValue2);
                            i4 = adapter.mo94096c(this.f36195a.get(5));
                            i3 = m27235a(getChildAt(i4));
                        }
                        int itemId = (int) adapter.getItemId(i2);
                        int itemId2 = (int) adapter.getItemId(i4);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = getChildAt(numColumns);
                            int top = childAt.getTop() + rFCalendarStyle.getDay().getTopInset();
                            C12366c cVar = adapter;
                            int bottom = childAt.getBottom() - rFCalendarStyle.getDay().getBottomInset();
                            if (!isLayoutRtl) {
                                i6 = numColumns > i2 ? 0 : i;
                                i5 = i4 > numColumns2 ? getWidth() : i3;
                            } else {
                                int i7 = i4 > numColumns2 ? 0 : i3;
                                i5 = numColumns > i2 ? getWidth() : i;
                                i6 = i7;
                            }
                            Iterator<Pair<Long, Long>> it2 = it;
                            float dimens = (float) ((int) RFResUtils.getDimens(R.dimen.rf_dimen_12));
                            this.f36197c.set((float) i6, (float) top, (float) i5, (float) bottom);
                            canvas.drawRoundRect(this.f36197c, dimens, dimens, rFCalendarStyle.getRangeFill());
                            itemId++;
                            a = a;
                            it = it2;
                            adapter = cVar;
                        }
                    }
                }
            }
            Canvas canvas2 = canvas;
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f36196b) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            m27236a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    /* renamed from: a */
    private void m27236a(int i, Rect rect) {
        if (i == 33) {
            setSelection(getAdapter().mo94094b());
        } else if (i == 130) {
            setSelection(getAdapter().mo94090a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    /* renamed from: a */
    private static boolean m27237a(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    /* renamed from: a */
    private static int m27235a(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
