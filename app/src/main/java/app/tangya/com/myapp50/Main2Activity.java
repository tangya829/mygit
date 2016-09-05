package app.tangya.com.myapp50;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.tangya.com.adapter.TourAdapter;
import app.tangya.com.base.db.AssetsDBManager;
import app.tangya.com.base.db.DBRead;
import app.tangya.com.entity.TourInfo;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    TourAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new TourAdapter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        into();
        adapter.clearDataToAdapter();
        adapter.addDataToAdapter(DBRead.readTeldbClasslist());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void into() {
        try {
            if (!DBRead.isExistFileToFile()) {
                AssetsDBManager.copyAssetsFileToFile(getApplicationContext(), "db/tour.db", DBRead.tofile);
            }
        } catch (Exception e) {

        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TourInfo info = (TourInfo) adapter.getItem(position);
        if (info.locality.equals("洋人街")) {
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
        }


        if (info.locality.equals("黑山谷")) {
            Intent intent1 = new Intent(Main2Activity.this, Main4Activity.class);
            startActivity(intent1);
        }

        if (info.locality.equals("武隆天坑三桥")) {
            Intent intent2 = new Intent(Main2Activity.this, Main5Activity.class);
            startActivity(intent2);
        }


        if (info.locality.equals("仙女山")) {
            Intent intent3 = new Intent(Main2Activity.this, Main6Activity.class);
            startActivity(intent3);
        }


        if (info.locality.equals("磁器口")) {
            Intent intent4 = new Intent(Main2Activity.this, Main7Activity.class);
            startActivity(intent4);
        }


    }
}
