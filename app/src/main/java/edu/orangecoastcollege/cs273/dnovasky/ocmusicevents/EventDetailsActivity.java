package edu.orangecoastcollege.cs273.dnovasky.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView mEventImageView;
    private TextView mTitleTextView;
    private TextView mDetailsTextView;

    // In order to use AssetManager, need to know context
    private Context context = (Context)
this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra(EventListActivity.TITLE_TAG);
        String details = detailsIntent.getStringExtra(EventListActivity.DETAILS_TAG);
        String imageFileName = title.replace(" ", "") + ".jpeg";

        mEventImageView = (ImageView) findViewById(R.id.imageView);
        mTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        mDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);

        // Load the image from the Assets folder using the AssetManager class
        AssetManager am = context.getAssets();
        // Try to load the image file
        try
        {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            mEventImageView.setImageDrawable(image);
        }
        catch(IOException e) {
            Log.e("OC Music Events", "Cannot Load image: " + imageFileName + e);
        }

        mTitleTextView.setText(title);
        mDetailsTextView.setText(details);
    }
}
