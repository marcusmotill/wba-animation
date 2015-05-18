package interapt.wbaanimations;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    RelativeLayout viewToRotate;
    FrameLayout frameLayout1, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7;
    ClipDrawable clipDrawable1, clipDrawable2, clipDrawable3, clipDrawable4, clipDrawable5, clipDrawable6, clipDrawable7;
    Button next, complete;

    ClipDrawable[] clipDrawables;
    int count = 0;
    int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewToRotate = (RelativeLayout) findViewById(R.id.viewToRotate);

        next = (Button) findViewById(R.id.bNext);
        complete = (Button) findViewById(R.id.bComplete);

        next.setOnClickListener(this);
        complete.setOnClickListener(this);

        frameLayout1 = (FrameLayout) findViewById(R.id.framelayout1);
        frameLayout2 = (FrameLayout) findViewById(R.id.framelayout2);
        frameLayout3 = (FrameLayout) findViewById(R.id.framelayout3);
        frameLayout4 = (FrameLayout) findViewById(R.id.framelayout4);
        frameLayout5 = (FrameLayout) findViewById(R.id.framelayout5);
        frameLayout6 = (FrameLayout) findViewById(R.id.framelayout6);
        frameLayout7 = (FrameLayout) findViewById(R.id.framelayout7);

        imageView1 = (ImageView) findViewById(R.id.basicaccessclip);
        imageView2 = (ImageView) findViewById(R.id.emotionalhealthclip);
        imageView3 = (ImageView) findViewById(R.id.healthybehaviorclip);
        imageView4 = (ImageView) findViewById(R.id.labsbioclip);
        imageView5 = (ImageView) findViewById(R.id.lifeevalclip);
        imageView6 = (ImageView) findViewById(R.id.physicalhealthclip);
        imageView7 = (ImageView) findViewById(R.id.workenvironclip);

        clipDrawable1 = (ClipDrawable) imageView1.getDrawable();
        clipDrawable2 = (ClipDrawable) imageView2.getDrawable();
        clipDrawable3 = (ClipDrawable) imageView3.getDrawable();
        clipDrawable4 = (ClipDrawable) imageView4.getDrawable();
        clipDrawable5 = (ClipDrawable) imageView5.getDrawable();
        clipDrawable6 = (ClipDrawable) imageView6.getDrawable();
        clipDrawable7 = (ClipDrawable) imageView7.getDrawable();

        clipDrawables = new ClipDrawable[]{clipDrawable1, clipDrawable7, clipDrawable6, clipDrawable5, clipDrawable4, clipDrawable3, clipDrawable2};
        viewToRotate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == next.getId()){
            clickCounter++;
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                int count2 = 0;
                @Override
                public void run() {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            count++;
                            count2++;
                            viewToRotate.setRotation(count);
                            frameLayout1.setRotation(-count);
                            frameLayout2.setRotation(-count);
                            frameLayout3.setRotation(-count);
                            frameLayout4.setRotation(-count);
                            frameLayout5.setRotation(-count);
                            frameLayout6.setRotation(-count);
                            frameLayout7.setRotation(-count);
                            if (count2 == 51) {
                                timer.cancel();
                            }

                        }
                    });
                }
            }, 0, 10);

        }else if(id == complete.getId()){

            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int count = 0;

                @Override
                public void run() {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            count++;
                            clipDrawables[clickCounter].setLevel(count * 250);
                            if (count == 40) {
                                timer.cancel();
                            }
                        }
                    });
                }
            }, 0, 10);
        }



    }
}
