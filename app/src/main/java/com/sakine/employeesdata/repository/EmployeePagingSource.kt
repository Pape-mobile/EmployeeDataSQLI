package com.sakine.employeesdata.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sakine.employeesdata.api.RetrofitInstance
import com.sakine.employeesdata.models.EmployeeInfo
import com.sakine.employeesdata.utils.Constants.Companion.FIRST_PAGE_INDEX

class EmployeePagingSource() :
    PagingSource<Int, EmployeeInfo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EmployeeInfo> {
        return try {
            val page: Int = params.key ?: FIRST_PAGE_INDEX
            val response = RetrofitInstance.api.getAllEmployees(page)

            LoadResult.Page(
                data = response.body()?.data!!,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (page == response.body()!!.total_pages) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EmployeeInfo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}