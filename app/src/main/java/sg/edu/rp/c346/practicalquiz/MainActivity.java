package sg.edu.rp.c346.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etAge = findViewById(R.id.editTextAge);
        etName.setText("");
        etAge.setText("");
    }



    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        int age = Integer.parseInt(etAge.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.putInt("age", age);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("name", "" );
        int msg1 = prefs.getInt("age", 0);

if(msg.isEmpty()){
    etName.setText("");
} else {
    etName.setText(msg);}
       Integer age = new Integer(msg1);
if(age == null){

    etAge.setText("");
} else {
    etAge.setText(Integer.toString(msg1));
}
    }
}
