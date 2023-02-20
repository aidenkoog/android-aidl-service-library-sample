package io.github.aidenkoog.android.aidl_apptemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import io.github.aidenkoog.android.aidl_apptemplate.library.utils.DebugLogger;
import io.github.aidenkoog.android.aidl_apptemplate.utils.Utils;

import static io.github.aidenkoog.android.aidl_apptemplate.ApiCommand.*;
import static io.github.aidenkoog.android.aidl_apptemplate.data.Constants.*;

import java.util.concurrent.ConcurrentHashMap;

public class ApiHandler extends Handler {

    private static final String TAG = ApiHandler.class.getSimpleName();

    private ConcurrentHashMap<String, IAidlManagerCallback> mCallbackMap;
    private final Context mContext;

    public int getApiMessageWhat() {
        return MSG_API;
    }

    public ApiHandler(Context context, Looper lopper,
                      ConcurrentHashMap<String, IAidlManagerCallback> callbackMap) {
        super(lopper);
        mContext = context;
        mCallbackMap = callbackMap;
    }

    @Override
    public void handleMessage(Message message) {
        Bundle result = Utils.inspectMessage(message, getApiMessageWhat(), mCallbackMap);
        if (result == null) {
            return;
        }

        String cmdString = result.getString(KEY_COMMAND);
        if (cmdString == null) {
            return;
        }

        switch (cmdString) {
            case CMD_TEST:
                break;

            default:
                DebugLogger.d(TAG, "unhandled command : " + cmdString);
        }
        super.handleMessage(message);
    }
}