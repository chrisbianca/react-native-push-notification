package com.dieam.reactnativepushnotification;

import android.app.Application;
import android.content.Intent;

import com.dieam.reactnativepushnotification.modules.RNPushNotification;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReactNativePushNotificationPackage implements ReactPackage {
    Application mApplication;
    RNPushNotification mRNPushNotification;
    String gcmSenderId;

    public ReactNativePushNotificationPackage(Application application, String gcmSenderId) {
        mApplication = application;
        this.gcmSenderId = gcmSenderId;
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        mRNPushNotification = new RNPushNotification(reactContext, mApplication, gcmSenderId);

        modules.add(mRNPushNotification);
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Arrays.asList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return new ArrayList<>();
    }

    public void newIntent(Intent intent) {
        if(mRNPushNotification == null){ return; }
        mRNPushNotification.newIntent(intent);
    }
}


