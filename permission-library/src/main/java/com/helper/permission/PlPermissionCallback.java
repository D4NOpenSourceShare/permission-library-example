package com.helper.permission;

public interface PlPermissionCallback {
    void onPermissionGranted();

    void onPermissionDenied();

    void onPermissionAborted();

}
