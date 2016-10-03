package edu.orangecoastcollege.cs273.dnovasky.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    public static final String TITLE_TAG = "Title";
    public static final String DETAILS_TAG = "Details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the adapter (which binds the ListView wth data in MusicEvent.java)
        // Since the data is an array we use an ArrayAdapter

        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, MusicEvent.titles));

        //setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id) {
        // 1) Get the position, get the title, get the details
        String title = MusicEvent.titles[pos];
        String details = MusicEvent.details[pos];

        // 2) Make a new intent.
        Intent intent = new Intent(this, EventDetailsActivity.class);

        // 3) Put the necessary Strings into the intent
        intent.putExtra(TITLE_TAG, title)
                .putExtra(DETAILS_TAG, details);

        // 4) Start the intent
        startActivity(intent);
    }
}
