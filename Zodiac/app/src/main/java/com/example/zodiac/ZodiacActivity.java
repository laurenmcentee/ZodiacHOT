package com.example.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ZodiacActivity extends AppCompatActivity {

    TextView textViewZodiac;
    TextView textViewDates;
    TextView textViewDesc;
    ImageView imageViewSign;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);

        textViewDates = findViewById(R.id.textViewDates);
        textViewDesc = findViewById(R.id.textViewDesc);
        textViewZodiac = findViewById(R.id.textViewZodiac);
        imageViewSign = findViewById(R.id.imageViewSign);
        buttonBack = findViewById(R.id.buttonBack);


        String[] signs = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
        //Sign Dates
        String aries = "March 21 ~ April 20";
        String taurus = "April 21 ~ May 20";
        String gemini = "May 21 ~ June 20";
        String cancer = "June 21 ~ July 22";
        String leo = "July 23 ~ August 22";
        String virgo = "August 23 ~ September 22";
        String libra = " September 23 ~ October 22";
        String scorpio = "October 23 ~ November 22";
        String sagittarius = "November 23 ~ December 21";
        String capricorn = "December 22 ~ January 19";
        String aquarius = "January 20 ~ February 19";
        String pisces = "February 20 ~ March 20";

        //sign descriptions
        String ariesDes = "The pioneer and trailblazer of the horoscope wheel, Aries energy helps us initiate, fight for our beliefs and fearlessly put ourselves out there.";
        String taurusDes = "The persistent provider of the horoscope family, Taurus energy helps us seek security, enjoy earthly pleasures and get the job done.";
        String geminiDes = "The most versatile and vibrant horoscope sign, Gemini energy helps us communicate, collaborate and fly our freak flags at full mast.";
        String cancerDes = "The natural nurturer of the horoscope wheel, Cancer energy helps us connect with our feelings, plant deep roots and feather our family nests.";
        String leoDes = "The drama queen and regal ruler of the horoscope clan, Leo energy helps us shine, express ourselves boldly and wear our hearts on our sleeves.";
        String virgoDes = "The masterful helper of the horoscope wheel, Virgo energy teaches us to serve, do impeccable work and prioritize wellbeing—of ourselves, our loved ones and the planet.";
        String libraDes = "The balanced beautifier of the horoscope family, Libra energy inspires us to seek peace, harmony and cooperation—and to do it with style and grace.";
        String scorpioDes = "The most intense and focused of the horoscope signs, Scorpio energy helps us dive deep, merge our superpowers and form bonds that are built to last.";
        String sagittariusDes = "The worldly adventurer of the horoscope wheel, Sagittarius energy inspires us to dream big, chase the impossible and take fearless risks.";
        String capricornDes = "The measured master planner of the horoscope family, Capricorn energy teaches us the power of structure and long-term goals.";
        String aquariusDes = "The mad scientist and humanitarian of the horoscope wheel, futuristic Aquarius energy helps us innovate and unite for social justice.";
        String piscesDes = "The dreamer and healer of the horoscope family, Pisces energy awakens compassion, imagination and artistry, uniting us as one.";


        Intent intent = getIntent();
        String zodiac = intent.getStringExtra("zodiac");

        if(zodiac != null)
        {
            if(zodiac.equals("Aries"))
            {
                imageViewSign.setImageResource(R.drawable.aries);
                textViewZodiac.setText(signs[0]);
                textViewDesc.setText(ariesDes);
                textViewDates.setText(aries);
            }
            if(zodiac.equals("Taurus"))
            {
                imageViewSign.setImageResource(R.drawable.taurus);
                textViewZodiac.setText(signs[1]);
                textViewDesc.setText(taurusDes);
                textViewDates.setText(taurus);

            }
            if(zodiac.equals("Gemini"))
            {
                imageViewSign.setImageResource(R.drawable.gemini);
                textViewZodiac.setText(signs[2]);
                textViewDesc.setText(geminiDes);
                textViewDates.setText(gemini);
            }
            if(zodiac.equals("Cancer"))
            {
                imageViewSign.setImageResource(R.drawable.cancer);
                textViewZodiac.setText(signs[3]);
                textViewDesc.setText(cancerDes);
                textViewDates.setText(cancer);
            }
            if(zodiac.equals("Leo"))
            {
                imageViewSign.setImageResource(R.drawable.leo);
                textViewZodiac.setText(signs[4]);
                textViewDesc.setText(leoDes);
                textViewDates.setText(leo);
            }
            if(zodiac.equals("Virgo"))
            {
                imageViewSign.setImageResource(R.drawable.pisces);
                textViewZodiac.setText(signs[5]);
                textViewDesc.setText(virgoDes);
                textViewDates.setText(virgo);
            }
            if(zodiac.equals("Libra"))
            {
                imageViewSign.setImageResource(R.drawable.libra);
                textViewZodiac.setText(signs[6]);
                textViewDesc.setText(libraDes);
                textViewDates.setText(libra);
            }
            if(zodiac.equals("Scorpio"))
            {
                imageViewSign.setImageResource(R.drawable.scorpio);
                textViewZodiac.setText(signs[7]);
                textViewDesc.setText(scorpioDes);
                textViewDates.setText(scorpio);
            }
            if(zodiac.equals("Sagittarius"))
            {
                imageViewSign.setImageResource(R.drawable.sagittarius);
                textViewZodiac.setText(signs[8]);
                textViewDesc.setText(sagittariusDes);
                textViewDates.setText(sagittarius);
            }
            if(zodiac.equals("Capricorn"))
            {
                imageViewSign.setImageResource(R.drawable.capricorn);
                textViewZodiac.setText(signs[9]);
                textViewDesc.setText(capricornDes);
                textViewDates.setText(capricorn);
            }
            if(zodiac.equals("Aquarius"))
            {
                imageViewSign.setImageResource(R.drawable.aquarius);
                textViewZodiac.setText(signs[10]);
                textViewDesc.setText(aquariusDes);
                textViewDates.setText(aquarius);
            }
            if(zodiac.equals("Pisces"))
            {
                imageViewSign.setImageResource(R.drawable.pisces);
                textViewZodiac.setText(signs[11]);
                textViewDesc.setText(pisces);
                textViewDates.setText(piscesDes);
            }
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
