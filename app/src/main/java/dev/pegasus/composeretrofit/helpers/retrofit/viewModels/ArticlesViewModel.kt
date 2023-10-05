package dev.pegasus.composeretrofit.helpers.retrofit.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dev.pegasus.composeretrofit.helpers.pagination.ArticlesPagingSource
import dev.pegasus.composeretrofit.helpers.retrofit.RetrofitInstance

class ArticlesViewModel : ViewModel() {

    private val pagingSource = ArticlesPagingSource(RetrofitInstance.clientApi)

    val pagingData = Pager(config = PagingConfig(pageSize = 100), pagingSourceFactory = { pagingSource }).flow.cachedIn(viewModelScope)
}