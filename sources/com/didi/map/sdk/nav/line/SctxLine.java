package com.didi.map.sdk.nav.line;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Deprecated
public final class SctxLine {

    /* renamed from: a */
    private Map f30935a;

    /* renamed from: b */
    private String f30936b;

    /* renamed from: c */
    private LineOptions f30937c;

    /* renamed from: d */
    private List<LatLng> f30938d;

    /* renamed from: e */
    private List<LatLng> f30939e;

    /* renamed from: f */
    private List<LatLng> f30940f;

    /* renamed from: g */
    private Line f30941g;

    /* renamed from: h */
    private Line f30942h;

    public SctxLine(Map map, LineOptions lineOptions, int i) {
        this(map, (String) null, lineOptions, i);
    }

    public SctxLine(Map map, String str, LineOptions lineOptions, int i) {
        this.f30938d = new ArrayList();
        this.f30939e = new ArrayList();
        this.f30940f = new ArrayList();
        this.f30935a = map;
        this.f30936b = str;
        this.f30937c = lineOptions;
        if (lineOptions.getPoints() != null) {
            this.f30938d.addAll(lineOptions.getPoints());
        }
        m23748a(i);
    }

    public void updateNewLine(List<LatLng> list, int i) {
        this.f30938d.clear();
        if (list != null) {
            this.f30938d.addAll(list);
        }
        m23748a(i);
    }

    /* renamed from: a */
    private void m23748a(int i) {
        int i2;
        if (i <= this.f30938d.size() - 2 && i >= 0) {
            this.f30939e.clear();
            this.f30940f.clear();
            int i3 = 0;
            while (true) {
                i2 = i + 1;
                if (i3 > i2) {
                    break;
                }
                this.f30939e.add(this.f30938d.get(i3));
                i3++;
            }
            this.f30940f.add(new LatLng(this.f30938d.get(i2).latitude, this.f30938d.get(i2).longitude));
            for (int i4 = i + 2; i4 < this.f30938d.size(); i4++) {
                this.f30940f.add(this.f30938d.get(i4));
            }
            Line line = this.f30941g;
            if (line == null) {
                this.f30941g = this.f30935a.addLine(this.f30936b, new LineOptions().color(this.f30937c.getColor()).width(this.f30937c.getWidth()).setPoints(this.f30939e));
            } else {
                line.setPoints(this.f30939e);
            }
            Line line2 = this.f30942h;
            if (line2 == null) {
                this.f30942h = this.f30935a.addLine(this.f30936b, new LineOptions().color(this.f30937c.getColor()).width(this.f30937c.getWidth()).setPoints(this.f30940f));
            } else {
                line2.setPoints(this.f30940f);
            }
        }
    }

    public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
        if (list != null) {
            this.f30939e.clear();
            this.f30939e.addAll(list);
            Line line = this.f30941g;
            if (line != null) {
                line.setPoints(this.f30939e);
            }
        }
        if (list2 != null) {
            this.f30940f.clear();
            this.f30940f.addAll(list2);
            Line line2 = this.f30942h;
            if (line2 != null) {
                line2.setPoints(this.f30940f);
            }
        }
    }

    public void onErase(List<LatLng> list) {
        if (list == null) {
            return;
        }
        if (list.size() <= 0 || this.f30939e.size() <= 0 || !list.get(0).equals(this.f30939e.get(0))) {
            this.f30939e.clear();
            this.f30939e.addAll(list);
            Line line = this.f30941g;
            if (line != null) {
                line.setPoints(this.f30939e);
            }
        }
    }

    @Deprecated
    public void onRecvNextDriverMatchIndex(List<LatLng> list, int i) {
        if (this.f30941g != null && this.f30942h != null && list != null && list.size() >= 1 && i <= list.size() - 2 && i >= 0) {
            int i2 = i + 1;
            this.f30939e.clear();
            for (int i3 = 0; i3 <= i2; i3++) {
                this.f30939e.add(list.get(i3));
            }
            this.f30941g.setPoints(this.f30939e);
            this.f30940f.clear();
            while (i2 < list.size()) {
                this.f30940f.add(list.get(i2));
                i2++;
            }
            this.f30942h.setPoints(this.f30940f);
        }
    }

    @Deprecated
    public void onFirstLinePointsUpdated(List<LatLng> list) {
        Line line = this.f30941g;
        if (line != null) {
            line.setPoints(list);
        }
    }

    public List<LatLng> getCurrLinePoints() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f30939e);
        arrayList.addAll(this.f30940f);
        return arrayList;
    }

    public void remove() {
        this.f30935a.remove(this.f30941g);
        this.f30935a.remove(this.f30942h);
    }

    /* renamed from: a */
    private String m23747a(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(m23746a("(%d)[%f,%f]", Integer.valueOf(i), Double.valueOf(list.get(i).longitude), Double.valueOf(list.get(i).latitude)));
            if (i < list.size() - 1) {
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m23746a(String str, Object... objArr) {
        return String.format(Locale.CHINA, str, objArr);
    }
}
