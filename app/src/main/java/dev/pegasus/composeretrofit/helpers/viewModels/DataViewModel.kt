package dev.pegasus.composeretrofit.helpers.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.pegasus.composeretrofit.helpers.models.DataItem
import dev.pegasus.composeretrofit.helpers.repositories.DataRepository
import dev.pegasus.composeretrofit.helpers.utils.HelperUtils.TAG
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {


    private val repository = DataRepository()

    private val _dataItemLiveData = MutableLiveData<List<DataItem>>()
    val dataItemLiveData: LiveData<List<DataItem>> = _dataItemLiveData

    fun fetchData() {
        viewModelScope.launch {
            try {
                val cards = repository.getResult()
                _dataItemLiveData.value = cards
                Log.e(TAG, _dataItemLiveData.value.toString())
            } catch (e: Exception) {
                // Handle error
                Log.e(TAG, _dataItemLiveData.value.toString())
            }
        }
    }

}