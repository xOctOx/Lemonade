package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeWithTextImgAndBtn(Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeWithTextImgAndBtn(modifier: Modifier = Modifier) {
    var etat by remember { mutableStateOf(1) }

    val images = when (etat) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val textDescription = when (etat) {
        1 -> R.string.lemon_select
        2 -> R.string.lemon_squeeze
        3 -> R.string.lemon_drink
        4 -> R.string.lemon_restart
        else -> R.string.lemon_select
    }

    val imageContentDescription = when (etat) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.lemonade_content_description
        4 -> R.string.empty_glass_content_description
        else -> R.string.lemon_tree_content_description
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(images),
            contentDescription = stringResource(imageContentDescription),
            modifier = Modifier.clickable {
                if (etat == 4) {
                    etat = 1
                } else {
                    etat = etat + 1
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(textDescription))
    }
}