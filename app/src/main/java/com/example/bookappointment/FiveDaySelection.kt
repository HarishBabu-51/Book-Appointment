package com.example.bookappointment

import android.os.Build
import android.util.Log

import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
object FiveDaySelection : SelectableDates {

    override fun isSelectableDate(utcTimeMillis: Long): Boolean {

        val five_days:Long = 5 * 24 * 60 * 60 * 1000
        Log.d("utcTimeMillis","$utcTimeMillis")

        return utcTimeMillis <= (System.currentTimeMillis() + five_days)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun isSelectableYear(year: Int): Boolean {
        return year <= LocalDate.now().year
    }
}