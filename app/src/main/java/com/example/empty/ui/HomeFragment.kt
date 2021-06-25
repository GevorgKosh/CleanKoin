package com.example.empty.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.empty.R
import com.example.empty.adapter.TaskAdapter
import com.example.empty.databinding.FragmentHomeBinding
import com.example.empty.viewModel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val mViewModel by viewModel<TaskViewModel>()
    private lateinit var mAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        mViewModel.getAllCountries()
        mViewModel.countriesList.observe(viewLifecycleOwner, Observer {
            mAdapter.setList(it)
        })
    }

    private fun initAdapter() {
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            mAdapter = TaskAdapter()
            adapter = mAdapter
        }
    }
}