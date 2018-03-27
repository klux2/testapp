package de.android.konrad.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {
    boolean female = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gender);
        final RadioButton f_btn = (RadioButton) findViewById(R.id.female);
        final RadioButton m_btn = (RadioButton) findViewById(R.id.male);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        female = false;
                        f_btn.setAlpha(.2f);
                        m_btn.setAlpha(1f);
                        break;
                    case R.id.female:
                        female = true;
                        m_btn.setAlpha(.2f);
                        f_btn.setAlpha(1f);
                        break;
                }
            }
        });
    }

    protected void onClick(View view) {
        EditText text = (EditText) findViewById(R.id.username);
        String string = text.getText().toString();
        String gender;
        if (female) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        Toast.makeText(this, gender + " user " + string + " created.", Toast.LENGTH_SHORT).show();
    }

}
