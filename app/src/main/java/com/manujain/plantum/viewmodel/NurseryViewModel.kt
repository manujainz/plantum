package com.manujain.plantum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.manujain.plantum.models.NurseryPlant
import com.manujain.plantum.network.RetrofitServiceBuilder
import com.manujain.plantum.network.api.DoggoAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class NurseryViewModel @Inject constructor(private val doggoService: DoggoAPI): ViewModel() {

    private val _nurseryPlantsLiveData: MutableLiveData<List<NurseryPlant>> by lazy { MutableLiveData<List<NurseryPlant>>() }
    val nurseryPlantsLiveData: LiveData<List<NurseryPlant>> = _nurseryPlantsLiveData

    private val nurseryPlants = mutableListOf<NurseryPlant>()

    init {
        getDoggos()
    }

    fun fetchPlants(urls: List<String>) {
        var index = 1
        repeat(10) {
            nurseryPlants.add(NurseryPlant(id = index, name = "Plant $index", imageLink = URL(urls[index-1])))
            index++
        }
        _nurseryPlantsLiveData.value = nurseryPlants
    }

    fun updateDoggos() {
        nurseryPlants[2] = NurseryPlant(202, "Moroccan Rose")
        _nurseryPlantsLiveData.value = nurseryPlants
    }

    fun getDoggos() {
        val call = doggoService.getDoggos(count = 10, url = true)

        call.enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                response.body()?.let { fetchPlants(it) }
            }
            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                Timber.d(t.message)
            }
        })
    }
}