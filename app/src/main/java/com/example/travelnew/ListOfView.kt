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

class ListOfView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold3()
                }
            }
        }
    }
}
@Composable
fun MyScaffold3() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = { ListScreen() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        // bottomBar = { MyBottomAppBar() },
        drawerContent = { drawerContent()}
    )
}

@Composable
fun Greeting5(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    TravelNewTheme {
        Greeting5("Android")
    }
}

private val items = listOf(
    BookCategory(
        R.string.android,
        listOf(
            R.drawable.pei1,
            R.drawable.pei2,
            R.drawable.pei3
        )

    ),
    BookCategory(
        R.string.kotlin,
        listOf(
            R.drawable.chung1,
            R.drawable.chung2,
            R.drawable.chung3
        )
    ),
    BookCategory(
        R.string.swift,
        listOf(
            R.drawable.nan1,
            R.drawable.nan2,
            R.drawable.nan3,
        )
    ),
)



@Composable
fun ListScreen() {
    MyList()
}
@Composable
fun MyList() {
    LazyColumn {
        items(items) { item -> ListItem(item) }
    }
}


@Composable
fun ListItem(bookCategory: BookCategory, modifier: Modifier = Modifier) {
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
            items(bookCategory.bookImageResources) { items ->
                BookImage(items)
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
            items(bookCategory.bookImageResources) { items ->
                BookImageC(items)
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
            items(bookCategory.bookImageResources) { items ->
                BookImageNAN(items)
            }
        }
    }
}



@Composable
fun BookImage(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {  mContext.startActivity(Intent(mContext,ViewFirst::class.java))},
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp,200.dp),
            painter = painterResource(id = R.drawable.pei1),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }

    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewSecond::class.java))
    },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei2),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }

    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewThird::class.java)) },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.pei3),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }


}

@Composable
fun BookImageC(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewForth::class.java))},
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung1),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewFifth::class.java))
                      },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung2),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewSixth::class.java))
                      },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.chung3),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
}

@Composable
fun BookImageNAN(imageResource: Int) {
    val mContext= LocalContext.current
    val materialBlue700= Color(0xFF1976D2)
    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewSeventh::class.java)) },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan1),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewEighth::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan2),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
    Button(onClick = {
        mContext.startActivity(Intent(mContext,ViewNinth::class.java))
                     },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier.size(170.dp, 200.dp),
            painter = painterResource(id = R.drawable.nan3),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.book_image)
        )
    }
}

data class BookCategory(@StringRes val categoryResourceId: Int, val bookImageResources: List<Int>)