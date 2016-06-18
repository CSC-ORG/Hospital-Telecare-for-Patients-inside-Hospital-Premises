package b2wdevelopers.com.hosptelecare;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeActivity extends AppCompatActivity {
ImageView hosp;
    Button b1,b2,b3,b4;
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.scan:
                onScan();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onScan(){


        IntentIntegrator.initiateScan(this);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {

            Log.d("scanresult", scanResult.toString());

            Log.d("scancontent",scanResult.getContents());
            if(scanResult.getContents().equals("CSC")){

                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);

            }
             if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Intent i = new Intent(this,HomeActivity.class);
                startActivity(i);
                }

            Log.d("scanresultcode",resultCode+"");

            Log.d("scanrequestcode",requestCode+"");

          }
        // else continue with any other code you need in the method
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
        alertDialog2.setMessage("Do you want to Logout?");
        alertDialog2.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(HomeActivity.this,LoginActivity.class);
                        HomeActivity.this.finish();
                        startActivity(i);
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
