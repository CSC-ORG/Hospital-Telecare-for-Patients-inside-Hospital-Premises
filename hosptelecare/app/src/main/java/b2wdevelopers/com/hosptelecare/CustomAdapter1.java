package b2wdevelopers.com.hosptelecare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter1 extends BaseAdapter{

    Context context;
    List<String> bno,amount,issue,date;

    private static LayoutInflater inflater=null;
    public CustomAdapter1(BillActivity bill, List bno1, List date1, List issue1,List amount1) {
        // TODO Auto-generated constructor stub
        bno=bno1;
        context=bill;
        issue=issue1;
        date=date1;
        amount = amount1;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return bno.size();
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

    public class Holder1
    {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder1 holder=new Holder1();
        View rowView;
        rowView = inflater.inflate(R.layout.activity_payview, null);
        holder.tv1=(TextView) rowView.findViewById(R.id.text1);
        holder.tv2=(TextView) rowView.findViewById(R.id.text2);
        holder.tv3=(TextView) rowView.findViewById(R.id.text3);
        holder.tv4=(TextView) rowView.findViewById(R.id.text4);

        holder.tv1.setText("#"+bno.get(position));
        holder.tv2.setText(date.get(position));
        holder.tv3.setText(issue.get(position));
        holder.tv4.setText(amount.get(position));

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });
        return rowView;
    }

}