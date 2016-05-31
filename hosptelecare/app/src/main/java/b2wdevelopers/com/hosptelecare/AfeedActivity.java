package b2wdevelopers.com.hosptelecare;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AfeedActivity extends AppCompatActivity {

    ListView listView;
    TextView t;
    List<String> DoctorList,DateList,FeedList,PatientList;
    SharedPreferences pref ;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afeed);

        t = (TextView)findViewById(R.id.tv);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        id = pref.getInt("ID", 0);

        DatabaseHandler db = new DatabaseHandler(this);

        List<Feedback> fee= db.getFeedback();

        for(Feedback f : fee) {

            Log.d("feedact", f.getId() + " " + f.getIssue() + " " + f.getDName() + " " + f.getPName() + " " + f.getDate());
        }

        DoctorList = new ArrayList<String>();
        DateList = new ArrayList<String>();
        FeedList = new ArrayList<String>();
        PatientList = new ArrayList<String>();

        for(Feedback f : fee){
            DoctorList.add(f.getDName());
            DateList.add(f.getDate());
            FeedList.add(f.getIssue());
            PatientList.add(f.getPName());
        }

        listView=(ListView) findViewById(R.id.listView2);

        listView.setAdapter(new CustomAdapter2(this, DoctorList, DateList, FeedList,PatientList));



    }

}
