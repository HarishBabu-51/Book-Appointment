package com.example.bookappointment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListTile(
    leading:  @Composable () -> Unit ={},
    title:  @Composable () -> Unit ={},
    subtitle:  @Composable () -> Unit ={},
    trailing:  @Composable () -> Unit ={},
){
    Card(modifier = Modifier
        .padding(15.dp)
        .height(90.dp)
        .background(Color(0xfffafaf4), shape = RoundedCornerShape(12.dp))
        .fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ){
        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color(0xfffafaf4))
                    .fillMaxWidth(0.24f),

                contentAlignment = Alignment.Center
            ){
                leading()
            }
            Spacer(modifier = Modifier
                .fillMaxWidth(fraction = 0.06f)
                .background(Color(0xfffafaf4))
                .fillMaxSize())
            Box(modifier = Modifier
                .fillMaxWidth(0.75f)
                .fillMaxHeight().background(Color(0xfffafaf4))
                .align(Alignment.CenterVertically)
                //.background(Color.Red)
            ) {
                Column(
                    //verticalArrangement = Arrangement.SpaceAround,
                    //horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.fillMaxHeight(0.15f).fillMaxSize().background(Color(0xfffafaf4)))
                    Box(modifier = Modifier
                        .fillMaxHeight(0.45f)

                        .fillMaxSize(), contentAlignment = Alignment.CenterStart,) {
                        title()
                    }
                    Box(modifier = Modifier
                        .fillMaxHeight(0.54f)

                        .fillMaxSize().background(Color(0xfffafaf4)),
                         contentAlignment = Alignment.CenterStart,

                    ) {
                        subtitle()
                    }
                }
            }
            Box(
                modifier = Modifier
                    //.background(Color.Magenta)
                    .fillMaxSize().background(Color(0xfffafaf4)),
                contentAlignment = Alignment.Center) {
                trailing()
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun TilePreview() =  MaterialTheme {  //I missed this line
    ListTile()
}
