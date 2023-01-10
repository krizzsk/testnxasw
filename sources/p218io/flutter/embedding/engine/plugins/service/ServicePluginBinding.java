package p218io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import p218io.flutter.embedding.engine.plugins.service.ServiceAware;

/* renamed from: io.flutter.embedding.engine.plugins.service.ServicePluginBinding */
public interface ServicePluginBinding {
    void addOnModeChangeListener(ServiceAware.OnModeChangeListener onModeChangeListener);

    Object getLifecycle();

    Service getService();

    void removeOnModeChangeListener(ServiceAware.OnModeChangeListener onModeChangeListener);
}
