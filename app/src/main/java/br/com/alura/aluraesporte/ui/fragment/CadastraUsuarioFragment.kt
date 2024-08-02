package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import kotlinx.android.synthetic.main.cadastrar_usuario.cadastro_usuario_botao_cadastrar

class CadastraUsuarioFragment : Fragment() {

    private val controlador: NavController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cadastrar_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cadastro_usuario_botao_cadastrar.setOnClickListener {
            controlador.popBackStack()
        }
    }
}