package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dr. Ken on 4/13/2016.
 */
public class AsyncTaskTestII extends AndroidTestCase implements MainActivity.IJokeListener{

    MainActivity jokeDownloader;
    MainActivity.EndpointsAsyncTask asyncTask;
    CountDownLatch signal;
    String returnedJoke = null;

    public void testVerifyNonNullReturn(){
        signal = new CountDownLatch(1);
        jokeDownloader = new MainActivity(this);
        asyncTask = jokeDownloader.new EndpointsAsyncTask();

        asyncTask.execute(new Pair<Context, String>(getContext(), null));
        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(returnedJoke);
    }


    @Override
    public void downloadCompleted(String _joke)
    {
        returnedJoke = _joke;
        signal.countDown();
    }
}