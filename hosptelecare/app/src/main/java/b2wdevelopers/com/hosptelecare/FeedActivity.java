package b2wdevelopers.com.hosptelecare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FeedActivity extends AppCompatActivity {

    TextView doc1,diag1,feed1;
    EditText doc2,diag2,feed2;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        submit=(Button)findViewById(R.id.submit);
        doc1=(TextView)findViewById(R.id.doc1);
        diag1=(TextView)findViewById(R.id.diag1);
        feed1=(TextView)findViewById(R.id.feed1);
        doc2=(EditText)findViewById(R.id.doc2);
        diag2=(EditText)findViewById(R.id.diag2);
        feed2=(EditText)findViewById(R.id.feed2);




    }

    public void onSubmit(View v)
    {
        doc2.setText("");
        diag2.setText("");
        feed2.setText("");

    }
}
