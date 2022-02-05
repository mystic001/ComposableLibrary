package com.example.mycomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeproject.ui.theme.MyComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeProjectTheme {
                MyApp()
            }
        }
    }
}


@Composable
private fun MyApp() {
    val names = listOf("Omonayin","Bamidele")
    GreetingPro(names)
}

@Composable
fun Greeting(name: String) {

    Surface( color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .fillMaxWidth(1f)
        ) {

        Row(modifier = Modifier.padding( 24.dp)) {
            Column(modifier = Modifier.weight(0.5f)) {
                Text("Hello,")
                Text(name)

            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                modifier = Modifier.weight(0.5f)
                // You'll learn about this callback later
            ) {
                Text("Show less")
            }
        }




    }
}


@Composable
fun GreetingPro(names: List<String>){
    Column{
        for(name in names ){
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeProjectTheme {
        Greeting("Android")
    }
}