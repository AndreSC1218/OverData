package com.ascdev.overdata.home.di

import com.ascdev.overdata.home.data.remote.OverDataApi
import com.ascdev.overdata.home.data.repositories.HomeRepositoryImpl
import com.ascdev.overdata.home.domain.usecase.heroes_usecase.GetAllHeroesUseCase
import com.ascdev.overdata.home.domain.usecase.heroes_usecase.GetHeroDetailUseCase
import com.ascdev.overdata.home.domain.usecase.heroes_usecase.HeroesUseCases
import com.ascdev.overdata.home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun provideOverDataApi() : OverDataApi{
        return Retrofit.Builder().baseUrl(OverDataApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build()).build().create(OverDataApi::class.java)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(
        api: OverDataApi
    ): HomeRepository {
        return HomeRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideHeroesUseCases(repository: HomeRepository): HeroesUseCases {
        return HeroesUseCases(
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            getHeroDetailUseCase = GetHeroDetailUseCase(repository)
        )
    }


}