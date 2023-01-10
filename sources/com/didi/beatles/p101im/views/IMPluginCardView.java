package com.didi.beatles.p101im.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;

/* renamed from: com.didi.beatles.im.views.IMPluginCardView */
public class IMPluginCardView extends IMBaseRenderView {

    /* renamed from: a */
    private static final String f11753a = IMPluginCardView.class.getSimpleName();

    /* access modifiers changed from: protected */
    public void onFindViewById() {
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public IMPluginCardView(Context context, int i, MessageAdapter messageAdapter, boolean z) {
        super(context, i, messageAdapter, z);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        String str = f11753a;
        IMLog.m10020d(str, "[onSetUpView]" + toString());
        m10083a();
    }

    /* renamed from: a */
    private void m10083a() {
        IMMessageDownExtend parsedMessageExtend = this.message.getParsedMessageExtend();
        if (parsedMessageExtend == null) {
            IMLog.m10020d(f11753a, "[handleEggsEffect] #NULL MESSAGE EXTEND#");
        } else if (parsedMessageExtend.getEid() <= 0) {
            IMLog.m10020d(f11753a, "[handleEggsEffect] #INVALID EID#");
        } else if (parsedMessageExtend.getEggsDisplayCount() > 0) {
            IMLog.m10020d(f11753a, "[handleEggsEffect] #ALREADY DISPLAY#");
        } else {
            IIMGlobalModule globalModel = IMManager.getInstance().getGlobalModel();
            if (globalModel != null) {
                IMConfig.EggsInfo businessEggsInfo = globalModel.getBusinessEggsInfo(this.message.getBusinessId(), parsedMessageExtend.eid);
                parsedMessageExtend.setEggsDisplayCount(1);
                this.message.setMessageExtendInfo(parsedMessageExtend);
                IMManager.getInstance().updateMessage(this.message);
                IMLog.m10020d(f11753a, "[handleEggsEffect] #render eggs#");
                if (businessEggsInfo != null && this.itemListener != null) {
                    this.itemListener.onEggsMsgRender(businessEggsInfo);
                }
            }
        }
    }
}
