package com.example.example.controller

import com.example.example.model.Patient
import com.example.example.model.PatientRequest
import com.example.example.repository.PatientRepository
import com.example.example.service.PatientService
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/patients")
class PatientController(
    private val patientsRepository: PatientRepository,
    private val patientService: PatientService
) {

    @GetMapping
    fun getAllPatients(): ResponseEntity<List<Patient>> {
        val patients = patientService.getPatients()
        return patients
    }

    @GetMapping("/{id}")
    fun getOnePatient(@PathVariable("id") id: String): ResponseEntity<Patient> {
        val patient = patientsRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(patient)
    }

    @PostMapping("/patient/add")
    fun createPatient(@RequestBody request: PatientRequest): ResponseEntity<Patient> {
        val patient = patientsRepository.save(Patient(
            name = request.name,
            description = request.description
        ))
        return ResponseEntity(patient, HttpStatus.CREATED)
    }

    @PutMapping("{id}")
    fun updatePatient(@RequestBody request: PatientRequest, @PathVariable("id") id: String): ResponseEntity<Patient>{
        val updatePatient = patientsRepository.save(
            Patient(
                id = "123",
                name = request.name,
                description = request.description,
                createdDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )
        return ResponseEntity.ok(updatePatient)
    }

    @DeleteMapping("{id}")
    fun deletePatient(@PathVariable("id") id: String) : ResponseEntity<Unit>
    {
       patientsRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}