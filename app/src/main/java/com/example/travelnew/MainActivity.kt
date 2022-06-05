package com.example.travelnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelnew.ui.theme.TravelNewTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldDemo()
                }
            }
        }
    }
}

@Composable
fun ScaffoldDemo() {
    val scope: CoroutineScope = rememberCoroutineScope()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(scaffoldState = scaffoldState, scope = scope)
        },
        drawerContent = {},
        content = {
            MyMButton()
        },
    )
}

@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope){
    val materialBlue700= Color(0xFF1976D2)
    val drawerState = scaffoldState.drawerState
    TopAppBar(
        title = {
            Text("TRAVEL",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.size(250.dp),
                fontSize = 45.sp
            )

        },
        navigationIcon = {},
        elevation = 12.dp,
        backgroundColor = materialBlue700
    )
}

@Composable
fun MyMButton(){
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(
        onClick = {
           mContext.startActivity(Intent(mContext,SecondActivity::class.java))
        },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    )

    {
        Image(
            painter = painterResource(id = R.drawable.earth) ,
            contentDescription = "",
            modifier=Modifier.fillMaxSize()
        )

        Text(text = "TRAVEL")
    }
}

