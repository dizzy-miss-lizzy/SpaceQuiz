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

    int score;
    boolean nature, music, narration, pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Question 2: Radio Button
     * Correct answer: #2 (Mount Everest)
     */
    public void onSecondQuestionClicked(View view) {
        // Is button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.kilimanjaro_radio_button:
                if (checked)
                    break;
            case R.id.everest_radio_button:
                if (checked)
                    score += 1;
                break;
            case R.id.fuji_radio_button:
                if (checked)
                    break;
            default:
                score = 0;
                break;
        }
    }

    /**
     * Question 3: Radio Button
     * Correct answer: #1 (90 minutes)
     */
    public void onThirdQuestionClicked(View view) {
        // Is button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.ninety_radio_button:
                if (checked)
                    score += 1;
                break;
            case R.id.thirty_radio_button:
                if (checked)
                    break;
            case R.id.one_twenty_radio_button:
                if (checked)
                    break;
            default:
                score = 0;
                break;
        }
    }

    /**
     * Question 4: Radio Button
     * Correct answer: #1 (69 moons)
     */
    public void onFourthQuestionClicked(View view) {
        // Is button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.jupiter_one_radio_button:
                if (checked)
                    score += 1;
                break;
            case R.id.jupiter_two_radio_button:
                if (checked)
                    break;
            case R.id.jupiter_three_radio_button:
                if (checked)
                    break;
            default:
                score = 0;
                break;
        }
    }

    /**
     * Question 5: Radio Button
     * Correct answer: #3 (15 seconds while conscious.)
     */
    public void onFifthQuestionClicked(View view) {
        // Is button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.wrong_one_radio_button:
                if (checked)
                    break;
            case R.id.wrong_two_radio_button:
                if (checked)
                    break;
            case R.id.correct_radio_button:
                if (checked)
                    score += 1;
                break;
            default:
                score = 0;
                break;
        }
    }

    /**
     * Question 6: Radio Button
     * Correct answer: #2 (No sound in space)
     */
    public void onSixthQuestionClicked(View view) {
        // Is button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yes_radio_button:
                if (checked)
                    break;
            case R.id.no_radio_button:
                if (checked)
                    score += 1;
                break;
            default:
                score = 0;
                break;
        }
    }

    /**
     * Question 7: CheckBox
     * Correct answers: #1, 2, and 4 (Nature, music, and pictures)
     */
    public void onCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.nature_check_box:
                nature = checked;
                break;
            case R.id.music_check_box:
                music = checked;
                break;
            case R.id.narration_check_box:
                narration = checked;
                break;
            case R.id.pictures_check_box:
                pictures = checked;
                break;
        }
    }

    /**
     * Executes when Submit button is clicked. Scores for question #1 and #7 are determined.
     */
    public void submitScore(View view) {
        // Displays error toast message if user clicks Submit button too many times
        if (score == 7) {
            Toast.makeText(getApplicationContext(), "Score cannot exceed 7", Toast.LENGTH_SHORT).show();
            // Exits method early
            return;
        }

        /**
         * Question 1: EditText
         * Correct answer: Venus
         */
        EditText planetName = (EditText) findViewById(R.id.planet_view);
        String planetInput = planetName.getText().toString().trim();  // Gets planet name input

        if (planetInput.equals("Venus")) {
            score += 1;
        } else {
            score += 0;
        }

        // Checks answers for question #7
        // Will only return a score of 1 if ALL correct answers are selected
        CheckBox nature = (CheckBox) findViewById(R.id.nature_check_box);
        CheckBox music = (CheckBox) findViewById(R.id.music_check_box);
        CheckBox pictures = (CheckBox) findViewById(R.id.pictures_check_box);
        CheckBox narration = (CheckBox) findViewById(R.id.narration_check_box);

        if (nature.isChecked() && music.isChecked() && pictures.isChecked() && !narration.isChecked()) {
            score += 1;
        } else {
            score += 0;
        }

        // Displays toast message with user's score
        Toast.makeText(getApplicationContext(), "Your score: " + score + " out of 7", Toast.LENGTH_LONG).show();
    }

    public void resetScore(View view) {
        // Resets score
        score = 0;

        // Resets EditText for question 1
        EditText planetName = (EditText) findViewById(R.id.planet_view);
        planetName.getText().clear();

        // Resets radio buttons for questions 2, 3, 4, 5, and 6
        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radio_group_two);
        radioGroupTwo.clearCheck();

        RadioGroup radioGroupThree = (RadioGroup) findViewById(R.id.radio_group_three);
        radioGroupThree.clearCheck();

        RadioGroup radioGroupFour = (RadioGroup) findViewById(R.id.radio_group_four);
        radioGroupFour.clearCheck();

        RadioGroup radioGroupFive = (RadioGroup) findViewById(R.id.radio_group_five);
        radioGroupFive.clearCheck();

        RadioGroup radioGroupSix = (RadioGroup) findViewById(R.id.radio_group_six);
        radioGroupSix.clearCheck();

        // Resets check boxes for question 7
        CheckBox nature = (CheckBox) findViewById(R.id.nature_check_box);
        if (nature.isChecked()) {
            nature.setChecked(false);
        }
        CheckBox music = (CheckBox) findViewById(R.id.music_check_box);
        if (music.isChecked()) {
            music.setChecked(false);
        }
        CheckBox narration = (CheckBox) findViewById(R.id.narration_check_box);
        if (narration.isChecked()) {
            narration.setChecked(false);
        }
        CheckBox pictures = (CheckBox) findViewById(R.id.pictures_check_box);
        if (pictures.isChecked()) {
            pictures.setChecked(false);
        }

    }
}


