package com.didi.map.global.component.line.excomponent;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

public class GuideLine implements IBaseComponent<GuideLineParam> {

    /* renamed from: a */
    private Context f28102a;

    /* renamed from: b */
    private Map f28103b;

    /* renamed from: c */
    private GuideLineParam f28104c;

    /* renamed from: d */
    private ICompLineContract f28105d;

    /* renamed from: e */
    private boolean f28106e = true;

    /* renamed from: f */
    private LatLng f28107f;

    /* renamed from: g */
    private LatLng f28108g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28102a = context;
        this.f28103b = map;
        GuideLineParam guideLineParam = this.f28104c;
        if (guideLineParam != null) {
            this.f28107f = guideLineParam.f28113e;
            this.f28108g = this.f28104c.f28114f;
            m22091b();
        }
    }

    public void destroy() {
        m22090a();
        this.f28102a = null;
        this.f28103b = null;
        this.f28104c = null;
        this.f28107f = null;
        this.f28108g = null;
    }

    public void setConfigParam(GuideLineParam guideLineParam) {
        this.f28104c = guideLineParam;
    }

    /* renamed from: a */
    private void m22090a() {
        ICompLineContract iCompLineContract = this.f28105d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f28105d = null;
        }
    }

    /* renamed from: b */
    private void m22091b() {
        if (this.f28103b != null && this.f28102a != null && this.f28104c != null && LatLngUtils.locateCorrect(this.f28107f) && LatLngUtils.locateCorrect(this.f28108g)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28107f);
            arrayList.add(this.f28108g);
            ICompLineContract iCompLineContract = this.f28105d;
            if (iCompLineContract == null) {
                LineParams lineParams = new LineParams(arrayList, this.f28104c.f28109a != 0 ? this.f28104c.f28109a : Color.parseColor("#279CFD"), this.f28104c.f28112d != 0 ? this.f28104c.f28112d : 4);
                lineParams.setDotSpace(this.f28104c.f28111c != 0.0f ? this.f28104c.f28111c : 5.0f);
                lineParams.setDottedIconRes(this.f28104c.f28110b);
                ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f28103b, this.f28102a, lineParams);
                this.f28105d = createLineComponent;
                if (this.f28106e && createLineComponent != null) {
                    createLineComponent.start();
                }
            } else if (this.f28106e && iCompLineContract != null) {
                iCompLineContract.updateLinePoints(arrayList);
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f28105d;
        if (iCompLineContract != null) {
            return iCompLineContract.getBestViewElements();
        }
        return null;
    }

    public void updateStartPosition(LatLng latLng) {
        if (LatLngUtils.locateCorrect(latLng) && !LatLngUtils.isCompletedSameLatLng(latLng, this.f28107f)) {
            this.f28107f = latLng;
            m22091b();
        }
    }

    public void updateEndPosition(LatLng latLng) {
        if (LatLngUtils.locateCorrect(latLng) && !LatLngUtils.isCompletedSameLatLng(latLng, this.f28108g)) {
            this.f28108g = latLng;
            m22091b();
        }
    }

    public void setVisible(boolean z) {
        this.f28106e = z;
        ICompLineContract iCompLineContract = this.f28105d;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    public boolean isVisible() {
        return this.f28106e;
    }
}
