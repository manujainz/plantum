package com.manujain.plantum.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.manujain.plantum.adapter.NurseryAdapter
import com.manujain.plantum.databinding.FragmentNurseryBinding
import com.manujain.plantum.models.NurseryPlant
import com.manujain.plantum.network.RetrofitServiceBuilder
import com.manujain.plantum.viewmodel.NurseryViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class NurseryFragment: Fragment() {

    private lateinit var binding: FragmentNurseryBinding
    private val nurseryViewModel by viewModels<NurseryViewModel>()


    companion object {
        val TAG = NurseryFragment::class.simpleName.toString()
        val lTag: String = "[LIFECYCLE] $TAG"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.tag(lTag).d("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(lTag).d("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        Timber.tag(lTag).d("onCreateView")
        binding = FragmentNurseryBinding.inflate(inflater, container, false)

        // init views
        val adapter = NurseryAdapter(requireActivity())
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        nurseryViewModel.nurseryPlantsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyItemChanged(2)
        }

        binding.textYourNursery.setOnClickListener {
            nurseryViewModel.updateDoggos()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag(lTag).d("onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(lTag).d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(lTag).d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(lTag).d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(lTag).d("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag(lTag).d("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(lTag).d("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag(lTag).d("onDetach")
    }
}