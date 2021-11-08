package com.emmanuelmuturia.userinputcontrolsinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    EditText first_name;
    EditText last_name;
    EditText email;
    EditText dateofBirth;
    EditText password;
    EditText reenterPassword;
    Button signUp;
    CheckBox check_Box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We link our signup components here:
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email_address);
        dateofBirth = findViewById(R.id.date_of_Birth);
        password = findViewById(R.id.enter_password);
        reenterPassword = findViewById(R.id.reenter_password);
        signUp = findViewById(R.id.sign_up);
        check_Box = findViewById(R.id.checkBox);



        //DatePicker code goes here:
        eText=(EditText) findViewById(R.id.date_of_Birth);
        eText.setInputType(InputType.TYPE_NULL);

        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        //Spinner code goes here:
        Spinner spinner = (Spinner) findViewById(R.id.phone_type);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Phone_Category, R.layout.my_spinner);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.my_spinner_view);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public void launchLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public static class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            Spinner spinner = (Spinner) findViewById(R.id.phone_type);
            spinner.setOnItemSelectedListener(this);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}