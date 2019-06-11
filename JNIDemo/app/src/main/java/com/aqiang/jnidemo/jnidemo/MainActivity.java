package com.aqiang.jnidemo.jnidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnMutiply = (Button) findViewById(R.id.btnMutiply);
        Button btnDevide = (Button) findViewById(R.id.btnDevide);

        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMutiply.setOnClickListener(this);
        btnDevide.setOnClickListener(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View v) {
        int id = v.getId();
        EditText etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        EditText etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
        float fistNumber = Float.parseFloat(etFirstNumber.getText().toString().trim());
        float secondNumber = Float.parseFloat(etSecondNumber.getText().toString().trim());
        Toast.makeText(getApplicationContext(),"两个数是："+fistNumber+"-"+secondNumber,Toast.LENGTH_LONG).show();

        switch (id) {
            case R.id.btnAdd:
                Toast.makeText(getApplicationContext(),"结果是："+add(fistNumber, secondNumber),Toast.LENGTH_LONG).show();
                break;
            case R.id.btnMinus:
                Toast.makeText(getApplicationContext(),"结果是："+minus(fistNumber, secondNumber),Toast.LENGTH_LONG).show();
                break;
            case R.id.btnMutiply:
                Toast.makeText(getApplicationContext(),"结果是："+mutiply(fistNumber, secondNumber),Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDevide:
                Toast.makeText(getApplicationContext(),"结果是："+divide(fistNumber, secondNumber),Toast.LENGTH_LONG).show();
                break;
        }
    }

    public native double add(float a, float b);

    public native double minus(float a, float b);

    public native double mutiply(float a, float b);

    public native double divide(float a, float b);
}
