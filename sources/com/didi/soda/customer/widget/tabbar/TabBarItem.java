package com.didi.soda.customer.widget.tabbar;

import android.os.Bundle;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001:\u0001YB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010X\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010(\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010*\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\u001c\u0010D\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001c\u0010G\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010S¨\u0006Z"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "", "()V", "bottomName", "", "getBottomName", "()Ljava/lang/String;", "setBottomName", "(Ljava/lang/String;)V", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "getController", "()Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "setController", "(Lcom/didi/soda/customer/widget/tabbar/ComponentController;)V", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "iconRes", "getIconRes", "setIconRes", "iconResSelected", "getIconResSelected", "setIconResSelected", "iconUrl", "getIconUrl", "setIconUrl", "iconUrlSelected", "getIconUrlSelected", "setIconUrlSelected", "isCanDoubleClick", "", "()Z", "setCanDoubleClick", "(Z)V", "isLazyLoad", "setLazyLoad", "isRocketAnimShown", "setRocketAnimShown", "isSelected", "setSelected", "mDiscountTag", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "getMDiscountTag", "()Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "setMDiscountTag", "(Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;)V", "needShowRocket", "getNeedShowRocket", "setNeedShowRocket", "op", "Lcom/didi/soda/customer/widget/tabbar/TabBarOp;", "getOp", "()Lcom/didi/soda/customer/widget/tabbar/TabBarOp;", "setOp", "(Lcom/didi/soda/customer/widget/tabbar/TabBarOp;)V", "params", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "setParams", "(Landroid/os/Bundle;)V", "rocketLaunchText", "getRocketLaunchText", "setRocketLaunchText", "tabPath", "getTabPath", "setTabPath", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "text", "getText", "setText", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColorSelected", "getTextColorSelected", "setTextColorSelected", "toString", "TabBarItemBuilder", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarItem.kt */
public final class TabBarItem {

    /* renamed from: a */
    private int f44761a;

    /* renamed from: b */
    private int f44762b;

    /* renamed from: c */
    private String f44763c;

    /* renamed from: d */
    private String f44764d;

    /* renamed from: e */
    private String f44765e;

    /* renamed from: f */
    private Integer f44766f;

    /* renamed from: g */
    private Integer f44767g;

    /* renamed from: h */
    private ComponentController f44768h;

    /* renamed from: i */
    private boolean f44769i;

    /* renamed from: j */
    private boolean f44770j = true;

    /* renamed from: k */
    private boolean f44771k;

    /* renamed from: l */
    private String f44772l;

    /* renamed from: m */
    private Object f44773m;

    /* renamed from: n */
    private TabBarOp f44774n = TabBarOp.ADD;

    /* renamed from: o */
    private Bundle f44775o;

    /* renamed from: p */
    private TagEntity f44776p;

    /* renamed from: q */
    private String f44777q;

    /* renamed from: r */
    private int f44778r;

    /* renamed from: s */
    private String f44779s;

    /* renamed from: t */
    private boolean f44780t;

    /* renamed from: u */
    private boolean f44781u;

    public final int getIconRes() {
        return this.f44761a;
    }

    public final void setIconRes(int i) {
        this.f44761a = i;
    }

    public final int getIconResSelected() {
        return this.f44762b;
    }

    public final void setIconResSelected(int i) {
        this.f44762b = i;
    }

    public final String getIconUrl() {
        return this.f44763c;
    }

    public final void setIconUrl(String str) {
        this.f44763c = str;
    }

    public final String getIconUrlSelected() {
        return this.f44764d;
    }

    public final void setIconUrlSelected(String str) {
        this.f44764d = str;
    }

    public final String getText() {
        return this.f44765e;
    }

    public final void setText(String str) {
        this.f44765e = str;
    }

    public final Integer getTextColor() {
        return this.f44766f;
    }

    public final void setTextColor(Integer num) {
        this.f44766f = num;
    }

    public final Integer getTextColorSelected() {
        return this.f44767g;
    }

    public final void setTextColorSelected(Integer num) {
        this.f44767g = num;
    }

    public final ComponentController getController() {
        return this.f44768h;
    }

    public final void setController(ComponentController componentController) {
        this.f44768h = componentController;
    }

    public final boolean isSelected() {
        return this.f44769i;
    }

    public final void setSelected(boolean z) {
        this.f44769i = z;
    }

    public final boolean isLazyLoad() {
        return this.f44770j;
    }

    public final void setLazyLoad(boolean z) {
        this.f44770j = z;
    }

    public final boolean isCanDoubleClick() {
        return this.f44771k;
    }

    public final void setCanDoubleClick(boolean z) {
        this.f44771k = z;
    }

    public final String getTabPath() {
        return this.f44772l;
    }

    public final void setTabPath(String str) {
        this.f44772l = str;
    }

    public final Object getTag() {
        return this.f44773m;
    }

    public final void setTag(Object obj) {
        this.f44773m = obj;
    }

    public final TabBarOp getOp() {
        return this.f44774n;
    }

    public final void setOp(TabBarOp tabBarOp) {
        Intrinsics.checkNotNullParameter(tabBarOp, "<set-?>");
        this.f44774n = tabBarOp;
    }

    public final Bundle getParams() {
        return this.f44775o;
    }

    public final void setParams(Bundle bundle) {
        this.f44775o = bundle;
    }

    public final TagEntity getMDiscountTag() {
        return this.f44776p;
    }

    public final void setMDiscountTag(TagEntity tagEntity) {
        this.f44776p = tagEntity;
    }

    public final String getBottomName() {
        return this.f44777q;
    }

    public final void setBottomName(String str) {
        this.f44777q = str;
    }

    public final int getCurrentIndex() {
        return this.f44778r;
    }

    public final void setCurrentIndex(int i) {
        this.f44778r = i;
    }

    public final String getRocketLaunchText() {
        return this.f44779s;
    }

    public final void setRocketLaunchText(String str) {
        this.f44779s = str;
    }

    public final boolean isRocketAnimShown() {
        return this.f44780t;
    }

    public final void setRocketAnimShown(boolean z) {
        this.f44780t = z;
    }

    public final boolean getNeedShowRocket() {
        return this.f44781u;
    }

    public final void setNeedShowRocket(boolean z) {
        this.f44781u = z;
    }

    public String toString() {
        return "TabBarItem@" + hashCode() + " text = " + this.f44765e;
    }

    @Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0014J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0006J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bJ\u0016\u00100\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0014J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0014J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u00106\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u00107\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000bJ\u001f\u00108\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010;\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010<\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"¨\u0006="}, mo148868d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItem$TabBarItemBuilder;", "", "()V", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "discountTag", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "iconRes", "", "iconResSelected", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "iconUrlSelected", "getIconUrlSelected", "setIconUrlSelected", "isCanDoubleClick", "", "isLazyLoad", "isSelected", "needShowRocket", "params", "Landroid/os/Bundle;", "rocketLaunchText", "tabPath", "tag", "text", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColorSelected", "getTextColorSelected", "setTextColorSelected", "builder", "Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "setCanDoubleClick", "can", "setDiscountTag", "tagEntity", "setItemController", "setItemIconRes", "selectedIconRes", "setItemIconUrl", "setItemIsLazyLoad", "lazyLoad", "setItemIsSelected", "selected", "setItemTabPath", "setItemTag", "setItemText", "setItemTextColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/didi/soda/customer/widget/tabbar/TabBarItem$TabBarItemBuilder;", "setParams", "setRocketLaunchText", "setRocketNeedShow", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TabBarItem.kt */
    public static final class TabBarItemBuilder {
        private ComponentController controller;
        private TagEntity discountTag;
        private int iconRes;
        private int iconResSelected;
        private String iconUrl;
        private String iconUrlSelected;
        private boolean isCanDoubleClick;
        private boolean isLazyLoad = true;
        private boolean isSelected;
        private boolean needShowRocket;
        private Bundle params;
        private String rocketLaunchText;
        private String tabPath;
        private Object tag;
        private String text;
        private Integer textColor;
        private Integer textColorSelected;

        public final Integer getTextColor() {
            return this.textColor;
        }

        public final void setTextColor(Integer num) {
            this.textColor = num;
        }

        public final Integer getTextColorSelected() {
            return this.textColorSelected;
        }

        public final void setTextColorSelected(Integer num) {
            this.textColorSelected = num;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            this.iconUrl = str;
        }

        public final String getIconUrlSelected() {
            return this.iconUrlSelected;
        }

        public final void setIconUrlSelected(String str) {
            this.iconUrlSelected = str;
        }

        public final TabBarItemBuilder setItemTag(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "tag");
            this.tag = obj;
            return this;
        }

        public final TabBarItemBuilder setItemTabPath(String str) {
            Intrinsics.checkNotNullParameter(str, "tabPath");
            this.tabPath = str;
            return this;
        }

        public final TabBarItemBuilder setItemIconRes(int i, int i2) {
            this.iconRes = i;
            this.iconResSelected = i2;
            return this;
        }

        public final TabBarItemBuilder setItemIconUrl(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "iconUrl");
            Intrinsics.checkNotNullParameter(str2, "iconUrlSelected");
            this.iconUrl = str;
            this.iconUrlSelected = str2;
            return this;
        }

        public final TabBarItemBuilder setItemText(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            return this;
        }

        public final TabBarItemBuilder setItemTextColor(Integer num, Integer num2) {
            this.textColor = num;
            this.textColorSelected = num2;
            return this;
        }

        public final TabBarItemBuilder setItemController(ComponentController componentController) {
            Intrinsics.checkNotNullParameter(componentController, "controller");
            this.controller = componentController;
            return this;
        }

        public final TabBarItemBuilder setItemIsSelected(boolean z) {
            this.isSelected = z;
            return this;
        }

        public final TabBarItemBuilder setItemIsLazyLoad(boolean z) {
            this.isLazyLoad = z;
            return this;
        }

        public final TabBarItemBuilder setCanDoubleClick(boolean z) {
            this.isCanDoubleClick = z;
            return this;
        }

        public final TabBarItemBuilder setParams(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "params");
            this.params = bundle;
            return this;
        }

        public final TabBarItemBuilder setDiscountTag(TagEntity tagEntity) {
            this.discountTag = tagEntity;
            return this;
        }

        public final TabBarItemBuilder setRocketLaunchText(String str) {
            this.rocketLaunchText = str;
            return this;
        }

        public final TabBarItemBuilder setRocketNeedShow(boolean z) {
            this.needShowRocket = z;
            return this;
        }

        public final TabBarItem builder() {
            TabBarItem tabBarItem = new TabBarItem();
            tabBarItem.setText(this.text);
            tabBarItem.setTextColor(getTextColor());
            tabBarItem.setTextColorSelected(getTextColorSelected());
            tabBarItem.setController(this.controller);
            tabBarItem.setSelected(this.isSelected);
            tabBarItem.setLazyLoad(this.isLazyLoad);
            tabBarItem.setCanDoubleClick(this.isCanDoubleClick);
            tabBarItem.setIconRes(this.iconRes);
            tabBarItem.setIconResSelected(this.iconResSelected);
            tabBarItem.setIconUrl(getIconUrl());
            tabBarItem.setIconUrlSelected(getIconUrlSelected());
            tabBarItem.setTag(this.tag);
            tabBarItem.setTabPath(this.tabPath);
            tabBarItem.setParams(this.params);
            tabBarItem.setMDiscountTag(this.discountTag);
            tabBarItem.setRocketLaunchText(this.rocketLaunchText);
            tabBarItem.setNeedShowRocket(this.needShowRocket);
            return tabBarItem;
        }
    }
}
