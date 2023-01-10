package com.didi.soda.web.page.performance;

import android.text.TextUtils;
import com.didi.soda.web.tools.LogUtil;
import java.util.HashMap;

public class PagePerformanceDelegate {

    /* renamed from: a */
    private HashMap<String, PagePerformance> f46465a = new HashMap<>();

    /* renamed from: b */
    private PagePerformanceListener f46466b;

    public void onDestroy() {
        LogUtil.info("PagePerformanceDelegate onDestroy");
        this.f46465a.clear();
        this.f46466b = null;
    }

    public void onWebPageStarted(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.info("PagePerformanceDelegate Started ->" + str);
            PagePerformance pagePerformance = new PagePerformance();
            pagePerformance.url = str;
            pagePerformance.startTime = System.currentTimeMillis();
            this.f46465a.put(str, pagePerformance);
        }
    }

    public void onWebPageFinished(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.info("PagePerformanceDelegate onWebPageFinished");
            if (this.f46465a.containsKey(str)) {
                LogUtil.info("PerformanceDelegate Finished ->" + str);
                PagePerformance remove = this.f46465a.remove(str);
                remove.endTime = System.currentTimeMillis();
                remove.totalTime = remove.endTime - remove.startTime;
                PagePerformanceListener pagePerformanceListener = this.f46466b;
                if (pagePerformanceListener != null) {
                    pagePerformanceListener.onPagePerformance(remove);
                }
            }
        }
    }

    public void setPerformanceListener(PagePerformanceListener pagePerformanceListener) {
        this.f46466b = pagePerformanceListener;
    }
}
