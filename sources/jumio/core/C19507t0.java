package jumio.core;

import com.jumio.core.persistence.DataManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.t0 */
/* compiled from: UserConsent.kt */
public final class C19507t0 {

    /* renamed from: a */
    public static final C19507t0 f55406a = new C19507t0();

    /* renamed from: a */
    public final boolean mo148739a(DataManager dataManager, C19487k kVar) {
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        if (kVar == null || !kVar.isConsentRequired()) {
            return false;
        }
        String stateForIp = kVar.getStateForIp();
        String a = C19512x.m41239a((C19464b) dataManager.get(C19464b.class));
        List<String> consentStates = kVar.getConsentStates();
        if (!(consentStates != null && CollectionsKt.contains(consentStates, stateForIp))) {
            List<String> consentStates2 = kVar.getConsentStates();
            if (consentStates2 != null && consentStates2.contains(a)) {
                return true;
            }
            return false;
        }
        return true;
    }
}
