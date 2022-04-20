package com.example.yelpapp.domain

import com.example.yelpapp.data.BusinessRepository
import kotlinx.coroutines.flow.Flow

class GetBusinessUseCase (private val repository: BusinessRepository){

    operator fun invoke (): Flow<List<Business>> = repository.business

}