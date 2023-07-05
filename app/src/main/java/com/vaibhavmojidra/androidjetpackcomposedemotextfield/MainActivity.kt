package com.vaibhavmojidra.androidjetpackcomposedemotextfield

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val textState = remember { mutableStateOf(TextFieldValue()) }
                val context = LocalContext.current
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Enter text") }
                )

                Button(
                    onClick = {
                        val enteredText = textState.value.text
                        // Do something with the entered text
                        Toast.makeText(context,enteredText,Toast.LENGTH_LONG).show()
                    },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Submit")
                }
            }
        }
    }
}