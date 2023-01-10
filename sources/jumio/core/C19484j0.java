package jumio.core;

import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("ReportingModel")
/* renamed from: jumio.core.j0 */
/* compiled from: ReportingModel.kt */
public final class C19484j0 implements StaticModel {

    /* renamed from: a */
    public JumioScanStep f55359a;

    /* renamed from: b */
    public JumioScanSide f55360b;

    /* renamed from: c */
    public ScanMode f55361c;

    /* renamed from: d */
    public String f55362d;

    /* renamed from: e */
    public long f55363e;

    /* renamed from: f */
    public final TreeMap<String, C19485a> f55364f = new TreeMap<>();

    /* renamed from: jumio.core.j0$a */
    /* compiled from: ReportingModel.kt */
    public final class C19485a implements Serializable {

        /* renamed from: a */
        public C19486b f55365a;

        /* renamed from: b */
        public final HashMap<JumioScanSide, C19486b> f55366b = new HashMap<>();

        /* renamed from: c */
        public final /* synthetic */ C19484j0 f55367c;

        public C19485a(C19484j0 j0Var) {
            Intrinsics.checkNotNullParameter(j0Var, "this$0");
            this.f55367c = j0Var;
            this.f55365a = new C19486b(j0Var);
        }

        /* renamed from: a */
        public final HashMap<JumioScanSide, C19486b> mo148654a() {
            return this.f55366b;
        }

        /* renamed from: b */
        public final C19486b mo148655b() {
            return this.f55365a;
        }
    }

    /* renamed from: jumio.core.j0$b */
    /* compiled from: ReportingModel.kt */
    public final class C19486b implements Serializable {

        /* renamed from: a */
        public long f55368a;

        /* renamed from: b */
        public long f55369b;

        /* renamed from: c */
        public long f55370c;

        public C19486b(C19484j0 j0Var) {
            Intrinsics.checkNotNullParameter(j0Var, "this$0");
        }

        /* renamed from: a */
        public final void mo148657a(long j) {
            this.f55369b = j;
        }

        /* renamed from: b */
        public final long mo148658b() {
            return this.f55368a;
        }

        /* renamed from: c */
        public final long mo148660c() {
            return this.f55370c;
        }

        /* renamed from: a */
        public final long mo148656a() {
            return this.f55369b - this.f55368a;
        }

        /* renamed from: b */
        public final void mo148659b(long j) {
            this.f55368a = j;
        }

        /* renamed from: c */
        public final void mo148661c(long j) {
            this.f55370c = j;
        }
    }

    /* renamed from: a */
    public final void mo148648a(JumioScanStep jumioScanStep) {
        this.f55359a = jumioScanStep;
    }

    /* renamed from: b */
    public final void mo148651b(String str) {
        this.f55362d = str;
    }

    /* renamed from: c */
    public final void mo148653c(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!this.f55364f.containsKey(str)) {
            this.f55364f.put(str, new C19485a(this));
        }
        C19485a aVar = this.f55364f.get(str);
        if (aVar != null) {
            aVar.mo148655b().mo148659b(System.currentTimeMillis());
            aVar.mo148655b().mo148657a(0);
        }
    }

    /* renamed from: a */
    public final void mo148647a(JumioScanSide jumioScanSide) {
        this.f55360b = jumioScanSide;
    }

    /* renamed from: b */
    public final void mo148652b(String str, JumioScanSide jumioScanSide) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        C19485a aVar = this.f55364f.get(str);
        if (aVar != null) {
            if (!aVar.mo148654a().containsKey(jumioScanSide)) {
                aVar.mo148654a().put(jumioScanSide, new C19486b(this));
            }
            C19486b bVar = aVar.mo148654a().get(jumioScanSide);
            if (bVar != null) {
                bVar.mo148659b(System.currentTimeMillis());
                bVar.mo148657a(0);
            }
        }
    }

    /* renamed from: a */
    public final void mo148646a(ScanMode scanMode) {
        this.f55361c = scanMode;
    }

    /* renamed from: a */
    public final void mo148645a(long j) {
        this.f55363e = j;
    }

    /* renamed from: a */
    public final void mo148649a(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        C19485a aVar = this.f55364f.get(str);
        if (aVar != null) {
            aVar.mo148655b().mo148657a(System.currentTimeMillis());
            if (aVar.mo148655b().mo148658b() != 0) {
                C19486b b = aVar.mo148655b();
                b.mo148661c(b.mo148660c() + aVar.mo148655b().mo148656a());
            }
            aVar.mo148655b().mo148659b(0);
            aVar.mo148655b().mo148657a(0);
        }
    }

    /* renamed from: a */
    public final void mo148650a(String str, JumioScanSide jumioScanSide) {
        C19486b bVar;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        C19485a aVar = this.f55364f.get(str);
        if (aVar != null && (bVar = aVar.mo148654a().get(jumioScanSide)) != null) {
            bVar.mo148657a(System.currentTimeMillis());
            if (bVar.mo148658b() != 0) {
                bVar.mo148661c(bVar.mo148660c() + bVar.mo148656a());
            }
            bVar.mo148659b(0);
            bVar.mo148657a(0);
        }
    }

    /* renamed from: a */
    public final MetaInfo mo148644a(C19497p pVar) {
        MetaInfo metaInfo = new MetaInfo();
        JSONObject jSONObject = new JSONObject();
        String str = this.f55362d;
        if (str != null) {
            jSONObject.put("id", str);
        }
        JumioScanStep jumioScanStep = this.f55359a;
        if (jumioScanStep != null) {
            jSONObject.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP, jumioScanStep.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        JumioScanSide jumioScanSide = this.f55360b;
        if (jumioScanSide != null) {
            jSONObject2.put("side", jumioScanSide.toString());
        }
        ScanMode scanMode = this.f55361c;
        if (scanMode != null) {
            jSONObject2.put(ParamKeys.PARAM_MODE, scanMode.toString());
        }
        if (jSONObject2.length() != 0) {
            jSONObject.put("part", jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject.length() != 0) {
            jSONObject3.put("credential", jSONObject);
        }
        if (pVar != null && !pVar.mo148713c()) {
            JSONArray jSONArray = new JSONArray();
            for (C19489l lVar : pVar.mo148714d()) {
                if (!lVar.mo148673g()) {
                    jSONArray.put(lVar.mo148671e());
                }
            }
            jSONObject3.put("incomplete", jSONArray);
        }
        if (jSONObject3.length() != 0) {
            metaInfo.put("dropOff", jSONObject3.toString());
        }
        JSONObject jSONObject4 = new JSONObject();
        for (Map.Entry next : this.f55364f.entrySet()) {
            JSONObject jSONObject5 = new JSONObject();
            long j = (long) 1000;
            jSONObject5.put(ParamConst.PARAM_TOTAL, (int) (((C19485a) next.getValue()).mo148655b().mo148660c() / j));
            for (Map.Entry next2 : ((C19485a) next.getValue()).mo148654a().entrySet()) {
                jSONObject5.put(((JumioScanSide) next2.getKey()).toString(), (int) (((C19486b) next2.getValue()).mo148660c() / j));
            }
            jSONObject4.put((String) next.getKey(), jSONObject5);
        }
        jSONObject4.put(ParamConst.PARAM_TOTAL, (int) ((System.currentTimeMillis() - this.f55363e) / ((long) 1000)));
        metaInfo.put("sec", jSONObject4.toString());
        return metaInfo;
    }
}
