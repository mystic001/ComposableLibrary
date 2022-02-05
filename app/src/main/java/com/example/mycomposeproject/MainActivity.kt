package com.example.mycomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.mycomposeproject.ui.theme.MyComposeProjectTheme
import androidx.compose.animation.core.spring
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeProjectTheme {
                MyApp()
            }
        }
    }
}


@Composable
private fun MyApp() {

    val names = listOf("Omonayin","Bamidele")
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    if (shouldShowOnboarding){
        Onboarding(onContinueClicked = {shouldShowOnboarding = false})

    }
        else
    Greetings()
}

@Composable
fun Greeting(name: String) {


    val expandable = rememberSaveable{mutableStateOf(false)}
    val extraPadding by animateDpAsState(if (expandable.value) 48.dp else 0.dp,
        animationSpec = spring(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow
    ))
    Surface( color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .fillMaxWidth(1f)
        ) {

        Row(modifier = Modifier.padding( 24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text("Hello,")
                Text(text = name, style = MaterialTheme.typography.h4)
                if (expandable.value) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }

            }

            IconButton(onClick ={
                expandable.value = !expandable.value
            }
            ){

             Icon(imageVector = if (expandable.value) Filled.ExpandLess else Filled.ExpandMore,
             contentDescription = if(expandable.value) stringResource(R.string.show_less) else stringResource(R.string.show_more) )
            }

        }

    }
}


@Composable
fun Greetings(names: List<String> = List(1000){
    "$it"
}){
//    Column{
//        for(name in names ){
//            Greeting(name = name)
//        }
  //  }

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = names){content ->
            Greeting(content)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    MyComposeProjectTheme {
        if(shouldShowOnboarding){
            Onboarding(onContinueClicked = {
                shouldShowOnboarding = false
            })
        }else{
            Greeting("Welcome home")
        }

    }
}


@Composable
fun Onboarding(onContinueClicked: () -> Unit){
// TODO: This state should be hoisted

    Surface{
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxSize(),
            verticalArrangement =Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text("You welcome to this hood", modifier = Modifier.padding(bottom = 24.dp))

            Button(onClick =
                onContinueClicked
        ) {
                Text("Click Me")
            }

        }
    }
}