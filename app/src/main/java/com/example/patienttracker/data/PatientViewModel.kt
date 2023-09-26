package com.example.patienttracker.data

import androidx.lifecycle.ViewModel
import com.example.patienttracker.model.Patient

class PatientViewModel : ViewModel() {
    private val patients = mutableListOf<Patient>()

    init {
        // Initialize some sample patients (you can replace this with your data source)
        patients.add(Patient(1, "John Doe", 35, "Fever"))
        patients.add(Patient(2, "Jane Smith", 28, "Cough"))
    }

    fun getPatients(): List<Patient> {
        return patients
    }

}
