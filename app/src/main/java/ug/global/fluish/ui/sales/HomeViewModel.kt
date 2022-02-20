package ug.global.fluish.ui.sales

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hi Nahabwe Edwin"
    }
    val text: LiveData<String> = _text
}