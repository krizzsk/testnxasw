package com.didichuxing.comp.telecom.biz.p177ui.notitication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipBusinessActivity;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.base.ICall;
import com.didichuxing.comp.telecom.core.voip.RoomInfo;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import org.apache.commons.p074io.IOUtils;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u001f\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001dJ\u0012\u0010!\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/notitication/VoipNotificationHelper;", "", "()V", "INCOME_CHANNEL_ID", "", "INCOME_CHANNEL_NAME", "INCOME_SHOW_ID", "", "INCOME_SHOW_TAG", "STATE_CHANNEL_ID", "STATE_CHANNEL_NAME", "STATE_SHOW_ID", "STATE_SHOW_TAG", "TAG", "incomeCallShowing", "", "mNotificationManager", "Landroid/app/NotificationManager;", "stateShowing", "clearIncomeCallNotification", "", "clearStateNotification", "createCallIncomeChannel", "createStateChannel", "genInComeNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "model", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "getNotificationManager", "showIncomeCallNotification", "data", "showStateNotification", "Companion", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.notitication.VoipNotificationHelper */
/* compiled from: VoipNotificationHelper.kt */
public final class VoipNotificationHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final Lazy f48955m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VoipNotificationHelper$Companion$sInstance$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f48956a = "NotificationHelper";

    /* renamed from: b */
    private NotificationManager f48957b;

    /* renamed from: c */
    private final String f48958c;

    /* renamed from: d */
    private final String f48959d;

    /* renamed from: e */
    private String f48960e;

    /* renamed from: f */
    private int f48961f;

    /* renamed from: g */
    private boolean f48962g;

    /* renamed from: h */
    private final String f48963h;

    /* renamed from: i */
    private final String f48964i;

    /* renamed from: j */
    private String f48965j;

    /* renamed from: k */
    private int f48966k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f48967l;

    @JvmStatic
    public static final VoipNotificationHelper getInstance() {
        return Companion.getInstance();
    }

    public VoipNotificationHelper() {
        CallManager.bindCallListener$default(CallManager.Companion.getInstance(), new Object(this) {
            final /* synthetic */ VoipNotificationHelper this$0;

            {
                this.this$0 = r1;
            }

            public void notifyStateDes(String str) {
                VoipCallListener.DefaultImpls.notifyStateDes(this, str);
            }

            public void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i) {
                Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
                VoipCallListener.DefaultImpls.onAudioDeviceChange(this, voipAudioCall, i);
            }

            public void onMicStateChange(VoipAudioCall voipAudioCall, boolean z) {
                Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipAudioCall");
                VoipCallListener.DefaultImpls.onMicStateChange(this, voipAudioCall, z);
            }

            public void onCallCreate(ICall iCall) {
                Intrinsics.checkParameterIsNotNull(iCall, "newCall");
                CallLogUtil.logI(this.this$0.f48956a, "onCallCreate - show notification");
                if (!(iCall instanceof VoipAudioCall)) {
                    iCall = null;
                }
                VoipAudioCall voipAudioCall = (VoipAudioCall) iCall;
                if (voipAudioCall != null) {
                    VoipAudioCall.bindCallListener$default(voipAudioCall, this, (LifecycleOwner) null, false, 6, (Object) null);
                }
            }

            public void onCallDestroy(ICall iCall) {
                CallLogUtil.logI(this.this$0.f48956a, "onCallDestroy - clear notification on call destroy");
                if (!(iCall instanceof VoipAudioCall)) {
                    iCall = null;
                }
                VoipAudioCall voipAudioCall = (VoipAudioCall) iCall;
                if (voipAudioCall != null) {
                    voipAudioCall.unbindCallListener(this);
                }
                this.this$0.clearIncomeCallNotification();
                this.this$0.clearStateNotification();
            }

            public void onStateChange(VoipAudioCall voipAudioCall, CallState callState) {
                Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkParameterIsNotNull(callState, "state");
                String access$getTAG$p = this.this$0.f48956a;
                CallLogUtil.logI(access$getTAG$p, "onStateChange - " + callState);
                if (!CallStateKt.inInitState(callState) && !this.this$0.f48967l) {
                    this.this$0.showStateNotification(voipAudioCall.getModel());
                }
            }
        }, (LifecycleOwner) null, 2, (Object) null);
        this.f48958c = "VOIP_CALL_INCOME";
        this.f48959d = "VOIP_CALL_INCOME";
        this.f48960e = "voip_income";
        this.f48961f = 101;
        this.f48963h = "VOIP_CALL_STATE";
        this.f48964i = "VOIP_CALL_STATE";
        this.f48965j = "voip_state";
        this.f48966k = 102;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/notitication/VoipNotificationHelper$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/biz/ui/notitication/VoipNotificationHelper;", "getSInstance", "()Lcom/didichuxing/comp/telecom/biz/ui/notitication/VoipNotificationHelper;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "notifyIncomeCall", "", "context", "Landroid/content/Context;", "data", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.notitication.VoipNotificationHelper$Companion */
    /* compiled from: VoipNotificationHelper.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/biz/ui/notitication/VoipNotificationHelper;"))};

        private final VoipNotificationHelper getSInstance() {
            Lazy access$getSInstance$cp = VoipNotificationHelper.f48955m;
            Companion companion = VoipNotificationHelper.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (VoipNotificationHelper) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final VoipNotificationHelper getInstance() {
            return getSInstance();
        }

        public final void notifyIncomeCall(Context context, VoipCallModel voipCallModel) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(voipCallModel, "data");
            getSInstance().showIncomeCallNotification(context, voipCallModel);
        }
    }

    /* renamed from: a */
    private final NotificationManager m36733a() {
        NotificationManager notificationManager = this.f48957b;
        if (notificationManager != null) {
            return notificationManager;
        }
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            Object systemService = appContext.getSystemService("notification");
            if (systemService != null) {
                this.f48957b = (NotificationManager) systemService;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
            }
        }
        return this.f48957b;
    }

    /* renamed from: b */
    private final void m36734b() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null && Build.VERSION.SDK_INT >= 26) {
            Uri parse = Uri.parse("android.resource://" + appContext.getPackageName() + IOUtils.DIR_SEPARATOR_UNIX + R.raw.call_ringtone);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(\"${ContentReso…/${R.raw.call_ringtone}\")");
            NotificationChannel notificationChannel = new NotificationChannel(this.f48958c, this.f48959d, 4);
            notificationChannel.setSound(parse, new AudioAttributes.Builder().setUsage(6).setContentType(4).build());
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{500, 500, 500, 500});
            NotificationManager a = m36733a();
            if (a != null) {
                a.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static /* synthetic */ void showIncomeCallNotification$default(VoipNotificationHelper voipNotificationHelper, Context context, VoipCallModel voipCallModel, int i, Object obj) {
        if ((i & 2) != 0) {
            voipCallModel = null;
        }
        voipNotificationHelper.showIncomeCallNotification(context, voipCallModel);
    }

    public final void showIncomeCallNotification(Context context, VoipCallModel voipCallModel) {
        CallLogUtil.logI(this.f48956a, "showIncomeCallNotification");
        if (context != null && voipCallModel != null) {
            this.f48962g = true;
            m36734b();
            Notification a = m36731a(context, voipCallModel);
            NotificationManager a2 = m36733a();
            if (a2 != null) {
                a2.notify(this.f48960e, this.f48961f, a);
            }
        }
    }

    public final void clearIncomeCallNotification() {
        this.f48962g = false;
        CallLogUtil.logI(this.f48956a, "clearIncomeCallNotification");
        NotificationManager a = m36733a();
        if (a != null) {
            a.cancel(this.f48960e, this.f48961f);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Notification m36732a(VoipNotificationHelper voipNotificationHelper, Context context, VoipCallModel voipCallModel, int i, Object obj) {
        if ((i & 2) != 0) {
            voipCallModel = null;
        }
        return voipNotificationHelper.m36731a(context, voipCallModel);
    }

    /* renamed from: a */
    private final Notification m36731a(Context context, VoipCallModel voipCallModel) {
        String str;
        NotificationCompat.Builder builder;
        PendingIntent pendingIntent;
        RoomInfo roomInfo;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.voip_biz_notification_income_call);
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Integer num = instance.getResources().get("voip_call_notification_logo");
        int intValue = num != null ? num.intValue() : -1;
        if (intValue > 0) {
            remoteViews.setImageViewResource(R.id.avatar, intValue);
        }
        remoteViews.setImageViewResource(R.id.callIcon, R.drawable.voip_biz_notification_small_icon);
        if (voipCallModel == null || (roomInfo = voipCallModel.getRoomInfo()) == null || (str = roomInfo.getOppositeNickname()) == null) {
            str = " ";
        }
        remoteViews.setTextViewText(R.id.oppositeName, str);
        remoteViews.setTextViewText(R.id.callText, context.getString(R.string.GDriver_IBT_Answering_Internet_sxJg));
        Uri parse = Uri.parse("android.resource://" + context.getPackageName() + IOUtils.DIR_SEPARATOR_UNIX + R.raw.call_ringtone);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(\"${ContentReso…/${R.raw.call_ringtone}\")");
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new NotificationCompat.Builder(context, this.f48958c);
        } else {
            builder = new NotificationCompat.Builder(context);
        }
        Intent buildIncomeIntent$default = VoipBusinessActivity.Companion.buildIncomeIntent$default(VoipBusinessActivity.Companion, context, (VoipCallModel) null, 2, (Object) null);
        if (Build.VERSION.SDK_INT < 31) {
            pendingIntent = PendingIntent.getActivity(context, 0, buildIncomeIntent$default, 268435456);
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, buildIncomeIntent$default, 335544320);
        }
        builder.setSmallIcon((int) R.drawable.voip_biz_notification_small_icon).setContent(remoteViews).setCategory(NotificationCompat.CATEGORY_CALL).setOngoing(true).setAutoCancel(false).setSound(parse).setVibrate(new long[]{500, 500, 500, 500}).setContentIntent(pendingIntent).setFullScreenIntent(pendingIntent, true);
        if (Build.VERSION.SDK_INT < 26) {
            builder.setPriority(1);
        }
        Notification build = builder.build();
        build.flags = 6;
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.build().apply {\n…G_ONGOING_EVENT\n        }");
        return build;
    }

    /* renamed from: c */
    private final void m36735c() {
        NotificationManager a = m36733a();
        if (a != null && Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(this.f48963h, this.f48964i, 3);
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
            a.createNotificationChannel(notificationChannel);
        }
    }

    public static /* synthetic */ void showStateNotification$default(VoipNotificationHelper voipNotificationHelper, VoipCallModel voipCallModel, int i, Object obj) {
        if ((i & 1) != 0) {
            voipCallModel = null;
        }
        voipNotificationHelper.showStateNotification(voipCallModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r8 = r8.getRoomInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showStateNotification(com.didichuxing.comp.telecom.core.voip.VoipCallModel r8) {
        /*
            r7 = this;
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r1 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.content.Context r0 = r0.getAppContext()
            if (r0 == 0) goto L_0x009b
            r1 = 1
            r7.f48967l = r1
            java.lang.String r2 = r7.f48956a
            java.lang.String r3 = "showStateNotification"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r2, r3)
            r7.m36735c()
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipBusinessActivity$Companion r2 = com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipBusinessActivity.Companion
            android.content.Intent r2 = r2.buildResumeIntent(r0, r8)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            r5 = 0
            if (r3 >= r4) goto L_0x0030
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r0, r5, r2, r3)
            goto L_0x0036
        L_0x0030:
            r3 = 335544320(0x14000000, float:6.4623485E-27)
            android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r0, r5, r2, r3)
        L_0x0036:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r3 < r4) goto L_0x0044
            androidx.core.app.NotificationCompat$Builder r3 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r6 = r7.f48963h
            r3.<init>((android.content.Context) r0, (java.lang.String) r6)
            goto L_0x0049
        L_0x0044:
            androidx.core.app.NotificationCompat$Builder r3 = new androidx.core.app.NotificationCompat$Builder
            r3.<init>(r0)
        L_0x0049:
            r6 = 2131236092(0x7f0814fc, float:1.8088396E38)
            androidx.core.app.NotificationCompat$Builder r6 = r3.setSmallIcon((int) r6)
            if (r8 == 0) goto L_0x005d
            com.didichuxing.comp.telecom.core.voip.RoomInfo r8 = r8.getRoomInfo()
            if (r8 == 0) goto L_0x005d
            java.lang.String r8 = r8.getOppositeNickname()
            goto L_0x005e
        L_0x005d:
            r8 = 0
        L_0x005e:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            androidx.core.app.NotificationCompat$Builder r8 = r6.setContentText(r8)
            r6 = 2131952251(0x7f13027b, float:1.954094E38)
            java.lang.String r0 = r0.getString(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            androidx.core.app.NotificationCompat$Builder r8 = r8.setContentText(r0)
            androidx.core.app.NotificationCompat$Builder r8 = r8.setContentIntent(r2)
            androidx.core.app.NotificationCompat$Builder r8 = r8.setOngoing(r1)
            androidx.core.app.NotificationCompat$Builder r8 = r8.setAutoCancel(r5)
            r8.build()
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 >= r4) goto L_0x0087
            r3.setPriority(r1)
        L_0x0087:
            android.app.Notification r8 = r3.build()
            r0 = 2
            r8.flags = r0
            android.app.NotificationManager r0 = r7.m36733a()
            if (r0 == 0) goto L_0x009b
            java.lang.String r1 = r7.f48965j
            int r2 = r7.f48966k
            r0.notify(r1, r2, r8)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p177ui.notitication.VoipNotificationHelper.showStateNotification(com.didichuxing.comp.telecom.core.voip.VoipCallModel):void");
    }

    public final void clearStateNotification() {
        this.f48967l = false;
        CallLogUtil.logI(this.f48956a, "clearStateNotification");
        NotificationManager a = m36733a();
        if (a != null) {
            a.cancel(this.f48965j, this.f48966k);
        }
    }
}
