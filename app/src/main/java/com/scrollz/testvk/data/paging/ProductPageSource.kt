package com.scrollz.testvk.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.scrollz.testvk.data.api.ProductApi
import com.scrollz.testvk.domain.model.Product
import com.scrollz.testvk.domain.model.toProduct

class ProductPageSource(
    private val productApi: ProductApi,
    private val query: String
): PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val page = params.key ?: 0
        val skip = page * params.loadSize

        return try {
            val products = productApi.getProducts(query, skip, params.loadSize)
                .products.map { it.toProduct() }
            val nextKey = if (products.size < params.loadSize) null else page + 1
            val prevKey = if (page == 0) null else page - 1
            LoadResult.Page(products, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
