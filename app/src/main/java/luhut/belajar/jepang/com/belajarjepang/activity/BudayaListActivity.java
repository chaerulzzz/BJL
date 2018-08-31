package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import luhut.belajar.jepang.com.belajarjepang.BudayaVideoActivity;
import luhut.belajar.jepang.com.belajarjepang.R;

public class BudayaListActivity extends AppCompatActivity implements View.OnClickListener{
    CardView mBonOdori, mKaligragi, mUpacaraTeh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budaya_list_video);

        this.init();
    }

    private void init(){

        getSupportActionBar();
        getSupportActionBar().setTitle(getResources().getString(R.string.home_budaya));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBonOdori = findViewById(R.id.budaya_bon_odori);
        mBonOdori.setOnClickListener(this);

        mKaligragi = findViewById(R.id.budaya_kaligrafi);
        mKaligragi.setOnClickListener(this);

        mUpacaraTeh = findViewById(R.id.budaya_upacara);
        mUpacaraTeh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mBonOdori.equals(view)){
            Intent intent = new Intent(BudayaListActivity.this, BudayaVideoActivity.class);
            intent.putExtra("video", "budaya_01");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BudayaListActivity.this.startActivity(intent);
        }else if(mKaligragi.equals(view)){
            Intent intent = new Intent(BudayaListActivity.this, BudayaVideoActivity.class);
            intent.putExtra("video", "budaya_02");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BudayaListActivity.this.startActivity(intent);
        } else if(mUpacaraTeh.equals(view)){
            Intent intent = new Intent(BudayaListActivity.this, BudayaVideoActivity.class);
            intent.putExtra("video", "budaya_03");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BudayaListActivity.this.startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent myIntent = new Intent(this, BudayaActivity.class);
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed(){
        Intent myIntent = new Intent(this, HomeActivity.class);
        startActivity(myIntent);
    }
}

