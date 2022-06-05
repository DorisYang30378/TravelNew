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

class Hotel6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold27()
                }
            }
        }
    }
}

@Composable
fun MyScaffold27() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = { Mycard23() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        // bottomBar = { MyBottomAppBar() },
        drawerContent = { drawerContent()}
    )
}

@Composable
fun Mycard23() {
    Card {
        val paddingModifier = Modifier.padding(0.dp)
        Card(shape = RoundedCornerShape(0.dp), elevation = 10.dp, modifier = paddingModifier) {
            Column() {
                Row() {
                    androidx.compose.foundation.Image(
                        painter = painterResource(R.drawable.chung33),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 130.dp).fillMaxWidth()
                    )
                }
                Row() {
                    Text(
                        text = "「七天四季」一棟以四季打造的療癒系民宿，每個房間採用不同月份來命名，非常的有趣！",
                        modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp),
                        fontSize = 20.sp
                    )
                }

            }

        }
    }
}