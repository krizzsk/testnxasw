package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;

public class NonHierarchicalViewBasedAlgorithm<T extends ClusterItem> extends NonHierarchicalDistanceBasedAlgorithm<T> implements ScreenBasedAlgorithm<T> {
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private LatLng mMapCenter;
    private int mViewHeight;
    private int mViewWidth;

    public boolean shouldReclusterOnMapMovement() {
        return true;
    }

    public NonHierarchicalViewBasedAlgorithm(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        this.mMapCenter = cameraPosition.target;
    }

    /* access modifiers changed from: protected */
    public Collection<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> getClusteringItems(PointQuadTree<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> pointQuadTree, float f) {
        PointQuadTree<NonHierarchicalDistanceBasedAlgorithm.QuadItem<T>> pointQuadTree2 = pointQuadTree;
        Bounds visibleBounds = getVisibleBounds(f);
        ArrayList arrayList = new ArrayList();
        if (visibleBounds.minX < 0.0d) {
            arrayList.addAll(pointQuadTree2.search(new Bounds(visibleBounds.minX + 1.0d, 1.0d, visibleBounds.minY, visibleBounds.maxY)));
            visibleBounds = new Bounds(0.0d, visibleBounds.maxX, visibleBounds.minY, visibleBounds.maxY);
        }
        if (visibleBounds.maxX > 1.0d) {
            arrayList.addAll(pointQuadTree2.search(new Bounds(0.0d, visibleBounds.maxX - 1.0d, visibleBounds.minY, visibleBounds.maxY)));
            visibleBounds = new Bounds(visibleBounds.minX, 1.0d, visibleBounds.minY, visibleBounds.maxY);
        }
        arrayList.addAll(pointQuadTree2.search(visibleBounds));
        return arrayList;
    }

    public void updateViewSize(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
    }

    private Bounds getVisibleBounds(float f) {
        LatLng latLng = this.mMapCenter;
        if (latLng == null) {
            return new Bounds(0.0d, 0.0d, 0.0d, 0.0d);
        }
        Point point = PROJECTION.toPoint(latLng);
        double d = (double) f;
        double pow = ((((double) this.mViewWidth) / Math.pow(2.0d, d)) / 256.0d) / 2.0d;
        double pow2 = ((((double) this.mViewHeight) / Math.pow(2.0d, d)) / 256.0d) / 2.0d;
        return new Bounds(point.f55226x - pow, point.f55226x + pow, point.f55227y - pow2, point.f55227y + pow2);
    }
}
