package com.didi.beatles.p101im.service.dao;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.p102db.dao.DaoMaster;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.service.dao.IMDaoInitTrace;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.utils.IMEncryptionUtil;
import com.didi.security.wireless.DAQException;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.didi.beatles.im.service.dao.IMDaoCipherInit */
public class IMDaoCipherInit implements IMDaoInit {

    /* renamed from: a */
    private static final int f11437a = 1;

    /* renamed from: b */
    private static final int f11438b = 2;

    /* renamed from: c */
    private static final int f11439c = -1;

    /* renamed from: d */
    private static final int f11440d = 0;

    /* renamed from: e */
    private static final int f11441e = 3;

    /* renamed from: f */
    private Context f11442f;

    /* renamed from: g */
    private IMDaoInitTrace.Builder f11443g;

    /* renamed from: h */
    private DaoMaster.DevOpenHelper f11444h;

    /* renamed from: i */
    private Database f11445i;

    /* renamed from: j */
    private Map<String, String> f11446j = new HashMap(2);

    /* renamed from: k */
    private Map<String, String> f11447k = new HashMap(2);

    public IMDaoCipherInit(Context context, IMDaoInitTrace.Builder builder) {
        this.f11442f = context;
        this.f11443g = builder;
        IMPreference.getInstance(context).increaseCrashCount();
    }

    public void end() {
        IMPreference.getInstance(this.f11442f).decreaseCrashCount();
    }

