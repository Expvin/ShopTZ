package com.expv1n.onlineshop.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.ShopApplication
import com.expv1n.onlineshop.databinding.FragmentPage1Binding
import com.expv1n.onlineshop.presentation.adapter.FlashSaleAdapter
import com.expv1n.onlineshop.presentation.adapter.LatestAdapter
import com.expv1n.onlineshop.presentation.viewmodel.LoginFragmentViewModel
import com.expv1n.onlineshop.presentation.viewmodel.Page1FragmentViewModel
import com.expv1n.onlineshop.presentation.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Page1Fragment : Fragment() {

    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("Unknown binding")
    private lateinit var latestAdapter: LatestAdapter
    private lateinit var flashSaleAdapter: FlashSaleAdapter
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var viewModel: Page1FragmentViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as ShopApplication).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPage1Binding.inflate(inflater, container, false)
        initButton()
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? MainActivity)?.showBottomNavigationView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[Page1FragmentViewModel::class.java]
        setupAdapters()
        coroutineScope.launch {
            viewModel.getData()
            viewModel.latestLiveDate.observe(requireActivity()) {
                latestAdapter.submitList(it)
            }
            viewModel.flashSaleLiveDate.observe(requireActivity()) {
                flashSaleAdapter.submitList(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun initButton() {
        binding.page1ImageView.setOnClickListener {
            launchFragment(ProfileFragment.getInstance(), ProfileFragment.NAME)
        }
    }

    private fun launchFragment(fragment: Fragment, fragmentName: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, fragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    private fun setupAdapters() {
        latestAdapter = LatestAdapter()
        binding.page1LatestRecyclerView.adapter = latestAdapter
        binding.page1LatestRecyclerView.layoutManager = LinearLayoutManager(requireActivity(),
            LinearLayoutManager.HORIZONTAL, false)
        flashSaleAdapter = FlashSaleAdapter()
        binding.page1FlashSaleRecyclerView.adapter = flashSaleAdapter
        binding.page1FlashSaleRecyclerView.layoutManager = LinearLayoutManager(requireActivity(),
            LinearLayoutManager.HORIZONTAL, false)
        binding.page1BrandsRecyclerView.adapter = latestAdapter
        binding.page1BrandsRecyclerView.layoutManager = LinearLayoutManager(requireActivity(),
            LinearLayoutManager.HORIZONTAL, false)
    }

    companion object {

        const val NAME = "Page1Fragment"

        fun getInstance() = Page1Fragment()

    }

}