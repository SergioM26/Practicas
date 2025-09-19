package com.example.practicas

import android.R
import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PracticasTheme
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculadora()
                }
            }
        }
    }
}

@Composable
fun Calculadora() {

    var currentInput by remember { mutableStateOf(TextFieldValue("")) }
    var previousValue by remember { mutableStateOf<Double?>(null) }
    var operator by remember { mutableStateOf<String?>(null)}

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row( // Operaciones
            modifier = Modifier.fillMaxWidth().weight(1.5f),
        ) {
            TextField(
                value = currentInput,
                onValueChange = { currentInput = it },
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                textStyle = TextStyle(
                    fontSize = 48.sp,
                    textAlign = TextAlign.Right,
                )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    currentInput = TextFieldValue("")
                    previousValue = null
                    operator = null
                },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("C", modifier = Modifier.scale(1.7f))
            }

            Button(
                onClick = {
                    if (previousValue != null && operator != null && currentInput.text.isNotEmpty()) {
                        previousValue = when (operator) {
                            "+" -> previousValue!! + currentInput.text.toDouble()
                            "-" -> previousValue!! - currentInput.text.toDouble()
                            "*" -> previousValue!! * currentInput.text.toDouble()
                            "/" -> previousValue!! / currentInput.text.toDouble()
                            else -> currentInput.text.toDouble()
                        }
                        currentInput = TextFieldValue(previousValue.toString())
                        previousValue = null
                        operator = null
                    }
                },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("=", modifier = Modifier.scale(1.7f))
            }

            Button(
                onClick = {
                    if (currentInput.text.isNotEmpty()) {
                        currentInput = TextFieldValue(currentInput.text.dropLast(1))
                    }
                },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_input_delete),
                    contentDescription = ""
                )
            }
        }

        fun operatorClick(op: String) {
            if (previousValue != null && operator != null && currentInput.text.isNotEmpty()) {
                previousValue = when (operator) {
                    "+" -> previousValue!! + currentInput.text.toDouble()
                    "-" -> previousValue!! - currentInput.text.toDouble()
                    "*" -> previousValue!! * currentInput.text.toDouble()
                    "/" -> previousValue!! / currentInput.text.toDouble()
                    else -> currentInput.text.toDouble()
                }
            } else if (currentInput.text.isNotEmpty()) {
                previousValue = currentInput.text.toDouble()
            }
            currentInput = TextFieldValue("")
            operator = op
        }

        // Primera fila: 7, 8, 9, /
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("7","8","9").forEach { num ->
                Button(
                    onClick = { currentInput = currentInput.copy(text = currentInput.text + num) },
                    modifier = Modifier.weight(1f).fillMaxHeight(.7f)
                ) {
                    Text(num, modifier = Modifier.scale(1.7f))
                }
            }
            Button(
                onClick = { operatorClick("/") },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("/", modifier = Modifier.scale(1.7f))
            }
        }

        // Segunda fila: 4, 5, 6, *
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("4","5","6").forEach { num ->
                Button(
                    onClick = { currentInput = currentInput.copy(text = currentInput.text + num) },
                    modifier = Modifier.weight(1f).fillMaxHeight(.7f)
                ) {
                    Text(num, modifier = Modifier.scale(1.7f))
                }
            }
            Button(
                onClick = { operatorClick("*") },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("X", modifier = Modifier.scale(1.7f))
            }
        }

        // Tercera fila: 1, 2, 3, -
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("1","2","3").forEach { num ->
                Button(
                    onClick = { currentInput = currentInput.copy(text = currentInput.text + num) },
                    modifier = Modifier.weight(1f).fillMaxHeight(.7f)
                ) {
                    Text(num, modifier = Modifier.scale(1.7f))
                }
            }
            Button(
                onClick = { operatorClick("-") },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("-", modifier = Modifier.scale(1.7f))
            }
        }

        // Cuarta fila: 0, ., +
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + ".") },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text(".", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "0") },
                modifier = Modifier.weight(2f).fillMaxHeight(.7f)
            ) {
                Text("0", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { operatorClick("+") },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("+", modifier = Modifier.scale(1.7f))
            }
        }
    }
}
/*
fun operacion(operador: Char){
    val previusValue = when (operador) {
        '+' -> previusValue!!.plus(currentInput.toString().toDouble())
        '-' -> previusValue!!.rem(currentInput.toString().toDouble())
        '*' -> previusValue!!.times(currentInput.toString().toDouble())
        '/' -> previusValue!!.div(currentInput.toString().toDouble())
        else -> 0
    }
    //answer = previusValue.toString()
}*/