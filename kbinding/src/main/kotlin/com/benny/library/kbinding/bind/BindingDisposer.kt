package com.benny.library.kbinding.bind

import android.content.Context
import android.util.Log
import rx.Observable
import java.util.*

/**
 * Created by benny on 11/17/15.
 */

public class BindingDisposer {
    private val unbinds: MutableList<() -> Unit> = ArrayList()

    public fun unbind() {
        Log.d("BindingRecord", "unsubscribe size is " + unbinds.size)
        unbinds.forEach { it() }
        unbinds.clear()
    }

    public fun add(unbind: () -> Unit) {
        unbinds.add(unbind)
    }
}