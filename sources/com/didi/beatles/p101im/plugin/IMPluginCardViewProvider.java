package com.didi.beatles.p101im.plugin;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p101im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p101im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.custom.IMCustomCardViewBaseProvider;
import java.lang.reflect.Constructor;

/* renamed from: com.didi.beatles.im.plugin.IMPluginCardViewProvider */
public class IMPluginCardViewProvider extends IMCustomCardViewBaseProvider {

    /* renamed from: a */
    private static final String f11307a = IMPluginCardViewProvider.class.getSimpleName();

    /* renamed from: b */
    private SparseArray<Class<? extends View>> f11308b = new SparseArray<>();
    protected IMMessageViewStatusCallback mStatusCallback;

    public final void bindData(int i, View view, String str) {
    }

    public void setMessageViewStatusCallback(IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.mStatusCallback = iMMessageViewStatusCallback;
    }

    public void removeMessageViewStatusCallback(IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.mStatusCallback = null;
    }

    public void registerPluginMessageView(int i, Class<? extends View> cls) {
        this.f11308b.put(i, cls);
    }

    public View getView(Context context, View view, int i) {
        Class cls = this.f11308b.get(i);
        String str = f11307a;
        IMLog.m10020d(str, "[getView] viewType=" + i + " |clazz=" + cls);
        if (cls == null) {
            IMLog.m10021e(f11307a, C4786I.m9980t("custom im card not support type ", Integer.valueOf(i)));
            return null;
        }
        try {
            Constructor constructor = cls.getConstructor(new Class[]{Context.class});
            if (constructor != null) {
                return (View) constructor.newInstance(new Object[]{context});
            }
        } catch (Exception e) {
            IMLog.m10021e(f11307a, C4786I.m9980t("create custom card failed, view class = ", cls.getName(), " errMsg = ", e.toString()));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onBindData(int i, View view, String str, IMMessage iMMessage, IMRenderCardEnv iMRenderCardEnv) {
        if (view == null) {
            IMLog.m10021e(f11307a, C4786I.m9980t("[bindData] with NULL view. position=", Integer.valueOf(i), " |data=", str));
        } else if (view instanceof IIMPluginCardView) {
            ((IIMPluginCardView) view).onBind(i, iMRenderCardEnv, str, this.mStatusCallback);
        } else {
            IMLog.m10021e(f11307a, C4786I.m9980t("view @", view.getClass().getCanonicalName(), "@ not implement interface IIMPluginCardView."));
        }
    }

    public void clear() {
        super.clear();
        this.mStatusCallback = null;
        SparseArray<Class<? extends View>> sparseArray = this.f11308b;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }
}
