package com.secrettextview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.secrettextview.SecretTextView;

import java.util.Map;

import javax.annotation.Nullable;

public class ShineLabelManager extends SimpleViewManager<SecretTextView> {
    private static final String REACT_CLASS = "ShineLabel";
    private static final int COMMAND_SHINE = 1;
    private static final int COMMAND_FADEOUT = 2;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected SecretTextView createViewInstance(ThemedReactContext reactContext) {
        SecretTextView secretTextView = new SecretTextView(reactContext);
        return secretTextView;
    }

    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(
                "shine", COMMAND_SHINE,
                "fadeOut", COMMAND_FADEOUT
        );
    }

    @Override
    public void receiveCommand(final SecretTextView view, int commandId, final ReadableArray args) {
        switch (commandId) {
            case COMMAND_SHINE: {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override public void run() {
                       view.show();
                    }
                });
            }
            break;
            case COMMAND_FADEOUT: {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override public void run() {
                        view.hide();
                    }
                });
            }
            break;
        }
    }

//
    @ReactProp(name = "text")
    public void setText(SecretTextView view, String text) {
        view.setText(text);
    }


    @ReactProp(name = "fontColor")
    public void setFontColor(SecretTextView view, String text) {
        view.setFontColor(text);
    }

    @ReactProp(name = "font")
    public void setFont(SecretTextView view, String text) {
        view.setTypeface(Typeface.create(text, Typeface.NORMAL));
    }

    @ReactProp(name = "fontSize")
    public void setFontSize(SecretTextView view, int size) {
        view.setTextSize(size);
    }

    @ReactProp(name = "autoStart")
    public void setAutoStart(SecretTextView view, Boolean start) {
        if (start){
            view.toggle();
        }
    }

}
