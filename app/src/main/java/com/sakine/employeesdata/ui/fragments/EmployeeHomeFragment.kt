package com.sakine.employeesdata.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sakine.employeesdata.R
import com.sakine.employeesdata.adapters.EmployeeAdapter
import com.sakine.employeesdata.databinding.FragmentEmployeeHomeBinding
import com.sakine.employeesdata.ui.EmployeeActivity
import com.sakine.employeesdata.ui.EmployeeViewModel

class EmployeeHomeFragment : Fragment(R.layout.fragment_employee_home) {

    private var _binding: FragmentEmployeeHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentEmployeeHomeBinding.bind(view)

        viewModel = (activity as EmployeeActivity).viewModel

        setupRecyclerView()

        getAllEmployees()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupRecyclerView() {
        employeeAdapter = EmployeeAdapter()
        binding.rvListEmployees.apply {
            adapter = employeeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun getAllEmployees() {
        viewModel.allEmployees.observe(viewLifecycleOwner) { employeeInfo ->
            employeeAdapter.submitData(lifecycle, employeeInfo)
        }
    }

}