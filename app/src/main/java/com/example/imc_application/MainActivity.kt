package com.example.imc_application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcularBTN.setOnClickListener {
            if (pesoTXT.text.toString() != "" && alturaEDT.text.toString() != "") {
                val imc = calcIMC(pesoTXT.text.toString(), alturaEDT.text.toString())
                val df = DecimalFormat("#.00")
                val resultado = "IMC: " + df.format(imc) + "\n" + checkIMC(imc)
                resultadoIMC.text = resultado
            } else {
                resultadoIMC.text = "valores nulos."
            }
        }
    }
}
    private fun calcIMC (peso: String, altura: String):
            Double = peso.toDouble() / (altura.toDouble() * altura.toDouble())
private fun checkIMC(db:Double): String{
  return when(db){

        in 0.0..18.49 -> "Abaixo do peso"
        in 18.5..24.99 -> "Peso normal"
        in 25.0..29.99 ->  "Acima do peso"
        in 30.0..34.99 -> "Obesidade I"
        in 35.0..39.99 -> "Obesidade II(severa)"
        else -> "Obesidade III(mórbida)"
    }
}






