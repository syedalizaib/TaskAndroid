package com.taskandroid.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {


    protected val activity by lazy { requireActivity() as MainActivity }
    protected lateinit var parentView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentView = view
        hideKeyboard()
        setupViews()
        attachViewModel()
    }


    abstract fun setupViews()
    abstract fun attachViewModel()

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val windowHeightMethod =
            InputMethodManager::class.java.getMethod("getInputMethodWindowVisibleHeight")
        val height = windowHeightMethod.invoke(imm) as Int
        if (height > 0) {
            imm.hideSoftInputFromWindow(parentView.windowToken, 0)
        }
    }

}