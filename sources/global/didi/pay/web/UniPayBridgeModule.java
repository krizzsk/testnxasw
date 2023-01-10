package global.didi.pay.web;

import android.app.Activity;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule;
import org.json.JSONObject;

public class UniPayBridgeModule extends FusionBridgeModule {
    /* access modifiers changed from: private */
    public Activity mActivity;

    public UniPayBridgeModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.mActivity = hybridableContainer.getActivity();
        addUniPayFunction();
    }

    private void addUniPayFunction() {
        addFunction("selectedCoupon", new CouponSelectedFunction());
        addFunction("cancelSelectedCoupon", new CouponCancelFunction());
    }

    private class CouponSelectedFunction extends FusionBridgeModule.Function {
        private CouponSelectedFunction() {
        }

        public JSONObject execute(JSONObject jSONObject) {
            UniPayBridgeFunctions.doSelectedCoupon(UniPayBridgeModule.this.mActivity, jSONObject);
            return null;
        }
    }

    private class CouponCancelFunction extends FusionBridgeModule.Function {
        private CouponCancelFunction() {
        }

        public JSONObject execute(JSONObject jSONObject) {
            UniPayBridgeFunctions.doCancelSelectedCoupon(UniPayBridgeModule.this.mActivity, jSONObject);
            return null;
        }
    }
}
