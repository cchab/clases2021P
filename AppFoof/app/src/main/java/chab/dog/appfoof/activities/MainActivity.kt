package chab.dog.appfoof.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import chab.dog.appfoof.R
import chab.dog.appfoof.fragments.HomeFragment
import chab.dog.appfoof.fragments.ProfileFragment
import chab.dog.appfoof.fragments.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var imgDice : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navMenu : BottomNavigationView = findViewById(R.id.navMenu)
        navMenu.setOnNavigationItemSelectedListener {
                menuItem ->
            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    val fragment = HomeFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.profileFragment -> {
                    val fragment = ProfileFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.settingFragment -> {
                    val fragment = SettingFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
