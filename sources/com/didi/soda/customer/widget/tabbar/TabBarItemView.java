package com.didi.soda.customer.widget.tabbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.manager.HomeRocketLaunchAnimManager;
import com.didi.soda.home.manager.TagStorage;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J)\u0010\u001d\u001a\u00020\u00102!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00100\u001fJ\u0012\u0010$\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u001a\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0015H\u0002J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "discountTagView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "gestureDetector", "Landroid/view/GestureDetector;", "iconView", "Landroid/widget/ImageView;", "textView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "topRocketLaunch", "Lcom/airbnb/lottie/LottieAnimationView;", "checkShouldBackToTop", "", "tabBarItemModel", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemModel;", "handleRocketLaunchAnim", "showRocketView", "", "doAnim", "model", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "registerHomeListScrollChangeEvent", "saveClickTimeForDiscountTagView", "setOnDoubleClickListener", "doubleClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "shouldShowTag", "updateDiscountTag", "updateIconWithUrl", "imageUrl", "", "selected", "updateTabBarItem", "updateTextColor", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarItemView.kt */
public final class TabBarItemView extends LinearLayout {

    /* renamed from: a */
    private ImageView f44788a = ((ImageView) findViewById(R.id.customer_tabbar_icon));

    /* renamed from: b */
    private CustomerAppCompatTextView f44789b = ((CustomerAppCompatTextView) findViewById(R.id.customer_tabbar_text));

    /* renamed from: c */
    private RichTextView f44790c = ((RichTextView) findViewById(R.id.customer_tabbar_tag));

    /* renamed from: d */
    private LottieAnimationView f44791d = ((LottieAnimationView) findViewById(R.id.customer_tabbar_top_rocket_launch));

