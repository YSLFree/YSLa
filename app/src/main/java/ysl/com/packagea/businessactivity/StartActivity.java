package ysl.com.packagea.businessactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import ysl.com.packagea.jpushdemo.R;
import ysl.com.packagea.otherbusiness.ControlBean;
import ysl.com.packagea.utils.Constants;
import ysl.com.packagea.utils.Tools;

/**
 * Created by free on 2017/12/31.
 */

public class StartActivity extends Activity{
    private ControlBean controlBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity);
        controlBean=new ControlBean();
        Tools.getControlData(Constants.ControlURL);
        goToMainActivity();
    }

    private int getActivity(){
        Object isshowwap=controlBean.getIsshowwap();
return 0;
    }
    private void goToMainActivity(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(StartActivity.this,MainsActivity.class);
                startActivity(intent);
                StartActivity.this.finish();
            }
        };
        timer.schedule(task, 3000);//3秒后执行TimeTask的run方法
    }
}
