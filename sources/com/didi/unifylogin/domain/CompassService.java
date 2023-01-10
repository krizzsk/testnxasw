package com.didi.unifylogin.domain;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginJsonException;
import com.didi.unifylogin.base.net.pojo.request.ComboJudgeParam;
import com.didi.unifylogin.base.net.pojo.response.JudgeResponse;
import com.didi.unifylogin.spi.CompassRequestService;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.StringUtil;
import com.didi.unifylogin.view.CompassPopup;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;
import com.didiglobal.domainservice.utils.ELog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompassService {

    /* renamed from: a */
    private List<IBizProcessor> f47418a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PopupShowHandler f47419b;

    /* renamed from: c */
    private CompassCheckCondition f47420c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f47421d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ICpsResponseHandler<JudgeResponse> f47422e = new ICpsResponseHandler<JudgeResponse>() {
        public void onHandleResponse(Context context, JudgeResponse judgeResponse) {
            String domainFromCache = GlobalDomainCache.getInstance(context).getDomainFromCache(context);
            ELog.log("#CompassService query cache domain suffix is " + domainFromCache);
            if (!(judgeResponse == null || judgeResponse.data == null || judgeResponse.errdef != 0)) {
                JudgeResponse.PiiDataItem piiDataItem = judgeResponse.data.pii_info;
                if (piiDataItem == null) {
                    CompassService.this.m35267b(context, SuffixType.PII);
                } else if (!piiDataItem.illegal()) {
                    PiiDomainSuffixModel piiDomainSuffixModel = new PiiDomainSuffixModel();
                    piiDomainSuffixModel.setUris(piiDataItem.uri);
                    piiDomainSuffixModel.setTimeout(piiDataItem.timeout);
                    piiDomainSuffixModel.setSuffix(piiDataItem.idc_suffix);
                    CompassService.this.m35256a(context, (AbsDomainSuffixModel) piiDomainSuffixModel);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("idc_suffix", piiDataItem.idc_suffix);
                    hashMap.put("timeout", Integer.valueOf(piiDataItem.timeout));
                    hashMap.put(ShareConstants.MEDIA_URI, piiDataItem.uri);
                    OmegaSDKAdapter.trackEvent("tech_compass_pii_info_error", (Map<String, Object>) hashMap);
                }
                ArrayList<JudgeResponse.JudgeDataItem> arrayList = judgeResponse.data.idc_info;
                if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && arrayList.size() > 1) {
                    CompassService.this.m35255a(context, judgeResponse.data, domainFromCache);
                    return;
                } else if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && arrayList.size() > 0) {
                    String str = arrayList.get(0).idc_sign;
                    if (!TextUtil.isEmpty(str) && !str.equalsIgnoreCase(domainFromCache)) {
                        CompassService.this.m35257a(context, str);
                        CompassRequestService.compassResponse(str);
                    }
                }
            }
            CompassService.this.processFollowUp();
        }

        public void onHandleFailure(IOException iOException) {
            CompassRequestService.compassResponse((String) null);
            if (CompassService.this.f47421d != null) {
                CompassService compassService = CompassService.this;
                compassService.m35267b(compassService.f47421d, SuffixType.PII);
            }
            CompassService.this.processFollowUp();
        }
    };

    public interface CompassCheckCondition {
        boolean haveCpsCKCondition();
    }

    public interface IBizProcessor {
        void processBiz();
    }

    public interface ICpsResponseHandler<T> {
        void onHandleFailure(IOException iOException);

        void onHandleResponse(Context context, T t);
    }

    public interface PopupShowHandler {
        void onCancel();

        void onConfirm();

        void onShowPopup(SimplePopupBase simplePopupBase);
    }

    public void getCompassJudge(final Context context, Map<String, String> map) {
        CompassCheckCondition compassCheckCondition = this.f47420c;
        if (compassCheckCondition == null || !compassCheckCondition.haveCpsCKCondition()) {
            processFollowUp();
            return;
        }
        this.f47421d = context;
        ComboJudgeParam comboJudgeParam = new ComboJudgeParam(context, 1);
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            if (map.containsKey("cell_phone")) {
                comboJudgeParam.setCell(map.get("cell_phone"));
            }
            if (map.containsKey("invoke_scene")) {
                comboJudgeParam.setInvokeScene(map.get("invoke_scene"));
            }
            if (map.containsKey("email")) {
                comboJudgeParam.setEmail(map.get("email"));
            }
        }
        CompassRequestService.compassRequestBegin();
        LoginModel.getNet(context).compassJudge(comboJudgeParam, new RpcService.CallbackV2<JudgeResponse>() {
            public void onSuccess(RpcResponseProxy<JudgeResponse> rpcResponseProxy) {
                CompassService.this.m35265a(rpcResponseProxy);
                JudgeResponse content = rpcResponseProxy.getContent();
                if (CompassService.this.f47422e != null) {
                    CompassService.this.f47422e.onHandleResponse(context, content);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                CompassService.this.m35264a(rpcRequest, iOException);
                if (CompassService.this.f47422e != null) {
                    CompassService.this.f47422e.onHandleFailure(iOException);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35265a(RpcResponseProxy<JudgeResponse> rpcResponseProxy) {
        JudgeResponse content = rpcResponseProxy.getContent();
        LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil("tech_passport_net_response_sw");
        loginOmegaUtil.add("errno", Integer.valueOf(content.errdef));
        Iterator<HttpHeader> it = rpcResponseProxy.getHeaders().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            HttpHeader next = it.next();
            if (next.getName().equals("didi-header-rid")) {
                loginOmegaUtil.add("trace", next.getValue());
                break;
            }
        }
        loginOmegaUtil.add("is_valid_rsp", Integer.valueOf(content.errno == -1 ? 0 : 1));
        loginOmegaUtil.add("path", StringUtil.getPath(rpcResponseProxy.getRequest().getUrl()));
        loginOmegaUtil.add("is_release", Integer.valueOf(LoginStore.isDebug ^ true ? 1 : 0));
        loginOmegaUtil.add("base_url", StringUtil.getBaseUrl(rpcResponseProxy.getRequest().getUrl()));
        loginOmegaUtil.send();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35264a(RpcRequest rpcRequest, IOException iOException) {
        LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil("tech_passport_net_response_sw");
        loginOmegaUtil.add("errno", -1);
        if (iOException instanceof LoginJsonException) {
            loginOmegaUtil.add("is_valid_rsp", 0);
        } else {
            loginOmegaUtil.add("is_valid_rsp", 2);
        }
        loginOmegaUtil.add("path", StringUtil.getPath(rpcRequest.getUrl()));
        loginOmegaUtil.add("is_release", Integer.valueOf(LoginStore.isDebug ^ true ? 1 : 0));
        loginOmegaUtil.add("base_url", StringUtil.getBaseUrl(rpcRequest.getUrl()));
        loginOmegaUtil.send();
    }

    private class CompassPopData extends JudgeResponse.JudgeData implements CompassPopup.IPopupDataHandler {
        public String getSubTitle() {
            return null;
        }

        public CompassPopData(JudgeResponse.JudgeData judgeData) {
            if (judgeData != null) {
                this.text = judgeData.text;
                this.idc_info = judgeData.idc_info;
            }
        }

        public String getTitle() {
            return this.text;
        }

        public String getPositiveBtnText() {
            return (CollectionUtil.isEmpty((Collection<?>) this.idc_info) || this.idc_info.size() <= 1) ? "Ok" : ((JudgeResponse.JudgeDataItem) this.idc_info.get(0)).button_text;
        }

        public String getNegativeBtnText() {
            return (CollectionUtil.isEmpty((Collection<?>) this.idc_info) || this.idc_info.size() <= 1) ? "I'm not here now" : ((JudgeResponse.JudgeDataItem) this.idc_info.get(1)).button_text;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35255a(Context context, JudgeResponse.JudgeData judgeData, String str) {
        if (judgeData == null || CollectionUtil.isEmpty((Collection<?>) judgeData.idc_info) || judgeData.idc_info.size() <= 1) {
            ELog.log("illegal idc data when build custom chooose popup dialog!");
            CompassRequestService.compassResponse((String) null);
            processFollowUp();
            return;
        }
        CompassPopup instance = CompassPopup.getInstance(new CompassPopData(judgeData));
        final JudgeResponse.JudgeData judgeData2 = judgeData;
        final String str2 = str;
        final Context context2 = context;
        final CompassPopup compassPopup = instance;
        instance.setConfirmListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                JudgeResponse.JudgeData judgeData = judgeData2;
                if (judgeData != null && !CollectionUtil.isEmpty((Collection<?>) judgeData.idc_info)) {
                    String str = judgeData2.idc_info.get(0).idc_sign;
                    if (!TextUtil.isEmpty(str) && !str.equalsIgnoreCase(str2)) {
                        ELog.log("#CompassService choose idc: " + str + " with click positive button");
                        String lowerCase = str.toLowerCase();
                        CompassService.this.m35257a(context2, lowerCase);
                        CompassRequestService.compassResponse(lowerCase);
                    }
                }
                LoginOmegaUtil.trackEvent("tone_p_x_roaming_yes_ck");
                compassPopup.dismiss();
                if (CompassService.this.f47419b != null) {
                    CompassService.this.f47419b.onConfirm();
                }
            }
        });
        instance.setCancelListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                JudgeResponse.JudgeData judgeData = judgeData2;
                if (judgeData != null && !CollectionUtil.isEmpty((Collection<?>) judgeData.idc_info) && judgeData2.idc_info.size() > 1) {
                    String str = judgeData2.idc_info.get(1).idc_sign;
                    if (!TextUtil.isEmpty(str) && !str.equalsIgnoreCase(str2)) {
                        ELog.log("#CompassService choose idc: " + str + " with click negative button");
                        CompassService.this.m35257a(context2, str);
                        CompassRequestService.compassResponse(str);
                    }
                }
                LoginOmegaUtil.trackEvent("tone_p_x_roaming_no_ck");
                compassPopup.dismiss();
                if (CompassService.this.f47419b != null) {
                    CompassService.this.f47419b.onCancel();
                }
            }
        });
        m35258a((SimplePopupBase) instance);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35257a(Context context, String str) {
        GlobalDomainCache instance = GlobalDomainCache.getInstance(context);
        if (!TextUtils.isEmpty(str)) {
            instance.setDomainSuffix(context, str.toLowerCase());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35256a(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        GlobalDomainCache instance = GlobalDomainCache.getInstance(context);
        if (absDomainSuffixModel != null && !TextUtils.isEmpty(absDomainSuffixModel.getSuffix())) {
            instance.setDomainSuffixModel(context, absDomainSuffixModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35267b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            GlobalDomainCache.getInstance(context).removeDomainSuffixModel(context, str);
        }
    }

    public CompassService replaceCpsResponseHandler(ICpsResponseHandler<JudgeResponse> iCpsResponseHandler) {
        this.f47422e = iCpsResponseHandler;
        return this;
    }

    public CompassService setCompassCheckCond(CompassCheckCondition compassCheckCondition) {
        this.f47420c = compassCheckCondition;
        return this;
    }

    public CompassService setPopupHandler(PopupShowHandler popupShowHandler) {
        this.f47419b = popupShowHandler;
        return this;
    }

    public CompassService registeProcessor(IBizProcessor iBizProcessor) {
        this.f47418a.add(iBizProcessor);
        return this;
    }

    public PopupShowHandler getmPopupHandler() {
        return this.f47419b;
    }

    /* renamed from: a */
    private void m35258a(SimplePopupBase simplePopupBase) {
        PopupShowHandler popupShowHandler = this.f47419b;
        if (popupShowHandler != null) {
            popupShowHandler.onShowPopup(simplePopupBase);
        }
    }

    public void processFollowUp() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f47418a)) {
            for (IBizProcessor processBiz : this.f47418a) {
                processBiz.processBiz();
            }
        }
    }
}
