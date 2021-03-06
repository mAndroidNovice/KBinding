package com.benny.library.kbinding.view

import android.view.View
import android.view.ViewGroup
import com.benny.library.kbinding.bind.BindingDisposer
import com.benny.library.kbinding.bind.ItemViewModel
import com.benny.library.kbinding.bind.ViewModel
import org.jetbrains.anko.AnkoContext
import java.util.*

/**
 * Created by benny on 11/18/15.
 */

public open class ViewCreator(val bindingDisposer: BindingDisposer, val viewBinderComponent: ViewBinderComponent<*>, val viewModelFactory: () -> ItemViewModel<*>) : IViewCreator<Any> {

    override fun view(container: ViewGroup): View {
        val viewBinder = viewBinderComponent.createViewBinder(AnkoContext.create(container.context))
        val viewModel = viewModelFactory()
        viewBinder.bindTo(bindingDisposer, viewModel)
        viewBinder.view.tag = viewModel
        return viewBinder.view
    }

    override fun viewTypeFor(data: Any?, position: Int): Int {
        return  0
    }

    override fun viewTypeCount(): Int {
        return 1
    }
}