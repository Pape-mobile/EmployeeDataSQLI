package com.sakine.employeesdata.models

data class Employee(
    var `data`: List<EmployeeInfo>?,
    var page: Int?,
    var per_page: Int?,
    var support: Support?,
    var total: Int?,
    var total_pages: Int?
)