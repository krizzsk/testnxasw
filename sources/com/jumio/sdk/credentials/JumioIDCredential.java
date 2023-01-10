package com.jumio.sdk.credentials;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.credentials.C20950a;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.scanpart.IDScanPart;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.List;
import java.util.Map;
import jumio.core.C19495o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0005\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0014\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00170\u00168F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, mo148868d2 = {"Lcom/jumio/sdk/credentials/JumioIDCredential;", "Lcom/jumio/sdk/credentials/JumioCredential;", "", "start$jumio_core_release", "()V", "start", "cancel", "", "country", "Lcom/jumio/sdk/document/JumioDocument;", "document", "", "isSupportedConfiguration", "setConfiguration", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanSide", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "initScanPart", "isConfigured", "()Z", "", "", "getCountries", "()Ljava/util/Map;", "countries", "getSuggestedCountry", "()Ljava/lang/String;", "suggestedCountry", "Lcom/jumio/core/Controller;", "controller", "Ljumio/core/o;", "credentialDataModel", "<init>", "(Lcom/jumio/core/Controller;Ljumio/core/o;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JumioIDCredential.kt */
public final class JumioIDCredential extends JumioCredential {

    /* renamed from: f */
    public final C20950a f57926f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioIDCredential(Controller controller, C19495o oVar) {
        super(controller, oVar);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(oVar, "credentialDataModel");
        this.f57926f = new C20950a((SettingsModel) controller.getDataManager().get(SettingsModel.class), oVar);
    }

    /* renamed from: a */
    public final void mo172896a() {
        this.f57926f.mo171990a(getData$jumio_core_release().mo148672f());
        Analytics.Companion.add(MobileEvents.userAction$default("configuration", (JumioScanStep) null, this.f57926f.mo171992b(), 2, (Object) null));
    }

    public void cancel() throws SDKNotConfiguredException {
        super.cancel();
        C19495o oVar = (C19495o) getData$jumio_core_release();
        oVar.mo148687a((String) null);
        oVar.mo148686a((JumioDocument) null);
    }

    public final Map<String, List<JumioDocument>> getCountries() {
        return this.f57926f.mo171989a();
    }

    public final String getSuggestedCountry() {
        return this.f57926f.mo171995c();
    }

    public synchronized JumioScanPart initScanPart(JumioScanSide jumioScanSide, JumioScanPartInterface jumioScanPartInterface) throws IllegalArgumentException {
        JumioScanPart activeScanPart$jumio_core_release;
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        if (!isValid()) {
            throw new IllegalArgumentException("Credential is not active".toString());
        } else if (getData$jumio_core_release().mo148672f().containsKey(jumioScanSide)) {
            boolean z = true;
            if (this.f57926f.mo171992b() != null) {
                if (getActiveScanPart$jumio_core_release() != null) {
                    z = false;
                }
                if (z) {
                    getData$jumio_core_release().mo148667a(jumioScanSide);
                    Controller controller$jumio_core_release = getController$jumio_core_release();
                    Object obj = getData$jumio_core_release().mo148672f().get(jumioScanSide);
                    Intrinsics.checkNotNull(obj);
                    setActiveScanPart$jumio_core_release(new JumioScanPart(new IDScanPart(controller$jumio_core_release, this, (IDScanPartModel) obj, jumioScanPartInterface)));
                    activeScanPart$jumio_core_release = getActiveScanPart$jumio_core_release();
                    Intrinsics.checkNotNull(activeScanPart$jumio_core_release);
                } else {
                    throw new IllegalArgumentException("Please finish the active scan part first".toString());
                }
            } else {
                throw new IllegalArgumentException("Country/Document selection not found".toString());
            }
        } else {
            throw new IllegalArgumentException((jumioScanSide + " not found").toString());
        }
        return activeScanPart$jumio_core_release;
    }

    public boolean isConfigured() {
        return isValid() && this.f57926f.mo171996d();
    }

    public final boolean isSupportedConfiguration(String str, JumioDocument jumioDocument) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(jumioDocument, "document");
        if (!isValid()) {
            return false;
        }
        return this.f57926f.mo171991a(str, jumioDocument);
    }

    public final void setConfiguration(String str, JumioDocument jumioDocument) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(jumioDocument, "document");
        if (isValid()) {
            if (isSupportedConfiguration(str, jumioDocument)) {
                this.f57926f.mo171993b(str, jumioDocument);
                C19495o oVar = (C19495o) getData$jumio_core_release();
                oVar.mo148687a(str);
                oVar.mo148686a(jumioDocument);
                mo172896a();
                return;
            }
            throw new IllegalArgumentException("The selected country/document combination is not valid".toString());
        }
    }

    public void start$jumio_core_release() {
        super.start$jumio_core_release();
        if (this.f57926f.mo171996d()) {
            mo172896a();
        }
    }
}
