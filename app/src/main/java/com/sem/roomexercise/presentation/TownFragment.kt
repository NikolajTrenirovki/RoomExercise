package com.sem.roomexercise.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.roomexercise.R
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.sem.roomexercise.data.models.TownModel
import com.sem.roomexercise.databinding.FragmentTownBinding
import kotlinx.coroutines.launch


class TownFragment : Fragment() {

    private var townBinding: FragmentTownBinding? = null
    private var townAdapter: TownAdapter? = null

    private val binding get() = townBinding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        townBinding = FragmentTownBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private val viewModel: TownModel by activityViewModels {
        TownModel(
            (activity?.application as TownModel)
                .database.scheduleDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.townRv
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val busStopAdapter = TownAdapter({
            val action = TownFragmentDirections
                .actionFullScheduleFragmentToStopScheduleFragment(
                    stopName = it.stopName
                )
            view.findNavController().navigate(action)
        })
        recyclerView.adapter = busStopAdapter
        lifecycle.coroutineScope.launch {
            viewModel.fullSchedule().collect() {
                busStopAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        townBinding = null
    }

/*    // инициализация адаптера
    private fun init() {
        // вертикальный макет recyclerView
        binding?.townRv?.layoutManager =
            LinearLayoutManager(context)
        townAdapter =
            TownAdapter ()
        binding?.townRv?.adapter = townAdapter

    }

    private fun loadTown() {
        // получение всех необходимых данных для заполнения recyclerView
        medicationsViewModel.loadMedicines.observe(viewLifecycleOwner, Observer {
            // setList наполняет адаптер данными
            medicationsAdapter?.setList(it)
            // notifyDataSetChanged обновляет адаптер
            medicationsAdapter?.notifyDataSetChanged()
        })
    }*/
}