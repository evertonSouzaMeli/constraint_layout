package br.com.fiap.constraints_layout_intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculaPreco()
    }


    private fun calculaPreco(){
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val editTextAlcool = findViewById<EditText>(R.id.editTextAlcool)
            val editTextGasolina = findViewById<EditText>(R.id.editTextGasolina)

            val precoAlcool = editTextAlcool.text.toString().toDouble()
            val precoGasolina = editTextGasolina.text.toString().toDouble()

            val resultado = precoAlcool / precoGasolina


            val mensagem = when{
                resultado > 0.7 -> "Gasolina"
                resultado < 0.7 -> "Alcool"
                else -> "Tanto faz"
            }

              val alert = AlertDialog.Builder(this)
                                     .setTitle("Resultado")
                                     .setMessage(mensagem)
                                     .setPositiveButton("OK", null)

            alert.create().show()
        }
    }
}