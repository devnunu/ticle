package com.devnunu.ticle.di

import com.devnunu.ticle.data.datasource.AssetDataSource
import com.devnunu.ticle.data.datasource.AssetMemoryDataSourceImpl
import org.koin.dsl.module

val assetModule = module {
    single<AssetDataSource> { AssetMemoryDataSourceImpl() }
}