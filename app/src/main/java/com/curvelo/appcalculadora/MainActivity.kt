package com.curvelo.appcalculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.curvelo.appcalculadora.ui.theme.AppCalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCalculadoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  TelaCalculadora()
                }
            }
        }
    }
}


@Composable
fun TelaCalculadora() {

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Calculadora")});
        }, content = {
            Column(
                modifier = Modifier.padding(10.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                var valorA by remember{
                    mutableStateOf("")

                }
                var valorB by remember{
                    mutableStateOf("")

                }

                var resultado by remember{
                    mutableStateOf("")

                }
                OutlinedTextField(
                    value = valorA,
                    label = {Text("Informe o valor A")},
                    onValueChange = {valorA = it},
                    modifier = Modifier.fillMaxWidth()


                )

                OutlinedTextField(
                    value = valorB,
                    label = {Text("Informe o valor B")},
                    onValueChange = {valorB = it},
                    modifier = Modifier.fillMaxWidth()

                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        val vA = valorA.toDouble()
                        val vB = valorB.toDouble()

                        val soma = vA + vB

                        resultado = soma.toString()

                              },
                    modifier = Modifier.fillMaxWidth()


                ) {
                    Text("Calcular")
                }
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = resultado,
                    label = {Text("Informe o valor B")},
                    onValueChange = {resultado = it},
                    modifier = Modifier.fillMaxWidth()

                )
                
                }
                
            }

        )
    }



