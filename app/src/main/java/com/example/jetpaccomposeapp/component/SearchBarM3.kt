package com.example.jetpaccomposeapp.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3SearchBarDemo() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it },
        placeholder = { Text("Cari sesuatu...") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search icon")
        },
        trailingIcon = {
            if (active) {
                IconButton(onClick = {
                    query = ""
                    active = false
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Close icon")
                }
            }
        }
    ) {
        Text("Hasil pencarian untuk \"$query\"")
    }
}

@Preview(showBackground = true)
@Composable
private fun prevSearchBar() {
    M3SearchBarDemo()
}