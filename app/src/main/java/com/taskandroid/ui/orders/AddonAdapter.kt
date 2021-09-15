package com.taskandroid.ui.orders

import android.view.View
import com.taskandroid.R
import com.taskandroid.base.RecyclerBaseAdapter
import com.taskandroid.constant.Constants
import com.taskandroid.databinding.ViewListItemAddonBinding
import com.taskandroid.entities.Addon


class AddonAdapter(
    private val data: ArrayList<Addon>,
    itemClicker: OnItemClicker
) :
    RecyclerBaseAdapter(
        itemClicker,
        data,
        R.layout.view_list_item_addon,
        Constants.ADAPTER_TYPES.ADDON_ADAPTER
    ) {

    override fun View.bind(item: Any, position: Int) {
        val item = item as Addon
        val binding = ViewListItemAddonBinding.bind(this)
        with(binding)
        {
            addonTitleText.text = item.title
            addonQuantity.text = "x${item.quantity}"
        }
    }
}