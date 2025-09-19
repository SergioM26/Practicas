package com.example.practicas

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PracticasTheme

data class RangoISR(
    val limiteInferior: Double,
    val limiteSuperior: Double?,
    val cuotaFija: Double,
    val porcentaje: Double
)

val tablaISR = listOf(
    RangoISR(0.01, 746.04, 0.0, 1.92),
    RangoISR(746.05, 6332.05, 14.32, 6.40),
    RangoISR(6332.06, 11128.01, 371.83, 10.88),
    RangoISR(11128.02, 12935.82, 893.63, 16.00),
    RangoISR(12935.83, 15487.71, 1182.88, 17.92),
    RangoISR(15487.72, 31236.49, 1640.18, 21.36),
    RangoISR(31236.50, 49233.00, 5004.12, 23.52),
    RangoISR(49233.01, 93993.90, 9236.89, 30.00),
    RangoISR(93993.91, 125325.20, 22665.17, 32.00),
    RangoISR(125325.21, 375975.61, 32691.18, 34.00),
    RangoISR(375975.62, null, 117912.32, 35.00)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            interfaz()
        }
    }
}

fun calcularISR(salarioBruto: Double): Pair<Double, Double> {
    val rango = tablaISR.find {
        it.limiteSuperior?.let { sup -> salarioBruto <= sup } ?: true
                && salarioBruto >= it.limiteInferior
    } ?: return 0.0 to salarioBruto // fallback, no debería pasar

    val excedente = salarioBruto - rango.limiteInferior
    val isr = rango.cuotaFija + (rango.porcentaje / 100 * excedente)
    val salarioNeto = salarioBruto - isr
    return isr to salarioNeto
}

@Preview(showBackground = true)
@Composable
fun interfaz() {
    var SalarioB by remember { mutableStateOf(TextFieldValue("")) }
    var ISR by remember { mutableStateOf(TextFieldValue("")) }
    var SalarioN by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = SalarioB,
            onValueChange = { SalarioB = it },
            label = { Text("Sueldo Bruto") },
            placeholder = { Text("Ingrese su sueldo mensual") },
            singleLine = true
        )

        Button(onClick = {
            val salario = SalarioB.text.toDoubleOrNull() ?: 0.0
            val (isr, salarioNeto) = calcularISR(salario)
            ISR = TextFieldValue(String.format("%.2f", isr))
            SalarioN = TextFieldValue(String.format("%.2f", salarioNeto))
        }) {
            Text("Calcular")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "ISR = ", style = MaterialTheme.typography.bodyLarge)
            TextField(
                value = ISR,
                onValueChange = { },
                readOnly = true
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Salario Neto = ", style = MaterialTheme.typography.bodyLarge)
            TextField(
                value = SalarioN,
                onValueChange = { },
                readOnly = true
            )
        }
    }
}