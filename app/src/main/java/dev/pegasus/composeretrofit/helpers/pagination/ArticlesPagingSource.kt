package dev.pegasus.composeretrofit.helpers.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.pegasus.composeretrofit.helpers.retrofit.interfaces.ClientApi
import dev.pegasus.composeretrofit.helpers.retrofit.models.Product
import dev.pegasus.composeretrofit.helpers.utils.HelperUtils.TAG

class ArticlesPagingSource(private val api: ClientApi) : PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val nextPage = (params.key ?: 0) * 10

        Log.d(TAG, "load: NextPage: $nextPage")

        val response = api.getData(nextPage)
        val productList = response.body()?.products ?: emptyList()
        val nextKey = if (productList.isEmpty()) null else nextPage + 1

        return LoadResult.Page(
            data = productList,
            prevKey = null,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return null
    }
}