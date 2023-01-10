package com.didi.map.global.flow.scene.order.serving.components;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.serving.param.OrderState;
import com.didi.map.global.flow.scene.order.serving.param.PageSceneID;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.ArrayList;
import java.util.List;

public class OrderFloatWindowManager implements IOrderFloatWindow {
    public static OrderFloatWindowManager Instance = null;

    /* renamed from: a */
    private static final String f29318a = "OrderFloatWindow";

    /* renamed from: b */
    private boolean f29319b;

    /* renamed from: c */
    private boolean f29320c;

    /* renamed from: d */
    private OrderFWMAgent f29321d = new OrderFWMAgent();

    /* renamed from: e */
    private List<String> f29322e = new ArrayList();

    public static final OrderFloatWindowManager Instance() {
        if (Instance == null) {
            synchronized (OrderFloatWindowManager.class) {
                if (Instance == null) {
                    Instance = new OrderFloatWindowManager();
                }
            }
        }
        return Instance;
    }

    private OrderFloatWindowManager() {
        boolean enableOrderFloatWindow = MapFlowApolloUtils.enableOrderFloatWindow();
        this.f29320c = enableOrderFloatWindow;
        this.f29319b = enableOrderFloatWindow;
        DLog.m10773d(f29318a, "apollo is enable:" + this.f29319b, new Object[0]);
        this.f29322e.add("21081");
        this.f29322e.add("21106");
    }

    public void setLicensePlate(String str) {
        if (this.f29319b) {
            this.f29321d.setLicensePlate(str);
        }
    }

    public void setModelBitmap(Bitmap bitmap) {
        if (this.f29319b) {
            this.f29321d.setModelBitmap(bitmap);
        }
    }

    public void updateEtaEda(int i, int i2) {
        if (this.f29319b) {
            this.f29321d.updateEtaEda(i, i2);
        }
    }

    public void updateOrderState(OrderState orderState) {
        if (this.f29319b) {
            this.f29321d.updateOrderState(orderState);
        }
    }

    public boolean isVisible() {
        if (this.f29319b) {
            return this.f29321d.isVisible();
        }
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.f29319b) {
            this.f29321d.setOnClickListener(onClickListener);
        }
    }

    public boolean hasPermission(Context context) {
        return this.f29321d.hasPermission(context);
    }

    public void requestPermission(Activity activity, int i) {
        this.f29321d.requestPermission(activity, i);
    }

    public void appTurnIntoForeground() {
        if (this.f29319b) {
            this.f29321d.appTurnIntoForeground();
        }
    }

    public void appTurnIntoBackGround() {
        if (this.f29319b) {
            this.f29321d.appTurnIntoBackGround();
        }
    }

    public void setContext(Context context) {
        if (this.f29319b) {
            this.f29321d.setContext(context);
        }
    }

    public void setProductId(String str) {
        DLog.m10773d(f29318a, "productId:" + str, new Object[0]);
        if (str == null || this.f29322e.contains(str)) {
            this.f29319b = false;
        } else {
            this.f29319b = this.f29320c;
        }
    }

    public void setOrderId(String str) {
        if (this.f29319b) {
            this.f29321d.setOrderId(str);
        }
    }

    public void setServingParam(ServingParam servingParam) {
        if (this.f29319b) {
            this.f29321d.setServingParam(servingParam);
        }
    }

    public void setMapSdkType(String str) {
        if (this.f29319b) {
            this.f29321d.setMapSdkType(str);
        }
    }

    public void setTripStage(int i) {
        if (this.f29319b) {
            this.f29321d.setTripStage(i);
        }
    }

    public void show() {
        if (this.f29319b) {
            this.f29321d.show();
        }
    }

    public void hidden() {
        if (this.f29319b) {
            this.f29321d.hidden();
        }
    }

    public void setPageScene(PageSceneID pageSceneID) {
        if (this.f29319b) {
            this.f29321d.setPageScene(pageSceneID);
        }
    }

    public void resetState() {
        if (this.f29319b) {
            this.f29321d.resetState();
        }
    }

    public static String getMapSdkType(Map map) {
        if (map == null || map.getMapVendor() == null) {
            return "google";
        }
        String mapVendor = map.getMapVendor().toString();
        if (TextUtils.isEmpty(mapVendor) || !mapVendor.equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
            return "google";
        }
        return "didi";
    }
}
