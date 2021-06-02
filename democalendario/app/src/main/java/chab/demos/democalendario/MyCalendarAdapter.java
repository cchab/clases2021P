package chab.demos.democalendario;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCalendarAdapter extends ArrayAdapter<MyCalendar> {
    Context ctx;
    public MyCalendarAdapter( Context context,  ArrayList<MyCalendar> calendars ) {
        super(context, R.layout.calendar_list_view,calendars);
        this.ctx = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        MyCalendar c = getItem(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.calendar_list_view,null);
        }
        TextView tvid = (TextView)convertView.findViewById(R.id.txtid);
        TextView tvName = (TextView)convertView.findViewById(R.id.txtName);
        TextView tvOwner = (TextView)convertView.findViewById(R.id.txtOwner);
        Button buttonDelete = convertView.findViewById(R.id.buttonVer);

        tvName.setText(c.getDisplayName());
        tvid.setText(""+c.getId());
        tvOwner.setText(c.getOwnerName());
        buttonDelete.setOnClickListener(new ActionOnClick(ctx,c));
        return  convertView;
    }

    private class ActionOnClick implements View.OnClickListener {
        private MyCalendar calendar;
        private Context context;
        public ActionOnClick(Context ctx, MyCalendar c){
            calendar = c;
            context = ctx;
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(ctx,EventsActivity.class);
            i.putExtra("calendar_id", calendar.getId());
            ctx.startActivity(i);
        }
    }
}
