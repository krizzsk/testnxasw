package com.didi.map.global.component.recmarker;

import android.animation.ValueAnimator;
import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.recmarker.model.RecMarkerParam;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.view.IRecMarker;
import com.didi.map.global.component.recmarker.view.RecMarkerImpl;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecMarkerController implements IRecMarkerController {

    /* renamed from: a */
    private static final String f28371a = "RecMarkerController";

    /* renamed from: b */
    private Context f28372b;

    /* renamed from: c */
    private Map f28373c;

    /* renamed from: d */
    private RecMarkerControllerParam f28374d;

    /* renamed from: e */
    private boolean f28375e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<IRecMarker> f28376f;

    /* renamed from: g */
    private boolean f28377g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28372b = context.getApplicationContext();
        this.f28373c = map;
        this.f28376f = new ArrayList();
    }

    public void destroy() {
        remove();
        this.f28372b = null;
        this.f28373c = null;
        List<IRecMarker> list = this.f28376f;
        if (list != null) {
            list.clear();
            this.f28376f = null;
        }
    }

    public void setConfigParam(RecMarkerControllerParam recMarkerControllerParam) {
        this.f28374d = recMarkerControllerParam;
    }

    public void add() {
        RecMarkerControllerParam recMarkerControllerParam = this.f28374d;
        if (recMarkerControllerParam != null && this.f28373c != null) {
            if (CollectionUtil.isEmpty((Collection<?>) recMarkerControllerParam.list)) {
                remove();
                return;
            }
            remove();
            for (RecPoint next : this.f28374d.list) {
                DLog.m10773d(f28371a, "loop:" + next.location.toString() + "," + next.addrName, new Object[0]);
                RecMarkerImpl recMarkerImpl = new RecMarkerImpl();
                recMarkerImpl.create(this.f28372b, this.f28373c);
                RecMarkerParam recMarkerParam = new RecMarkerParam();
                recMarkerParam.point = next;
                recMarkerParam.selectedIcon = this.f28374d.selectedIcon;
                recMarkerParam.icon = this.f28374d.icon;
                recMarkerParam.isClickEnable = this.f28374d.isClickable;
                recMarkerParam.listener = this.f28374d.markerClickListener;
                recMarkerParam.markerCallback = this.f28374d.markerCallback;
                recMarkerParam.isShowLabel = this.f28374d.isShowLabel;
                recMarkerParam.labelView = this.f28374d.labelView;
                recMarkerParam.labelDirection = this.f28374d.labelDirection;
                recMarkerParam.strategy = this.f28374d.strategy;
                recMarkerImpl.setConfigParam(recMarkerParam);
                recMarkerImpl.setNeedShowInfoWindow(this.f28377g);
                recMarkerImpl.setPined(m22207a(next, this.f28374d.pinedPoint));
                recMarkerImpl.add();
                this.f28376f.add(recMarkerImpl);
            }
        }
    }

    /* renamed from: a */
    private boolean m22207a(RecPoint recPoint, RecPoint recPoint2) {
        if (recPoint2 == null) {
            return false;
        }
        return LatLngUtils.isCompletedSameLatLng(recPoint.location, recPoint2.location);
    }

    public void remove() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.remove();
                }
            }
            this.f28376f.clear();
        }
    }

    public void remove(int i) {
        if (i <= 10) {
            remove();
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            IRecMarker iRecMarker = this.f28376f.get(0);
            if (iRecMarker == null) {
                for (IRecMarker next : this.f28376f) {
                    if (next != null) {
                        next.remove();
                    }
                }
                this.f28376f.clear();
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{iRecMarker.getAlpha(), 0.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() > 0.9f) {
                        for (IRecMarker iRecMarker : RecMarkerController.this.f28376f) {
                            if (iRecMarker != null) {
                                iRecMarker.remove();
                            }
                        }
                        RecMarkerController.this.f28376f.clear();
                        return;
                    }
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (IRecMarker iRecMarker2 : RecMarkerController.this.f28376f) {
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
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.showCircles();
                }
            }
        }
    }

    public void hideCircles() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.hideCircles();
                }
            }
        }
    }

    public void visible(boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            this.f28375e = z;
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.visible(z);
                }
            }
        }
    }

    public boolean isVisible() {
        return this.f28375e;
    }

    public void setLabelDirect(String str, int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f) && str != null && !str.isEmpty()) {
            for (IRecMarker next : this.f28376f) {
                if (next != null && next.getId() == str) {
                    next.setLabelDirect(i);
                }
            }
        }
    }

    public void setVisible(String str, boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f) && str != null && !str.isEmpty()) {
            for (IRecMarker next : this.f28376f) {
                if (next != null && next.getId() == str) {
                    next.visible(z);
                }
            }
        }
    }

    public void showTransientCircles(LatLng latLng) {
        IRecMarker findMarker = findMarker(latLng);
        if (findMarker != null) {
            findMarker.showTransientCircles();
        }
    }

    public IRecMarker findMarker(LatLng latLng) {
        if (latLng == null || CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            return null;
        }
        for (IRecMarker next : this.f28376f) {
            if (LatLngUtils.isSameLatLng(latLng, next.getLocation())) {
                return next;
            }
        }
        return null;
    }

    public void updateMarkerPinedState(LatLng latLng) {
        if (latLng != null && !CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next instanceof RecMarkerImpl) {
                    ((RecMarkerImpl) next).isPined = LatLngUtils.isCompletedSameLatLng(latLng, next.getLocation());
                }
            }
        }
    }

    public void onMapStable() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.onMapStable();
                }
            }
        }
    }

    public void onMapScroll() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.onMapScroll();
                }
            }
        }
    }

    public void setNeedShowInfoWindow(boolean z) {
        this.f28377g = z;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28376f)) {
            for (IRecMarker next : this.f28376f) {
                if (next != null) {
                    next.setNeedShowInfoWindow(z);
                }
            }
        }
    }
}
