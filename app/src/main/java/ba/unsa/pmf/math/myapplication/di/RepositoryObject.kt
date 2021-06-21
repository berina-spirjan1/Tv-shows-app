package ba.unsa.pmf.math.myapplication.di

import ba.unsa.pmf.math.myapplication.repository.CategoryRespository
import ba.unsa.pmf.math.myapplication.retrofit.GetDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryObject {

    @Singleton
    @Provides
    fun categoryRepositoryProvider(moviesAPI: GetDataService): CategoryRespository {
        return CategoryRespository(moviesAPI)
    }
}