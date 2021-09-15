package com.taskandroid.ui.ingredients

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.konnect.helper.loadImage
import com.taskandroid.R
import com.taskandroid.base.RecyclerBaseAdapter
import com.taskandroid.constant.Constants
import com.taskandroid.databinding.ViewListItemIngredientsBinding
import com.taskandroid.entities.Ingeredient


class IngredientsAdapter(
    private val context: Context,
    private val data: ArrayList<Ingeredient>,
    private val itemClicker: OnItemClicker
) :
    RecyclerBaseAdapter(
        itemClicker,
        data,
        R.layout.view_list_item_ingredients,
        Constants.ADAPTER_TYPES.INGREDIENT_ADAPTER
    ) {

    override fun View.bind(item: Any, position: Int) {
        val item = item as Ingeredient
        val binding = ViewListItemIngredientsBinding.bind(this)
        with(binding)
        {
            title.text = item.title
            ingredientCount.text = item.quantity.toString()
            image.loadImage(item.image, R.drawable.ic_launcher_foreground)

            if (item.available) {
                quantityCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.deep_orange_primary
                    )
                )
            } else {
                quantityCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.gray))
            }
        }
    }

}