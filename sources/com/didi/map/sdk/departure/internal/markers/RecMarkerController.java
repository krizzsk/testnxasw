package com.didi.map.sdk.departure.internal.markers;

import android.animation.ValueAnimator;
import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.departure.internal.rec.IRecMarker;
import com.didi.map.sdk.departure.internal.rec.RecMarkerImpl;
import com.didi.map.sdk.departure.internal.rec.RecMarkerParam;
import com.didi.map.sdk.departure.internal.rec.SquareHelper;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.didi.map.sdk.departure.internal.util.OmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecMarkerController implements IRecMarkerController {

    /* renamed from: a */
    private static final String f30617a = "RecMarkerController";

    /* renamed from: b */
    private Context f30618b;

    /* renamed from: c */
    private Map f30619c;

    /* renamed from: d */
    private RecMarkerControllerParam f30620d;

    /* renamed from: e */
    private boolean f30621e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<IRecMarker> f30622f;

    /* renamed from: g */
    private double f30623g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f30618b = context.getApplicationContext();
        this.f30619c = map;
        this.f30622f = new ArrayList();
        this.f30623g = this.f30619c.getCameraPosition().zoom;
    }

    public void destroy() {
        remove();
        this.f30618b = null;
        this.f30619c = null;
        List<IRecMarker> list = this.f30622f;
        if (list != null) {
            list.clear();
            this.f30622f = null;
        }
    }

    public void setConfigParam(RecMarkerControllerParam recMarkerControllerParam) {
        this.f30620d = recMarkerControllerParam;
    }

    public void add() {
        RecMarkerControllerParam recMarkerControllerParam = this.f30620d;
        if (recMarkerControllerParam != null && this.f30619c != null) {
            if (CollectionUtil.isEmpty((Collection<?>) recMarkerControllerParam.list)) {
                remove();
                return;
            }
            remove();
            for (RecPoint next : this.f30620d.list) {
                DLog.m10773d(f30617a, "loop:" + next.location.toString() + "," + next.addrName, new Object[0]);
                RecMarkerImpl recMarkerImpl = new RecMarkerImpl();
                recMarkerImpl.create(this.f30618b, this.f30619c);
                RecMarkerParam recMarkerParam = new RecMarkerParam();
                recMarkerParam.point = next;
                recMarkerParam.selectedIcon = this.f30620d.selectedIcon;
                recMarkerParam.icon = this.f30620d.icon;
                recMarkerParam.isClickEnable = this.f30620d.isClickable;
                recMarkerParam.listener = this.f30620d.markerClickListener;
                recMarkerImpl.setConfigParam(recMarkerParam);
                recMarkerImpl.add();
                this.f30622f.add(recMarkerImpl);
                OmegaUtil.trackShowRecMarker(next);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f) && this.f30618b != null) {
                SquareHelper.sortAndHideWithWeight(new ArrayList(this.f30622f));
            }
        }
    }

    public void remove() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            for (IRecMarker next : this.f30622f) {
                if (next != null) {
                    next.remove();
                }
            }
            this.f30622f.clear();
        }
    }

    public void remove(int i) {
        if (i <= 10) {
            remove();
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            IRecMarker iRecMarker = this.f30622f.get(0);
            if (iRecMarker == null) {
                for (IRecMarker next : this.f30622f) {
                    if (next != null) {
                        next.remove();
                    }
                }
                this.f30622f.clear();
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{iRecMarker.getAlpha(), 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() > 0.9f) {
                        for (IRecMarker iRecMarker : RecMarkerController.this.f30622f) {
                            if (iRecMarker != null) {
                                iRecMarker.remove();
                            }
                        }
                        RecMarkerController.this.f30622f.clear();
                        return;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (IRecMarker iRecMarker2 : RecMarkerController.this.f30622f) {
                        if (iRecMarker2 != null) {
                            iRecMarker2.setAlpha(floatValue);
                        }
                    }
                }
            });
            ofFloat.setDuration((long) i);
            ofFloat.start();
        }
    }

    public void showCircles() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            for (IRecMarker next : this.f30622f) {
                if (next != null) {
                    next.showCircles();
                }
            }
        }
    }

    public void hideCircles() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            for (IRecMarker next : this.f30622f) {
                if (next != null) {
                    next.hideCircles();
                }
            }
        }
    }

    public void visible(boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            this.f30621e = z;
            for (IRecMarker next : this.f30622f) {
                if (next != null) {
                    next.visible(z);
                }
            }
        }
    }

    public boolean isVisible() {
        return this.f30621e;
    }

    public void showTransientCircles(LatLng latLng) {
        IRecMarker findMarker = findMarker(latLng);
        if (findMarker != null) {
            findMarker.showTransientCircles();
        }
    }

    public IRecMarker findMarker(LatLng latLng) {
        if (latLng == null || CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            return null;
        }
        for (IRecMarker next : this.f30622f) {
            if (LatLngUtil.isSameLatLng(latLng, next.getLocation())) {
                return next;
            }
        }
        return null;
    }

    public void onMapStable() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            for (IRecMarker next : this.f30622f) {
                if (next != null) {
                    next.onMapStable();
                }
            }
        }
    }

    public void onZoomChange(double d) {
        if (Math.abs(d - this.f30623g) >= 0.1d) {
            this.f30623g = d;
            if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f) && this.f30618b != null) {
                SquareHelper.sortAndHideWithWeight(new ArrayList(this.f30622f));
            }
        }
    }

    public void setNeedShowInfoWindow(boolean z) {
        SystemUtils.log(3, "ccc", "setNeedShowInfoWindow need:" + z, (Throwable) null, "com.didi.map.sdk.departure.internal.markers.RecMarkerController", 270);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f30622f)) {
            for (IRecMarker next : this.f30622f) {
                if (next != null) {
                    next.setNeedShowInfoWindow(z);
                }
            }
        }
    }
}
