package com.example.assignment1smd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SenderInformationForm extends AppCompatActivity {
    TextInputEditText senderEmail,senderFullname,senderContact,senderCountry,senderAddress;
    Button btnNext;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender_information_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext =findViewById(R.id.btnNext);
                senderEmail=findViewById(R.id.input_email);
                senderFullname=findViewById(R.id.input_name);
                senderContact=findViewById(R.id.input_contactinfo);
                senderCountry=findViewById(R.id.input_country);
                senderAddress=findViewById(R.id.input_address);

                  String Email=senderEmail.getText().toString();
                  String Fullname=senderFullname.getText().toString();
                  String Address=senderAddress.getText().toString();
                  String Country=senderCountry.getText().toString();
                  String contact=senderContact.getText().toString();
                if(Email.contains("@gmail.com")&& contact.length()>8 && !Country.isEmpty() && !Fullname.isEmpty() && !Address.isEmpty())
                {
                Intent i=new Intent(SenderInformationForm.this,ReceiverInformationForm.class);
                i.putExtra("senderEmail",Email);
                i.putExtra("senderFullName",Fullname);
                i.putExtra("senderContact",contact);
                i.putExtra("senderCountry",Country);
                i.putExtra("senderAddress",Address);
                startActivity(i);
                finish();}
                else {
                    Toast.makeText(SenderInformationForm.this,"Enter Correct Information",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}