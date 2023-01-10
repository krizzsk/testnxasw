package com.didichuxing.sofa.permission;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;

public interface PermissionResultCallback {
    void onPermissionDenied(String[] strArr);

    void onPermissionGranted();

    boolean onShowPermissionExplanation(PermissionRequest permissionRequest);

    class PermissionHelper extends C17281c {
        private int REQUEST_CODE;
        private String[] permissions;

        PermissionHelper() {
        }

        /* access modifiers changed from: package-private */
        public void requestPermission(Activity activity, Object obj, String[] strArr) {
            int i = RequestCodeManager.get(strArr);
            this.REQUEST_CODE = i;
            internalRequestPermission(activity, obj, strArr, PermissionRequest.m38865b(activity, strArr, i));
        }

        /* access modifiers changed from: package-private */
        public void requestPermission(Fragment fragment, Object obj, String[] strArr) {
            int i = RequestCodeManager.get(strArr);
            this.REQUEST_CODE = i;
            internalRequestPermission(fragment.getActivity(), obj, strArr, PermissionRequest.m38865b(fragment, strArr, i));
        }

        private void internalRequestPermission(Activity activity, Object obj, String[] strArr, PermissionRequest permissionRequest) {
            this.permissions = strArr;
            PermissionResultCallback permissionResultCallback = (PermissionResultCallback) obj;
            if (C17283e.m38883a(activity, strArr)) {
                permissionResultCallback.onPermissionGranted();
            } else if (!C17283e.m38886b(activity, strArr) || !permissionResultCallback.onShowPermissionExplanation(permissionRequest)) {
                permissionRequest.execute();
            }
        }

        /* access modifiers changed from: package-private */
        public void onRequestPermissionsResult(Activity activity, Object obj, int i, String[] strArr, int[] iArr) {
            internalOnRequestPermissionsResult(obj, i, strArr, iArr);
        }

        /* access modifiers changed from: package-private */
        public void onRequestPermissionsResult(Fragment fragment, Object obj, int i, String[] strArr, int[] iArr) {
            internalOnRequestPermissionsResult(obj, i, strArr, iArr);
        }

        private void internalOnRequestPermissionsResult(Object obj, int i, String[] strArr, int[] iArr) {
            PermissionResultCallback permissionResultCallback = (PermissionResultCallback) obj;
            if (i != this.REQUEST_CODE) {
                return;
            }
            if (C17283e.m38884a(iArr)) {
                permissionResultCallback.onPermissionGranted();
            } else {
                permissionResultCallback.onPermissionDenied(C17283e.m38885a(strArr, iArr));
            }
        }

        /* access modifiers changed from: package-private */
        public void onActivityResult(Activity activity, Object obj, int i, int i2, Intent intent) {
            internalOnActivityResult(activity, obj, i);
        }

        /* access modifiers changed from: package-private */
        public void onActivityResult(Fragment fragment, Object obj, int i, int i2, Intent intent) {
            internalOnActivityResult(fragment.getActivity(), obj, i);
        }

        private void internalOnActivityResult(Activity activity, Object obj, int i) {
            PermissionResultCallback permissionResultCallback = (PermissionResultCallback) obj;
            if (i != this.REQUEST_CODE) {
                return;
            }
            if (C17283e.m38883a(activity, this.permissions)) {
                permissionResultCallback.onPermissionGranted();
            } else {
                permissionResultCallback.onPermissionDenied(this.permissions);
            }
        }
    }
}
