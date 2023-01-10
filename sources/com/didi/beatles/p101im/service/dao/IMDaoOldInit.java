package com.didi.beatles.p101im.service.dao;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.p102db.dao.DaoMaster;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.service.dao.IMDaoInitTrace;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.utils.IMFileUtils;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.security.uuid.Constants;
import java.io.File;

/* renamed from: com.didi.beatles.im.service.dao.IMDaoOldInit */
public class IMDaoOldInit implements IMDaoInit {

    /* renamed from: a */
    private static final String f11478a = "IMDaoCipherInit";

    /* renamed from: b */
    private Context f11479b;

    /* renamed from: c */
    private IMDaoInitTrace.Builder f11480c;

    /* renamed from: d */
    private DaoMaster.DevOpenHelper f11481d;

    /* renamed from: e */
    private Database f11482e;

    public void end() {
    }

    public IMDaoOldInit(Context context, IMDaoInitTrace.Builder builder) {
        this.f11479b = context;
        this.f11480c = builder;
    }

    public void init(long j) {
        Database database;
        if (IMFileUtils.fileIsExists(m9902b()) || IMFileUtils.fileIsExists(m9896a())) {
            this.f11480c.addAction("open");
        } else {
            this.f11480c.addAction(Constants.CREATE_NAME);
        }
        IMLog.m10024i(f11478a, "init DB start");
        m9897a(j, false);
        try {
            database = this.f11481d.getWritableDb();
        } catch (Exception e) {
            m9899a(e, 10);
            m9898a(e);
            if (!e.getMessage().contains("change locale")) {
                this.f11480c.addDegree("outer");
                m9897a(j, true);
                try {
                    database = this.f11481d.getWritableDb();
                    IMPreference.getInstance(this.f11479b).setUseInnerFile();
                } catch (Exception e2) {
                    m9899a(e2, 11);
                    throw new IllegalArgumentException("database still has Exception " + e.toString(), e.getCause());
                }
            } else {
                throw new IllegalArgumentException("database still has Exception " + e.toString(), e.getCause());
            }
        }
        this.f11482e = database;
        IMLog.m10024i(f11478a, "init DB end");
        if (IMPreference.getInstance(this.f11479b).isUseInnerFile()) {
            this.f11480c.addDao("inner");
        } else {
            this.f11480c.addDao("outer");
        }
    }

    public Database getInitDatabase() {
        return this.f11482e;
    }

    public DaoMaster.DevOpenHelper getOpenHelper() {
        return this.f11481d;
    }

    /* renamed from: a */
    private void m9898a(Exception exc) {
        String message = exc.getMessage();
        if (!TextUtils.isEmpty(message) && message.contains("change locale")) {
            m9899a((Exception) exc.getCause(), 8);
        }
    }

    /* renamed from: a */
    private void m9897a(long j, boolean z) {
        String str;
        if (IMContextInfoHelper.isUseInnerStorage() || z) {
            str = m9902b();
        } else {
            str = m9896a();
        }
        String str2 = str + "/" + ("im_database_" + j + ".db");
        m9901a(str2);
        this.f11481d = new DaoMaster.DevOpenHelper(this.f11479b, str2);
    }

    /* renamed from: a */
    private void m9901a(String str) {
        File file = new File(str);
        if (file.exists() && !file.canWrite()) {
            IMTraceUtil.CodeErrorParam addErrMsg = IMTraceUtil.addCodeErrorEvent().addErrno(13).addErrMsg("文件没有写权限");
            addErrMsg.addExtendMsg("文件路径" + str).report();
            try {
                if (!file.setWritable(true)) {
                    IMTraceUtil.CodeErrorParam addErrMsg2 = IMTraceUtil.addCodeErrorEvent().addErrno(14).addErrMsg("修改文件权限失败");
                    addErrMsg2.addExtendMsg("文件路径" + str).report();
                }
            } catch (Exception e) {
                IMTraceUtil.addCodeErrorEvent().addErrno(14).addErrMsg(e.toString()).addExtendMsg(IMTextUtil.getExceptionStack(e)).report();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = r5.f11479b.getExternalFilesDir("im");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m9896a() {
        /*
            r5 = this;
            android.content.Context r0 = r5.f11479b
            com.didi.beatles.im.pref.IMPreference r0 = com.didi.beatles.p101im.pref.IMPreference.getInstance(r0)
            boolean r0 = r0.isUseInnerFile()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r5.m9902b()
            return r0
        L_0x0011:
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 == 0) goto L_0x002d
            android.content.Context r0 = r5.f11479b
            java.lang.String r2 = "im"
            java.io.File r0 = r0.getExternalFilesDir(r2)
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getAbsolutePath()
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0042
            android.content.Context r0 = r5.f11479b
            com.didi.beatles.im.pref.IMPreference r0 = com.didi.beatles.p101im.pref.IMPreference.getInstance(r0)
            r0.setUseInnerFile()
            java.lang.String r0 = r5.m9902b()
            return r0
        L_0x0042:
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x0075
            boolean r2 = r2.mkdirs()
            if (r2 != 0) goto L_0x0075
            r2 = 4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "outer path = "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r5.m9900a(r1, r2, r0)
            android.content.Context r0 = r5.f11479b
            com.didi.beatles.im.pref.IMPreference r0 = com.didi.beatles.p101im.pref.IMPreference.getInstance(r0)
            r0.setUseInnerFile()
            java.lang.String r0 = r5.m9902b()
        L_0x0075:
            return r0
        L_0x0076:
            java.lang.String r0 = r5.m9902b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.service.dao.IMDaoOldInit.m9896a():java.lang.String");
    }

    /* renamed from: b */
    private String m9902b() {
        m9900a((Exception) null, 3, "ues inner path");
        String str = this.f11479b.getFilesDir().getAbsolutePath() + "/" + "im";
        File file = new File(str);
        if (!file.exists() && !file.mkdir()) {
            m9900a((Exception) null, 12, "ues inner path failed ,path = " + str);
        }
        return str;
    }

    /* renamed from: a */
    private void m9899a(Exception exc, int i) {
        m9900a(exc, i, (String) null);
    }

    /* renamed from: a */
    private void m9900a(Exception exc, int i, String str) {
        if (TextUtils.isEmpty(str) && exc != null) {
            str = exc.toString();
        }
        IMTraceUtil.addCodeErrorEvent().addErrno(i).addErrMsg(str).addExtendMsg(IMTextUtil.getExceptionStack(exc)).report();
    }
}
