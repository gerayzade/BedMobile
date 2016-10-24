package gerayzade.bedmobile;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.TextView;

public class BedTalks extends AppCompatActivity {
    private Chronometer mChronometer;
    TextView textView4;

    class update implements OnChronometerTickListener {
        public void onChronometerTick(Chronometer chronometer) {
            long elapsedMillis = SystemClock.elapsedRealtime() - BedTalks.this.mChronometer.getBase();
            BedTalks.this.textView4 = (TextView) BedTalks.this.findViewById(R.id.textView4);
            if (elapsedMillis > 10000) {
                BedTalks.this.textView4.setText("Bekarsan e... Krovatnan 10 saniye daniwirsan!");
            }
            if (elapsedMillis > 15000) {
                BedTalks.this.textView4.setText("Day bu qeder yox daa...");
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_bed_talks);
        this.mChronometer = (Chronometer) findViewById(R.id.chronometer);
        this.mChronometer.setOnChronometerTickListener(new update());
        this.mChronometer.setBase(SystemClock.elapsedRealtime());
        this.mChronometer.start();
    }

    public void endTalk(View view) {
        finish();
    }
}