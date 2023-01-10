package com.didi.beatles.p101im.service;

import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.p102db.dao.DaoMaster;
import com.didi.beatles.p101im.p102db.dao.DaoSession;
import com.didi.beatles.p101im.service.dao.IMDaoCipherInit;
import com.didi.beatles.p101im.service.dao.IMDaoInit;
import com.didi.beatles.p101im.service.dao.IMDaoInitTrace;
import com.didi.beatles.p101im.service.dao.IMDaoOldInit;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.service.IMDaoManager */
public class IMDaoManager extends IMBaseProvider {
    public static final String TAG = "IMInit";

    /* renamed from: a */
    private boolean f11425a = false;

    /* renamed from: b */
    private DaoSession f11426b;

    /* renamed from: c */
    private DaoMaster.DevOpenHelper f11427c;

    protected IMDaoManager(IMServiceProvider iMServiceProvider) {
        super(iMServiceProvider);
    }

    public void close() {
        DaoSession daoSession = this.f11426b;
        if (daoSession != null) {
            daoSession.clear();
        }
        IMModelProvider.getInstance().destroy();
        DaoMaster.DevOpenHelper devOpenHelper = this.f11427c;
        if (devOpenHelper != null) {
            devOpenHelper.close();
            this.f11427c = null;
        }
    }

    /* access modifiers changed from: protected */
    public void init(long j) {
        IMDaoInit iMDaoInit;
        if (j > 0) {
            IMLog.m10024i("IMInit", "init DB start");
            close();
            IMDaoInitTrace.Builder builder = new IMDaoInitTrace.Builder();
            boolean isMoveCipher = IMContextInfoHelper.isMoveCipher();
            if (isMoveCipher) {
                builder.addApollo(IMDaoInitTrace.APOLLO_ENCRYPT);
                iMDaoInit = new IMDaoCipherInit(this.mContext, builder);
            } else {
                builder.addApollo("txt");
                iMDaoInit = new IMDaoOldInit(this.mContext, builder);
            }
            try {
                iMDaoInit.init(j);
                iMDaoInit.end();
                builder.report();
                IMLog.m10024i("IMInit", "init DB log " + builder.log());
                this.f11427c = iMDaoInit.getOpenHelper();
                this.f11426b = new DaoMaster(iMDaoInit.getInitDatabase()).newSession();
                this.f11425a = true;
                IMLog.m10024i("IMInit", "init DB end");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("im_dao_init_");
                sb.append(isMoveCipher ? "cipher" : "text");
                IMTraceError.trackError(sb.toString(), e);
                throw new IllegalStateException(e);
            } catch (Throwable th) {
                iMDaoInit.end();
                builder.report();
                throw th;
            }
        } else {
            IMLog.m10021e("IMInit", "loginID is " + j + " init() DB exception!");
            throw new IllegalArgumentException("init() DB exception!,uid = " + j);
        }
    }

    public DaoSession getDaoSession() {
        m9876a();
        return this.f11426b;
    }

    /* renamed from: a */
    private void m9876a() {
        if (!this.f11425a) {
            IMLog.m10021e("IMInit", "isInit not success or start,cause by mOpenHelper is null");
            throw new IllegalArgumentException(" isInit not success or start,cause by mOpenHelper is null");
        }
    }
}
