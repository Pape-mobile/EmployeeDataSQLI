package com.sakine.employeesdata.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.sakine.employeesdata.models.EmployeeInfo
import com.sakine.employeesdata.repository.EmployeeRepository
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class EmployeeViewModelTest {
    private lateinit var viewModel: EmployeeViewModel
    private val repository = EmployeeRepository()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setInstance() {
        viewModel = EmployeeViewModel(repository)
    }


    @Test
    fun getAllEmployees() {
        val employeeList = viewModel.allEmployees
        val employeeInfo = EmployeeInfo(
            1,
            "George",
            "Bluth",
            "george.bluth@reqres.in",
            "https://reqres.in/img/faces/1-image.jpg"
        )
        val pagingEmployeeData = MutableLiveData<PagingData<EmployeeInfo>>()
        val pagingDataList = listOf(employeeInfo)
        pagingEmployeeData.value = PagingData.from(pagingDataList)

        assertTrue(pagingDataList.isNotEmpty())
        assertNotNull(pagingEmployeeData.value)
        assertNotNull(employeeList)
    }


}