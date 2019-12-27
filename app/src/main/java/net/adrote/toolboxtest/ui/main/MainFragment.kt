package net.adrote.toolboxtest.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import net.adrote.toolboxtest.R
import net.adrote.toolboxtest.ui.model.Data

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter:MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.authenthicate()
        viewModel.dataListToObserve().observe(viewLifecycleOwner, Observer {
            prepareRecyclerView(it)
        })
    }

    private fun prepareRecyclerView(lista: List<Data>) {
        if(lista.size>0){
            mainAdapter = MainAdapter(lista)

            mainRecycler.layoutManager = LinearLayoutManager(context)
            mainRecycler.setItemAnimator(DefaultItemAnimator())
            mainRecycler.adapter = mainAdapter
            mainAdapter.notifyDataSetChanged()
        }
    }
}
