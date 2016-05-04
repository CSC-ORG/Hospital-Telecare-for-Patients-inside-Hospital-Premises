package b2wdevelopers.com.hosptelecare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends BaseAdapter{

    Context context;
    List<String> Date,Doctor,Issue;

    private static LayoutInflater inflater=null;
    public CustomAdapter(MedicalActivity medicalActivity, List DoctorList, List DateList, List IssueList) {
        // TODO Auto-generated constructor stub
        Doctor=DoctorList;
        context=medicalActivity;
        Issue=IssueList;
        Date=DateList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Doctor.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.activity_listview, null);
        holder.tv1=(TextView) rowView.findViewById(R.id.text1);
        holder.tv2=(TextView) rowView.findViewById(R.id.text2);
        holder.tv3=(TextView) rowView.findViewById(R.id.text3);

        holder.tv1.setText(Doctor.get(position));
        holder.tv2.setText(Date.get(position));
        holder.tv3.setText(Issue.get(position));

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + Doctor.get(position)+"'s Record", Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

}