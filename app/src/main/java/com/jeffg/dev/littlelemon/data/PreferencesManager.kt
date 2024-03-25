package com.jeffg.dev.littlelemon.data

import android.content.Context
import android.content.SharedPreferences

enum class PreferenceKey {
    FirstName,
    LastName,
    EmailAddress
}

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)

    fun saveData(key: PreferenceKey, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key.name, value)
        editor.apply()
    }

    fun getData(key: PreferenceKey, defaultValue: String): String {
        return sharedPreferences.getString(key.name, defaultValue) ?: defaultValue
    }

    fun clearData() {
        sharedPreferences.edit().clear().apply()
    }
}
