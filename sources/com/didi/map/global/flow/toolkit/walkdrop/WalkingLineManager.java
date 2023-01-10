package com.didi.map.global.flow.toolkit.walkdrop;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.departure.apolllo.WalkDropApollo;
import com.didi.map.global.component.line.pax.walkanddropoff.IWalkAndDropOffLine;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkAndDropOffLineImpl;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkDropOffParam;
import com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent;
import com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkParam;
import com.didi.map.sdk.env.PaxEnvironment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalkingLineManager {

    /* renamed from: a */
    private static final String f29776a = "WalkingLineManager";

    /* renamed from: b */
    private IWalkAndDropOffLine f29777b;

    /* renamed from: c */
    private NewWalkLineComponent f29778c;

    /* renamed from: d */
    private Context f29779d;

    /* renamed from: e */
    private Map f29780e;

    /* renamed from: f */
    private WalkParam f29781f;

    public WalkingLineManager(Context context, Map map, WalkParam walkParam) {
        if (walkParam != null) {
            if (TextUtils.equals(DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT, walkParam.getSrcTag())) {
                DLog.m10773d(f29776a, "srcTag是场站围栏", new Object[0]);
            } else if (context == null || map == null) {
                DLog.m10773d(f29776a, "param error", new Object[0]);
            } else {
                this.f29779d = context;
                this.f29780e = map;
                this.f29781f = walkParam;
                m23078a();
            }
        }
    }

    /* renamed from: a */
    private void m23078a() {
        WalkParam walkParam = this.f29781f;
        if (walkParam != null) {
            if (WalkComponentApolloUtils.isUseNewComponent(this.f29779d, walkParam.getEndPoint())) {
                DLog.m10773d(f29776a, "new WalkLine", new Object[0]);
                m23080c();
            } else if (WalkDropApollo.Companion.getWalkline_enable()) {
                DLog.m10773d(f29776a, "old WalkLine", new Object[0]);
                m23079b();
            } else {
                DLog.m10773d(f29776a, "WalkDropApollo false", new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateWalkingLine(com.didi.common.map.model.LatLng r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = com.didi.common.map.util.LatLngUtils.locateCorrect(r3)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0013
            java.lang.String r3 = "WalkingLineManager"
            java.lang.String r0 = "updateWalkingLine:return ,startPoint= null"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002b }
            com.didi.common.map.util.DLog.m10773d(r3, r0, r1)     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x0013:
            com.didi.map.global.component.line.pax.walkanddropoff.IWalkAndDropOffLine r0 = r2.f29777b     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0020
            com.didi.map.global.component.line.pax.walkanddropoff.IWalkAndDropOffLine r0 = r2.f29777b     // Catch:{ all -> 0x002b }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = com.didi.map.global.component.line.utils.LineDataConverter.latConvertToDoublePoint(r3)     // Catch:{ all -> 0x002b }
            r0.updateLines(r1)     // Catch:{ all -> 0x002b }
        L_0x0020:
            com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent r0 = r2.f29778c     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0029
            com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent r0 = r2.f29778c     // Catch:{ all -> 0x002b }
            r0.updateStartPoint(r3)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.toolkit.walkdrop.WalkingLineManager.updateWalkingLine(com.didi.common.map.model.LatLng):void");
    }

    public void destroy() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f29777b;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.destroy();
            this.f29777b = null;
        }
        NewWalkLineComponent newWalkLineComponent = this.f29778c;
        if (newWalkLineComponent != null) {
            newWalkLineComponent.destroy();
            this.f29778c = null;
        }
    }

    public void setVisible(boolean z) {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f29777b;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.setVisible(z);
        }
    }

    public List<IMapElement> getWalkLine() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f29777b;
        if (iWalkAndDropOffLine != null) {
            return iWalkAndDropOffLine.getWalkLine();
        }
        return null;
    }

    /* renamed from: b */
    private void m23079b() {
        if (this.f29781f != null) {
            try {
                this.f29777b = new WalkAndDropOffLineImpl();
                WalkDropOffParam walkDropOffParam = new WalkDropOffParam();
                walkDropOffParam.setCallFrom(this.f29781f.getCallFromm());
                walkDropOffParam.setAnimate(this.f29781f.isAnimate());
                walkDropOffParam.setCountryId(PaxEnvironment.getInstance().getCountryCode());
                String uid = PaxEnvironment.getInstance().getUid();
                if (!TextUtils.isEmpty(uid)) {
                    walkDropOffParam.setPassengerId(Long.parseLong(uid));
                }
                walkDropOffParam.setPhoneNum(PaxEnvironment.getInstance().getPhoneNumber());
                if (TextUtils.isEmpty(this.f29781f.getProductId())) {
                    walkDropOffParam.setProductId(PaxEnvironment.getInstance().getProductId());
                } else {
                    walkDropOffParam.setProductId(this.f29781f.getProductId());
                }
                walkDropOffParam.setToken(PaxEnvironment.getInstance().getToken());
                if (!TextUtils.isEmpty(this.f29781f.getOrderId())) {
                    walkDropOffParam.setOrderId(this.f29781f.getOrderId());
                }
                walkDropOffParam.setWalkLineAWidth(6);
                walkDropOffParam.setWalkLineASpace(10.0f);
                walkDropOffParam.setWalkLineAColor(Color.parseColor("#999999"));
                walkDropOffParam.setWalkLineBSpace(20.0f);
                this.f29777b.setConfigParam(walkDropOffParam);
                this.f29777b.create(this.f29779d, this.f29780e);
            } catch (Exception e) {
                DLog.m10773d(f29776a, "createOldLine error" + e.getMessage(), new Object[0]);
            }
        }
    }

    /* renamed from: c */
    private void m23080c() {
        if (this.f29781f != null) {
            NewWalkLineComponent newWalkLineComponent = this.f29778c;
            if (newWalkLineComponent != null) {
                newWalkLineComponent.destroy();
                this.f29778c = null;
            }
            this.f29781f.setPushInterval((long) WalkComponentApolloUtils.getOraPushInterval());
            NewWalkParam newWalkParam = new NewWalkParam(this.f29781f.getEndPoint(), this.f29781f.getDriverId(), this.f29781f.getOrderId(), this.f29781f.getProductId(), this.f29781f.getPushInterval());
            NewWalkLineComponent newWalkLineComponent2 = new NewWalkLineComponent();
            this.f29778c = newWalkLineComponent2;
            newWalkLineComponent2.create(this.f29779d, this.f29780e, newWalkParam);
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        NewWalkLineComponent newWalkLineComponent = this.f29778c;
        if (newWalkLineComponent != null && !CollectionUtil.isEmpty((Collection<?>) newWalkLineComponent.getBestViewElements())) {
            arrayList.addAll(this.f29778c.getBestViewElements());
        }
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f29777b;
        if (iWalkAndDropOffLine != null) {
            if (!CollectionUtil.isEmpty((Collection<?>) iWalkAndDropOffLine.getDropOffLine())) {
                arrayList.addAll(this.f29777b.getDropOffLine());
            }
            if (!CollectionUtil.isEmpty((Collection<?>) this.f29777b.getWalkLine())) {
                arrayList.addAll(this.f29777b.getWalkLine());
            }
        }
        return arrayList;
    }
}
