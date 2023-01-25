package com.sakine.employeesdata.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sakine.employeesdata.repository.EmployeeRepository

@Suppress("UNCHECKED_CAST")
class EmployeeViewModelProviderFactory(
    private val repository: EmployeeRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(repository) as T
    }
}