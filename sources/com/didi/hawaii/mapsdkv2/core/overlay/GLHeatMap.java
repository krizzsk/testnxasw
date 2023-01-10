package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Bitmap;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLTile;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.common.utils.MathBaseUtil;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.HeatNode;
import com.didi.map.outer.model.HeatOverlayOptions;
import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GLHeatMap extends GLTile {

    /* renamed from: a */
    private static final int f26345a = 256;

    /* renamed from: b */
    private static final int f26346b = 1;

    /* renamed from: c */
    private HeatMapRTreeNodes f26347c;

    /* renamed from: d */
    private int f26348d;

    /* renamed from: e */
    private List<HeatDataNode> f26349e;

    /* renamed from: f */
    private HeatOverlayOptions.HeatTileGenerator f26350f;

    /* renamed from: g */
    private HeatOverlayOptions.IColorMapper f26351g;

    public static final class HeatMapRTreeNodes {
        public List<HeatMapNode> queryNode(DoublePoint doublePoint, DoublePoint doublePoint2, double d) {
            return null;
        }

        public void setData(List<HeatDataNode> list) {
        }
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public GLHeatMap(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26348d = option.radius;
        this.f26349e = option.heatNodes;
        this.f26350f = option.heatTileGenerator;
        this.f26351g = option.colorMapper;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        if (this.mDisplayId == -1) {
            this.mDisplayId = this.mMapCanvas.addTile(this);
            return;
        }
        this.mMapCanvas.removeTile(this.mDisplayId);
        this.mDisplayId = this.mMapCanvas.addTile(this);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        this.mMapCanvas.removeTile(this.mDisplayId);
        this.mDisplayId = -1;
        synchronized (this) {
            this.f26347c = null;
        }
    }

    public void reloadHeatMap(List<HeatDataNode> list) {
        this.f26349e = list;
        synchronized (this) {
            this.f26347c = null;
        }
        getParent().postToRenderThread((RenderTask) new RenderTask() {
            public void run() {
                GLHeatMap.this.mMapCanvas.reloadTile(GLHeatMap.this.mDisplayId);
            }
        });
    }

    public Bitmap onLoadTile(int i, int i2, int i3) {
        Bitmap a;
        synchronized (this) {
            if (this.f26347c == null) {
                HeatMapRTreeNodes heatMapRTreeNodes = new HeatMapRTreeNodes();
                this.f26347c = heatMapRTreeNodes;
                heatMapRTreeNodes.setData(this.f26349e);
            }
            a = m20809a(MathsUtils.getScale((double) i3), new HeatMapTile(i, ((((int) ((double) ((1 << i3) * 256))) / 256) - i2) - 1, i3));
        }
        return a;
    }

    public static final class Option extends GLTile.Option {
        /* access modifiers changed from: private */
        public HeatOverlayOptions.IColorMapper colorMapper;
        /* access modifiers changed from: private */
        public List<HeatDataNode> heatNodes;
        /* access modifiers changed from: private */
        public HeatOverlayOptions.HeatTileGenerator heatTileGenerator;
        /* access modifiers changed from: private */
        public int radius;

        public HeatOverlayOptions.HeatTileGenerator getHeatTileGenerator() {
            return this.heatTileGenerator;
        }

        public void setHeatTileGenerator(HeatOverlayOptions.HeatTileGenerator heatTileGenerator2) {
            this.heatTileGenerator = heatTileGenerator2;
        }

        public HeatOverlayOptions.IColorMapper getColorMapper() {
            return this.colorMapper;
        }

        public void setColorMapper(HeatOverlayOptions.IColorMapper iColorMapper) {
            this.colorMapper = iColorMapper;
        }

        public int getRadius() {
            return this.radius;
        }

        public void setRadius(int i) {
            this.radius = i;
        }

        public List<HeatDataNode> getHeatNodes() {
            return this.heatNodes;
        }

        public void setHeatNodes(List<HeatDataNode> list) {
            this.heatNodes = list;
        }
    }

    public static final class HeatDataNode {
        private LatLng point;
        private double value;

        public HeatDataNode(LatLng latLng, double d) {
            this.point = latLng;
            this.value = d;
        }

        public double getValue() {
            return this.value;
        }

        public void setValue(double d) {
            this.value = d;
        }

        public LatLng getPoint() {
            return this.point;
        }

        public void setPoint(LatLng latLng) {
            this.point = latLng;
        }
    }

    /* renamed from: a */
    private float[] m20810a() {
        int i = this.f26348d;
        float[] fArr = new float[(i * 2 * 2 * i)];
        for (int i2 = 0; i2 < this.f26348d * 2; i2++) {
            int i3 = 0;
            while (true) {
                int i4 = this.f26348d;
                if (i3 >= i4 * 2) {
                    break;
                }
                float sqrt = (float) Math.sqrt((double) (((i2 - i4) * (i2 - i4)) + ((i3 - i4) * (i3 - i4))));
                float f = 0.0f;
                if (1.0f - (sqrt / ((float) this.f26348d)) >= 0.0f) {
                    f = (float) ((Math.exp(((double) (-sqrt)) / 10.0d) - Math.exp(((double) (-this.f26348d)) / 10.0d)) / Math.exp(0.0d));
                }
                fArr[(i3 * 2 * this.f26348d) + i2] = f;
                i3++;
            }
        }
        return fArr;
    }

    /* renamed from: a */
    private Bitmap m20809a(double d, HeatMapTile heatMapTile) {
        float[] fArr;
        int[] iArr;
        double d2 = d;
        HeatMapTile heatMapTile2 = heatMapTile;
        HeatOverlayOptions.HeatTileGenerator heatTileGenerator = this.f26350f;
        if (heatTileGenerator == null) {
            fArr = m20810a();
        } else {
            fArr = heatTileGenerator.generateFadeOutMatrix(this.f26348d);
        }
        float[] fArr2 = fArr;
        DoublePoint leftTop = heatMapTile2.getLeftTop(d2);
        DoublePoint rightBottom = heatMapTile2.getRightBottom(d2);
        double pow = 1.0d / Math.pow(2.0d, (double) (22 - heatMapTile.getZ()));
        List<HeatMapNode> queryNode = this.f26347c.queryNode(new DoublePoint(leftTop.f27004x - (((double) this.f26348d) / pow), leftTop.f27005y + (((double) this.f26348d) / pow)), new DoublePoint(rightBottom.f27004x + (((double) this.f26348d) / pow), rightBottom.f27005y - (((double) this.f26348d) / pow)), pow);
        ArrayList arrayList = new ArrayList();
        Iterator<HeatMapNode> it = queryNode.iterator();
        while (it.hasNext()) {
            HeatMapNode next = it.next();
            DoublePoint point = next.getPoint();
            double value = next.getValue();
            double d3 = point.f27004x - leftTop.f27004x;
            Iterator<HeatMapNode> it2 = it;
            double d4 = leftTop.f27005y - point.f27005y;
            double scaleFrom20 = MathBaseUtil.getScaleFrom20(heatMapTile.getZ());
            arrayList.add(new HeatNode(d3 * scaleFrom20, d4 * scaleFrom20, value));
            it = it2;
        }
        HeatOverlayOptions.HeatTileGenerator heatTileGenerator2 = this.f26350f;
        if (heatTileGenerator2 == null) {
            iArr = m20811a(arrayList, fArr2, (float) this.f26348d, 256);
        } else {
            iArr = heatTileGenerator2.generateHeatTile(arrayList, fArr2, this.f26348d, 256, this.f26351g);
        }
        try {
            return Bitmap.createBitmap(iArr, 256, 256, Bitmap.Config.ARGB_8888);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private int[] m20811a(List<HeatNode> list, float[] fArr, float f, int i) {
        float f2 = f;
        int i2 = i;
        int i3 = i2 * i2;
        float[] fArr2 = new float[i3];
        int[] iArr = new int[i3];
        if (list == null || list.isEmpty()) {
            return iArr;
        }
        Iterator<HeatNode> it = list.iterator();
        while (it.hasNext()) {
            HeatNode next = it.next();
            double value = next.getValue();
            double x = next.getX();
            double y = next.getY();
            if (value > 0.0d) {
                int i4 = 0;
                while (true) {
                    float f3 = 2.0f * f2;
                    if (((float) i4) >= f3) {
                        break;
                    }
                    int i5 = 0;
                    while (((float) i5) < f3) {
                        int[] iArr2 = iArr;
                        Iterator<HeatNode> it2 = it;
                        double d = (double) f2;
                        double d2 = x;
                        int i6 = (int) ((x - d) + ((double) i4));
                        double d3 = y;
                        int i7 = (int) ((y - d) + ((double) i5));
                        if (i7 >= 0 && i6 >= 0 && i7 < i2 && i6 < i2) {
                            int i8 = (i7 * i2) + i6;
                            fArr2[i8] = (float) (((double) fArr2[i8]) + (((double) fArr[(i5 * 2 * ((int) f2)) + i4]) * value));
                        }
                        i5++;
                        iArr = iArr2;
                        it = it2;
                        y = d3;
                        x = d2;
                    }
                    int[] iArr3 = iArr;
                    Iterator<HeatNode> it3 = it;
                    double d4 = x;
                    double d5 = y;
                    i4++;
                }
            }
            iArr = iArr;
            it = it;
        }
        int[] iArr4 = iArr;
        for (int i9 = 0; i9 < i3; i9++) {
            if (fArr2[i9] > 0.0f) {
                iArr4[i9] = MathBaseUtil.colorForValue((double) fArr2[i9]);
            }
        }
        return iArr4;
    }

    public static final class HeatMapTile {
        private DoublePoint tileLeftTopPixel;
        private DoublePoint tileRightBottomPixel;

        /* renamed from: x */
        private int f26352x;

        /* renamed from: y */
        private int f26353y;

        /* renamed from: z */
        private int f26354z;

        public int getX() {
            return this.f26352x;
        }

        public void setX(int i) {
            this.f26352x = i;
        }

        public int getY() {
            return this.f26353y;
        }

        public void setY(int i) {
            this.f26353y = i;
        }

        public int getZ() {
            return this.f26354z;
        }

        public void setZ(int i) {
            this.f26354z = i;
        }

        public HeatMapTile(int i, int i2, int i3) {
            this.f26352x = i;
            this.f26353y = i2;
            this.f26354z = i3;
            this.tileLeftTopPixel = new DoublePoint((double) (i * 256), (double) ((i2 + 1) * 256));
            this.tileRightBottomPixel = new DoublePoint((double) ((i + 1) * 256), (double) (i2 * 256));
        }

        public DoublePoint getTileLeftTopPixel() {
            return this.tileLeftTopPixel;
        }

        public DoublePoint getTileRightBottomPixel() {
            return this.tileRightBottomPixel;
        }

        public DoublePoint getLeftTop(double d) {
            DoublePoint doublePoint = new DoublePoint();
            doublePoint.f27004x = this.tileLeftTopPixel.f27004x / d;
            doublePoint.f27005y = this.tileLeftTopPixel.f27005y / d;
            return doublePoint;
        }

        public DoublePoint getRightBottom(double d) {
            DoublePoint doublePoint = new DoublePoint();
            doublePoint.f27004x = this.tileRightBottomPixel.f27004x / d;
            doublePoint.f27005y = this.tileRightBottomPixel.f27005y / d;
            return doublePoint;
        }
    }

    public static final class HeatMapNode {
        private GeoPoint geoPoint;
        private DoublePoint point;
        private double value;

        public HeatMapNode(DoublePoint doublePoint, double d) {
            this.point = doublePoint;
            this.value = d;
        }

        public HeatMapNode(GeoPoint geoPoint2, double d) {
            this.geoPoint = geoPoint2;
            this.value = d;
        }

        public DoublePoint getPoint() {
            return this.point;
        }

        public void setPoint(DoublePoint doublePoint) {
            this.point = doublePoint;
        }

        public double getValue() {
            return this.value;
        }

        public void setValue(double d) {
            this.value = d;
        }

        public GeoPoint getGeoPoint() {
            return this.geoPoint;
        }

        public void setGeoPoint(GeoPoint geoPoint2) {
            this.geoPoint = geoPoint2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
            r2 = (r2 = (com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap.HeatMapNode) r2).point;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r2 instanceof com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap.HeatMapNode
                if (r0 == 0) goto L_0x0016
                com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap$HeatMapNode r2 = (com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap.HeatMapNode) r2
                if (r2 == 0) goto L_0x0016
                com.didi.map.core.point.DoublePoint r2 = r2.point
                if (r2 == 0) goto L_0x0016
                com.didi.map.core.point.DoublePoint r0 = r1.point
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L_0x0016
                r2 = 1
                return r2
            L_0x0016:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap.HeatMapNode.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return this.point.hashCode();
        }

        public String toString() {
            return "x:" + this.point.f27004x + ", y:" + this.point.f27005y;
        }
    }
}
