package com.techtastic.minditup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Act2_Onboarding_register extends AppCompatActivity {
    EditText phoneNumber;
    Button genOtpBtn;
    String number;
    ProgressBar progressBarPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2_onboarding_register);
        getSupportActionBar().hide();

        phoneNumber = findViewById(R.id.phoneNumber);
        genOtpBtn = findViewById(R.id.genOtpBtn);
        progressBarPhone = findViewById(R.id.progressbar_phonepage);

        genOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = phoneNumber.getText().toString();
                if(number.length()==10) {

                    progressBarPhone.setVisibility(View.VISIBLE);
                    genOtpBtn.setVisibility(View.INVISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + number, 60, TimeUnit.SECONDS, Act2_Onboarding_register.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    progressBarPhone.setVisibility(View.GONE);
                                    genOtpBtn.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    progressBarPhone.setVisibility(View.GONE);
                                    genOtpBtn.setVisibility(View.VISIBLE);
                                    Toast.makeText(Act2_Onboarding_register.this, "On Verification Failed", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    progressBarPhone.setVisibility(View.GONE);
                                    genOtpBtn.setVisibility(View.VISIBLE);

                                    Intent intent = new Intent(Act2_Onboarding_register.this, OtpVerificationActivity.class);
                                    intent.putExtra("pnumber",number);
                                    intent.putExtra("backendotp",s);
                                    startActivity(intent);
                                }
                            });


                }else{
                    Toast.makeText(Act2_Onboarding_register.this, "Enter a valid number", Toast.LENGTH_SHORT).show();
                }

            }
        });

        SharedPreferences preferences= getSharedPreferences("pref",MODE_PRIVATE);
        String firsttime= preferences.getString("firsttimeinstall","");

        if (firsttime.equals("yes")){
            startActivity(new Intent(Act2_Onboarding_register.this, Act4_BasePage.class));
        }else {
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("firsttimeinstall","yes");
            editor.apply();}

    }
}