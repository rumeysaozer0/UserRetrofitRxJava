package com.rumeysaozer.retrofitusers.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.retrofitusers.databinding.RowItemBinding
import com.rumeysaozer.retrofitusers.model.UserItem
import com.rumeysaozer.retrofitusers.view.DetailsActivity

class UserAdapter(val userList: ArrayList<UserItem>): RecyclerView.Adapter<UserAdapter.Userholder>() {
    class Userholder(var binding: RowItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Userholder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Userholder(binding)
    }

    override fun onBindViewHolder(holder: Userholder, position: Int) {
        holder.binding.userItem.text = userList[position].name
        holder.itemView.setOnClickListener {
        val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("user",userList[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}