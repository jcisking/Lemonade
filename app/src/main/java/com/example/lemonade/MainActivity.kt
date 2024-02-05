package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = modifier.background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LemonadeTopAppBar()
        Spacer(modifier = Modifier.fillMaxSize(.3f))
        LemonadeImageAndInstruction(
            modifier = Modifier
                .background(Color.Blue)
            

        )
    }

}

@Composable
fun LemonadeTopAppBar(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.top_app_bar),
        color = Color.Black,
        modifier = modifier
            .background(Color.Yellow)
    )
}

@Composable
fun LemonadeImageAndInstruction(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.lemon_drink),
            modifier = Modifier
                .padding(bottom = 24.dp)
                .background(Color.Green, RoundedCornerShape(100f))
                .padding(40.dp),
            contentDescription = null
        )
        Text(text = stringResource(id = R.string.full_glass_string))
    }
}

