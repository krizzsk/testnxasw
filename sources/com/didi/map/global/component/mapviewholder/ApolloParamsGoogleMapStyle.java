package com.didi.map.global.component.mapviewholder;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloParamsGoogleMapStyle {

    /* renamed from: a */
    private static ApolloParamsGoogleMapStyle f28235a;
    public boolean buildingEnable;
    public String styleJson = "";

    public static ApolloParamsGoogleMapStyle getInstance() {
        if (f28235a == null) {
            synchronized (ApolloParamsGoogleMapStyle.class) {
                if (f28235a == null) {
                    f28235a = new ApolloParamsGoogleMapStyle();
                }
            }
        }
        return f28235a;
    }

    private ApolloParamsGoogleMapStyle() {
        boolean z = false;
        this.buildingEnable = false;
        IToggle toggle = Apollo.getToggle("android_googlemap_style_config");
        if (toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            this.styleJson = (String) experiment.getParam("style_jsonString", "");
            this.buildingEnable = ((Integer) experiment.getParam("building_enable", 0)).intValue() == 1 ? true : z;
        }
    }

    public String toString() {
        return "ApolloParamsGoogleMapStyle{styleJson='" + this.styleJson + '\'' + ", buildingEnable=" + this.buildingEnable + '}';
    }
}
