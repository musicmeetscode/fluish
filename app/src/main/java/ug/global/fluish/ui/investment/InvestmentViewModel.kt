package ug.global.fluish.ui.investment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InvestmentViewModel : ViewModel() {
    val investments: LiveData<ArrayList<Investment>> = MutableLiveData<ArrayList<Investment>>().apply {
        val innerInvestments = arrayListOf<Investment>()
        for (i in 0..5) {
            innerInvestments.add(Investment(i, "name or thing", 30000))
        }
        value = innerInvestments
    }
}