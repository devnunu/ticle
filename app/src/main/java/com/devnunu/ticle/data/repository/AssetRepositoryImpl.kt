package com.devnunu.ticle.data.repository

import com.devnunu.ticle.data.datasource.AssetDataSource

class AssetRepositoryImpl(
    val assetMemoryDataSource: AssetDataSource
) : AssetRepository {

}