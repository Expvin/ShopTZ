package com.expv1n.onlineshop.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("Unknown binding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        initButton()
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? MainActivity)?.showBottomNavigationView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initButton() {
        binding.profileLogOutLinerLayout.setOnClickListener {
            launchFragment(SignInPageFragment.getInstance(), SignInPageFragment.NAME)
        }
    }

    private fun launchFragment(fragment: Fragment, fragmentName: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, fragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    companion object {
        const val NAME = "ProfileFragment"
        fun getInstance() = ProfileFragment()
    }
}