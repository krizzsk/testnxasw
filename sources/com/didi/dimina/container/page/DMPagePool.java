package com.didi.dimina.container.page;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.mina.DMMemoryManager;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DMPagePool {
    public static final String TAG_PAGE_FRAME = "PAGE_FRAME";

    /* renamed from: a */
    private final LinkedList<DMPage> f18907a = new LinkedList<>();

    /* renamed from: b */
    private final LinkedList<DMPage> f18908b = new LinkedList<>();

    /* renamed from: c */
    private final Map<String, LinkedList<DMPage>> f18909c = new HashMap();

    /* renamed from: d */
    private final Activity f18910d;

    /* renamed from: e */
    private final DMMina f18911e;

    /* renamed from: f */
    private volatile IDMCommonAction<Void> f18912f;

    /* renamed from: g */
    private List<JSAppConfig.DidiPageFrameItem> f18913g;

    public DMPagePool(DMMina dMMina, Activity activity) {
        this.f18910d = activity;
        this.f18911e = dMMina;
    }

    public void requireReadyDMPageCreated(IDMCommonAction<Void> iDMCommonAction, String str) {
        if (this.f18908b.isEmpty() && !m15979a(str)) {
            this.f18912f = iDMCommonAction;
        } else if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
    }

    /* renamed from: a */
    private boolean m15979a(String str) {
        return this.f18909c.get(str) != null && this.f18909c.get(str).size() > 0;
    }

    public DMPage getReadyDMPage(String str) {
        String splitPath = HttpUtil.splitPath(str);
        LogUtil.iRelease("PAGE_FRAME", "开始查询页面缓存项：" + splitPath);
        if (!TextUtils.isEmpty(splitPath)) {
            for (Map.Entry next : this.f18909c.entrySet()) {
                if (splitPath.equals(next.getKey()) && next.getValue() != null && ((LinkedList) next.getValue()).size() > 0) {
                    LogUtil.iRelease("PAGE_FRAME", "取出 di-page-frame: " + ((String) next.getKey()) + " url: " + str);
                    return (DMPage) ((LinkedList) next.getValue()).removeFirst();
                }
            }
        }
        if (this.f18908b.isEmpty()) {
            return null;
        }
        LogUtil.iRelease("PAGE_FRAME", "取出 page-frame url:" + str);
        return this.f18908b.removeFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15976a() {
        DMPage dMPage = (DMPage) LayoutInflater.from(this.f18910d).inflate(R.layout.dimina_webview_fragment, (ViewGroup) null);
        dMPage.preLoadView(this.f18911e);
        this.f18907a.addLast(dMPage);
    }

    /* renamed from: a */
    private boolean m15978a(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (didiPageFrameItem == null || didiPageFrameItem.isEmpty()) {
            return false;
        }
        DMPage dMPage = (DMPage) LayoutInflater.from(this.f18910d).inflate(R.layout.dimina_webview_fragment, (ViewGroup) null);
        dMPage.setPageFrameConfig(didiPageFrameItem);
        if (!dMPage.preLoadSingleView(this.f18911e, didiPageFrameItem)) {
            return false;
        }
        this.f18907a.addLast(dMPage);
        return true;
    }

    public void putDMPageToReady(int i) {
        DMPage preDMPage = getPreDMPage(i);
        if (preDMPage != null) {
            preDMPage.poolMark = 2;
            this.f18907a.remove(preDMPage);
            JSAppConfig.DidiPageFrameItem pageFrameConfig = preDMPage.getPageFrameConfig();
            if (pageFrameConfig == null || pageFrameConfig.isEmpty()) {
                LogUtil.iRelease("PAGE_FRAME", "生成成功: page-frame.");
                this.f18908b.addLast(preDMPage);
            } else if (this.f18909c.containsKey(pageFrameConfig.url)) {
                this.f18909c.get(pageFrameConfig.url).addLast(preDMPage);
                LogUtil.iRelease("PAGE_FRAME", "生成成功: " + pageFrameConfig.url + ".");
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.addLast(preDMPage);
                this.f18909c.put(pageFrameConfig.url, linkedList);
                LogUtil.iRelease("PAGE_FRAME", "生成成功: " + pageFrameConfig.url);
            }
            if (this.f18912f != null) {
                this.f18912f.callback(null);
                this.f18912f = null;
            }
        }
    }

    /* renamed from: b */
    private void m15981b() {
        if (this.f18911e.getJSAppConfig() != null && this.f18911e.getJSAppConfig().didiPageFrame != null) {
            LogUtil.iRelease("PAGE_FRAME", "使用PageFrame，配置页面数为" + this.f18911e.getJSAppConfig().didiPageFrame.size());
            this.f18913g = this.f18911e.getJSAppConfig().didiPageFrame;
        }
    }

    /* renamed from: c */
    private void m15983c() {
        if (this.f18908b.size() < 1) {
            UIHandlerUtil.safePost(this.f18911e, new Runnable() {
                public void run() {
                    DMPagePool.this.m15976a();
                }
            });
        }
    }

    public void genDMPage4FirstCreate() {
        LogUtil.iRelease("PAGE_FRAME", "genDMPage4FirstCreate()");
        m15981b();
        String d = m15985d();
        LogUtil.iRelease("PAGE_FRAME", "第一次启动的默认路径：entryPath = " + d);
        LogUtil.iRelease("PAGE_FRAME", "前端didiPageFrame内容" + JSONUtil.toJson(this.f18911e.getJSAppConfig().didiPageFrame));
        if (TextUtils.isEmpty(d)) {
            m15983c();
        } else if (!m15982b(m15980b(d))) {
            LogUtil.iRelease("PAGE_FRAME", "未生成首页quick-page-frame, 开始生成通用DMPage" + d);
            m15983c();
        }
    }

    /* renamed from: b */
    private JSAppConfig.DidiPageFrameItem m15980b(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("/")) {
            LogUtil.iRelease("PAGE_FRAME", "首页未命中quick-page-frame: 首页路径异常");
            return null;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        String[] split = str.split("/", 2);
        if (split.length < 2) {
            LogUtil.iRelease("PAGE_FRAME", "首页未命中quick-page-frame: 分包名/路径为空");
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            LogUtil.iRelease("PAGE_FRAME", "首页未命中quick-page-frame: 分包名/路径为空");
            return null;
        } else if (this.f18911e.getJSAppConfig().subPackages == null || this.f18911e.getJSAppConfig().subpackagesDir == null) {
            LogUtil.iRelease("PAGE_FRAME", "首页未命中quick-page-frame: subPackages/subpackagesDir为空");
            return null;
        } else {
            String str4 = "";
            for (JSAppConfig.SubPackage next : this.f18911e.getJSAppConfig().subPackages) {
                if (str2.equals(next.root)) {
                    for (String equals : next.pages) {
                        if (str3.equals(equals)) {
                            str4 = this.f18911e.getJSAppConfig().subpackagesDir.get(str2);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            if (this.f18911e.getJSAppConfig().didiPageFrame == null) {
                LogUtil.iRelease("PAGE_FRAME", "首页未命中quick-page-frame: didiPageFrame为空");
                return null;
            }
            for (JSAppConfig.DidiPageFrameItem next2 : this.f18911e.getJSAppConfig().didiPageFrame) {
                if (next2.root.equals(str4) && next2.url.equals(str3)) {
                    LogUtil.iRelease("PAGE_FRAME", "首页命中quick-page-frame: " + str);
                    return next2;
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[SYNTHETIC, Splitter:B:12:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m15985d() {
        /*
            r2 = this;
            com.didi.dimina.container.DMMina r0 = r2.f18911e
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()
            if (r0 == 0) goto L_0x0039
            com.didi.dimina.container.DMMina r0 = r2.f18911e
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()
            com.didi.dimina.container.DMConfig$LaunchConfig r0 = r0.getLaunchConfig()
            if (r0 == 0) goto L_0x0039
            com.didi.dimina.container.DMMina r0 = r2.f18911e
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()
            com.didi.dimina.container.DMConfig$LaunchConfig r0 = r0.getLaunchConfig()
            java.lang.String r0 = r0.getEntryPath()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x003b
            com.didi.dimina.container.DMMina r0 = r2.f18911e
            com.didi.dimina.container.bean.JSAppConfig r0 = r0.getJSAppConfig()
            if (r0 == 0) goto L_0x0039
            com.didi.dimina.container.DMMina r0 = r2.f18911e
            com.didi.dimina.container.bean.JSAppConfig r0 = r0.getJSAppConfig()
            java.lang.String r0 = r0.entryPagePath
            goto L_0x003b
        L_0x0039:
            java.lang.String r0 = ""
        L_0x003b:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x004f
            java.net.URI r1 = new java.net.URI     // Catch:{ URISyntaxException -> 0x004b }
            r1.<init>(r0)     // Catch:{ URISyntaxException -> 0x004b }
            java.lang.String r0 = r1.getPath()     // Catch:{ URISyntaxException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.page.DMPagePool.m15985d():java.lang.String");
    }

    /* renamed from: e */
    private String m15987e() {
        return (this.f18911e.getConfig() == null || this.f18911e.getConfig().getLaunchConfig() == null) ? "" : this.f18911e.getConfig().getLaunchConfig().getAppId();
    }

    public void genDMPage4DomReady() {
        LogUtil.iRelease("PAGE_FRAME", "页面渲染完毕，触发DOMReady");
        for (JSAppConfig.DidiPageFrameItem next : m15989f()) {
            LogUtil.iRelease("PAGE_FRAME", "页面渲染完毕，触发DOMReady 生成分包缓存项：" + next.url);
            m15982b(next);
        }
        if (this.f18908b.size() < 1) {
            LogUtil.iRelease("PAGE_FRAME", "生成:page-frame。页面渲染完毕，触发DOMReady 生成默认通用缓存项");
            UIHandlerUtil.safePost(this.f18911e, new Runnable() {
                public final void run() {
                    DMPagePool.this.m15976a();
                }
            });
        }
    }

    /* renamed from: b */
    private boolean m15982b(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (didiPageFrameItem == null || didiPageFrameItem.isEmpty()) {
            LogUtil.iRelease("PAGE_FRAME", "生成失败 didiPageFrameItem 为空 ");
            return false;
        } else if (!m15986d(didiPageFrameItem)) {
            LogUtil.iRelease("PAGE_FRAME", "生成失败 作为模板的quick-page-frame.html不存在: ");
            return false;
        } else if (!m15988e(didiPageFrameItem)) {
            LogUtil.iRelease("PAGE_FRAME", "生成失败 分包路径不存在: " + didiPageFrameItem.url);
            return false;
        } else {
            if (!this.f18909c.containsKey(didiPageFrameItem.url)) {
                this.f18909c.put(didiPageFrameItem.url, new LinkedList());
            }
            UIHandlerUtil.runOnUiThread(new Runnable(didiPageFrameItem) {
                public final /* synthetic */ JSAppConfig.DidiPageFrameItem f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DMPagePool.this.m15990f(this.f$1);
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m15990f(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        List list = this.f18909c.get(didiPageFrameItem.url);
        if (list == null) {
            return;
        }
        if (list.size() >= 1) {
            LogUtil.iRelease("PAGE_FRAME", "生成失败 已存在: " + didiPageFrameItem.url);
        } else if (m15984c(didiPageFrameItem)) {
            LogUtil.iRelease("PAGE_FRAME", "生成失败 准备池已存在相同页面: " + didiPageFrameItem.url);
        } else if (this.f18911e.getCurNavigator() == null || this.f18911e.getCurNavigator().getCurrentPages() == null || this.f18911e.getCurNavigator().getCurrentPages().size() <= 6 || !DMMemoryManager.getInstance().isLowMemory()) {
            LogUtil.iRelease("PAGE_FRAME", "开始生成分包缓存项: " + didiPageFrameItem.url);
            if (!m15978a(didiPageFrameItem)) {
                m15983c();
            }
        } else {
            LogUtil.iRelease("PAGE_FRAME", "生成失败 内存不足: " + didiPageFrameItem.url);
        }
    }

    /* renamed from: f */
    private List<JSAppConfig.DidiPageFrameItem> m15989f() {
        ArrayList arrayList = new ArrayList();
        List<JSAppConfig.DidiPageFrameItem> list = this.f18913g;
        if (!(list == null || list.size() == 0)) {
            for (JSAppConfig.DidiPageFrameItem next : this.f18913g) {
                if (next != null && !next.isEmpty()) {
                    arrayList.add(next);
                }
            }
            LogUtil.m16842i("PAGE_FRAME", "触发DOMReady，获取需要预加载的页面：" + JSONUtil.toJson(arrayList));
        }
        return arrayList;
    }

    /* renamed from: c */
    private boolean m15984c(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        Iterator it = this.f18907a.iterator();
        while (it.hasNext()) {
            DMPage dMPage = (DMPage) it.next();
            if (dMPage.getPageFrameConfig() != null && dMPage.getPageFrameConfig().url.equals(didiPageFrameItem.url)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private boolean m15986d(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (this.f18911e.getConfig().getLaunchConfig().getBundleManagerStrategy() instanceof RemoteBundleMangerStrategy) {
            return false;
        }
        return FileUtil.isFileProtocolExists(BundleManager.getInstance().transformUrl(this.f18911e, didiPageFrameItem.root, didiPageFrameItem.getModelName()));
    }

    /* renamed from: e */
    private boolean m15988e(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        if (this.f18911e.getConfig().getLaunchConfig().getBundleManagerStrategy() instanceof RemoteBundleMangerStrategy) {
            return false;
        }
        return FileUtil.isParentFileDirProtocolExists(BundleManager.getInstance().transformUrl(this.f18911e, didiPageFrameItem.root, didiPageFrameItem.getModelName()));
    }

    public DMPage getPreDMPage(int i) {
        Iterator it = this.f18907a.iterator();
        while (it.hasNext()) {
            DMPage dMPage = (DMPage) it.next();
            if (dMPage.getWebViewId() == i) {
                return dMPage;
            }
        }
        return null;
    }
}
