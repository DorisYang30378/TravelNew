package com.example.travelnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
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
import kotlinx.coroutines.launch

class ListOfFood : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold1()

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TravelNewTheme {
        Greeting2("Android")
    }
}

private val items = listOf(
    FoodCategory(
        R.string.android,
        listOf(
            R.drawable.pei21,
            R.drawable.pei22,
            R.drawable.pei23
        )

    ),
    FoodCategory(
        R.string.kotlin,
        listOf(
            R.drawable.chung21,
            R.drawable.chung22,
            R.drawable.chung23
        )
    ),
    FoodCategory(
        R.string.swift,
        listOf(
            R.drawable.nan1,
            R.drawable.nan2,
            R.drawable.nan3,
        )
    ),
)

@Composable
fun FoodList() {
    MyfoodList()
}
@Composable
fun MyfoodList() {
    LazyColumn {
        items(items) { item -> ListFoodItem(item) }
    }
}


@Composable
fun ListFoodItem(FoodCategory: FoodCategory, modifier: Modifier = Modifier) {
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
            items(FoodCategory.FoodImageResources) { items ->
                FoodImageA(items)
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
            items(FoodCategory.FoodImageResources) { items ->
                FoodImageB(items)
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
            items(FoodCategory.FoodImageResources) { items ->
                FoodImageC(items)
            }
        }
    }
}





@Composable
fun FoodImageA(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food1::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei21),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }

    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food2::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei22),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }

    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food3::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei23),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }


}

@Composable
fun FoodImageB(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food4::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung21),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food5::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung22),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food6::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung23),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
}

@Composable
fun FoodImageC(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food7::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan21),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food8::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan22),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,Food9::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan23),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
}

data class FoodCategory(@StringRes val categoryResourceId: Int, val FoodImageResources: List<Int>)

@Composable
fun MyScaffold1() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = { FoodList() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        // bottomBar = { MyBottomAppBar() },
        drawerContent = { drawerContent()}
    )
}

