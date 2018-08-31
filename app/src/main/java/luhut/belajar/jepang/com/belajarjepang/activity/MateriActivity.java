package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import luhut.belajar.jepang.com.belajarjepang.R;
import luhut.belajar.jepang.com.belajarjepang.adapter.MenuAdapter;
import luhut.belajar.jepang.com.belajarjepang.model.MenuModel;

public class MateriActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<MenuModel> menuList = new ArrayList<>();
    private MenuAdapter mAdapter;
    private MediaPlayer md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        this.init();
    }

    private void init() {
        getSupportActionBar();
        getSupportActionBar().setTitle(getResources().getString(R.string.home_materi));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        md = new MediaPlayer();

        mRecyclerView = findViewById(R.id.materi_recycler_view);

        mAdapter = new MenuAdapter(menuList, new MenuAdapter.onItemClickListener() {
            @Override
            public void onItemClick(MenuModel menu) {
                Intent intent = new Intent(MateriActivity.this, PdfViewerActivity.class);
                intent.putExtra("pdf", menu.getCodePdf() + ".pdf");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MateriActivity.this.startActivity(intent);
            }
        }, new MenuAdapter.onSpeakerClicked() {
            @Override
            public void onSpeakerClick(String code, boolean clicked) {
                try {
                    AssetFileDescriptor afd = getAssets().openFd(code + ".mp3");

                    if(md != null) {
                        md.stop();
                        md.release();
                    }

                    md = new MediaPlayer();
                    md.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    md.prepare();
                    md.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setAdapter(mAdapter);

        prepareMenu();
    }

    private void prepareMenu(){
        MenuModel menu = new MenuModel("Pelajaran 1", "Hajimemashite", getResources().getDrawable(R.drawable.materi_01), "materi_01", "01");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 2", "Kore wa Nan desu ka ", getResources().getDrawable(R.drawable.materi_02), "materi_02", "02");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 3", "Toire wa Doko desu ka", getResources().getDrawable(R.drawable.materi_03), "materi_03", "03");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 4", "Tadaima", getResources().getDrawable(R.drawable.materi_04), "materi_04", "04");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 5", "Sore wa Watashi no takaramono desu", getResources().getDrawable(R.drawable.materi_05), "materi_05", "05");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 6", "Denwa Bango", getResources().getDrawable(R.drawable.materi_06), "materi_06", "06");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 7", "Shuukuriimu wa arimasu ka", getResources().getDrawable(R.drawable.materi_07), "materi_07", "07");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 8", "Mouichido Onegai Shimasu", getResources().getDrawable(R.drawable.materi_08), "materi_08", "08");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 9", "Nanji kara desu ka", getResources().getDrawable(R.drawable.materi_09), "materi_09", "09");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 10", "Zen-in imasu ka", getResources().getDrawable(R.drawable.materi_10), "materi_10", "10");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 11", "Zehi kite kudasai", getResources().getDrawable(R.drawable.materi_11), "materi_11", "11");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 12", "Itsu Nihon ni kimashita ka", getResources().getDrawable(R.drawable.materi_12), "materi_12", "12");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 13", "Shousetsu ga suki desu", getResources().getDrawable(R.drawable.materi_13), "materi_13", "13");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 14", "Koko ni gomi o sutete mo ii desu ka", getResources().getDrawable(R.drawable.materi_14), "materi_14", "14");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 15", "Nete imasu", getResources().getDrawable(R.drawable.materi_15), "materi_15", "15");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 16", "Kaidan o agette, migi ni itte kudasai", getResources().getDrawable(R.drawable.materi_16), "materi_16", "16");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 17", "Osusume wa nan desu ka", getResources().getDrawable(R.drawable.materi_17), "materi_17", "17");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 18", "Michi ni mayotte shimashita", getResources().getDrawable(R.drawable.materi_18), "materi_18", "18");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 19", "Yokatta", getResources().getDrawable(R.drawable.materi_19), "materi_19", "19");
        menuList.add(menu);

        menu = new MenuModel("Pelajaran 20", "Nihon no uta o utatta koto ga arimasu ka", getResources().getDrawable(R.drawable.materi_20), "materi_20", "20");
        menuList.add(menu);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(MateriActivity.this, HomeActivity.class);
                startActivity(intent);
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


    @Override
    protected void onPause() {
        super.onPause();

        if(md.isPlaying()){
            md.stop();
            md.release();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(md.isPlaying()){
            md.stop();
            md.release();
        }
    }
}
