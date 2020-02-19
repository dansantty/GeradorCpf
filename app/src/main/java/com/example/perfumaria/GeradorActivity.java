package com.example.perfumaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GeradorActivity extends AppCompatActivity {

    private EditText digito1;
    private EditText digito2;
    private EditText digito3;
    private EditText digito4;
    private EditText digito5;
    private EditText digito6;
    private EditText digito7;
    private EditText digito8;
    private EditText digito9;
    private EditText[] digitos;

    private TextView digito10;
    private TextView digito11;

    private Button btGerar;
    private Button btClear;

    int dig1;
    int dig2;
    int dig3;
    int dig4;
    int dig5;
    int dig6;
    int dig7;
    int dig8;
    int dig9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_gerador);
        bind();
        init();
        digito1.requestFocus();
    }

    private void bind() {
        digito1 = findViewById(R.id.dig1);
        digito2 = findViewById(R.id.dig2);
        digito3 = findViewById(R.id.dig3);
        digito4 = findViewById(R.id.dig4);
        digito5 = findViewById(R.id.dig5);
        digito6 = findViewById(R.id.dig6);
        digito7 = findViewById(R.id.dig7);
        digito8 = findViewById(R.id.dig8);
        digito9 = findViewById(R.id.dig9);
        digito10 = findViewById(R.id.dig10);
        digito11 = findViewById(R.id.dig11);
        btClear = findViewById(R.id.btlimp);
        btGerar = findViewById(R.id.btnGera);

    }

    private void init() {
        digitos = new EditText[]{digito1, digito2, digito3, digito4, digito5, digito6, digito7, digito8, digito9};
        digito1.addTextChangedListener(new DigitTextWatch(digito1));
        digito2.addTextChangedListener(new DigitTextWatch(digito2));
        digito3.addTextChangedListener(new DigitTextWatch(digito3));
        digito4.addTextChangedListener(new DigitTextWatch(digito4));
        digito5.addTextChangedListener(new DigitTextWatch(digito5));
        digito6.addTextChangedListener(new DigitTextWatch(digito6));
        digito7.addTextChangedListener(new DigitTextWatch(digito7));
        digito8.addTextChangedListener(new DigitTextWatch(digito8));
        digito9.addTextChangedListener(new DigitTextWatch(digito9));
        digito1.requestFocus();

        btGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarCPF();
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCamposCPF();
            }
        });


    }

    public void random() {

        Random rand = new Random();
        dig1 = rand.nextInt(9) + 1;
        dig2 = rand.nextInt(9) + 1;
        dig3 = rand.nextInt(9) + 1;
        dig4 = rand.nextInt(9) + 1;
        dig5 = rand.nextInt(9) + 1;
        dig6 = rand.nextInt(9) + 1;
        dig7 = rand.nextInt(9) + 1;
        dig8 = rand.nextInt(9) + 1;
        dig9 = rand.nextInt(9) + 1;

    }

    private void pegarDigitosFinais() {

        int dig1 = Integer.parseInt(digito1.getText().toString());
        int dig2 = Integer.parseInt(digito2.getText().toString());
        int dig3 = Integer.parseInt(digito3.getText().toString());
        int dig4 = Integer.parseInt(digito4.getText().toString());
        int dig5 = Integer.parseInt(digito5.getText().toString());
        int dig6 = Integer.parseInt(digito6.getText().toString());
        int dig7 = Integer.parseInt(digito7.getText().toString());
        int dig8 = Integer.parseInt(digito8.getText().toString());
        int dig9 = Integer.parseInt(digito9.getText().toString());

        int dig10 = ((dig1) + (dig2 * 2) + (dig3 * 3) + (dig4 * 4) + (dig5 * 5) + (dig6 * 6) + (dig7 * 7) + (dig8 * 8) + (dig9 * 9)) % 11;

        if (dig10 >= 10) {
            dig10 = 0;
        }

        int dig11 = ((dig2) + (dig3 * 2) + (dig4 * 3) + (dig5 * 4) + (dig6 * 5) + (dig7 * 6) + (dig8 * 7) + (dig9 * 8) + (dig10 * 9)) % 11;

        if (dig11 >= 10) {
            dig11 = 0;
        }

        //exibir
        digito10.setText(String.valueOf(dig10));
        digito11.setText(String.valueOf(dig11));
    }


    private void verificadorCampos(EditText[] digitos) {
        for (EditText digito : digitos) {
            if (digito.getText().toString().length() <= 0) {
                return;
            }
        }
        pegarDigitosFinais();
    }

    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(digito9.getWindowToken(), 0);
    }

    public void gerarCPF() {

        random();
        digito1.setText(Integer.toString(dig1));
        digito2.setText(Integer.toString(dig2));
        digito3.setText(Integer.toString(dig3));
        digito4.setText(Integer.toString(dig4));
        digito5.setText(Integer.toString(dig5));
        digito6.setText(Integer.toString(dig6));
        digito7.setText(Integer.toString(dig7));
        digito8.setText(Integer.toString(dig8));
        digito9.setText(Integer.toString(dig9));

        digito9.requestFocus();
        digito9.clearFocus();
        closeKeyboard();
    }


    public void limparCamposCPF() {
        digito1.setText("");
        digito2.setText("");
        digito3.setText("");
        digito4.setText("");
        digito5.setText("");
        digito6.setText("");
        digito7.setText("");
        digito8.setText("");
        digito9.setText("");
        digito10.setText("");
        digito11.setText("");
        digito1.requestFocus();

        InputMethodManager inm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

    }


    private class DigitTextWatch implements TextWatcher {

        private View view;

        private DigitTextWatch(View view) {
            this.view = view;
        }


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            verificadorCampos(digitos);
        }


        @Override
        public void afterTextChanged(Editable s) {

            String text = s.toString();

            switch (view.getId()) {
                case R.id.dig1:
                    if (text.length() == 1) {
                        digito2.requestFocus();

                    }

                    break;
                case R.id.dig2:
                    if (text.length() == 1) {
                        digito3.requestFocus();
                    } else {
                        digito1.requestFocus();
                    }
                    break;
                case R.id.dig3:
                    if (text.length() == 1) {
                        digito4.requestFocus();
                    }else {
                        digito2.requestFocus();
                    }
                    break;
                case R.id.dig4:
                    if (text.length() == 1) {
                        digito5.requestFocus();
                    }else {
                        digito3.requestFocus();
                    }
                    break;
                case R.id.dig5:
                    if (text.length() == 1) {
                        digito6.requestFocus();
                    }else {
                        digito4.requestFocus();
                    }
                    break;
                case R.id.dig6:
                    if (text.length() == 1) {
                        digito7.requestFocus();
                    }else {
                        digito5.requestFocus();
                    }
                    break;
                case R.id.dig7:
                    if (text.length() == 1) {
                        digito8.requestFocus();
                    }else {
                        digito6.requestFocus();
                    }
                    break;
                case R.id.dig8:

                    if (text.length() == 1) {
                        digito9.requestFocus();
                    } else {
                        digito7.requestFocus();
                    }

                    break;
                case R.id.dig9:
                    if (text.length() == 0) {
                        digito8.requestFocus();
                        digito10.setText("");
                        digito11.setText("");
                    }
                    break;


            }




        }
    }
}

