package com.example.scrapper.util

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import com.example.scrapper.MainActivity

object Utils {

    fun isPackageInstalled(packageName: String): Boolean {
        val packageManager = MainActivity.applicationContext().packageManager
        var isInstalled = false;
        try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            isInstalled = true
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(context(), "$packageName is not installed", Toast.LENGTH_LONG ).show()
        }
        return isInstalled
    }

    fun context(): Context {
        return MainActivity.applicationContext()
    }
}