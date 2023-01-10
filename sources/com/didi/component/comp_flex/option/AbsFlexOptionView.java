package com.didi.component.comp_flex.option;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.comp_flex.option.OperationPanelModel;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsFlexOptionView implements View.OnClickListener, IFlexOptionView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f14035a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f14036b;

    /* renamed from: c */
    private FlexOptionPresenter f14037c;

    /* renamed from: d */
    private View f14038d;

    /* renamed from: e */
    private View f14039e;

    /* renamed from: f */
    private PopupWindow f14040f;

    /* renamed from: g */
    private OperationPanelModel f14041g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f14042h = true;

    public AbsFlexOptionView(Context context, ViewGroup viewGroup) {
        this.f14036b = context;
        this.f14038d = viewGroup;
        View inflate = LayoutInflater.from(context).inflate(R.layout.flex_option_layout, viewGroup, false);
        this.f14039e = inflate;
        inflate.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        showOptionPop();
    }

    public void dismissPopupWindow() {
        PopupWindow popupWindow = this.f14040f;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f14040f.dismiss();
            this.f14040f = null;
        }
    }

    public void onDestroy() {
        dismissPopupWindow();
    }

    public void showOptionPop() {
        View inflate = LayoutInflater.from(this.f14036b).inflate(R.layout.flex_option_popup, (ViewGroup) null);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AbsFlexOptionView.this.dismissPopupWindow();
            }
        });
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_container);
        OperationPanelModel operationPanelModel = this.f14041g;
        if (!(operationPanelModel == null || operationPanelModel.data == null || this.f14041g.data.items == null || this.f14041g.data.items.size() <= 0)) {
            for (final OperationPanelModel.ItemModel next : this.f14041g.data.items) {
                if (next.richBtn != null && !TextUtils.isEmpty(next.richBtn.getContent())) {
                    View inflate2 = LayoutInflater.from(this.f14036b).inflate(R.layout.flex_option_pop_item_layout, (ViewGroup) null);
                    next.richBtn.bindTextView((TextView) inflate2.findViewById(R.id.flex_option_tv));
                    inflate2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            AbsFlexOptionView.this.dismissPopupWindow();
                            if (next.url != null && AbsFlexOptionView.this.f14042h) {
                                boolean unused = AbsFlexOptionView.this.f14042h = false;
                                try {
                                    GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_canceltrip_ck");
                                    ((Request) DRouter.build(next.url).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(AbsFlexOptionView.this.f14036b, new RouterCallback() {
                                        public void onResult(Result result) {
                                            JSONObject optJSONObject;
                                            JSONObject optJSONObject2;
                                            boolean unused = AbsFlexOptionView.this.f14042h = true;
                                            AbsFlexOptionView.this.f14035a.info("onResult: 取消订单  数据提交", new Object[0]);
                                            String string = result.getString("KEY_CALLBACK");
                                            if (!TextUtils.isEmpty(string)) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(string);
                                                    if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("extension") && (optJSONObject2 = optJSONObject.optJSONObject("extension")) != null && optJSONObject2.optInt("errno") != 0) {
                                                        LEGOToastHelper.showToast(AbsFlexOptionView.this.f14036b, optJSONObject2.optString("errmsg"));
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    if (!TextUtils.isEmpty(next.iconUrl)) {
                        Glide.with(this.f14036b).load(next.iconUrl).into((ImageView) inflate2.findViewById(R.id.flex_option_close_img));
                    }
                    linearLayout.addView(inflate2);
                }
            }
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
        this.f14040f = popupWindow;
        popupWindow.showAtLocation(this.f14038d, GravityCompat.END, 0, 0);
    }

    public void setVisibility(int i) {
        this.f14039e.setVisibility(i);
    }

    public void setOperationPanelModel(OperationPanelModel operationPanelModel) {
        this.f14041g = operationPanelModel;
    }

    public View getView() {
        return this.f14039e;
    }

    public void setPresenter(FlexOptionPresenter flexOptionPresenter) {
        this.f14037c = flexOptionPresenter;
    }
}
