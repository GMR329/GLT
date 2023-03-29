package gmr.studios.glt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public void leftMenuClick(View v){
        Intent openLeftMenu = new Intent(MainActivity.this, LeftMenu.class);
        startActivity(openLeftMenu);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void rightMenuClick(View v){
        Intent openRightMenu = new Intent(MainActivity.this, RightMenu.class);
        startActivity(openRightMenu);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void bottomMenuClick(View v){
        Intent openBottomMenu = new Intent(MainActivity.this, BottomMenu.class);
        startActivity(openBottomMenu);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    public void makeRemindTag(String tag){
        String strRemind = savedRemind.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savedRemind.edit();
        preferencesEditor.putString("theRemind", tag);
        preferencesEditor.commit();
    }

    public void saveRemindButtons(View v){
        if(basicRemind.getText().length() > 0){
            makeRemindTag(basicRemind.getText().toString());
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(basicRemind.getWindowToken(),0);
        }
    }

    EditText basicRemind;
    private SharedPreferences savedRemind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicRemind = (EditText) findViewById(R.id.BasicRemind);
        savedRemind = getSharedPreferences("myRemind", MODE_PRIVATE);
        basicRemind.setText(savedRemind.getString("theRemind", "REMIND"));
        basicRemind.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}