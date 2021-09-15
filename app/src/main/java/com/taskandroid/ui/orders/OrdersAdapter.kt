package com.taskandroid.ui.orders

import android.os.CountDownTimer
import android.util.Log
import android.view.View
import com.taskandroid.R
import com.taskandroid.base.RecyclerBaseAdapter
import com.taskandroid.constant.Constants
import com.taskandroid.databinding.ViewListItemOrderBinding
import com.taskandroid.entities.Order
import com.viewtraksol.kyriopos.utils.GeneralUtils
import kotlinx.android.synthetic.main.view_list_item_order.view.*
import java.text.SimpleDateFormat
import java.util.*


class OrdersAdapter(
    private val data: ArrayList<Order>,
    private val itemClicker: OnItemClicker
) :
    RecyclerBaseAdapter(
        itemClicker,
        data,
        R.layout.view_list_item_order,
        Constants.ADAPTER_TYPES.ORDER_ADAPTER
    ) {

    override fun View.bind(item: Any, position: Int) {
        val item = item as Order
        val binding = ViewListItemOrderBinding.bind(this)
        with(binding)
        {
            orderId.text = "#${item.id}"
            addonCountText.text = "${item.addon.size} items"
            orderCreatedAt.text = GeneralUtils.convertServerTimeForOrderText(item.created_at)
            rvAddon.adapter = AddonAdapter(
                item.addon,
                itemClicker
            )
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ")
            var start: Date = parser.parse(item.created_at)
            var alert: Date = parser.parse(item.alerted_at)
            var end: Date = parser.parse(item.expired_at)
            var current = Date()
            if (end > current && start < current) {
                object : CountDownTimer(end.time - current.time, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val seconds: Long = millisUntilFinished / 1000
                        val minutes = seconds / 60
                        val hours = minutes / 60
                        val days = hours / 24
                        val time =
                            "${minutes % 60}:${seconds % 60}"
                        orderCountDown.text = time
                        count_down_bar.currentProgressDot = 3 - minutes.toInt()

                        if (Date() === alert) {
                            itemClicker.onItemClick(
                                position, item, Constants.ADAPTER_TYPES.PLAY_RINGTONE
                            )
                        }

                    }

                    override fun onFinish() {
                        btnAccept.visibility = View.GONE
                        btnReject.visibility = View.VISIBLE
                        count_down_bar.currentProgressDot = 4
                    }
                }.start()
            } else {
                btnAccept.visibility = View.GONE
                btnReject.visibility = View.VISIBLE
            }
            btnAccept.setOnClickListener {
                itemClicker.onItemClick(
                    position, item, Constants.ADAPTER_TYPES.ORDER_ACCEPTED
                )
            }
            btnReject.setOnClickListener {
                itemClicker.onItemClick(
                    position, item, Constants.ADAPTER_TYPES.ORDER_REJECT
                )
            }
        }
    }

}