package com.taskandroid.ui.ingredients

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.konnect.helper.observe
import com.taskandroid.R
import com.taskandroid.base.RecyclerBaseAdapter
import com.taskandroid.constant.Constants
import com.taskandroid.databinding.FragmentIngredientsBinding
import com.taskandroid.entities.Ingeredient
import com.taskandroid.ui.BaseFragment
import com.taskandroid.ui.ingredients.IngredientsFragment.TABS.BENTO_TAB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class IngredientsFragment : BaseFragment(R.layout.fragment_ingredients), View.OnClickListener,
    RecyclerBaseAdapter.OnItemClicker {

    private val viewModel: IngredientsViewModel by viewModel()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentIngredientsBinding
    private val ingredientArrayList: ArrayList<Ingeredient> = ArrayList()

    private val ingredientsAdapter by lazy {
        IngredientsAdapter(
            requireContext(),
            ingredientArrayList,
            this
        )
    }
    private var selectedTab = BENTO_TAB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun setupViews() {
        binding = FragmentIngredientsBinding.bind(parentView)
        subscribeUi()
    }

    override fun attachViewModel() {
        with(viewModel) {
            ingredientList.observe(viewLifecycleOwner, {
                ingredientArrayList.clear()
                ingredientArrayList.addAll(it)
                ingredientsAdapter.notifyDataSetChanged()
            })
            createBentoIngredientsData()
        }
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back -> navController.popBackStack()
        }
    }

    private fun subscribeUi() {
        binding.rvIngredients.adapter = ingredientsAdapter
        val mLayoutManager = FlexboxLayoutManager(context, FlexDirection.ROW)
        mLayoutManager.justifyContent = JustifyContent.SPACE_EVENLY
        binding.rvIngredients.layoutManager = mLayoutManager
        binding.rvIngredients.itemAnimator = DefaultItemAnimator()

        binding.tabLayout.observe {
            selectedTab = it
            showHideTabsData(it)
        }

        binding.etSearch.observe {
            if (it.isEmpty()) {
                ingredientArrayList.clear()
                ingredientArrayList.addAll(viewModel.ingredientList.value!!)
                ingredientsAdapter.notifyDataSetChanged()
            } else {
                filterIngredients(it)
            }
        }
        binding.btnBack.setOnClickListener(this)
    }

    override fun onItemClick(position: Int, data: Any, adapterType: Int) {
        when (adapterType) {
            Constants.ADAPTER_TYPES.INGREDIENT_ADAPTER -> {
                //item click
            }
        }
    }

    private fun showHideTabsData(tabPosition: Int) {
        when (tabPosition) {
            0 -> {
                viewModel.createBentoIngredientsData()
            }
            1 -> {
                viewModel.createMainIngredientsData()
            }
            2 -> {
                viewModel.createAppetizerIngredientsData()
            }
        }
    }

    private fun filterIngredients(searchQuery: String) {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {
            ingredientArrayList.clear()
            ingredientArrayList.addAll(viewModel.ingredientList.value!!.filter {
                it.title.lowercase().contains(searchQuery.lowercase())
            })
            withContext(Dispatchers.Main) {
                ingredientsAdapter.notifyDataSetChanged()
            }
        }
    }

    object TABS {
        const val BENTO_TAB = 0
        const val MAIN_TAB = 1
        const val APPETIZER_TAB = 2
    }
}