package com.didi.map.global.flow.presenter;

import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.SceneSwitcher;
import com.didi.map.global.flow.scene.mainpage.CarMainPageScene;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.scene.mainpage.MainPageSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.over.IMiniBusOrderOverSceneController;
import com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverScene;
import com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.pre.IMiniBusConfirmSceneController;
import com.didi.map.global.flow.scene.minibus.scene.pre.MiniBusConfirmScene;
import com.didi.map.global.flow.scene.minibus.scene.pre.MiniBusConfirmSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.service.IMiniBusSctxSceneController;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusAppointParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusAppointScene;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusInServiceScene;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusSctxSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusWaitingScene;
import com.didi.map.global.flow.scene.order.confirm.normal.IOrderConfirmController;
import com.didi.map.global.flow.scene.order.confirm.normal.NewOrderConfirmScene;
import com.didi.map.global.flow.scene.order.confirm.normal.OrderConfirmSceneParam;
import com.didi.map.global.flow.scene.order.serving.ILockScreenServingController;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam;
import com.didi.map.global.flow.scene.order.serving.param.ServiceOverParam;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.order.serving.scene.ServiceOverScene;
import com.didi.map.global.flow.scene.order.serving.scene.sctx.DrivingSctxScene;
import com.didi.map.global.flow.scene.order.serving.scene.sctx.LockScreenSctxScene;
import com.didi.map.global.flow.scene.order.serving.scene.sctx.WaitingForDrivingAppointScene;
import com.didi.map.global.flow.scene.order.waiting.IWaitingForReplyController;
import com.didi.map.global.flow.scene.order.waiting.WaitingForReplyOldScene;
import com.didi.map.global.flow.scene.order.waiting.WaitingForReplyParam;
import com.didi.map.global.flow.scene.order.waiting.WaitingForReplyScene;
import com.didi.map.global.flow.scene.order.waiting.p124v2.IWaitingForReplyControllerV2;
import com.didi.map.global.flow.scene.order.waiting.p124v2.WaitingForReplyParamV2;
import com.didi.map.global.flow.scene.order.waiting.p124v2.WaitingForReplySceneV2;
import com.didi.map.global.flow.scene.simple.ISimpleMapSceneController;
import com.didi.map.global.flow.scene.simple.impl.SimpleMapScene;
import com.didi.map.global.flow.scene.simple.params.SimpleSceneParams;
import com.didi.map.global.flow.scene.sug.IPopSugSceneController;
import com.didi.map.global.flow.scene.sug.PopSugScene;
import com.didi.map.global.flow.scene.sug.PopSugSceneParam;
import com.didi.map.global.flow.scene.vamos.confirm.geton.IVamosConfirmGetOnController;
import com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnScene;
import com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnSceneParam;
import com.didi.map.global.flow.scene.vamos.confirm.order.IVamosConfirmOrderController;
import com.didi.map.global.flow.scene.vamos.confirm.order.VamosConfirmOrderScene;
import com.didi.map.global.flow.scene.vamos.confirm.order.VamosConfirmOrderSceneParam;
import com.didi.map.global.flow.scene.vamos.confirm.order.driver.IVamosDriverConfirmOrderController;
import com.didi.map.global.flow.scene.vamos.confirm.order.driver.VamosDriverConfirmOrderScene;
import com.didi.map.global.flow.scene.vamos.confirm.order.driver.VamosDriverConfirmOrderSceneParam;
import com.didi.map.global.flow.scene.vamos.homepage.VamosHomePageScene;
import com.didi.map.global.flow.scene.vamos.homepage.VamosHomePageSceneParam;
import com.didi.map.global.flow.scene.vamos.orderpreview.DriverVamosOrderPreviewScene;
import com.didi.map.global.flow.scene.vamos.orderpreview.IVamosOrderPreviewController;
import com.didi.map.global.flow.scene.vamos.orderpreview.PaxVamosOrderPreviewScene;
import com.didi.map.global.flow.scene.vamos.orderpreview.param.VamosOrderPreviewParams;
import com.didi.map.global.flow.scene.vamos.orderwait.DriverVamosOrderWaitScene;
import com.didi.map.global.flow.scene.vamos.orderwait.IVamosOrderWaitController;
import com.didi.map.global.flow.scene.vamos.orderwait.PaxVamosOrderWaitScene;
import com.didi.map.global.flow.scene.vamos.orderwait.param.VamosOrderWaitParams;
import com.didi.map.global.flow.scene.vamos.sctx.driver.IVamosDriverSctxController;
import com.didi.map.global.flow.scene.vamos.sctx.driver.VamosDriverPickupScene;
import com.didi.map.global.flow.scene.vamos.sctx.driver.VamosDriverSendoffScene;
import com.didi.map.global.flow.scene.vamos.sctx.driver.VamosDriverWaitScene;
import com.didi.map.global.flow.scene.vamos.sctx.driver.param.VamosDriverSctxParam;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.IVamosPssengerSctxSceneController;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.VamosInServiceScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.VamosPickupScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.VamosWaitingScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.param.VamosSctxSceneParam;
import com.didi.map.global.flow.scene.vamos.sug.IVamosSugPageSceneController;
import com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene;
import com.didi.map.global.flow.scene.vamos.sug.VamosSugPageSceneParam;

