package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;

import android.os.Bundle;
import android.view.View;
import org.mozilla.javascript.Scriptable;
import android.widget.TextView;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MaterialButton btn1,btn0, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_malt, btn_dev,
            btn_pls,btn_eq,btnclr,btn_del,btnsin,btntan;
    String operate;
 TextView slntv,restv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slntv = (TextView) findViewById(R.id.wk_tv);
        restv = (TextView) findViewById(R.id.res_tv);
//       calling the idassigment method
        idAssignment(btn0,R.id.btn_0);
       idAssignment(btn1,R.id.btn_1);
        idAssignment(btn2,R.id.btn_2);
        idAssignment(btn3,R.id.btn_3);
        idAssignment(btn4,R.id.btn_4);
        idAssignment(btn5,R.id.btn_5);
        idAssignment(btn6,R.id.btn_6);
        idAssignment(btn7,R.id.btn_7);
        idAssignment(btn8,R.id.btn_8);
        idAssignment(btn9,R.id.btn_9);
        idAssignment(btn9,R.id.btn_9);


        idAssignment(btn_eq,R.id.btn_eql);
        idAssignment(btn_del,R.id.btn_del);
        idAssignment(btnclr,R.id.btn_clr);
        idAssignment(btn_dev,R.id.btn_dev);
        idAssignment(btn_malt,R.id.btn_malt);
        idAssignment(btn_pls,R.id.btn_pls);
        idAssignment(btnsin,R.id.btn_sin);
        idAssignment(btntan,R.id.btn_tan);


    }
    void idAssignment(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        taking  any button clicked
        MaterialButton button=(MaterialButton) v;
//        get the text to string
        String str= button.getText().toString();
       String cal=slntv.getText().toString();
if(str.equals("clr")){
    slntv.setText("");
    restv.setText("0");
    return;
}if(str.equals("=")){

    restv.setText(slntv.getText());
    return;
        }
if(str.equals("sin")){
double sin=Double.parseDouble(slntv.getText().toString());
double son1=Math.sin(sin);
restv.setText(String.valueOf(son1));
}
    if(str.equals("del")){
                cal=cal.substring(0,cal.length()-1);

            }
       else {
            cal+=str;
        }

       slntv.setText(cal);
       String reslt=output1(cal);
       if(!reslt.equals("Syntax error")){
           restv.setText(reslt);
       }



    }
    String output1(String info){
        try {
            Context cont=Context.enter();
            cont.setOptimizationLevel(-1);
            Scriptable script=cont.initStandardObjects();
            String reslt =cont.evaluateString(script,info,"Javascript",1,null).toString();
            return reslt;
        }catch (Exception e){
            return "Syntax error";
        }
    }
}

