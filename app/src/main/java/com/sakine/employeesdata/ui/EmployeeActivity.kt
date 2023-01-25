package com.sakine.employeesdata.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sakine.employeesdata.R
import com.sakine.employeesdata.repository.EmployeeRepository

class EmployeeActivity : AppCompatActivity() {
    lateinit var viewModel: EmployeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        val employeeRepository = EmployeeRepository()
        val employeeViewModelProviderFactory = EmployeeViewModelProviderFactory(employeeRepository)
        viewModel = ViewModelProvider(this, employeeViewModelProviderFactory)[EmployeeViewModel::class.java]

    }
}