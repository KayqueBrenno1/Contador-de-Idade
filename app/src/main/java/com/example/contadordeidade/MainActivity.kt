package com.example.contadordeidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contadordeidade.ui.theme.ContadorDeIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorDeIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    var aumentarDiminuir by remember {
        mutableStateOf(0)
    }
    var statusIdade = ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F8FC)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual é a sua idade?",
            color = Color.Blue,
            fontSize = 25.sp
        )

        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Text(
            text = aumentarDiminuir.toString(),
            fontSize = 25.sp,
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(
                onClick = {
                    if (aumentarDiminuir < 180)
                        aumentarDiminuir ++
                    else
                        aumentarDiminuir = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                modifier = Modifier
                    .size(50.dp),
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = {
                    if (aumentarDiminuir > 0)
                        aumentarDiminuir --
                    else
                        aumentarDiminuir = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                modifier = Modifier
                    .size(50.dp),
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            ) {
                Text(
                    text = "-",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Row() {
            if (aumentarDiminuir < 18)
                statusIdade = "MENOR"
            else
                statusIdade = "MAIOR"

            Text(
                text = "Você é $statusIdade de idade",
                fontSize = 25.sp,
                color = Color.Blue
            )
        }
    }
}