package com.threatmetrix.TrustDefender;

import android.util.Pair;

public interface TMXModuleInitializerInterface extends TMXModuleMetadataProviderInterface {
    String getNativeLibName();

    Pair<String, Object> initialize();
}
