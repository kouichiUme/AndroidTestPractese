package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.MediaStore;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myapplication", appContext.getPackageName());
    }


    @Test
    public void test_contextResolver(){


        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();


        String[] project = {MediaStore.Images.Media._ID,MediaStore.Images.Media.DATA };
        String selection = "_data = ? ";
        String[] selectionArg = {"jpg"};
        Cursor c = appContext.getContentResolver().query(MediaStore.Files.getContentUri("external"),project,selection,selectionArg,null);
        DatabaseUtils.dumpCursor(c);

    }


}