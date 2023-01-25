package com.sakine.employeesdata.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.sakine.employeesdata.repository.EmployeeRepository


class EmployeeViewModel(
     repository: EmployeeRepository
) : ViewModel() {

    val allEmployees = repository.getAllEmployees().cachedIn(viewModelScope)

}