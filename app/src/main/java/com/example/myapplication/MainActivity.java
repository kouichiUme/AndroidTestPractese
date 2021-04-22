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

public class MainActivity extends AppCompatActivity
        implements SensorEventListener, SurfaceHolder.Callback {

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
        setContentView(R.layout.activity_main);


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SurfaceView sv = (SurfaceView) findViewById(R.id.surfaceView);
        sh = sv.getHolder();
        sh.addCallback(this);


        sh.setFormat(PixelFormat.TRANSLUCENT);
        sv.setZOrderOnTop(true);

        Bitmap ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);

        int DIA = (int) RADIUS * 2;
        mBallBitmap = Bitmap.createScaledBitmap(ball,DIA ,DIA,true);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            float x = -event.values[0];
            float y = event.values[1];
//            event.values[2]
//
//            Log.d("線", String.format("x ; y ; z = %s,%s,Ts", , ));

            if (mT0 == 0) {
                mT0 = event.timestamp;
                return;
            }

            // 跳ね返り 左右
            if (mBallX - RADIUS < 0 && mVX < 0) {

            } else if (mBallX + RADIUS > mSurfaceWidth && mVX > 0) {

            }

            // 跳ね返り上下

            drawCanvas();


        }


    }

    private void drawCanvas() {
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME);
        mBallX = mSurfaceWidth / 2;
        mBallY = mSurfaceWidth / 2;


    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

        mSurfaceHeight = 1;
        mSurfaceHeight = 1;

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        mSensorManager.unregisterListener(this);

    }
}