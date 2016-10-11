package jp.co.a328w.kubox.ganaltrackevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;

    private Tracker mTracker;
    private final String actionName = "gradle22_gs212_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mTracker.setScreenName("MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    @OnClick(R.id.button1)
    public void onClickButton1() {
        Log.d("test", actionName + "button1");
        sendEvent("button", actionName + "button1");
    }

    @OnClick(R.id.button2)
    public void onClickButton2(){
        Log.d("test", actionName + "button2");
        sendEvent("button", actionName + "button2");
    }

    @OnClick(R.id.button3)
    public void onClickButton3(){
        Log.d("test", actionName + "button3");
        sendEvent("button", actionName + "button3");
    }


    private void sendEvent(String categoryName, String actionName){
        mTracker.send(new HitBuilders.EventBuilder()
            .setCategory(categoryName)
            .setAction(actionName)
            .build());
    }
//


}
