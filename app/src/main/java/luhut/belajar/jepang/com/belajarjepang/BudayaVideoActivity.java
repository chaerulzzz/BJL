package luhut.belajar.jepang.com.belajarjepang;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import luhut.belajar.jepang.com.belajarjepang.activity.BudayaActivity;
import luhut.belajar.jepang.com.belajarjepang.activity.BudayaListActivity;

public class BudayaVideoActivity extends AppCompatActivity {

    private Intent intent;
    private VideoView videoView;
    private MediaController media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budaya_video);

        this.init();
    }

    private void init(){

        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();

        videoView = findViewById(R.id.budaya_video_1);

        if (intent != null) {
            String filename = intent.getStringExtra("video");

            if (filename.equalsIgnoreCase("budaya_01")) {
                getSupportActionBar().setTitle(getResources().getString(R.string.budaya_bon_odori));
                String path = "android.resource://" + getPackageName() + "/" + R.raw.budaya_01;
                videoView.setVideoURI(Uri.parse(path));

                MediaController mediaController = new MediaController(this);
                mediaController.setAnchorView(videoView);
                videoView.setMediaController(mediaController);
                videoView.start();
            } else if (filename.equalsIgnoreCase("budaya_03")) {
                getSupportActionBar().setTitle(getResources().getString(R.string.budaya_upacara));
                String path = "android.resource://" + getPackageName() + "/" + R.raw.budaya_03;
                videoView.setVideoURI(Uri.parse(path));

                MediaController mediaController = new MediaController(this);
                mediaController.setAnchorView(videoView);
                videoView.setMediaController(mediaController);
                videoView.start();
            } else if (filename.equalsIgnoreCase("budaya_02")) {
                getSupportActionBar().setTitle(getResources().getString(R.string.budaya_kaligrafi));
                String path = "android.resource://" + getPackageName() + "/" + R.raw.budaya_02;
                videoView.setVideoURI(Uri.parse(path));

                MediaController mediaController = new MediaController(this);
                mediaController.setAnchorView(videoView);
                videoView.setMediaController(mediaController);
                videoView.start();
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent myIntent = new Intent(this, BudayaListActivity.class);
                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
