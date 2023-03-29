package gmr.studios.glt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.SharedPreferences;

public class LeftMenu extends AppCompatActivity {
    ImageView subEvents;
    ImageView subSchedule;
    TextView scheduleText;
    TextView eventsText;
    HorizontalScrollView dayScroller;
    Button save;

    EditText monday;
    EditText tuesday;
    EditText wednesday;
    EditText thursday;
    EditText friday;
    EditText saturday;
    EditText sunday;
    EditText events;

    int mainColor = 0xFF004CFF;
    int notHighlighted = 0xFF0A141E;

    public void lMainMenuClick(View v){
        Intent openMainMenu = new Intent(LeftMenu.this, MainActivity.class);
        startActivity(openMainMenu);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        if(events.getText().length() > 0){
            makeEventsTag(events.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(events.getWindowToken(),0);
        } //events
        if(monday.getText().length() > 0){
            makeMondayTag(monday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(monday.getWindowToken(), 0);
        } //monday
        if(friday.getText().length() > 0){
            makeFridayTag(friday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(friday.getWindowToken(), 0);
        } //friday
        if(tuesday.getText().length() > 0){
            makeTuesdayTag(tuesday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(tuesday.getWindowToken(), 0);
        } //tuesday
        if(wednesday.getText().length() > 0){
            makeWednesdayTag(wednesday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(wednesday.getWindowToken(), 0);
        } //wednesday
        if(thursday.getText().length() > 0){
            makeThursdayTag(thursday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(thursday.getWindowToken(), 0);
        } //thursday
        if(saturday.getText().length() > 0){
            makeSaturdayTag(saturday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(saturday.getWindowToken(), 0);
        } //saturday
        if(sunday.getText().length() > 0){
            makeSundayTag(sunday.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(sunday.getWindowToken(), 0);
        } //sunday

    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void subEventsClick(View v){
        subEvents.setColorFilter(mainColor);
        subSchedule.setColorFilter(notHighlighted);
        scheduleText.setVisibility(View.GONE);
        eventsText.setVisibility(View.VISIBLE);
        events.setVisibility(View.VISIBLE);
        dayScroller.setVisibility(View.GONE);

    }

    public void subScheduleClick(View v){
        subSchedule.setColorFilter(mainColor);
        subEvents.setColorFilter(notHighlighted);
        eventsText.setVisibility(View.GONE);
        scheduleText.setVisibility(View.VISIBLE);
        events.setVisibility(View.GONE);
        dayScroller.setVisibility(View.VISIBLE);
    }

    public void saveClick(View v){
        if(events.getText().length() > 0){
            makeEventsTag(events.getText().toString());

            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(events.getWindowToken(),0);
        }
    }

    public void makeEventsTag(String tag){
        String strEvents = savedEvents.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedEvents.edit();
        preferencesEditor.putString("theEvents", tag);
        preferencesEditor.commit();
    }

    public void makeMondayTag(String tag){
        String strMonday = savedMonday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedMonday.edit();
        preferencesEditor.putString("theMonday", tag);
        preferencesEditor.commit();
    }

    public void makeFridayTag(String tag){
        String strFriday = savedFriday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedFriday.edit();
        preferencesEditor.putString("theFriday", tag);
        preferencesEditor.commit();
    }

    public void makeTuesdayTag(String tag){
        String strTuesday = savedTuesday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedTuesday.edit();
        preferencesEditor.putString("theTuesday", tag);
        preferencesEditor.commit();
    }

    public void makeWednesdayTag(String tag){
        String strWednesday = savedWednesday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedWednesday.edit();
        preferencesEditor.putString("theWednesday", tag);
        preferencesEditor.commit();
    }

    public void makeThursdayTag(String tag){
        String strThursday = savedThursday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedThursday.edit();
        preferencesEditor.putString("theThursday", tag);
        preferencesEditor.commit();
    }

    public void makeSaturdayTag(String tag){
        String strSaturday = savedSaturday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedSaturday.edit();
        preferencesEditor.putString("theSaturday", tag);
        preferencesEditor.commit();
    }

    public void makeSundayTag(String tag){
        String strSunday = savedSunday.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedSunday.edit();
        preferencesEditor.putString("theSunday", tag);
        preferencesEditor.commit();
    }



    private SharedPreferences savedEvents;
    private SharedPreferences savedMonday;
    private SharedPreferences savedTuesday;
    private SharedPreferences savedWednesday;
    private SharedPreferences savedThursday;
    private SharedPreferences savedFriday;
    private SharedPreferences savedSaturday;
    private SharedPreferences savedSunday;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_menu);

        subSchedule = (ImageView) findViewById(R.id.subSchedule);
        subEvents = (ImageView) findViewById(R.id.subEvents);
        scheduleText = (TextView) findViewById(R.id.scheduleText);
        eventsText = (TextView) findViewById(R.id.eventsText);
        dayScroller = (HorizontalScrollView) findViewById(R.id.DayScroller);
        save = (Button) findViewById(R.id.saveButton);

        monday = (EditText) findViewById(R.id.Monday);
        tuesday = (EditText) findViewById(R.id.Tuesday);
        wednesday = (EditText) findViewById(R.id.Wednesday);
        thursday = (EditText) findViewById(R.id.Thursday);
        friday = (EditText) findViewById(R.id.Friday);
        saturday = (EditText) findViewById(R.id.Saturday);
        sunday = (EditText) findViewById(R.id.Sunday);
        events = (EditText) findViewById(R.id.events);

        savedEvents = getSharedPreferences("myEvents", MODE_PRIVATE);
        events.setText(savedEvents.getString("theEvents", "Events:"));

        savedMonday = getSharedPreferences("myMonday", MODE_PRIVATE);
        monday.setText(savedMonday.getString("theMonday", "MONDAY"));
        monday.setGravity(Gravity.CENTER_HORIZONTAL);

        savedFriday = getSharedPreferences("myFriday", MODE_PRIVATE);
        friday.setText(savedFriday.getString("theFriday", "FRIDAY"));
        friday.setGravity(Gravity.CENTER_HORIZONTAL);

        savedTuesday = getSharedPreferences("myTuesday", MODE_PRIVATE);
        tuesday.setText(savedTuesday.getString("theTuesday", "TUESDAY"));
        tuesday.setGravity(Gravity.CENTER_HORIZONTAL);

        savedWednesday = getSharedPreferences("myWednesday", MODE_PRIVATE);
        wednesday.setText(savedWednesday.getString("theWednesday", "WEDNESDAY"));
        wednesday.setGravity(Gravity.CENTER_HORIZONTAL);

        savedThursday = getSharedPreferences("myThursday", MODE_PRIVATE);
        thursday.setText(savedThursday.getString("theThursday", "THURSDAY"));
        thursday.setGravity(Gravity.CENTER_HORIZONTAL);

        savedSaturday = getSharedPreferences("mySaturday", MODE_PRIVATE);
        saturday.setText(savedSaturday.getString("theSaturday", "SATURDAY"));
        saturday.setGravity(Gravity.CENTER_HORIZONTAL);

        savedSunday = getSharedPreferences("mySunday", MODE_PRIVATE);
        sunday.setText(savedSunday.getString("theSunday", "SUNDAY"));
        sunday.setGravity(Gravity.CENTER_HORIZONTAL);
    } //close method onCreate
}
