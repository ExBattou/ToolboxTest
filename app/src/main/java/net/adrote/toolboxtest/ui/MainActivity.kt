package net.adrote.toolboxtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.adrote.toolboxtest.R
import net.adrote.toolboxtest.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
