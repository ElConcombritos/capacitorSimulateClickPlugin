package com.elconcombritos.plugins.simulateclickplugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;


import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.getcapacitor.Bridge;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;


@CapacitorPlugin(name = "SimulateClickPlugin")
public class SimulateClickPluginPlugin extends Plugin {

    private SimulateClickPlugin implementation = new SimulateClickPlugin();

   /* @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }*/

    @PluginMethod
    public void simulateClick(PluginCall call) {
        Bridge bridge = getBridge();
        View rootView = bridge.getActivity().getWindow().getDecorView().findViewById(android.R.id.content);

        int x = 1;
        int y = 1;

        // Simulate click
        simulateClick(rootView, x, y);

        call.success();
    }

    private void simulateClick(View view, int x, int y) {
        long downTime = System.currentTimeMillis();
        long eventTime = System.currentTimeMillis();

        MotionEvent motionEventDown = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, x, y, 0);
        MotionEvent motionEventUp = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, x, y, 0);

        view.dispatchTouchEvent(motionEventDown);
        view.dispatchTouchEvent(motionEventUp);
    }
}
