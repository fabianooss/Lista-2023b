package com.example.lista

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lista.model.Produto
import com.example.lista.ui.theme.ListaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val produtos = listOf(
        Produto("Caneta", "Descrição da Caneta", 2.5),
        Produto("Monitor", "Descrição da Monitor", 900.0),
        Produto("Teclado", "Descrição da Teclado", 80.0)
    )

    LazyColumn() {
        items(items = produtos) {
            ProdutoApp(produto = it)
        }
    }
}

@Composable
fun ProdutoApp(produto: Produto) {
    val ctx = LocalContext.current
    Card(
         //elevation = 8.dp,   material 2
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                Toast.makeText(ctx,
                    "Produto: ${produto.nome}",
                    Toast.LENGTH_LONG
                ).show()
            }


    ) {
        Row(
            modifier = Modifier.
                    padding(4.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f, true)
            ) {
                Text(
                    text = produto.nome,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = produto.descricao,

                )
            }
            Text(
                text = "R$ ${produto.valor}",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(1f, true)
            )
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ListaTheme {
        MyApp()
    }
}