package com.shady.tiger.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shady.tiger.R
import com.shady.tiger.data.JobsMockData
import kotlinx.android.synthetic.main.rv_row.view.*

class MainAdapter(val jobsList: ArrayList<JobsMockData>)  : RecyclerView.Adapter<MainAdapter.JobsViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        return JobsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jobsList.size
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bindItems(jobsList[position])
    }

    class JobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(job: JobsMockData) = with(itemView) {
            tvCustomerName.text = job.customer_name
            tvStatus.text = job.status
            tvId.text = job.order_id

            setOnClickListener{
                val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(job)
                it.findNavController().navigate(action)
                /*val bundle = bundleOf("job" to job)
                it.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)*/
            }
        }
    }
}