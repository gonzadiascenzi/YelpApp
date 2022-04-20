package com.example.yelpapp.domain

import com.example.yelpapp.data.BusinessRepository

class RequestBusinessUseCase (private val moviesRepository: BusinessRepository){

    suspend operator fun invoke() = moviesRepository.requestBusiness()
}