package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class InfomationAddActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infomation_add_activity);

        findViewById(R.id.btnsubmit).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnsubmit) {
            EditText fullname = findViewById(R.id.fullnameInput);
            EditText IDUser = findViewById(R.id.IDUserInput);

            String fullnameStr = fullname.getText().toString();
            String IDUserStr = IDUser.getText().toString();

//          bằng cấp
            CheckBox checkBox = findViewById(R.id.checkBox);
            CheckBox checkBox2 = findViewById(R.id.checkBox2);
            CheckBox checkBox3 = findViewById(R.id.checkBox3);

//            sở thích
            CheckBox checkBox4 = findViewById(R.id.checkBox4);
            CheckBox checkBox5 = findViewById(R.id.checkBox5);
            CheckBox checkBox6 = findViewById(R.id.checkBox6);

//            Thông tin bổ sung
            EditText addInfo = findViewById(R.id.addInfoInput);

//            Tên người không được để trống và phải có ít nhất 3 ký tự
//            - Chứng minh nhân dân chỉ được nhập kiểu số và phải có đúng 9 chữ số
//            - Bằng cấp mặc định sẽ chọn là Đại học
//            - Sở thích phải chọn ít nhất 1 chọn lựa
//            - Thông tin bổ sung có thể để trống
//                    - Khi bấm gửi thông tin, chương trình sẽ hiển thị toàn bộ thông tin cá nhân cho
//            người sử dụng biết (dùng Alert Dialog)


            if (fullnameStr.length() < 3) {
                fullname.setError("Tên người không được để trống và phải có ít nhất 3 ký tự");
                return;
            }


            if (IDUserStr.length() != 9 || !IDUserStr.matches("[0-9]+")) {
                IDUser.setError("Chứng minh nhân dân chỉ được nhập kiểu số và phải có đúng 9 chữ số");
                return;
            }

            if (!checkBox.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
                checkBox.setError("Bằng cấp mặc định sẽ chọn là Đại học");
                checkBox3.setChecked(true);
            }

            if (!checkBox4.isChecked() && !checkBox5.isChecked() && !checkBox6.isChecked()) {
                checkBox4.setError("Sở thích phải chọn ít nhất 1 chọn lựa");
                return;
            }

            String bcap = "";
            if (checkBox.isChecked()) {
                bcap = "Cao đẳng";
            } else if (checkBox2.isChecked()) {
                bcap = "Trung cấp";
            } else if (checkBox3.isChecked()) {
                bcap = "Đại học";
            }

            String sothich = "";
            if (checkBox4.isChecked()) {
                sothich += "Đọc Báo ";
            }
            if (checkBox5.isChecked()) {
                sothich += "Đọc Sách ";
            }
            if (checkBox6.isChecked()) {
                sothich += "Đọc Code ";
            }

            String addInfoStr = addInfo.getText().toString();

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Thông tin cá nhân");
            builder.setMessage("Tên người: " + fullnameStr + "\n" +
                    "Chứng minh nhân dân: " + IDUserStr + "\n" +
                    "Bằng cấp: " + bcap + "\n" +
                    "Sở thích: " + sothich + "\n" +
                    "--------------------------------" + "\n" +
                    "Thông tin bổ sung: " + addInfoStr + "\n" +
                    "--------------------------------");

            builder.setIcon(android.R.drawable.ic_dialog_info);
            builder.setPositiveButton("Close", new android.content.DialogInterface.OnClickListener() {
                public void onClick(android.content.DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();
        }
    }
}