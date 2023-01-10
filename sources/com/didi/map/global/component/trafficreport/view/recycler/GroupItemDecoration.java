package com.didi.map.global.component.trafficreport.view.recycler;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter;
import com.taxis99.R;

public class GroupItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private RecyclerView.Adapter f28766a;

    /* renamed from: b */
    private Drawable f28767b;

    /* renamed from: c */
    private Drawable f28768c;

    /* renamed from: d */
    private Drawable f28769d;

    /* renamed from: e */
    private boolean f28770e = true;

    /* renamed from: f */
    private Drawable f28771f;

    /* renamed from: g */
    private final Rect f28772g = new Rect();

    public GroupItemDecoration(RecyclerView.Adapter adapter) {
        if (adapter instanceof ReportEventAdapter) {
            this.f28766a = (ReportEventAdapter) adapter;
        }
        if (adapter instanceof ReportHistoryAdapter) {
            this.f28766a = (ReportHistoryAdapter) adapter;
        }
        if (adapter instanceof ReportDetailAdapter) {
            this.f28766a = (ReportDetailAdapter) adapter;
        }
    }

    public void setGroupDivider(Drawable drawable) {
        this.f28767b = drawable;
    }

    public void setTitleDivider(Drawable drawable) {
        this.f28768c = drawable;
    }

    public void setChildDivider(Drawable drawable) {
        this.f28769d = drawable;
    }

    public void setFirstDividerEnabled(boolean z) {
        this.f28770e = z;
    }

    public void setRemarkDivider(Drawable drawable) {
        this.f28771f = drawable;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (this.f28770e || viewLayoutPosition != 0) {
            Drawable a = m22391a(viewLayoutPosition);
            if (a != null) {
                rect.top = a.getIntrinsicHeight();
            }
            view.setTag(R.id.item_divider, a);
        }
    }

    /* renamed from: a */
    private Drawable m22391a(int i) {
        return m22392b(i);
    }

    /* renamed from: b */
    private Drawable m22392b(int i) {
        RecyclerView.Adapter adapter = this.f28766a;
        if (adapter instanceof ReportEventAdapter) {
            int i2 = C104311.f28775xf6612b06[((ReportEventAdapter) adapter).getItemType(i).ordinal()];
            if (i2 == 1) {
                return this.f28767b;
            }
            if (i2 == 2 || i2 == 3) {
                return this.f28768c;
            }
            if (i2 == 4 || i2 == 5) {
                return this.f28769d;
            }
            return null;
        } else if (adapter instanceof ReportHistoryAdapter) {
            int itemViewType = ((ReportHistoryAdapter) adapter).getItemViewType(i);
            if (ReportHistoryAdapter.ItemType.getByValue(itemViewType) == null || C104311.f28773x27e03e6f[ReportHistoryAdapter.ItemType.getByValue(itemViewType).ordinal()] != 1) {
                return null;
            }
            return this.f28769d;
        } else if (!(adapter instanceof ReportDetailAdapter)) {
            return null;
        } else {
            int i3 = C104311.f28774x736028e9[((ReportDetailAdapter) adapter).getItemType(i).ordinal()];
            if (i3 == 1) {
                return this.f28767b;
            }
            if (i3 == 2) {
                return this.f28768c;
            }
            if (i3 == 3) {
                return this.f28769d;
            }
            if (i3 != 4) {
                return null;
            }
            return this.f28771f;
        }
    }

    /* renamed from: com.didi.map.global.component.trafficreport.view.recycler.GroupItemDecoration$1 */
    static /* synthetic */ class C104311 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$trafficreport$view$history$ReportHistoryAdapter$ItemType */
        static final /* synthetic */ int[] f28773x27e03e6f;

        /* renamed from: $SwitchMap$com$didi$map$global$component$trafficreport$view$recycler$ReportDetailAdapter$ItemType */
        static final /* synthetic */ int[] f28774x736028e9;

        /* renamed from: $SwitchMap$com$didi$map$global$component$trafficreport$view$recycler$ReportEventAdapter$ItemType */
        static final /* synthetic */ int[] f28775xf6612b06;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        static {
            /*
                com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter$ItemType[] r0 = com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter.ItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28774x736028e9 = r0
                r1 = 1
                com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter$ItemType r2 = com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter.ItemType.GROUP_TITLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f28774x736028e9     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter$ItemType r3 = com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter.ItemType.FIRST_CHILD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f28774x736028e9     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter$ItemType r4 = com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter.ItemType.NOT_FIRST_CHILD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f28774x736028e9     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter$ItemType r5 = com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter.ItemType.REMARK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType[] r4 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f28773x27e03e6f = r4
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType r5 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.VIEW_TYPE_DATA     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter$ItemType[] r4 = com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter.ItemType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f28775xf6612b06 = r4
                com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter$ItemType r5 = com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter.ItemType.GROUP_TITLE     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                int[] r1 = f28775xf6612b06     // Catch:{ NoSuchFieldError -> 0x005f }
                com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter$ItemType r4 = com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter.ItemType.FIRST_CHILD     // Catch:{ NoSuchFieldError -> 0x005f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r0 = f28775xf6612b06     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter.ItemType.ONLY_ONE_CHILD     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = f28775xf6612b06     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter.ItemType.END_CHILD     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = f28775xf6612b06     // Catch:{ NoSuchFieldError -> 0x007e }
                com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter.ItemType.NOT_FIRST_CHILD     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.trafficreport.view.recycler.GroupItemDecoration.C104311.<clinit>():void");
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        if (recyclerView.getLayoutManager() != null) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i = recyclerView.getPaddingLeft();
                i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                i2 = recyclerView.getWidth();
                i = 0;
            }
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.f28772g);
                Object tag = childAt.getTag(R.id.item_divider);
                if (tag != null && (tag instanceof Drawable)) {
                    Drawable drawable = (Drawable) tag;
                    drawable.setBounds(i, this.f28772g.top + Math.round(childAt.getTranslationX()), i2, this.f28772g.top + drawable.getIntrinsicHeight());
                    drawable.draw(canvas);
                }
            }
            canvas.restore();
        }
    }
}
