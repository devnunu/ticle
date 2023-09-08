package com.devnunu.ticle.data.asset.di

import com.devnunu.ticle.data.asset.datasource.AssetDataSource
import com.devnunu.ticle.data.asset.datasource.AssetMemoryDataSourceImpl
import com.devnunu.ticle.data.asset.repository.AssetRepository
import com.devnunu.ticle.data.asset.repository.AssetRepositoryImpl
import org.koin.dsl.module

val assetModule = module {

    single<AssetDataSource> { AssetMemoryDataSourceImpl() }

    factory<AssetRepository> { AssetRepositoryImpl(get()) }
}