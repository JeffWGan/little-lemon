package com.jeffg.dev.littlelemon

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.jeffg.dev.littlelemon.data.LITTLE_LEMON_URL
import com.jeffg.dev.littlelemon.data.database.AppDatabase
import com.jeffg.dev.littlelemon.data.database.MenuItemRoom
import com.jeffg.dev.littlelemon.data.network.MenuItemNetwork
import com.jeffg.dev.littlelemon.data.network.MenuNetwork
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy {
        Room.databaseBuilder(application, AppDatabase::class.java, "little-lemon-db").build()
    }

    private suspend fun fetchMenuFromNetwork(): List<MenuItemNetwork> =
        try {
            httpClient.get(LITTLE_LEMON_URL)
                .body<MenuNetwork>()
                .menu
        } catch (e: Exception) {
            println("Network error $e")
            emptyList()
        }

    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
        database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
    }

    fun fetchMenu() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                fetchMenuFromNetwork().also { saveMenuToDatabase(it) }
            }
        }
    }

    fun getMenu(): LiveData<List<MenuItemRoom>> = database.menuItemDao().getAll()

    fun clearData() {
        viewModelScope.launch(Dispatchers.IO) {
            database.menuItemDao().deleteAll()
        }
    }
}
