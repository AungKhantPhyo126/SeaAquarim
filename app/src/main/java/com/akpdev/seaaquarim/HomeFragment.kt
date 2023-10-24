package com.akpdev.seaaquarim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.akpdev.seaaquarim.data.MyDummyData
import com.akpdev.seaaquarim.databinding.FragmentHomeBinding
import com.akpdev.seaaquarim.detail.DetailViewModel

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(inflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val headerRecyclerAdapter = HeaderRecyclerAdapter()
        binding?.rvHeaderImages?.adapter = headerRecyclerAdapter
        binding?.indicator?.attachToRecyclerView(binding!!.rvHeaderImages)

        val upcomingShowsRecyclerAdapter = UpcomingShowsRecyclerAdapter{
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
        }
        binding?.includeUpcomingShows?.rvUpcomingShows?.adapter = upcomingShowsRecyclerAdapter

        viewModel.myData.observe(viewLifecycleOwner){
            headerRecyclerAdapter.submitList(it)
            upcomingShowsRecyclerAdapter.submitList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}