    /* renamed from: e */
    private GestureDetector f44792e;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.customer_widget_tabbar_item_layout, this);
    }

    /* renamed from: a */
    private final void m33218a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ImageView imageView = this.f44788a;
            Drawable drawable = imageView == null ? null : imageView.getDrawable();
            if (CustomerApolloUtil.tabBarPlaceHolderSwitch()) {
                FlyImageLoader.loadImageUnspecified(getContext(), str).diskCacheStrategy(DiskCacheStrategy.DATA).fitCenter().dontAnimate().into(this.f44788a);
            } else {
                FlyImageLoader.loadImageUnspecified(getContext(), str).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(drawable).fitCenter().dontAnimate().into(this.f44788a);
            }
        }
    }

    /* renamed from: a */
    private final void m33217a(TabBarItemModel tabBarItemModel) {
        if (tabBarItemModel.getTabBarItem().getTextColor() == null || tabBarItemModel.getTabBarItem().getTextColorSelected() == null) {
            ColorStateList colorStateList = ResourceHelper.getColorStateList(R.color.customer_selector_tab_item_text_color);
            CustomerAppCompatTextView customerAppCompatTextView = this.f44789b;
            if (customerAppCompatTextView != null) {
                customerAppCompatTextView.setTextColor(colorStateList);
                return;
            }
            return;
        }
        int[][] iArr = {new int[]{16842913}, new int[]{-16842913}};
        Integer textColorSelected = tabBarItemModel.getTabBarItem().getTextColorSelected();
        Intrinsics.checkNotNull(textColorSelected);
        Integer textColor = tabBarItemModel.getTabBarItem().getTextColor();
        Intrinsics.checkNotNull(textColor);
        ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{textColorSelected.intValue(), textColor.intValue()});
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f44789b;
        if (customerAppCompatTextView2 != null) {
            customerAppCompatTextView2.setTextColor(colorStateList2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r2.getMDiscountTag();
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ea A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0104 A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0118  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33220b(com.didi.soda.customer.widget.tabbar.TabBarItemModel r7) {
        /*
            r6 = this;
            boolean r0 = r6.m33221c(r7)
            if (r0 == 0) goto L_0x0129
            r0 = 0
            r6.setClipChildren(r0)
            com.didi.soda.customer.widget.text.RichTextView r1 = r6.f44790c
            if (r1 != 0) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            r1.setVisibility(r0)
        L_0x0012:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f44790c
            r1 = 0
            if (r0 != 0) goto L_0x0018
            goto L_0x0030
        L_0x0018:
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.getTabBarItem()
            if (r2 != 0) goto L_0x0020
        L_0x001e:
            r2 = r1
            goto L_0x002b
        L_0x0020:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()
            if (r2 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            java.lang.String r2 = r2.getContent()
        L_0x002b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0030:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f44790c
            if (r0 != 0) goto L_0x0036
        L_0x0034:
            r0 = r1
            goto L_0x006d
        L_0x0036:
            android.text.TextPaint r0 = r0.getPaint()
            if (r0 != 0) goto L_0x003d
            goto L_0x0034
        L_0x003d:
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.getTabBarItem()
            if (r2 != 0) goto L_0x0045
        L_0x0043:
            r2 = r1
            goto L_0x0050
        L_0x0045:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()
            if (r2 != 0) goto L_0x004c
            goto L_0x0043
        L_0x004c:
            java.lang.String r2 = r2.getContent()
        L_0x0050:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = com.didi.soda.customer.widget.text.RichTextParser.parseText(r2)
            java.lang.String r2 = r2.toString()
            float r0 = r0.measureText(r2)
            r2 = 2131168369(0x7f070c71, float:1.7951038E38)
            int r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r2)
            int r2 = r2 * 2
            float r2 = (float) r2
            float r0 = r0 + r2
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
        L_0x006d:
            com.didi.soda.customer.widget.text.RichTextView r2 = r6.f44790c
            if (r2 != 0) goto L_0x0073
            r2 = r1
            goto L_0x0077
        L_0x0073:
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
        L_0x0077:
            boolean r3 = r2 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r3 == 0) goto L_0x007e
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
            goto L_0x007f
        L_0x007e:
            r2 = r1
        L_0x007f:
            if (r0 == 0) goto L_0x00a0
            if (r2 != 0) goto L_0x0084
            goto L_0x00a0
        L_0x0084:
            float r3 = r0.floatValue()
            r4 = 2131167468(0x7f0708ec, float:1.794921E38)
            int r5 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r4)
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0099
            int r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r4)
            goto L_0x009e
        L_0x0099:
            float r0 = r0.floatValue()
            int r0 = (int) r0
        L_0x009e:
            r2.width = r0
        L_0x00a0:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f44790c
            if (r0 != 0) goto L_0x00a5
            goto L_0x00aa
        L_0x00a5:
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r0.setLayoutParams(r2)
        L_0x00aa:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f44790c
            if (r0 != 0) goto L_0x00b0
        L_0x00ae:
            r0 = r1
            goto L_0x00c5
        L_0x00b0:
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x00b7
            goto L_0x00ae
        L_0x00b7:
            android.content.res.Resources r0 = r0.getResources()
            if (r0 != 0) goto L_0x00be
            goto L_0x00ae
        L_0x00be:
            r2 = 2131232342(0x7f080656, float:1.808079E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
        L_0x00c5:
            boolean r2 = r0 instanceof android.graphics.drawable.GradientDrawable
            if (r2 == 0) goto L_0x00cc
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            goto L_0x00cd
        L_0x00cc:
            r0 = r1
        L_0x00cd:
            if (r0 == 0) goto L_0x011d
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.getTabBarItem()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00d7
        L_0x00d5:
            r2 = r1
            goto L_0x00e2
        L_0x00d7:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00de
            goto L_0x00d5
        L_0x00de:
            java.lang.String r2 = r2.getBackColor()     // Catch:{ Exception -> 0x010f }
        L_0x00e2:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x010f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x0104
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.getTabBarItem()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00f1
            goto L_0x00fc
        L_0x00f1:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00f8
            goto L_0x00fc
        L_0x00f8:
            java.lang.String r1 = r2.getBackColor()     // Catch:{ Exception -> 0x010f }
        L_0x00fc:
            int r1 = android.graphics.Color.parseColor(r1)     // Catch:{ Exception -> 0x010f }
            r0.setColor(r1)     // Catch:{ Exception -> 0x010f }
            goto L_0x0113
        L_0x0104:
            r1 = 2131101601(0x7f0607a1, float:1.7815616E38)
            int r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r1)     // Catch:{ Exception -> 0x010f }
            r0.setColor(r1)     // Catch:{ Exception -> 0x010f }
            goto L_0x0113
        L_0x010f:
            r1 = move-exception
            r1.fillInStackTrace()
        L_0x0113:
            com.didi.soda.customer.widget.text.RichTextView r1 = r6.f44790c
            if (r1 != 0) goto L_0x0118
            goto L_0x011d
        L_0x0118:
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r1.setBackground(r0)
        L_0x011d:
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r0 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()
            com.didi.soda.customer.widget.tabbar.TabBarItem r7 = r7.getTabBarItem()
            r0.trackTabBarRedFlagSW(r7)
            goto L_0x0133
        L_0x0129:
            com.didi.soda.customer.widget.text.RichTextView r7 = r6.f44790c
            if (r7 != 0) goto L_0x012e
            goto L_0x0133
        L_0x012e:
            r0 = 8
            r7.setVisibility(r0)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.tabbar.TabBarItemView.m33220b(com.didi.soda.customer.widget.tabbar.TabBarItemModel):void");
    }

    /* renamed from: c */
    private final boolean m33221c(TabBarItemModel tabBarItemModel) {
        boolean z;
        TabBarItem tabBarItem;
        TagEntity tagEntity = null;
        if (!(tabBarItemModel == null || (tabBarItem = tabBarItemModel.getTabBarItem()) == null)) {
            tagEntity = tabBarItem.getMDiscountTag();
        }
        if (tabBarItemModel != null && tabBarItemModel.isClicked()) {
            z = true;
        } else {
            z = false;
        }
        if (z || tagEntity == null || TextUtils.isEmpty(tagEntity.getContent())) {
            return false;
        }
        long j = ((TagStorage) SingletonFactory.get(TagStorage.class)).getLong(tagEntity.getCacheKey());
        if (TextUtils.isEmpty(tagEntity.getCacheKey()) || j == 0 || System.currentTimeMillis() - j > ((long) (tagEntity.getWaitTime() * 24 * 60 * 60)) * 1000) {
            return true;
        }
        return false;
    }

    public final void saveClickTimeForDiscountTagView(TabBarItemModel tabBarItemModel) {
        String str;
        TabBarItem tabBarItem;
        TagEntity mDiscountTag;
        TabBarItem tabBarItem2;
        TagEntity mDiscountTag2;
        if (m33221c(tabBarItemModel)) {
            String str2 = null;
            if (tabBarItemModel == null || (tabBarItem2 = tabBarItemModel.getTabBarItem()) == null || (mDiscountTag2 = tabBarItem2.getMDiscountTag()) == null) {
                str = null;
            } else {
                str = mDiscountTag2.getCacheKey();
            }
            if (!TextUtils.isEmpty(str)) {
                TagStorage tagStorage = (TagStorage) SingletonFactory.get(TagStorage.class);
                if (!(tabBarItemModel == null || (tabBarItem = tabBarItemModel.getTabBarItem()) == null || (mDiscountTag = tabBarItem.getMDiscountTag()) == null)) {
                    str2 = mDiscountTag.getCacheKey();
                }
                tagStorage.putLong(str2, System.currentTimeMillis());
            }
        }
    }

    public final void updateTabBarItem(TabBarItemModel tabBarItemModel) {
        Intrinsics.checkNotNullParameter(tabBarItemModel, "model");
        TabBarItem tabBarItem = tabBarItemModel.getTabBarItem();
        setSelected(tabBarItemModel.isSelected());
        CustomerAppCompatTextView customerAppCompatTextView = this.f44789b;
        if (customerAppCompatTextView != null) {
            customerAppCompatTextView.setText(tabBarItem.getText());
        }
        m33217a(tabBarItemModel);
        m33220b(tabBarItemModel);
        m33222d(tabBarItemModel);
        boolean z = false;
        boolean z2 = true;
        if (isSelected()) {
            CharSequence iconUrlSelected = tabBarItem.getIconUrlSelected();
            if (iconUrlSelected == null || iconUrlSelected.length() == 0) {
                z = true;
            }
            if (z) {
                ImageView imageView = this.f44788a;
                if (imageView != null) {
                    imageView.setImageResource(tabBarItem.getIconResSelected());
                }
            } else {
                m33218a(tabBarItem.getIconUrlSelected(), true);
            }
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f44789b;
            if (customerAppCompatTextView2 != null) {
                customerAppCompatTextView2.setFontType(IToolsService.FontType.BOLD);
                return;
            }
            return;
        }
        CharSequence iconUrl = tabBarItem.getIconUrl();
        if (!(iconUrl == null || iconUrl.length() == 0)) {
            z2 = false;
        }
        if (z2) {
            ImageView imageView2 = this.f44788a;
            if (imageView2 != null) {
                imageView2.setImageResource(tabBarItem.getIconRes());
            }
        } else {
            m33218a(tabBarItem.getIconUrl(), false);
        }
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f44789b;
        if (customerAppCompatTextView3 != null) {
            customerAppCompatTextView3.setFontType(IToolsService.FontType.NORMAL);
        }
    }

    /* renamed from: d */
    private final void m33222d(TabBarItemModel tabBarItemModel) {
        if (tabBarItemModel.getTabBarItem().getNeedShowRocket()) {
            HomeRocketLaunchAnimManager.Companion.getInstance().setOnHomeListScrollChangeListener(new TabBarItemView$registerHomeListScrollChangeEvent$1(this, tabBarItemModel));
            m33219a(isSelected() && tabBarItemModel.getTabBarItem().isRocketAnimShown(), false, tabBarItemModel);
        }
    }

    public final void checkShouldBackToTop(TabBarItemModel tabBarItemModel) {
        Intrinsics.checkNotNullParameter(tabBarItemModel, "tabBarItemModel");
        if (tabBarItemModel.getTabBarItem().getNeedShowRocket() && tabBarItemModel.getTabBarItem().isRocketAnimShown()) {
            HomeRocketLaunchAnimManager.Companion.getInstance().backToTop();
            TabBarItem tabBarItem = tabBarItemModel.getTabBarItem();
            if (tabBarItem != null) {
                tabBarItem.setRocketAnimShown(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33219a(boolean z, boolean z2, TabBarItemModel tabBarItemModel) {
        if (z) {
            LottieAnimationView lottieAnimationView = this.f44791d;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
            }
            ImageView imageView = this.f44788a;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            CustomerAppCompatTextView customerAppCompatTextView = this.f44789b;
            if (customerAppCompatTextView != null) {
                customerAppCompatTextView.setText(tabBarItemModel.getTabBarItem().getRocketLaunchText());
            }
            if (z2 && !tabBarItemModel.getTabBarItem().isRocketAnimShown()) {
                LottieAnimationView lottieAnimationView2 = this.f44791d;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.playAnimation();
                }
                tabBarItemModel.getTabBarItem().setRocketAnimShown(true);
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView3 = this.f44791d;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        ImageView imageView2 = this.f44788a;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f44789b;
        if (customerAppCompatTextView2 != null) {
            TabBarItem tabBarItem = tabBarItemModel.getTabBarItem();
            customerAppCompatTextView2.setText(tabBarItem == null ? null : tabBarItem.getText());
        }
        if (z2) {
            tabBarItemModel.getTabBarItem().setRocketAnimShown(false);
        }
    }

    public final void setOnDoubleClickListener(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "doubleClick");
        this.f44792e = new GestureDetector(getContext(), new TabBarItemView$setOnDoubleClickListener$listener$1(function1, this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f44792e;
        if (gestureDetector != null) {
            Intrinsics.checkNotNull(gestureDetector);
            if (gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
