package com.shady.tiger.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.shady.tiger.R
import kotlinx.android.synthetic.main.rv_row.*

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rv_row, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: DetailsFragmentArgs by navArgs()
        val job = safeArgs.job
//        val job = arguments?.get("job") as JobsMockData
        tvCustomerName.text = job.customer_name
        tvStatus.text = job.status
        tvId.text = job.order_id
    }

}
