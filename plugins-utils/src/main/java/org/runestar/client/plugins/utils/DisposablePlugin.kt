package org.runestar.client.plugins.utils

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper
import org.runestar.client.plugins.Plugin
import org.runestar.client.plugins.PluginSettings
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.internal.disposables.ListCompositeDisposable

abstract class DisposablePlugin<T : PluginSettings>(
        private val listCompositeDisposable: ListCompositeDisposable
) : Plugin<T>(), DisposableContainer by listCompositeDisposable {

    constructor() : this(ListCompositeDisposable())

    @OverridingMethodsMustInvokeSuper
    override fun stop() {
        super.stop()
        listCompositeDisposable.clear()
    }
}