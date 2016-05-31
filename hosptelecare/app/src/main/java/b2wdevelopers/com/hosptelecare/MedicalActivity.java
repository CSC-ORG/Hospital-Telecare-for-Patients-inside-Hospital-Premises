package b2wdevelopers.com.hosptelecare;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MedicalActivity extends AppCompatActivity {
    public static String [] DoctorList1={"Dr.Ashwin","Dr.Anirudh","Dr.Mohan","Dr.Junia","Dr.Azhar","Dr.Archana","Dr.Abishek","Dr.Anandhi","Dr.Hari"};
    public static String [] DateList1={"01:05:2015","02:05:2015","12:06:2015","10:07:2015","14:07:2015","02:08:2015","19:08:2015","30:08:2015","12:09:2015"};
    public static String [] IssueList1={"Head Ache","Stomach Pain","Body Pain","Tooth Ache","Finger Injury","Eye Pain","Stomach Pain","Head Ache","Head Injury"};
    ListView listView;
    TextView t;
    List<String> DoctorList,DateList,IssueList;
    SharedPreferences pref ;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        t = (TextView)findViewById(R.id.tv);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        id = pref.getInt("ID", 0);
        DatabaseHandler db = new DatabaseHandler(this);

        List<MedRecords> med= db.getRecords(id);

        for(MedRecords m : med) {

            Log.d("medact",m.getId()+" "+m.getIssue()+" "+m.getName()+ " "+m.getDate());

        }

        DoctorList = new ArrayList<String>();
        DateList = new ArrayList<String>();
        IssueList = new ArrayList<String>();

        for(MedRecords m : med){
            DoctorList.add(m.getName());
            DateList.add(m.getDate());
            IssueList.add(m.getIssue());
        }
        t.setText("MR."+db.getUserName(id).toUpperCase());

        listView=(ListView) findViewById(R.id.listView);

        listView.setAdapter(new CustomAdapter(this, DoctorList, DateList, IssueList));
}

}
