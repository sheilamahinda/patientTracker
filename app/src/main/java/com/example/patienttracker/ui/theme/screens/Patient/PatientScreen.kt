package com.example.patienttracker.ui.theme.screens.Patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.patienttracker.R
import com.example.patienttracker.model.Patient
@Composable
fun PatientScreen(navController: NavHostController, viewModel: PatientViewModel) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }
    val viewModel: PatientViewModel = viewModel()

    val filteredPatients = remember(searchText) {
        derivedStateOf {
            val query = searchText.text.toLowerCase()
            viewModel.getPatients().filter { patient ->
                patient.name.toLowerCase().contains(query)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)



        )

        LazyColumn {
            items(filteredPatients.value) { patient ->
                PatientItem(patient)
            }
        }
    }
}

fun BasicTextField(value: TextFieldValue, onValueChange: Any, placeholder: () -> Unit, modifier: Modifier) {

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
        Patient(2, "Jane Smith", 28, "Cough"),
        Patient(3, "Erick Mwai", 35, "Headache"),
        Patient(4, "Amina Baraka", 35, "Stomachache"),
        Patient(5, "Sasha Abdi", 35, "Fever"),
        Patient(6, "Ken Mwangi", 35, "Headache"),
        Patient(7, "Steph Wambui", 35, "Cough"),
        Patient(8, "Mary Atieno", 35, "Fever"),
        Patient(9, "Jane Mary", 35, "Flu"),
        Patient(10, "Peter Ken", 35, "Cough")
    )

    // You can provide a mock ViewModel if needed
    val viewModel = PatientViewModel()

    PatientScreen(rememberNavController(), viewModel = viewModel) // You can pass your actual ViewModel here
}
