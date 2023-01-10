package com.didi.map.global.component.line.component.traffic;

import android.content.Context;
import android.os.Build;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineConstant;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrafficLineComponent implements ITrafficLine {
    public static final String TAG = "TrafficLineComponent";

    /* renamed from: a */
    private Context f28053a;

    /* renamed from: b */
    private Map f28054b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LineParams f28055c;

    /* renamed from: d */
    private ITrafficLine f28056d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<LatLng> f28057e = new ArrayList();

    /* renamed from: f */
    private ICompLineContract f28058f;

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f28053a = context;
        this.f28054b = map;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f28055c = lineParams;
            if (lineParams.getLineWidth() == 0) {
                lineParams.setLineWidth(6);
            }
            this.f28057e = lineParams.getLinePoints();
            if (this.f28054b != null && this.f28053a != null) {
                boolean z = true;
                if (C102942.$SwitchMap$com$didi$common$map$MapVendor[this.f28054b.getMapVendor().ordinal()] != 1) {
                    this.f28056d = new GoogleTrafficLine();
                } else {
                    if (Build.VERSION.SDK_INT >= 31) {
                        DLog.m10773d(TAG, "android 12 not enable worm line", new Object[0]);
                        z = false;
                    }
                    if (!lineParams.isEnableEarthWormLine() || !z) {
                        this.f28056d = new GoogleTrafficLine();
                    } else {
                        this.f28056d = new DidiTrafficLine();
                    }
                }
                this.f28056d.setConfigParam(lineParams);
                this.f28056d.create(this.f28053a, this.f28054b);
            }
        }
    }

    /* renamed from: com.didi.map.global.component.line.component.traffic.TrafficLineComponent$2 */
    static /* synthetic */ class C102942 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        static {
            int[] iArr = new int[MapVendor.values().length];
            $SwitchMap$com$didi$common$map$MapVendor = iArr;
            try {
                iArr[MapVendor.DIDI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void destroy() {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.destroy();
            this.f28056d = null;
        }
        ICompLineContract iCompLineContract = this.f28058f;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f28058f = null;
        }
        List<LatLng> list = this.f28057e;
        if (list != null) {
            list.clear();
            this.f28057e = null;
        }
        this.f28053a = null;
        this.f28054b = null;
    }

    public void onMapVisible(boolean z) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.onMapVisible(z);
        }
    }

    public void start() {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.start();
        }
    }

    public void stop() {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.stop();
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f28056d.getAllLinePoints();
    }

    public void drawPulseLine(List<LatLng> list) {
        if (this.f28053a != null && this.f28054b != null && this.f28055c != null) {
            ICompLineContract iCompLineContract = this.f28058f;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.f28058f = null;
            }
            LineExParam exParam = this.f28055c.getExParam();
            if (exParam != null) {
                LineParams lineParams = new LineParams(list, exParam.getPulseLineColor() == 0 ? LineConstant.DEFAULT_PULSE_LINE_COLOR : exParam.getPulseLineColor(), this.f28055c.getLineWidth() + 1);
                lineParams.setZIndex(this.f28055c.getZIndex() + 1);
                lineParams.setExParam(exParam);
                ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_PULSE, this.f28054b, this.f28053a, lineParams);
                this.f28058f = createLineComponent;
                createLineComponent.start();
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            arrayList.addAll(iTrafficLine.getBestViewElements());
        }
        ICompLineContract iCompLineContract = this.f28058f;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f28058f.getBestViewElements());
        }
        return arrayList;
    }

    public void setListener(final OnLineDrawStatusListener onLineDrawStatusListener) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.setListener(new OnLineDrawStatusListener() {
                public void onLineDrawStart() {
                }

                public void onLineDrawFinished() {
                    if (TrafficLineComponent.this.f28055c != null && TrafficLineComponent.this.f28055c.getExParam() != null && TrafficLineComponent.this.f28055c.getExParam().isHasPulseAnim() && !CollectionUtil.isEmpty((Collection<?>) TrafficLineComponent.this.f28057e)) {
                        TrafficLineComponent trafficLineComponent = TrafficLineComponent.this;
                        trafficLineComponent.drawPulseLine(trafficLineComponent.f28057e);
                    }
                    OnLineDrawStatusListener onLineDrawStatusListener = onLineDrawStatusListener;
                    if (onLineDrawStatusListener != null) {
                        onLineDrawStatusListener.onLineDrawFinished();
                    }
                }
            });
        }
    }

    public void setLineVisible(boolean z) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.setLineVisible(z);
        }
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.setLineClickListener(onLineClickListener);
        }
    }

    public void erase(int i, LatLng latLng) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.erase(i, latLng);
        }
    }

    public List<Line> getLines() {
        ITrafficLine iTrafficLine = this.f28056d;
        return iTrafficLine != null ? iTrafficLine.getLines() : new ArrayList();
    }

    public void highLight(boolean z) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }

    public void updateTraffic(List<TrafficData> list) {
        ITrafficLine iTrafficLine = this.f28056d;
        if (iTrafficLine != null) {
            iTrafficLine.updateTraffic(list);
        }
    }
}
