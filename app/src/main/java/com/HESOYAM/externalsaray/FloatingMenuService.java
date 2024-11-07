package com.HESOYAM.externalsaray;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class FloatingMenuService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        FloatingMenu menu = new FloatingMenu(this);

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 0;

        windowManager.addView(menu, params);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
