package com.example.travelnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelnew.ui.theme.TravelNewTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    MyScaffold()
                }
            }
        }
    }
}

@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        content = { ExploreButtonsScreen()  },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        drawerContent = { drawerContent()}
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {

    val drawerState = scaffoldState.drawerState

    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = stringResource(R.string.menu)
                    )
                },
                onClick = {
                    scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() }
                }
            )
        },
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        backgroundColor = colorResource(id = R.color.topBar)
    )
}
@Composable
fun drawerContent() {
        val mContext= LocalContext.current
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly ,
            modifier = Modifier.fillMaxWidth().height(80.dp)
                .background(color = colorResource(id = R.color.topBar)),
            ) {
            Text(text = "Travel", fontSize = 28.sp, color = Color.White)
        }
       TextButton(onClick = {  mContext.startActivity(Intent(mContext,SecondActivity::class.java))},
          Modifier.size(width = 1000.dp, height = 60.dp)) {
          Text(text = "主選單", fontSize = 24.sp,color= colorResource(id = R.color.topBar))
       }
       TextButton(onClick = {  mContext.startActivity(Intent(mContext,ListOfFood::class.java)) },
          Modifier.size(width = 1000.dp, height = 60.dp)) {
          Text(text = "美食", fontSize = 24.sp,color= colorResource(id = R.color.topBar))
       }
        TextButton(onClick = {
            mContext.startActivity(Intent(mContext,ListOfView::class.java))
        },Modifier.size(width = 1000.dp, height = 60.dp)) {
            Text(text = "景點", fontSize = 24.sp,color= colorResource(id = R.color.topBar))
        }

        TextButton(onClick = {  mContext.startActivity(Intent(mContext,ListOfHotel::class.java))},Modifier.size(width = 1000.dp, height = 60.dp)) {
            Text(text = "住宿", fontSize = 24.sp,color= colorResource(id = R.color.topBar))
        }


}
@Composable
fun ExploreButtonsScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(-20.dp)
    ) {

        MyButton()
        MyButton1()
        MyButton2()
    }

}

@Composable
fun MyButton() {
    val mContext= LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(60.dp)
        //modifier = Modifier.fillMaxSize(),
    ) {
        Image()
        Button(
            onClick = {
                mContext.startActivity(Intent(mContext,ListOfFood::class.java))
            },

            elevation = ButtonDefaults.elevation(10.dp, 20.dp, 10.dp),
            modifier = Modifier.size(width = 100.dp,height = 60.dp),
            shape = RoundedCornerShape(topStart = 10.dp,topEnd = 10.dp,bottomEnd = 10.dp,bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.topBar)),
            border = BorderStroke(
                0.5.dp,
                color = colorResource(id = R.color.topBar)

            )
        ) {
            Text(
                text = stringResource(id = R.string.button_text),
                fontSize = 24.sp,
                color = Color.White
            )


        }
        Column() {

        }


    }
}

@Composable
fun Image() {
    androidx.compose.foundation.Image(

        painter = painterResource(id = R.drawable.food),

        null,
        modifier = Modifier.size(220.dp,200.dp),
        //contentScale = ContentScale.Inside
    )
}
@Composable
fun Image1() {
    androidx.compose.foundation.Image(

        painter = painterResource(id = R.drawable.viewpoint),

        null,
        modifier = Modifier.size(250.dp,220.dp),
        //contentScale = ContentScale.Inside
    )
}
@Composable
fun Image2() {
    androidx.compose.foundation.Image(

        painter = painterResource(id = R.drawable.hotel),

        null,
        modifier = Modifier.size(250.dp,220.dp),
        //contentScale = ContentScale.Inside
    )
}



@Composable
fun MyButton1() {
    val mContext= LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(35.dp)
        // modifier = Modifier.fillMaxSize()
    ) {
        Column() {

        }
        Column() {

        }
        Button(
            onClick = { mContext.startActivity(Intent(mContext, ListOfView::class.java)) },
            modifier = Modifier.size(width = 100.dp,height = 60.dp),
            elevation = ButtonDefaults.elevation(10.dp, 20.dp, 10.dp),
            shape = RoundedCornerShape(topStart = 10.dp,topEnd = 10.dp,bottomEnd = 10.dp,bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.topBar)),
            border = BorderStroke(
                0.5.dp,
                color = colorResource(id = R.color.topBar)
            )
        ) {
            Text(
                text = stringResource(id = R.string.button_text1),
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Image1()
        Column() {

        }
    }
}

@Composable
fun MyButton2() {
    val mContext= LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(40.dp)
        //  modifier = Modifier.fillMaxSize()
    ) {

        Image2()
        Button(
            onClick = {mContext.startActivity(Intent(mContext,ListOfHotel::class.java))},
            elevation = ButtonDefaults.elevation(10.dp, 20.dp, 10.dp),
            modifier = Modifier.size(width = 100.dp,height = 60.dp),
            shape = RoundedCornerShape(topStart = 10.dp,topEnd = 10.dp,bottomEnd = 10.dp,bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.topBar)),
            border = BorderStroke(
                0.5.dp,
                color = colorResource(id = R.color.topBar)
            )
        ) {
            Text(
                text = stringResource(id = R.string.button_text2),
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Column() {

        }
        Column() {

        }
    }
}




