package com.didi.dimina.container.secondparty.bundle.chain;

import android.content.Context;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager;
import com.didi.dimina.container.secondparty.bundle.UnzipManager;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.List;

public class SubModuleUnzipInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM SubModuleUnzipInterceptor";

    /* renamed from: a */
    private final String f18957a;

    /* renamed from: b */
    private final String f18958b;

    /* renamed from: c */
    private final String f18959c;

    /* renamed from: d */
    private final String f18960d;

    /* renamed from: e */
    private final PmSubModuleReadManager.SubModuleInstallCallBack f18961e;

    /* renamed from: f */
    private PmSubModuleReadManager.SubModuleInstallCbConfig f18962f;

    /* renamed from: g */
    private int f18963g = 0;

    /* renamed from: h */
    private final List<InstallModuleFileDescribe> f18964h;

    public SubModuleUnzipInterceptor(String str, String str2, String str3, String str4, PmSubModuleReadManager.SubModuleInstallCallBack subModuleInstallCallBack, PmSubModuleReadManager.SubModuleInstallCbConfig subModuleInstallCbConfig, List<InstallModuleFileDescribe> list) {
        this.f18957a = str;
        this.f18958b = str2;
        this.f18959c = str3;
        this.f18960d = str4;
        this.f18961e = subModuleInstallCallBack;
        this.f18962f = subModuleInstallCbConfig;
        this.f18964h = list;
    }

    /* access modifiers changed from: protected */
    public boolean process() {
        List<InstallModuleFileDescribe> list = this.f18964h;
        if (list == null || list.size() <= 0) {
            m16064a(PckErrCode.SUB_INSTALL_LIST_EMPTY, (String) null);
        } else {
            m16063a();
        }
        PmIOQueueManager.getInstance().setRunningStatusOver();
        PmIOQueueManager.getInstance().exec();
        return false;
    }

    /* renamed from: a */
    private void m16063a() {
        this.f18963g++;
        DebugExceptionUtil.dottingPmTime("processDownloadResultThenOperate()", "  开始 unzip 子module mSubUnzipRetryCount=" + this.f18963g);
        UnzipManager.unzip(this.f18964h, new IDMCommonAction() {
            public final void callback(Object obj) {
                SubModuleUnzipInterceptor.this.m16065a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16065a(Boolean bool) {
        DebugExceptionUtil.dottingPmTime("processDownloadResultThenOperate()", "  unzip 子module 结束 -> 结果:" + bool + " mSubUnzipRetryCount= + mSubUnzipRetryCount");
        if (bool.booleanValue()) {
            String read = PmFileUtil.read(m16066b());
            DebugExceptionUtil.dottingPmTime("processDownloadResultThenOperate()", "  解压成功后，读取文件耗时");
            m16064a(0, read);
            return;
        }
        LogUtil.eRelease(TAG, "解压操作失败 mSubUnzipRetryCount=" + this.f18963g);
        for (InstallModuleFileDescribe next : this.f18964h) {
            LogUtil.iRelease(TAG, "需要删除的文件列表 = " + PmFileHelper.filePath2fileDir(next.getFilesAbsolutePath()));
            PmFileUtil.deleteFile(PmFileHelper.filePath2fileDir(next.getFilesAbsolutePath()), false);
        }
        if (this.f18963g > 3) {
            LogUtil.m16842i(TAG, "解压失败的重试超过限定次数了, 放弃 回调失败 mSubUnzipRetryCount=" + this.f18963g);
            m16064a(PckErrCode.SUB_UNZIP_FAILED, (String) null);
            return;
        }
        LogUtil.m16842i(TAG, "解压失败了, 继续重试 mSubUnzipRetryCount=" + this.f18963g);
        m16063a();
    }

    /* renamed from: b */
    private String m16066b() {
        return PmFileHelper.getFilesModuleFilePath((Context) Dimina.getConfig().getApp(), this.f18957a, this.f18960d, this.f18958b, this.f18959c);
    }

    /* renamed from: a */
    private void m16064a(int i, String str) {
        if (this.f18961e != null) {
            if (this.f18962f == null) {
                this.f18962f = new PmSubModuleReadManager.SubModuleInstallCbConfig();
            }
            this.f18962f.content = str;
            this.f18962f.moduleName = this.f18958b;
            this.f18962f.finalFileName = this.f18959c;
            this.f18962f.jsVersion = this.f18960d;
            this.f18961e.onModuleInstall(i, this.f18962f);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubModuleUnzipInterceptor{, jsId:'");
        sb.append(this.f18957a);
        sb.append('\'');
        sb.append(", jsVersion:'");
        sb.append(this.f18960d);
        sb.append('\'');
        sb.append(", moduleName:'");
        sb.append(this.f18958b);
        sb.append('\'');
        sb.append(", @");
        sb.append(hashCode());
        sb.append(", DMMina@");
        sb.append(this.mina != null ? Integer.valueOf(this.mina.hashCode()) : "null");
        sb.append('}');
        return sb.toString();
    }
}
