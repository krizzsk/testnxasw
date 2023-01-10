package com.didi.map.outer.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.log.LoggerInit;
import com.didi.hawaii.net.NetUtil;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.hawaii.utils.StorageUtils;
import com.didi.map.MapApolloHawaii;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.accessibility.AccessibilityUtils;
import com.didi.map.common.lib.MapLibaryLoader;
import com.didi.map.common.utils.NetSeqUtils;
import com.didi.support.device.DeviceUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MapView extends FrameLayout {

    /* renamed from: c */
    private static final String f30321c = "com.didi.hawaii.mapsdkv2.HWMapView";

    /* renamed from: d */
    private static final String f30322d = "com.didi.hawaii.mapsdkv2.VKMapView";

    /* renamed from: e */
    private static final String f30323e = "com.didi.hawaii.mapsdkv2.HWTextureMapView";

    /* renamed from: f */
    private static final String f30324f = (ApolloHawaii.USE_VULKAN_MAP ? f30322d : f30321c);

    /* renamed from: h */
    private static final String f30325h = "com.didi.map.intent.DUMP_INSPECT_INFO";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DidiMap f30326a;

    /* renamed from: b */
    private ImageView f30327b;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MapDebugView f30328g;

    /* renamed from: i */
    private boolean f30329i;

    /* renamed from: j */
    private final BroadcastReceiver f30330j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MapOpenGL f30331k;

    /* renamed from: l */
    private HawaiiTouchHelper f30332l;

    public MapView(Context context) {
        super(context);
        this.f30326a = null;
        this.f30329i = false;
        this.f30330j = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (MapView.this.f30331k != null) {
                    MapView.this.f30331k.dumpInspectInfo();
                }
            }
        };
        m23535a(context, MapOptions.createDefaultOptions());
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30326a = null;
        this.f30329i = false;
        this.f30330j = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (MapView.this.f30331k != null) {
                    MapView.this.f30331k.dumpInspectInfo();
                }
            }
        };
        m23535a(context, MapOptions.createDefaultOptions());
    }

    public MapView(Context context, int i, MapOptions mapOptions) {
        this(context, mapOptions);
    }

    public MapView(Context context, MapOptions mapOptions) {
        super(context);
        this.f30326a = null;
        this.f30329i = false;
        this.f30330j = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (MapView.this.f30331k != null) {
                    MapView.this.f30331k.dumpInspectInfo();
                }
            }
        };
        m23535a(context, mapOptions);
    }

    /* renamed from: a */
    private void m23535a(Context context, MapOptions mapOptions) {
        m23534a(context);
        setClickable(true);
        if (!isInEditMode()) {
            if (mapOptions == null) {
                mapOptions = MapOptions.createDefaultOptions();
            }
            m23538b(context, mapOptions);
        }
    }

    /* renamed from: a */
    private void m23534a(Context context) {
        HWContextProvider.setContextIfNecessary(context);
        AsyncNetUtils.init(context);
        NetUtil.initNet(context, MapUtil.getUserAgent());
        DeviceUtils.init(context);
        StorageUtils.init(context);
        MapLibaryLoader.init(context);
        LoggerInit.initAll(context, false);
        NetSeqUtils.init();
    }

    /* renamed from: b */
    private void m23538b(final Context context, MapOptions mapOptions) {
        setEnabled(true);
        try {
            String str = f30324f;
            if ((mapOptions != null && mapOptions.isUseTextureMapView()) || ApolloHawaii.IS_USE_TEXTUREVIEW) {
                str = f30323e;
            }
            HWLog.m20433i("hawaii-map", "use map view:" + str + ",version:" + "5766");
            Object newInstance = Class.forName(str).getConstructor(new Class[]{Context.class, MapOptions.class}).newInstance(new Object[]{context, mapOptions});
            if (!(newInstance instanceof View) || !(newInstance instanceof MapOpenGL)) {
                throw new IllegalStateException("com.didi.hawaii.mapsdkv2.HWMapView is not a view nor a MapOpenGL!");
            }
            addView((View) newInstance, new FrameLayout.LayoutParams(-1, -1));
            this.f30331k = (MapOpenGL) newInstance;
            if (m23536a()) {
                try {
                    getContext().registerReceiver(this.f30330j, new IntentFilter(f30325h));
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
                this.f30329i = true;
                this.f30331k.setOnMapReadyCallback(new OnMapReadyCallback() {
                    public void onMapReady(DidiMap didiMap) {
                        DidiMap unused = MapView.this.f30326a = didiMap;
                        MapDebugView unused2 = MapView.this.f30328g = new MapDebugView(context);
                        MapView.this.f30328g.init(didiMap, MapView.this);
                    }
                });
            }
            setAccessibilityDelegate(context);
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException(e2);
        } catch (NoSuchMethodException e3) {
            throw new IllegalStateException(e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        } catch (InvocationTargetException e6) {
            throw new IllegalStateException(e6);
        }
    }

    public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
        MapOpenGL mapOpenGL = this.f30331k;
        if (mapOpenGL != null) {
            mapOpenGL.setOnMapReadyCallback(new OnMapReadyCallback() {
                public void onMapReady(DidiMap didiMap) {
                    DidiMap unused = MapView.this.f30326a = didiMap;
                    onMapReadyCallback.onMapReady(didiMap);
                }
            });
        }
    }

    private void setAccessibilityDelegate(Context context) {
        if (MapApolloHawaii.isTalkbackOpen() && AccessibilityUtils.isAccessibilityTackbackEnable(context) && this.f30332l == null) {
            HawaiiTouchHelper hawaiiTouchHelper = new HawaiiTouchHelper(this);
            this.f30332l = hawaiiTouchHelper;
            ViewCompat.setAccessibilityDelegate(this, hawaiiTouchHelper);
        }
    }

    public final DidiMap getMap() {
        return this.f30326a;
    }

    public void onStart() {
        DidiMap didiMap = this.f30326a;
        if (didiMap != null) {
            didiMap.onStart();
        }
    }

    public void onStop() {
        DidiMap didiMap = this.f30326a;
        if (didiMap != null) {
            didiMap.onStop();
        }
        MapDebugView mapDebugView = this.f30328g;
        if (mapDebugView != null) {
            mapDebugView.onStop();
        }
    }

    public void onDestroy() {
        MapOpenGL mapOpenGL = this.f30331k;
        if (mapOpenGL != null) {
            mapOpenGL.onDestroy();
            this.f30331k = null;
        }
        HWLog.m20433i("hawaii-map", "MapView onDestroy");
        MapDebugView mapDebugView = this.f30328g;
        if (mapDebugView != null) {
            mapDebugView.onDestroy();
        }
        if (this.f30329i) {
            try {
                getContext().unregisterReceiver(this.f30330j);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f30329i = false;
        }
    }

    public void onResume() {
        MapOpenGL mapOpenGL = this.f30331k;
        if (mapOpenGL != null) {
            mapOpenGL.onResume();
        }
        MapDebugView mapDebugView = this.f30328g;
        if (mapDebugView != null) {
            mapDebugView.onResume();
        }
    }

    public void onPause() {
        MapOpenGL mapOpenGL = this.f30331k;
        if (mapOpenGL != null) {
            mapOpenGL.onPause();
        }
    }

    public void onRestart() {
        DidiMap didiMap = this.f30326a;
        if (didiMap != null) {
            didiMap.onRestart();
        }
    }

    public void setOnTop(boolean z) {
        DidiMap didiMap = this.f30326a;
        if (didiMap != null) {
            didiMap.setOnTop(z);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.f30331k != null) {
            HWLog.m20433i("hawaii-map", "MapView setVisibility:" + i);
            this.f30331k.setVisibility(i);
            if (i == 8 || i == 4) {
                this.f30331k.onPause();
            } else {
                this.f30331k.onResume();
            }
        }
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        setPadding(i, i2, i3, i4);
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    public void showLogoForInternationalWms(int i) {
        Bitmap bitmap;
        Context context = getContext();
        if (i == -1) {
            ImageView imageView = this.f30327b;
            if (imageView != null) {
                removeView(imageView);
                this.f30327b = null;
                return;
            }
            return;
        }
        if (this.f30327b == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            layoutParams.bottomMargin = 15;
            layoutParams.leftMargin = 15;
            ImageView imageView2 = new ImageView(context);
            this.f30327b = imageView2;
            imageView2.setBackgroundColor(0);
            addView(this.f30327b, layoutParams);
        }
        if (i == 0) {
            bitmap = MapUtil.getBitmapFromAsset(context, "hawaii_wms_google.png");
        } else {
            bitmap = MapUtil.getBitmapFromAsset(context, "hawaii_wms_bing.png");
        }
        this.f30327b.setImageBitmap(bitmap);
    }

    public class HawaiiTouchHelper extends ExploreByTouchHelper {
        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            return false;
        }

        public HawaiiTouchHelper(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public synchronized int getVirtualViewAt(float f, float f2) {
            if (MapView.this.f30326a == null || MapView.this.f30326a.getAccessManager() == null) {
                return Integer.MIN_VALUE;
            }
            return MapView.this.f30326a.getAccessManager().getVirtualViewAt(f, f2);
        }

        /* access modifiers changed from: protected */
        public synchronized void getVisibleVirtualViews(List<Integer> list) {
            if (!(MapView.this.f30326a == null || MapView.this.f30326a.getAccessManager() == null)) {
                MapView.this.f30326a.getAccessManager().getVisibleVirtualViews(list);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!(MapView.this.f30326a == null || MapView.this.f30326a.getAccessManager() == null)) {
                MapView.this.f30326a.getAccessManager().onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            if (!(MapView.this.f30326a == null || MapView.this.f30326a.getAccessManager() == null)) {
                MapView.this.f30326a.getAccessManager().onPopulateEventForVirtualView(i, accessibilityEvent);
            }
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        HawaiiTouchHelper hawaiiTouchHelper;
        if (motionEvent.getAction() == 9 && (hawaiiTouchHelper = this.f30332l) != null) {
            int virtualViewAt = hawaiiTouchHelper.getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            if (virtualViewAt != Integer.MIN_VALUE) {
                this.f30332l.getAccessibilityNodeProvider(this).performAction(this.f30332l.getVirtualViewAt(motionEvent.getX(), motionEvent.getY()), 64, (Bundle) null);
            }
            this.f30332l.dispatchHoverEvent(motionEvent);
            if (virtualViewAt != Integer.MIN_VALUE) {
                this.f30332l.getAccessibilityNodeProvider(this).performAction(this.f30332l.getVirtualViewAt(motionEvent.getX(), motionEvent.getY()), 128, (Bundle) null);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m23536a() {
        return (getContext().getApplicationInfo().flags & 2) != 0;
    }
}
