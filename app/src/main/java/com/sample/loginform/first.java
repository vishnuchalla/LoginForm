package com.sample.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class first extends AppCompatActivity {
    Button btn;
    EditText editText1,editText2,editText3,editText4,editText5;
    RadioGroup rg;
    RadioButton rb;
    boolean flag1,flag2,flag3,flag4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ninput=editText1.getText().toString();
                String minput=editText2.getText().toString();
                String phinput=editText3.getText().toString();
                String pinput=editText4.getText().toString();
                String cpinput=editText5.getText().toString();
                rg=(RadioGroup)findViewById(R.id.rgroup);
                int radiobuttonid=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(radiobuttonid);
                String rinput=rb.getText().toString();
                if(!validatename(editText1.getText().toString()))
                {editText1.setError("Invalid Name");
                    editText1.requestFocus();
                flag1=true;}
                else
                flag1=false;
                if(!validateEmail(editText2.getText().toString()))
                {editText2.setError("Invalid Email");
                editText2.requestFocus();
                    flag2=true;}
                else
                flag2=false;
                if(!validatePhone(editText3.getText().toString()))
                {editText3.setError("Invalid Phone");
                    editText3.requestFocus();
                    flag3=true;}
                else
                    flag3=false;
                if(!validatepassword(editText4.getText().toString(),editText5.getText().toString()))
                {editText4.setError("Passwords Doesn't Match");
                    editText4.requestFocus();
                    editText5.setError("Passwords Doesn't Match");
                    editText5.requestFocus();
                    flag4=true;}
                else
                flag4=false;
                if(flag1==true||flag2==true||flag3==true||flag4==true)
                {Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();}
                else{
                Intent i=new Intent(first.this,second.class);
                    i.putExtra("ninput",ninput);
                    i.putExtra("minput",minput);
                    i.putExtra("phinput",phinput);
                    i.putExtra("pinput",pinput);
                    i.putExtra("cpinput",cpinput);
                    i.putExtra("rinput",rinput);

                    startActivity(i);}}

        });
    }
    protected boolean validateEmail(String email) {
        String emailPattern="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                Pattern pattern= Pattern.compile(emailPattern);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
    protected boolean validatePhone(String p)
    {
       String phone="\\d{10}";
               Pattern pattern=Pattern.compile(phone);
        Matcher matcher=pattern.matcher(p);
        return matcher.matches();
    }
    protected boolean validatepassword(String s,String p)
    {
        if (s.matches("")&&p.matches("")) {
            return false;}
        else if(s.equals(p))
        return true;
        else
            return false;
    }
    protected boolean validatename(String n)
    {
        String name=".*\\D.*";
        Pattern pattern=Pattern.compile(name);
        Matcher matcher=pattern.matcher(n);
        return matcher.matches();
    }
}
