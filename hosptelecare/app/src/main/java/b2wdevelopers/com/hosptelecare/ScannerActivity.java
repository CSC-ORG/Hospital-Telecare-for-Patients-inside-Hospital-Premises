package b2wdevelopers.com.hosptelecare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScannerActivity extends AppCompatActivity {

    ImageView fing;
    TextView inst;
    Intent intent;
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      */
        fing=(ImageView)findViewById(R.id.finger);
        inst=(TextView)findViewById(R.id.inst);

        Bundle extras = getIntent().getExtras();
        if (extras!= null) {
            val= extras.getInt("value");

        }

        fing.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                if(val==1)
                intent = new Intent(ScannerActivity.this, MedicalActivity.class);
                else
                intent = new Intent(ScannerActivity.this, BillActivity.class);

                startActivity(intent);
                ScannerActivity.this.finish();
                return true;
            }
        });


    }

}
