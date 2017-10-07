package edu.chanmat_tsilpakorn.bmioat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BMIactivity2 extends AppCompatActivity {
    private TextView T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity2);

        // เข้าถึงอินเทนต์ที่ส่งมจากต้นทาง (MainActivity)
        Intent intent = getIntent();
        // อ่านค่าตัวเลข bmi จากอินเทนต์
        Double bmi = intent.getDoubleExtra("bmi_value", 0);
        // อ่านข้อความ (ที่บอกผอม, ปกติ, อ้วน) จากอินเทนต์
        String bmiText = intent.getStringExtra("bmi_text");
        String result2 = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s", bmi, bmiText);
        T = (TextView) findViewById(R.id.textView3);
        T.setText(result2);
        // ...
        // นำค่า bmi, bmiText ไปใช้งานตามต้องการ
        // ...
    }
}
