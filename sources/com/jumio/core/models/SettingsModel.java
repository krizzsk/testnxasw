package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.document.DocumentType;
import com.jumio.core.model.StaticModel;
import com.jumio.core.network.ErrorMock;
import com.jumio.core.provider.IproovProvider;
import com.jumio.sdk.util.IsoCountryConverter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import jumio.core.C19487k;
import jumio.core.C19502r0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R$\u0010!\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R(\u0010$\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR(\u0010'\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0016@RX\u000e¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001bR$\u0010)\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R$\u00101\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015R$\u00103\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b3\u0010\u0015R$\u00109\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010;\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\u0015R$\u0010>\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b<\u00106\u001a\u0004\b=\u00108R$\u0010A\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R$\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\bB\u0010\u0013\u001a\u0004\bC\u0010\u0015R$\u0010I\u001a\u00020D2\u0006\u0010\f\u001a\u00020D8\u0006@BX\u000e¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010O\u001a\u00020J2\u0006\u0010\f\u001a\u00020J8\u0006@BX\u000e¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR4\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010P2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010P8\u0016@RX\u000e¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR(\u0010X\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0016@RX\u000e¢\u0006\f\n\u0004\bV\u0010\u0019\u001a\u0004\bW\u0010\u001bR(\u0010[\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\bY\u0010\u0019\u001a\u0004\bZ\u0010\u001bR$\u0010^\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b\\\u00106\u001a\u0004\b]\u00108R$\u0010a\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b_\u00106\u001a\u0004\b`\u00108R$\u0010g\u001a\u00020b2\u0006\u0010\f\u001a\u00020b8\u0006@BX\u000e¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR$\u0010j\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\bh\u0010\u0019\u001a\u0004\bi\u0010\u001bR$\u0010m\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bk\u00106\u001a\u0004\bl\u00108R$\u0010p\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bn\u00106\u001a\u0004\bo\u00108R$\u0010s\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bq\u00106\u001a\u0004\br\u00108R$\u0010v\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bt\u00106\u001a\u0004\bu\u00108R$\u0010x\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bF\u00106\u001a\u0004\bw\u00108R$\u0010{\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\by\u00106\u001a\u0004\bz\u00108R$\u0010}\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bL\u00106\u001a\u0004\b|\u00108R%\u0010\u0001\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\b~\u00106\u001a\u0004\b\u00108R\u0018\u0010\u0001\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0015¨\u0006\u0001"}, mo148868d2 = {"Lcom/jumio/core/models/SettingsModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/core/provider/IproovProvider;", "Ljumio/core/k;", "Ljumio/core/r0;", "Lorg/json/JSONObject;", "json", "", "localize", "", "fromJson", "Ljava/util/Date;", "<set-?>", "a", "Ljava/util/Date;", "getServerTimestamp", "()Ljava/util/Date;", "serverTimestamp", "b", "Z", "getHasBarcodeScannerKey", "()Z", "hasBarcodeScannerKey", "", "c", "Ljava/lang/String;", "getBarcodeScannerKey", "()Ljava/lang/String;", "barcodeScannerKey", "d", "isBrandingEnabled", "e", "getReturnImages", "returnImages", "f", "getCountryForIp", "countryForIp", "g", "getStateForIp", "stateForIp", "h", "isAdditionalDataPointsEnabled", "Lcom/jumio/core/models/CountryDocumentModel;", "i", "Lcom/jumio/core/models/CountryDocumentModel;", "getCountryModel", "()Lcom/jumio/core/models/CountryDocumentModel;", "countryModel", "j", "isLoaded", "k", "isAnalyticsEnabled", "", "l", "I", "getMaxLivenessImages", "()I", "maxLivenessImages", "m", "isInstantFeedbackEnabled", "n", "getAutomationMaxRetries", "automationMaxRetries", "o", "getIproovMaxAttempts", "iproovMaxAttempts", "p", "isCvAnalytics", "", "q", "D", "getCvMrzThreshold", "()D", "cvMrzThreshold", "", "r", "F", "getFocusScore", "()F", "focusScore", "", "s", "Ljava/util/List;", "getConsentStates", "()Ljava/util/List;", "consentStates", "t", "getConsentUrl", "consentUrl", "u", "getDataPrivacyUrl", "dataPrivacyUrl", "v", "getNfcRetries", "nfcRetries", "w", "getNfcTimeout", "nfcTimeout", "Lcom/jumio/core/models/DataDogModel;", "x", "Lcom/jumio/core/models/DataDogModel;", "getDataDog", "()Lcom/jumio/core/models/DataDogModel;", "dataDog", "y", "getWorkflowDefinitionKey", "workflowDefinitionKey", "z", "getUpload", "upload", "A", "getUsability", "usability", "B", "getFinalize", "finalize", "C", "getExtractdata", "extractdata", "getAnalytics", "analytics", "E", "getReporting", "reporting", "getIproovtoken", "iproovtoken", "G", "getIproovvalidate", "iproovvalidate", "isConsentRequired", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
@PersistWith("SettingsModel")
/* compiled from: SettingsModel.kt */
public final class SettingsModel implements StaticModel, IproovProvider, C19487k, C19502r0 {

    /* renamed from: A */
    public int f57700A = 15000;

    /* renamed from: B */
    public int f57701B = 10000;

    /* renamed from: C */
    public int f57702C = 20000;

    /* renamed from: D */
    public int f57703D = 10000;

    /* renamed from: E */
    public int f57704E = 10000;

    /* renamed from: F */
    public int f57705F = 15000;

    /* renamed from: G */
    public int f57706G = 10000;

    /* renamed from: a */
    public Date f57707a = new Date();

    /* renamed from: b */
    public boolean f57708b;

    /* renamed from: c */
    public String f57709c;

    /* renamed from: d */
    public boolean f57710d = true;

    /* renamed from: e */
    public boolean f57711e;

    /* renamed from: f */
    public String f57712f;

    /* renamed from: g */
    public String f57713g;

    /* renamed from: h */
    public boolean f57714h;

    /* renamed from: i */
    public final CountryDocumentModel f57715i = new CountryDocumentModel();

    /* renamed from: j */
    public boolean f57716j;

    /* renamed from: k */
    public boolean f57717k;

    /* renamed from: l */
    public int f57718l;

    /* renamed from: m */
    public boolean f57719m;

    /* renamed from: n */
    public int f57720n;

    /* renamed from: o */
    public int f57721o;

    /* renamed from: p */
    public boolean f57722p;

    /* renamed from: q */
    public double f57723q = 0.9d;

    /* renamed from: r */
    public float f57724r = -1.0f;

    /* renamed from: s */
    public List<String> f57725s;

    /* renamed from: t */
    public String f57726t;

    /* renamed from: u */
    public String f57727u;

    /* renamed from: v */
    public int f57728v = 1;

    /* renamed from: w */
    public int f57729w = 10000;

    /* renamed from: x */
    public DataDogModel f57730x = new DataDogModel((String) null, (String) null, 3, (DefaultConstructorMarker) null);

    /* renamed from: y */
    public String f57731y = "";

    /* renamed from: z */
    public int f57732z = 20000;

    /* renamed from: a */
    public final void mo172328a(JSONObject jSONObject) throws JSONException {
        int i;
        float f;
        boolean z;
        String str = null;
        String optString = jSONObject.optString("barcodeScannerKey", (String) null);
        this.f57709c = optString;
        this.f57708b = !(optString == null || optString.length() == 0);
        try {
            i = jSONObject.optInt("iproovMaxAttempts", 3);
        } catch (Exception unused) {
            i = 0;
        }
        this.f57721o = i;
        try {
            f = (float) jSONObject.getDouble("focusScore");
        } catch (Exception unused2) {
            f = -1.0f;
        }
        this.f57724r = f;
        try {
            z = jSONObject.optBoolean("cvAnalytics", false);
        } catch (Exception unused3) {
            z = false;
        }
        this.f57722p = z;
        double d = 0.9d;
        try {
            d = jSONObject.optDouble("cvMrzThreshold", 0.9d);
        } catch (Exception unused4) {
        }
        this.f57723q = d;
        try {
            this.f57719m = jSONObject.getBoolean("instantFeedback");
            this.f57720n = jSONObject.getInt("maxRetries");
        } catch (Exception unused5) {
            this.f57719m = false;
            this.f57720n = 2;
        }
        try {
            String string = jSONObject.getString("consentRequired");
            Intrinsics.checkNotNullExpressionValue(string, "configuration.getString(\"consentRequired\")");
            this.f57725s = new Regex(",").split(string, 0);
            this.f57726t = jSONObject.getString("consentURL");
        } catch (Exception unused6) {
            this.f57725s = null;
            this.f57726t = null;
        }
        try {
            str = jSONObject.getString("dataPrivacyUrl");
        } catch (Exception unused7) {
        }
        this.f57727u = str;
        try {
            this.f57728v = jSONObject.getInt("nfcRetries");
            this.f57729w = jSONObject.getInt("nfcTimeout");
        } catch (Exception unused8) {
            this.f57728v = 1;
            this.f57729w = 10000;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("dataDog");
            DataDogModel dataDogModel = this.f57730x;
            String string2 = jSONObject2.getString("appId");
            Intrinsics.checkNotNullExpressionValue(string2, "dataDogModelJson.getString(\"appId\")");
            dataDogModel.setAppId(string2);
            DataDogModel dataDogModel2 = this.f57730x;
            String string3 = jSONObject2.getString("clientId");
            Intrinsics.checkNotNullExpressionValue(string3, "dataDogModelJson.getString(\"clientId\")");
            dataDogModel2.setClientId(string3);
        } catch (Exception unused9) {
        }
        try {
            JSONObject jSONObject3 = jSONObject.getJSONObject("networkTimeouts");
            this.f57732z = jSONObject3.optInt("upload", 20000);
            this.f57700A = jSONObject3.optInt("usability", 15000);
            this.f57701B = jSONObject3.optInt("finalize", 10000);
            this.f57702C = jSONObject3.optInt("extractdata", 20000);
            this.f57703D = jSONObject3.optInt("analytics", 10000);
            this.f57704E = jSONObject3.optInt("reporting", 10000);
            this.f57705F = jSONObject3.optInt("iproovtoken", 15000);
            this.f57706G = jSONObject3.optInt("iproovvalidate", 10000);
        } catch (Exception unused10) {
        }
    }

    /* renamed from: b */
    public final Date mo172329b(JSONObject jSONObject) throws JSONException {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(jSONObject.optString("timestamp"));
        } catch (Exception e) {
            Log.printStackTrace(e);
            return null;
        }
    }

    public final void fromJson(JSONObject jSONObject, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        ErrorMock.onSettingsMock(jSONObject);
        Date b = mo172329b(jSONObject);
        if (b != null) {
            this.f57707a = b;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("configurations");
        if (optJSONObject != null) {
            mo172328a(optJSONObject);
        }
        this.f57710d = jSONObject.optBoolean("brandingEnabled", true);
        this.f57711e = jSONObject.optBoolean("returnImages", false);
        this.f57712f = jSONObject.optString("countryForIp");
        this.f57713g = jSONObject.optString("stateForIp");
        this.f57717k = jSONObject.optBoolean("analyticsEnabled", true);
        this.f57714h = jSONObject.optBoolean("additionalDataPoints", false);
        int optInt = jSONObject.optInt("maxLivenessImages", 10);
        this.f57718l = optInt;
        if (optInt < 0 || optInt > 10) {
            this.f57718l = 10;
        }
        mo172327a(jSONObject.optJSONArray("supportedCountries"), z);
        String optString = jSONObject.optString("workflowDefinitionKey", (String) null);
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"workflowDefinitionKey\", null)");
        this.f57731y = optString;
        this.f57716j = true;
    }

    public int getAnalytics() {
        return this.f57703D;
    }

    public final int getAutomationMaxRetries() {
        return this.f57720n;
    }

    public final String getBarcodeScannerKey() {
        return this.f57709c;
    }

    public List<String> getConsentStates() {
        return this.f57725s;
    }

    public String getConsentUrl() {
        return this.f57726t;
    }

    public final String getCountryForIp() {
        return this.f57712f;
    }

    public final CountryDocumentModel getCountryModel() {
        return this.f57715i;
    }

    public final double getCvMrzThreshold() {
        return this.f57723q;
    }

    public final DataDogModel getDataDog() {
        return this.f57730x;
    }

    public final String getDataPrivacyUrl() {
        return this.f57727u;
    }

    public int getExtractdata() {
        return this.f57702C;
    }

    public int getFinalize() {
        return this.f57701B;
    }

    public final float getFocusScore() {
        return this.f57724r;
    }

    public final boolean getHasBarcodeScannerKey() {
        return this.f57708b;
    }

    public int getIproovMaxAttempts() {
        return this.f57721o;
    }

    public int getIproovtoken() {
        return this.f57705F;
    }

    public int getIproovvalidate() {
        return this.f57706G;
    }

    public final int getMaxLivenessImages() {
        return this.f57718l;
    }

    public final int getNfcRetries() {
        return this.f57728v;
    }

    public final int getNfcTimeout() {
        return this.f57729w;
    }

    public int getReporting() {
        return this.f57704E;
    }

    public final boolean getReturnImages() {
        return this.f57711e;
    }

    public final Date getServerTimestamp() {
        return this.f57707a;
    }

    public String getStateForIp() {
        return this.f57713g;
    }

    public int getUpload() {
        return this.f57732z;
    }

    public int getUsability() {
        return this.f57700A;
    }

    public final String getWorkflowDefinitionKey() {
        return this.f57731y;
    }

    public final boolean isAdditionalDataPointsEnabled() {
        return this.f57714h;
    }

    public final boolean isAnalyticsEnabled() {
        return this.f57717k;
    }

    public final boolean isBrandingEnabled() {
        return this.f57710d;
    }

    public boolean isConsentRequired() {
        if (getConsentStates() != null) {
            List<String> consentStates = getConsentStates();
            Intrinsics.checkNotNull(consentStates);
            if (consentStates.size() != 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCvAnalytics() {
        return this.f57722p;
    }

    public final boolean isInstantFeedbackEnabled() {
        return this.f57719m;
    }

    public final boolean isLoaded() {
        return this.f57716j;
    }

    /* renamed from: a */
    public final void mo172327a(JSONArray jSONArray, boolean z) throws JSONException {
        int length;
        this.f57715i.mo172210a();
        if (jSONArray != null && jSONArray.length() != 0 && (length = jSONArray.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("country");
                Intrinsics.checkNotNullExpressionValue(string, "jsonCountry.getString(\"country\")");
                Country country = new Country(string, z);
                if (!StringsKt.equals(country.getName(), IsoCountryConverter.convertToAlpha2(jSONObject.getString("country")), true)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("idTypes");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        if (length2 > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                Intrinsics.checkNotNullExpressionValue(jSONObject2, "supportedIdTypes.getJSONObject(j)");
                                arrayList.add(new DocumentType(jSONObject2));
                                if (i4 >= length2) {
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                    } else {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("idTypes");
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonCountry.getJSONObject(\"idTypes\")");
                        arrayList.add(new DocumentType(jSONObject3));
                    }
                    if (!arrayList.isEmpty()) {
                        CollectionsKt.sort(arrayList);
                        this.f57715i.mo172211a(country, (ArrayList<DocumentType>) arrayList);
                    }
                }
                if (i2 < length) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
