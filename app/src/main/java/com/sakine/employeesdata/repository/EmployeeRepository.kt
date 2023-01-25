package com.sakine.employeesdata.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class EmployeeRepository {

     fun getAllEmployees() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 200),
        pagingSourceFactory = {EmployeePagingSource()}
    ).liveData

}