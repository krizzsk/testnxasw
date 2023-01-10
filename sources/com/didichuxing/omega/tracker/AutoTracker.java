package com.didichuxing.omega.tracker;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didichuxing.omega.sdk.UIAutoTracker;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.utils.PrismUtil;
import com.taxis99.R;
import com.xiaojuchefu.prism.monitor.model.EventData;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class AutoTracker {
    private static final float DEFAULT_SHOW_AREA = 1.0f;
    private static final long DEFAULT_SHOW_INTERVAL = 1000;
    private static final String ITEM_INDEX = "item_index";
    private static final String ITEM_NAME = "item_name";
    private static final int NON_SEND_EVENT = 101;
    private static final int SEND_EVENT = 100;
    private static boolean canBind = true;
    /* access modifiers changed from: private */
    public static boolean canReport = false;
    private static WeakHashMap<View, EventParameters> clickReporterMap = new WeakHashMap<>();
    private static ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            AutoTracker.reportAllShowEvent();
        }
    };
    private static ExecutorService mExecutorService = ThreadPoolHelp.Builder.fixed(3).builder();
    private static Handler m_Handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            View view;
            EventParameters eventParameters;
            if (message.obj != null && (view = (View) ((WeakReference) message.obj).get()) != null && (eventParameters = (EventParameters) AutoTracker.showReporterMap.get(view)) != null) {
                eventParameters.msgSet.remove(message);
                if (AutoTracker.canReport && eventParameters.canReport && AutoTracker.isCurActivity(view) && 101 != message.what) {
                    if (AutoTracker.isCover(view, eventParameters)) {
                        boolean unused = eventParameters.isSendHandler = false;
                        boolean unused2 = eventParameters.isReportEvent = false;
                    } else if (!eventParameters.isReportEvent) {
                        AutoTracker.reportEvent(eventParameters);
                        boolean unused3 = eventParameters.isReportEvent = true;
                    }
                    super.handleMessage(message);
                }
            }
        }
    };
    private static ViewTreeObserver.OnScrollChangedListener scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
        public void onScrollChanged() {
            AutoTracker.reportAllShowEvent();
        }
    };
    /* access modifiers changed from: private */
    public static float showArea = 1.0f;
    /* access modifiers changed from: private */
    public static long showInterval = 1000;
    /* access modifiers changed from: private */
    public static WeakHashMap<View, EventParameters> showReporterMap = new WeakHashMap<>();
    private static WeakReference<Activity> weakAcy;

    public interface IParametersGenerator {
        Map<String, Object> generatorParameters();
    }

    public interface IReportSetting {
        boolean reportCheck();
    }

    public static void setShowInterval(long j) {
        if (j >= 0) {
            showInterval = j;
        }
    }

    public static void setShowArea(float f) {
        if (f > 0.0f && f <= 1.0f) {
            showArea = f;
        }
    }

    public static void setClickEvent(View view, String str, Map<String, Object> map) {
        setClickEvent(view, str, map, (IParametersGenerator) null);
    }

    public static void setClickEvent(View view, String str, Map<String, Object> map, IParametersGenerator iParametersGenerator) {
        if (view != null && !TextUtils.isEmpty(str)) {
            if (canReport) {
                clickReporterMap.put(view, new EventParameters.Builder(str).setParameters(map).setParametersGenerator(iParametersGenerator).Build());
            }
            bindEvent(view, str, map, true);
        }
    }

    public static void setClickEvent(View view, EventParameters eventParameters) {
        if (view != null && eventParameters != null && !TextUtils.isEmpty(eventParameters.eventId)) {
            if (canReport) {
                clickReporterMap.put(view, eventParameters);
            }
            bindEvent(view, eventParameters.eventId, eventParameters.parameters, true);
        }
    }

    public static void setShowEvent(View view, String str, Map<String, Object> map) {
        setShowEvent(view, str, map, (IParametersGenerator) null);
    }

    public static void setShowEvent(View view, String str, Map<String, Object> map, IParametersGenerator iParametersGenerator) {
        if (view != null && !TextUtils.isEmpty(str)) {
            if (canReport) {
                showReporterMap.put(view, new EventParameters.Builder(str).setParameters(map).setParametersGenerator(iParametersGenerator).Build());
            }
            bindEvent(view, str, map, false);
        }
    }

    public static void setShowEvent(View view, EventParameters eventParameters) {
        if (view != null && eventParameters != null && !TextUtils.isEmpty(eventParameters.eventId)) {
            if (canReport) {
                showReporterMap.put(view, eventParameters);
            }
            bindEvent(view, eventParameters.eventId, eventParameters.parameters, false);
        }
    }

    public static void closeSingleAutoReport(View view) {
        EventParameters eventParameters = clickReporterMap.get(view);
        if (eventParameters != null) {
            boolean unused = eventParameters.canReport = false;
        }
        EventParameters eventParameters2 = showReporterMap.get(view);
        if (eventParameters2 != null) {
            boolean unused2 = eventParameters2.canReport = false;
        }
    }

    public static void closeGlobalAutoReport() {
        canReport = false;
    }

    public static void closeGlobalDataBind() {
        canBind = false;
    }

    public static class EventParameters {
        /* access modifiers changed from: private */
        public volatile boolean canReport;
        /* access modifiers changed from: private */
        public String eventId;
        /* access modifiers changed from: private */
        public boolean isReportEvent;
        /* access modifiers changed from: private */
        public boolean isSendHandler;
        /* access modifiers changed from: private */
        public Set<Message> msgSet;
        /* access modifiers changed from: private */
        public Map<String, Object> parameters;
        /* access modifiers changed from: private */
        public IParametersGenerator parametersGenerator;
        /* access modifiers changed from: private */
        public IReportSetting reportSetting;
        /* access modifiers changed from: private */
        public float showArea;
        /* access modifiers changed from: private */
        public long showInterval;
        private int touchAction;

        private EventParameters() {
            this.msgSet = new HashSet();
            this.canReport = true;
        }

        private EventParameters(Builder builder) {
            this.msgSet = new HashSet();
            this.canReport = true;
            this.eventId = builder.eventId;
            this.parameters = builder.parameters;
            this.parametersGenerator = builder.parametersGenerator;
            this.reportSetting = builder.reportSetting;
            this.touchAction = builder.touchAction;
            this.showInterval = builder.showInterval;
            this.showArea = builder.showArea;
        }

        public static class Builder {
            /* access modifiers changed from: private */
            public String eventId;
            /* access modifiers changed from: private */
            public Map<String, Object> parameters;
            /* access modifiers changed from: private */
            public IParametersGenerator parametersGenerator;
            /* access modifiers changed from: private */
            public IReportSetting reportSetting;
            /* access modifiers changed from: private */
            public float showArea = AutoTracker.showArea;
            /* access modifiers changed from: private */
            public long showInterval = AutoTracker.showInterval;
            /* access modifiers changed from: private */
            public int touchAction;

            public Builder(String str) {
                this.eventId = str;
            }

            public Builder setParameters(Map<String, Object> map) {
                this.parameters = map;
                return this;
            }

            public Builder setParametersGenerator(IParametersGenerator iParametersGenerator) {
                this.parametersGenerator = iParametersGenerator;
                return this;
            }

            public Builder setReportSetting(IReportSetting iReportSetting) {
                this.reportSetting = iReportSetting;
                return this;
            }

            public Builder setShowInterval(long j) {
                if (j < 0) {
                    return this;
                }
                this.showInterval = j;
                return this;
            }

            public Builder setShowArea(float f) {
                if (f > 0.0f && f <= 1.0f) {
                    this.showArea = f;
                }
                return this;
            }

            public EventParameters Build() {
                return new EventParameters(this);
            }
        }
    }

    public static void reportClickEvent(View view, EventData eventData) {
        reportEvent(clickReporterMap.get(view));
    }

    public static void onViewResume(Activity activity) {
        if (activity != null) {
            weakAcy = new WeakReference<>(activity);
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnScrollChangedListener(scrollChangedListener);
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
            resetEventParameters();
            reportAllShowEvent();
        }
    }

    public static void onViewPause(Activity activity) {
        if (activity != null) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().removeOnScrollChangedListener(scrollChangedListener);
            decorView.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
            weakAcy = null;
        }
    }

    /* access modifiers changed from: private */
    public static void reportAllShowEvent() {
        EventParameters eventParameters;
        Set<View> keySet = showReporterMap.keySet();
        if (keySet.size() != 0) {
            for (View next : keySet) {
                if (isCurActivity(next) && (eventParameters = showReporterMap.get(next)) != null && canReport && eventParameters.canReport) {
                    if (isCover(next, eventParameters)) {
                        boolean unused = eventParameters.isSendHandler = false;
                        boolean unused2 = eventParameters.isReportEvent = false;
                        for (Message message : eventParameters.msgSet) {
                            message.what = 101;
                        }
                    } else if (!eventParameters.isSendHandler) {
                        Message obtain = Message.obtain();
                        obtain.what = 100;
                        obtain.obj = new WeakReference(next);
                        eventParameters.msgSet.add(obtain);
                        boolean unused3 = eventParameters.isSendHandler = true;
                        if (eventParameters.showInterval > 0) {
                            m_Handler.sendMessageDelayed(obtain, eventParameters.showInterval);
                        } else {
                            m_Handler.sendMessage(obtain);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isCurActivity(View view) {
        Activity scanForActivity = UIAutoTracker.scanForActivity(view.getContext());
        if (scanForActivity != null && weakAcy.get() == scanForActivity) {
            return true;
        }
        return false;
    }

    private static void resetEventParameters() {
        Set<View> keySet = showReporterMap.keySet();
        if (keySet.size() != 0) {
            for (View view : keySet) {
                EventParameters eventParameters = showReporterMap.get(view);
                if (eventParameters != null) {
                    boolean unused = eventParameters.isReportEvent = false;
                    boolean unused2 = eventParameters.isSendHandler = false;
                }
            }
        }
    }

    private static void reportShowEvent(View view) {
        reportEvent(showReporterMap.get(view));
    }

    /* access modifiers changed from: private */
    public static void reportEvent(final EventParameters eventParameters) {
        if (eventParameters != null && !TextUtils.isEmpty(eventParameters.eventId) && canReport && eventParameters.canReport) {
            mExecutorService.execute(new Runnable() {
                public void run() {
                    if (AutoTracker.canReport && eventParameters.canReport) {
                        Event event = new Event(eventParameters.eventId);
                        if (eventParameters.parameters != null) {
                            event.putAllAttrs(eventParameters.parameters);
                        }
                        if (eventParameters.parametersGenerator != null) {
                            event.putAllAttrs(eventParameters.parametersGenerator.generatorParameters());
                        }
                        if (eventParameters.reportSetting == null || eventParameters.reportSetting.reportCheck()) {
                            Tracker.trackEvent(event);
                        }
                    }
                }
            });
        }
    }

    private static void bindEvent(View view, String str, Map<String, Object> map, boolean z) {
        String str2;
        if (canBind && PrismUtil.isHavaPrismTool()) {
            String str3 = "";
            if (map == null || map.size() < 2) {
                str2 = str3;
            } else {
                Object obj = map.get("item_index");
                Object obj2 = map.get("item_name");
                String obj3 = obj != null ? obj.toString() : str3;
                if (obj2 != null) {
                    str3 = obj2.toString();
                }
                str2 = str3;
                str3 = obj3;
            }
            if (z) {
                PrismUtil.bindCkEvent(view, str, str3, str2);
            } else {
                PrismUtil.bindEpEvent(view, str, str3, str2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isCover(View view, EventParameters eventParameters) {
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return true;
        }
        if (1.0f == eventParameters.showArea) {
            if (rect.width() < view.getMeasuredWidth() || rect.height() < view.getMeasuredHeight()) {
                return true;
            }
            return false;
        } else if (eventParameters.showArea <= 0.0f || eventParameters.showArea >= 1.0f || ((float) (rect.width() * rect.height())) / ((float) (view.getMeasuredWidth() * view.getMeasuredHeight())) < eventParameters.showArea) {
            return true;
        } else {
            return false;
        }
    }

    public static void bindCkEvent(View view, String str) {
        bindCkEvent(view, str, (Object) null, (Object) null);
    }

    public static void bindEpEvent(View view, String str) {
        bindEpEvent(view, str, (Object) null, (Object) null);
    }

    public static void bindCkEvent(View view, String str, Object obj, Object obj2) {
        if (view != null && !TextUtils.isEmpty(str)) {
            view.setTag(R.id.prism_omega_ck, str);
            if (obj != null) {
                view.setTag(R.id.prism_omega_item_index, obj);
            }
            if (obj2 != null) {
                view.setTag(R.id.prism_omega_item_name, obj2);
            }
        }
    }

    public static void bindEpEvent(View view, String str, Object obj, Object obj2) {
        if (view != null && !TextUtils.isEmpty(str)) {
            view.setTag(R.id.prism_omega_ep, str);
            if (obj != null) {
                view.setTag(R.id.prism_omega_item_index, obj);
            }
            if (obj2 != null) {
                view.setTag(R.id.prism_omega_item_name, obj2);
            }
        }
    }
}
