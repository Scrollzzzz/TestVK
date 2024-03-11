package com.scrollz.testvk.data.repoitory

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.scrollz.testvk.BuildConfig
import com.scrollz.testvk.data.api.ProductApi
import com.scrollz.testvk.data.paging.ProductPageSource
import com.scrollz.testvk.domain.model.Product
import com.scrollz.testvk.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val api: ProductApi
): ProductRepository {

    override fun getProducts(query: String): Flow<PagingData<Product>> = Pager(
        config = PagingConfig(
            pageSize = BuildConfig.PAGE_SIZE,
            initialLoadSize = BuildConfig.PAGE_SIZE
        ),
        pagingSourceFactory = { ProductPageSource(api, query = query) }
    ).flow

}