public class MapFlowPresenter implements IMapFlowPresenter {

    /* renamed from: a */
    private static final String f28794a = "MapFlowPresenter";

    /* renamed from: b */
    private IScene f28795b;

    /* renamed from: c */
    private MapViewHolder f28796c;

    public MapFlowPresenter(MapViewHolder mapViewHolder) {
        this.f28796c = mapViewHolder;
    }

    public IOrderConfirmController switch2OrderConfirmScene(OrderConfirmSceneParam orderConfirmSceneParam) {
        NewOrderConfirmScene newOrderConfirmScene = new NewOrderConfirmScene(orderConfirmSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, newOrderConfirmScene);
        return newOrderConfirmScene;
    }

    public ICarMainPageController switch2CarMainPageScene(MainPageSceneParam mainPageSceneParam) {
        CarMainPageScene carMainPageScene = new CarMainPageScene(mainPageSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, carMainPageScene);
        return carMainPageScene;
    }

    public IVamosSugPageSceneController switch2VamosSugPageScene(VamosSugPageSceneParam vamosSugPageSceneParam) {
        VamosSugPageScene vamosSugPageScene = new VamosSugPageScene(vamosSugPageSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosSugPageScene);
        return vamosSugPageScene;
    }

    public IPopSugSceneController switch2PopSugPageScene(PopSugSceneParam popSugSceneParam) {
        PopSugScene popSugScene = new PopSugScene(popSugSceneParam, this.f28796c);
        popSugScene.enter((Bundle) null);
        return popSugScene;
    }

    public IWaitingForReplyControllerV2 switch2WaitingForReplySceneV2(WaitingForReplyParamV2 waitingForReplyParamV2) {
        WaitingForReplySceneV2 waitingForReplySceneV2 = new WaitingForReplySceneV2(waitingForReplyParamV2, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, waitingForReplySceneV2);
        return waitingForReplySceneV2;
    }

    public IWaitingForReplyController switch2WaitingForReplyScene(WaitingForReplyParam waitingForReplyParam) {
        WaitingForReplyScene waitingForReplyScene = new WaitingForReplyScene(waitingForReplyParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, waitingForReplyScene);
        return waitingForReplyScene;
    }

    public IWaitingForReplyController switch2WaitingForReplyOldScene(WaitingForReplyParam waitingForReplyParam) {
        WaitingForReplyOldScene waitingForReplyOldScene = new WaitingForReplyOldScene(waitingForReplyParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, waitingForReplyOldScene);
        return waitingForReplyOldScene;
    }

    public IServingController switch2WaitingForDrivingAppointScene(ServingParam servingParam) {
        WaitingForDrivingAppointScene waitingForDrivingAppointScene = new WaitingForDrivingAppointScene(servingParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, waitingForDrivingAppointScene);
        return waitingForDrivingAppointScene;
    }

