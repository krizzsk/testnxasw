package com.adyen.checkout.components.p058ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.adyen.checkout.components.ComponentView;
import com.adyen.checkout.components.ViewableComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.OutputData;
import java.util.Locale;

/* renamed from: com.adyen.checkout.components.ui.view.AdyenLinearLayout */
public abstract class AdyenLinearLayout<OutputDataT extends OutputData, ConfigurationT extends Configuration, ComponentStateT, ComponentT extends ViewableComponent<OutputDataT, ConfigurationT, ComponentStateT>> extends LinearLayout implements ComponentView<OutputDataT, ComponentT> {

    /* renamed from: a */
    private ComponentT f898a;
    protected Context mLocalizedContext;

    /* access modifiers changed from: protected */
    public abstract void initLocalizedStrings(Context context);

    /* access modifiers changed from: protected */
    public abstract void observeComponentChanges(LifecycleOwner lifecycleOwner);

    public AdyenLinearLayout(Context context) {
        super(context);
    }

    public AdyenLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdyenLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(isInEditMode() ? 0 : 8);
    }

    public void attach(ComponentT componentt, LifecycleOwner lifecycleOwner) {
        this.f898a = componentt;
        onComponentAttached();
        m1056a(this.f898a.getConfiguration().getShopperLocale());
        initView();
        initLocalizedStrings(this.mLocalizedContext);
        setVisibility(0);
        this.f898a.sendAnalyticsEvent(getContext());
        observeComponentChanges(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public ComponentT getComponent() {
        ComponentT componentt = this.f898a;
        if (componentt != null) {
            return componentt;
        }
        throw new RuntimeException("Should not get Component before it's attached");
    }

    /* renamed from: a */
    private void m1056a(Locale locale) {
        android.content.res.Configuration configuration = new android.content.res.Configuration(getContext().getResources().getConfiguration());
        configuration.setLocale(locale);
        this.mLocalizedContext = getContext().createConfigurationContext(configuration);
    }
}
