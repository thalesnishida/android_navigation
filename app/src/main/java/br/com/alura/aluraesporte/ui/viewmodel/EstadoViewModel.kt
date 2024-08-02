package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoViewModel : ViewModel() {

    val components: LiveData<ComponentesVisuais> get() = _components

    private var _components: MutableLiveData<ComponentesVisuais> =
        MutableLiveData<ComponentesVisuais>().also {
            it.value = temComponentes
        }

    var temComponentes: ComponentesVisuais = ComponentesVisuais()
        set(value) {
            field = value
            _components.value = value
        }

}

class ComponentesVisuais(
    val appBar: Boolean = false,
    val bottomNavigation: Boolean = false
)

