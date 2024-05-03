package com.example.appcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Vincular los elementos a sus Id
        val campoNum1: EditText = findViewById(R.id.edText_num1)
        val campoNum2: EditText = findViewById(R.id.edText_num2)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val txtResultado: TextView = findViewById(R.id.txtResultado)

        val btnSuma: ImageButton = findViewById(R.id.btnSum)
        val btnResta: ImageButton = findViewById(R.id.btnRes)
        val btnMulti: ImageButton = findViewById(R.id.btnMult)
        val btnDivi: ImageButton = findViewById(R.id.btnDiv)

        val imagenOpc: ImageView = findViewById(R.id.imgOperacion)
        var tipoOperacion = 0

        btnCalcular.setOnClickListener(){
            if (tipoOperacion >= 1 && tipoOperacion <= 4){ //tipoOperacion >= 1 && tipoOperacion <= 4
                if(campoNum1.text.isNotEmpty() && campoNum2.text.isNotEmpty()){
                    //Toast.makeText(this, "Todo Ok", Toast.LENGTH_SHORT).show()

                    if (tipoOperacion == 1){
                        val resultadoSuma = calcSuma(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                        txtResultado.text = resultadoSuma
                    } else if (tipoOperacion == 2){
                        val resultadoResta = calcResta(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                        txtResultado.text = resultadoResta
                    } else if (tipoOperacion == 3){
                        val resultadoMulti = calcMulti(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                        txtResultado.setText(resultadoMulti)
                    } else if (tipoOperacion == 4){
                        val resultadoDivi = calcDivi(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                        txtResultado.setText(resultadoDivi)
                    }

                }else{
                    Toast.makeText(this, "Los campos No deben estar vacios", Toast.LENGTH_SHORT).show()
                }

            } else{

                when (tipoOperacion){
                    0 -> Toast.makeText(this, "Seleccione Una Operación", Toast.LENGTH_SHORT).show()
                    1 -> calcSuma(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                    2 -> calcResta(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                    3 -> calcMulti(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                    4 -> calcDivi(campoNum1.text.toString().toDouble(), campoNum2.text.toString().toDouble())
                    else -> Toast.makeText(this, "Seleccione Una Operación", Toast.LENGTH_SHORT).show()
                }
            }

        }

        btnSuma.setOnClickListener(){
            imagenOpc.setImageResource(R.drawable.black_suma)
            tipoOperacion = 1
        }

        btnResta.setOnClickListener(){
            imagenOpc.setImageResource(R.drawable.black_resta)
            tipoOperacion = 2
        }

        btnMulti.setOnClickListener(){
            imagenOpc.setImageResource(R.drawable.black_multi)
            tipoOperacion = 3
        }

        btnDivi.setOnClickListener(){
            imagenOpc.setImageResource(R.drawable.black_divi)
            tipoOperacion = 4
        }

    }

    fun calcSuma(numero1:Double, numero2:Double):String{
        val result:Double = numero1 + numero2
        return result.toString()
    }

    fun calcResta(numero1:Double, numero2:Double):String{
        val result:Double = numero1 - numero2
        return result.toString()
    }

    fun calcMulti(numero1:Double, numero2:Double):String{
        val result:Double = numero1 * numero2
        return result.toString()
    }

    fun calcDivi(numero1:Double, numero2:Double):String{
        val result: Double = numero1 / numero2
        return result.toString()
    }

}
