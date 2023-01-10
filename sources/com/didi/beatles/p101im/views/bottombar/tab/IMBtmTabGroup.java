package com.didi.beatles.p101im.views.bottombar.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.protocol.model.IMTabActionItem;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabGroup */
public class IMBtmTabGroup extends LinearLayout {

    /* renamed from: a */
    private static final String f11959a = IMBtmTabGroup.class.getSimpleName();

    /* renamed from: b */
    private static final float f11960b = 1.0f;

    /* renamed from: c */
    private static final float f11961c = 0.5f;

    /* renamed from: d */
    private OnTabCheckedChangeListener f11962d;

    /* renamed from: e */
    private int f11963e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<String, String> f11964f;

    /* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabGroup$OnTabCheckedChangeListener */
    public interface OnTabCheckedChangeListener {
        void onTabCheckedChanged(int i, boolean z, boolean z2);
    }

    public IMBtmTabGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBtmTabGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBtmTabGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11963e = -1;
        this.f11964f = null;
        setOrientation(0);
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f11964f = map;
    }

    public void setOnTabCheckedChangeListener(OnTabCheckedChangeListener onTabCheckedChangeListener) {
        this.f11962d = onTabCheckedChangeListener;
    }

    public void setCheckId(int i, boolean z) {
        m10292a(i, z);
    }

    public int getCheckedId() {
        return this.f11963e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10292a(int i, boolean z) {
        boolean z2 = i != this.f11963e;
        IMLog.m10020d(f11959a, C4786I.m9980t("[check] pluginId=", Integer.valueOf(i), " |mCheckedPluginId=", Integer.valueOf(this.f11963e), " |needNotify=", Boolean.valueOf(z2)));
        int i2 = this.f11963e;
        if (i2 != -1) {
            m10293a(i2, false, z2, z);
        }
        if (i != -1) {
            m10293a(i, true, z2, z);
        }
        this.f11963e = i;
    }

    public void reset() {
        if (getVisibility() != 8) {
            m10292a(-1, false);
        }
    }

    public void bindData(List<IMTabActionItem> list) {
        removeAllViews();
        for (IMTabActionItem next : list) {
            addView(m10299b(next));
            if (next.pluginId == this.f11963e && !next.enable) {
                this.f11963e = -1;
                IMLog.m10020d(f11959a, C4786I.m9980t("[bindData] reset checked but disable tab -> ", Integer.valueOf(next.pluginId)));
            }
        }
        m10292a(this.f11963e, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10295a(IMTabActionItem iMTabActionItem) {
        if (iMTabActionItem.pluginId == 5) {
            int btmTabRedDotShowedCount = IMPreference.getInstance(IMContextInfoHelper.getContext()).getBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 5);
            if (btmTabRedDotShowedCount >= 3) {
                View defaultTabView = iMTabActionItem.getDefaultTabView();
                if (defaultTabView instanceof IMBtmTabContentView) {
                    ((IMBtmTabContentView) defaultTabView).setDotVisible(8);
                }
            }
            if (btmTabRedDotShowedCount < 3) {
                IMPreference.getInstance(IMContextInfoHelper.getContext()).saveBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 5, btmTabRedDotShowedCount + 1);
            }
        }
    }

    /* renamed from: b */
    private View m10299b(final IMTabActionItem iMTabActionItem) {
        IMBtmTabItemView iMBtmTabItemView = new IMBtmTabItemView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        iMBtmTabItemView.setLayoutParams(layoutParams);
        if (iMTabActionItem.enable) {
            iMBtmTabItemView.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMBtmTabGroup.this.m10292a(iMTabActionItem.pluginId, true);
                    IMBtmTabGroup.this.m10295a(iMTabActionItem);
                    IMTraceUtil.addBusinessEvent("wyc_ddim_changetab_ck").add("ck_type", Integer.valueOf(iMTabActionItem.pluginId)).add(IMBtmTabGroup.this.f11964f).report();
                }
            });
            iMBtmTabItemView.setAlpha(1.0f);
        } else {
            iMBtmTabItemView.setOnClickListener((View.OnClickListener) null);
            iMBtmTabItemView.setSelected(false);
            iMBtmTabItemView.setAlpha(0.5f);
        }
        if (iMTabActionItem.customTabView != null) {
            iMBtmTabItemView.addTabView(iMTabActionItem.customTabView);
        } else {
            View defaultTabView = iMTabActionItem.getDefaultTabView();
            if (defaultTabView instanceof IMBtmTabContentView) {
                IMBtmTabContentView iMBtmTabContentView = (IMBtmTabContentView) defaultTabView;
                iMBtmTabContentView.bindData(iMTabActionItem.text, iMTabActionItem.iconId);
                m10296a(iMTabActionItem, iMBtmTabContentView);
            }
            iMBtmTabItemView.addTabView(defaultTabView);
        }
        m10294a((View) iMBtmTabItemView, iMTabActionItem.pluginId);
        return iMBtmTabItemView;
    }

    /* renamed from: a */
    private void m10296a(IMTabActionItem iMTabActionItem, IMBtmTabContentView iMBtmTabContentView) {
        if (iMTabActionItem.pluginId == 5 && IMPreference.getInstance(IMContextInfoHelper.getContext()).getBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 5) < 3) {
            iMBtmTabContentView.setDotVisible(0);
        }
    }

    /* renamed from: a */
    private void m10293a(int i, boolean z, boolean z2, boolean z3) {
        OnTabCheckedChangeListener onTabCheckedChangeListener;
        View a = m10290a(i);
        if (a != null && (a instanceof IMBtmTabItemView)) {
            ((IMBtmTabItemView) a).setChecked(z);
        }
        if (a != null) {
            a.setSelected(z);
        }
        if (z2 && (onTabCheckedChangeListener = this.f11962d) != null) {
            onTabCheckedChangeListener.onTabCheckedChanged(i, z, z3);
        }
    }

    /* renamed from: a */
    private View m10290a(int i) {
        View findViewWithTag = findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null) {
            IMLog.m10021e(f11959a, "[findViewByPluginId] NULL VIEW. pluginId=", Integer.valueOf(i));
        }
        return findViewWithTag;
    }

    /* renamed from: a */
    private void m10294a(View view, int i) {
        view.setTag(String.valueOf(i));
    }
}
