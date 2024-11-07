package com.HESOYAM.externalsaray;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class FloatingMenu extends GLSurfaceView {
    private native void ImGuiInit();
    private native void ImGuiRender();
    private native void ImGuiResize(int width, int height);

    public FloatingMenu(Context context) {
        super(context);
        setEGLContextClientVersion(3);
        setBackgroundColor(Color.TRANSPARENT);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(PixelFormat.TRANSPARENT);
        setRenderer(new Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                ImGuiInit();
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int width, int height) {
                gl.glViewport(0, 0, width, height);
                ImGuiResize(width, height);
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                ImGuiRender();
            }
        });
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
