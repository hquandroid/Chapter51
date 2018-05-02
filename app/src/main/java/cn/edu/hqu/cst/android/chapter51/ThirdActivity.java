package cn.edu.hqu.cst.android.chapter51;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView tv=findViewById(R.id.textView2);
        tv.setText("Action:"+getIntent().getAction()+"\nCategory:"+getIntent().getCategories());
    }
}
