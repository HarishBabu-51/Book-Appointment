package com.example.bookappointment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.text.DateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(state:DatePickerState, onConfirm: () -> Unit,onDismiss: () -> Unit){
    DatePickerDialog(
        onDismissRequest = {

        },
        confirmButton = {
            TextButton(onClick = onConfirm) { Text("OK") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("CANCEL") }
        }, modifier = Modifier.fillMaxSize()) {

        DatePicker(state = state)
    }
}

fun dateFormat(selectedDateMillis: Long?): String {
    selectedDateMillis?.let {
        return DateFormat.getDateInstance().format(selectedDateMillis)
    }
    return "";
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DatePickerReview() =  MaterialTheme {  //I missed this line
    DatePicker(state= rememberDatePickerState(), onConfirm = {}, onDismiss = {})
}


