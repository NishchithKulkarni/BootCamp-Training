package com.example.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
	runApplication<ExampleApplication>(*args)
}
