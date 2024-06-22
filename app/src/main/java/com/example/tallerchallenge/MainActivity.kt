package com.example.tallerchallenge

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tallerchallenge.entities.TitleAndDescription
import com.example.tallerchallenge.ui.theme.TallerChallengeTheme
import com.example.tallerchallenge.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by viewModels()

        setContent {
            TallerChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListWithTitleAndDescription(mainViewModel.titleList.value, context = this)
                }
            }
        }
    }
}

@Composable
fun ListWithTitleAndDescription(
    titleList: List<TitleAndDescription>,
    modifier: Modifier = Modifier,
    context: Context
) {

    Column(
        modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        LazyColumn(
            content = {
                items(titleList) { item ->
                    Surface(onClick = {
                        Toast.makeText(context, item.title, Toast.LENGTH_LONG).show()
                    }) {
                        Column(Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
                            Row {
                                Text(
                                    text = item.title,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row {
                                Text(text = item.description, maxLines = 2)
                            }
                            Divider()
                        }
                    }
                }
            },
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val titleList = arrayListOf<TitleAndDescription>(
        TitleAndDescription(
            "Lorem Ipsum sadadas dda dad ad ad adas dadasdsas",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ),
        TitleAndDescription("b", "bbbbbbbbbb"),
        TitleAndDescription("c", "ccccccccc"),
        TitleAndDescription("d", "ddddddddd"),
        TitleAndDescription("e", "eeeeeeeee"),
        TitleAndDescription("f", "fffffffff"),
    )

    TallerChallengeTheme {
//        ListWithTitleAndDescription(titleList, )
    }
}