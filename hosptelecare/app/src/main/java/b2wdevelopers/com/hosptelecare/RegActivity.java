package b2wdevelopers.com.hosptelecare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    EditText us,pass,repass;
    String user,pas,repas;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        us=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText4);
        repass=(EditText)findViewById(R.id.editText5);
        reg=(Button)findViewById(R.id.button4);


    }

    public void register(View view)
    {
        user=us.getText().toString();
        pas=pass.getText().toString();
        repas=repass.getText().toString();


        if((!(us.equals("")))&&((!pas.equals("")))&&(!(repas.equals("")))){

            if(!pas.equals(repas))
            {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show();
                us.setText("");
                pass.setText("");
                repass.setText("");
            }
            else {
                Users u = new Users();
       //         u.setUId(10);
                u.setUName(user);
                u.setUPass(pas);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addUsers(u, this);
                Intent intent2 = new Intent(RegActivity.this, LoginActivity.class);
                this.finish();
                startActivity(intent2);
            }
        }
        else{
            us.setText("");
            pass.setText("");
            repass.setText("");
            Toast.makeText(this,"Enter valid credentials",Toast.LENGTH_LONG).show();
        }

    }

}
