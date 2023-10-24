package com.akpdev.seaaquarim.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akpdev.seaaquarim.R
import com.akpdev.seaaquarim.UpcomingShowsRecyclerAdapter
import com.akpdev.seaaquarim.data.MyDummyData
import com.akpdev.seaaquarim.databinding.FragmentDetailBinding

class DetailFragment:Fragment() {
    private var binding:FragmentDetailBinding? = null
    private val viewModel by viewModels<DetailViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentDetailBinding.inflate(inflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailRecyclerAdapter = DetailRecyclerAdapter()

        binding?.rvDetail?.adapter = detailRecyclerAdapter
        viewModel.myData.observe(viewLifecycleOwner){
            detailRecyclerAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}