    public IServingController switch2WaitingForDrivingScene(ServingParam servingParam) {
        DrivingSctxScene drivingSctxScene = new DrivingSctxScene(servingParam, this.f28796c, 0);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, drivingSctxScene);
        return drivingSctxScene;
    }

    public ILockScreenServingController switch2LockScreenScene(LockScreenServingParam lockScreenServingParam) {
        LockScreenSctxScene lockScreenSctxScene = new LockScreenSctxScene(lockScreenServingParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, lockScreenSctxScene);
        return lockScreenSctxScene;
    }

    public IServingController switch2InServiceScene(ServingParam servingParam) {
        DrivingSctxScene drivingSctxScene = new DrivingSctxScene(servingParam, this.f28796c, 1);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, drivingSctxScene);
        return drivingSctxScene;
    }

    public ISceneController switch2ServiceOverScene(ServiceOverParam serviceOverParam) {
        ServiceOverScene serviceOverScene = new ServiceOverScene(serviceOverParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, serviceOverScene);
        return serviceOverScene;
    }

    public ISceneController switch2VamosHomePageScene(VamosHomePageSceneParam vamosHomePageSceneParam) {
        VamosHomePageScene vamosHomePageScene = new VamosHomePageScene(vamosHomePageSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosHomePageScene);
        return vamosHomePageScene;
    }

    public IVamosDriverConfirmOrderController switch2VamosDriverConfirmOrderScene(VamosDriverConfirmOrderSceneParam vamosDriverConfirmOrderSceneParam) {
        VamosDriverConfirmOrderScene vamosDriverConfirmOrderScene = new VamosDriverConfirmOrderScene(vamosDriverConfirmOrderSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosDriverConfirmOrderScene);
        return vamosDriverConfirmOrderScene;
    }

    public IVamosConfirmOrderController switch2VamosConfirmOrderScene(VamosConfirmOrderSceneParam vamosConfirmOrderSceneParam) {
        VamosConfirmOrderScene vamosConfirmOrderScene = new VamosConfirmOrderScene(vamosConfirmOrderSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosConfirmOrderScene);
        return vamosConfirmOrderScene;
    }

    public IVamosConfirmGetOnController switch2VamosConfirmGetOnScene(VamosConfirmGetOnSceneParam vamosConfirmGetOnSceneParam) {
        VamosConfirmGetOnScene vamosConfirmGetOnScene = new VamosConfirmGetOnScene(vamosConfirmGetOnSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosConfirmGetOnScene);
        return vamosConfirmGetOnScene;
    }

    public IVamosPssengerSctxSceneController switchVamosPassengerPickupScene(VamosSctxSceneParam vamosSctxSceneParam) {
        VamosPickupScene vamosPickupScene = new VamosPickupScene(vamosSctxSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosPickupScene);
        return vamosPickupScene;
    }

    public IVamosPssengerSctxSceneController switchVamosPassengerWaitingScene(VamosSctxSceneParam vamosSctxSceneParam) {
        VamosWaitingScene vamosWaitingScene = new VamosWaitingScene(vamosSctxSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosWaitingScene);
        return vamosWaitingScene;
    }

    public IVamosPssengerSctxSceneController switchVamosPassengerInServiceScene(VamosSctxSceneParam vamosSctxSceneParam) {
        VamosInServiceScene vamosInServiceScene = new VamosInServiceScene(vamosSctxSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosInServiceScene);
        return vamosInServiceScene;
    }

    public IVamosDriverSctxController switch2VamosDriverPickupScene(VamosDriverSctxParam vamosDriverSctxParam) {
        VamosDriverPickupScene vamosDriverPickupScene = new VamosDriverPickupScene(vamosDriverSctxParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosDriverPickupScene);
        return vamosDriverPickupScene;
    }

    public IVamosDriverSctxController switch2VamosDriverWaitScene(VamosDriverSctxParam vamosDriverSctxParam) {
        VamosDriverWaitScene vamosDriverWaitScene = new VamosDriverWaitScene(vamosDriverSctxParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosDriverWaitScene);
        return vamosDriverWaitScene;
    }

    public IVamosDriverSctxController switch2VamosDriverSendoffScene(VamosDriverSctxParam vamosDriverSctxParam) {
        VamosDriverSendoffScene vamosDriverSendoffScene = new VamosDriverSendoffScene(vamosDriverSctxParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, vamosDriverSendoffScene);
        return vamosDriverSendoffScene;
    }

    public IVamosOrderPreviewController switch2VamosDriverOrderPreviewScene(VamosOrderPreviewParams vamosOrderPreviewParams) {
        DriverVamosOrderPreviewScene driverVamosOrderPreviewScene = new DriverVamosOrderPreviewScene(vamosOrderPreviewParams, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, driverVamosOrderPreviewScene);
        return driverVamosOrderPreviewScene;
    }

    public IVamosOrderPreviewController switch2VamosPaxOrderPreviewScene(VamosOrderPreviewParams vamosOrderPreviewParams) {
        PaxVamosOrderPreviewScene paxVamosOrderPreviewScene = new PaxVamosOrderPreviewScene(vamosOrderPreviewParams, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, paxVamosOrderPreviewScene);
        return paxVamosOrderPreviewScene;
    }

    public IVamosOrderWaitController switch2VamosDriverOrderWaitScene(VamosOrderWaitParams vamosOrderWaitParams) {
        DriverVamosOrderWaitScene driverVamosOrderWaitScene = new DriverVamosOrderWaitScene(vamosOrderWaitParams, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, driverVamosOrderWaitScene);
        return driverVamosOrderWaitScene;
    }

    public IVamosOrderWaitController switch2VamosPaxOrderWaitScene(VamosOrderWaitParams vamosOrderWaitParams) {
        PaxVamosOrderWaitScene paxVamosOrderWaitScene = new PaxVamosOrderWaitScene(vamosOrderWaitParams, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, paxVamosOrderWaitScene);
        return paxVamosOrderWaitScene;
    }

    public ISimpleMapSceneController openSimpleScene(SimpleSceneParams simpleSceneParams) {
        SimpleMapScene simpleMapScene = new SimpleMapScene(simpleSceneParams, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, simpleMapScene);
        return simpleMapScene;
    }

    public IMiniBusConfirmSceneController switchMiniBusConfirmScene(MiniBusConfirmSceneParam miniBusConfirmSceneParam) {
        MiniBusConfirmScene miniBusConfirmScene = new MiniBusConfirmScene(miniBusConfirmSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, miniBusConfirmScene);
        return miniBusConfirmScene;
    }

    public IMiniBusOrderOverSceneController switchMiniBusOrderOverScene(MiniBusOrderOverSceneParam miniBusOrderOverSceneParam) {
        MiniBusOrderOverScene miniBusOrderOverScene = new MiniBusOrderOverScene(miniBusOrderOverSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, miniBusOrderOverScene);
        return miniBusOrderOverScene;
    }

    public ISceneController switchMiniBusAppointScene(MiniBusAppointParam miniBusAppointParam) {
        MiniBusAppointScene miniBusAppointScene = new MiniBusAppointScene(miniBusAppointParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, miniBusAppointScene);
        return miniBusAppointScene;
    }

    public IMiniBusSctxSceneController switchMiniBusInsServiceScene(MiniBusSctxSceneParam miniBusSctxSceneParam) {
        MiniBusInServiceScene miniBusInServiceScene = new MiniBusInServiceScene(miniBusSctxSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, miniBusInServiceScene);
        return miniBusInServiceScene;
    }

    public IMiniBusSctxSceneController switchMiniBusPickingScene(MiniBusSctxSceneParam miniBusSctxSceneParam) {
        MiniBusWaitingScene miniBusWaitingScene = new MiniBusWaitingScene(miniBusSctxSceneParam, this.f28796c);
        this.f28795b = SceneSwitcher.switchScene(this.f28795b, miniBusWaitingScene);
        return miniBusWaitingScene;
    }

    public void clear() {
        IScene iScene = this.f28795b;
        if (iScene != null) {
            iScene.leave();
            this.f28795b = null;
        }
        MapViewHolder mapViewHolder = this.f28796c;
        if (mapViewHolder != null) {
            mapViewHolder.setLocationVisible(false);
        }
    }

    public void onDestroy() {
        clear();
    }

    public void onResume() {
        IScene iScene = this.f28795b;
        if (iScene != null) {
            iScene.onResume();
        }
    }

    public void onPause() {
        IScene iScene = this.f28795b;
        if (iScene != null) {
            iScene.onPause();
        }
    }

    public IScene getCurrentScene() {
        return this.f28795b;
    }
}
