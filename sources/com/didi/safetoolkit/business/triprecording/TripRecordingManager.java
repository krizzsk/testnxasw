package com.didi.safetoolkit.business.triprecording;

import android.app.Activity;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
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

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0011\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\tJ\b\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\rJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\rJ\u0006\u0010)\u001a\u00020\u001cJ\u0006\u0010*\u001a\u00020\u001cJ\u0006\u0010+\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo148868d2 = {"Lcom/didi/safetoolkit/business/triprecording/TripRecordingManager;", "", "()V", "_tag", "", "mDurationChangedListener", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$DurationChangedListener;", "mDurationListenerList", "", "Lcom/didi/safetoolkit/business/triprecording/DurationListener;", "mIsRecording", "", "mOutRecordListener", "Lcom/didi/safetoolkit/business/triprecording/RecordListenerImpl;", "mRecordErrorListener", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$OnErrorListener;", "mRecordListener", "com/didi/safetoolkit/business/triprecording/TripRecordingManager$mRecordListener$1", "Lcom/didi/safetoolkit/business/triprecording/TripRecordingManager$mRecordListener$1;", "mRecordingModel", "Lcom/didi/safetoolkit/business/triprecording/RecordingModel;", "formatDuration", "durationSeconds", "", "getBussinessCallback", "Lcom/didi/safetoolkit/api/ISFTripRecordingService;", "isRecording", "permission", "", "context", "Landroid/app/Activity;", "recoveryRecord", "removeDurationListener", "listener", "resumeUploadTasks", "setDurationListener", "setListener", "setModel", "oid", "start", "startAndPermission", "stop", "stopAndUpload", "updateListener", "Companion", "safe-toolkit_passengerRelease"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: TripRecordingManager.kt */
public final class TripRecordingManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Lazy f37248i = LazyKt.lazy(TripRecordingManager$Companion$instance$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f37249a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecordingModel f37250b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<DurationListener> f37251c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecordListenerImpl f37252d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f37253e;

    /* renamed from: f */
    private final AudioRecorder.DurationChangedListener f37254f;

    /* renamed from: g */
    private final AudioRecorder.OnErrorListener f37255g;

    /* renamed from: h */
    private final TripRecordingManager$mRecordListener$1 f37256h;

    private TripRecordingManager() {
        this.f37249a = "Trip-recording";
        this.f37251c = new ArrayList();
        this.f37254f = new TripRecordingManager$mDurationChangedListener$1(this);
        this.f37255g = new TripRecordingManager$mRecordErrorListener$1(this);
        this.f37256h = new TripRecordingManager$mRecordListener$1(this);
        ISFTripRecordingService bussinessCallback = getBussinessCallback();
        String alias = bussinessCallback != null ? bussinessCallback.getAlias() : null;
        if (!TextUtil.isEmpty(alias)) {
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            Intrinsics.checkExpressionValueIsNotNull(audioRecordManager, "AudioRecordManager.get()");
            audioRecordManager.setBusinessAlias(alias);
            m28103a();
        }
    }

    public /* synthetic */ TripRecordingManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/safetoolkit/business/triprecording/TripRecordingManager$Companion;", "", "()V", "instance", "Lcom/didi/safetoolkit/business/triprecording/TripRecordingManager;", "getInstance", "()Lcom/didi/safetoolkit/business/triprecording/TripRecordingManager;", "instance$delegate", "Lkotlin/Lazy;", "safe-toolkit_passengerRelease"}, mo148869k = 1, mo148870mv = {1, 1, 15})
    /* compiled from: TripRecordingManager.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/didi/safetoolkit/business/triprecording/TripRecordingManager;"))};

        public final TripRecordingManager getInstance() {
            Lazy access$getInstance$cp = TripRecordingManager.f37248i;
            Companion companion = TripRecordingManager.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (TripRecordingManager) access$getInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isRecording() {
        return this.f37253e;
    }

    public final void start(String str, RecordListenerImpl recordListenerImpl) {
        Intrinsics.checkParameterIsNotNull(str, "oid");
        if (!this.f37253e) {
            m28104a(str);
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            Intrinsics.checkExpressionValueIsNotNull(audioRecordManager, "AudioRecordManager.get()");
            if (audioRecordManager.isRecording()) {
                AudioRecordManager.get().resumeRecord();
            } else {
                AudioRecordManager.get().startRecord();
            }
            this.f37252d = recordListenerImpl;
            SfLog.m28138i(this.f37249a, "Recording start");
        } else if (recordListenerImpl != null) {
            recordListenerImpl.onAlreadyStart();
        }
    }

    public final void stop() {
        AudioRecordManager.get().stopRecord();
        SPUtils.put(SfContextHelper.getContext(), "current_recording_order_oid", "");
        SfLog.m28138i(this.f37249a, "Recording stop");
    }

    public final void resumeUploadTasks() {
        AudioRecordManager.get().resumeUploadTasks();
        SfLog.m28138i(this.f37249a, "Recording resumeUploadTasks");
    }

    public final void stopAndUpload() {
        stop();
        resumeUploadTasks();
        SfLog.m28138i(this.f37249a, "Recording stopAndUpload");
    }

    public final void setDurationListener(DurationListener durationListener) {
        Intrinsics.checkParameterIsNotNull(durationListener, "listener");
        this.f37251c.add(durationListener);
    }

    public final void removeDurationListener(DurationListener durationListener) {
        Intrinsics.checkParameterIsNotNull(durationListener, "listener");
        this.f37251c.remove(durationListener);
    }

    public final ISFTripRecordingService getBussinessCallback() {
        return (ISFTripRecordingService) ServiceLoader.load(ISFTripRecordingService.class, SafeToolKit.getIns().getBusinessType()).get();
    }

    /* renamed from: a */
    private final void m28104a(String str) {
        RecordingModel recordingModel = this.f37250b;
        if (!Intrinsics.areEqual((Object) str, (Object) recordingModel != null ? recordingModel.getOid() : null)) {
            this.f37250b = new RecordingModel(str);
            SPUtils.put(SfContextHelper.getContext(), "current_recording_order_oid", str);
        }
    }

    public final void updateListener() {
        m28103a();
    }

    /* renamed from: a */
    private final void m28103a() {
        if (!SfApolloUtil.isNewSafe()) {
            AudioRecordManager audioRecordManager = AudioRecordManager.get();
            audioRecordManager.setRecordListener(this.f37256h);
            audioRecordManager.setDurationChangedListener(this.f37254f);
            audioRecordManager.setOnErrorListener(this.f37255g);
            audioRecordManager.setUploadListener(new TripRecordingManager$setListener$$inlined$apply$lambda$1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m28102a(int i) {
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
        if (!this.f37253e) {
            String str = null;
            SafeToolKit ins = SafeToolKit.getIns();
            Intrinsics.checkExpressionValueIsNotNull(ins, "SafeToolKit.getIns()");
            ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, ins.getBusinessType()).get();
            if (iSfInfoService != null) {
                str = iSfInfoService.getCarOrderId();
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
        SafeToolKit ins = SafeToolKit.getIns();
        Intrinsics.checkExpressionValueIsNotNull(ins, "SafeToolKit.getIns()");
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, ins.getBusinessType()).get();
        if (iSfInfoService != null) {
            str = iSfInfoService.getCarOrderId();
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
