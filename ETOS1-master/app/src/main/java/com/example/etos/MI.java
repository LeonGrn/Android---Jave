package com.example.etos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class MI extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;

    Button button1;
    Button button2;
    Button button3;
    Button button4;


    public void clickButton(final View view)
    {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.amharic1);

        button1.setOnClickListener(new View.OnClickListener() {
            public String getSpinnerText(){
                return spinner.getSelectedItem().toString();
            }
            @Override
            public void onClick(View v) {
                switch(getSpinnerText()){
                    case "אנגלית":

                        break;
                    case "רוסית":
                        break;
                    case "אמהרית":
                        break;
                }
                mp.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        spinner = findViewById(R.id.spinnerIM);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void audioPlayer(String path, String fileName){
        //set up MediaPlayer
        MediaPlayer mp = new MediaPlayer();

        try {
            mp.setDataSource(path + File.separator + fileName);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void MI(String language,String option) {
        switch (language) {
            case "English":
                switch (option) {
                    case "Show me where it hurts":
                        audioPlayer("path", "ENshowhurts");
                        break;
                    case "What type of pain":
                        audioPlayer("path", "ENtypepain");
                        break;
                    case "When did the pain start":
                        audioPlayer("path", "ENpainstart");
                        break;
                    case "Does the pain change when breathing":
                        audioPlayer("path", "ENpainchange");
                        break;
                }
                break;
            case "Russian":
                switch (option) {
                    case "Show me where it hurts":
                        audioPlayer("path", "RUshowhurts");
                        break;
                    case "What type of pain":
                        audioPlayer("path", "RUtypepain");
                        break;
                    case "When did the pain start":
                        audioPlayer("path", "RUpainstart");
                        break;
                    case "Does the pain change when breathing":
                        audioPlayer("path", "RUpainchange");
                        break;
                }
                break;
            case "Amarit":
                switch (option) {
                    case "Show me where it hurts":
                        audioPlayer("path", "AMshowhurts");
                        break;
                    case "What type of pain":
                        audioPlayer("path", "AMtypepain");
                        break;
                    case "When did the pain start":
                        audioPlayer("path", "AMpainstart");
                        break;
                    case "Does the pain change when breathing":
                        audioPlayer("path", "AMpainchange");
                        break;
                }
                break;
        }
    }
}