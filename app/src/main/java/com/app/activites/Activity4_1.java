package com.app.activites;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4_1 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
      SharedPreferences preferences;
      SharedPreferences.Editor editor;

     Button Login;
     EditText nom,pwd;
     CheckBox checkB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_1);

        Login= findViewById(R.id.btnLogin);
        pwd=findViewById(R.id.password);
        nom=findViewById(R.id.Nom);
        checkB= findViewById(R.id.check);

        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        checkSharedPreference();
        Login.setOnClickListener(view -> {
            if(checkB.isChecked()){

                //set the checkbox when the app is started
                editor.putString(getString(R.string.chekbox),"True");
                editor.apply();

                //save the name
                String name=nom.getText().toString();
                editor.putString(getString(R.string.name),name);
                editor.commit();

                //save the password
                String pass =pwd.getText().toString();
                editor.putString(getString(R.string.password),pass);
                editor.commit();

            }else {
                //set the checkbox when the app is started
                editor.putString(getString(R.string.chekbox),"False");
                editor.commit();

                // the name is not saved
                editor.putString(getString(R.string.name),"");
                editor.commit();

                //the password is not saved
                editor.putString(getString(R.string.password),"");
                editor.commit();

            }
        });

      /*  editor.putString("key","Amina");
        editor.commit();

        String name=preferences.getString("key","Default");
        log.d(TAG,"OnCreate: name:" +name);*/

    }
    private void checkSharedPreference(){
        String checkbox=preferences.getString(getString(R.string.chekbox),"False");
        String name=preferences.getString(getString(R.string.name),"");
        String password=preferences.getString(getString(R.string.password),"");

        nom.setText(name);
        pwd.setText(password);

        checkB.setChecked(checkbox.equals("True"));




    }
}