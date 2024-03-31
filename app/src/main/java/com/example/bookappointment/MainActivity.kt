package com.example.bookappointment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bookappointment.ui.theme.BookAppointmentTheme
import com.example.bookappointment.ui.theme.cardoFamily
import com.example.bookappointment.ui.theme.openSansFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BookAppointmentTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        //color = Color.Blue
                        //color = Color((0xfffbfaf5))
                    ) {
                        BookAppointment()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() = BookAppointmentTheme {  //I missed this line
    BookAppointment()
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BookAppointment(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(Color(0xfffbfaf5))
            .background(Color(0xfffbfaf5))
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
       // verticalArrangement = Arrangement.Center
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
                    GlideImage(
                        model = "https://randomuser.me/api/portraits/men/87.jpg",
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Blue),

                        )
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
                        text = "$36",
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
            text = "When you would like the shift?*",
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
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = null,
                        tint = Color(0xfff2612f)
                    )
                }
            },
            title = {
                Text(
                    text = "Date",
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
                    text = "Jan 15*",
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
                    Icon(
                        modifier = Modifier.size(30.dp),painter = painterResource(id = R.drawable.schedule),
                        contentDescription = null,
                        tint = Color(0xff51776a)
                    )

                }
            },
            title = {
                Text(
                    text = "Time*",
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
                    text = "06:20pm - 07:20pm",
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

}





