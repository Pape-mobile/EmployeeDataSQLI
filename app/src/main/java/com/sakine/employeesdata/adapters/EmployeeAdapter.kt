package com.sakine.employeesdata.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sakine.employeesdata.R
import com.sakine.employeesdata.databinding.ListItemEmployeesBinding
import com.sakine.employeesdata.models.EmployeeInfo

class EmployeeAdapter :
    PagingDataAdapter<EmployeeInfo, EmployeeAdapter.EmployeeViewHolder>(diffCallback = differCallBack) {

    inner class EmployeeViewHolder(private val binding: ListItemEmployeesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun showEmployeeData(employeeInfo: EmployeeInfo) {
            binding.apply {
                Glide.with(itemView)
                    .load(employeeInfo.avatar)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_action_person)
                    .into(avatar)

                name.text = "${employeeInfo.first_name} ${employeeInfo.last_name}"
                email.text = employeeInfo.email
            }
        }
    }

    companion object {
        private val differCallBack = object : DiffUtil.ItemCallback<EmployeeInfo>() {
            override fun areItemsTheSame(oldItem: EmployeeInfo, newItem: EmployeeInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: EmployeeInfo, newItem: EmployeeInfo): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            ListItemEmployeesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employeeInfo = getItem(position)
        holder.showEmployeeData(employeeInfo!!)
    }
}