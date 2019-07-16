package com.asura.connections

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager


//Connection types added directly as extensions to the Context type
//So anywhere in the subclass of Context like Activity or Service we can just use these properties

val Context.isNetworkConnected: Boolean
    @SuppressLint("MissingPermission")
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected == true
    }

//It seems isAvailable is deprecate in the NetworkInfo
val Context.isNetworkAvailable: Boolean
    @SuppressLint("MissingPermission")
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isAvailable == true
    }

val Context.networkType : String?
    @SuppressLint("MissingPermission")
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.typeName
    }

val Context.networkSubType : String?
    @SuppressLint("MissingPermission")
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.subtypeName
    }