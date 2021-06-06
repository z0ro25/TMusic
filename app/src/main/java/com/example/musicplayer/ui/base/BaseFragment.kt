package com.t3h.mvvm.ui.base

import androidx.fragment.app.Fragment
import com.t3h.mvvm.ui.base.BaseActivity

open class BaseFragment:Fragment(){

    open fun onBackPress(){
        if (activity != null){
            (activity as BaseActivity).backRoot()
        }
    }
}