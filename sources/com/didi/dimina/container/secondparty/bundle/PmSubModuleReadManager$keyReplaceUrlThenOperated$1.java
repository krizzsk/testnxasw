package com.didi.dimina.container.secondparty.bundle;

import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.http.PmHttpCallback;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmJsonUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, mo148868d2 = {"com/didi/dimina/container/secondparty/bundle/PmSubModuleReadManager$keyReplaceUrlThenOperated$1", "Lcom/didi/dimina/container/secondparty/bundle/http/PmHttpCallback;", "", "onFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSucceed", "result", "2party-impl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PmSubModuleReadManager.kt */
public final class PmSubModuleReadManager$keyReplaceUrlThenOperated$1 implements PmHttpCallback<String> {
    final /* synthetic */ DMConfigBean.AppModulesBean $appModule;
    final /* synthetic */ PmSubModuleReadManager this$0;

    PmSubModuleReadManager$keyReplaceUrlThenOperated$1(PmSubModuleReadManager pmSubModuleReadManager, DMConfigBean.AppModulesBean appModulesBean) {
        this.this$0 = pmSubModuleReadManager;
        this.$appModule = appModulesBean;
    }

    public void onSucceed(String str) {
        LogUtil.iRelease(PmSubModuleReadManager.TAG, "onSucceed() = " + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                PmKey2UrlBean pmKey2UrlBean = (PmKey2UrlBean) PmJsonUtil.toObject(str, PmKey2UrlBean.class);
                if (pmKey2UrlBean == null || pmKey2UrlBean.getCode() != 200) {
                    int i = (pmKey2UrlBean == null || pmKey2UrlBean.getCode() != 429) ? PckErrCode.SUB_KEY_2_URL_NO_200 : PckErrCode.HTTP_TOO_MANY_REQUEST;
                    PmSubModuleReadManager.m16017a(this.this$0, i, (String) null, (Throwable) null, 4, (Object) null);
                    PmSubModuleReadManager pmSubModuleReadManager = this.this$0;
                    if (pmKey2UrlBean != null) {
                        i = pmKey2UrlBean.getCode();
                    }
                    PmSubModuleReadManager.traceSubPackageHttpRequestEnd$default(pmSubModuleReadManager, (String) null, i, (String) null, 5, (Object) null);
                    return;
                }
                if (!CollectionsUtil.isEmpty((Collection) pmKey2UrlBean.getData())) {
                    if (pmKey2UrlBean.getData().size() <= 1) {
                        PmSubModuleReadManager pmSubModuleReadManager2 = this.this$0;
                        String str2 = pmKey2UrlBean.getData().get(0);
                        Intrinsics.checkExpressionValueIsNotNull(str2, "key2UrlBean.data[0]");
                        pmSubModuleReadManager2.m16019a(str2, this.$appModule);
                        PmSubModuleReadManager.traceSubPackageHttpRequestEnd$default(this.this$0, "1", 0, (String) null, 6, (Object) null);
                        return;
                    }
                }
                PmSubModuleReadManager.m16017a(this.this$0, (int) PckErrCode.SUB_KEY_2_URL_RESPONSE_DATA_ERROR, (String) null, (Throwable) null, 4, (Object) null);
                PmSubModuleReadManager.traceSubPackageHttpRequestEnd$default(this.this$0, (String) null, PckErrCode.SUB_KEY_2_URL_RESPONSE_DATA_ERROR, (String) null, 5, (Object) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("key换url接口发生错误 = ");
            Throwable th = e;
            sb.append(Log.getStackTraceString(th));
            LogUtil.eRelease(PmSubModuleReadManager.TAG, sb.toString());
            this.this$0.m16015a(PckErrCode.SUB_OCCUR_EXCEPTION, (String) null, th);
            PmSubModuleReadManager.traceSubPackageHttpRequestEnd$default(this.this$0, (String) null, PckErrCode.SUB_OCCUR_EXCEPTION, (String) null, 5, (Object) null);
        }
    }

    public void onFailed(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "e");
        exc.printStackTrace();
        LogUtil.eRelease(PmSubModuleReadManager.TAG, "onFailed() = " + Log.getStackTraceString(exc));
        PmSubModuleReadManager.m16017a(this.this$0, (int) PckErrCode.SUB_KEY_2_URL_FAILED, (String) null, (Throwable) null, 4, (Object) null);
        this.this$0.traceSubPackageHttpRequestEnd("-1", PckErrCode.SUB_KEY_2_URL_FAILED, exc.toString());
    }
}
