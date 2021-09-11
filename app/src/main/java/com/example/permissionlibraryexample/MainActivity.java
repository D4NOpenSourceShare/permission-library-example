package com.example.permissionlibraryexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.helper.permission.PlPermissionCallback;
import com.helper.permission.PlPermissionUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
    }

    private void requestPermission() {
        PlPermissionUtils.instance().setPermissionCallback(new PlPermissionCallback() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied() {
            }

            @Override
            public void onPermissionAborted() {
                finish();
            }
        });
        boolean showPermissionDialog = PlPermissionUtils.instance().showPermissionDialogIfNeed(this);
        if (!showPermissionDialog) {
            Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
        }
    }

}