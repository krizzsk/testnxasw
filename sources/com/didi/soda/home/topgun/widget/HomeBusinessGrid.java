package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p128ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo148867d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002J \u0010\u0018\u001a\u00020\u00142\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"J\u0015\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006."}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid;", "Lcom/didi/nova/assembly/ui/flowlayout/NovaFlowLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHomeBusinessGridConfig", "Lcom/didi/soda/home/topgun/widget/HomeBusinessGridConfig;", "addAndMeasureDivider", "content", "", "tag", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "originWidth", "exceptHeight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "removeLastDividerForRow", "setData", "list", "", "Lcom/didi/soda/customer/foundation/rpc/entity/PromptEntity;", "viewWidth", "setDefaultConfig", "setDivider", "divider", "setExactlyHeight", "exactlyHeight", "", "setItemSpace", "itemSpace", "", "(Ljava/lang/Float;)V", "setLineSpace", "lineSpace", "setMaxRow", "maxRow", "setShowDividerIndex", "index", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeBusinessGrid.kt */
public final class HomeBusinessGrid extends NovaFlowLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIVIDER_DEFAULT = "";
    public static final String DIVIDER_DOT = "dot";
    public static final String DIVIDER_SPACE_DOT = "space_and_dot";

    /* renamed from: a */
    private HomeBusinessGridConfig f45592a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessGrid(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessGrid(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        m33877a();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid$Companion;", "", "()V", "DIVIDER_DEFAULT", "", "DIVIDER_DOT", "DIVIDER_SPACE_DOT", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeBusinessGrid.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m33877a() {
        HomeBusinessGridConfig homeBusinessGridConfig = new HomeBusinessGridConfig(1, "", MathKt.roundToInt(getContext().getResources().getDimension(R.dimen.rf_dimen_20)), getContext().getResources().getDimension(R.dimen.rf_dimen_20), 0, false, 16, (DefaultConstructorMarker) null);
        this.f45592a = homeBusinessGridConfig;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        setChildSpacing(homeBusinessGridConfig.getItemSpace());
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f45592a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setRowSpacing(homeBusinessGridConfig2.getLineSpace());
    }

    public final void setMaxRow(int i) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        if (i <= 1) {
            i = 1;
        }
        homeBusinessGridConfig.setMaxRow(i);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f45592a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setMaxRows(homeBusinessGridConfig2.getMaxRow());
    }

    public final void setDivider(String str) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        homeBusinessGridConfig.setDivider(str);
    }

    public final void setExactlyHeight(boolean z) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        homeBusinessGridConfig.setExactlyHeight(z);
    }

    public final void setShowDividerIndex(int i) {
        HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        homeBusinessGridConfig.setShowDividerIndex(i);
    }

    public final void setItemSpace(Float f) {
        int i;
        HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        if (f != null) {
            i = DisplayUtils.dip2px(getContext(), f.floatValue() / ((float) 2));
        } else {
            i = MathKt.roundToInt(getContext().getResources().getDimension(R.dimen.customer_4px));
        }
        homeBusinessGridConfig.setItemSpace(i);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f45592a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setChildSpacing(homeBusinessGridConfig2.getItemSpace());
    }

    public final void setLineSpace(Float f) {
        float f2;
        HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
        HomeBusinessGridConfig homeBusinessGridConfig2 = null;
        if (homeBusinessGridConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig = null;
        }
        if (f != null) {
            f2 = (float) DisplayUtils.dip2px(getContext(), f.floatValue() / ((float) 2));
        } else {
            f2 = getContext().getResources().getDimension(R.dimen.customer_14px);
        }
        homeBusinessGridConfig.setLineSpace(f2);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f45592a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig2 = homeBusinessGridConfig3;
        }
        setRowSpacing(homeBusinessGridConfig2.getLineSpace());
    }

    public final void setData(List<? extends PromptEntity> list, int i) {
        ViewGroup.LayoutParams layoutParams;
        int i2 = i;
        removeAllViews();
        Collection collection = list;
        int i3 = 0;
        if (collection == null || collection.isEmpty()) {
            setVisibility(8);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        for (PromptEntity promptEntity : list) {
            int i6 = i4 + 1;
            if (promptEntity != null) {
                CharSequence charSequence = promptEntity.content;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    IconAndTextView iconAndTextView = new IconAndTextView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    iconAndTextView.setData(promptEntity.icon, promptEntity.content, 1);
                    iconAndTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    HomeBusinessGridConfig homeBusinessGridConfig = this.f45592a;
                    HomeBusinessGridConfig homeBusinessGridConfig2 = null;
                    if (homeBusinessGridConfig == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                        homeBusinessGridConfig = null;
                    }
                    if (!homeBusinessGridConfig.getExactlyHeight() || getMaxRows() != 1) {
                        layoutParams = new ViewGroup.LayoutParams(-2, -2);
                    } else {
                        layoutParams = new ViewGroup.LayoutParams(-2, -1);
                    }
                    if (iconAndTextView.getMeasuredWidth() + i5 + getChildSpacing() >= i2) {
                        int iconWidthAndMargin = (i2 - i5) - iconAndTextView.getIconWidthAndMargin();
                        if (iconAndTextView.hasEnoughSpaceShowContent(iconWidthAndMargin)) {
                            iconAndTextView.setVisibility(0);
                            iconAndTextView.setTextWidth(iconWidthAndMargin);
                            addView(iconAndTextView, layoutParams);
                            z = true;
                        } else {
                            iconAndTextView.setVisibility(8);
                        }
                        if (getMaxRows() <= 1) {
                            break;
                        }
                        i4 = i6;
                        i5 = 0;
                    } else {
                        int measuredWidth = i5 + iconAndTextView.getMeasuredWidth() + getChildSpacing();
                        addView(iconAndTextView, layoutParams);
                        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f45592a;
                        if (homeBusinessGridConfig3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                            homeBusinessGridConfig3 = null;
                        }
                        if (!Intrinsics.areEqual((Object) homeBusinessGridConfig3.getDivider(), (Object) "dot") || i4 == list.size() - 1) {
                            HomeBusinessGridConfig homeBusinessGridConfig4 = this.f45592a;
                            if (homeBusinessGridConfig4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                                homeBusinessGridConfig4 = null;
                            }
                            if (!Intrinsics.areEqual((Object) homeBusinessGridConfig4.getDivider(), (Object) DIVIDER_SPACE_DOT) || i4 == list.size() - 1) {
                                i4 = i6;
                                i5 = measuredWidth;
                                z = true;
                            } else {
                                HomeBusinessGridConfig homeBusinessGridConfig5 = this.f45592a;
                                if (homeBusinessGridConfig5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
                                } else {
                                    homeBusinessGridConfig2 = homeBusinessGridConfig5;
                                }
                                if (homeBusinessGridConfig2.getShowDividerIndex() <= i4) {
                                    i5 = m33876a("·", DIVIDER_SPACE_DOT, layoutParams, measuredWidth, iconAndTextView.getMeasuredHeight());
                                } else {
                                    i5 = m33876a(" ", DIVIDER_SPACE_DOT, layoutParams, measuredWidth, iconAndTextView.getMeasuredHeight());
                                }
                            }
                        } else {
                            i5 = m33876a("·", "dot", layoutParams, measuredWidth, iconAndTextView.getMeasuredHeight());
                        }
                        i4 = i6;
                        z = true;
                    }
                }
            }
            i4 = i6;
        }
        if (z) {
            m33878b();
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    /* renamed from: a */
    private final int m33876a(String str, String str2, ViewGroup.LayoutParams layoutParams, int i, int i2) {
        HomeBusinessGridConfig homeBusinessGridConfig = null;
        View inflate = View.inflate(getContext(), R.layout.customer_layout_home_business_grid_divider, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.customer_custom_business_divider_content);
        HomeBusinessGridConfig homeBusinessGridConfig2 = this.f45592a;
        if (homeBusinessGridConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
            homeBusinessGridConfig2 = null;
        }
        if (homeBusinessGridConfig2.getExactlyHeight() && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
            if (layoutParams3 == null) {
                layoutParams3 = null;
            } else {
                layoutParams3.setMargins(0, 0, 0, 0);
                layoutParams3.height = -2;
                layoutParams3.gravity = 16;
                Unit unit = Unit.INSTANCE;
            }
            textView.setLayoutParams(layoutParams3);
        }
        int measureText = i + ((int) textView.getPaint().measureText(str)) + getChildSpacing();
        textView.setText(str);
        inflate.setTag(str2);
        HomeBusinessGridConfig homeBusinessGridConfig3 = this.f45592a;
        if (homeBusinessGridConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomeBusinessGridConfig");
        } else {
            homeBusinessGridConfig = homeBusinessGridConfig3;
        }
        if (homeBusinessGridConfig.getExactlyHeight()) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        } else {
            layoutParams.height = i2;
        }
        addView(inflate, layoutParams);
        return measureText;
    }

    /* renamed from: b */
    private final void m33878b() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) childAt;
                if (Intrinsics.areEqual(frameLayout.getTag(), (Object) "dot") || Intrinsics.areEqual(frameLayout.getTag(), (Object) DIVIDER_SPACE_DOT)) {
                    frameLayout.setVisibility(8);
                }
            }
        }
    }
}
