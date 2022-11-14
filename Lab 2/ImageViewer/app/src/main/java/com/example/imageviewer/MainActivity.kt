package com.example.imageviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imageviewer.ui.theme.ImageViewerTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun ChangeImage(clicked: ()->Unit){
    Button(onClick = clicked) {
        Text(text = stringResource(id = R.string.buttonChangeImage))
    }
}

@Composable
fun MessageText(newName: String) {
    if (newName.isNotEmpty()) {
        Text(
            text = stringResource(id = R.string.greeting) + " " + newName,
            color = Color.Blue,
            fontSize = 35.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun NameTextField(name: String, changed: (String)->Unit){
    TextField(
        value = name,
        label = {Text(stringResource(id = R.string.enterName))},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=10.dp)
    )
}

@Composable
fun ShowImage(image: Int){
    Image(painter = painterResource(id = image),
        contentDescription = "",
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp)
            .height(300.dp)
            .width(300.dp)
            .fillMaxHeight()
            .clip(shape = CircleShape)
            .background(color = Color.White)
    )
}

@Composable
fun Greeting() {
    val name = remember{ mutableStateOf("Default") }
    val idx = remember{ mutableStateOf(0) }
    val textFieldName = remember { mutableStateOf(("")) }
    val listOfImages = listOf(R.drawable.debby1, R.drawable.debby2, R.drawable.debby3, R.drawable.debby4,
                                R.drawable.lola1, R.drawable.lola2, R.drawable.lola3, R.drawable.lola4)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        NameTextField(name = textFieldName.value, changed = {textFieldName.value = it})
        ChangeImage ({idx.value = (0..listOfImages.size-1).random();
        name.value = textFieldName.value})
        ShowImage(listOfImages[idx.value]);
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Black)

        ) {
            MessageText(newName = name.value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageViewerTheme {
        Greeting()
    }
}