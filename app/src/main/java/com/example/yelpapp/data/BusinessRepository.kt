package com.example.yelpapp.data

import com.example.yelpapp.App

class BusinessRepository(app : App) {

    private val DEFAULT_LATITUDE = -31.417
    private val DEFAULT_LONGITUDE = -64.183

    private val regionRepository : RegionRepository = RegionRepository(app)
    private val localDataSource : LocalDataSource = LocalDataSource(app.db.businessDao())
    private val remoteDataSource : RemoteDataSource = RemoteDataSource(YelpDbClient.service)

    val business = localDataSource.business

    suspend fun requestBusiness() {
        if(localDataSource.isEmpty()){
            val location = regionRepository.findLastCoordinates()
            val lat = location?.latitude ?: DEFAULT_LATITUDE
            val long = location?.longitude ?: DEFAULT_LONGITUDE

            val business = remoteDataSource.searchBusiness(lat.toString(),long.toString())
            localDataSource.save(business)
        }
    }
}