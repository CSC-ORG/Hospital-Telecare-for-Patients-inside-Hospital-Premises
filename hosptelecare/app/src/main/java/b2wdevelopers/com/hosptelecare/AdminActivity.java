package b2wdevelopers.com.hosptelecare;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);

    }

    public void med(View view)
    {
        Intent intent = new Intent(AdminActivity.this, AmedActivity.class);
    //    this.finish();
        startActivity(intent);
    }

    public void feed(View view)
    {
        Intent intent = new Intent(AdminActivity.this, AfeedActivity.class);
    //    this.finish();
        startActivity(intent);
    }
    public void pay(View view)
    {

        Intent intent = new Intent(AdminActivity.this, ApayActivity.class);
    //    this.finish();
        startActivity(intent);

    }
    public void det(View view)
    {

        Intent intent = new Intent(AdminActivity.this, PatActivity.class);
        //    this.finish();
        startActivity(intent);

    }
    @Override
    public void onBackPressed(){

        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(AdminActivity.this);
        alertDialog2.setTitle("EXIT");
        alertDialog2.setCancelable(false);
        alertDialog2.setMessage("Do you want to Logout?");
        alertDialog2.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                        AdminActivity.this.finish();
                        startActivity(intent);
                    }
                });
// Setting Negative "NO" Btn
        alertDialog2.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                    }
                });

        alertDialog2.show();

    }


}
