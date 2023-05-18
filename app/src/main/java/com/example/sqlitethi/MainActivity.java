package com.example.sqlitethi;





import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {
    private SQLiteTaxi dbHelper;
    private AdapterTaxi adapter;

    ListView listView;
    ModelTaxi taxi;
    ModelTaxi taxi1;
    ModelTaxi taxi2;
    ModelTaxi taxi3;
    ModelTaxi taxi4;
    ModelTaxi taxi5;
    ArrayList<ModelTaxi> tax = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taxi = new ModelTaxi(01, "17-B7 1234", 20, 21000, 1);
        taxi1 = new ModelTaxi(02, "17-B3 32824", 20, 21000, 1);
        taxi2 = new ModelTaxi(03, "17-B6 12324", 20, 2100, 1);
        taxi3 = new ModelTaxi(04, "16-B2 4123", 20, 21000, 1);
        taxi4 = new ModelTaxi(05, "19-B2 12348", 20, 21000, 1);
        taxi5 = new ModelTaxi(06, "11-B2 12981", 20, 21000, 1);
        dbHelper = new SQLiteTaxi(this);
        dbHelper.addTaxi(taxi);
        dbHelper.addTaxi(taxi1);
        dbHelper.addTaxi(taxi2);
        dbHelper.addTaxi(taxi3);
        dbHelper.addTaxi(taxi4);
        dbHelper.addTaxi(taxi5);

        tax = (ArrayList<ModelTaxi>) dbHelper.getAllTaxi();
        SortByID(tax);
        adapter = new AdapterTaxi(tax, this);
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                return true; // Return 'true' to consume the event and prevent further handling
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_onclick, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.edititem:
                // Handle option 1
                return true;
            case R.id.deleteitem:
                // Handle option 2
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    public void SortByID(ArrayList<ModelTaxi> dataList) {
        Collections.sort(dataList, new Comparator<ModelTaxi>() {
            @Override
            public int compare(ModelTaxi s1, ModelTaxi s2) {
                return s1.getSoxe().compareTo(s2.getSoxe()); // Sắp xếp theo thứ tự tăng dần
            }
        });
    }
}
