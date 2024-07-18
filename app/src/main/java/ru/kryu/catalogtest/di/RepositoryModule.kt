package ru.kryu.catalogtest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kryu.catalogtest.data.CatalogRepositoryImpl
import ru.kryu.catalogtest.data.ProductRepositoryImpl
import ru.kryu.catalogtest.data.network.NetworkClient
import ru.kryu.catalogtest.domain.CatalogRepository
import ru.kryu.catalogtest.domain.ProductRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCatalogRepository(networkClient: NetworkClient): CatalogRepository =
        CatalogRepositoryImpl(networkClient)

    @Provides
    @Singleton
    fun provideProductRepository(networkClient: NetworkClient): ProductRepository =
        ProductRepositoryImpl(networkClient)
}