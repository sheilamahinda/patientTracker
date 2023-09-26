package com.example.patienttracker.data

import androidx.lifecycle.ViewModel
import com.example.patienttracker.model.Patient

class PatientViewModel : ViewModel() {
    private val patients = mutableListOf<Patient>()

    init {
        // Initialize some sample patients (you can replace this with your data source)
        patients.add(Patient(1, "John Doe", 35, "Fever"))
        patients.add(Patient(2, "Jane Smith", 28, "Cough"))
        patients.add(Patient(3, "Erick Mwai", 35, "Headache"))
                patients.add(Patient(4, "Amina Baraka", 35, "Stomachache"))
                patients.add(Patient(5, "Sasha Abdi", 35, "Fever"))
                patients.add( Patient(6, "Ken Mwangi", 35, "Headache"))
                patients.add( Patient(7, "Steph Wambui", 35, "Cough"))
                patients.add( Patient(8, "Mary Atieno", 35, "Fever"))
                patients.add( Patient(9, "Jane Mary", 35, "Flu"))
                patients.add( Patient(10, "Peter Ken", 35, "Cough"))
    }

    fun getPatients(): List<Patient> {
        return patients
    }

}
