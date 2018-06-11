package com.example.android.spacequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This app quizzes the user about space and displays the results in a toast message when the Submit button is clicked.
 * A Reset button is available if the user wants to try again.
 */
public class MainActivity extends AppCompatActivity {

    int score = 0;
    boolean isSubmitted;
    boolean secondAnswer;
    boolean thirdAnswer;
    boolean fourthAnswer;
    boolean fifthAnswer;
    boolean sixthAnswer;
    boolean seventhAnswer;

    EditText planetName;
    RadioGroup radioGroupTwo;
    RadioGroup radioGroupThree;
    RadioGroup radioGroupFour;
    RadioGroup radioGroupFive;
    RadioGroup radioGroupSix;
    RadioButton everest;
    RadioButton ninety;
    RadioButton jupiterOne;
    RadioButton correct;
    RadioButton noSound;
    CheckBox nature;
    CheckBox music;
    CheckBox narration;
    CheckBox pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetName = (EditText) findViewById(R.id.planet_view);
        radioGroupTwo = (RadioGroup) findViewById(R.id.radio_group_two);
        radioGroupThree = (RadioGroup) findViewById(R.id.radio_group_three);
        radioGroupFour = (RadioGroup) findViewById(R.id.radio_group_four);
        radioGroupFive = (RadioGroup) findViewById(R.id.radio_group_five);
        radioGroupSix = (RadioGroup) findViewById(R.id.radio_group_six);
        everest = (RadioButton) findViewById(R.id.everest_radio_button);
        ninety = (RadioButton) findViewById(R.id.ninety_radio_button);
        jupiterOne = (RadioButton) findViewById(R.id.jupiter_one_radio_button);
        correct = (RadioButton) findViewById(R.id.correct_radio_button);
        noSound = (RadioButton) findViewById(R.id.no_radio_button);
        nature = (CheckBox) findViewById(R.id.nature_check_box);
        music = (CheckBox) findViewById(R.id.music_check_box);
        pictures = (CheckBox) findViewById(R.id.pictures_check_box);
        narration = (CheckBox) findViewById(R.id.narration_check_box);

        isSubmitted = false;
        secondAnswer = false;
        thirdAnswer = false;
        fourthAnswer = false;
        fifthAnswer = false;
        sixthAnswer = false;
        seventhAnswer = false;
    }

    /**
     * Saves score data when screen is rotated.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreData", score);
        outState.putBoolean("submit", isSubmitted);
        outState.putBoolean("secondAnswer", secondAnswer);
        outState.putBoolean("thirdAnswer", thirdAnswer);
        outState.putBoolean("fourthAnswer", fourthAnswer);
        outState.putBoolean("fifthAnswer", fifthAnswer);
        outState.putBoolean("sixthAnswer", sixthAnswer);
        outState.putBoolean("seventhAnswer", seventhAnswer);
    }

    /*
     * Restores score data after screen rotation.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("scoreData");
        isSubmitted = savedInstanceState.getBoolean("submit");
        secondAnswer = savedInstanceState.getBoolean("secondAnswer");
        thirdAnswer = savedInstanceState.getBoolean("thirdAnswer");
        fourthAnswer = savedInstanceState.getBoolean("fourthAnswer");
        fifthAnswer = savedInstanceState.getBoolean("fifthAnswer");
        sixthAnswer = savedInstanceState.getBoolean("sixthAnswer");
        seventhAnswer = savedInstanceState.getBoolean("seventhAnswer");
    }

    /**
     * Question 2: Radio Button
     * Correct answer: #2 (Mount Everest)
     */
    public void onSecondQuestionClicked(View view) {
        if (everest.isChecked()) {
            secondAnswer = true;
        }
    }

    /**
     * Question 3: Radio Button
     * Correct answer: #1 (90 minutes)
     */
    public void onThirdQuestionClicked(View view) {
        if (ninety.isChecked()) {
            thirdAnswer = true;
        }
    }

    /**
     * Question 4: Radio Button
     * Correct answer: #1 (69 moons)
     */
    public void onFourthQuestionClicked(View view) {
        if (jupiterOne.isChecked()) {
            fourthAnswer = true;
        }
    }

    /**
     * Question 5: Radio Button
     * Correct answer: #3 (15 seconds while conscious.)
     */
    public void onFifthQuestionClicked(View view) {
        if (correct.isChecked()) {
            fifthAnswer = true;
        }
    }

    /**
     * Question 6: Radio Button
     * Correct answer: #2 (No sound in space)
     */
    public void onSixthQuestionClicked(View view) {
        if (noSound.isChecked()) {
            sixthAnswer = true;
        }
    }

    /**
     * Question 7: CheckBox
     * Correct answers: #1, 2, and 4 (Nature, music, and pictures)
     */
    public void onCheckBoxClicked(View view) {
        // Will only return a score of 1 if ALL correct answers are selected
        if (nature.isChecked() && music.isChecked() && pictures.isChecked() && !narration.isChecked()) {
            seventhAnswer = true;
        }
    }

    /**
     * Executes when Submit button is clicked. Score for question #1 is determined.
     */
    public void submitScore(View view) {
        // Check for isSubmitted value
        if (isSubmitted) {
            Toast.makeText(getApplicationContext(), getString(R.string.submitted), Toast.LENGTH_SHORT).show();
        } else {
            /**
             * Question 1: EditText
             * Correct answer: Venus
             */
            if (planetName.getText().toString().trim().equalsIgnoreCase(getString(R.string.edit_text_answer))) {
                score++;
            }
            // Calls answer booleans and increments score
            if (secondAnswer) {
                score++;
            }
            if (thirdAnswer) {
                score++;
            }
            if (fourthAnswer) {
                score++;
            }
            if (fifthAnswer) {
                score++;
            }
            if (sixthAnswer) {
                score++;
            }
            if (seventhAnswer) {
                score++;
            }
            // Displays toast message with user's score and changes isSubmitted value
            Toast.makeText(getApplicationContext(), getString(R.string.score) + score + getString(R.string.max_score), Toast.LENGTH_LONG).show();
            isSubmitted = true;
        }
    }

    public void resetScore(View view) {
        // Resets score and booleans for Submit and answers
        score = 0;
        isSubmitted = false;
        secondAnswer = false;
        thirdAnswer = false;
        fourthAnswer = false;
        fifthAnswer = false;
        sixthAnswer = false;
        seventhAnswer = false;

        // Resets EditText for question 1
        planetName.getText().clear();

        // Resets RadioButtons for questions 2 - 6
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();
        radioGroupFive.clearCheck();
        radioGroupSix.clearCheck();

        // Resets CheckBoxes for question 7
        nature.setChecked(false);
        music.setChecked(false);
        narration.setChecked(false);
        pictures.setChecked(false);
    }
}