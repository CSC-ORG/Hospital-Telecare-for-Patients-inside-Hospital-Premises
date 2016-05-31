package b2wdevelopers.com.hosptelecare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class ApayActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private int year, month, day;
    EditText e1,e2,e3,e4;
    Button b,b1;
    String id;
    public static final String MyPREFERENCES = "MyPref" ;
    String bno,issue,amount,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apay);
        e4 = (EditText)findViewById(R.id.id2);
        e1 = (EditText)findViewById(R.id.bill2);
        e2 = (EditText)findViewById(R.id.issue1);
        e3 = (EditText)findViewById(R.id.amount1);
        b = (Button)findViewById(R.id.date1);
        b1 = (Button)findViewById(R.id.submit);
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
        id = e4.getText().toString();
        Log.d("apayid",id+"");
        bno = e1.getText().toString();
        issue = e2.getText().toString();
        amount = e3.getText().toString();
        if (!id.equals("") && !amount.equals("") && !issue.equals("") && !date.equals("") && !bno.equals("")) {
            int i = Integer.parseInt(id);
            Payments mr = new Payments(i, bno, issue, amount, date);
            DatabaseHandler db = new DatabaseHandler(this);
            db.addPayment(mr, this);
            Toast.makeText(this, "Payment details added successfully !", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "All fields should be filled", Toast.LENGTH_LONG).show();
        }
        e1.setText("");
        e2.setText("");
        e4.setText("");
        e3.setText("");
        b.setText("SET DATE");
    }


}
