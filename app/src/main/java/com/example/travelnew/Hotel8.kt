package com.example.travelnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelnew.ui.theme.TravelNewTheme
import kotlinx.coroutines.CoroutineScope

class Hotel8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold29()
                }
            }
        }
    }
}


@Composable
fun MyScaffold29() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = { Mycard25() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        // bottomBar = { MyBottomAppBar() },
        drawerContent = { drawerContent()}
    )
}

@Composable
fun Mycard25() {
    Card {
        val paddingModifier = Modifier.padding(0.dp)
        Card(shape = RoundedCornerShape(0.dp), elevation = 10.dp, modifier = paddingModifier) {
            Column() {
                Row() {
                    androidx.compose.foundation.Image(
                        painter = painterResource(R.drawable.nan32),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 130.dp).fillMaxWidth()
                    )
                }
                Row() {
                    Text(
                        text = "「玩聚安平」前身為玩具工廠，所以在設計師的改造下，成了一間充滿工業風與童趣的創意民宿。",
                        modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp),
                        fontSize = 20.sp
                    )
                }

            }

        }
    }
}