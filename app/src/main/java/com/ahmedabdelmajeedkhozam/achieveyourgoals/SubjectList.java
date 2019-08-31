package com.ahmedabdelmajeedkhozam.achieveyourgoals;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;


import java.util.ArrayList;


public class SubjectList extends AppCompatActivity {

    ListView listView;
    ArrayList<Data> arraylist = new ArrayList<>();
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);

        listView = (ListView) findViewById(R.id.listviewid);

        String[] AndRody_Subject = {getString(R.string.TEXT1), getString(R.string.TEXT2), getString(R.string.TEXT3)};
        Integer[] AndRody_Part = {R.string.TEXT11, R.string.TEXT22, R.string.TEXT33};
        Integer[] AndRody_Text = {R.string.TEXT111, R.string.TEXT222, R.string.TEXT333};

        for (int i = 0; i < AndRody_Subject.length; i++) {
            Data abboudi = new Data(AndRody_Subject[i], AndRody_Part[i], AndRody_Text[i]);
            arraylist.add(abboudi);
        }
        adapter = new ListAdapter(this, arraylist);

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_serch, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);

                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);

                return true;
            }
        };
        searchView.setOnQueryTextListener(textChangeListener);

        return super.onCreateOptionsMenu(menu);
    }
}
