package com.didi.travel.psnger;

import com.didi.travel.psnger.common.net.host.HostGroupManager;

public class TEBridge {

    /* renamed from: a */
    private static TEBridgeConfig f46679a;

    public static void init(TEBridgeConfig tEBridgeConfig) {
        if (tEBridgeConfig == null) {
            throw new IllegalArgumentException("travel params is null!");
        } else if (tEBridgeConfig.getApplication() == null) {
            throw new IllegalArgumentException("context is null!");
        } else if (tEBridgeConfig.getClientConfig() != null) {
            f46679a = tEBridgeConfig;
            HostGroupManager.getInstance().configTargetHostGroup(hostConfig());
            TravelSDK.init(tEBridgeConfig.getApplication(), new TravelSdkParam(clientConfig()));
        } else {
            throw new IllegalArgumentException("travel params is null!");
        }
    }

    public static TEBridgeConfig getConfig() {
        return f46679a;
    }

    public static IClientConfig clientConfig() {
        TEBridgeConfig tEBridgeConfig = f46679a;
        if (tEBridgeConfig != null) {
            return tEBridgeConfig.getClientConfig();
        }
        return null;
    }

    public static IHostConfig hostConfig() {
        TEBridgeConfig tEBridgeConfig = f46679a;
        if (tEBridgeConfig != null) {
            return tEBridgeConfig.getHostConfig();
        }
        return null;
    }

    private static class TravelSdkParam implements ITravelParam {
        IClientConfig clientConfig;

        public TravelSdkParam(IClientConfig iClientConfig) {
            this.clientConfig = iClientConfig;
        }

        public String token() {
            return this.clientConfig.token();
        }

        public int curBid() {
            return this.clientConfig.currentBid();
        }

        public int locCity() {
            return this.clientConfig.locationCity();
        }

        public String tripCountry() {
            return this.clientConfig.tripCountry();
        }
    }
}
