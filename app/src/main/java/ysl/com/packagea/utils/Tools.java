package ysl.com.packagea.utils;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import ysl.com.packagea.otherbusiness.ControlBean;

/**
 * Created by free on 2017/12/31.
 */

public class Tools {
    private static OkHttpClient mClient;
    private static Request mReuest;
    private static Call mCall;
    public static String TAG="----getdata-------";
    public static int RESULT=5;


    public static void getControlData(String url) {
        mClient = new OkHttpClient();
        mReuest = new Request.Builder().url(url).build();
        mClient.newCall(mReuest).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                RESULT=0;
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Gson gson=new Gson();
                gson.fromJson(response.body().string(), ControlBean.class);
                Log.i(TAG, "转gsonsuccess！");
            }
        });

    }
}
