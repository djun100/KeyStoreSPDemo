package com.joe.androidkeystore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextInput;

    TextView textEncrypt;
    TextView textDecrypt;

    Button buttonEncrypt;
    Button buttonDecrypt;
    Button buttonSave;
    Button btnJump;
    private static final String PREF_KEY_2 = "PREF_KEY_2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEditTextInput();
        setupButton();

    }

    private void initEditTextInput() {
        editTextInput.setText(UtilSafeSP.fetch(PREF_KEY_2));
    }

    private void setupButton() {
        buttonEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String encryptedText = keyStoreHelper.encrypt(editTextInput.getText().toString());
//                textEncrypt.setText(encryptedText);
            }
        });

        buttonDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String decryptedText = keyStoreHelper.decrypt(textEncrypt.getText().toString());
//                textDecrypt.setText(decryptedText);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilSafeSP.save(PREF_KEY_2,editTextInput.getText().toString());
                Toast.makeText(getApplicationContext(), "Successfully saved!", Toast.LENGTH_SHORT).show();
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
