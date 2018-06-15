package com.mytrendin.googlemapsapp;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class TableMainActivity extends AppCompatActivity {

    TableAdapter tableAdapter;
    ArrayList<TableModal> activeArray;
    int min = 20;
    int max = 35;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_main);

        final RecyclerView activeList = (RecyclerView) findViewById(R.id.rcv_table_list);
        activeList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        activeList.setLayoutManager(llm);
        activeList.setItemAnimator(new DefaultItemAnimator());
        final SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();


        Random r = new Random();
        int random_number = r.nextInt(max - min + 1) + min;
        activeArray = new ArrayList<>();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String restoredText = prefs.getString("TableId", null);
        if (restoredText != null) {
            if (prefs.getString("restaurant_name", null).equals(getIntent().getStringExtra("restaurant_name"))) {
                Toast.makeText(this, "You have reservation for table " + restoredText, Toast.LENGTH_SHORT).show();
            }
        }

        for (int i = 0; i < random_number; i++) {

            String m = Integer.toString(i + 1);
            if (restoredText != null) {
                if (m.equals(restoredText) && prefs.getString("restaurant_name", null).equals(getIntent().getStringExtra("restaurant_name"))) {
                    activeArray.add(new TableModal(m, "Reserved"));
                }
            }
            if ((i % 5 == 0)) {
                activeArray.add(new TableModal(m, "Reserved"));
            } else if ((i % 7 == 0)) {
                activeArray.add(new TableModal(m, "Booked"));
            } else {
                activeArray.add(new TableModal(m, "Available"));
            }
        }
        final TableAdapter table = new TableAdapter(this, activeArray);
        activeList.setAdapter(table);


        activeList.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        TableModal model = (TableModal) table.getItem(position);
                        //Log.d("testing","Name" + model.name);
                        //Toast.makeText(TableMainActivity.this, model.tableId + "\nTableId   " + activeArray.get(position).tableId, Toast.LENGTH_LONG).show();
                        if (model.status.equalsIgnoreCase("Available")) {
                            editor.putString("TableId", model.tableId);
                            editor.putString("restaurant_name", getIntent().getStringExtra("restaurant_name"));
                            editor.apply();
                            DisplayConfirmationDialog(view);


                            // finish();
                        } else if (model.status.equalsIgnoreCase("Booked")) {
                            Toast.makeText(TableMainActivity.this, "This table is currently booked", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(TableMainActivity.this, "This table is already reserved", Toast.LENGTH_LONG).show();
                        }

                    }
                }));


    }

    public void DisplayConfirmationDialog(View view) {

        // custom dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.confirmation_dialog);
        // set the custom dialog components - text, image and button
        //Button dialogButton = (Button) dialog.findViewById(R.drawable.okbutton);
        TextView confirmation = (TextView) findViewById(R.id.tv_confirmation);
        Button yes = (Button) dialog.findViewById(R.id.btn_yes);
        Button cancel = (Button) dialog.findViewById(R.id.btn_no);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //startActivity(new Intent(this,TableMainActivity.class);
            }
        });
        // if button is clicked, close the custom dialog
        yes.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TableMainActivity.this, "You have reserved a table for yourself", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

        dialog.show();
    }
}
