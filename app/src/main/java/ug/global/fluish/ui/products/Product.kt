package ug.global.fluish.ui.products

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ug.global.fluish.R
import java.text.NumberFormat

data class Product(var id: Int, var name: String, var unit: String, var unitCost: Int, var contents: String)

class ProductsAdapter(var context: Context, var products: ArrayList<Product>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.productName)
        var unit: TextView = itemView.findViewById(R.id.productUnit)
        var description: TextView = itemView.findViewById(R.id.productDescription)
        var cost: TextView = itemView.findViewById(R.id.productCost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (id, name, unit, unitCost, contents) = products[position]
        holder.name.text = name
        holder.unit.text = unit
        holder.description.text = contents
        holder.cost.text = NumberFormat.getInstance().format(unitCost)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}