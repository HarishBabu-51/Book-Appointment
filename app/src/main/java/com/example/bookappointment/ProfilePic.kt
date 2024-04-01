package com.example.bookappointment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfilePic(int: Int){
    GlideImage(
        model = "https://randomuser.me/api/portraits/thumb/women/${int}.jpg",
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color(0xfffafaf4)),
    )
}



@Preview(showBackground = true)
@Composable
fun PicReview() =  ProfilePic(45)