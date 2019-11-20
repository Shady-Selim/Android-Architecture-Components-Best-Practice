package com.shady.tiger.ui.main

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel{ MainViewModel(get()) }
}
