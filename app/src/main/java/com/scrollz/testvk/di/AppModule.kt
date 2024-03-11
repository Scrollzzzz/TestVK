package com.scrollz.testvk.di

import com.scrollz.testvk.BuildConfig
import com.scrollz.testvk.data.api.ProductApi
import com.scrollz.testvk.data.repoitory.ProductRepositoryImpl
import com.scrollz.testvk.domain.repository.ProductRepository
import com.scrollz.testvk.utils.AppDispatchers
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDispatchers(): AppDispatchers = AppDispatchers()

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(5, TimeUnit.SECONDS)
            .build()

        val moshi = MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(moshi)
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        productApi: ProductApi
    ): ProductRepository = ProductRepositoryImpl(productApi)

}
