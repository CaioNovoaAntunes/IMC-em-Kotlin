package br.com.example.versiononecaio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Executando (escutando) o clique do botão entrar
        btnMainCalc.setOnClickListener {
            calculoIMC()

        }
    }

    private fun calculoIMC() {
        var calculoAltura = calcMA.text.toString().trim()
        var calculoPeso = calcMP.text.toString().trim()


        //validação dos campos
        if (calculoAltura.isEmpty()) {
            calcMA.error = "Este Campo não pode  ficar vazio"

        } else if (calculoPeso.isEmpty()) {
            calcMP.error = "Este Campo não pode ficar vazio"
        } else {
            var mensagem = ""
            var resultado =
                calculoPeso.toDouble() / (calculoAltura.toDouble() * calculoAltura.toDouble())
            if (resultado <18.0) {
                mensagem = " muito Abaixo do Peso"
            } else if (resultado >= 18.0 && resultado < 24.9) {
                mensagem = "abaixo"
            } else if (resultado >= 24.9 && resultado < 29.9) {
                mensagem = "normal"

            }else if (resultado >= 29.9 && resultado < 34.9) {
                mensagem = "Obesidade I"
            }else if (resultado >= 34.9 && resultado < 39.9) {
                mensagem = "Obesidade  II (Severa)"
            } else {
                    mensagem = "Obesidade III (Mórbida)"
                }

             caixa.text = mensagem
            }

        }
    }