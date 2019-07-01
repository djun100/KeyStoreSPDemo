package com.joe.androidkeystore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editTextInput;

    TextView textEncrypt;
    TextView textDecrypt;

    Button buttonEncrypt;
    Button buttonDecrypt;
    Button buttonSave;
    Button btnJump;
    KeyStoreHelper keyStoreHelper;
    SharedPreferencesHelper preferencesHelper;
    private static final String PREF_KEY_1 = "PREF_KEY_1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesHelper = new SharedPreferencesHelper(getApplicationContext());
        keyStoreHelper = new KeyStoreHelper(getApplicationContext(), preferencesHelper);


        initView();
        initEditTextInput();
        setupButton();

    }

    private void initEditTextInput() {
        String encryptedText = preferencesHelper.getInput(PREF_KEY_1 );
        String plainInput = keyStoreHelper.decrypt(encryptedText);
        editTextInput.setText(plainInput);
    }

    private void setupButton() {
        buttonEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encryptedText = keyStoreHelper.encrypt(editTextInput.getText().toString());
                textEncrypt.setText(encryptedText);
            }
        });

        buttonDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String decryptedText = keyStoreHelper.decrypt(textEncrypt.getText().toString());
                textDecrypt.setText(decryptedText);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferencesHelper.setInput(PREF_KEY_1 ,textEncrypt.getText().toString());
                Toast.makeText(getApplicationContext(), "Successfully saved!", Toast.LENGTH_SHORT).show();
            }
        });
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    private void initView() {
        editTextInput = (EditText) findViewById(R.id.editText_input);
        textEncrypt = (TextView) findViewById(R.id.text_encrypt);
        textDecrypt = (TextView) findViewById(R.id.text_decrypt);
        buttonEncrypt = (Button) findViewById(R.id.button_encrypt);
        buttonDecrypt = (Button) findViewById(R.id.button_decrypt);
        buttonSave = (Button) findViewById(R.id.button_save);
        btnJump = (Button) findViewById(R.id.btnJump);
    }
}
