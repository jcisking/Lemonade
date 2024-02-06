package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()

                }
            }
        }
    }
}


@Composable
@Preview
fun LemonadeApp(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LemonadeTopAppBar()
        Spacer(modifier = Modifier.fillMaxSize(.2f))
        LemonadeImageAndInstruction(
            modifier = Modifier
        )
    }

}

@Composable
fun LemonadeTopAppBar(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.top_app_bar),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(top = 15.dp, bottom = 15.dp)
    )
}

@Composable
fun LemonadeImageAndInstruction(
    modifier: Modifier = Modifier
) {
    val list = listOf(
        Pair(R.drawable.lemon_tree, R.string.lemon_tree_string),
        Pair(R.drawable.lemon_squeeze, R.string.lemon_squeeze_string),
        Pair(R.drawable.lemon_drink, R.string.lemon_drink_string),
        Pair(R.drawable.lemon_restart, R.string.lemon_restart_string)
    )
    var imageTextPair by remember { mutableStateOf(list[0]) }
    var ranNum by remember { mutableStateOf(1) }

    val callBack = {
        if (imageTextPair == list[0]) {
            imageTextPair = list[1]
            ranNum = (3..5).random()
        } else if (imageTextPair == list[1]) {
            ranNum--
            if (ranNum == 0) {
                imageTextPair = list[2]
            }
        } else if (imageTextPair == list[2]) {
            imageTextPair = list[3]
        } else {
            imageTextPair = list[0]
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Button(
            onClick = { callBack() },
            shape = RoundedCornerShape(100f),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = imageTextPair.first),
                modifier = Modifier
                    .background(Color.Green)
                    .padding(40.dp),
                contentDescription = null
            )
        }
        Text(text = stringResource(id = imageTextPair.second))
    }
}


