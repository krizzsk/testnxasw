package com.didichuxing.dfbasesdk.algomodel;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelConfigResult;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelTaskManager;
import com.didichuxing.dfbasesdk.downloader.FileDownloader;
import com.didichuxing.dfbasesdk.downloader.FileDownloaderListener;
import com.didichuxing.dfbasesdk.utils.FileUtils;
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.dfbasesdk.view.ProgressbarActivity;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AlgoModelTaskImpl {
    public static final int ERR_DOWNLOAD_MODEL = 20;
    public static final int ERR_DOWNLOAD_MODEL_FAIL = 22;
    public static final int ERR_DOWNLOAD_MODEL_SUCCESS = 21;
    public static final int ERR_ENQUEUE_MODEL_TASK = 1;
    public static final int ERR_LOAD_MODEL_FAIL = 50;
    public static final int ERR_LOAD_MODEL_SUCCESS = 100;
    public static final int ERR_REQUEST_CONFIG = 10;
    public static final int ERR_REQUEST_CONFIG_FAIL = 13;
    public static final int ERR_REQUEST_CONFIG_SUCCESS = 11;

    /* renamed from: e */
    private static Map<Integer, Pair<Integer, String>> f49148e = new HashMap();

    /* renamed from: i */
    private static SPHelper f49149i;

    /* renamed from: a */
    Context f49150a;

    /* renamed from: b */
    int f49151b;

    /* renamed from: c */
    String f49152c;

    /* renamed from: d */
    int f49153d;

    /* renamed from: f */
    private Callback f49154f;

    /* renamed from: g */
    private ConfigDelegate f49155g;

    /* renamed from: h */
    private DownloadDelegate f49156h;

    /* renamed from: j */
    private boolean f49157j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f49158k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f49159l;

    public interface Callback {
        void onFail(int i);

        void onMessage(int i, int i2, String str);

        void onSuccess(int i, String str);
    }

    interface ConfigListener {
        void onException(Throwable th);

        void onSuccess(Config config);
    }

    public AlgoModelTaskImpl(Context context, int i, String str, int i2) {
        this(context, i, str, i2, (Callback) null);
    }

    public AlgoModelTaskImpl(Context context, int i, String str, int i2, Callback callback) {
        this.f49155g = new ConfigDelegate();
        this.f49156h = new DownloadDelegate();
        this.f49150a = context;
        if (f49149i == null) {
            f49149i = new SPHelper(context, "access_algo_models_sp");
        }
        this.f49151b = i;
        this.f49152c = str;
        this.f49153d = i2;
        this.f49154f = callback;
    }

    @Deprecated
    public AlgoModelTaskImpl(Context context, int i, String str, int i2, AlgoModelResourceExtractor algoModelResourceExtractor) {
        this(context, i, str, i2, (Callback) null);
    }

    @Deprecated
    public AlgoModelTaskImpl(Context context, int i, String str, int i2, AlgoModelResourceExtractor algoModelResourceExtractor, Callback callback) {
        this(context, i, str, i2, callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m36806a(long j) {
        return (System.currentTimeMillis() - j) + "ms";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m36813a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return "";
        }
        if (1 == objArr.length) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(objArr[0]));
        for (int i = 1; i < objArr.length; i++) {
            sb.append('|');
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m36835c() {
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory == null) {
            return "-1k";
        }
        StatFs statFs = new StatFs(dataDirectory.getPath());
        return ((((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize())) / 1024) + "k";
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m36839d() {
        return WsgSecInfo.networkType(this.f49150a);
    }

    public void prepareModels() {
        if (!this.f49157j) {
            this.f49157j = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.f49159l = currentTimeMillis;
            this.f49158k = currentTimeMillis;
            m36814a(this.f49151b, 1, "开始加载模型");
            m36824a("资源下载中 0%");
            m36827a(true);
            m36814a(this.f49151b, 10, "请求config");
            this.f49155g.getConfig(m36841e());
        }
    }

    /* renamed from: a */
    private void m36827a(boolean z) {
        if (this.f49153d == 0) {
            ProgressbarActivity.setProgressVisible(this.f49150a, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36824a(String str) {
        if (this.f49153d == 0) {
            ProgressbarActivity.setProgressContent(str);
        }
    }

    /* renamed from: e */
    private ConfigListener m36841e() {
        return new ConfigListener() {
            public void onSuccess(Config config) {
                String str = (config == null || !config.cache) ? "远程配置" : "缓存配置";
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                int i = algoModelTaskImpl.f49151b;
                AlgoModelTaskImpl algoModelTaskImpl2 = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m36814a(i, 11, algoModelTaskImpl2.m36813a("config请求成功", str, algoModelTaskImpl2.m36806a(algoModelTaskImpl2.f49159l), AlgoModelTaskImpl.this.m36839d(), String.valueOf(config)));
                String str2 = "已更新模型";
                if (config == null || TextUtils.isEmpty(config.url) || TextUtils.isEmpty(config.md5)) {
                    String c = AlgoModelTaskImpl.this.m36844f();
                    if (!TextUtils.isEmpty(c)) {
                        AlgoModelTaskImpl algoModelTaskImpl3 = AlgoModelTaskImpl.this;
                        int i2 = algoModelTaskImpl3.f49151b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("使用缓存模型|");
                        if (config == null || !config.cache) {
                            str2 = "config接口没下发配置";
                        }
                        sb.append(str2);
                        String sb2 = sb.toString();
                        AlgoModelTaskImpl algoModelTaskImpl4 = AlgoModelTaskImpl.this;
                        algoModelTaskImpl3.m36816a(i2, c, sb2, algoModelTaskImpl4.m36832b(AlgoModelTaskImpl.m36842e(algoModelTaskImpl4.f49150a, AlgoModelTaskImpl.this.f49151b)));
                        return;
                    }
                    AlgoModelTaskImpl algoModelTaskImpl5 = AlgoModelTaskImpl.this;
                    algoModelTaskImpl5.m36815a(algoModelTaskImpl5.f49151b, "config接口配置为空");
                    return;
                }
                if (config.md5.equalsIgnoreCase(AlgoModelTaskImpl.this.mo122061a())) {
                    String c2 = AlgoModelTaskImpl.this.m36844f();
                    if (!TextUtils.isEmpty(c2)) {
                        AlgoModelTaskImpl algoModelTaskImpl6 = AlgoModelTaskImpl.this;
                        int i3 = algoModelTaskImpl6.f49151b;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("使用缓存模型|");
                        if (!config.cache) {
                            str2 = "config接口下发配置和缓存一致";
                        }
                        sb3.append(str2);
                        String sb4 = sb3.toString();
                        AlgoModelTaskImpl algoModelTaskImpl7 = AlgoModelTaskImpl.this;
                        algoModelTaskImpl6.m36816a(i3, c2, sb4, algoModelTaskImpl7.m36832b(AlgoModelTaskImpl.m36842e(algoModelTaskImpl7.f49150a, AlgoModelTaskImpl.this.f49151b)));
                        return;
                    }
                }
                String a = AlgoModelTaskImpl.this.m36812a(new File(AlgoModelTaskImpl.m36846g(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b)), config.md5);
                if (!TextUtils.isEmpty(a)) {
                    AlgoModelTaskImpl.this.m36826a(a, config.url, config.md5);
                    return;
                }
                String str3 = "md5_" + config.md5 + PmFileConstant.ZIP_SUFFIX;
                if (1 == AlgoModelTaskImpl.this.f49153d) {
                    AlgoModelTaskImpl algoModelTaskImpl8 = AlgoModelTaskImpl.this;
                    algoModelTaskImpl8.m36817a(algoModelTaskImpl8.f49151b, config.url, config.md5, str3, 0);
                    return;
                }
                long currentTimeMillis = 15000 - (System.currentTimeMillis() - AlgoModelTaskImpl.this.f49158k);
                long j = currentTimeMillis < 100 ? 100 : currentTimeMillis;
                AlgoModelTaskImpl algoModelTaskImpl9 = AlgoModelTaskImpl.this;
                algoModelTaskImpl9.m36817a(algoModelTaskImpl9.f49151b, config.url, config.md5, str3, j);
            }

            public void onException(Throwable th) {
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                int i = algoModelTaskImpl.f49151b;
                AlgoModelTaskImpl algoModelTaskImpl2 = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m36814a(i, 13, algoModelTaskImpl2.m36813a("config请求失败", algoModelTaskImpl2.m36806a(algoModelTaskImpl2.f49159l), AlgoModelTaskImpl.this.m36839d(), String.valueOf(th)));
                AlgoModelTaskImpl algoModelTaskImpl3 = AlgoModelTaskImpl.this;
                int i2 = algoModelTaskImpl3.f49151b;
                algoModelTaskImpl3.m36815a(i2, "config接口失败|" + th);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo122061a() {
        String d;
        if (!TextUtils.isEmpty(m36844f()) && (d = m36840d(this.f49150a, this.f49151b)) != null) {
            return d;
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AlgoModelTaskManager.ConfigCallback mo122062b() {
        return this.f49155g.getFacadeConfigCallback();
    }

    /* renamed from: d */
    private static String m36840d(Context context, int i) {
        SPHelper b = m36829b(context);
        return (String) b.get("model_zip_md5_type" + i, "");
    }

    /* renamed from: a */
    private static void m36818a(Context context, int i, String str) {
        SPHelper b = m36829b(context);
        b.put("model_zip_md5_type" + i, str).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static String m36842e(Context context, int i) {
        SPHelper b = m36829b(context);
        return (String) b.get("model_zip_url_type" + i, "");
    }

    /* renamed from: b */
    private static void m36833b(Context context, int i, String str) {
        SPHelper b = m36829b(context);
        b.put("model_zip_url_type" + i, str).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static SPHelper m36829b(Context context) {
        if (f49149i == null) {
            f49149i = new SPHelper(context, "access_algo_models_sp");
        }
        return f49149i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36816a(int i, String str, String str2, String str3) {
        m36814a(i, 100, m36813a("模型加载成功", str2, m36806a(this.f49158k), m36832b(str3)));
        if (this.f49154f != null) {
            m36827a(false);
            this.f49154f.onSuccess(i, str);
        }
        this.f49157j = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36815a(int i, String str) {
        m36814a(i, 50, m36813a("模型加载失败", str, m36806a(this.f49158k), m36835c()));
        if (this.f49154f != null) {
            m36827a(false);
            this.f49154f.onFail(i);
        }
        this.f49157j = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36814a(int i, int i2, String str) {
        Pair pair;
        if (this.f49154f != null) {
            if (50 == i2 && (pair = f49148e.get(Integer.valueOf(i))) != null) {
                str = str + "|(后台更新模型失败)" + ((String) pair.second);
                f49148e.remove(Integer.valueOf(i));
            }
            this.f49154f.onMessage(i, i2, str);
        } else if (i2 == 13 || i2 == 22) {
            f49148e.put(Integer.valueOf(i), new Pair(Integer.valueOf(i2), str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36817a(final int i, String str, final String str2, String str3, long j) {
        this.f49159l = System.currentTimeMillis();
        m36814a(i, 20, m36813a("开始下载模型", m36839d(), m36832b(str)));
        this.f49156h.download(this.f49150a, i, this.f49153d, str, str2, str3, j, new FileDownloaderListener() {
            public void success(String str, String str2) {
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m36814a(i, 21, algoModelTaskImpl.m36813a("模型下载成功", algoModelTaskImpl.m36806a(algoModelTaskImpl.f49159l), AlgoModelTaskImpl.this.m36832b(str), AlgoModelTaskImpl.this.m36839d()));
                AlgoModelTaskImpl.this.m36826a(str2, str, str2);
            }

            public void progress(int i) {
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m36824a("资源下载中 " + i + "%");
            }

            public void failed(Throwable th) {
                String b = AlgoModelTaskImpl.m36842e(AlgoModelTaskImpl.this.f49150a, i);
                String a = !TextUtils.isEmpty(b) ? AlgoModelTaskImpl.this.m36832b(b) : "";
                AlgoModelTaskImpl algoModelTaskImpl = AlgoModelTaskImpl.this;
                algoModelTaskImpl.m36814a(i, 22, algoModelTaskImpl.m36813a("模型下载失败", algoModelTaskImpl.m36806a(algoModelTaskImpl.f49159l), AlgoModelTaskImpl.this.m36832b(b), AlgoModelTaskImpl.this.m36839d(), th, AlgoModelTaskImpl.this.m36835c(), a));
                AlgoModelTaskImpl algoModelTaskImpl2 = AlgoModelTaskImpl.this;
                int i = i;
                algoModelTaskImpl2.m36815a(i, "模型下载失败|" + th);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m36812a(File file, String str) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile() && FileUtils.fileToMD5(file2).equalsIgnoreCase(str)) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36826a(String str, String str2, String str3) {
        String f = m36845f(this.f49150a, this.f49151b);
        if (!new File(f).mkdirs()) {
            m36815a(this.f49151b, "创建解压目录失败");
            return;
        }
        try {
            m36825a(str, f);
            String a = m36807a(this.f49150a, this.f49151b);
            if (!m36828a(new File(a))) {
                m36815a(this.f49151b, "删除老模型失败");
                return;
            }
            if (new File(f).renameTo(new File(a))) {
                m36818a(this.f49150a, this.f49151b, str3);
                m36833b(this.f49150a, this.f49151b, str2);
                m36816a(this.f49151b, a, "使用下载模型", m36832b(str2));
            } else {
                m36815a(this.f49151b, "重命名解压目录失败");
            }
            m36828a(new File(m36846g(this.f49150a, this.f49151b)));
        } catch (Throwable unused) {
            m36828a(new File(m36846g(this.f49150a, this.f49151b)));
            m36815a(this.f49151b, "zip文件解压失败");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m36844f() {
        File[] listFiles;
        String a = m36807a(this.f49150a, this.f49151b);
        File file = new File(a);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return null;
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m36828a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile() && file.delete()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return file.delete();
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    return false;
                }
            } else if (file2.isDirectory() && !m36828a(file2)) {
                return false;
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    private void m36825a(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            String name = zipEntry.getName();
            File file = new File(str2 + "/" + name);
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            IOUtils.copy(inputStream, fileOutputStream);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m36832b(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(47)) >= 0) {
            int i = lastIndexOf + 1;
            int indexOf = str.indexOf(63);
            if (indexOf > i) {
                return str.substring(i, indexOf);
            }
            if (indexOf < 0) {
                return str.substring(i);
            }
        }
        return "";
    }

    /* renamed from: f */
    private static String m36845f(Context context, int i) {
        return m36846g(context, i) + "/unzip" + System.nanoTime();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static String m36846g(Context context, int i) {
        return m36847h(context, i) + "/temp";
    }

    /* renamed from: a */
    static String m36807a(Context context, int i) {
        return m36847h(context, i) + "/model";
    }

    /* renamed from: h */
    private static String m36847h(Context context, int i) {
        return context.getFilesDir().getAbsolutePath() + "/accessAlgoModels/type" + i;
    }

    class ConfigDelegate {
        ConfigListener configListener;
        AlgoModelTaskManager.ConfigCallback facadeConfigCallback;

        ConfigDelegate() {
        }

        /* access modifiers changed from: package-private */
        public void getConfig(ConfigListener configListener2) {
            if (!getConfigSdkVersion(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b).equalsIgnoreCase(AlgoModelTaskImpl.this.f49152c) || System.currentTimeMillis() - getRequestConfigTime(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b) >= 86400000) {
                this.configListener = configListener2;
                AlgoModelTaskManager.m36854a(AlgoModelTaskImpl.this);
                return;
            }
            Config config = new Config();
            config.md5 = getConfigModelMd5(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b);
            config.url = getConfigModelUrl(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b);
            config.cache = true;
            configListener2.onSuccess(config);
        }

        /* access modifiers changed from: package-private */
        public AlgoModelTaskManager.ConfigCallback getFacadeConfigCallback() {
            if (this.facadeConfigCallback == null) {
                this.facadeConfigCallback = new AlgoModelTaskManager.ConfigCallback() {
                    public void onSuccess(AlgoModelConfigResult.ResultModel resultModel) {
                        Config config = new Config();
                        config.cache = false;
                        if (resultModel != null && resultModel.type == AlgoModelTaskImpl.this.f49151b) {
                            config.url = resultModel.url;
                            config.md5 = resultModel.md5;
                            ConfigDelegate configDelegate = ConfigDelegate.this;
                            configDelegate.setRequestConfigTime(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b, System.currentTimeMillis());
                            if (!TextUtils.isEmpty(resultModel.url)) {
                                ConfigDelegate configDelegate2 = ConfigDelegate.this;
                                configDelegate2.setConfigModelMd5(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b, resultModel.md5);
                                ConfigDelegate configDelegate3 = ConfigDelegate.this;
                                configDelegate3.setConfigModelUrl(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b, resultModel.url);
                            }
                            ConfigDelegate configDelegate4 = ConfigDelegate.this;
                            configDelegate4.setConfigSdkVersion(AlgoModelTaskImpl.this.f49150a, AlgoModelTaskImpl.this.f49151b, AlgoModelTaskImpl.this.f49152c);
                        }
                        ConfigDelegate.this.configListener.onSuccess(config);
                    }

                    public void onFailure(Exception exc) {
                        ConfigDelegate.this.configListener.onException(exc);
                    }
                };
            }
            return this.facadeConfigCallback;
        }

        private long getRequestConfigTime(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            Long l = (Long) a.get("request_config_time_type" + i, 0L);
            if (l != null) {
                return l.longValue();
            }
            return 0;
        }

        /* access modifiers changed from: private */
        public void setRequestConfigTime(Context context, int i, long j) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            a.put("request_config_time_type" + i, Long.valueOf(j)).apply();
        }

        private String getConfigModelUrl(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            return (String) a.get("config_model_url_type" + i, "");
        }

        /* access modifiers changed from: private */
        public void setConfigModelUrl(Context context, int i, String str) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            String str2 = "config_model_url_type" + i;
            if (str == null) {
                str = "";
            }
            a.put(str2, str).apply();
        }

        private String getConfigModelMd5(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            return (String) a.get("config_model_md5_type" + i, "");
        }

        /* access modifiers changed from: private */
        public void setConfigModelMd5(Context context, int i, String str) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            String str2 = "config_model_md5_type" + i;
            if (str == null) {
                str = "";
            }
            a.put(str2, str).apply();
        }

        private String getConfigSdkVersion(Context context, int i) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            return (String) a.get("config_sdk_version_type" + i, "");
        }

        /* access modifiers changed from: private */
        public void setConfigSdkVersion(Context context, int i, String str) {
            SPHelper a = AlgoModelTaskImpl.m36829b(context);
            String str2 = "config_sdk_version_type" + i;
            if (str == null) {
                str = "";
            }
            a.put(str2, str).apply();
        }
    }

    class Config {
        boolean cache;
        String md5;
        String url;

        Config() {
        }
    }

    static class DownloadDelegate {
        static Map<Integer, DownloadTask> sDownloadListeners = new ConcurrentHashMap();
        static Handler sHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                DownloadTask downloadTask = DownloadDelegate.sDownloadListeners.get(Integer.valueOf(message.what - 100));
                if (downloadTask != null && downloadTask.downloadListener != null) {
                    downloadTask.timeout = true;
                    downloadTask.downloadListener.failed(new Exception("time out!!"));
                }
            }
        };

        DownloadDelegate() {
        }

        /* access modifiers changed from: package-private */
        public int getProgress(int i) {
            DownloadTask downloadTask = sDownloadListeners.get(Integer.valueOf(i));
            if (downloadTask != null) {
                return downloadTask.progress;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void download(Context context, final int i, int i2, String str, String str2, String str3, long j, FileDownloaderListener fileDownloaderListener) {
            int i3 = i + 100;
            sHandler.removeMessages(i3);
            if (i2 == 0 && j > 0) {
                sHandler.sendEmptyMessageDelayed(i3, j);
            }
            DownloadTask downloadTask = new DownloadTask(fileDownloaderListener);
            DownloadTask put = sDownloadListeners.put(Integer.valueOf(i), downloadTask);
            if (put == null) {
                FileDownloader.download(context, new FileDownloader.ParamBuilder().setUrl(str).setDirectory(AlgoModelTaskImpl.m36846g(context, i)).setFileName(str3).setRetryTime(1 == i2 ? 2 : 0).setRetryDelayInMills(3000).setUseRange(true).build(), new FileDownloaderListener() {
                    int currentPrg = 0;

                    public void success(String str, String str2) {
                        DownloadTask remove = DownloadDelegate.sDownloadListeners.remove(Integer.valueOf(i));
                        if (remove != null && remove.downloadListener != null && !remove.timeout) {
                            remove.downloadListener.success(str, str2);
                        }
                    }

                    public void progress(int i) {
                        DownloadTask downloadTask = DownloadDelegate.sDownloadListeners.get(Integer.valueOf(i));
                        if (downloadTask != null && downloadTask.downloadListener != null && !downloadTask.timeout) {
                            downloadTask.progress = i;
                            downloadTask.downloadListener.progress(i);
                        }
                    }

                    public void failed(Throwable th) {
                        DownloadTask remove = DownloadDelegate.sDownloadListeners.remove(Integer.valueOf(i));
                        if (remove != null && remove.downloadListener != null && !remove.timeout) {
                            remove.downloadListener.failed(th);
                        }
                    }
                });
            } else {
                downloadTask.progress = put.progress;
            }
            if (downloadTask.downloadListener != null) {
                downloadTask.downloadListener.progress(downloadTask.progress);
            }
        }
    }

    private static class DownloadTask {
        FileDownloaderListener downloadListener;
        int progress = 0;
        boolean timeout = false;

        public DownloadTask(FileDownloaderListener fileDownloaderListener) {
            this.downloadListener = fileDownloaderListener;
        }
    }
}
