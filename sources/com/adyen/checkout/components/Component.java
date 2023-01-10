package com.adyen.checkout.components;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.adyen.checkout.components.base.Configuration;

public interface Component<ComponentResultT, ConfigurationT extends Configuration> {
    ConfigurationT getConfiguration();

    void observe(LifecycleOwner lifecycleOwner, Observer<ComponentResultT> observer);

    void observeErrors(LifecycleOwner lifecycleOwner, Observer<ComponentError> observer);
}
