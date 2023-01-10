package com.didi.rfusion.widget.floating;

import java.io.Serializable;

public class RFFloatingNavBar implements Serializable {
    private static final long serialVersionUID = -9200121808941075802L;
    private final transient RFFloatingNavBarController controller;
    private int navBarId;

    RFFloatingNavBar(RFFloatingNavBarController rFFloatingNavBarController, int i) {
        this.controller = rFFloatingNavBarController;
        this.navBarId = i;
    }

    public void setTitle(RFFloatingTextAttr rFFloatingTextAttr) {
        this.controller.mo94271a(this.navBarId, rFFloatingTextAttr);
    }

    public void setLeftIcon(RFFloatingIconAttr rFFloatingIconAttr) {
        this.controller.mo94270a(this.navBarId, rFFloatingIconAttr);
    }

    public void setRightButton(RFFloatingTextAttr rFFloatingTextAttr) {
        this.controller.mo94276b(this.navBarId, rFFloatingTextAttr);
    }

    public void setBackground(int i) {
        this.controller.mo94269a(this.navBarId, i);
    }

    public void setShadowVisible(boolean z) {
        this.controller.mo94277b(this.navBarId, z);
    }

    public void setVisible(boolean z) {
        this.controller.mo94279c(this.navBarId, z);
    }

    public boolean isVisible() {
        return this.controller.mo94280c(this.navBarId);
    }
}
