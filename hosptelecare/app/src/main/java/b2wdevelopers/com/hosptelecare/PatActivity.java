package b2wdevelopers.com.hosptelecare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PatActivity extends AppCompatActivity {

    ListView listView;

    List<String> IdList,PatientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat);

        DatabaseHandler db = new DatabaseHandler(this);

        List<Users> use= db.getAllUsers();
        for(Users u :use) {

            Log.d("useact", u.getUName() + " " + u.getUPass());
        }
        IdList = new ArrayList<String>();
        PatientList = new ArrayList<String>();

        for(Users u : use){
            IdList.add(u.getUPass());
            PatientList.add(u.getUName());
        }
        listView=(ListView) findViewById(R.id.listView3);

        listView.setAdapter(new CustomAdapter3(this,IdList,PatientList));
    }

}
