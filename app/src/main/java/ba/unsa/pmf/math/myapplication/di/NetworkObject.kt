package ba.unsa.pmf.math.myapplication.di

import ba.unsa.pmf.math.myapplication.retrofit.DataClient
import ba.unsa.pmf.math.myapplication.retrofit.GetDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkObject {

    @Singleton
    @Provides
    fun networkCategoryService(): GetDataService {
        return DataClient.serviceApiInterface
    }

}