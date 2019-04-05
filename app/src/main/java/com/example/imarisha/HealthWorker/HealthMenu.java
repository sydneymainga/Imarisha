package com.example.imarisha.HealthWorker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imarisha.R;

public class HealthMenu extends AppCompatActivity {

    private GridView menugrid;
    //add the various activities of a Health worker
    private String[] captions = new String[]{"Report a Case","Request Emergency"};
    //match with  the captions to create a grid view
    private int [] images = new int[]{R.drawable.bell,R.drawable.phone};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthmenu);
        initView();


    }

    private void initView() {
        menugrid = (GridView) findViewById(R.id.menugrid);
        menugrid.setAdapter(new GridAdapter());
        menugrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(HealthMenu.this,ReportCase.class));
                        break;
                }
            }
        });
    }

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return captions.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.menu_grid_item, viewGroup, false);
                ImageView imageView = view.findViewById(R.id.menuimage);
                imageView.setImageResource(images[i]);
                TextView txtcaption = view.findViewById(R.id.menucaption);
                txtcaption.setText(captions[i]);
            }
            return view;
        }


    }
}
