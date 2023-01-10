package com.didi.beatles.p101im.views.bottombar.tab;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p101im.plugin.IMPluginFactory;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p101im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p101im.protocol.model.IMTabActionItem;
import com.didi.beatles.p101im.protocol.plugin.IMPluginService;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMTabActionFactory */
public final class IMTabActionFactory {

    /* renamed from: a */
    private static final String f11967a = IMTabActionFactory.class.getSimpleName();

    /* renamed from: b */
    private IMTabActionItem f11968b;

    /* renamed from: c */
    private IMTabActionItem f11969c;

    /* renamed from: d */
    private IMTabActionItem f11970d;

    public void release() {
        IMLog.m10024i(f11967a, "[release]");
        this.f11968b = null;
        this.f11969c = null;
        this.f11970d = null;
    }

    /* renamed from: a */
    private IMTabActionItem m10301a(Context context) {
        if (this.f11968b == null) {
            this.f11968b = new IMTabActionItem(4, context.getString(R.string.im_bottombar_button_expression), R.drawable.im_bottom_bar_tab_message_selector) {
                public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
                    return null;
                }
            };
        }
        return this.f11968b;
    }

    /* renamed from: b */
    private IMTabActionItem m10303b(Context context) {
        if (this.f11969c == null) {
            this.f11969c = new IMTabActionItem(6, context.getString(R.string.im_bottombar_button_emoji), R.drawable.im_bottom_bar_tab_emoji_selector) {
                public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
                    return null;
                }
            };
        }
        return this.f11969c;
    }

    /* renamed from: a */
    private IMTabActionItem m10302a(Context context, String str) {
        if (this.f11970d == null) {
            if (TextUtils.isEmpty(str)) {
                str = context.getString(R.string.im_bottombar_button_more);
            }
            this.f11970d = new IMTabActionItem(5, str, R.drawable.im_bottom_bar_tab_more_selector) {
                public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
                    return null;
                }
            };
        }
        return this.f11970d;
    }

    public IMTabActionItem loadTabActionItem(Context context, int i, IMTabInvokeEnv iMTabInvokeEnv) {
        return loadTabActionItem(context, i, iMTabInvokeEnv, (String) null);
    }

    public IMTabActionItem loadTabActionItem(Context context, int i, IMTabInvokeEnv iMTabInvokeEnv, String str) {
        if (i == 4) {
            return m10301a(context);
        }
        if (i == 6) {
            return m10303b(context);
        }
        if (i == 5) {
            return m10302a(context, str);
        }
        IMPluginService plugin = IMPluginFactory.getPlugin(i);
        if (plugin == null) {
            IMLog.m10021e(f11967a, C4786I.m9980t("[loadTabActionItem] Plugin id :", Integer.valueOf(i), " not implement yet."));
            return null;
        }
        IMTabActionItem tabActionItem = plugin.getTabActionItem(context, iMTabInvokeEnv);
        if (tabActionItem == null) {
            IMLog.m10021e(f11967a, C4786I.m9980t("[loadTabActionItem] Plugin id :", Integer.valueOf(i), " without tab action item."));
            return null;
        }
        IMLog.m10021e(f11967a, C4786I.m9980t("[loadTabActionItem] Tab item with plugin id :", Integer.valueOf(i)));
        return tabActionItem;
    }
}
