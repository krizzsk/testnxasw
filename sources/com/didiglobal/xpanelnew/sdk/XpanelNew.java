package com.didiglobal.xpanelnew.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.base.XpOmegaConfig;
import com.didiglobal.xpanelnew.callback.IXpCallback;
import com.didiglobal.xpanelnew.callback.IXpView;
import com.didiglobal.xpanelnew.message.IXpMessageContainer;
import com.didiglobal.xpanelnew.view.XpanelView;
import java.util.List;

public class XpanelNew implements IXpView, IXpanelNew {

    /* renamed from: a */
    private Context f54169a;

    /* renamed from: b */
    private XpanelView f54170b;

    public void destroy() {
    }

    public XpanelNew(Activity activity, XpConfig xpConfig) {
        this.f54169a = activity;
        XpanelView xpanelView = new XpanelView(activity);
        this.f54170b = xpanelView;
        xpanelView.init(xpConfig);
    }

    public void setData(List<XpCardProperty> list) {
        this.f54170b.setData(list);
    }

    public void addCard(XpCardProperty xpCardProperty, int i) {
        this.f54170b.addCard(xpCardProperty, i);
    }

    public void removeCard(int i) {
        this.f54170b.removeCard(i);
    }

    public void setData(List<XpCardProperty> list, boolean z) {
        this.f54170b.setDataWithAnimator(list, z);
    }

    public void setXpScrollEnabled(boolean z) {
        XpanelView xpanelView = this.f54170b;
        if (xpanelView != null) {
            xpanelView.setXpScrollEnabled(z);
        }
    }

    public View getView() {
        return this.f54170b.getView();
    }

    public IXpMessageContainer getMessageContainer() {
        return this.f54170b.getMessageContainer();
    }

    public void setTitle(String str) {
        this.f54170b.setTitle(str);
    }

    public void refreshMsgHeight() {
        this.f54170b.refreshMsgHeight();
    }

    public void setConfig(XpConfig xpConfig) {
        this.f54170b.setConfig(xpConfig);
    }

    public void setOmegaConfig(XpOmegaConfig xpOmegaConfig) {
        this.f54170b.setOmegaConfig(xpOmegaConfig);
    }

    public void setShowOneCard() {
        this.f54170b.setShowOneCard();
    }

    public int getFirstCardHeight() {
        return this.f54170b.getFirstCardHeight();
    }

    public int getMessageRealHeight() {
        return this.f54170b.getMessageRealHeight();
    }

    public void fistCardHeightChange(int i) {
        this.f54170b.fistCardHeightChange(i);
    }

    public void firstCardHeightWillChangeTo(XpConfig xpConfig) {
        this.f54170b.firstCardHeightWillChangeTo(xpConfig);
    }

    public void cardHeightChange(int i, int i2) {
        this.f54170b.cardHeightChange(i, i2);
    }

    public void onResume() {
        this.f54170b.onResume();
    }

    public void onPause() {
        this.f54170b.onPause();
    }

    public void setXpCallback(IXpCallback iXpCallback) {
        this.f54170b.setXpCallback(iXpCallback);
    }
}
