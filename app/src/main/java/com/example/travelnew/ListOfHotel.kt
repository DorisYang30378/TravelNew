package com.example.travelnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelnew.ui.theme.TravelNewTheme
import kotlinx.coroutines.CoroutineScope

class ListOfHotel : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold2()
                }
            }
        }
    }
}
@Composable
fun MyScaffold2() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = {HotelList() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        // bottomBar = { MyBottomAppBar() },
        drawerContent = { drawerContent()}
    )
}


@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    TravelNewTheme {
        Greeting4("Android")
    }
}


private val items = listOf(
    HotelCategory(
        R.string.android,
        listOf(
            R.drawable.pei31,
            R.drawable.pei32,
            R.drawable.pei33
        )

    ),
    HotelCategory(
        R.string.kotlin,
        listOf(
            R.drawable.chung31,
            R.drawable.chung32,
            R.drawable.chung33
        )
    ),
    HotelCategory(
        R.string.swift,
        listOf(
            R.drawable.nan31,
            R.drawable.nan32,
            R.drawable.nan33,
        )
    ),
)

@Composable
fun HotelList() {
    MyhotelList()
}
@Composable
fun MyhotelList() {
    LazyColumn {
        items(items) { item -> ListHotelItem(item) }
    }
}


@Composable
fun ListHotelItem(HotelCategory: HotelCategory, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(id=R.string.android),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = modifier.height(8.dp)
        )

        LazyRow {
            items(HotelCategory.HotelImageResources) { items ->
                HotelImageA(items)
            }
        }
    }

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(id=R.string.kotlin),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = modifier.height(8.dp)
        )

        LazyRow {
            items(HotelCategory.HotelImageResources) { items ->
                HotelImageB(items)
            }
        }
    }

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(id=R.string.swift),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = modifier.height(8.dp)
        )

        LazyRow {
            items(HotelCategory.HotelImageResources) { items ->
                HotelImageC(items)
            }
        }
    }
}





@Composable
fun HotelImageA(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel1::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei31),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }

    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel2::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei32),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }

    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel3::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei33),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }


}

@Composable
fun HotelImageB(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel4::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung31),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel5::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung32),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel6::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung33),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
}

@Composable
fun HotelImageC(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel7::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan31),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel8::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan32),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Hotel9::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan33),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
}

data class HotelCategory(@StringRes val categoryResourceId: Int, val HotelImageResources: List<Int>)