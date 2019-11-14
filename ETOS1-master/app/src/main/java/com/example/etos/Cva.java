package com.example.etos;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Cva extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Dialog epicDialog;
    Button returnBtn;
    TextView title, textMass;
    ImageView closeB;
    int [] arrSpinner ={R.string.eng, R.string.rus, R.string.amh};


    public void clickButton(final View view)
    {

        final MediaPlayer mpAmharic1 = MediaPlayer.create(this, R.raw.amharic1);
        final MediaPlayer mpAmharic3 = MediaPlayer.create(this, R.raw.amharic3);
        final MediaPlayer mpRussian1 = MediaPlayer.create(this, R.raw.russian1);
        final MediaPlayer mpRussian2 = MediaPlayer.create(this, R.raw.russian2);
        final MediaPlayer mpRussian3 = MediaPlayer.create(this, R.raw.russian3);
        final MediaPlayer mpRussian4 = MediaPlayer.create(this, R.raw.russian4);
        final MediaPlayer mpEnglish1 = MediaPlayer.create(this, R.raw.english1);
        final MediaPlayer mpEnglish2 = MediaPlayer.create(this, R.raw.english2);
        final MediaPlayer mpEnglish3 = MediaPlayer.create(this, R.raw.english3);
        final MediaPlayer mpEnglish4 = MediaPlayer.create(this, R.raw.english4);


        button1.setOnClickListener(new View.OnClickListener() {
            private String getSpinnerText(){

                return spinner.getSelectedItem().toString();
            }

            @Override
            public void onClick(View v) {
                switch(getSpinnerText()){
                    case "אנגלית":
                        mpEnglish3.start();
                        break;
                    case "רוסית":
                        mpRussian1.start();
                        break;
                    case "אמהרית":
                        mpAmharic3.start();
                        break;
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            private String getSpinnerText(){
                return spinner.getSelectedItem().toString();
            }
            @Override
            public void onClick(View v) {
                switch(getSpinnerText()){
                    case "אנגלית":
                        mpEnglish2.start();
                        break;
                    case "רוסית":
                        mpRussian2.start();
                        break;
                    case "אמהרית":

                        break;
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            private String getSpinnerText(){
                return spinner.getSelectedItem().toString();
            }

            private void showDialog(int lan){
                epicDialog.setContentView(R.layout.alert_counting10);
                closeB = epicDialog.findViewById(R.id.closePopup);
                returnBtn = epicDialog.findViewById(R.id.btnReturn);
                title = epicDialog.findViewById(R.id.titleTv);
                textMass = epicDialog.findViewById(R.id.textTv);

                switch (lan){
                    case 1:
                        textMass.setText("1. One\n2. Two\n3. Three\n4. Four\n5. Five\n6. Six\n7. Seven\n8. Eight\n9. Nine\n10. Ten");
                        break;
                    case 2:
                        textMass.setText("1. Odin\n2. Dva\n3. Tri\n4. Chetyre\n5. Pyat\n6. Shest\n7. Syem\n8. Vosem\n9. Devyat\n10. Desyat");
                        break;
                    case 3:
                        textMass.setText("1. Anidi\n2. Huleti\n3. Sositi \n4. Arati\n5. Amisiti\n6. Sidisiti \n7. Sebati\n8. Siminiti\n9. Zetenyi\n10. Asiri");
                    break;
                }

                returnBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        epicDialog.dismiss();
                    }
                });

                closeB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        epicDialog.dismiss();
                    }
                });
                epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                epicDialog.show();
            }

            @Override
            public void onClick(View v) {
                switch(getSpinnerText()){
                    case "אנגלית":
                        mpEnglish1.start();
                        showDialog(1);
                        break;
                    case "רוסית":
                        mpRussian3.start();
                        showDialog(2);
                        break;
                    case "אמהרית":
                        mpAmharic1.start();
                        showDialog(3);
                        break;
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            private String getSpinnerText(){
                return spinner.getSelectedItem().toString();
            }
            @Override
            public void onClick(View v) {
                switch(getSpinnerText()){
                    case "אנגלית":
                        mpEnglish4.start();
                        break;
                    case "רוסית":
                        mpRussian4.start();
                        break;
                    case "אמהרית":
                        break;
                }

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cva);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        epicDialog = new Dialog(this);



        spinner = findViewById(R.id.spinnerCVA);
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