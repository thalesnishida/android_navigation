package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import br.com.alura.aluraesporte.R
import kotlinx.android.synthetic.main.main_activity.main_activity_nav_host


class MainActivity : AppCompatActivity() {

    private val controller: NavController by lazy { findNavController(R.id.main_activity_nav_host)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        controller.addOnDestinationChangedListener { controller, destination, arguments ->

            title = destination.label

            when(destination.id) {
                R.id.listaProdutos -> supportActionBar?.show()
                R.id.login -> supportActionBar?.hide()
            }

        }
    }

}
