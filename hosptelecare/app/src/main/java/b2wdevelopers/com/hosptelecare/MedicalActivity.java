package b2wdevelopers.com.hosptelecare;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MedicalActivity extends AppCompatActivity {
    public static String [] DoctorList1={"Dr.Ashwin","Dr.Anirudh","Dr.Mohan","Dr.Junia","Dr.Azhar","Dr.Archana","Dr.Abishek","Dr.Anandhi","Dr.Hari"};
    public static String [] DateList1={"01:05:2015","02:05:2015","12:06:2015","10:07:2015","14:07:2015","02:08:2015","19:08:2015","30:08:2015","12:09:2015"};
    public static String [] IssueList1={"Head Ache","Stomach Pain","Body Pain","Tooth Ache","Finger Injury","Eye Pain","Stomach Pain","Head Ache","Head Injury"};
    ListView listView;
    List<String> DoctorList,DateList,IssueList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DoctorList = new ArrayList<String>();
        DateList = new ArrayList<String>();
        IssueList = new ArrayList<String>();


        for(String a : DoctorList1){
            DoctorList.add(a);
        }

        for(String b : DateList1){
            DateList.add(b);
        }

        for(String c : IssueList1){
            IssueList.add(c);
        }

        listView=(ListView) findViewById(R.id.listView);

        listView.setAdapter(new CustomAdapter(this, DoctorList, DateList, IssueList));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    protected void showCustomDialog() {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(MedicalActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.customdialog);

        final EditText editText1 = (EditText)dialog.findViewById(R.id.editText1);
        final EditText editText2 = (EditText)dialog.findViewById(R.id.editText2);
        final EditText editText3 = (EditText)dialog.findViewById(R.id.editText3);
        Button button = (Button)dialog.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DoctorList.add(editText1.getText().toString());
                DateList.add(editText2.getText().toString());
                IssueList.add(editText3.getText().toString());
                listView.setAdapter(new CustomAdapter(MedicalActivity.this, DoctorList, DateList, IssueList));
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
