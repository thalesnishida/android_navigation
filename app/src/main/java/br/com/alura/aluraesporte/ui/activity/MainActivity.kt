package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoViewModel
import kotlinx.android.synthetic.main.main_activity.actitivy_main_nav_bottom
import kotlinx.android.synthetic.main.main_activity.main_activity_nav_host
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val controller: NavController by lazy { findNavController(R.id.main_activity_nav_host) }
    private val viewModel: EstadoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        controller.addOnDestinationChangedListener { controller, destination, arguments ->

            title = destination.label

            viewModel.appBar.observe(this, Observer {
                it?.let { temAppBar ->
                    if (temAppBar) {
                        supportActionBar?.show()
                    } else {
                        supportActionBar?.hide()
                    }
                }
            })
        }
        actitivy_main_nav_bottom.setupWithNavController(controller)
    }

}
