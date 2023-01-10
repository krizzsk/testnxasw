package com.didi.map.outer.model;

import java.util.ArrayList;
import java.util.List;

public class HeatOverlayOptions {
    public static final int DEFAULT_RADIUS = 18;

    /* renamed from: a */
    private ArrayList<HeatDataNode> f30387a;

    /* renamed from: b */
    private OnHeatMapReadyListener f30388b;

    /* renamed from: c */
    private IColorMapper f30389c;

    /* renamed from: d */
    private int f30390d = 18;

    /* renamed from: e */
    private HeatTileGenerator f30391e;

    public interface HeatTileGenerator {
        float[] generateFadeOutMatrix(int i);

        int[] generateHeatTile(List<HeatNode> list, float[] fArr, int i, int i2, IColorMapper iColorMapper);
    }

    public interface IColorMapper {
        int colorForValue(double d);
    }

    public interface OnHeatMapReadyListener {
        void onHeatMapReady();
    }

    public HeatOverlayOptions nodes(List<HeatDataNode> list) {
        ArrayList<HeatDataNode> arrayList = new ArrayList<>();
        this.f30387a = arrayList;
        arrayList.addAll(list);
        return this;
    }

    public HeatOverlayOptions colorMapper(IColorMapper iColorMapper) {
        this.f30389c = iColorMapper;
        return this;
    }

    public HeatOverlayOptions onHeatMapReadyListener(OnHeatMapReadyListener onHeatMapReadyListener) {
        this.f30388b = onHeatMapReadyListener;
        return this;
    }

    public HeatOverlayOptions radius(int i) {
        this.f30390d = i;
        return this;
    }

    public List<HeatDataNode> getNodes() {
        return this.f30387a;
    }

    public OnHeatMapReadyListener getOnHeatMapReadyListener() {
        return this.f30388b;
    }

    public int getRadius() {
        return this.f30390d;
    }

    public IColorMapper getColorMapper() {
        return this.f30389c;
    }

    public HeatOverlayOptions heatTileGenerator(HeatTileGenerator heatTileGenerator) {
        this.f30391e = heatTileGenerator;
        return this;
    }

    public HeatTileGenerator getHeatTileGenerator() {
        return this.f30391e;
    }
}
