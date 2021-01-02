package com.app.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4_2 extends AppCompatActivity {
    DataBaseHelper db;
    EditText Mail,Password,ConfirmerP;
    Button btnInscription,btnConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_2);

        db=new DataBaseHelper(this);
        Mail=findViewById(R.id.email);
        Password=findViewById(R.id.etpassword);
        ConfirmerP=findViewById(R.id.CPassword);

        btnConnexion=findViewById(R.id.btnConnexion);
        btnConnexion.setOnClickListener(v -> {
            Intent intent=new Intent(Activity4_2.this,LoginActivity.class);
            startActivity(intent);
        });


        btnInscription= findViewById(R.id.btnC);
        btnInscription.setOnClickListener(v -> {
            String M=Mail.getText().toString();
            String P=Password.getText().toString();
            String CP= ConfirmerP.getText().toString();
            if(M.equals("") || P.equals("") || CP.equals("")){
                Toast.makeText(getApplicationContext(),"field area is empty",Toast.LENGTH_SHORT).show();
            }
            else {
                if (P.equals(CP)){
                    boolean chkemail=db.chkemail(P);
                    if (chkemail){
                        boolean insert=db.insert();
                        if (insert){
                            Toast.makeText(getApplicationContext(),"registred successfuly",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"email is already exsist",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"not the same password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