    public void init(long j) throws Exception {
        if (IMContextInfoHelper.isNewInnerFlow()) {
            this.f11443g.addApollo(IMDaoInitTrace.APOLLO_NO_ENC);
        }
        try {
            m9880a(j);
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_INNER_PATH).setResult(true, (Exception) null).report();
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_CHANGE_LOCAL).setResult(true, (Exception) null).report();
            m9894j(j);
        } catch (Exception e) {
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_INNER_PATH).setResult(false, e).report();
            IMTraceError.trackErrorFlow(IMTraceError.ERROR_CHANGE_LOCAL).setResult(false, e).report();
            throw e;
        }
    }

    /* renamed from: a */
    private void m9880a(long j) {
        File i = m9893i(j);
        if (i.exists()) {
            this.f11443g.addAction("no_enc_open");
            try {
                this.f11445i = m9882b(j);
                this.f11443g.addDao("new_in");
            } catch (SQLiteException e) {
                Throwable cause = e.getCause();
                if (cause != null && cause.getMessage() != null && cause.getMessage().contains("database disk image is malformed")) {
                    IMTraceError.trackErrorFlow(IMTraceError.ERROR_CHANGE_LOCAL).setError(e);
                    this.f11443g.addDegree("no_enc_rebuild");
                    i.delete();
                    this.f11445i = m9882b(j);
                    this.f11443g.addDao("new_in");
                }
            }
        } else {
            File b = m9883b(-1, j);
            if (!b.exists()) {
                int i2 = 3;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    File b2 = m9883b(i2, j);
                    if (b2.exists()) {
                        b = b2;
                        break;
                    }
                    i2--;
                }
            }
            if (b.exists()) {
                this.f11443g.addAction("no_enc_new");
                this.f11445i = m9882b(j);
                b.delete();
                this.f11443g.addDao("new_in");
            } else if (m9891g(j).exists()) {
                this.f11443g.addAction("no_enc_inner");
                try {
                    this.f11445i = m9886c(j);
                    this.f11443g.addDao("new_in");
                } catch (Exception e2) {
                    IMTraceError.trackError("im_no_cipher_inner", e2);
                    this.f11443g.addDegree("no_enc_inner");
                    this.f11445i = m9889e(j);
                    this.f11443g.addDao("inner");
                }
            } else {
                File h = m9892h(j);
                if (h == null || !h.exists()) {
                    this.f11443g.addAction("no_enc_create");
                    this.f11445i = m9882b(j);
                    this.f11443g.addDao("new_in");
                    return;
                }
                this.f11443g.addAction("no_enc_outer");
                try {
                    this.f11445i = m9888d(j);
                    this.f11443g.addDao("new_in");
                } catch (Exception e3) {
                    IMTraceError.trackError("im_no_cipher_outer", e3);
                    this.f11443g.addDegree("no_enc_outer");
                    this.f11445i = m9882b(j);
                    this.f11443g.addDao("outer");
                }
            }
        }
    }

    public Database getInitDatabase() {
        return this.f11445i;
    }

    public DaoMaster.DevOpenHelper getOpenHelper() {
        return this.f11444h;
    }

    /* renamed from: b */
    private Database m9882b(long j) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this.f11442f, m9893i(j).getAbsolutePath());
        this.f11444h = devOpenHelper;
        return devOpenHelper.getWritableDb();
    }

    /* renamed from: c */
    private Database m9886c(long j) {
        m9881a(m9891g(j), m9893i(j));
        return m9882b(j);
    }

    /* renamed from: d */
    private Database m9888d(long j) {
        File h = m9892h(j);
        if (h != null) {
            m9885b(h, m9893i(j));
            return m9882b(j);
        }
        throw new IllegalArgumentException("open old outer in empty file");
    }

    /* renamed from: e */
    private Database m9889e(long j) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this.f11442f, m9891g(j).getAbsolutePath());
        this.f11444h = devOpenHelper;
        return devOpenHelper.getWritableDb();
    }

    /* renamed from: f */
    private Database m9890f(long j) throws IllegalArgumentException {
        File h = m9892h(j);
        if (h != null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this.f11442f, h.getAbsolutePath());
            this.f11444h = devOpenHelper;
            return devOpenHelper.getWritableDb();
        }
        throw new IllegalArgumentException("open old outer in empty file");
    }

    /* renamed from: a */
    private static void m9881a(File file, File file2) {
        if (!file.renameTo(file2)) {
            throw new IllegalStateException("move file inner fail");
        }
    }

    /* renamed from: b */
    private static void m9885b(File file, File file2) {
        File file3 = new File(file2.getAbsolutePath() + DefaultDiskStorage.FileType.TEMP);
        if (!file3.exists() || file3.delete()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (fileInputStream.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                fileOutputStream.flush();
                fileInputStream.close();
                fileOutputStream.close();
                if (!file3.renameTo(file2)) {
                    throw new IllegalStateException("moveFileOuter temp rename fail");
                } else if (file.exists() && !file.delete()) {
                    IMTraceError.trackError("im_dao_cipher_new_move", new IllegalStateException("moveFileOuter old file delete fail"));
                }
            } catch (IOException e) {
                throw new IllegalStateException("moveFileOuter io fail", e);
            }
        } else {
            throw new IllegalStateException("moveFileOuter temp delete fail");
        }
    }

    /* renamed from: a */
    private String m9879a(int i, long j) throws PasswordException {
        String str;
        if (this.f11446j.containsKey(m9887c(i, j))) {
            return this.f11446j.get(m9887c(i, j));
        }
        if (i == -1 || i == 0) {
            str = IMEncryptionUtil.toMD5(String.valueOf(j));
        } else if (i == 1) {
            str = SecurityWrapper.secKey(String.valueOf(j));
        } else if (i == 2) {
            try {
                str = SecurityWrapper.secKey2(String.valueOf(j));
            } catch (DAQException e) {
                throw new PasswordException("cipher dao key error by security version " + i + " by error code " + e.getErrorCode(), e);
            }
        } else if (i == 3) {
            try {
                str = SecurityWrapper.secKey3(String.valueOf(j));
            } catch (DAQException e2) {
                throw new PasswordException("cipher dao key error by security version " + i + " by error code " + e2.getErrorCode(), e2);
            }
        } else {
            throw new PasswordException("cipher dao key get by wrong version " + i);
        }
        if (str != null) {
            this.f11443g.addKey(i, str);
            this.f11446j.put(m9887c(i, j), str);
            return str;
        }
        throw new PasswordException("cipher dao key empty by security version " + i);
    }

    /* renamed from: com.didi.beatles.im.service.dao.IMDaoCipherInit$PasswordException */
    private class PasswordException extends Exception {
        PasswordException(String str) {
            super(str);
        }

        PasswordException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: g */
    private File m9891g(long j) {
        return new File(m9884b(), "im_database_" + j + ".db");
    }

    /* renamed from: h */
    private File m9892h(long j) {
        String a = m9878a();
        if (a == null) {
            return null;
        }
        return new File(a, "im_database_" + j + ".db");
    }

    /* renamed from: b */
    private File m9883b(int i, long j) {
        String str = this.f11447k.get(m9887c(i, j));
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(IMEncryptionUtil.toMD5(i + "_" + j));
            sb.append(".im");
            str = sb.toString();
            this.f11447k.put(m9887c(i, j), str);
        }
        return new File(m9884b(), str);
    }

    /* renamed from: i */
    private File m9893i(long j) {
        String str = this.f11447k.get(String.valueOf(j));
        if (TextUtils.isEmpty(str)) {
            str = IMEncryptionUtil.toMD5(String.valueOf(j)) + ".im2";
        }
        return new File(m9884b(), str);
    }

    /* renamed from: a */
    private String m9878a() {
        File externalFilesDir = this.f11442f.getExternalFilesDir("im");
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* renamed from: b */
    private String m9884b() {
        File file = new File(this.f11442f.getFilesDir().getAbsolutePath(), "im");
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        IMTraceError.TraceFlow trackErrorFlow = IMTraceError.trackErrorFlow(IMTraceError.ERROR_INNER_PATH);
        trackErrorFlow.setError(new IllegalStateException("get inner path fail " + file.getAbsolutePath()));
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    private String m9887c(int i, long j) {
        return i + "_" + j;
    }

    /* renamed from: j */
    private void m9894j(long j) {
        LinkedList<File> linkedList = new LinkedList<>();
        linkedList.add(m9891g(j));
        linkedList.add(m9892h(j));
        linkedList.add(m9893i(j));
        linkedList.add(m9883b(-1, j));
        for (int i = 0; i < 3; i++) {
            linkedList.add(m9883b(i, j));
        }
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        for (File file : linkedList) {
            if (file != null && file.exists()) {
                linkedList2.add(file);
                sb.append(file.getName());
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("num", Integer.valueOf(linkedList2.size()));
        hashMap.put("name", sb.toString());
        OmegaSDKAdapter.trackEvent("im_db_num", (Map<String, Object>) hashMap);
    }
}
