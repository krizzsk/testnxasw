package com.didi.beatles.p101im.protocol.plugin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.beatles.p101im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p101im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p101im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.protocol.plugin.widget.IMPluginCardLinearLayout */
public abstract class IMPluginCardLinearLayout extends LinearLayout implements IIMPluginCardView {

    /* renamed from: a */
    private int f11412a;

    /* renamed from: b */
    private IMMessageViewStatusCallback f11413b;

    public abstract boolean isShowInMiddle();

    public abstract void onBindData(String str);

    public abstract void onCardClick(View view);

    public IMPluginCardLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPluginCardLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPluginCardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11412a = -1;
    }

    public final void onBind(int i, IMRenderCardEnv iMRenderCardEnv, String str, IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.f11412a = i;
        this.f11413b = iMMessageViewStatusCallback;
        onBindData(str);
    }

    /* access modifiers changed from: protected */
    public final void executeUpdateData(String str) {
        int i;
        IMMessageViewStatusCallback iMMessageViewStatusCallback = this.f11413b;
        if (iMMessageViewStatusCallback == null || (i = this.f11412a) == -1) {
            String simpleName = getClass().getSimpleName();
            IMLog.m10021e(simpleName, "[executeUpdateData] invalid callback or position. position=" + this.f11412a);
            return;
        }
        iMMessageViewStatusCallback.onUpdate(i, str);
    }

    /* access modifiers changed from: protected */
    public final void executeDeleteMessage() {
        int i;
        IMMessageViewStatusCallback iMMessageViewStatusCallback = this.f11413b;
        if (iMMessageViewStatusCallback == null || (i = this.f11412a) == -1) {
            String simpleName = getClass().getSimpleName();
            IMLog.m10021e(simpleName, "[executeDeleteMessage] invalid callback or position. position=" + this.f11412a);
            return;
        }
        iMMessageViewStatusCallback.deleteMessage(i);
    }
}
