package dev.pegasus.composeretrofit.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.pegasus.composeretrofit.helpers.models.DataItem
import dev.pegasus.composeretrofit.helpers.viewModels.DataViewModel

@Composable
fun MainScreen(viewModel: DataViewModel) {

    val dataItemList by viewModel.dataItemLiveData.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    Column {
        if (dataItemList.isNullOrEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            RecyclerView(dataItemList!!)
        }
    }
}

@Composable
fun RecyclerView(dataItemList: List<DataItem>) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(dataItemList) {
            CardItem(dataItem = it)
        }
    }
}

@Composable
fun CardItem(dataItem: DataItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Sr. ${dataItem.id}",
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dataItem.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dataItem.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
