package com.example.android.quizapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    RadioButton phishing;
    RadioButton worms;
    RadioButton trojan;
    int finalscore;
    CheckBox cbBaiting;
    CheckBox cbRansom;
    CheckBox cbPhishing;
    CheckBox cbTravellingWorms;
    CheckBox question41;
    CheckBox question42;
    CheckBox question43;
    EditText edittext;
    int totalScore = 5;

    RadioGroup groupCyberAttack;
    Button submitButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        phishing = this.getActivity().findViewById(R.id.phishing);
        worms = this.getActivity().findViewById(R.id.worms);
        trojan = this.getActivity().findViewById(R.id.trojan);
        cbBaiting = this.getActivity().findViewById(R.id.baiting);
        cbRansom = this.getActivity().findViewById(R.id.ransom);
        cbPhishing = this.getActivity().findViewById(R.id.fishing);
        cbTravellingWorms = this.getActivity().findViewById(R.id.travelling_worms);
        question41 = this.getActivity().findViewById(R.id.compression);
        question42 = this.getActivity().findViewById(R.id.systematic);
        question43 = this.getActivity().findViewById(R.id.encyptiom);
        edittext = this.getActivity().findViewById(R.id.fieldtext);

        groupCyberAttack = this.getActivity().findViewById(R.id.cyberattack);

        submitButton = getActivity().findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitQuizAnswers();
            }
        });

    }

    public void submitQuizAnswers() {

        int selected = groupCyberAttack.getCheckedRadioButtonId();
        RadioButton button1 = this.getActivity().findViewById(selected);
        if (button1 != null && "Phishing".equals(button1.getText())) {
            score1 = 1;

        } else {

        }
        RadioGroup group2 = this.getActivity().findViewById(R.id.password);
        int selected2 = group2.getCheckedRadioButtonId();
        RadioButton button2 = this.getActivity().findViewById(selected2);
        if (button2 != null && "Upper and lower case letters, numbers and symbols".equals(button2.getText())) {
            score2 = 1;
        } else {

        }

        if (cbBaiting.isChecked() || cbRansom.isChecked() || cbTravellingWorms.isChecked()) {
            score3 = 1;

        } else {
            score3 = 0;
        }
        if (question43.isChecked() && question42.isChecked() && cbTravellingWorms.isChecked()) {
            score4 = 0;

        } else if (question43.isChecked()) {
            score4 = 1;

        } else {
            score4 = 0;

        }
        String toCompare = edittext.getText().toString();

        if (toCompare.equalsIgnoreCase("antivirus")) {
            score5 = score5 + 1;
        }


        finalscore = score1 + score2 + score3 + score4 + score5;
        if(finalscore == totalScore) {

            String finalScoreMessage = "Your score is " + String.valueOf(finalscore) + "/5 Well done!!!!";
            Toast.makeText(getActivity(), finalScoreMessage, Toast.LENGTH_LONG).show();
        }
        else
        {
            String finalScoreMessage = "Your score is " + String.valueOf(finalscore) + "/5 You may take the quiz again to improve your score!!!!";
            Toast.makeText(getActivity(), finalScoreMessage, Toast.LENGTH_LONG).show();

        }

    }
}
