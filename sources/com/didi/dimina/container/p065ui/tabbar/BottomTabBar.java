package com.didi.dimina.container.p065ui.tabbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.soda.blocks.constant.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.tabbar.BottomTabBar */
public class BottomTabBar extends FrameLayout {
    public static final int LINE_HEIGHT = 2;

    /* renamed from: a */
    private View f19700a;

    /* renamed from: b */
    private LinearLayout f19701b;

    /* renamed from: c */
    private JSAppConfig.TabBar f19702c;

    /* renamed from: d */
    private DMConfig.OnTabSelectInterceptor f19703d;

    /* renamed from: e */
    private onItemSelectedListener f19704e;

    /* renamed from: f */
    private int f19705f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f19706g;

    /* renamed from: h */
    private boolean f19707h;

    /* renamed from: com.didi.dimina.container.ui.tabbar.BottomTabBar$onItemSelectedListener */
    public interface onItemSelectedListener {
        void onSelected(int i, int i2, JSAppConfig.TabBar.Item item, boolean z);
    }

    /* renamed from: com.didi.dimina.container.ui.tabbar.BottomTabBar$onTabSelectInterceptorCallBack */
    public interface onTabSelectInterceptorCallBack {
        void onNext();
    }

    public BottomTabBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomTabBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public BottomTabBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f19705f = -1;
        this.f19706g = -1;
    }

    public void setTabBarData(JSAppConfig.TabBar tabBar, int i, ArrayList<Integer> arrayList) {
        this.f19702c = tabBar;
        setBackgroundColor(tabBar.getBackgroundColor());
        m16773b();
        m16771a();
        this.f19701b.removeAllViews();
        List<JSAppConfig.TabBar.Item> list = tabBar.list;
        int i2 = 0;
        while (i2 < list.size()) {
            JSAppConfig.TabBar.Item item = list.get(i2);
            TabView tabView = new TabView(getContext());
            tabView.mo61746a(this.f19702c.getNormalColor(), this.f19702c.getSelectedColor());
            tabView.mo61747a(item, (arrayList == null || arrayList.size() <= i2) ? -1 : arrayList.get(i2).intValue());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.f19701b.addView(tabView, layoutParams);
            tabView.setOnClickListener(new View.OnClickListener(i2, item) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ JSAppConfig.TabBar.Item f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    BottomTabBar.this.m16772a(this.f$1, this.f$2, view);
                }
            });
            i2++;
        }
        setSelectIndex(false, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16772a(int i, JSAppConfig.TabBar.Item item, View view) {
        if (this.f19707h) {
            DMConfig.OnTabSelectInterceptor onTabSelectInterceptor = this.f19703d;
            if (onTabSelectInterceptor != null) {
                onTabSelectInterceptor.onInterceptor(this.f19706g, i, item, new onTabSelectInterceptorCallBack(i) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onNext() {
                        BottomTabBar.this.m16775c(this.f$1);
                    }
                });
            } else {
                setSelectIndex(true, i);
            }
        } else if (this.f19706g == -1) {
            this.f19706g = i;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m16775c(int i) {
        setSelectIndex(true, i);
    }

    public void setTabBarData(JSAppConfig.TabBar tabBar, int i) {
        setTabBarData(tabBar, i, (ArrayList<Integer>) null);
    }

    public void setSelectIndex(boolean z, int i) {
        int i2 = this.f19705f;
        if (i2 != -1) {
            ((TabView) this.f19701b.getChildAt(i2)).setChecked(false);
        }
        ((TabView) this.f19701b.getChildAt(i)).setChecked(true);
        int i3 = this.f19705f;
        this.f19705f = i;
        onItemSelectedListener onitemselectedlistener = this.f19704e;
        if (onitemselectedlistener != null) {
            onitemselectedlistener.onSelected(i3, i, this.f19702c.list.get(i), z);
        }
    }

    /* renamed from: a */
    private void m16771a() {
        if (this.f19701b == null) {
            this.f19701b = new LinearLayout(getContext());
            this.f19701b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f19701b.setOrientation(0);
            addView(this.f19701b);
        }
    }

    /* renamed from: b */
    private void m16773b() {
        int borderColor = this.f19702c.getBorderColor();
        if (this.f19700a == null) {
            this.f19700a = new View(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 2);
            layoutParams.gravity = 48;
            this.f19700a.setLayoutParams(layoutParams);
            addView(this.f19700a);
        }
        this.f19700a.setBackgroundColor(borderColor);
    }

    public boolean setTabBarStyle(JSONObject jSONObject) {
        if (this.f19701b.getChildCount() != this.f19702c.list.size()) {
            return false;
        }
        String optString = jSONObject.optString("color");
        String optString2 = jSONObject.optString("selectedColor");
        String optString3 = jSONObject.optString("backgroundColor");
        String optString4 = jSONObject.optString(Const.StyleConst.BORDER_STYLE);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            this.f19702c.color = optString;
            this.f19702c.selectedColor = optString2;
            int childCount = this.f19701b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mo61731a(i).mo61746a(this.f19702c.getNormalColor(), this.f19702c.getSelectedColor());
            }
        }
        if (!TextUtils.isEmpty(optString3)) {
            this.f19702c.backgroundColor = optString3;
            setBackgroundColor(this.f19702c.getBackgroundColor());
        }
        if (TextUtils.isEmpty(optString4)) {
            return true;
        }
        this.f19702c.borderStyle = optString4;
        this.f19700a.setBackgroundColor(this.f19702c.getBorderColor());
        return true;
    }

    public boolean setTabBarItem(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index", -1);
        if (m16774b(optInt)) {
            return false;
        }
        String optString = jSONObject.optString("text");
        String optString2 = jSONObject.optString("iconPath");
        String optString3 = jSONObject.optString("selectedIconPath");
        JSAppConfig.TabBar.Item item = this.f19702c.list.get(optInt);
        if (!TextUtils.isEmpty(optString)) {
            item.text = optString;
        }
        if (!TextUtils.isEmpty(optString2)) {
            item.iconPath = optString2;
        }
        if (!TextUtils.isEmpty(optString3)) {
            item.selectedIconPath = optString3;
        }
        TabView a = mo61731a(optInt);
        if (a == null) {
            return true;
        }
        a.setData(item);
        return true;
    }

    public boolean showTabBarRedDot(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index", -1);
        if (m16774b(optInt)) {
            return false;
        }
        TabView a = mo61731a(optInt);
        if (a == null) {
            return true;
        }
        a.mo61748a("");
        return true;
    }

    public boolean hideTabBarRedDot(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index");
        if (m16774b(optInt)) {
            return false;
        }
        TabView a = mo61731a(optInt);
        if (a == null) {
            return true;
        }
        a.mo61745a();
        return true;
    }

    public boolean setTabBarBadge(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index");
        if (m16774b(optInt)) {
            return false;
        }
        String optString = jSONObject.optString("text", "");
        TabView a = mo61731a(optInt);
        if (a == null) {
            return true;
        }
        if ("0".equals(optString)) {
            a.mo61745a();
            return true;
        }
        a.mo61748a(optString);
        return true;
    }

    public boolean removeTabBarBadge(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("index");
        if (m16774b(optInt)) {
            return false;
        }
        TabView a = mo61731a(optInt);
        if (a == null) {
            return true;
        }
        a.mo61745a();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TabView mo61731a(int i) {
        if (i < 0 || i > this.f19701b.getChildCount() - 1) {
            return null;
        }
        return (TabView) this.f19701b.getChildAt(i);
    }

    /* renamed from: b */
    private boolean m16774b(int i) {
        if (i == -1 || i >= this.f19702c.list.size() || this.f19701b.getChildCount() != this.f19702c.list.size()) {
            return true;
        }
        return false;
    }

    public void setOnItemSelectedListener(onItemSelectedListener onitemselectedlistener) {
        this.f19704e = onitemselectedlistener;
    }

    public void enable(boolean z) {
        this.f19707h = z;
        if (z && this.f19706g != -1) {
            UIHandlerUtil.post(new Runnable() {
                public void run() {
                    BottomTabBar bottomTabBar = BottomTabBar.this;
                    bottomTabBar.setSelectIndex(true, bottomTabBar.f19706g);
                    int unused = BottomTabBar.this.f19706g = -1;
                }
            });
        }
    }

    public void setOnTabSelectInterceptor(DMConfig.OnTabSelectInterceptor onTabSelectInterceptor) {
        this.f19703d = onTabSelectInterceptor;
    }
}
