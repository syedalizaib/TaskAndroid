package com.konnect.helper


import android.content.Context
import android.net.Uri
import android.text.*
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.taskandroid.R
import java.util.*
import kotlin.collections.ArrayList


fun EditText.observe(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun ImageView.loadImage(url: String?, placeHolder: Int? = null) {
    val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
    circularProgressDrawable?.strokeWidth = 10f
    circularProgressDrawable?.centerRadius = 50f
    ContextCompat.getColor(context, (R.color.colorPrimaryDark))
        ?.let { circularProgressDrawable?.setColorSchemeColors(it) }
    circularProgressDrawable?.start()
//    val errorDrawable = placeHolder.takeIf { placeHolder != null } ?: R.drawable.button_1_selected
    val errorDrawable = R.drawable.ic_launcher_foreground
    context?.let {
        if (url.isNullOrEmpty().not()) {
            Glide.with(it)
                .load(GlideUrl(url))
                .placeholder(circularProgressDrawable)
                .error(errorDrawable)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this)
        } else {
            Glide.with(it)
                .load(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this)
        }
    }
}

fun ImageView.loadImage(uri: Uri, placeHolder: Int? = null) {
    val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
    circularProgressDrawable?.strokeWidth = 10f
    circularProgressDrawable?.centerRadius = 50f
    ContextCompat.getColor(context, (R.color.colorPrimaryDark))
        ?.let { circularProgressDrawable?.setColorSchemeColors(it) }
    circularProgressDrawable?.start()
    val errorDrawable =
        placeHolder.takeIf { placeHolder != null } ?: R.drawable.ic_launcher_foreground
    context?.let {
        Glide.with(it)
            .load(uri)
            .placeholder(circularProgressDrawable)
            .error(errorDrawable)
            .into(this)
    }
}


fun EditText.string(): String {
    return this.text.toString().trim()
}

fun TextView.string(): String {
    return this.text.toString().trim()
}


fun TabLayout.observe(onSelectedPosition: (Int) -> Unit) {

    this.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {

            onSelectedPosition.invoke(tab.position)
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {

        }

        override fun onTabReselected(tab: TabLayout.Tab) {

        }
    })

}


fun EditText?.getString(): String {
    if (this?.text.isNullOrEmpty()) {
        return ""
    } else {
        return this?.text.toString()
    }
}

fun EditText.getInt(): Int {
    var value = 0
    try {
        value = this.text.toString().toInt()
    } catch (e: Exception) {
    }
    return value
}


fun View.showSnackBar(message: String) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackbar.show()
}


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisibleToUser(): Boolean {
    return visibility == View.VISIBLE
}


fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}


fun Spinner.getString(): String {
    return this.selectedItem.toString()
}

fun Spinner.setSelectedValue(value: String?) {
    var array: ArrayList<String> = ArrayList()
    for (item in 0 until this.adapter.count) {
        array.add(adapter.getItem(item).toString())
    }
    if (array.contains(value)) {
        setSelection(array.indexOf(value))
    }
}


fun EditText.searchObserve(onSearchClicked: (String) -> Unit) {
    this.setOnEditorActionListener(object : TextView.OnEditorActionListener {
        override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                onSearchClicked.invoke(this@searchObserve.string())
                return true
            }
            return false
        }
    })
}

















