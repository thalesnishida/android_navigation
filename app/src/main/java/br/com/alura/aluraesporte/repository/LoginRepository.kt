package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit


private const val LOGADO = "LOGADO"

class LoginRepository(private val preferences: SharedPreferences) {

    fun loga() {
        preferences.edit {
            putBoolean(LOGADO, true)
        }
    }

    fun estaLogado() : Boolean = preferences.getBoolean(LOGADO, false)

}
