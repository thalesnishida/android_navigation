package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.model.Produto
import br.com.alura.aluraesporte.ui.recyclerview.adapter.ProdutosAdapter
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import br.com.alura.aluraesporte.ui.viewmodel.ProdutosViewModel
import kotlinx.android.synthetic.main.lista_produtos.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListaProdutosFragment : Fragment() {

    private val viewModel: ProdutosViewModel by viewModel()
    private val loginViewModel: LoginViewModel by viewModel()
    private val adapter: ProdutosAdapter by inject()
    private val controller by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(loginViewModel.naoEstaLogado()){
            vaiParaLogin()
        }
        buscaProdutos()
        setHasOptionsMenu(true)
    }

    private fun buscaProdutos() {
        viewModel.buscaTodos().observe(this, Observer { produtosEncontrados ->
            produtosEncontrados?.let {
                adapter.atualiza(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.lista_produtos,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_lista_produto, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.menu_lista_produto_deslogar){
            loginViewModel.desloga()
            vaiParaLogin()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun vaiParaLogin() {
        val direction = ListaProdutosFragmentDirections.actionListaProdutosToLogin()
        controller.navigate(direction)
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, VERTICAL)
        lista_produtos_recyclerview.addItemDecoration(divisor)
        adapter.onItemClickListener = { produtoSelecionado ->
            vaiParaDetalhesProdutos(produtoSelecionado)
        }
        lista_produtos_recyclerview.adapter = adapter
    }

    private fun vaiParaDetalhesProdutos(produto: Produto) {
        val directions = ListaProdutosFragmentDirections.actionListaProdutosToDetalhesProduto(produto.id)
        controller.navigate(directions)
    }

}
