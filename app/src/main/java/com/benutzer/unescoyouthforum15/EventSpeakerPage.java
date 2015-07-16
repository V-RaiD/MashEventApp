package com.benutzer.unescoyouthforum15;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;


public class EventSpeakerPage extends ActionBarActivity {
    Handler handleSpeakerDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displaySpeakerData();
        }
    };
    int eventId;
    String speakerName[];
    ListAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_speaker_page);

        //gathering data from past activity that was passed via intent extras
        Bundle bundle = getIntent().getExtras();
        eventId = ((Integer) bundle.get("eventId")).intValue();

        loadSpeakerList();
    }

    private void loadSpeakerList(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                database linking code and retrieval using eventId
                 */
                /*
                initialise speaker name list for retrieving name of speakers in an event
                 */
                speakerName = new String[]{"1","2", "3", "4"};
                handleSpeakerDisplay.sendEmptyMessage(0);
            }
        };
    }

    private void displaySpeakerData(){
        listAdapter = new SpeakerAdapter(this, speakerName, eventId);
        listView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_speaker_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
