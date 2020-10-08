package com.aurora.qeshmjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aurora.qeshmjob.Info.InfoJop;
import com.aurora.qeshmjob.Recycler.RecyclerAdapter_Jobs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MaterialSearchView.SearchViewListener {

    RecyclerView recyclerView;
    ArrayList<InfoJop> infoJops = new ArrayList<>();
    Toolbar toolbar;
    MaterialSearchView searchView;
    TextView txtTitle;
    ImageView imgRemoveTitle;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setRecycler();

        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setTitle("");

        searchView.setVoiceSearch(true);
        searchView.setOnSearchViewListener( this);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                txtTitle.setText("جستجوی "+query);
                imgRemoveTitle.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              //  toolbar.setTitle(newText);

                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_voice_btn:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fa");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent, 1010);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.search);
        searchView.setMenuItem(item);

        return true;
    }


    private void setRecycler() {
        InfoJop infoJop = new InfoJop();

        for (int i = 0; i < 10; i++) {
            infoJops.add(infoJop);
        }

        recyclerView.setAdapter(new RecyclerAdapter_Jobs(getApplicationContext(), infoJops, new RecyclerAdapter_Jobs.Clik_Item() {
            @Override
            public void Onrecived(InfoJop InfoJop) {

            }
        }));

    }

    public void init() {
        fab= (FloatingActionButton) findViewById(R.id.fab);
        //////////////////////
        imgRemoveTitle= (ImageView) findViewById(R.id.imgRemoveTitle);
        ////////////////////////////
        txtTitle= (TextView) findViewById(R.id.txtTitle);
        ///////////////////////
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        // set a GridLayoutManager with 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( requestCode == 1010) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
           // Toast.makeText(this,matches.get(0)+ "", Toast.LENGTH_SHORT).show();
          // mSearchView.setSearchFocused(true);
            searchView.showSearch();
            searchView.showKeyboard(searchView);
            searchView.setQuery(matches.get(0),false);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSearchViewShown() {

    }

    @Override
    public void onSearchViewClosed() {

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgRemoveTitle:
                txtTitle.setText("");
                searchView.setQuery("",true);
                imgRemoveTitle.setVisibility(View.INVISIBLE);
                break;
                case R.id.fab:

                    startActivity(new Intent(getApplicationContext(),InsertAdverticmend.class));
                break;
        }
    }
}
