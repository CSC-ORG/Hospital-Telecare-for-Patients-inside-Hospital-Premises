package b2wdevelopers.com.hosptelecare;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity {
    ListView l1;
    Button pay;
    TextView total;
    List<String> bno,date,issue,amount;
    SharedPreferences pref ;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        pay=(Button)findViewById(R.id.b1);
        l1 = (ListView)findViewById(R.id.listView);
        total = (TextView)findViewById(R.id.total);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        id = pref.getInt("ID", 0);

        DatabaseHandler db = new DatabaseHandler(this);

        List<Payments> p = db.getPayments(id);

        bno = new ArrayList<String>();
        date =new ArrayList<String>();
        issue = new ArrayList<String>();
        amount =new ArrayList<String>();

        int tot=0;
        for(Payments m : p){
            bno.add(m.getBill());
            date.add(m.getDate());
            issue.add(m.getIssue());
            amount.add(m.getAmount());
            tot+=Integer.parseInt(m.getAmount());
        }
        total.setText("Rs. "+tot);

        l1.setAdapter(new CustomAdapter1(this, bno, date, issue,amount));

    }

}
