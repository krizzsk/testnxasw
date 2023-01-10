package com.didi.map.global.sctx.event_reveal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.PatternsCompat;
import com.bumptech.glide.Glide;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.event_reveal.TriggeredTrafficEventShowModel;
import com.didi.map.global.sctx.event_verify.TrafficEventVerifyRepository;
import com.didi.map.google.util.ApolloUtils;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.event.ButtonInfo;
import com.didi.map.sdk.proto.driver_gl.event.ButtonModeInfo;
import com.didi.map.sdk.proto.driver_gl.event.EventShowRes;
import com.didi.map.sdk.proto.driver_gl.event.FeedCard;
import com.didi.map.sdk.proto.driver_gl.event.ShowEvent;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.store.PoiStore;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Typography;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(mo148867d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002wxB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014H\u0002J4\u0010<\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010>\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u00020/\u0018\u00010?H\u0002J\u0006\u0010@\u001a\u00020/J\\\u0010A\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010C\u0012\u0004\u0012\u00020\u0018\u0018\u00010B2\b\u0010D\u001a\u0004\u0018\u00010E2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010G2\u0006\u0010H\u001a\u00020\u00182 \b\u0002\u0010I\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0006\u0012\u0004\u0018\u00010C\u0012\u0004\u0012\u00020\u001e\u0018\u00010JH\u0002J\u0014\u0010K\u001a\u00020/2\n\u0010L\u001a\u00060Mj\u0002`NH\u0002J\u0010\u0010O\u001a\u00020/2\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010P\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0014J\b\u0010R\u001a\u00020/H\u0002J\u0006\u0010S\u001a\u00020/J*\u0010T\u001a\u0002012\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020\u00102\b\u0010X\u001a\u0004\u0018\u00010YH\u0002J;\u0010Z\u001a\u00020/2\b\u0010[\u001a\u0004\u0018\u00010\u00102\b\u0010\\\u001a\u0004\u0018\u0001092\u0006\u0010]\u001a\u00020\u00142\b\u0010^\u001a\u0004\u0018\u00010\u001a2\u0006\u0010_\u001a\u00020`H\u0002¢\u0006\u0002\u0010aJ3\u0010b\u001a\u00020/2\b\u0010[\u001a\u0004\u0018\u00010\u00102\b\u0010\\\u001a\u0004\u0018\u0001092\b\u0010^\u001a\u0004\u0018\u00010\u001a2\u0006\u0010_\u001a\u00020`H\u0002¢\u0006\u0002\u0010cJ\u0018\u0010d\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010e\u001a\u00020\u001eJ\u0006\u0010f\u001a\u00020/J\b\u0010g\u001a\u00020/H\u0002J\u0006\u0010h\u001a\u00020/J\b\u0010i\u001a\u00020/H\u0002J\u001a\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020\u001e2\b\u0010l\u001a\u0004\u0018\u00010mH\u0002J\u0006\u0010n\u001a\u00020/J\b\u0010o\u001a\u00020/H\u0002J\b\u0010p\u001a\u00020/H\u0002J\u0018\u0010q\u001a\u00020/2\u000e\u0010r\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010GH\u0002J\u001a\u0010s\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010e\u001a\u00020\u001eH\u0002J\u0010\u0010t\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\f\u0010u\u001a\u000209*\u000201H\u0002J\u000e\u0010v\u001a\u0004\u0018\u00010m*\u000201H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006y"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventsController;", "", "context", "Landroid/content/Context;", "map", "Lcom/didi/common/map/Map;", "eventsRepository", "Lcom/didi/map/global/sctx/event_reveal/TrafficEventsRepository;", "verifyRepository", "Lcom/didi/map/global/sctx/event_verify/TrafficEventVerifyRepository;", "paramGetter", "Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsReqParamGetter;", "mSctxCallback", "Lcom/didi/map/global/sctx/SctxService$SctxCallback;", "(Landroid/content/Context;Lcom/didi/common/map/Map;Lcom/didi/map/global/sctx/event_reveal/TrafficEventsRepository;Lcom/didi/map/global/sctx/event_verify/TrafficEventVerifyRepository;Lcom/didi/map/global/sctx/event_reveal/ITrafficEventsReqParamGetter;Lcom/didi/map/global/sctx/SctxService$SctxCallback;)V", "EVENT_MARKER_TAG", "", "KEY_SUCCESSIVE_TRIGGER_TIMES", "KEY_SUCCESSIVE_TRIGGER_TIMESTAMP", "SHOW_DISTANCE_THRESHOLD", "", "TAG", "TRIGGER_DIALOG_SHOW_VERITY_CODE", "TRIGGER_DRIVER_ACROSS_DISTANCE", "", "eventShowRequestInterval", "", "fetchDataJob", "Lkotlinx/coroutines/Job;", "hasShownTriggeredDialog", "", "hasVerifyEventIDs", "", "isInRightZoomRange", "maxWaitTime", "onCameraChangeListener", "Lcom/didi/common/map/listener/OnCameraChangeListener;", "onMarkerClickListener", "Lcom/didi/common/map/listener/OnMarkerClickListener;", "triggerSuccessiveTimes", "triggerSuccessiveTimestamp", "triggeredEventListIDs", "", "uiCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "verifyJob", "addSingleTrafficEventMarker", "", "event", "Lcom/didi/map/sdk/proto/driver_gl/event/ShowEvent;", "iconBitmap", "Landroid/graphics/Bitmap;", "canShowTriggerDialogByFrequency", "debugEventDistanceInfo", "res", "Lcom/didi/map/sdk/proto/driver_gl/event/EventShowRes;", "doVerify", "Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;", "code", "cardType", "downloadIcon", "url", "callback", "Lkotlin/Function1;", "forceRestart", "getNearestEventMarker", "Lkotlin/Pair;", "Lcom/didi/common/map/internal/IMapElement;", "point", "Lcom/didi/common/map/model/LatLng;", "list", "", "distanceThreshold", "filter", "Lkotlin/Function2;", "handleApiError", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleEventsDataResponse", "handleTriggerVerifyDialogClick", "model", "initTriggerShowFrequency", "leave", "mockShowEvent", "eventId", "eventTitle", "subTitle", "eventPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "omegaVerifyDialogOperation", "orderId", "showEvent", "operationType", "routeId", "card_type", "Lcom/didi/map/global/sctx/event_reveal/TrafficEventsController$OmegaCardType;", "(Ljava/lang/String;Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;ILjava/lang/Long;Lcom/didi/map/global/sctx/event_reveal/TrafficEventsController$OmegaCardType;)V", "omegaVerifyDialogShow", "(Ljava/lang/String;Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;Ljava/lang/Long;Lcom/didi/map/global/sctx/event_reveal/TrafficEventsController$OmegaCardType;)V", "onMatched", "isSimulate", "pause", "recordTriggerDialogFrequency", "removeTrafficEventMarkers", "removeTriggerDialogFrequency", "showTriggerVerifyDialog", "show", "triggerDialogModel", "Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel;", "start", "startFetchEventData", "testVerifyDialog", "tryAddTrafficEventMarkers", "events", "tryShowTriggerVerifyDialog", "tryShowUserClickedVerifyDialog", "toTrafficEventModel", "toTriggerDialogShowModel", "OmegaCardType", "OmegaOperateCodeType", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsController.kt */
public final class TrafficEventsController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f30046a;

    /* renamed from: b */
    private final Map f30047b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final TrafficEventsRepository f30048c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final TrafficEventVerifyRepository f30049d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ITrafficEventsReqParamGetter f30050e;

    /* renamed from: f */
    private final SctxService.SctxCallback f30051f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final String f30052g;

    /* renamed from: h */
    private final String f30053h;

    /* renamed from: i */
    private final int f30054i;

    /* renamed from: j */
    private final double f30055j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final CoroutineScope f30056k;

    /* renamed from: l */
    private Job f30057l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Job f30058m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final int f30059n;

    /* renamed from: o */
    private final Set<Long> f30060o;

    /* renamed from: p */
    private boolean f30061p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final List<Long> f30062q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final long f30063r;

    /* renamed from: s */
    private int f30064s;

    /* renamed from: t */
    private long f30065t;

    /* renamed from: u */
    private final String f30066u;

    /* renamed from: v */
    private final String f30067v;

    /* renamed from: w */
    private final int f30068w;

    /* renamed from: x */
    private boolean f30069x;

    /* renamed from: y */
    private final OnCameraChangeListener f30070y;

    /* renamed from: z */
    private final OnMarkerClickListener f30071z;

    public TrafficEventsController(Context context, Map map, TrafficEventsRepository trafficEventsRepository, TrafficEventVerifyRepository trafficEventVerifyRepository, ITrafficEventsReqParamGetter iTrafficEventsReqParamGetter, SctxService.SctxCallback sctxCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(trafficEventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(trafficEventVerifyRepository, "verifyRepository");
        this.f30046a = context;
        this.f30047b = map;
        this.f30048c = trafficEventsRepository;
        this.f30049d = trafficEventVerifyRepository;
        this.f30050e = iTrafficEventsReqParamGetter;
        this.f30051f = sctxCallback;
        this.f30052g = "TrafficReveal";
        this.f30053h = "GLOBAL_MAP_EVENT_TAG";
        this.f30054i = ApolloUtils.getEventShowMaxDistance();
        this.f30055j = (double) ApolloUtils.getEventTriggerVerifyDistance();
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        this.f30056k = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(Dispatchers.getMain().getImmediate()));
        this.f30059n = -1;
        this.f30060o = new LinkedHashSet();
        this.f30062q = new ArrayList();
        this.f30063r = (long) ApolloUtils.getEventShowRequestInterval();
        this.f30064s = -1;
        this.f30065t = -1;
        this.f30066u = "key_successive_trigger_times";
        this.f30067v = "key_successive_trigger_timestamp";
        this.f30068w = ApolloUtils.getEventTriggerMaxWaitTime();
        this.f30069x = true;
        this.f30070y = new OnCameraChangeListener() {
            public final void onCameraChange(CameraPosition cameraPosition) {
                TrafficEventsController.m23419a(TrafficEventsController.this, cameraPosition);
            }
        };
        this.f30071z = new OnMarkerClickListener() {
            public final boolean onMarkerClick(Marker marker) {
                return TrafficEventsController.m23428a(TrafficEventsController.this, marker);
            }
        };
        this.f30047b.addOnCameraChangeListener(this.f30070y);
        this.f30047b.addOnMarkerClickListener(this.f30071z);
        m23434d();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrafficEventsController(Context context, Map map, TrafficEventsRepository trafficEventsRepository, TrafficEventVerifyRepository trafficEventVerifyRepository, ITrafficEventsReqParamGetter iTrafficEventsReqParamGetter, SctxService.SctxCallback sctxCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, map, trafficEventsRepository, trafficEventVerifyRepository, (i & 16) != 0 ? null : iTrafficEventsReqParamGetter, (i & 32) != 0 ? null : sctxCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23419a(TrafficEventsController trafficEventsController, CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(trafficEventsController, "this$0");
        StringBuilder sb = new StringBuilder();
        double d = cameraPosition.zoom;
        boolean z = false;
        if (11.0d <= d && d <= 20.0d) {
            z = true;
        }
        sb.append(Intrinsics.stringPlus("map zoom level: ", Double.valueOf(cameraPosition.zoom)));
        if (z != trafficEventsController.f30069x) {
            trafficEventsController.removeTrafficEventMarkers();
            if (z) {
                trafficEventsController.m23426a(trafficEventsController.f30048c.getTrafficEvents());
                sb.append("|try SHOW traffic events");
            } else {
                sb.append("|try HIDE traffic events");
            }
        }
        trafficEventsController.f30069x = z;
        SystemUtils.log(3, trafficEventsController.f30052g, sb.toString(), (Throwable) null, "com.didi.map.global.sctx.event_reveal.TrafficEventsController", 114);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m23428a(TrafficEventsController trafficEventsController, Marker marker) {
        Intrinsics.checkNotNullParameter(trafficEventsController, "this$0");
        if (!((marker == null ? null : marker.getData()) instanceof ShowEvent)) {
            return false;
        }
        Object data = marker.getData();
        if (data != null) {
            trafficEventsController.m23432c((ShowEvent) data);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.map.sdk.proto.driver_gl.event.ShowEvent");
    }

    public final void start() {
        Job job = this.f30057l;
        if (!Intrinsics.areEqual((Object) job == null ? null : Boolean.valueOf(job.isActive()), (Object) true)) {
            m23430b();
        }
    }

    public final void forceRestart() {
        Job job = this.f30057l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f30057l = null;
        m23430b();
    }

    /* renamed from: a */
    private final void m23414a() {
        CoroutineScope coroutineScope = this.f30056k;
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        Job unused = C2746d.m5821a(coroutineScope, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new TrafficEventsController$testVerifyDialog$1(this, (Continuation<? super TrafficEventsController$testVerifyDialog$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ShowEvent m23411a(long j, String str, String str2, DoublePoint doublePoint) {
        String str3 = str;
        ButtonInfo build = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK).buttonValue(1).buttonIndex(0).build();
        ButtonInfo build2 = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK).buttonValue(2).buttonIndex(1).build();
        FeedCard.Builder builder = new FeedCard.Builder();
        FeedCard build3 = builder.title(str3 + "{closes in " + "{{close_time}}" + 's').subTitle((String) null).secondary((String) null).cardType(1).btn(CollectionsKt.listOf(build, build2)).build();
        ButtonInfo build4 = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK).buttonValue(1).buttonIndex(0).build();
        ButtonInfo build5 = new ButtonInfo.Builder().buttonTitle(DCryptoUtils.KEY_IP_BLOCKING_STATUS_BLOCK).buttonValue(2).buttonIndex(1).build();
        FeedCard build6 = new FeedCard.Builder().title(str3).subTitle(str2).secondary("test secondary").cardType(2).btn(CollectionsKt.listOf(build4, build5)).build();
        ShowEvent build7 = new ShowEvent.Builder().eventId(Long.valueOf(j)).modeInfo(CollectionsKt.listOf(new ButtonModeInfo.Builder().buttonMode(1).buttonPicUrl("test_use_local").build())).eventTitle(str3).eventType(1).eventPoint(doublePoint).linkId(6L).card(CollectionsKt.listOf(build3, build6)).eventOper(1).reportTime(Long.valueOf(System.currentTimeMillis() / ((long) 1000))).build();
        Intrinsics.checkNotNullExpressionValue(build7, "showEvent");
        return build7;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m23427a(boolean r7, com.didi.map.global.sctx.event_reveal.TriggeredTrafficEventShowModel r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            if (r7 == 0) goto L_0x001d
            if (r8 != 0) goto L_0x0009
            r7 = r2
            goto L_0x0011
        L_0x0009:
            boolean r7 = r8.isValid()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
        L_0x0011:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            if (r7 == 0) goto L_0x001d
            r7 = 1
            goto L_0x001e
        L_0x001d:
            r7 = 0
        L_0x001e:
            java.lang.String r3 = r6.f30052g
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "trigger_verify|try "
            r4.append(r5)
            if (r7 == 0) goto L_0x002f
            java.lang.String r5 = "show"
            goto L_0x0031
        L_0x002f:
            java.lang.String r5 = "hide"
        L_0x0031:
            r4.append(r5)
            java.lang.String r5 = " trigger verify dialog"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.didi.common.map.util.DLog.m10773d(r3, r4, r0)
            com.didi.map.global.sctx.SctxService$SctxCallback r0 = r6.f30051f
            if (r0 != 0) goto L_0x0047
            goto L_0x004f
        L_0x0047:
            if (r7 == 0) goto L_0x004b
            r3 = r8
            goto L_0x004c
        L_0x004b:
            r3 = r2
        L_0x004c:
            r0.onShowTrafficEventFeedbackXpanelDialog(r7, r3)
        L_0x004f:
            if (r7 == 0) goto L_0x008d
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r7 = r6.f30050e
            if (r7 != 0) goto L_0x0057
            r7 = r2
            goto L_0x005b
        L_0x0057:
            java.lang.String r7 = r7.getOrderId()
        L_0x005b:
            if (r8 != 0) goto L_0x005f
            r0 = r2
            goto L_0x0063
        L_0x005f:
            com.didi.map.global.sctx.event_reveal.TrafficEventModel r0 = r8.getEvent()
        L_0x0063:
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r3 = r6.f30050e
            if (r3 != 0) goto L_0x0069
            r3 = r2
            goto L_0x0071
        L_0x0069:
            long r3 = r3.getCurRouteId()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0071:
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r4 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.TRIGGER_TYPE
            r6.m23425a((java.lang.String) r7, (com.didi.map.global.sctx.event_reveal.TrafficEventModel) r0, (java.lang.Long) r3, (com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType) r4)
            if (r8 != 0) goto L_0x0079
            goto L_0x007d
        L_0x0079:
            com.didi.map.global.sctx.event_reveal.TrafficEventModel r2 = r8.getEvent()
        L_0x007d:
            int r7 = r6.f30059n
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r8 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.TRIGGER_TYPE
            int r8 = r8.getType()
            r6.m23417a((com.didi.map.global.sctx.event_reveal.TrafficEventModel) r2, (int) r7, (int) r8)
            r6.f30061p = r1
            r6.m23436f()
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController.m23427a(boolean, com.didi.map.global.sctx.event_reveal.TriggeredTrafficEventShowModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final TriggeredTrafficEventShowModel m23410a(ShowEvent showEvent) {
        FeedCard feedCard;
        Object obj;
        boolean z;
        List arrayList = new ArrayList();
        List<FeedCard> list = showEvent.card;
        if (list == null) {
            feedCard = null;
        } else {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer num = ((FeedCard) obj).cardType;
                int type = OmegaCardType.TRIGGER_TYPE.getType();
                if (num != null && num.intValue() == type) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            feedCard = (FeedCard) obj;
        }
        if (feedCard == null) {
            return null;
        }
        List<ButtonInfo> list2 = feedCard.btn;
        Intrinsics.checkNotNullExpressionValue(list2, "feedcard.btn");
        for (ButtonInfo buttonInfo : list2) {
            String str = buttonInfo.buttonTitle;
            Intrinsics.checkNotNullExpressionValue(str, "btn.buttonTitle");
            Integer num2 = buttonInfo.buttonValue;
            Intrinsics.checkNotNullExpressionValue(num2, "btn.buttonValue");
            arrayList.add(new VerifyBtnModel(str, num2.intValue()));
        }
        TriggeredTrafficEventShowModel.Builder countDownTime = new TriggeredTrafficEventShowModel.Builder().setCountDownTime(10);
        String str2 = feedCard.title;
        Intrinsics.checkNotNullExpressionValue(str2, "feedcard.title");
        TriggeredTrafficEventShowModel.Builder message = countDownTime.setMessage(str2);
        Long l = showEvent.eventId;
        Intrinsics.checkNotNullExpressionValue(l, "this.eventId");
        long longValue = l.longValue();
        String str3 = showEvent.eventTitle;
        Intrinsics.checkNotNullExpressionValue(str3, "this.eventTitle");
        Integer num3 = showEvent.eventType;
        Intrinsics.checkNotNullExpressionValue(num3, "this.eventType");
        int intValue = num3.intValue();
        DoublePoint doublePoint = showEvent.eventPoint;
        Long l2 = showEvent.linkId;
        Intrinsics.checkNotNullExpressionValue(l2, "this.linkId");
        long longValue2 = l2.longValue();
        Integer num4 = showEvent.eventOper;
        Intrinsics.checkNotNullExpressionValue(num4, "this.eventOper");
        int intValue2 = num4.intValue();
        Long l3 = showEvent.reportTime;
        Intrinsics.checkNotNullExpressionValue(l3, "this.reportTime");
        return message.setEvent(new TrafficEventModel(longValue, str3, intValue, doublePoint, longValue2, intValue2, l3.longValue())).setBtnList(arrayList).build();
    }

    /* renamed from: b */
    private final TrafficEventModel m23429b(ShowEvent showEvent) {
        Long l = showEvent.eventId;
        Intrinsics.checkNotNullExpressionValue(l, "this.eventId");
        long longValue = l.longValue();
        String str = showEvent.eventTitle;
        Intrinsics.checkNotNullExpressionValue(str, "this.eventTitle");
        Integer num = showEvent.eventType;
        Intrinsics.checkNotNullExpressionValue(num, "this.eventType");
        int intValue = num.intValue();
        DoublePoint doublePoint = showEvent.eventPoint;
        Long l2 = showEvent.linkId;
        Intrinsics.checkNotNullExpressionValue(l2, "this.linkId");
        long longValue2 = l2.longValue();
        Integer num2 = showEvent.eventOper;
        Intrinsics.checkNotNullExpressionValue(num2, "this.eventOper");
        int intValue2 = num2.intValue();
        Long l3 = showEvent.reportTime;
        Intrinsics.checkNotNullExpressionValue(l3, "this.reportTime");
        return new TrafficEventModel(longValue, str, intValue, doublePoint, longValue2, intValue2, l3.longValue());
    }

    /* renamed from: b */
    private final void m23430b() {
        DLog.m10773d(this.f30052g, "START fetch Data Job", new Object[0]);
        Job job = this.f30057l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScope coroutineScope = this.f30056k;
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        this.f30057l = C2746d.m5821a(coroutineScope, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new TrafficEventsController$startFetchEventData$1(this, (Continuation<? super TrafficEventsController$startFetchEventData$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23421a(EventShowRes eventShowRes) {
        removeTrafficEventMarkers();
        this.f30062q.clear();
        m23426a(eventShowRes.events);
        m23431b(eventShowRes);
    }

    /* renamed from: b */
    private final void m23431b(EventShowRes eventShowRes) {
        DoublePoint doublePoint;
        CarMarker carMarker;
        ITrafficEventsReqParamGetter iTrafficEventsReqParamGetter = this.f30050e;
        LatLng latLng = null;
        if (!(iTrafficEventsReqParamGetter == null || (carMarker = iTrafficEventsReqParamGetter.getCarMarker()) == null)) {
            latLng = carMarker.getPosition();
        }
        if (latLng != null) {
            StringBuilder sb = new StringBuilder();
            List<ShowEvent> list = eventShowRes.events;
            if (list != null) {
                int i = 0;
                for (Object next : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ShowEvent showEvent = (ShowEvent) next;
                    if (!(showEvent == null || (doublePoint = showEvent.eventPoint) == null)) {
                        Double d = doublePoint.dlat;
                        double d2 = 0.0d;
                        double doubleValue = d == null ? 0.0d : d.doubleValue();
                        Double d3 = doublePoint.dlng;
                        if (d3 != null) {
                            d2 = d3.doubleValue();
                        }
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, new LatLng(doubleValue, d2));
                        sb.append("{index:" + i + ", eventId:" + showEvent.eventTitle + '@' + showEvent.eventId + ", distance:" + computeDistanceBetween + ", oper:" + showEvent.eventOper + '}');
                    }
                    i = i2;
                }
            }
            DLog.m10773d(this.f30052g, Intrinsics.stringPlus("distance_debug|", sb), new Object[0]);
        }
    }

    public final void removeTrafficEventMarkers() {
        try {
            this.f30047b.removeElementGroupByTag(this.f30053h);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private final void m23426a(List<ShowEvent> list) {
        ButtonModeInfo buttonModeInfo;
        Double d;
        Double d2;
        CarMarker carMarker;
        CameraPosition cameraPosition = this.f30047b.getCameraPosition();
        double d3 = cameraPosition == null ? 0.0d : cameraPosition.zoom;
        if (11.0d <= d3 && d3 <= 20.0d) {
            ITrafficEventsReqParamGetter iTrafficEventsReqParamGetter = this.f30050e;
            LatLng position = (iTrafficEventsReqParamGetter == null || (carMarker = iTrafficEventsReqParamGetter.getCarMarker()) == null) ? null : carMarker.getPosition();
            if (position != null && list != null) {
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    ShowEvent showEvent = (ShowEvent) next;
                    DoublePoint doublePoint = showEvent.eventPoint;
                    double doubleValue = (doublePoint == null || (d2 = doublePoint.dlat) == null) ? 0.0d : d2.doubleValue();
                    DoublePoint doublePoint2 = showEvent.eventPoint;
                    if (DDSphericalUtil.computeDistanceBetween(position, new LatLng(doubleValue, (doublePoint2 != null && (d = doublePoint2.dlng) != null) ? d.doubleValue() : 0.0d)) <= ((double) this.f30054i)) {
                        arrayList.add(next);
                    }
                }
                for (ShowEvent showEvent2 : (List) arrayList) {
                    List<ButtonModeInfo> list2 = showEvent2.modeInfo;
                    String str = (list2 == null || (buttonModeInfo = (ButtonModeInfo) CollectionsKt.firstOrNull(list2)) == null) ? null : buttonModeInfo.buttonPicUrl;
                    if (str != null) {
                        if (!(str.length() > 0)) {
                            str = null;
                        }
                        if (str != null) {
                            if (Intrinsics.areEqual((Object) "test_use_local", (Object) str)) {
                                Bitmap decodeResource = BitmapFactory.decodeResource(this.f30046a.getResources(), R.drawable.test_traffic_event_junk);
                                DLog.m10773d(this.f30052g, "[Debug] use local test event icon|eventID:" + showEvent2.eventId + "|url:test_use_local", new Object[0]);
                                Intrinsics.checkNotNullExpressionValue(decodeResource, "bitmap");
                                m23422a(showEvent2, decodeResource);
                            } else if (PatternsCompat.WEB_URL.matcher(str).matches()) {
                                m23415a(this.f30046a, str, (Function1<? super Bitmap, Unit>) new TrafficEventsController$tryAddTrafficEventMarkers$2$2$1(this, showEvent2, str));
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23422a(ShowEvent showEvent, Bitmap bitmap) {
        try {
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
            Map map = this.f30047b;
            String str = this.f30053h;
            MarkerOptions markerOptions = new MarkerOptions();
            Double d = showEvent.eventPoint.dlat;
            Intrinsics.checkNotNullExpressionValue(d, "event.eventPoint.dlat");
            double doubleValue = d.doubleValue();
            Double d2 = showEvent.eventPoint.dlng;
            Intrinsics.checkNotNullExpressionValue(d2, "event.eventPoint.dlng");
            markerOptions.position(new LatLng(doubleValue, d2.doubleValue()));
            markerOptions.anchor(0.5f, 1.0f);
            markerOptions.icon(fromBitmap);
            markerOptions.draggable(false);
            markerOptions.clickable(true);
            markerOptions.zIndex(1);
            Unit unit = Unit.INSTANCE;
            Marker addMarker = map.addMarker(str, markerOptions);
            if (addMarker != null) {
                addMarker.setData(showEvent);
            }
        } catch (Exception e) {
            String str2 = this.f30052g;
            DLog.m10773d(str2, "[Error] when add event icon to map [" + showEvent.eventTitle + "] ex:\"" + e.getMessage() + Typography.quote, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23423a(Exception exc) {
        String str = this.f30052g;
        StringBuilder sb = new StringBuilder();
        sb.append("[API Error]: \"");
        sb.append(exc == null ? null : exc.getMessage());
        sb.append(Typography.quote);
        DLog.m10773d(str, sb.toString(), new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109 A[LOOP:1: B:44:0x0103->B:46:0x0109, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x019e  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23432c(com.didi.map.sdk.proto.driver_gl.event.ShowEvent r24) {
        /*
            r23 = this;
            r6 = r23
            r0 = r24
            java.util.List<com.didi.map.sdk.proto.driver_gl.event.FeedCard> r1 = r0.card
            r8 = 1
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            if (r1 != 0) goto L_0x000f
            r11 = 0
            goto L_0x003d
        L_0x000f:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.didi.map.sdk.proto.driver_gl.event.FeedCard r3 = (com.didi.map.sdk.proto.driver_gl.event.FeedCard) r3
            java.lang.Integer r3 = r3.cardType
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r4 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.CLICK_TYPE
            int r4 = r4.getType()
            if (r3 != 0) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0035
            r3 = 1
            goto L_0x0036
        L_0x0035:
            r3 = 0
        L_0x0036:
            if (r3 == 0) goto L_0x0015
            goto L_0x003a
        L_0x0039:
            r2 = 0
        L_0x003a:
            com.didi.map.sdk.proto.driver_gl.event.FeedCard r2 = (com.didi.map.sdk.proto.driver_gl.event.FeedCard) r2
            r11 = r2
        L_0x003d:
            if (r11 != 0) goto L_0x0040
            return
        L_0x0040:
            java.util.List<com.didi.map.sdk.proto.driver_gl.event.ButtonInfo> r1 = r11.btn
            if (r1 != 0) goto L_0x0046
            r12 = 0
            goto L_0x0054
        L_0x0046:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$$inlined$sortedBy$1 r2 = new com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$$inlined$sortedBy$1
            r2.<init>()
            java.util.Comparator r2 = (java.util.Comparator) r2
            java.util.List r1 = kotlin.collections.CollectionsKt.sortedWith(r1, r2)
            r12 = r1
        L_0x0054:
            if (r12 != 0) goto L_0x0058
            r1 = 0
            goto L_0x0064
        L_0x0058:
            r1 = r12
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r8
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x0064:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            if (r1 != 0) goto L_0x006b
            return
        L_0x006b:
            kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
            r13.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            com.didi.map.global.sctx.event_reveal.TrafficEventModel r15 = r23.m23429b((com.didi.map.sdk.proto.driver_gl.event.ShowEvent) r24)
            com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback r5 = new com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r12)
            com.didi.map.sdk.proto.driver_gl.event.ButtonInfo r0 = (com.didi.map.sdk.proto.driver_gl.event.ButtonInfo) r0
            java.lang.String r4 = r0.buttonTitle
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$majorBtn$1 r16 = new com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$majorBtn$1
            r0 = r16
            r1 = r14
            r2 = r13
            r3 = r15
            r10 = r4
            r4 = r23
            r7 = r5
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener r0 = (com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener) r0
            r7.<init>(r10, r0)
            com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1 r10 = new com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1
            java.lang.String r0 = r11.title
            r10.<init>(r0, r7)
            java.lang.String r0 = r11.subTitle
            if (r0 != 0) goto L_0x00a6
        L_0x00a4:
            r7 = 0
            goto L_0x00f5
        L_0x00a6:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00b1
            r1 = 1
            goto L_0x00b2
        L_0x00b1:
            r1 = 0
        L_0x00b2:
            if (r1 == 0) goto L_0x00b7
            r17 = r0
            goto L_0x00b9
        L_0x00b7:
            r17 = 0
        L_0x00b9:
            if (r17 != 0) goto L_0x00bc
            goto L_0x00a4
        L_0x00bc:
            long r0 = r15.getReportTime()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00df
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "HH:mm"
            r0.<init>(r2, r1)
            java.util.Date r1 = new java.util.Date
            long r2 = r15.getReportTime()
            r1.<init>(r2)
            java.lang.String r0 = r0.format(r1)
            goto L_0x00e1
        L_0x00df:
            java.lang.String r0 = "00:00"
        L_0x00e1:
            java.lang.String r1 = "timeFormat"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r18 = "{{report_time}}"
            r19 = r0
            java.lang.String r0 = kotlin.text.StringsKt.replace$default((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (boolean) r20, (int) r21, (java.lang.Object) r22)
            r7 = r0
        L_0x00f5:
            int r0 = r12.size()
            java.util.List r0 = r12.subList(r8, r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r12 = r0.iterator()
        L_0x0103:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0132
            java.lang.Object r0 = r12.next()
            r5 = r0
            com.didi.map.sdk.proto.driver_gl.event.ButtonInfo r5 = (com.didi.map.sdk.proto.driver_gl.event.ButtonInfo) r5
            com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback r4 = new com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback
            java.lang.String r3 = r5.buttonTitle
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$modelType1$1$1$1 r16 = new com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$modelType1$1$1$1
            r0 = r16
            r1 = r14
            r2 = r13
            r8 = r3
            r3 = r15
            r24 = r12
            r12 = r4
            r4 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r16
            com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener r0 = (com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener) r0
            r12.<init>(r8, r0)
            r10.addMinorBtn(r12)
            r12 = r24
            r8 = 1
            goto L_0x0103
        L_0x0132:
            java.lang.String r0 = r11.secondary
            if (r0 != 0) goto L_0x0138
            r0 = 0
            goto L_0x0147
        L_0x0138:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0142
            r0 = 1
            goto L_0x0143
        L_0x0142:
            r0 = 0
        L_0x0143:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0147:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)
            if (r0 == 0) goto L_0x0156
            java.lang.String r0 = r11.secondary
            java.lang.String r1 = "\n"
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            goto L_0x0158
        L_0x0156:
            java.lang.String r0 = ""
        L_0x0158:
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r0)
            r10.setSubTitle(r0)
            r0 = 1
            r10.setIsShowCloseImg(r0)
            r10.setClickOutsideCanCancel(r0)
            com.didi.map.global.sctx.event_reveal.-$$Lambda$TrafficEventsController$q8C70zPqCtZn4SItnETJ0hgU8_w r0 = new com.didi.map.global.sctx.event_reveal.-$$Lambda$TrafficEventsController$q8C70zPqCtZn4SItnETJ0hgU8_w
            r0.<init>(r15, r13)
            r10.setDismissListener(r0)
            android.content.Context r0 = r6.f30046a
            com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel r10 = (com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel) r10
            com.didi.global.globaluikit.drawer.LEGODrawer r0 = com.didi.global.globaluikit.LEGOUICreator.showDrawerTemplate(r0, r10)
            r14.element = r0
            java.lang.String r0 = r6.f30052g
            long r1 = r15.getEventId()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Click_Verify|show Click Verify Dialog eventID "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.didi.common.map.util.DLog.m10773d(r0, r1, r2)
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r0 = r6.f30050e
            if (r0 != 0) goto L_0x0194
            r0 = 0
            goto L_0x0198
        L_0x0194:
            java.lang.String r0 = r0.getOrderId()
        L_0x0198:
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r1 = r6.f30050e
            if (r1 != 0) goto L_0x019e
            r10 = 0
            goto L_0x01a6
        L_0x019e:
            long r1 = r1.getCurRouteId()
            java.lang.Long r10 = java.lang.Long.valueOf(r1)
        L_0x01a6:
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r1 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.CLICK_TYPE
            r6.m23425a((java.lang.String) r0, (com.didi.map.global.sctx.event_reveal.TrafficEventModel) r15, (java.lang.Long) r10, (com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController.m23432c(com.didi.map.sdk.proto.driver_gl.event.ShowEvent):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23420a(TrafficEventsController trafficEventsController, TrafficEventModel trafficEventModel, Ref.BooleanRef booleanRef) {
        Intrinsics.checkNotNullParameter(trafficEventsController, "this$0");
        Intrinsics.checkNotNullParameter(trafficEventModel, "$eventModel");
        Intrinsics.checkNotNullParameter(booleanRef, "$buttonClicked");
        String str = trafficEventsController.f30052g;
        DLog.m10773d(str, "Click_Verify|show Click Verify Dialog eventID " + trafficEventModel.getEventId() + " buttonClick " + booleanRef.element, new Object[0]);
        if (!booleanRef.element) {
            ITrafficEventsReqParamGetter iTrafficEventsReqParamGetter = trafficEventsController.f30050e;
            Long l = null;
            String orderId = iTrafficEventsReqParamGetter == null ? null : iTrafficEventsReqParamGetter.getOrderId();
            int type = OmegaOperateCodeType.DIALOG_CLOSE.getType();
            ITrafficEventsReqParamGetter iTrafficEventsReqParamGetter2 = trafficEventsController.f30050e;
            if (iTrafficEventsReqParamGetter2 != null) {
                l = Long.valueOf(iTrafficEventsReqParamGetter2.getCurRouteId());
            }
            trafficEventsController.m23424a(orderId, trafficEventModel, type, l, OmegaCardType.CLICK_TYPE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23417a(TrafficEventModel trafficEventModel, int i, int i2) {
        if (trafficEventModel == null) {
            DLog.m10773d(this.f30052g, "verify|event model is null", new Object[0]);
            return;
        }
        Job job = this.f30058m;
        if (Intrinsics.areEqual((Object) job == null ? null : Boolean.valueOf(job.isActive()), (Object) true)) {
            Context context = this.f30046a;
            LEGOToastHelper.showShortNagToast(context, context.getString(R.string.GRider_PassengerReports__FBlf));
            return;
        }
        CoroutineScope coroutineScope = this.f30056k;
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        Job unused = C2746d.m5821a(coroutineScope, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new TrafficEventsController$doVerify$1(this, trafficEventModel, i, i2, (Continuation<? super TrafficEventsController$doVerify$1>) null), 2, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleTriggerVerifyDialogClick(com.didi.map.global.sctx.event_reveal.TrafficEventModel r12, int r13) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000d
        L_0x0005:
            int r1 = r12.getEventOper()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x000d:
            r2 = 1
            java.lang.String r3 = "trigger_verify|operaCode "
            r4 = 0
            if (r1 != 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            int r1 = r1.intValue()
            if (r1 == r2) goto L_0x0041
        L_0x001a:
            java.lang.String r13 = r11.f30052g
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            if (r12 != 0) goto L_0x0027
            goto L_0x002f
        L_0x0027:
            int r12 = r12.getEventOper()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
        L_0x002f:
            r1.append(r0)
            java.lang.String r12 = "|illegal state: this event cannot even show. Why it clicked to verify"
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.didi.common.map.util.DLog.m10773d(r13, r12, r0)
            return
        L_0x0041:
            java.lang.String r1 = r11.f30052g
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            java.lang.String r5 = "trigger_verify|handleTriggerVerifyDialogClick code: "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r2)
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.didi.common.map.util.DLog.m10773d(r1, r2, r5)
            r1 = -101(0xffffffffffffff9b, float:NaN)
            if (r13 == r1) goto L_0x00f4
            r1 = -2
            if (r13 == r1) goto L_0x00c5
            java.lang.String r1 = r11.f30052g
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            if (r12 != 0) goto L_0x0067
            r3 = r0
            goto L_0x006f
        L_0x0067:
            int r3 = r12.getEventOper()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x006f:
            r2.append(r3)
            java.lang.String r3 = "|eventId "
            r2.append(r3)
            if (r12 != 0) goto L_0x007b
            r3 = r0
            goto L_0x0083
        L_0x007b:
            long r5 = r12.getEventId()
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
        L_0x0083:
            r2.append(r3)
            java.lang.String r3 = "|verify code "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r4]
            com.didi.common.map.util.DLog.m10773d(r1, r2, r3)
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r1 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.TRIGGER_TYPE
            int r1 = r1.getType()
            r11.m23417a((com.didi.map.global.sctx.event_reveal.TrafficEventModel) r12, (int) r13, (int) r1)
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r1 = r11.f30050e
            if (r1 != 0) goto L_0x00a6
            r3 = r0
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r1 = r1.getOrderId()
            r3 = r1
        L_0x00ab:
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r1 = r11.f30050e
            if (r1 != 0) goto L_0x00b0
            goto L_0x00b8
        L_0x00b0:
            long r0 = r1.getCurRouteId()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x00b8:
            r6 = r0
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r7 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.TRIGGER_TYPE
            r2 = r11
            r4 = r12
            r5 = r13
            r2.m23424a(r3, r4, r5, r6, r7)
            r11.m23435e()
            goto L_0x00f4
        L_0x00c5:
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r13 = r11.f30050e
            if (r13 != 0) goto L_0x00cb
            r6 = r0
            goto L_0x00d0
        L_0x00cb:
            java.lang.String r13 = r13.getOrderId()
            r6 = r13
        L_0x00d0:
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaOperateCodeType r13 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaOperateCodeType.TIMEOUT_CLOSE
            int r8 = r13.getType()
            com.didi.map.global.sctx.event_reveal.ITrafficEventsReqParamGetter r13 = r11.f30050e
            if (r13 != 0) goto L_0x00db
            goto L_0x00e3
        L_0x00db:
            long r0 = r13.getCurRouteId()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x00e3:
            r9 = r0
            com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType r10 = com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType.TRIGGER_TYPE
            r5 = r11
            r7 = r12
            r5.m23424a(r6, r7, r8, r9, r10)
            java.lang.String r12 = r11.f30052g
            java.lang.Object[] r13 = new java.lang.Object[r4]
            java.lang.String r0 = "trigger_verify|dismiss after counting down"
            com.didi.common.map.util.DLog.m10773d(r12, r0, r13)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController.handleTriggerVerifyDialogClick(com.didi.map.global.sctx.event_reveal.TrafficEventModel, int):void");
    }

    public final void onMatched(LatLng latLng, boolean z) {
        m23416a(latLng, z);
    }

    /* renamed from: c */
    private final boolean m23433c() {
        int i = this.f30064s;
        if (i < 0 || this.f30065t < 0) {
            DLog.m10773d(this.f30052g, "read SP not finish", new Object[0]);
            return false;
        }
        if (i >= 3) {
            long currentTimeMillis = (System.currentTimeMillis() - this.f30065t) / ((long) 1000);
            if (0 <= currentTimeMillis && currentTimeMillis <= ((long) this.f30068w)) {
                return false;
            }
            if (currentTimeMillis > ((long) this.f30068w)) {
                m23435e();
            }
        }
        return true;
    }

    /* renamed from: d */
    private final void m23434d() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f30064s = PoiStore.getInstance(this.f30046a).getInt(this.f30066u, 0);
            this.f30065t = PoiStore.getInstance(this.f30046a).getLong(this.f30067v, currentTimeMillis);
            String str = this.f30052g;
            DLog.m10773d(str, "read SP finish|time:" + this.f30064s + ", timestamp: " + this.f30065t, new Object[0]);
        } catch (Exception e) {
            DLog.m10773d(this.f30052g, Intrinsics.stringPlus("read SP Error: ", e.getMessage()), new Object[0]);
        }
    }

    /* renamed from: e */
    private final void m23435e() {
        PoiStore.getInstance(this.f30046a).remove(this.f30066u);
        PoiStore.getInstance(this.f30046a).remove(this.f30067v);
    }

    /* renamed from: f */
    private final void m23436f() {
        PoiStore.getInstance(this.f30046a).putAndSave(this.f30066u, this.f30064s + 1);
        PoiStore.getInstance(this.f30046a).putAndSave(this.f30067v, System.currentTimeMillis());
    }

    /* renamed from: a */
    private final void m23416a(LatLng latLng, boolean z) {
        Pair<IMapElement, Double> pair;
        Boolean bool;
        Long l;
        Boolean bool2;
        TrafficEventModel event;
        TrafficEventModel event2;
        if (this.f30061p) {
            DLog.m10773d(this.f30052g, "Don't show trigger dialog, cause it has been shown before", new Object[0]);
        } else if (!m23433c()) {
            DLog.m10773d(this.f30052g, "Don't show trigger dialog, cause it is too frequent", new Object[0]);
        } else {
            double d = this.f30055j;
            CameraPosition cameraPosition = this.f30047b.getCameraPosition();
            double d2 = cameraPosition == null ? 0.0d : cameraPosition.zoom;
            Integer num = null;
            if (!(11.0d <= d2 && d2 <= 20.0d)) {
                pair = null;
            } else {
                pair = m23412a(latLng, (List<? extends IMapElement>) this.f30047b.getElementGroup(this.f30053h), d, (Function2<? super LatLng, ? super IMapElement, Boolean>) new TrafficEventsController$tryShowTriggerVerifyDialog$pair$1(this));
            }
            if (pair != null) {
                IMapElement first = pair.getFirst();
                Marker marker = first instanceof Marker ? (Marker) first : null;
                Object data = marker == null ? null : marker.getData();
                ShowEvent showEvent = data instanceof ShowEvent ? (ShowEvent) data : null;
                TriggeredTrafficEventShowModel a = showEvent == null ? null : m23410a(showEvent);
                if (a == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(a.isValid());
                }
                if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                    m23427a(true, a);
                }
                String str = this.f30052g;
                StringBuilder sb = new StringBuilder();
                sb.append("trigger_verify|get nearest event point(distance < ");
                sb.append(d);
                sb.append("m)|eventId:");
                if (a == null || (event2 = a.getEvent()) == null) {
                    l = null;
                } else {
                    l = Long.valueOf(event2.getEventId());
                }
                sb.append(l);
                sb.append("|isSimulate:");
                sb.append(z);
                sb.append("|modelValid:");
                if (a == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(a.isValid());
                }
                sb.append(bool2);
                sb.append("|eventOpre:");
                if (!(a == null || (event = a.getEvent()) == null)) {
                    num = Integer.valueOf(event.getEventOper());
                }
                sb.append(num);
                DLog.m10773d(str, sb.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ Pair m23413a(TrafficEventsController trafficEventsController, LatLng latLng, List list, double d, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        return trafficEventsController.m23412a(latLng, (List<? extends IMapElement>) list, d, (Function2<? super LatLng, ? super IMapElement, Boolean>) function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<com.didi.common.map.internal.IMapElement, java.lang.Double> m23412a(com.didi.common.map.model.LatLng r10, java.util.List<? extends com.didi.common.map.internal.IMapElement> r11, double r12, kotlin.jvm.functions.Function2<? super com.didi.common.map.model.LatLng, ? super com.didi.common.map.internal.IMapElement, java.lang.Boolean> r14) {
        /*
            r9 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0006
            r11 = r0
            goto L_0x00d2
        L_0x0006:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r11 = r11.iterator()
        L_0x0013:
            boolean r2 = r11.hasNext()
            r3 = 1
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r11.next()
            r4 = r2
            com.didi.common.map.internal.IMapElement r4 = (com.didi.common.map.internal.IMapElement) r4
            if (r14 != 0) goto L_0x0024
            goto L_0x0031
        L_0x0024:
            java.lang.Object r4 = r14.invoke(r10, r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            if (r4 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            boolean r3 = r4.booleanValue()
        L_0x0031:
            if (r3 == 0) goto L_0x0013
            r1.add(r2)
            goto L_0x0013
        L_0x0037:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r11 = new java.util.ArrayList
            r14 = 10
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r14)
            r11.<init>(r14)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r14 = r1.iterator()
        L_0x004c:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x00d0
            java.lang.Object r1 = r14.next()
            com.didi.common.map.internal.IMapElement r1 = (com.didi.common.map.internal.IMapElement) r1
            boolean r2 = r1 instanceof com.didi.common.map.model.Marker
            if (r2 == 0) goto L_0x0060
            r2 = r1
            com.didi.common.map.model.Marker r2 = (com.didi.common.map.model.Marker) r2
            goto L_0x0061
        L_0x0060:
            r2 = r0
        L_0x0061:
            if (r2 != 0) goto L_0x0065
            r2 = r0
            goto L_0x0069
        L_0x0065:
            java.lang.Object r2 = r2.getData()
        L_0x0069:
            boolean r4 = r2 instanceof com.didi.map.sdk.proto.driver_gl.event.ShowEvent
            if (r4 == 0) goto L_0x0070
            com.didi.map.sdk.proto.driver_gl.event.ShowEvent r2 = (com.didi.map.sdk.proto.driver_gl.event.ShowEvent) r2
            goto L_0x0071
        L_0x0070:
            r2 = r0
        L_0x0071:
            if (r2 != 0) goto L_0x0075
            r2 = r0
            goto L_0x0077
        L_0x0075:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r2 = r2.eventPoint
        L_0x0077:
            if (r2 != 0) goto L_0x007b
        L_0x0079:
            r4 = r0
            goto L_0x00ac
        L_0x007b:
            java.lang.Double r4 = r2.dlat
            if (r4 == 0) goto L_0x0085
            java.lang.Double r4 = r2.dlng
            if (r4 == 0) goto L_0x0085
            r4 = 1
            goto L_0x0086
        L_0x0085:
            r4 = 0
        L_0x0086:
            if (r4 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r2 = r0
        L_0x008a:
            if (r2 != 0) goto L_0x008d
            goto L_0x0079
        L_0x008d:
            com.didi.common.map.model.LatLng r4 = new com.didi.common.map.model.LatLng
            java.lang.Double r5 = r2.dlat
            java.lang.String r6 = "it.dlat"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            java.lang.Double r2 = r2.dlng
            java.lang.String r7 = "it.dlng"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.Number r2 = (java.lang.Number) r2
            double r7 = r2.doubleValue()
            r4.<init>((double) r5, (double) r7)
        L_0x00ac:
            boolean r2 = com.didi.common.map.util.LatLngUtils.locateCorrect(r10)
            if (r2 == 0) goto L_0x00bd
            boolean r2 = com.didi.common.map.util.LatLngUtils.locateCorrect(r4)
            if (r2 == 0) goto L_0x00bd
            double r4 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r10, r4)
            goto L_0x00c2
        L_0x00bd:
            r4 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x00c2:
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            r2.<init>(r1, r4)
            r11.add(r2)
            goto L_0x004c
        L_0x00d0:
            java.util.List r11 = (java.util.List) r11
        L_0x00d2:
            if (r11 != 0) goto L_0x00d6
            r11 = r0
            goto L_0x011d
        L_0x00d6:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r10 = r11.iterator()
            boolean r11 = r10.hasNext()
            if (r11 != 0) goto L_0x00e4
            r11 = r0
            goto L_0x011b
        L_0x00e4:
            java.lang.Object r11 = r10.next()
            boolean r14 = r10.hasNext()
            if (r14 != 0) goto L_0x00ef
            goto L_0x011b
        L_0x00ef:
            r14 = r11
            kotlin.Pair r14 = (kotlin.Pair) r14
            java.lang.Object r14 = r14.getSecond()
            java.lang.Number r14 = (java.lang.Number) r14
            double r1 = r14.doubleValue()
        L_0x00fc:
            java.lang.Object r14 = r10.next()
            r3 = r14
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r3 = r3.getSecond()
            java.lang.Number r3 = (java.lang.Number) r3
            double r3 = r3.doubleValue()
            int r5 = java.lang.Double.compare(r1, r3)
            if (r5 <= 0) goto L_0x0115
            r11 = r14
            r1 = r3
        L_0x0115:
            boolean r14 = r10.hasNext()
            if (r14 != 0) goto L_0x00fc
        L_0x011b:
            kotlin.Pair r11 = (kotlin.Pair) r11
        L_0x011d:
            if (r11 != 0) goto L_0x0120
            return r0
        L_0x0120:
            java.lang.Object r10 = r11.getSecond()
            java.lang.Number r10 = (java.lang.Number) r10
            double r1 = r10.doubleValue()
            int r10 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r10 > 0) goto L_0x012f
            goto L_0x0132
        L_0x012f:
            r11 = r0
            kotlin.Pair r11 = (kotlin.Pair) r11
        L_0x0132:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController.m23412a(com.didi.common.map.model.LatLng, java.util.List, double, kotlin.jvm.functions.Function2):kotlin.Pair");
    }

    public final void pause() {
        DLog.m10773d(this.f30052g, "Pause Traffic Events Request", new Object[0]);
        Job job = this.f30057l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f30057l = null;
        Job job2 = this.f30058m;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.f30058m = null;
    }

    public final void leave() {
        DLog.m10773d(this.f30052g, "Leave Traffic Events Request", new Object[0]);
        m23427a(false, (TriggeredTrafficEventShowModel) null);
        removeTrafficEventMarkers();
        this.f30047b.removeOnCameraChangeListener(this.f30070y);
        this.f30047b.removeOnMarkerClickListener(this.f30071z);
        CoroutineScopeKt.cancel$default(this.f30056k, (CancellationException) null, 1, (Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m23418a(TrafficEventsController trafficEventsController, Context context, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        trafficEventsController.m23415a(context, str, (Function1<? super Bitmap, Unit>) function1);
    }

    /* renamed from: a */
    private final void m23415a(Context context, String str, Function1<? super Bitmap, Unit> function1) {
        Boolean bool;
        if (str == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(str.length() > 0);
        }
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            Glide.with(context).asBitmap().load(str).into(new TrafficEventsController$downloadIcon$1(function1));
        } else if (function1 != null) {
            function1.invoke(null);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventsController$OmegaCardType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "TRIGGER_TYPE", "CLICK_TYPE", "UNKNOWN", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TrafficEventsController.kt */
    public enum OmegaCardType {
        TRIGGER_TYPE(1),
        CLICK_TYPE(2),
        UNKNOWN(-101);
        
        private final int type;

        private OmegaCardType(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r4 = r4.lat;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23425a(java.lang.String r8, com.didi.map.global.sctx.event_reveal.TrafficEventModel r9, java.lang.Long r10, com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType r11) {
        /*
            r7 = this;
            r0 = 7
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            if (r8 != 0) goto L_0x0007
            java.lang.String r8 = ""
        L_0x0007:
            java.lang.String r1 = "order_id"
            kotlin.Pair r8 = kotlin.TuplesKt.m41339to(r1, r8)
            r1 = 0
            r0[r1] = r8
            r8 = 1
            r2 = 0
            if (r9 != 0) goto L_0x0017
            r4 = r2
            goto L_0x001b
        L_0x0017:
            long r4 = r9.getEventId()
        L_0x001b:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "mission_id"
            kotlin.Pair r4 = kotlin.TuplesKt.m41339to(r5, r4)
            r0[r8] = r4
            r8 = 2
            if (r9 != 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            int r1 = r9.getEventType()
        L_0x002f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "type"
            kotlin.Pair r1 = kotlin.TuplesKt.m41339to(r4, r1)
            r0[r8] = r1
            r8 = 3
            r1 = 0
            if (r9 != 0) goto L_0x0041
            r4 = r1
            goto L_0x0045
        L_0x0041:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r4 = r9.getEventPoint()
        L_0x0045:
            r5 = 0
            if (r4 != 0) goto L_0x004a
        L_0x0048:
            r4 = 0
            goto L_0x0053
        L_0x004a:
            java.lang.Float r4 = r4.lat
            if (r4 != 0) goto L_0x004f
            goto L_0x0048
        L_0x004f:
            float r4 = r4.floatValue()
        L_0x0053:
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.String r6 = "latitude"
            kotlin.Pair r4 = kotlin.TuplesKt.m41339to(r6, r4)
            r0[r8] = r4
            r8 = 4
            if (r9 != 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = r9.getEventPoint()
        L_0x0067:
            if (r1 != 0) goto L_0x006a
            goto L_0x0073
        L_0x006a:
            java.lang.Float r9 = r1.lng
            if (r9 != 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            float r5 = r9.floatValue()
        L_0x0073:
            java.lang.Float r9 = java.lang.Float.valueOf(r5)
            java.lang.String r1 = "longitude"
            kotlin.Pair r9 = kotlin.TuplesKt.m41339to(r1, r9)
            r0[r8] = r9
            r8 = 5
            if (r10 != 0) goto L_0x0083
            goto L_0x0087
        L_0x0083:
            long r2 = r10.longValue()
        L_0x0087:
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r10 = "route_id"
            kotlin.Pair r9 = kotlin.TuplesKt.m41339to(r10, r9)
            r0[r8] = r9
            r8 = 6
            int r9 = r11.getType()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = "card_type"
            kotlin.Pair r9 = kotlin.TuplesKt.m41339to(r10, r9)
            r0[r8] = r9
            java.util.Map r8 = kotlin.collections.MapsKt.mutableMapOf(r0)
            java.util.Map r8 = kotlin.collections.MapsKt.toMap(r8)
            java.lang.String r9 = "map_paxreport_verification_sw"
            com.didi.map.global.model.omega.GlobalOmegaTracker.trackEvent(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController.m23425a(java.lang.String, com.didi.map.global.sctx.event_reveal.TrafficEventModel, java.lang.Long, com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType):void");
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventsController$OmegaOperateCodeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "DIALOG_CLOSE", "TIMEOUT_CLOSE", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TrafficEventsController.kt */
    public enum OmegaOperateCodeType {
        DIALOG_CLOSE(-1),
        TIMEOUT_CLOSE(-2);
        
        private final int type;

        private OmegaOperateCodeType(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r2 = r2.lat;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m23424a(java.lang.String r6, com.didi.map.global.sctx.event_reveal.TrafficEventModel r7, int r8, java.lang.Long r9, com.didi.map.global.sctx.event_reveal.TrafficEventsController.OmegaCardType r10) {
        /*
            r5 = this;
            r0 = 8
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            if (r6 != 0) goto L_0x0008
            java.lang.String r6 = ""
        L_0x0008:
            java.lang.String r1 = "order_id"
            kotlin.Pair r6 = kotlin.TuplesKt.m41339to(r1, r6)
            r1 = 0
            r0[r1] = r6
            r6 = 1
            if (r7 != 0) goto L_0x0017
            r2 = 0
            goto L_0x001b
        L_0x0017:
            long r2 = r7.getEventId()
        L_0x001b:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "mission_id"
            kotlin.Pair r2 = kotlin.TuplesKt.m41339to(r3, r2)
            r0[r6] = r2
            r6 = 2
            if (r7 != 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            int r1 = r7.getEventType()
        L_0x002f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "type"
            kotlin.Pair r1 = kotlin.TuplesKt.m41339to(r2, r1)
            r0[r6] = r1
            r6 = 3
            r1 = 0
            if (r7 != 0) goto L_0x0041
            r2 = r1
            goto L_0x0045
        L_0x0041:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r2 = r7.getEventPoint()
        L_0x0045:
            r3 = 0
            if (r2 != 0) goto L_0x004a
        L_0x0048:
            r2 = 0
            goto L_0x0053
        L_0x004a:
            java.lang.Float r2 = r2.lat
            if (r2 != 0) goto L_0x004f
            goto L_0x0048
        L_0x004f:
            float r2 = r2.floatValue()
        L_0x0053:
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.String r4 = "latitude"
            kotlin.Pair r2 = kotlin.TuplesKt.m41339to(r4, r2)
            r0[r6] = r2
            r6 = 4
            if (r7 != 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = r7.getEventPoint()
        L_0x0067:
            if (r1 != 0) goto L_0x006a
            goto L_0x0073
        L_0x006a:
            java.lang.Float r7 = r1.lng
            if (r7 != 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            float r3 = r7.floatValue()
        L_0x0073:
            java.lang.Float r7 = java.lang.Float.valueOf(r3)
            java.lang.String r1 = "longitude"
            kotlin.Pair r7 = kotlin.TuplesKt.m41339to(r1, r7)
            r0[r6] = r7
            r6 = 5
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "operation_type"
            kotlin.Pair r7 = kotlin.TuplesKt.m41339to(r8, r7)
            r0[r6] = r7
            r6 = 6
            java.lang.String r7 = "route_id"
            kotlin.Pair r7 = kotlin.TuplesKt.m41339to(r7, r9)
            r0[r6] = r7
            r6 = 7
            int r7 = r10.getType()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "card_type"
            kotlin.Pair r7 = kotlin.TuplesKt.m41339to(r8, r7)
            r0[r6] = r7
            java.util.Map r6 = kotlin.collections.MapsKt.mutableMapOf(r0)
            java.util.Map r6 = kotlin.collections.MapsKt.toMap(r6)
            java.lang.String r7 = "map_paxreport_verification_ck"
            com.didi.map.global.model.omega.GlobalOmegaTracker.trackEvent(r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventsController.m23424a(java.lang.String, com.didi.map.global.sctx.event_reveal.TrafficEventModel, int, java.lang.Long, com.didi.map.global.sctx.event_reveal.TrafficEventsController$OmegaCardType):void");
    }
}
