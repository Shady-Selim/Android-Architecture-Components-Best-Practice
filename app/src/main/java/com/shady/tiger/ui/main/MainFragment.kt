package com.shady.tiger.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.tiger.R
import com.shady.tiger.data.JobsMockData
import com.shady.tiger.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getJobs().observe(this, Observer<ArrayList<JobsMockData>> {
            rvJobs.layoutManager = LinearLayoutManager(context)
            rvJobs.addItemDecoration(
                DividerItemDecoration(
                    rvJobs.context,
                    DividerItemDecoration.VERTICAL
                ))
            rvJobs.adapter = MainAdapter(it)
            message.text = "${getString(R.string.no_of_jobs_mainfragment_count)} ${it.size}"
        })
        val binding =
            DataBindingUtil.inflate<MainFragmentBinding>(
                inflater,
                R.layout.main_fragment,
                container,
                false
            )
        binding.viewModel = viewModel
        binding.mainFragment = this@MainFragment
        binding.lifecycleOwner = this@MainFragment
        return  binding.root
    }
}
