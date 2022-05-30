package com.rumeysaozer.retrofitusers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.retrofitusers.adapter.UserAdapter
import com.rumeysaozer.retrofitusers.databinding.ActivityMainBinding
import com.rumeysaozer.retrofitusers.model.User
import com.rumeysaozer.retrofitusers.service.UserAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userAPIService = UserAPIService()
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getData()
    }
    fun getData(){
        disposable.add(
            userAPIService.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<User>(){
                    override fun onSuccess(t: User) {
                    val  adapter = UserAdapter(t)
                        binding.recyclerView.adapter = adapter
                    }

                    override fun onError(e: Throwable) {
                     e.printStackTrace()
                    }

                })
        )
    }

}