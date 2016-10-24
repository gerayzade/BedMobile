package gerayzade.bedmobile;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView answer_1;
    ImageView answer_2;
    MediaPlayer mp;

    class getResponse implements OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.answer_1:
                    MainActivity.this.answer_1.setImageResource(R.drawable.answer_touch);
                    MainActivity.this.startActivity(new Intent(MainActivity.this, BedTalks.class));
                case R.id.answer_2:
                    MainActivity.this.answer_2.setImageResource(R.drawable.or_answer_touch);
                    MainActivity.this.startActivity(new Intent(MainActivity.this, BedTalks.class));
                default:
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mp = MediaPlayer.create(this, R.raw.ring);
        this.mp.start();
        this.mp.setLooping(true);
        this.answer_1 = (ImageView) findViewById(R.id.answer_1);
        this.answer_2 = (ImageView) findViewById(R.id.answer_2);
        OnClickListener response = new getResponse();
        this.answer_1.setOnClickListener(response);
        this.answer_2.setOnClickListener(response);
    }

    protected void onPause() {
        super.onPause();
        this.mp.release();
        finish();
    }
}
