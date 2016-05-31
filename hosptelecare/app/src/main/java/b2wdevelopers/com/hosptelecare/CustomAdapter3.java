package b2wdevelopers.com.hosptelecare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter3 extends BaseAdapter{

    Context context;
    List<String> Id,Patient;
    private static LayoutInflater inflater=null;


    public CustomAdapter3(PatActivity patActivity, List IdList,List PatientList) {
        // TODO Auto-generated constructor stub

        context=patActivity;
        Id=IdList;
        Patient=PatientList;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Patient.size();
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

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.activity_useview, null);
        holder.tv1=(TextView) rowView.findViewById(R.id.text1);
        holder.tv2=(TextView) rowView.findViewById(R.id.text2);


        holder.tv1.setText(Id.get(position));
        holder.tv2.setText(Patient.get(position));


       /* rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + Doctor.get(position)+"'s Record", Toast.LENGTH_LONG).show();
            }
        });*/
        return rowView;
    }

}