package com.didi.dimina.container.p065ui.tabbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.p065ui.tabbar.BadgeView.Badge;
import com.didi.dimina.container.p065ui.tabbar.BadgeView.QBadgeView;
import com.didi.dimina.container.service.ImageLoaderService;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;
import java.io.File;

/* renamed from: com.didi.dimina.container.ui.tabbar.TabView */
class TabView extends FrameLayout implements Checkable {

    /* renamed from: a */
    public static final int f19708a = -1;

    /* renamed from: b */
    private final FrameLayout f19709b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ImageView f19710c;

    /* renamed from: d */
    private final TextView f19711d;

    /* renamed from: e */
    private Badge f19712e;

    /* renamed from: f */
    private JSAppConfig.TabBar.Item f19713f;

    /* renamed from: g */
    private int f19714g;

    /* renamed from: h */
    private int f19715h;

    /* renamed from: i */
    private boolean f19716i;

    public TabView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflate(getContext(), R.layout.dimina_tab_view, this);
        this.f19710c = (ImageView) findViewById(R.id.iconImage);
        this.f19709b = (FrameLayout) findViewById(R.id.badgeContainer);
        this.f19711d = (TextView) findViewById(R.id.tabTextView);
    }

    public void setData(JSAppConfig.TabBar.Item item) {
        mo61747a(item, -1);
    }

    /* renamed from: a */
    public void mo61747a(JSAppConfig.TabBar.Item item, int i) {
        this.f19713f = item;
        m16780c();
        m16778a(i);
    }

    /* renamed from: a */
    public void mo61746a(int i, int i2) {
        this.f19714g = i;
        this.f19715h = i2;
        m16780c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61748a(String str) {
        m16779b();
        try {
            this.f19712e.setBadgeNumber(Integer.parseInt(str));
        } catch (Exception unused) {
            this.f19712e.setBadgeText(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61745a() {
        Badge badge = this.f19712e;
        if (badge != null) {
            badge.hide(true);
        }
    }

    /* renamed from: b */
    private void m16779b() {
        if (this.f19712e == null) {
            this.f19712e = new QBadgeView(getContext()).bindTarget(this.f19709b).setBadgeTextSize(9.0f, true).setBadgeGravity(BadgeDrawable.TOP_END).setBadgePadding(4.0f, true).setBadgeBackgroundColor(Color.parseColor("#FF525D")).setShowShadow(false);
        }
    }

    public void setChecked(boolean z) {
        this.f19716i = z;
        m16781d();
        m16780c();
    }

    public boolean isChecked() {
        return this.f19716i;
    }

    public void toggle() {
        this.f19716i = !this.f19716i;
        m16781d();
        m16780c();
    }

    /* renamed from: c */
    private void m16780c() {
        if (this.f19713f != null && !TextUtils.equals(this.f19711d.getText(), this.f19713f.text)) {
            this.f19711d.setText(this.f19713f.text);
        }
        this.f19711d.setTextColor(isChecked() ? this.f19715h : this.f19714g);
    }

    /* renamed from: d */
    private void m16781d() {
        m16778a(-1);
    }

    /* renamed from: a */
    private void m16778a(int i) {
        if (i != -1) {
            this.f19710c.setImageResource(i);
            return;
        }
        String str = isChecked() ? this.f19713f.selectedIconPath : this.f19713f.iconPath;
        if (str.startsWith("http")) {
            Dimina.getConfig().getAdapterConfig().getImageLoaderService().load(getContext(), str, (ImageLoaderService.FinishDrawableListener) new ImageLoaderService.FinishDrawableListener() {
                public void onDrawableFinish(Drawable drawable) {
                    TabView.this.f19710c.setImageDrawable(drawable);
                }
            });
        } else {
            Dimina.getConfig().getAdapterConfig().getImageLoaderService().loadInto(getContext(), new File(str), this.f19710c);
        }
    }
}
