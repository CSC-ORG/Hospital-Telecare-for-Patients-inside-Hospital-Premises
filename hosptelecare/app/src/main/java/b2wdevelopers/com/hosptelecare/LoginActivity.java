package b2wdevelopers.com.hosptelecare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{


    TextView log;
    EditText user,pass;
    Button loo;
    String us,pas;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       log=(TextView)findViewById(R.id.login);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        loo=(Button)findViewById(R.id.loo);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void login(View view)
    {
        us=user.getText().toString();
        pas=pass.getText().toString();

        if(((us.equals("admin"))&&(pas.equals("admin123"))))
        {
            Intent intent2 = new Intent(LoginActivity.this, AdminActivity.class);
            user.setText("");
            pass.setText("");

            startActivity(intent2);
        }
        else if(!((us.equals(""))&&(pas.equals("")))){
            DatabaseHandler db = new DatabaseHandler(this);
            int id=db.check(us,pas);//getUserId(us, pas);

            if(id==0)
            {
                user.setText("");
                pass.setText("");
                Toast.makeText(this,"Enter valid credentials",Toast.LENGTH_LONG).show();

            }
            else {
                String a = Integer.toString(id);
                Log.d("userid", a);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("ID", id);
                editor.commit();
                Intent intent2 = new Intent(LoginActivity.this, HomeActivity.class);
                this.finish();
                startActivity(intent2);
                user.setText("");
                pass.setText("");
            }
        }
        else{
            user.setText("");
            pass.setText("");
            Toast.makeText(this,"Enter valid credentials",Toast.LENGTH_LONG).show();
        }
    }


    public void signUp(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegActivity.class);
        startActivity(intent);
    }

}
