package b2wdevelopers.com.hosptelecare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class FeedActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private int year, month, day;
    EditText e1,e2,e3;
    Button b,b1;
    int id;
    public static final String MyPREFERENCES = "MyPref" ;
    String pat,doc,issue,date;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        e1 = (EditText)findViewById(R.id.pat1);
        e2 = (EditText)findViewById(R.id.doc2);
        e3 = (EditText)findViewById(R.id.feed2);
        b = (Button)findViewById(R.id.date2);
        b1 = (Button)findViewById(R.id.submit);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            DatePickerDialog dialog =new DatePickerDialog(this, myDateListener, year, month, day);
            dialog.updateDate(2016,6,1);
            return dialog;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        date = day+"/"+month+"/"+year;
        b.setText(date);
    }


        public void onSubmit(View view) {
        id = sharedpreferences.getInt("ID", 0);
        pat = e1.getText().toString();
        doc = e2.getText().toString();
        issue = e3.getText().toString();

        if (!pat.equals("") && !doc.equals("") && !date.equals("") && !issue.equals("")) {
            Feedback mr = new Feedback(id, pat,doc, issue,date);
            DatabaseHandler db = new DatabaseHandler(this);
            db.addFeedback(mr, this);
            Toast.makeText(this, "Feedback added successfully !", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "All fields should be filled", Toast.LENGTH_LONG).show();
        }
        e1.setText("");
        e2.setText("");
        e3.setText("");
        b.setText("SET DATE");
    }
}
