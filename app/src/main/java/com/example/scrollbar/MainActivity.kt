package com.example.scrollbar

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scrollbar.ui.theme.ScrollBarTheme

class MainActivity : ComponentActivity() {
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button10: Button
    private lateinit var button11: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button)
        button3 = findViewById(R.id.button)
        button4 = findViewById(R.id.button)
        button5 = findViewById(R.id.button)
        button6 = findViewById(R.id.button)
        button7 = findViewById(R.id.button)
        button8 = findViewById(R.id.button)
        button10 = findViewById(R.id.button)
        button11 = findViewById(R.id.button)

        button.setOnClickListener {

        }

        setContent {
            ScrollBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScrollBarTheme {
        Greeting("Android")
    }
}