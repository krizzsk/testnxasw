package com.didi.beatles.p101im.access.notify.decorfloat.wrapper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMPushEngine;
import com.didi.beatles.p101im.access.notify.IMFloatWindowController;
import com.didi.beatles.p101im.access.notify.NotificationUtils;
import com.didi.beatles.p101im.access.notify.decorfloat.IIMDecorFloatMsg;
import com.didi.beatles.p101im.access.notify.decorfloat.view.IMFloatMessageCard;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import java.util.ArrayList;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.wrapper.IMFloatMessageWrapper */
public class IMFloatMessageWrapper implements IIMDecorFloatMsg<IMMessage> {

    /* renamed from: a */
    private static final String f10670a = IMFloatMessageWrapper.class.getSimpleName();

    /* renamed from: b */
    private static final int f10671b = 400;

    /* renamed from: c */
    private static final int f10672c = 200;

    /* renamed from: d */
    private static final int f10673d = 5000;

    /* renamed from: e */
    private final IMMessage f10674e;

    public long getDisplayDuration() {
        return 5000;
    }

    public IMFloatMessageWrapper(IMMessage iMMessage) {
        this.f10674e = iMMessage;
    }

    public IMMessage getData() {
        return this.f10674e;
    }

    public boolean canShowFloat(Activity activity) {
        if (!IMFloatWindowController.isEnable()) {
            return false;
        }
        if (IMEngine.getInstance(activity).getCurrentBusinessConfig(this.f10674e.getSidType(), this.f10674e.getBusinessId()).isOpenGlobalAlert() && IMPushEngine.isInApplication() && !IMPushEngine.inThisMessagePage(this.f10674e)) {
            return true;
        }
        return false;
    }

    public boolean showNotification() {
        IMLog.m10020d(f10670a, "[showNotification]");
        Context context = IMCommonContextInfoHelper.getContext();
        if (context == null) {
            return false;
        }
        NotificationUtils.showPushMsgNotification(context, this.f10674e, new NotificationUtils.NotificationConfig(this.f10674e), true);
        return true;
    }

    public View getView(Activity activity, IIMDecorFloatMsg.RequestCallback requestCallback) {
        IMFloatMessageCard iMFloatMessageCard = new IMFloatMessageCard(activity);
        iMFloatMessageCard.setRequestCallback(requestCallback);
        iMFloatMessageCard.bind(this.f10674e);
        return iMFloatMessageCard;
    }

    public Animator getEnterAnimator(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-IMViewUtil.dp2px(view.getContext(), 78.0f)), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    public Animator getExitAnimator(View view) {
        int dp2px = IMViewUtil.dp2px(view.getContext(), 78.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, (float) (-dp2px)}));
        arrayList.add(ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}));
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        return animatorSet;
    }
}
