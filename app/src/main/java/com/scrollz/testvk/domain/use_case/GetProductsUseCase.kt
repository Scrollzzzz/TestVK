package com.scrollz.testvk.domain.use_case

import androidx.paging.PagingData
import androidx.paging.map
import com.scrollz.testvk.domain.repository.ProductRepository
import com.scrollz.testvk.presentation.model.ProductUI
import com.scrollz.testvk.presentation.model.toProductUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke(query: String): Flow<PagingData<ProductUI>> =
        productRepository.getProducts(query).map { it.map { product -> product.toProductUI() } }
}
