package com.example.hng_stage_two

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hng_stage_two.ui.theme.HNG_stage_twoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HNG_stage_twoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UserData()
                }
            }
        }
    }
}

@Composable
fun UserData() {
    var text by  remember{ mutableStateOf("") }
    var display by remember { mutableStateOf(false)}

    Scaffold(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it},
                    placeholder = {Text(text = "Input your name")}
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { display = true },
                    enabled = text.isNotEmpty()
                ) {
                    Text(text = "Submit")
                }
                Spacer(modifier = Modifier.height(10.dp))
                if(display && text.isNotEmpty()){
                    Text(
                        text = "Hello $text",
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HNG_stage_twoTheme {
        //Greeting("Android")
    }
}