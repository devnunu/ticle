package com.devnunu.ticle.repository

import com.devnunu.ticle.datasource.AssetDataSource

class AssetRepositoryImpl(
    val assetMemoryDataSource: AssetDataSource
) : AssetRepository {

}