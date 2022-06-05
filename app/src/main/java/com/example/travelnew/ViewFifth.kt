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

class ViewFifth : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold8()
                }
            }
        }
    }
}

@Composable
fun MyScaffold8() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = { Mycard4() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        // bottomBar = { MyBottomAppBar() },
        drawerContent = { drawerContent()}
    )
}

@Composable
fun Mycard4() {
    Card {
        val paddingModifier = Modifier.padding(0.dp)
        Card(shape = RoundedCornerShape(0.dp), elevation = 10.dp, modifier = paddingModifier) {
            Column() {
                Row() {
                    androidx.compose.foundation.Image(
                        painter = painterResource(R.drawable.chung2),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 130.dp).fillMaxWidth()
                    )
                }
                Row() {
                    Text(
                        text = "「高美濕地」位於台中市清水區西側出海口，是綜合淡水注水與潮汐交替所構成的海岸溼地。",
                        modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp),
                        fontSize = 20.sp
                    )
                }

            }

        }
    }
}