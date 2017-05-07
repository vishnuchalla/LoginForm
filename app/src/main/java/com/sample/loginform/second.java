package com.sample.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.sample.loginform.R.id.textView;

public class second extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        textView5=(TextView)findViewById(R.id.textView5);
        Intent i=getIntent();
        String ninput=i.getStringExtra("ninput");
        String minput=i.getStringExtra("minput");
        String phinput=i.getStringExtra("phinput");
        String pinput=i.getStringExtra("pinput");
       String rinput=i.getStringExtra("rinput");
        Toast.makeText(getApplicationContext(),"Logged In Successfully",Toast.LENGTH_LONG).show();
        textView1.setText("Name="+ninput);
        textView5.setText("Gender="+rinput);
        textView2.setText("E-mail="+minput);
        textView3.setText("\n\nPhone="+phinput);
        textView4.setText("Password="+pinput);

    }
}
