package com.didi.map.outer.model;

import android.graphics.Rect;
import com.didi.map.alpha.maps.internal.ICollisionGroupDelegate;
import java.util.List;

public class CollisionGroup {
    private final ICollisionGroupDelegate control;

    /* renamed from: id */
    private final String f30377id;
    private final CollisionGroupOption option;

    public CollisionGroup(CollisionGroupOption collisionGroupOption, ICollisionGroupDelegate iCollisionGroupDelegate, String str) {
        this.control = iCollisionGroupDelegate;
        this.f30377id = str;
        this.option = collisionGroupOption;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.control.setCollisonGroupPadding(this.f30377id, new Rect(i, i2, i3, i4));
    }

    public void setPadding(Rect rect) {
        this.control.setCollisonGroupPadding(this.f30377id, rect);
    }

    public void addRoute4Collision(List<LatLng> list) {
        this.control.addRoute4Collision(this.f30377id, list);
    }

    public void clearRoute4Collision() {
        this.control.clearRoute4Collision(this.f30377id);
    }

    public void remove() {
        this.control.removeCollisionGroup(this.f30377id);
    }

    public CollisionMarker addCollisionOverlay(CollisionMarkerOption collisionMarkerOption) {
        return this.control.addCollisionOverlay(this.f30377id, collisionMarkerOption);
    }

    public CollisionStub addVirtualCollsionStub(CollisionStubOption collisionStubOption) {
        return this.control.addVirtualCollsionStub(this.f30377id, collisionStubOption);
    }

    public void removeCollisionOverlay(String str) {
        this.control.removeCollisionOverlay(this.f30377id, str);
    }

    public void clearCollisionOverlay() {
        this.control.clearCollisionOverlay(this.f30377id);
    }

    public void requestCollision() {
        this.control.requestCollision(this.f30377id);
    }

    public void setVisible(boolean z) {
        this.control.setGroupVisible(this.f30377id, z);
    }
}
