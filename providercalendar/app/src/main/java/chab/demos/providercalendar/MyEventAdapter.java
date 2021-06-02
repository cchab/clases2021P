package chab.demos.providercalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyEventAdapter extends ArrayAdapter<MyEvent> {
    Context ctx;
    public MyEventAdapter(Context context, ArrayList<MyEvent> events) {
        super(context, R.layout.calendar_list_view, events);
        this.ctx = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        MyEvent c = getItem(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.calendar_list_view,null);
        }
        TextView tvid = (TextView)convertView.findViewById(R.id.txtid);
        TextView tvName = (TextView)convertView.findViewById(R.id.txtName);
        TextView tvOwner = (TextView)convertView.findViewById(R.id.txtOwner);
        Button buttonDelete = convertView.findViewById(R.id.buttonVer);

        tvName.setText(c.getTitle());
        tvid.setText(""+c.getTimeZ());
        tvOwner.setText(String.format("%s - %s",c.getDate(),c.getOrgenizer()));
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                Toast.makeText(ctx,"ver calendario "+position,Toast.LENGTH_LONG).show();
            }
        });
        return  convertView;
    }
}
