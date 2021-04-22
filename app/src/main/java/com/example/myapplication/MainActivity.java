package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;

    private SurfaceHolder sh;
    int mSurfaceWidth = 0;
    int mSurfaceHeight = 0;

    static final float RADIUS = 150.0f;
    static final float OOEF = 100.0f;

    float mBallX = 0;
    float mBallY = 0;

    float mVX = 0;
    float mVY = 0;

    long mT0 = 0;

    Bitmap mBallBitmap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}