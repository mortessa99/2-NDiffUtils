package com.example.a2_ndiffutils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_ndiffutils.databinding.UserItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    private lateinit var  binding:UserItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        binding = UserItemBinding.inflate(inflater,parent,false)
        return UserViewHolder()
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size

    inner class UserViewHolder:RecyclerView.ViewHolder(binding.root){
        fun setData(item: UserModel){
            binding.textViewItem.text = "${item.name} ${item.age}"
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<UserModel>(){
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }

    }

     val differ = AsyncListDiffer(this,differCallBack)
}