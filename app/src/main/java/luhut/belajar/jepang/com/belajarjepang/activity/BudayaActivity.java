package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import luhut.belajar.jepang.com.belajarjepang.R;

public class BudayaActivity extends AppCompatActivity implements View.OnClickListener {

    CardView mBonOdori, mKaligragi, mUpacaraTeh, mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budaya);

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

        mVideo = findViewById(R.id.budaya_video);
        mVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mBonOdori.equals(view)){
            Intent intent = new Intent(BudayaActivity.this, PdfViewerActivity.class);
            intent.putExtra("pdf", "budaya_01.pdf");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BudayaActivity.this.startActivity(intent);
        }else if(mKaligragi.equals(view)){
            Intent intent = new Intent(BudayaActivity.this, PdfViewerActivity.class);
            intent.putExtra("pdf", "budaya_02.pdf");
            BudayaActivity.this.startActivity(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } else if(mUpacaraTeh.equals(view)){
            Intent intent = new Intent(BudayaActivity.this, PdfViewerActivity.class);
            intent.putExtra("pdf", "budaya_03.pdf");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BudayaActivity.this.startActivity(intent);
        } else if (mVideo.equals(view)) {
            Intent intent = new Intent(BudayaActivity.this, BudayaListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BudayaActivity.this.startActivity(intent);
        }
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

    @Override
    public void onBackPressed(){
        Intent myIntent = new Intent(this, HomeActivity.class);
        startActivity(myIntent);
    }
}
