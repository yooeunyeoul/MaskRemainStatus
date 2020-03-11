package com.example.maskalarm

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import com.orhanobut.logger.Logger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


object Util {

    @SuppressLint("PackageManagerGetSignatures")
    fun getHashKey(context: Context) {
        try {
            val info = context.packageManager.getPackageInfo(
                "com.example.maskalarm",
                PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Logger.e(Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {

        } catch (e: NoSuchAlgorithmException) {

        }    }
}