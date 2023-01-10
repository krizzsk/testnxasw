package com.dmap.navigation.engine.event;

import com.dmap.navigation.engine.core.camera.INaviCamera;
import com.dmap.navigation.engine.simple.SimpleNaviCamera;
import com.dmap.navigation.jni.swig.NaviCameraList;
import java.util.ArrayList;
import java.util.List;

public class CameraEvent extends NaviEvent {

    /* renamed from: a */
    private final int f54400a;

    /* renamed from: b */
    private final List<INaviCamera> f54401b;

    /* renamed from: c */
    private final int f54402c;

    public CameraEvent(int i, NaviCameraList naviCameraList, int i2) {
        this.f54400a = i;
        int size = (int) naviCameraList.size();
        if (size > 0) {
            this.f54401b = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.f54401b.add(new SimpleNaviCamera(naviCameraList.get(i3)));
            }
        } else {
            this.f54401b = null;
        }
        this.f54402c = i2;
    }

    public String toString() {
        return "CameraEvent{updateType=" + this.f54400a + ", cameras=" + this.f54401b + ", style=" + this.f54402c + '}';
    }

    public int getUpdateType() {
        return this.f54400a;
    }

    public List<INaviCamera> getCameras() {
        return this.f54401b;
    }

    public int getStyle() {
        return this.f54402c;
    }
}
