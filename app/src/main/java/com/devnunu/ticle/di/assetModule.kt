package com.devnunu.ticle.di

import com.devnunu.ticle.data.datasource.AssetDataSource
import com.devnunu.ticle.data.datasource.AssetMemoryDataSourceImpl
import com.devnunu.ticle.data.repository.AssetRepository
import com.devnunu.ticle.data.repository.AssetRepositoryImpl
import org.koin.dsl.module

val assetModule = module {

    single<AssetDataSource> { AssetMemoryDataSourceImpl() }

    factory<AssetRepository> { AssetRepositoryImpl(get()) }
}