package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import luhut.belajar.jepang.com.belajarjepang.R;

public class PdfViewerActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {

    private PDFView pdfView;
    private Integer pageNumber = 0;
    private String pdfFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_detail);

        this.init();
    }

    private void init(){

        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.pdfView = findViewById(R.id.materi_detail_pdf_view);

        Intent intent = getIntent();

        if(intent!=null){
            String filename = intent.getStringExtra("pdf");

            if(filename!=null){
                displayFromAsset(filename);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(pdfFileName.contains("materi")) {
                    Intent myIntent = new Intent(this, MateriActivity.class);
                    startActivity(myIntent);
                    return true;
                }else if(pdfFileName.contains("budaya")){
                    Intent myIntent = new Intent(this, BudayaActivity.class);
                    startActivity(myIntent);
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;

        if(pdfFileName.contains("materi")) {
            this.setTitle(getResources().getString(R.string.home_materi));
        }else if(pdfFileName.contains("budaya")){
            this.setTitle(getResources().getString(R.string.home_budaya));
        }
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
    }
}
