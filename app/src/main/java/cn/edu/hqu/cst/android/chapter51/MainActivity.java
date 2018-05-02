package cn.edu.hqu.cst.android.chapter51;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.Btn1StartActivity);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp=new ComponentName(MainActivity.this,SecondActivity.class);
                Intent intent=new Intent();
                intent.setComponent(comp);
                startActivity(intent);
            }
        });
        btn2=findViewById(R.id.Btn3StartActivity);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("cn.edu.hqu.android.chapter51.START_ACTION");
                intent.addCategory("cn.edu.hqu.android.chapter51.START_CATEGORY");
                startActivity(intent);
            }
        });
        btn3=findViewById(R.id.Btn3StartActivity);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });
        btn4=findViewById(R.id.Btn4StartActivity);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
        btn5=findViewById(R.id.Btn5StartActivity);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String data="content://com.android.contacts/contacts/1";
                Uri uri= Uri.parse(data);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        btn6=findViewById(R.id.Btn6StartActivity);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_EDIT);
                String data="content://com.android.contacts/contacts/1";
                Uri uri= Uri.parse(data);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        btn7=findViewById(R.id.Btn7StartActivity);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                String data="tel:23423423";
                Uri uri= Uri.parse(data);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        btn8=findViewById(R.id.Btn8StartActivity);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String data="http://www.hqu.edu.cn";
                Uri uri= Uri.parse(data);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}
