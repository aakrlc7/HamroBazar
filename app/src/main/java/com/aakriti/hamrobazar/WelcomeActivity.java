
package com.aakriti.hamrobazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.aakriti.hamrobazar.TermsUI.AdRulesActivity;
import com.aakriti.hamrobazar.TermsUI.SafetyTips;
import com.aakriti.hamrobazar.TermsUI.TermsofUse;
import com.aakriti.hamrobazar.fragment.HomeFragment;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    CheckBox chkTerms, chkSafety, chkRules;
    Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        chkTerms = findViewById(R.id.chkTerms);
        chkSafety = findViewById(R.id.chkSafety);
        chkRules = findViewById(R.id.chkRules);
        btnAccept = findViewById(R.id.btnAccept);

        chkTerms.setOnClickListener(this);
        chkSafety.setOnClickListener(this);
        chkRules.setOnClickListener(this);



        chkTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, TermsofUse.class);
                startActivity(intent);
            }
        });

        chkSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, SafetyTips.class);
                startActivity(intent);
            }
        });

        chkRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, AdRulesActivity.class);
                startActivity(intent);
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, SplashActivity.class);
                startActivity(intent);

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chkTerms:
                if (chkTerms.isChecked())
                   // Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_LONG).show();
                break;
            case R.id.chkSafety:
                if (chkSafety.isChecked())
                   // Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_LONG).show();
                break;
            case R.id.chkRules:
                if (chkRules.isChecked())
                  //  Toast.makeText(getApplicationContext(), "PHP", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
