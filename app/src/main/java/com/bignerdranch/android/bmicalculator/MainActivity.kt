package com.bignerdranch.android.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bignerdranch.android.bmicalculator.R.*
import com.bignerdranch.android.bmicalculator.R.id as rId

class MainActivity : AppCompatActivity() {
//
    override fun onCreate(savedInstanceState: Bundle?) {
//

val button:Button;
    val editTextH:EditText;
    val editTextW:EditText;
    val textbmi:TextView
    val textresult:TextView;






        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    editTextH=findViewById(rId.editH)
      textresult=findViewById(R.id.textView);
textbmi=findViewById(R.id.bmi)
    editTextW=findViewById(rId.editW)
button=findViewById(rId.Rbtn)

        button.setOnClickListener { view: View ->
            val weight:Double=editTextW.text.toString().toDouble()
         val height :Double = editTextH.text.toString().toDouble()
            val inM:Double=height/100;
            val BMI:Double=weight/(inM*inM);
            val BMIF:Int=BMI.toInt()
          textbmi.setText(BMIF.toString())
if(BMIF<18){
    val ideal:Int=22*(inM*2).toInt()
    textresult.text ="UnderWeight! Your Ideal Weight is $ideal-${ideal+5} kg"
}else{
    if (BMIF==18||BMIF<25){
        textresult.clearComposingText()
        textresult.text ="You Are in Heathly Rang !"
    }else{
        if (BMIF in 25..30){
            val ideal:Int=22*(inM*2).toInt()
            textresult.text ="OverWeight ! Your Ideal Weight is $ideal-${ideal+5} kg"
        }else{
            val ideal:Int=22*(inM*2).toInt()
            textresult.text ="Obese ! At high Rist, Ideal Weight $ideal-${ideal+5} kg "
        }
    }
}


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(rId.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}