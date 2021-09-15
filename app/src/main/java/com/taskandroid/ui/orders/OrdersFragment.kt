package com.taskandroid.ui.orders

import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.taskandroid.R
import com.taskandroid.base.RecyclerBaseAdapter
import com.taskandroid.constant.Constants
import com.taskandroid.constant.DelayConstant
import com.taskandroid.databinding.FragmentOrdersBinding
import com.taskandroid.di.module.App
import com.taskandroid.entities.Order
import com.taskandroid.ui.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class OrdersFragment : BaseFragment(R.layout.fragment_orders), View.OnClickListener,
    RecyclerBaseAdapter.OnItemClicker {

    private val viewModel: OrdersViewModel by viewModel()
    private var mBackPressed: Long = 0
    private lateinit var navController: NavController
    private lateinit var binding: FragmentOrdersBinding
    private val orderArrayList: ArrayList<Order> = ArrayList()

    private val ordersAdapter by lazy {
        OrdersAdapter(
            orderArrayList,
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.createOrdersData()
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                if (mBackPressed + DelayConstant.CLOSE_DELAY > System.currentTimeMillis()) {
                    activity!!.finish()
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.exit_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                mBackPressed = System.currentTimeMillis()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun setupViews() {
        binding = FragmentOrdersBinding.bind(parentView)
        subscribeUi()
    }

    override fun attachViewModel() {
        with(viewModel) {
            orderList.observe(viewLifecycleOwner, {
                if (it != null) {
                    orderArrayList.clear()
                    orderArrayList.addAll(it)
                    ordersAdapter.notifyDataSetChanged()
                    orderList.value = null
                }
            })
        }
    }

    private fun subscribeUi() {
        binding.rvOrders.adapter = ordersAdapter
        binding.btnIngredients.setOnClickListener(this)
        binding.btnMenu.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_menu -> Toast.makeText(requireContext(), "Menu Button", Toast.LENGTH_SHORT)
                .show()
            R.id.btn_ingredients -> navController.navigate(OrdersFragmentDirections.actionOrderFragmentToIngredientsFragment())
        }
    }

    override fun onItemClick(position: Int, data: Any, adapterType: Int) {
        when (adapterType) {
            Constants.ADAPTER_TYPES.ORDER_ADAPTER -> {
                //order item click
            }
            Constants.ADAPTER_TYPES.ORDER_ACCEPTED -> {
                orderArrayList.removeAt(position)
                ordersAdapter.notifyItemRemoved(position)
                ordersAdapter.notifyItemRangeChanged(position, orderArrayList.size)
                pauseRingTone()
            }
            Constants.ADAPTER_TYPES.ORDER_REJECT -> {
                orderArrayList.removeAt(position)
                ordersAdapter.notifyItemRemoved(position)
                ordersAdapter.notifyItemRangeChanged(position, orderArrayList.size)
            }
            Constants.ADAPTER_TYPES.PLAY_RINGTONE -> {
                ringBellForCallNotification()
            }
            Constants.ADAPTER_TYPES.PAUSE_RINGTONE -> {
                pauseRingTone()
            }
        }
    }

    private var ringToneMediaPlayer: MediaPlayer? = null
    fun ringBellForCallNotification() {
        pauseRingTone()
        ringToneMediaPlayer = MediaPlayer.create(requireContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
        ringToneMediaPlayer?.apply {
            isLooping = true
            start()
        }
    }

    /**
     * Pause the ring tone
     */
    fun pauseRingTone() {
        ringToneMediaPlayer?.stop()
    }
}