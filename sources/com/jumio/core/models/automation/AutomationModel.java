package com.jumio.core.models.automation;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.model.StaticModel;
import java.util.List;
import jumio.core.C19478g0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

@PersistWith("AutomationModel")
/* compiled from: AutomationModel.kt */
public final class AutomationModel implements StaticModel {

    /* renamed from: d */
    public static final Companion f57733d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final C20978a f57734a;

    /* renamed from: b */
    public final C19478g0 f57735b;

    /* renamed from: c */
    public final String f57736c;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, mo148868d2 = {"Lcom/jumio/core/models/automation/AutomationModel$Companion;", "", "", "string", "Lcom/jumio/core/models/automation/AutomationModel;", "fromString", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: AutomationModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AutomationModel fromString(String str) {
            C20978a aVar;
            C19478g0 g0Var;
            String str2 = str;
            boolean z = false;
            if (str2 != null) {
                if (str.length() == 0) {
                    z = true;
                }
            }
            if (z) {
                return new AutomationModel((C20978a) null, (C19478g0) null, (String) null, 7, (DefaultConstructorMarker) null);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.isNull("decisionType")) {
                    String optString = jSONObject.optString("decisionType", "");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"decisionType\", \"\")");
                    aVar = C20978a.valueOf(optString);
                } else {
                    aVar = C20978a.NOT_AVAILABLE;
                }
                if (!jSONObject.isNull("rejectReason")) {
                    g0Var = new C19478g0(jSONObject.optJSONObject("rejectReason"));
                } else {
                    g0Var = new C19478g0((String) null, (String) null, (String) null, false, (String) null, (String) null, (List) null, false, 255, (DefaultConstructorMarker) null);
                }
                String optString2 = jSONObject.optString("additionalInformation", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "additionalInformation");
                return new AutomationModel(aVar, g0Var, optString2);
            } catch (JSONException e) {
                Log.m43666w("AutomationModel", "json exception in parseResponse()", (Throwable) e);
                return new AutomationModel((C20978a) null, (C19478g0) null, (String) null, 7, (DefaultConstructorMarker) null);
            } catch (Exception e2) {
                Log.m43666w("AutomationModel", "General exception", (Throwable) e2);
                return new AutomationModel((C20978a) null, (C19478g0) null, (String) null, 7, (DefaultConstructorMarker) null);
            }
        }
    }

    /* renamed from: com.jumio.core.models.automation.AutomationModel$a */
    /* compiled from: AutomationModel.kt */
    public enum C20978a {
        PASS,
        REJECT,
        NOT_AVAILABLE
    }

    public AutomationModel() {
        this((C20978a) null, (C19478g0) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public AutomationModel(C20978a aVar, C19478g0 g0Var, String str) {
        Intrinsics.checkNotNullParameter(aVar, "decisionType");
        Intrinsics.checkNotNullParameter(g0Var, "rejectReason");
        Intrinsics.checkNotNullParameter(str, "additionalInformation");
        this.f57734a = aVar;
        this.f57735b = g0Var;
        this.f57736c = str;
    }

    /* renamed from: a */
    public final C20978a mo172355a() {
        return this.f57734a;
    }

    /* renamed from: b */
    public final C19478g0 mo172356b() {
        return this.f57735b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutomationModel)) {
            return false;
        }
        AutomationModel automationModel = (AutomationModel) obj;
        return this.f57734a == automationModel.f57734a && Intrinsics.areEqual((Object) this.f57735b, (Object) automationModel.f57735b) && Intrinsics.areEqual((Object) this.f57736c, (Object) automationModel.f57736c);
    }

    public int hashCode() {
        return (((this.f57734a.hashCode() * 31) + this.f57735b.hashCode()) * 31) + this.f57736c.hashCode();
    }

    public String toString() {
        return "AutomationModel(decisionType=" + this.f57734a + ", rejectReason=" + this.f57735b + ", additionalInformation=" + this.f57736c + VersionRange.RIGHT_OPEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AutomationModel(com.jumio.core.models.automation.AutomationModel.C20978a r14, jumio.core.C19478g0 r15, java.lang.String r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r13 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L_0x0007
            com.jumio.core.models.automation.AutomationModel$a r0 = com.jumio.core.models.automation.AutomationModel.C20978a.NOT_AVAILABLE
            goto L_0x0008
        L_0x0007:
            r0 = r14
        L_0x0008:
            r1 = r17 & 2
            if (r1 == 0) goto L_0x001e
            jumio.core.g0 r1 = new jumio.core.g0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 255(0xff, float:3.57E-43)
            r12 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x001f
        L_0x001e:
            r1 = r15
        L_0x001f:
            r2 = r17 & 4
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = ""
            r3 = r13
            goto L_0x002a
        L_0x0027:
            r3 = r13
            r2 = r16
        L_0x002a:
            r13.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.automation.AutomationModel.<init>(com.jumio.core.models.automation.AutomationModel$a, jumio.core.g0, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
