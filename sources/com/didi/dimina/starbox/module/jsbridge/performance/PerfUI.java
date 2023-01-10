package com.didi.dimina.starbox.module.jsbridge.performance;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaPerfStorage;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IView;
import com.didi.dimina.starbox.module.jsbridge.performance.perfs.CPUProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.perfs.FPSProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.perfs.MemoryProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.perfs.RenderDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.perfs.SimpleDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.view.PerfTextView;
import com.didi.dimina.starbox.util.ForegroundChecker;
import com.didi.dimina.webview.util.C8407Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class PerfUI extends ScrollView implements ForegroundChecker.OnForegroundChange {

    /* renamed from: a */
    private final ArrayList<ForegroundChecker.OnForegroundChange> f19945a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f19946b;

    /* renamed from: a */
    private void m16935a(List<IView<?>> list) {
        list.add(m16933a(new CPUProvider(), new PerfTextView(getContext(), "CPU", "%.1f%s", "%")));
        list.add(m16933a(new MemoryProvider(this.f19946b), new PerfTextView<JSONObject>(getContext()) {
            public void onProvide(JSONObject jSONObject) {
                double doubleValue = ((Double) jSONObject.opt(MemoryProvider.TAG_V8_MEMORY)).doubleValue();
                if (doubleValue <= 0.0d) {
                    setText(String.format(Locale.US, "内存: %s", new Object[]{jSONObject.opt(MemoryProvider.TAG_TOTAL_MEMORY)}));
                    return;
                }
                setText(String.format(Locale.US, "内存: %s  V8: %.1fm", new Object[]{jSONObject.opt(MemoryProvider.TAG_TOTAL_MEMORY), Double.valueOf(doubleValue)}));
            }
        }));
        list.add(m16933a(new SimpleDataProvider<Long>() {
            /* access modifiers changed from: protected */
            public Long onDataProvide() {
                long j;
                DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(PerfUI.this.f19946b);
                if (findDMMinaByAppId == null) {
                    j = 0;
                } else {
                    j = findDMMinaByAppId.getPerformance().getCurPageChangeTime();
                }
                return Long.valueOf(j);
            }
        }, new PerfTextView(getContext(), "页面切换", "%d%s", "ms")));
        list.add(m16933a(new SimpleDataProvider<Long>() {
            /* access modifiers changed from: protected */
            public Long onDataProvide() {
                long j;
                DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(PerfUI.this.f19946b);
                if (findDMMinaByAppId == null) {
                    j = 0;
                } else {
                    j = findDMMinaByAppId.getPerformance().getLaunchDuration();
                }
                return Long.valueOf(j);
            }
        }, new PerfTextView(getContext(), "启动耗时", "%d%s", "ms")));
        list.add(m16933a(new RenderDataProvider(this.f19946b), new PerfTextView(getContext(), "初次渲染", "%d%s", "ms")));
        list.add(m16933a(new FPSProvider(), new PerfTextView(getContext(), "帧率", "%d%s", "fps")));
        list.add(m16933a(new SimpleDataProvider<Long>() {
            /* access modifiers changed from: protected */
            public Long onDataProvide() {
                DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(PerfUI.this.f19946b);
                long j = 0;
                if (findDMMinaByAppId == null) {
                    return 0L;
                }
                DMMinaPerfStorage minaPerfStorage = findDMMinaByAppId.getPerformance().getMinaPerfStorage();
                if (minaPerfStorage != null) {
                    j = minaPerfStorage.getTotal();
                }
                return Long.valueOf(j);
            }
        }, new PerfTextView<Long>(getContext()) {
            public void onProvide(Long l) {
                setText(String.format(Locale.US, "数据大小: %s", new Object[]{C8407Util.smartConvert(l.longValue()).toLowerCase(Locale.US)}));
            }
        }));
        list.add(m16933a(new SimpleDataProvider<Integer>() {
            /* access modifiers changed from: protected */
            public Integer onDataProvide() {
                DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(PerfUI.this.f19946b);
                if (findDMMinaByAppId == null) {
                    return 0;
                }
                return Integer.valueOf(findDMMinaByAppId.getMethodInject().getJSWindowApi().getMessageArgs().size());
            }
        }, new PerfTextView(getContext(), "计时器数目", TimeModel.NUMBER_FORMAT, "个")));
    }

    /* renamed from: a */
    private <T extends IPerformance<R> & ForegroundChecker.OnForegroundChange, R> IView<R> m16933a(T t, IView<R> iView) {
        this.f19945a.add(t);
        t.registerProvider(iView);
        return iView;
    }

    public PerfUI(Context context, String str) {
        super(context);
        this.f19946b = str;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int dip2px = PixUtil.dip2px(context, 10.0f);
        linearLayout.setPadding(dip2px, dip2px, dip2px, dip2px);
        linearLayout.setBackgroundColor(Color.parseColor("#6d000000"));
        addView(linearLayout);
        ArrayList<IView> arrayList = new ArrayList<>();
        m16935a((List<IView<?>>) arrayList);
        for (IView view : arrayList) {
            linearLayout.addView(view.view());
        }
    }

    public void onChange(boolean z) {
        Iterator<ForegroundChecker.OnForegroundChange> it = this.f19945a.iterator();
        while (it.hasNext()) {
            it.next().onChange(z);
        }
    }

    public void cancel() {
        onChange(false);
    }
}
