package gmr.studios.glt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.SharedPreferences;

public class BottomMenu extends AppCompatActivity {
    ImageView subList;
    ImageView subNotes;
    ImageView subMisc;

    EditText listArea;
    EditText notesArea;
    EditText miscArea;

    int mainColor = 0xFF004CFF;
    int notHighlighted = 0xFF0A141E;

    public void bMainMenuClick(View v){
        Intent openMainMenu = new Intent(BottomMenu.this, MainActivity.class);
        startActivity(openMainMenu);
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);

        if(listArea.getText().length() > 0){
            makeListTag(listArea.getText().toString());

            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(listArea.getWindowToken(),0);
        }
        if(notesArea.getText().length() > 0){
            makeNotesTag(notesArea.getText().toString());

            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(notesArea.getWindowToken(),0);
        }
        if(miscArea.getText().length() > 0){
            makeMiscTag(miscArea.getText().toString());

            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(miscArea.getWindowToken(),0);
        }
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }

    public void subListClick(View v){
        subList.setColorFilter(mainColor);
        subNotes.setColorFilter(notHighlighted);
        subMisc.setColorFilter(notHighlighted);

        listArea.setVisibility(View.VISIBLE);
        notesArea.setVisibility(View.GONE);
        miscArea.setVisibility(View.GONE);
    }

    public void subNotesClick(View v){
        subList.setColorFilter(notHighlighted);
        subNotes.setColorFilter(mainColor);
        subMisc.setColorFilter(notHighlighted);

        listArea.setVisibility(View.GONE);
        notesArea.setVisibility(View.VISIBLE);
        miscArea.setVisibility(View.GONE);
    }

    public void subMiscClick(View v){
        subList.setColorFilter(notHighlighted);
        subNotes.setColorFilter(notHighlighted);
        subMisc.setColorFilter(mainColor);

        listArea.setVisibility(View.GONE);
        notesArea.setVisibility(View.GONE);
        miscArea.setVisibility(View.VISIBLE);
    }


    public void makeListTag(String tag){
        String strList = savedList.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedList.edit();
        preferencesEditor.putString("theList", tag);
        preferencesEditor.commit();
    }

    public void makeNotesTag(String tag){
        String strMonday = savedNotes.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedNotes.edit();
        preferencesEditor.putString("theNotes", tag);
        preferencesEditor.commit();
    }

    public void makeMiscTag(String tag){
        String strMonday = savedMisc.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedMisc.edit();
        preferencesEditor.putString("theMisc", tag);
        preferencesEditor.commit();
    }

    private SharedPreferences savedList;
    private SharedPreferences savedNotes;
    private SharedPreferences savedMisc;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.bottom_menu);

        subList = (ImageView) findViewById(R.id.subList);
        subNotes = (ImageView) findViewById(R.id.subNotes);
        subMisc = (ImageView) findViewById(R.id.subMisc);

        listArea = (EditText) findViewById(R.id.listArea);
        notesArea = (EditText) findViewById(R.id.notesArea);
        miscArea = (EditText) findViewById(R.id.miscArea);

        savedList = getSharedPreferences("myList", MODE_PRIVATE);
        listArea.setText(savedList.getString("theList", "List:"));

        savedNotes = getSharedPreferences("myNotes", MODE_PRIVATE);
        notesArea.setText(savedNotes.getString("theNotes", "Notes:"));

        savedMisc = getSharedPreferences("myMisc", MODE_PRIVATE);
        miscArea.setText(savedMisc.getString("theMisc", "Misc:"));
    }
}
