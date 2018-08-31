package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

import luhut.belajar.jepang.com.belajarjepang.R;

public class KatakanaActivity extends AppCompatActivity {

    ScrollView mParentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana);

        this.init();
    }

    private void init(){

        mParentView = findViewById(R.id.katakana_parent_view);

        getSupportActionBar();
        getSupportActionBar().setTitle(getResources().getString(R.string.home_katakana));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent myIntent = new Intent(this, HomeActivity.class);
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
