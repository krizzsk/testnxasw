package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.view.View;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.manager.DepartureOmegaManager;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DeparturePickupSpotState;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.view.ITerminalView;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;

public class DepartureCardViewController {

    /* renamed from: a */
    private Context f27580a;

    /* renamed from: b */
    private DepartureFenceOptions f27581b;

    /* renamed from: c */
    private ITerminalView f27582c;

    /* renamed from: d */
    private ITerminalWelcomeView f27583d;

    /* renamed from: e */
    private ITerminalView.Callback f27584e;

    /* renamed from: f */
    private ITerminalWelcomeView.Callback f27585f;

    /* renamed from: g */
    private DepartureCompParams f27586g;

    /* renamed from: h */
    private DeparturePickupSpotState f27587h;

    /* renamed from: i */
    private int f27588i = 0;

    /* renamed from: j */
    private int f27589j = 0;

    /* renamed from: k */
    private DepartureOmegaManager f27590k;

    public DepartureCardViewController(Context context, DepartureCompParams departureCompParams) {
        this.f27580a = context;
        this.f27586g = departureCompParams;
        this.f27581b = departureCompParams.getFenceOptions();
        this.f27587h = new DeparturePickupSpotState();
        DepartureFenceOptions departureFenceOptions = this.f27581b;
        if (departureFenceOptions != null) {
            this.f27588i = departureFenceOptions.cardWizardStart;
            this.f27589j = this.f27581b.cardStyle;
        }
    }

    public void setOmegaManager(DepartureOmegaManager departureOmegaManager) {
        this.f27590k = departureOmegaManager;
    }

    public void setTerminalViewCallback(ITerminalView.Callback callback) {
        this.f27584e = callback;
    }

    public void setWelcomeViewCallback(ITerminalWelcomeView.Callback callback) {
        this.f27585f = callback;
    }

    public boolean isWelcomeViewValid() {
        ITerminalWelcomeView iTerminalWelcomeView = this.f27583d;
        return iTerminalWelcomeView != null && iTerminalWelcomeView.isValid() && this.f27588i == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f27586g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isTerminalViewValid() {
        /*
            r1 = this;
            com.didi.map.global.component.departure.view.ITerminalView r0 = r1.f27582c
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x0016
            com.didi.map.global.component.departure.DepartureCompParams r0 = r1.f27586g
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isTerminalViewVisible()
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.view.DepartureCardViewController.isTerminalViewValid():boolean");
    }

    public boolean isTerminal() {
        ITerminalView iTerminalView = this.f27582c;
        return iTerminalView != null && iTerminalView.isValid() && this.f27582c.isTerminal();
    }

    public boolean isValidAndTerminal() {
        return isTerminalViewValid() && isTerminal();
    }

    public boolean hasTerminalView() {
        return this.f27582c != null;
    }

    public SPoi getSelectedTerminalArea() {
        ITerminalView iTerminalView = this.f27582c;
        if (iTerminalView != null) {
            return iTerminalView.getSelectedTerminalArea();
        }
        return null;
    }

    public View getDepartureCardView() {
        DeparturePickupSpotState departurePickupSpotState;
        if (this.f27581b == null) {
            return null;
        }
        View a = m21813a();
        if (a != null) {
            return a;
        }
        if (this.f27581b.cardWizardStart != 1 || ((departurePickupSpotState = this.f27587h) != null && departurePickupSpotState.isValid() && this.f27587h.isChecked())) {
            return m21816b();
        }
        return null;
    }

    /* renamed from: a */
    private View m21813a() {
        ITerminalWelcomeView iTerminalWelcomeView;
        DepartureFenceOptions departureFenceOptions = this.f27581b;
        if (departureFenceOptions == null || departureFenceOptions.cardWizardStart != 2 || (iTerminalWelcomeView = this.f27583d) == null) {
            return null;
        }
        return iTerminalWelcomeView.getView();
    }

    /* renamed from: b */
    private View m21816b() {
        ITerminalView iTerminalView = this.f27582c;
        if (iTerminalView != null) {
            return iTerminalView.getView();
        }
        return null;
    }

    public void setSelectedTerminalArea(SPoi sPoi) {
        ITerminalView iTerminalView = this.f27582c;
        if (iTerminalView != null) {
            iTerminalView.setSelectedTerminalArea(sPoi);
        }
    }

    public void performSelectedArea(SPoi sPoi, RpcPoi rpcPoi) {
        ITerminalView iTerminalView = this.f27582c;
        if (iTerminalView != null) {
            iTerminalView.performSelectedArea(sPoi, rpcPoi);
        }
    }

    public void setSelectedDeparture(RpcPoi rpcPoi) {
        ITerminalView iTerminalView = this.f27582c;
        if (iTerminalView != null) {
            iTerminalView.setSelectedDeparture(rpcPoi);
        }
    }

    public void setData(DepartureAddress departureAddress, FenceInfo fenceInfo, RpcPoi rpcPoi) {
        m21815a(fenceInfo);
        m21814a(departureAddress, rpcPoi);
        boolean z = true;
        if (this.f27588i != 1 || !isTerminalViewValid()) {
            z = false;
        }
        DeparturePickupSpotState departurePickupSpotState = this.f27587h;
        if (departurePickupSpotState != null) {
            departurePickupSpotState.setValid(z);
        }
    }

    public void setPickupSpotChecked(boolean z) {
        DeparturePickupSpotState departurePickupSpotState = this.f27587h;
        if (departurePickupSpotState != null) {
            departurePickupSpotState.setChecked(z);
        }
    }

    public boolean isWaitCheckPickupSpot() {
        DeparturePickupSpotState departurePickupSpotState = this.f27587h;
        return departurePickupSpotState != null && !departurePickupSpotState.isChecked() && this.f27587h.isValid();
    }

    /* renamed from: a */
    private void m21815a(FenceInfo fenceInfo) {
        if (this.f27588i == 2) {
            if (this.f27583d == null) {
                this.f27583d = TerminalViewFactory.createTerminalWelcomeView(this.f27580a, this.f27585f);
            }
            ITerminalWelcomeView iTerminalWelcomeView = this.f27583d;
            if (iTerminalWelcomeView != null) {
                iTerminalWelcomeView.setData(fenceInfo);
            }
        }
    }

    /* renamed from: a */
    private void m21814a(DepartureAddress departureAddress, RpcPoi rpcPoi) {
        if (this.f27582c == null) {
            this.f27582c = TerminalViewFactory.createTerminalView(this.f27580a, this.f27584e);
        }
        ITerminalView iTerminalView = this.f27582c;
        if (iTerminalView != null) {
            iTerminalView.setCardStyle(this.f27589j);
            ITerminalView iTerminalView2 = this.f27582c;
            boolean z = true;
            if (this.f27589j != 1) {
                z = false;
            }
            iTerminalView2.setShowBroadOtherInAreaCard(z);
            this.f27582c.setData(departureAddress != null ? departureAddress.getSpecialPois() : null);
            this.f27582c.setSelectedDeparture(rpcPoi);
            refreshTerminalCardViewSubNotice(departureAddress);
        }
    }

    public void refreshTerminalCardViewSubNotice(DepartureAddress departureAddress) {
        if (this.f27582c == null) {
            return;
        }
        if (departureAddress == null || departureAddress.getExtendInfo() == null || isTerminal()) {
            this.f27582c.setPickupPoiNotice("");
        } else {
            this.f27582c.setPickupPoiNotice(departureAddress.getExtendInfo().getMainNoticeTitle());
        }
    }
}
