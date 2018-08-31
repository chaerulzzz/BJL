package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import luhut.belajar.jepang.com.belajarjepang.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    CardView mHomeMateri, mHomeHiragana, mHomeKatakana, mHomeBudaya, mHomeProfil;
    boolean doubleBackToExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.init();
    }

    private void init(){

        mHomeMateri = findViewById(R.id.home_materi);
        mHomeMateri.setOnClickListener(this);

        mHomeHiragana = findViewById(R.id.home_hiragana);
        mHomeHiragana.setOnClickListener(this);

        mHomeKatakana = findViewById(R.id.home_katakana);
        mHomeKatakana.setOnClickListener(this);

        mHomeBudaya = findViewById(R.id.home_budaya);
        mHomeBudaya.setOnClickListener(this);

        mHomeProfil = findViewById(R.id.home_profile);
        mHomeProfil.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mHomeMateri.equals(view)){
            Intent intent = new Intent(HomeActivity.this, MateriActivity.class);
            startActivity(intent);
        }else if(mHomeHiragana.equals(view)){
            Intent intent = new Intent(HomeActivity.this, HiraganaActivity.class);
            startActivity(intent);
        }else if(mHomeKatakana.equals(view)){
            Intent intent = new Intent(HomeActivity.this, KatakanaActivity.class);
            startActivity(intent);
        }else if(mHomeBudaya.equals(view)) {
            Intent intent = new Intent(HomeActivity.this, BudayaActivity.class);
            startActivity(intent);
        }else if(mHomeProfil.equals(view)){
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed(){
        if(doubleBackToExit){
            super.onBackPressed();
            Intent quit = new Intent(Intent.ACTION_MAIN);
            quit.addCategory(Intent.CATEGORY_HOME);
            quit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(quit);
            return;
        }

        this.doubleBackToExit = true;
        Toast.makeText(getApplicationContext(),"Tekan Sekali lagi jika anda ingin keluar dari aplikasi",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExit = false;
            }
        }, 2000);
    }
}
