package edu.chanmat_tsilpakorn.bmioat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mHeightEditText, mWeightEditText;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.valueOf(mHeightEditText.getText().toString());
                Double weight = Double.valueOf(mWeightEditText.getText().toString());

                Double bmi = weight / ((height / 100) * (height / 100));
                String bmiText = getBmiText(bmi);

                String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s", bmi, bmiText);

/*
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // โค้ดที่ต้องการให้ทำงาน เมื่อปุ่ม OK ในไดอะล็อกถูกคลิก
                        //finish(); // ปิดแอคทิวิตีปัจจุบัน
                        mHeightEditText.setText("");
                        mWeightEditText.setText("");
                        mHeightEditText.requestFocus();
                    }
                });
                dialog.show();
*/

                // สร้างอินเทนต์ โดยระบุคอนเท็กซ์ และแอคทิวิตีที่ต้องการรัน
                Intent intent = new Intent(MainActivity.this, BMIactivity2.class);
                // ใส่ค่าตัวเลข bmi ลงในอินเทนต์
                intent.putExtra("bmi_value", bmi);
                // ใส่ข้อความ (ที่บอกผอม, ปกติ, อ้วน) ลงในอินเทนต์
                intent.putExtra("bmi_text", bmiText);
                // ยิงอินเทนต์ออกไปให้ Android จัดการ (รันแอคทิวิตีใหม่)
                startActivity(intent);

            }
        });

    } // ปิดเมธอด onCreate

    private String getBmiText(Double bmi) {
        /*
            bmi < 18.5 : น้ำหนักน้อยกว่าปกติ
            18.5 <= bmi < 25 : น้ำหนักปกติ
            25 <= bmi < 30 : น้ำหนักมากกว่าปกติ (ท้วม)
            bmi >= 30 : น้ำหนักมากกว่าปกติมาก (อ้วน)
         */

        String bmiText = "";

        if (bmi < 18.5) {
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        } else if (bmi < 25) {
            bmiText = "น้ำหนักปกติ";
        } else if (bmi < 30) {
            bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
        } else {
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }

        return bmiText;
    } // ปิดเมธอด getBmiText
}
