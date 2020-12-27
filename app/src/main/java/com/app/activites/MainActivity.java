package com.app.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
     private SharedPreferences preferences;
     private SharedPreferences.Editor editor;
    private Button Login;
    private EditText nom,pwd;
    private CheckBox checkB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login=(Button) findViewById(R.id.btnLogin);
        pwd=(EditText)findViewById(R.id.password);
        nom=(EditText)findViewById(R.id.Nom);
        checkB=(CheckBox) findViewById(R.id.check);

        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        checkSharedPreference();
        Login.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(checkB.isChecked()){

                    //set the checkbox when the app is started
                    editor.putString(getString(R.string.chekbox),"True");
                    editor.commit();

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

        if(checkbox.equals("True")){
            checkB.setChecked(true);
        }else {
            checkB.setChecked(false);
        }




    }
}