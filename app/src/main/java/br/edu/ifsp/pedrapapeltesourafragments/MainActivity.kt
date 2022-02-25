package br.edu.ifsp.pedrapapeltesourafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import br.edu.ifsp.pedrapapeltesourafragments.databinding.ActivityMainBinding
import br.edu.ifsp.pedrapapeltesourafragments.fragments.MainFragment
import br.edu.ifsp.pedrapapeltesourafragments.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        with(supportFragmentManager.beginTransaction()) {
            setReorderingAllowed(true)
            addToBackStack("principal")
            add(R.id.mainContainerView, MainFragment(), "MainFragment")
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menu_settings){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack("configurações")
                replace(R.id.mainContainerView, SettingsFragment(), "SettingsFragment")
            }
            true
        } else
            false
    }
}