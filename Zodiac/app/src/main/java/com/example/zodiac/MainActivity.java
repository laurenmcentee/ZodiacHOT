package com.example.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    //CONSTANTS
    final String DAYERROR = "Please enter a valid day";
    final String MONTHERROR = " Please enter a valid month";
    final String YEARERROR = "Please enter a valid year";
    final String BEGIN = "Please enter your birthday and then press validate to unlock your Zodiac";

    final int currYear = Calendar.getInstance().get(Calendar.YEAR);

    //VARIABLES
    int month = 0;
    int day = 0;
    int year = 0;
    int age = 0;
    String dayOfWeek;

    //WIDGETS
    EditText editTextMonth;
    EditText editTextDay;
    EditText editTextYear;

    Button buttonValidate;
    Button buttonClear;
    Button buttonZodiac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDay = findViewById(R.id.editTextDay);
        editTextMonth = findViewById(R.id.editTextMonth);
        editTextYear = findViewById(R.id.editTextYear);
        buttonClear = findViewById(R.id.buttonClear);
        buttonValidate = findViewById(R.id.buttonValidate);
        buttonZodiac = findViewById(R.id.buttonZodiac);

        Toast toast = Toast.makeText(getApplicationContext(),
                BEGIN, Toast.LENGTH_LONG);
        toast.show();

        buttonZodiac.setEnabled(false);

        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                month = Integer.parseInt(editTextMonth.getText().toString());
                day = Integer.parseInt(editTextDay.getText().toString());
                year = Integer.parseInt(editTextYear.getText().toString());

                if(month <= 0 || month > 12 )
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            MONTHERROR, Toast.LENGTH_LONG);
                    toast.show();
                    editTextMonth.setText("");
                    editTextMonth.requestFocus();
                }

                if(year < 1890 || year > currYear)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            YEARERROR, Toast.LENGTH_LONG);
                    toast.show();
                    editTextYear.setText("");
                    editTextYear.requestFocus();
                }

                boolean dayIsValid = false;
                dayIsValid = checkForValidDay(month);

                if(dayIsValid)
                {
                    buttonZodiac.setEnabled(true);

                    age = findAge(year);
                    dayOfWeek = findDayOfWeek();

                    String toastStr = "Date Validated. You are " + age + " years old and you were born on a " + dayOfWeek + ". Click Zodiac for your horoscope";

                    Toast toast = Toast.makeText(getApplicationContext(),
                            toastStr, Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            DAYERROR, Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });


        buttonZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String zodiac = calculateZodiac();

                Intent intent = new Intent(MainActivity.this, ZodiacActivity.class);
                intent.putExtra("zodiac", zodiac);
                startActivity(intent);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextMonth.setText("");
                editTextDay.setText("");
                editTextYear.setText("");
                editTextMonth.requestFocus();
                int month = 0;
                int day = 0;
                int year = 0;
                int age = 0;
            }
        });

    }

    public String calculateZodiac() {

        String sign="";
        if (month == 1) {
            if (day < 20)
                sign = "Capricorn";
            else
                sign = "Aquarius";
        } else if (month == 2) {
            if (day < 19)
                sign = "Aquarius";
            else
                sign = "Pisces";
        } else if(month == 3) {
            if (day < 21)
                sign = "Pisces";
            else
                sign = "Aries";
        } else if (month == 4) {
            if (day < 20)
                sign = "Aries";
            else
                sign = "Taurus";
        } else if (month == 5) {
            if (day < 21)
                sign = "Taurus";
            else
                sign = "Gemini";
        } else if( month == 6) {
            if (day < 21)
                sign = "Gemini";
            else
                sign = "Cancer";
        } else if (month == 7) {
            if (day < 23)
                sign = "Cancer";
            else
                sign = "Leo";
        } else if( month == 8) {
            if (day < 23)
                sign = "Leo";
            else
                sign = "Virgo";
        } else if (month == 9) {
            if (day < 23)
                sign = "Virgo";
            else
                sign = "Libra";
        } else if (month == 10) {
            if (day < 23)
                sign = "Libra";
            else
                sign = "Scorpio";
        } else if (month == 11) {
            if (day < 22)
                sign = "Scorpio";
            else
                sign = "Sagittarius";
        } else if (month == 12) {
            if (day < 22)
                sign = "Sagittarius";
            else
                sign ="Capricorn";
        }

        return sign;

    }

    public String findDayOfWeek() {
        String result = "";

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        Date date = calendar.getTime();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {
            case 1: {
               result = "Sunday";
               break;
            }
            case 2: {
                result = "Monday";
                break;
            }
            case 3: {
                result = "Tuesday";
                break;
            }
            case 4: {
                result = "Wednesday";
                break;
            }
            case 5: {
                result = "Thursday";
                break;
            }
            case 6: {
                result = "Friday";
                break;
            }
            case 7: {
                result = "Saturday";
                break;
            }
        }

        return result;
    }

    public int findAge(Integer y) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        Date date = calendar.getTime();

        Calendar now = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        if (dob.after(now)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }
        int year1 = now.get(Calendar.YEAR);
        int year2 = dob.get(Calendar.YEAR);
        int age = year1 - year2;
        int month1 = now.get(Calendar.MONTH);
        int month2 = dob.get(Calendar.MONTH);
        if (month2 > month1) {
            age--;
        } else if (month1 == month2) {
            int day1 = now.get(Calendar.DAY_OF_MONTH);
            int day2 = dob.get(Calendar.DAY_OF_MONTH);
            if (day2 > day1) {
                age--;
            }
        }

        return age;

    }

    public boolean checkForValidDay(Integer m) {
        boolean returnVar = false;
        //february
        if (m == 2) {
            if(day < 28 && day > 0) {
                returnVar = true;
            }
            else {
                returnVar = false;
            }
        }
        //april, june, sept, nov
        if (m == 4 || m == 6 ||
                m == 9 || m == 11) {
            if(day < 30 && day > 0) {
                returnVar = true;
            }
            else {
                returnVar = false;
            }
        }
        // jan, march, may, july, august, october, december
        if (m == 1 || m == 3 ||
                m == 5 || m == 7 || m == 8 ||
                m == 10 || m == 12) {
            if(day < 31 && day > 0) {
                returnVar = true;
            }
            else {
                returnVar = false;
            }
        }
        return returnVar;
    }






}

















