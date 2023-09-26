package com.example.patienttracker.ui.theme.screens.Patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.patienttracker.data.PatientViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.patienttracker.R
import com.example.patienttracker.model.Patient
@Composable
fun PatientScreen(viewModel: PatientViewModel = viewModel()) {
    var searchText by remember { mutableStateOf("") }
    // Make sure viewModel.getPatients() returns a List<Patient>
    val patients: List<Patient> = viewModel.getPatients()
    var context = LocalContext.current
    val backgroundDrawable =
        painterResource(id = R.drawable.bg4) // Replace with your background image resource

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = backgroundDrawable,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BasicTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                // ... other parameters
            )

            LazyColumn {
                items(patients) { patient ->
                    PatientItem(patient)
                }
            }
        }
    }
}

@Composable
fun PatientItem(patient: Patient) {
    // Composable to display patient information
    // You can customize this to show patient details
    Text(text = patient.name, modifier = Modifier.padding(8.dp))
}
@Composable
@Preview
fun PatientScreenPreview() {
    val samplePatients = listOf(
        Patient(1, "John Doe", 35, "Fever"),
        Patient(2, "Jane Smith", 28, "Cough")
    )

    // You can provide a mock ViewModel if needed
    val viewModel = PatientViewModel()

    PatientScreen(viewModel = viewModel) // You can pass your actual ViewModel here
}
