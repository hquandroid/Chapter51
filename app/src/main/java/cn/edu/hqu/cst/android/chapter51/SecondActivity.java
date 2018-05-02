package cn.edu.hqu.cst.android.chapter51;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.textView);
        ComponentName comp=getIntent().getComponent();
        tv.setText("本Activity包名："+comp.getPackageName()+"\n类名："+comp.getClassName());
    }
}
