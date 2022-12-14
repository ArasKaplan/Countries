package com.araskaplan.countries.di

import android.content.Context
import androidx.room.Room
import com.araskaplan.countries.common.Common
import com.araskaplan.countries.data.local.CountryDao
import com.araskaplan.countries.data.local.CountryDatabase
import com.araskaplan.countries.data.remote.GeoDbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CountryDatabaseModule {
    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context): CountryDatabase {
        val db = Room.databaseBuilder(
            context,
            CountryDatabase::class.java,
            "country-database"
        ).build()
        return db
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideChannelDao(countryDatabase: CountryDatabase): CountryDao{
        return countryDatabase.countryDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideGeoDbApi(): GeoDbApi {
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val headerInterceptor = Interceptor.invoke { chain->
            chain.request().newBuilder()
                .addHeader("X-RapidApi-Key",Common.API_KEY)
                .addHeader("X-RapidAPI-Host",Common.API_HOST)
                .build()
                .let(chain::proceed)
        }
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logger)
            .addInterceptor(headerInterceptor)

        return Retrofit.Builder()
            .baseUrl(Common.GEODB_BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(GeoDbApi::class.java)
    }


}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

}


@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher