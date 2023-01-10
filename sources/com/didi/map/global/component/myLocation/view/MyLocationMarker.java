package com.didi.map.global.component.myLocation.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.security.wireless.ISecurityConf;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class MyLocationMarker {

    /* renamed from: a */
    private static final String f28352a = "MyLocationMarker";

    /* renamed from: b */
    private static final String f28353b = "map_location_arrow_tag";

    /* renamed from: c */
    private static final String f28354c = "map_location_avator_tag";

    /* renamed from: d */
    private Context f28355d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f28356e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Marker f28357f;

    /* renamed from: g */
    private MarkerOptions f28358g;

    /* renamed from: h */
    private MarkerOptions f28359h;

    /* renamed from: i */
    private LocationAccuracyCircle f28360i;

    /* renamed from: j */
    private ValueAnimator f28361j;
    public Marker mAvatarBase;

    public MyLocationMarker(MyLocationMarkerOptions myLocationMarkerOptions) {
        if (myLocationMarkerOptions != null && myLocationMarkerOptions.getMap() != null) {
            Map map = myLocationMarkerOptions.getMap();
            this.f28356e = map;
            this.f28355d = map.getContext();
            int i = myLocationMarkerOptions.getzIndex();
            if (((SensorManager) this.f28355d.getSystemService(ISecurityConf.KEY_SENSOR)).getDefaultSensor(3) != null) {
                BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(this.f28355d, myLocationMarkerOptions.getArrowIcon() != 0 ? myLocationMarkerOptions.getArrowIcon() : R.drawable.map_icon_position_arrow);
                if (fromResource != null) {
                    Bitmap scaledBitmap = ImageUtil.getScaledBitmap(this.f28355d, fromResource.getBitmap());
                    this.f28358g = new MarkerOptions();
                    DLog.m10773d(f28352a, "have orientation sensor", new Object[0]);
                    this.f28358g.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap));
                    this.f28358g.clickable(false);
                    this.f28358g.anchor(0.5f, 0.5f);
                    this.f28358g.title("location");
                    this.f28358g.zIndex(i);
                    if (LocationHelper.getLastKnownLocation(this.f28355d) != null && this.f28358g.getPosition() == null) {
                        this.f28358g.position(new LatLng(LocationHelper.getLastKnownLocation(this.f28355d).getLatitude(), LocationHelper.getLastKnownLocation(this.f28355d).getLongitude()));
                    }
                }
            } else {
                DLog.m10773d(f28352a, "no orientation sensor", new Object[0]);
            }
            BitmapDescriptor fromResource2 = BitmapDescriptorFactory.fromResource(this.f28355d, myLocationMarkerOptions.getPositionIcon() != 0 ? myLocationMarkerOptions.getPositionIcon() : R.drawable.map_icon_position);
            if (fromResource2 != null) {
                Bitmap scaledBitmap2 = ImageUtil.getScaledBitmap(this.f28355d, fromResource2.getBitmap());
                MarkerOptions markerOptions = new MarkerOptions();
                this.f28359h = markerOptions;
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap2));
                this.f28359h.anchor(0.5f, 0.5f);
                this.f28359h.title("location");
                this.f28359h.zIndex(i + 1);
                if (LocationHelper.getLastKnownLocation(this.f28355d) != null && this.f28359h.getPosition() == null) {
                    this.f28359h.position(new LatLng(LocationHelper.getLastKnownLocation(this.f28355d).getLatitude(), LocationHelper.getLastKnownLocation(this.f28355d).getLongitude()));
                }
            }
            m22199a(myLocationMarkerOptions);
        }
    }

    /* renamed from: a */
    private void m22199a(MyLocationMarkerOptions myLocationMarkerOptions) {
        if (myLocationMarkerOptions == null || myLocationMarkerOptions.getAccuracyCircleOptions() == null) {
            m22197a();
            return;
        }
        m22197a();
        LocationAccuracyCircle locationAccuracyCircle = new LocationAccuracyCircle(this.f28356e, myLocationMarkerOptions.getAccuracyCircleOptions());
        this.f28360i = locationAccuracyCircle;
        locationAccuracyCircle.show();
    }

    public void addSelf() {
        Map map = this.f28356e;
        if (map != null && this.f28357f == null) {
            MarkerOptions markerOptions = this.f28358g;
            if (markerOptions != null) {
                this.f28357f = map.addMarker(f28353b, markerOptions);
            }
            MarkerOptions markerOptions2 = this.f28359h;
            if (markerOptions2 != null) {
                this.mAvatarBase = this.f28356e.addMarker(f28354c, markerOptions2);
            }
            setVisible(false);
        }
    }

    public void removeSelf(boolean z, int i) {
        ValueAnimator valueAnimator = this.f28361j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f28361j = null;
        }
        if (this.f28357f == null) {
            z = false;
        }
        if (z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f28357f.getAlpha(), 0.0f});
            this.f28361j = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (MyLocationMarker.this.f28357f != null) {
                        MyLocationMarker.this.f28357f.setAlpha(floatValue);
                    }
                    if (MyLocationMarker.this.mAvatarBase != null) {
                        MyLocationMarker.this.mAvatarBase.setAlpha(floatValue);
                    }
                    if (valueAnimator.getAnimatedFraction() > 0.9f) {
                        if (MyLocationMarker.this.f28357f != null) {
                            MyLocationMarker.this.f28356e.remove(MyLocationMarker.this.f28357f);
                            Marker unused = MyLocationMarker.this.f28357f = null;
                        }
                        if (MyLocationMarker.this.mAvatarBase != null) {
                            MyLocationMarker.this.f28356e.remove(MyLocationMarker.this.mAvatarBase);
                            MyLocationMarker.this.mAvatarBase = null;
                        }
                    }
                }
            });
            this.f28361j.setDuration((long) i);
            this.f28361j.start();
        } else {
            Marker marker = this.f28357f;
            if (marker != null) {
                this.f28356e.remove(marker);
                this.f28357f = null;
            }
            Marker marker2 = this.mAvatarBase;
            if (marker2 != null) {
                this.f28356e.remove(marker2);
                this.mAvatarBase = null;
            }
        }
        m22197a();
    }

    /* renamed from: a */
    private void m22197a() {
        LocationAccuracyCircle locationAccuracyCircle = this.f28360i;
        if (locationAccuracyCircle != null) {
            locationAccuracyCircle.hide();
        }
    }

    public void updateAccuracyView(LatLng latLng, float f) {
        LocationAccuracyCircle locationAccuracyCircle = this.f28360i;
        if (locationAccuracyCircle != null) {
            locationAccuracyCircle.update(latLng, f);
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null) {
            m22201b(latLng);
            m22198a(latLng);
        }
    }

    /* renamed from: a */
    private void m22198a(LatLng latLng) {
        Marker marker = this.f28357f;
        if (marker == null) {
            MarkerOptions markerOptions = this.f28358g;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                Marker addMarker = this.f28356e.addMarker(f28353b, this.f28358g);
                this.f28357f = addMarker;
                if (addMarker != null) {
                    addMarker.setVisible(true);
                }
            }
        } else if (!latLng.equals(marker.getPosition())) {
            this.f28357f.setPosition(latLng);
        }
    }

    /* renamed from: b */
    private void m22201b(LatLng latLng) {
        Marker marker = this.mAvatarBase;
        if (marker == null) {
            MarkerOptions markerOptions = this.f28359h;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                Marker addMarker = this.f28356e.addMarker(f28354c, this.f28359h);
                this.mAvatarBase = addMarker;
                if (addMarker != null) {
                    addMarker.setVisible(true);
                }
            }
        } else if (!latLng.equals(marker.getPosition())) {
            this.mAvatarBase.setPosition(latLng);
        }
    }

    public void updateArrowRotateAngle(float f) {
        Marker marker;
        if (this.f28358g != null && (marker = this.f28357f) != null && ((double) Math.abs(f - marker.getRotation())) > 0.8d) {
            this.f28358g.rotation(f);
            this.f28357f.setRotation(this.f28358g.getRotation());
        }
    }

    public List<IMapElement> getMarkers() {
        ArrayList arrayList = new ArrayList(2);
        Marker marker = this.f28357f;
        if (marker != null) {
            arrayList.add(marker);
        }
        Marker marker2 = this.mAvatarBase;
        if (marker2 != null) {
            arrayList.add(marker2);
        }
        return arrayList;
    }

    public boolean isVisible() {
        Marker marker = this.f28357f;
        if (marker == null || this.mAvatarBase == null || !marker.isVisible() || !this.mAvatarBase.isVisible()) {
            return false;
        }
        return true;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f28357f;
        if (marker != null) {
            marker.setVisible(z);
        }
        Marker marker2 = this.mAvatarBase;
        if (marker2 != null) {
            marker2.setVisible(z);
        }
        LocationAccuracyCircle locationAccuracyCircle = this.f28360i;
        if (locationAccuracyCircle == null) {
            return;
        }
        if (z) {
            locationAccuracyCircle.show();
        } else {
            locationAccuracyCircle.hide();
        }
    }

    public void setZIndex(int i) {
        Marker marker = this.f28357f;
        if (marker != null) {
            marker.setZIndex(i);
        }
        Marker marker2 = this.mAvatarBase;
        if (marker2 != null) {
            marker2.setZIndex(i);
        }
    }
}
