package com.example.bookappointment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.bookappointment.ui.theme.BookAppointmentTheme
import com.example.bookappointment.ui.theme.cardoFamily
import com.example.bookappointment.ui.theme.openSansFamily
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BookAppointmentTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color((0xfffbfaf5))
                    ) {
                        BookAppointment()
                    }
                }
            }
        }
    }
}

val i = (10..60).random()

@Preview(showBackground = true)
@Composable
fun GreetingPreview() = BookAppointmentTheme {  //I missed this line
    BookAppointment()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAppointment(){


    val datePickerState = rememberDatePickerState(
        yearRange = 2024..2025,
        selectableDates = FiveDaySelection
    )
    var showDatePicker by remember { mutableStateOf(false) }
    var dateSelected by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }
    var fromHour by remember { mutableStateOf(0) }
    var toHour by remember { mutableStateOf(0) }

    var fromMinute by remember {mutableStateOf(0)}
    var timeSelected by remember { mutableStateOf(false) }

    var progress by remember {
        mutableFloatStateOf( 0f)
    }


    if(showDatePicker){
        DatePicker(datePickerState,onConfirm = {
            Calendar.getInstance().apply {
                timeInMillis = datePickerState.selectedDateMillis!!
                if(!dateSelected){
                    dateSelected = true
                    progress += 0.5f
                }
            }
            showDatePicker = false
        }, onDismiss = {
            showDatePicker = false
        })
    }

    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = {  },
            confirmButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                       // Log.i("OK","${timePickerState.hour}")
                        fromHour = timePickerState.hour
                        fromMinute = timePickerState.minute
                        toHour = timePickerState.hour.inc()
                        if(!timeSelected){
                            timeSelected = true
                            progress += 0.5f
                        }
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                    }
                ) { Text("CANCEL") }
            }
        )
        {
            TimePicker(state = timePickerState)
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xfffbfaf5)),) {
        Column(
            modifier = Modifier
                .weight(0.9f)
                .fillMaxSize()
                .background(Color(0xfffbfaf5)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.03f))

            Text(
                text = "Book a trial shift",
                style = TextStyle(
                    fontFamily = cardoFamily,
                    fontSize = 45.sp,
                    letterSpacing = 0.3.sp
                )
            )

            LinearProgress(progress = progress)

            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.03f))

            Text(
                text = "Please complete all required fields",
                style = TextStyle(
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp
                ),
            )
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.015f))

            ListTile(
                leading = {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxSize(0.75f)
                            .background(Color.White),
                        contentAlignment = Alignment.Center,
                    ) {
                        ProfilePic(i)
                    }
                },
                title = {
                    Text(
                        text = "Booking",
                        style = TextStyle(
                            fontFamily = openSansFamily,
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp
                        ),
                    )
                },
                subtitle = {
                    Text(
                        text = "Sheeba N.",
                        style = TextStyle(
                            fontFamily = openSansFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp
                        ),
                    )
                },
                trailing = {
                    Box(
                        modifier = Modifier
                            .background(Color(0xfff3f0e9), shape = RoundedCornerShape(15.dp))
                            .padding(9.dp)
                    ) {
                        Text(
                            text = "$${i}",
                            style = TextStyle(
                                fontFamily = openSansFamily,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.15.sp
                            ),
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.045f))

            ///
            Text(
                text = buildAnnotatedString {
                    append("When you would like the shift?")
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("*")
                    }

                },
                style = TextStyle(
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp
                ),
            )
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.012f))
            Text(
                text = "Trail shifts are 1 hour",
                style = TextStyle(
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp
                ),
            )
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.03f))

            // ListTile
            ListTile(
                leading = {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxSize(0.54f)
                            .background(Color(0xfffeddcc)),
                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(onClick = {
                            showDatePicker = true //changing the visibility state
                        }) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = null,
                                tint = Color(0xfff2612f)
                            )
                        }
                    }
                },
                title = {
                    Text(
                        //text = "Date",
                        text = buildAnnotatedString {
                            append("Date")
                            withStyle(style = SpanStyle(color = Color.Red)) {
                                append("*")
                            }

                        },
                        style = TextStyle(
                            fontFamily = openSansFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp
                        ),
                    )
                },
                subtitle = {
                    Text(
                        text = dateFormat(datePickerState.selectedDateMillis),
                        style = TextStyle(
                            fontFamily = openSansFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp
                        ),
                    )
                },

                )
            ListTile(
                leading = {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxSize(0.54f)
                            .background(Color(0xffcee9e2)),
                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(onClick = {
                            showTimePicker = true //changing the visibility state
                        }) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.schedule),
                                contentDescription = null,
                                tint = Color(0xff51776a)
                            )
                        }

                    }
                },
                title = {
                    Text(
                        //text = "Time*",
                        text = buildAnnotatedString {
                            append("Time")
                            withStyle(style = SpanStyle(color = Color.Red)) {
                                append("*")
                            }

                        },
                        style = TextStyle(
                            fontFamily = openSansFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp
                        ),
                    )
                },
                subtitle = {
                    Text(
                        text = "${fromHour.toString().padStart(2,'0')}:${fromMinute.toString().padStart(2,'0')} - ${toHour.toString().padStart(2,'0')}:${fromMinute.toString().padStart(2,'0')}",
                        style = TextStyle(
                            fontFamily = openSansFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp
                        ),
                    )
                },
            )
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.03f))

            Text(
                text = "What do you need help with?*",
                style = TextStyle(
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp
                )
            )
            /*Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.75f))
            OutlinedButton(
                onClick = {  }) {
                Text(text = "Next")
            }*/
        }
        Button(onClick = {  },
            modifier = Modifier
                .weight(0.09f)
                .fillMaxSize(),
            shape = RoundedCornerShape(0.dp),

        enabled = progress == 1f,
            colors = ButtonColors(
                containerColor = Color(0xff1d99bd),
                contentColor = Color(0xff1d99bd),
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Gray
                )
        ) {
            Text("Next",
                style = TextStyle(
                    fontFamily = openSansFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xfff6f9fd),
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp
            ),

                )
        }
    }

}







