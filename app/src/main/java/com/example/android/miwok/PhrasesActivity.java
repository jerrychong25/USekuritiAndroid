package com.example.android.miwok;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.Manifest.permission.CALL_PHONE;

public class PhrasesActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an arrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Encik Ali", "A-1-1", "0166581019"));
//        words.add(new Word("Mr Sundram","A-2-1", "0166581019"));
//        words.add(new Word("Encik Mohd","A-3-1", "0166581019"));
        words.add(new Word("Ms Jocelyn","B-1-1", "0175561642"));
//        words.add(new Word("Mr Yong","B-2-1", "0175561642"));
//        words.add(new Word("Ms Lim","B-3-1", "0175561642"));
        words.add(new Word("Cik Wahidah","C-1-1", "0132843154"));
//        words.add(new Word("Mr Raj","C-2-1", "0132843154"));
//        words.add(new Word("Mr Lee","C-3-1", "0132843154"));

        WordAdapter adapter = new WordAdapter(this, words);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long id) {
                Log.d("PhrasesActivity", "onCreate, position: " + position);
//                Log.d("PhrasesActivity", "onCreate, listView.getItemAtPosition(position).toString(): " + listView.getItemAtPosition(position).toString());
//                makePhoneCall(listView.getItemAtPosition(position).toString());

//                Log.d("PhrasesActivity", "onCreate, listView.getAdapter().getItem(position).toString(): " + listView.getAdapter().getItem(position).toString());
//                makePhoneCall(listView.getAdapter().getItem(position).toString());

//                HashMap<String, Object> obj = (HashMap<String, Object>) adapter.getItem(position);
//                String name = (String) obj.get("name");
                if( (position==0) )
                {
                    makePhoneCall("0166581019");
                }
                else if( (position==1) )
                {
                    makePhoneCall("0175561642");
                }
                else if( (position==2) )
                {
                    makePhoneCall("0132843154");
                }

            }

        });

//        TextView unit_A_1_1 = (TextView)findViewById(R.id.phrases);
//
//        unit_A_1_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // creat new intent for open (( PhrasesActivity
//                Intent phrasesIntent = new Intent(MainActivity.this,PhrasesActivity.class);
//                // Start to new Activity
//                startActivity(phrasesIntent);
//            }
//        });
    }

    private void makePhoneCall(String number) {

        Log.d("PhrasesActivity", "makePhoneCall, number: " + number);

        if (number.trim().length() > 0) {

            Log.d("PhrasesActivity", "makePhoneCall 1");

            if (ContextCompat.checkSelfPermission(PhrasesActivity.this,
                    CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                Log.d("PhrasesActivity", "makePhoneCall 2");

                ActivityCompat.requestPermissions(PhrasesActivity.this,
                        new String[]{CALL_PHONE}, REQUEST_CALL);
            } else {

                Log.d("PhrasesActivity", "makePhoneCall 3");

                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Log.d("PhrasesActivity", "makePhoneCall 4");

            Toast.makeText(PhrasesActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                makePhoneCall();
//            } else {
//                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
