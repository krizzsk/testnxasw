package com.didi.app.nova.skeleton.internal.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.ControllerChangeType;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didichuxing.sofa.permission.PermissionRequest;
import java.util.List;

public final class ControllerProxy extends RefWatchingController {

    /* renamed from: d */
    private static final String f10326d = "ControllerProxy.Page.className";

    /* renamed from: c */
    PageWrapper f10327c;

    public ControllerProxy(Bundle bundle) {
        super(bundle);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f10327c.onInflateView(layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onAttach(View view) {
        super.onAttach(view);
        this.f10327c.callStart();
    }

    /* access modifiers changed from: protected */
    public void onDetach(View view) {
        super.onDetach(view);
        this.f10327c.callStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroyView(View view) {
        super.onDestroyView(view);
        this.f10327c.callDestroy();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f10327c.onFinalize();
    }

    public boolean handleBack() {
        boolean handleBack = super.handleBack();
        return !handleBack ? this.f10327c.onHandleBack() : handleBack;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(f10326d, this.f10327c.getClass().getName());
        this.f10327c.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Page newInstance = PageFactory.newInstance(bundle.getString(f10326d), getArgs());
        this.f10327c = newInstance;
        newInstance.attach(getActivity(), new PageInstrumentImpl(getRouter()), this);
        this.f10327c.onRestoreInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onSaveViewState(View view, Bundle bundle) {
        super.onSaveViewState(view, bundle);
        this.f10327c.onSaveViewState(view, bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreViewState(View view, Bundle bundle) {
        this.f10327c.onRestoreViewState(view, bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10327c.onCreateOptionsMenu(menu, menuInflater);
    }

    /* access modifiers changed from: protected */
    public void onChangeStarted(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        setOptionsMenuHidden(!controllerChangeType.isEnter);
        this.f10327c.onChangeStarted(controllerChangeHandler, controllerChangeType);
    }

    /* access modifiers changed from: protected */
    public void onChangeEnded(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        super.onChangeEnded(controllerChangeHandler, controllerChangeType);
        this.f10327c.onChangeEnded(controllerChangeHandler, controllerChangeType);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f10327c.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        List<RouterTransaction> backstack = getRouter().getBackstack();
        if (!backstack.isEmpty() && backstack.get(backstack.size() - 1).controller() == this) {
            this.f10327c.callResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
        List<RouterTransaction> backstack = getRouter().getBackstack();
        if (!backstack.isEmpty() && backstack.get(backstack.size() - 1).controller() == this) {
            this.f10327c.callPause();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f10327c.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f10327c.onRequestPermissionsResult(i, strArr, iArr);
    }

    public PageWrapper getPage() {
        return this.f10327c;
    }

    public void onPermissionGranted() {
        super.onPermissionGranted();
        this.f10327c.onPermissionGranted();
    }

    public void onPermissionDenied(String[] strArr) {
        super.onPermissionDenied(strArr);
        this.f10327c.onPermissionDenied(strArr);
    }

    public boolean onShowPermissionExplanation(PermissionRequest permissionRequest) {
        return super.onShowPermissionExplanation(permissionRequest) && this.f10327c.showPermissionExplanation(permissionRequest);
    }

    public String toString() {
        return super.toString() + "{innerPage=" + this.f10327c + "}";
    }
}
