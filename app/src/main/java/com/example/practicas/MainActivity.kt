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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PracticasTheme

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
                    Greeting(
                        name = "Nombre",
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var currentInput by remember { mutableStateOf(TextFieldValue("")) }
    var previusValue by remember { mutableStateOf<Double?>(null)}
    var answer by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row( // Operaciones
            modifier = Modifier.fillMaxWidth().weight(1.5f),
        ) {
            TextField(
                value =currentInput,
                onValueChange = { currentInput= it },
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("C", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("=", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_input_delete),
                    contentDescription = ""
                )
            }
        }

        // Primera fila: 7, 8, 9, /
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.weight(1f).fillMaxHeight(.7f),
                onClick = {currentInput = currentInput.copy(text = currentInput.text + "7")
                }

            ) {
                Text("7", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "8")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("8", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "9")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("9", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("/", modifier = Modifier.scale(1.7f))
            }
        }

        // Segunda fila: 4, 5, 6, X
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "4")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("4", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "5")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("5", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "6")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("6", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { },
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
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "1")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("1", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "2")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("2", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "3")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("3", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("-", modifier = Modifier.scale(1.7f))
            }
        }

        // Cuarta fila: ., 0 , +
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + ".")},
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text(".", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { currentInput = currentInput.copy(text = currentInput.text + "0")},
                modifier = Modifier.weight(2f).fillMaxHeight(.7f)
            ) {
                Text("0", modifier = Modifier.scale(1.7f))
            }
            Button(
                onClick = { },
                modifier = Modifier.weight(1f).fillMaxHeight(.7f)
            ) {
                Text("+", modifier = Modifier.scale(1.7f))
            }
        }
    }
    fun operacion(char: Char){
        currentInput
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticasTheme {
        Greeting("Sergio Moreno")
    }
}