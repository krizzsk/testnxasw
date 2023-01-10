package com.didi.dimina.container.secondparty.bundle;

import com.didi.dimina.container.secondparty.bundle.chain.SubModuleUnzipInterceptor;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadTask;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.util.LogUtil;
import java.util.List;
import kotlin.Metadata;
import org.apache.commons.p074io.IOUtils;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "isSuccess", "", "onResult"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: PmSubModuleReadManager.kt */
final class PmSubModuleReadManager$handleKey2UrlSuccThenOperated$1<T> implements PmCallback<Boolean> {
    final /* synthetic */ PmDownloadTask $appDownloadTask;
    final /* synthetic */ List $mDownloadList;
    final /* synthetic */ List $mInstallList;
    final /* synthetic */ PmSubModuleReadManager this$0;

    PmSubModuleReadManager$handleKey2UrlSuccThenOperated$1(PmSubModuleReadManager pmSubModuleReadManager, List list, List list2, PmDownloadTask pmDownloadTask) {
        this.this$0 = pmSubModuleReadManager;
        this.$mInstallList = list;
        this.$mDownloadList = list2;
        this.$appDownloadTask = pmDownloadTask;
    }

    public /* synthetic */ void onResult(Object obj) {
        onResult(((Boolean) obj).booleanValue());
    }

    public final void onResult(boolean z) {
        boolean z2 = z;
        LogUtil.iRelease(PmSubModuleReadManager.TAG, "---------- 子module: " + this.this$0.f18940b + " 最终的下载结果 ->" + z2);
        if (z2) {
            PmSubModuleReadManager.traceSubPackageDownloadEnd$default(this.this$0, 1, 0, (String) null, 6, (Object) null);
            SubModuleUnzipInterceptor subModuleUnzipInterceptor = new SubModuleUnzipInterceptor(this.this$0.f18939a, this.this$0.f18940b, this.this$0.f18941c, this.this$0.f18942d, this.this$0.f18943e, this.this$0.f18944f, this.$mInstallList);
            if (this.this$0.f18945g) {
                PmIOQueueManager.getInstance().enqueue(subModuleUnzipInterceptor);
            } else {
                PmIOQueueManager.getInstance().enqueueHead(subModuleUnzipInterceptor);
            }
        } else if (((PmDownloadTask) this.$mDownloadList.get(0)).getStatus() == 4) {
            LogUtil.iRelease(PmSubModuleReadManager.TAG, "取消任务 " + this.this$0.f18939a + IOUtils.DIR_SEPARATOR_UNIX + this.this$0.f18940b);
            PmSubModuleReadManager.m16017a(this.this$0, (int) PckErrCode.SUB_DOWNLOAD_CANCELED, (String) null, (Throwable) null, 4, (Object) null);
            this.this$0.traceSubPackageDownloadEnd(-1, PckErrCode.SUB_DOWNLOAD_CANCELED, "任务被取消");
        } else {
            PmSubModuleReadManager.m16017a(this.this$0, (int) PckErrCode.SUB_DOWNLOAD_FAILED, (String) null, (Throwable) null, 4, (Object) null);
            PmSubModuleReadManager pmSubModuleReadManager = this.this$0;
            PmDownloadTask pmDownloadTask = this.$appDownloadTask;
            pmSubModuleReadManager.traceSubPackageDownloadEnd(-1, PckErrCode.SUB_DOWNLOAD_FAILED, pmDownloadTask != null ? pmDownloadTask.getErrMsg() : null);
        }
    }
}
