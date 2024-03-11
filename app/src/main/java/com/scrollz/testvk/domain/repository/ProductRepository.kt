package com.scrollz.testvk.domain.repository

import androidx.paging.PagingData
import com.scrollz.testvk.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(query: String): Flow<PagingData<Product>>

}
