package ug.global.fluish.ui.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductsViewModel : ViewModel() {
    val products = MutableLiveData<ArrayList<Product>>().apply {
        val productsInner = arrayListOf<Product>()
        for (i in 0..10) {
            productsInner.add(Product(i, "New name", "Packet(s)", 3000, "jsdbfjhsbfisubfgh"))
            productsInner.add(Product(i, "New name", "Packet(s)", 3000, "jsdbhjfv7t3 3r8734gru3hb4 r43uy34 rb3 4r384rb3 "))
        }
        value = productsInner
    }
}