package gmr.studios.glt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RightMenu extends AppCompatActivity {
    public void rMainMenuClick(View v){
        Intent openMainMenu = new Intent(RightMenu.this, MainActivity.class);
        startActivity(openMainMenu);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.right_menu);
    }
}
