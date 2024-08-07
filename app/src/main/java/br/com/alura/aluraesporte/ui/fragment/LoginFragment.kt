package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.ComponentesVisuais
import br.com.alura.aluraesporte.ui.viewmodel.EstadoViewModel
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login.login_botao_cadastra_usuario
import kotlinx.android.synthetic.main.login.login_botao_logar
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class LoginFragment : Fragment (){

    private val controller by lazy { findNavController() }
    private val estadoViewModel: EstadoViewModel by sharedViewModel()
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        estadoViewModel.temComponentes = ComponentesVisuais()
        login_botao_logar.setOnClickListener {
            viewModel.loga()
            vaiParaListaProdutos()
        }
        login_botao_cadastra_usuario.setOnClickListener {
            vaiParaCadastroUsuario()
        }
    }

    private fun vaiParaCadastroUsuario() {
        val direction = LoginFragmentDirections.actionLoginToCadastraUsuario()
        controller.navigate(direction)
    }

    private fun vaiParaListaProdutos() {
        val direction = LoginFragmentDirections.actionLoginToListaProdutos()
        controller.navigate(direction)
    }
}