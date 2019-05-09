package com.maheshvenkat.mycalendar

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.util.Log
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import androidx.appcompat.app.AppCompatDelegate

import com.google.android.gms.security.ProviderInstaller

import java.lang.ref.WeakReference
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext

class MyCalendarApplication : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()

        //This is for Vector support for API 19.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        MultiDex.install(this)

        checkTls()

        loadConfiguration()
        gsContext = WeakReference(this)
    }

    /**
     * This appears to fix TLS 1.2 for Android 5.x, without this code the network calls will fail.
     */
    protected fun checkTls() {
        if (android.os.Build.VERSION.SDK_INT < 21) {
            try {
                ProviderInstaller.installIfNeededAsync(this, object : ProviderInstaller.ProviderInstallListener {
                    override fun onProviderInstalled() {
                        var sslContext: SSLContext? = null
                        try {
                            sslContext = SSLContext.getInstance("TLSv1.2")
                            sslContext!!.init(null, null, null)
                            val engine = sslContext.createSSLEngine()
                        } catch (e: NoSuchAlgorithmException) {
                            Log.e(TAG, e.message)
                        } catch (e: KeyManagementException) {
                            Log.e(TAG, e.message)
                        }

                    }

                    override fun onProviderInstallFailed(i: Int, intent: Intent) {}
                })
            } catch (e: Exception) {
                Log.e(TAG, e.message)
            }

        }
    }

    private fun loadConfiguration() {
        try {
            Settings.System.getInt(getContentResolver(), Settings.System.INSTALL_NON_MARKET_APPS, 1)
            val appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA)
            val pkgInfo = getPackageManager().getPackageInfo(getPackageName(), 0)
            val metadata = appInfo.metaData

            serviceURl = metadata.getString("ServiceUrl")
            testURL = metadata.getString("ServiceUrl2")
            mobileUserName = metadata.getString("MobileAppUserName")
            mobilePassword = metadata.getString("MobileAppPassword")
            version = pkgInfo.versionName
            osVersion = android.os.Build.VERSION.RELEASE
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

    }

    companion object {
        var gsContext: WeakReference<Context>? = null
            private set

        var serviceURl: String? = null
        var testURL: String? = null
        var mobileUserName: String? = null
        var mobilePassword: String? = null
        var version: String? = null
        var osVersion: String? = null

        private val TAG = "Application"
    }

}
