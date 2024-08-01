package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit


private const val CHAVE_LOGADO = "LOGADO"

class LoginRepository(private val preferences: SharedPreferences) {

    fun loga() = preferences.edit { putBoolean(CHAVE_LOGADO, true) }
    fun desloga() = preferences.edit { putBoolean(CHAVE_LOGADO, false) }
    fun estaLogado() : Boolean = preferences.getBoolean(CHAVE_LOGADO, false)

}
