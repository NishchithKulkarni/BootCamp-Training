package com.example.example.service

import com.example.example.model.Patient
import com.example.example.repository.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PatientService(
    @Autowired val patientRepository: PatientRepository
) {

    fun getPatients() : ResponseEntity<List<Patient>>{
        val patients = patientRepository.findAll()
        return ResponseEntity.ok(patients)
    }

}