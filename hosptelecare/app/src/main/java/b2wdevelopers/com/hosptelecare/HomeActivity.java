package b2wdevelopers.com.hosptelecare;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
ImageView hosp;
    Button b1,b2,b3,b4;
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);

    }


    public void medrec(View view)
    {   //pl1.startAnimation(anim);

        val=1;
        Intent intent = new Intent(HomeActivity.this, ScannerActivity.class);
        intent.putExtra("value", val);
        startActivity(intent);

    }
    public void billpay(View view)
    {

        val=2;
        Intent intent = new Intent(HomeActivity.this, ScannerActivity.class);
        intent.putExtra("value", val);
        startActivity(intent);


    }
    public void hosmap(View view)
    {   //pl1.startAnimation(anim);
        Intent intent = new Intent(HomeActivity.this, MapActivity.class);
        startActivity(intent);


    }

    public void cusfeed(View view)
    {   //pl1.startAnimation(anim);


        Intent intent = new Intent(HomeActivity.this, FeedActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(HomeActivity.this);
        alertDialog2.setTitle("EXIT");
        alertDialog2.setCancelable(false);
        alertDialog2.setMessage("Do you want to Exit?");
        alertDialog2.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        HomeActivity.this.finish();

                    }
                });
// Setting Negative "NO" Btn
        alertDialog2.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Intent intent = new Intent(ChallengeActivity.this, MenuActivity.class);
                        //startActivity(intent);

                        dialog.cancel();
                    }
                });

        alertDialog2.show();
        // mp.release();
    }
}
