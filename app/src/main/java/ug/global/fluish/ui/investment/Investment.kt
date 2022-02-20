package ug.global.fluish.ui.investment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ug.global.fluish.R
import java.text.NumberFormat

data class Investment(var id: Int, var name: String, var amount: Int, var date: String = "")

class InvestmentAdapter(var context: Context, var investments: ArrayList<Investment>) : RecyclerView.Adapter<InvestmentAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.investmentName)
        var date: TextView = itemView.findViewById(R.id.investmentDate)
        var amount: TextView = itemView.findViewById(R.id.investmentAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.investment_layout, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (id, name, amount, date) = investments[position]
        holder.amount.text = "Ugx." + NumberFormat.getInstance().format(amount)
        holder.name.text = name
        holder.date.text = date
    }

    override fun getItemCount(): Int {
        return investments.size
    }
}