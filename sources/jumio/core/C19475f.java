package jumio.core;

import android.content.Context;
import com.jumio.core.network.C20982b;
import com.jumio.core.persistence.DataManager;

/* renamed from: jumio.core.f */
/* compiled from: ApiCallSettings.kt */
public interface C19475f {
    Context getContext();

    DataManager getDataManager();

    C20982b getEncryptionProvider();

    String getEndpoint();

    String getUserAgent();
}
