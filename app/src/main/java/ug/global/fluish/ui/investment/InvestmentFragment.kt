package ug.global.fluish.ui.investment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ug.global.fluish.databinding.FragmentInvestmentBinding
import java.text.NumberFormat

class InvestmentFragment : Fragment() {

    private var _binding: FragmentInvestmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentInvestmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        var total = 0
        val investments = arrayListOf<Investment>()
        val adapter = InvestmentAdapter(requireContext(), investments)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        ViewModelProvider(this)[InvestmentViewModel::class.java].investments.observe(viewLifecycleOwner) { investment ->
            investments.addAll(investment)
            investment.forEach {
                total += it.amount
                binding.totalINvestment.text = "Ugx." + NumberFormat.getInstance().format(total)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}