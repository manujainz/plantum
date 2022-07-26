package com.manujain.plantum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.manujain.plantum.R
import com.manujain.plantum.ui.fragments.NurseryFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.simpleName.toString()
        val lTag: String = "[LIFECYCLE] $TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Timber.tag(lTag).d("onCreate")
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            showNurseryFragment("nursery_fragment")
        }
    }

    private fun showNurseryFragment(tag: String) {
        val fm = this.supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.container, NurseryFragment(), tag)
        ft.setReorderingAllowed(true)
        ft.commit()
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(lTag).d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(lTag).d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(lTag).d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(lTag).d("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(lTag).d("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag(lTag).d("onRestart")
    }
}