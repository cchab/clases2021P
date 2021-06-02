package chab.demos.providercalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.mtp.MtpEvent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class EventsActivity extends AppCompatActivity {
    public static final String[] EVENT_PROJECTION = new String[]{
            CalendarContract.Events._ID,                           // 0
            CalendarContract.Events.TITLE,                  // 1
            CalendarContract.Events.ORGANIZER,         // 2
            CalendarContract.Events.DTSTART,                // 3
            CalendarContract.Events.EVENT_TIMEZONE      //4
    };

    // The indices for the projection array above.
    private static final int PROJECTION_ID_INDEX = 0;
    private static final int PROJECTION_TITLE_INDEX = 1;
    private static final int PROJECTION_ORGANIZER_INDEX = 2;
    private static final int PROJECTION_DTSTART_INDEX = 3;
    private static final int PROJECTION_EVENT_TIMEZONE_INDEX = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        long c_id = (long)getIntent().getSerializableExtra("calendar_id");

    }

    public ArrayList<MyEvent> getEvents(long calendar_id) {

        Cursor cur = null;
        ContentResolver cr = getContentResolver();
        Uri uri = CalendarContract.Events.CONTENT_URI;
        String selection = CalendarContract.Events.CALENDAR_ID + " = ?";
        String[] selectionArgs = new String[] {String.valueOf(calendar_id)};

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {

            return null;
        }
        cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
        ArrayList<MyEvent> events = new ArrayList<>();
        while (cur.moveToNext()) {
            long eventID = 0;
            String title = null;
            String organizer = null;
            long date = 0;
            String timeZ = null;

            // Get the field values
            eventID = cur.getLong(PROJECTION_ID_INDEX);
            organizer = cur.getString(PROJECTION_ORGANIZER_INDEX);
            title = cur.getString(PROJECTION_TITLE_INDEX);
            date = cur.getLong(PROJECTION_DTSTART_INDEX);
            timeZ = cur.getString(PROJECTION_EVENT_TIMEZONE_INDEX);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(date);
            events.add(new MyEvent(eventID,title,organizer, c,timeZ));

        }
        return events;
    }


}
