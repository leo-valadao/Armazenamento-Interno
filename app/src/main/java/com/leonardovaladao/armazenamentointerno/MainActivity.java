package com.leonardovaladao.armazenamentointerno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String PREF_NOME = "config";
    ToggleButton toggleButton;
    CheckBox checkBox;
    EditText editText;
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        checkBox = findViewById(R.id.checkBox);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        carregarPreferencias();
    }

    @Override
    public void onClick(View view) {
        salvarPreferencias();
    }

    private void salvarPreferencias() {
        SharedPreferences pref = getSharedPreferences(PREF_NOME, 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("receber", toggleButton.isChecked());
        editor.putBoolean("todos", checkBox.isChecked());
        editor.putString("nome", editText.getText().toString());

        editor.commit();
    }

    private void carregarPreferencias() {
        SharedPreferences pref = getSharedPreferences(PREF_NOME, 0);

        toggleButton.setChecked(pref.getBoolean("receber", false));
        checkBox.setChecked(pref.getBoolean("todos", false));
        editText.setText(pref.getString("nome", ""));
    }
}