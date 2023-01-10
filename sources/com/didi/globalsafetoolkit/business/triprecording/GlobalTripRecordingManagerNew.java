package com.didi.globalsafetoolkit.business.triprecording;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.TextUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0012\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\nJ\b\u0010%\u001a\u00020\u001dH\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ \u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010*\u001a\u00020\u001dJ\u0006\u0010+\u001a\u00020\u001dJ\u0006\u0010,\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew;", "", "()V", "_tag", "", "curDuration", "mDurationChangedListener", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$DurationChangedListener;", "mDurationListenerList", "", "Lcom/didi/globalsafetoolkit/business/triprecording/DurationListener;", "mIsRecording", "", "mOutRecordListener", "Lcom/didi/globalsafetoolkit/business/triprecording/RecordListenerImpl;", "mRecordErrorListener", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$OnErrorListener;", "mRecordListener", "com/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew$mRecordListener$1", "Lcom/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew$mRecordListener$1;", "mRecordingModel", "Lcom/didi/globalsafetoolkit/business/triprecording/RecordingModel;", "formatDuration", "durationSeconds", "", "getDuration", "getState", "isRecording", "permission", "", "context", "Landroid/app/Activity;", "recoveryRecord", "removeDurationListener", "listener", "resumeUploadTasks", "setDurationListener", "setListener", "setModel", "oid", "start", "startAndPermission", "stop", "stopAndUpload", "updateListener", "Companion", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: GlobalTripRecordingManagerNew.kt */
public final class GlobalTripRecordingManagerNew {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Lazy f25120j = LazyKt.lazy(GlobalTripRecordingManagerNew$Companion$instance$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f25121a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecordingModel f25122b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<DurationListener> f25123c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecordListenerImpl f25124d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f25125e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f25126f;

    /* renamed from: g */
    private final AudioRecorder.DurationChangedListener f25127g;

    /* renamed from: h */
    private final AudioRecorder.OnErrorListener f25128h;

    /* renamed from: i */
    private final GlobalTripRecordingManagerNew$mRecordListener$1 f25129i;

    private GlobalTripRecordingManagerNew() {
        this.f25121a = "Trip-recording";
        this.f25123c = new ArrayList();
        this.f25126f = "00:00:00";
        this.f25127g = new GlobalTripRecordingManagerNew$mDurationChangedListener$1(this);
        this.f25128h = new GlobalTripRecordingManagerNew$mRecordErrorListener$1(this);
        this.f25129i = new GlobalTripRecordingManagerNew$mRecordListener$1(this);
        String alias = GlobalSfBusinessInterface.getAlias();
        if (!TextUtil.isEmpty(alias)) {
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            Intrinsics.checkExpressionValueIsNotNull(audioRecordManager, "AudioRecordManager.get()");
            audioRecordManager.setBusinessAlias(alias);
            m20112a();
            setDurationListener(new DurationListener(this) {
                final /* synthetic */ GlobalTripRecordingManagerNew this$0;

                {
                    this.this$0 = r1;
                }

                public void onCallback(String str) {
                    Intrinsics.checkParameterIsNotNull(str, "duration");
                    this.this$0.f25126f = str;
                }
            });
        }
    }

    public /* synthetic */ GlobalTripRecordingManagerNew(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getDuration() {
        return this.f25126f;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew$Companion;", "", "()V", "instance", "Lcom/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew;", "getInstance", "()Lcom/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew;", "instance$delegate", "Lkotlin/Lazy;", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
    /* compiled from: GlobalTripRecordingManagerNew.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew;"))};

        public final GlobalTripRecordingManagerNew getInstance() {
            Lazy access$getInstance$cp = GlobalTripRecordingManagerNew.f25120j;
            Companion companion = GlobalTripRecordingManagerNew.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (GlobalTripRecordingManagerNew) access$getInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getState() {
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        String oid = businessInfo != null ? businessInfo.getOid() : null;
        GlobalSfManager instance = GlobalSfManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "GlobalSfManager.getInstance()");
        if (instance.isCanRecord()) {
            if (isRecording()) {
                return "2";
            }
            if (!TextUtils.isEmpty(oid)) {
                return "1";
            }
        }
        return "0";
    }

    public final boolean isRecording() {
        return this.f25125e;
    }

    public final void start(String str, RecordListenerImpl recordListenerImpl) {
        Intrinsics.checkParameterIsNotNull(str, "oid");
        if (!this.f25125e) {
            m20113a(str);
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            Intrinsics.checkExpressionValueIsNotNull(audioRecordManager, "AudioRecordManager.get()");
            if (audioRecordManager.isRecording()) {
                AudioRecordManager.get().resumeRecord();
            } else {
                AudioRecordManager.get().startRecord();
            }
            this.f25124d = recordListenerImpl;
            SfLog.m20152i(this.f25121a, "Recording start");
        } else if (recordListenerImpl != null) {
            recordListenerImpl.onAlreadyStart();
        }
    }

    public final void stop() {
        AudioRecordManager.get().stopRecord();
        SPUtils.put(SfContextHelper.getContext(), "current_recording_order_oid", "");
        SfLog.m20152i(this.f25121a, "Recording stop");
    }

    public final void resumeUploadTasks() {
        AudioRecordManager.get().resumeUploadTasks();
        SfLog.m20152i(this.f25121a, "Recording resumeUploadTasks");
    }

    public final void stopAndUpload() {
        stop();
        resumeUploadTasks();
        SfLog.m20152i(this.f25121a, "Recording stopAndUpload");
    }

    public final void setDurationListener(DurationListener durationListener) {
        Intrinsics.checkParameterIsNotNull(durationListener, "listener");
        this.f25123c.add(durationListener);
    }

    public final void removeDurationListener(DurationListener durationListener) {
        Intrinsics.checkParameterIsNotNull(durationListener, "listener");
        this.f25123c.remove(durationListener);
    }

    /* renamed from: a */
    private final void m20113a(String str) {
        RecordingModel recordingModel = this.f25122b;
        if (!Intrinsics.areEqual((Object) str, (Object) recordingModel != null ? recordingModel.getOid() : null)) {
            this.f25122b = new RecordingModel(str);
            SPUtils.put(SfContextHelper.getContext(), "current_recording_order_oid", str);
        }
    }

    public final void updateListener() {
        m20112a();
    }

    /* renamed from: a */
    private final void m20112a() {
        AudioRecordManager audioRecordManager = AudioRecordManager.get();
        audioRecordManager.setRecordListener(this.f25129i);
        audioRecordManager.setDurationChangedListener(this.f25127g);
        audioRecordManager.setOnErrorListener(this.f25128h);
        audioRecordManager.setUploadListener(new C9552x9ca06cd1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m20111a(int i) {
        int i2 = i > 3600 ? i / 3600 : 0;
        int i3 = i % 3600;
        int i4 = i3 > 60 ? i3 / 60 : 0;
        StringBuilder sb = new StringBuilder();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        sb.append(format);
        sb.append(':');
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        Locale locale2 = Locale.ENGLISH;
        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ENGLISH");
        String format2 = String.format(locale2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(locale, format, *args)");
        sb.append(format2);
        sb.append(':');
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        Locale locale3 = Locale.ENGLISH;
        Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.ENGLISH");
        String format3 = String.format(locale3, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i3 % 60)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format3, "java.lang.String.format(locale, format, *args)");
        sb.append(format3);
        return sb.toString();
    }

    public final void recoveryRecord(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        if (!this.f25125e) {
            String str = null;
            SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
            if (businessInfo != null) {
                str = businessInfo.getOid();
            }
            Object obj = SPUtils.get(SfContextHelper.getContext(), "current_recording_order_oid", "");
            if (str != null && str.equals(obj)) {
                startAndPermission(activity, str, (RecordListenerImpl) null);
            }
        }
    }

    public final void startAndPermission(Activity activity, String str, RecordListenerImpl recordListenerImpl) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        Intrinsics.checkParameterIsNotNull(str, "oid");
        if (!SfPermissionActivity.Companion.permission(activity, str) && !TextUtil.isEmpty(str)) {
            start(str, recordListenerImpl);
        }
    }

    public final void startAndPermission(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        String str = null;
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            str = businessInfo.getOid();
        }
        if (str != null) {
            startAndPermission(activity, str, (RecordListenerImpl) null);
        }
    }

    public final void permission(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        SfPermissionActivity.Companion.permission(activity, "");
    }
}
