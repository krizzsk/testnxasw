package com.didiglobal.p205sa.biz.component.homemsg;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.never.core.IView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.homemsg.model.HomeMsgModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/homemsg/HomeMsgView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/homemsg/HomeMsgPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bgImgView", "Landroid/widget/ImageView;", "displayName", "Landroid/widget/TextView;", "leftImgView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "mContext", "presenter", "rightImgView", "rootView", "Landroid/view/View;", "getView", "refreshDataModel", "", "model", "Lcom/didiglobal/sa/biz/component/homemsg/model/HomeMsgModel;", "json", "Lcom/google/gson/JsonObject;", "setPresenter", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.homemsg.HomeMsgView */
/* compiled from: HomeMsgView.kt */
public final class HomeMsgView implements IView<HomeMsgPresenter> {

    /* renamed from: a */
    private final Logger f53526a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: b */
    private final Context f53527b;

    /* renamed from: c */
    private View f53528c;

    /* renamed from: d */
    private TextView f53529d;

    /* renamed from: e */
    private ImageView f53530e;

    /* renamed from: f */
    private SimpleDraweeView f53531f;

    /* renamed from: g */
    private ImageView f53532g;

    /* renamed from: h */
    private HomeMsgPresenter f53533h;

    public HomeMsgView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f53527b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.sa_component_home_msg, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…nt_home_msg, null, false)");
        this.f53528c = inflate;
        View findViewById = inflate.findViewById(R.id.tv_display_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_display_name)");
        this.f53529d = (TextView) findViewById;
        View findViewById2 = this.f53528c.findViewById(R.id.bg_imgview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.bg_imgview)");
        this.f53530e = (ImageView) findViewById2;
        View findViewById3 = this.f53528c.findViewById(R.id.left_imageview);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.left_imageview)");
        this.f53531f = (SimpleDraweeView) findViewById3;
        View findViewById4 = this.f53528c.findViewById(R.id.right_imageview);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.right_imageview)");
        this.f53532g = (ImageView) findViewById4;
    }

    public View getView() {
        return this.f53528c;
    }

    public void setPresenter(HomeMsgPresenter homeMsgPresenter) {
        this.f53533h = homeMsgPresenter;
    }

    public final void refreshDataModel(HomeMsgModel homeMsgModel, JsonObject jsonObject) {
        JsonObject asObject;
        Intrinsics.checkNotNullParameter(homeMsgModel, "model");
        Intrinsics.checkNotNullParameter(jsonObject, "json");
        HashMap hashMap = new HashMap();
        JsonObject asObject2 = XEParserUtil.getAsObject("extension", jsonObject);
        if (!(asObject2 == null || (asObject = XEParserUtil.getAsObject("log_data", asObject2)) == null)) {
            try {
                Map map = (Map) new Gson().fromJson((JsonElement) asObject, new HomeMsgView$refreshDataModel$params$1().getType());
                if (map != null) {
                    hashMap.putAll(map);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f53526a.debug(Intrinsics.stringPlus("dispatch home_msg view ", homeMsgModel), new Object[0]);
        if (homeMsgModel.getMessage() != null) {
            LEGORichInfo message = homeMsgModel.getMessage();
            if (message != null) {
                message.bindTextView(this.f53529d);
            }
        } else {
            this.f53529d.setText("");
        }
        this.f53528c.setOnClickListener(new View.OnClickListener(hashMap, this, homeMsgModel) {
            public final /* synthetic */ HashMap f$0;
            public final /* synthetic */ HomeMsgView f$1;
            public final /* synthetic */ HomeMsgModel f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                HomeMsgView.m39958a(this.f$0, this.f$1, this.f$2, view);
            }
        });
        if (homeMsgModel.getBgimage() == null) {
            homeMsgModel.setBgimage("");
        }
        Glide.with(this.f53527b).load(homeMsgModel.getBgimage()).into(this.f53530e);
        if (homeMsgModel.getRighticon() == null) {
            homeMsgModel.setRighticon("");
        }
        Glide.with(this.f53527b).load(homeMsgModel.getRighticon()).into(this.f53532g);
        if (homeMsgModel.getLefticon() == null) {
            homeMsgModel.setLefticon("");
        }
        this.f53531f.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(homeMsgModel.getLefticon()).setAutoPlayAnimations(true)).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m39958a(HashMap hashMap, HomeMsgView homeMsgView, HomeMsgModel homeMsgModel, View view) {
        Intrinsics.checkNotNullParameter(hashMap, "$map");
        Intrinsics.checkNotNullParameter(homeMsgView, "this$0");
        Intrinsics.checkNotNullParameter(homeMsgModel, "$model");
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_act_module_ck", (Map<String, Object>) hashMap);
        Logger logger = homeMsgView.f53526a;
        logger.debug("dispatch home_msg click " + homeMsgModel + ".link", new Object[0]);
        if (!TextUtils.isEmpty(homeMsgModel.getLink())) {
            ((Request) DRouter.build(homeMsgModel.getLink()).putExtra("action_type", "notification")).start();
        }
    }
}
