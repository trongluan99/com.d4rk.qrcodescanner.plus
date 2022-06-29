package com.d4rk.qrcodescanner.plus.feature.tabs.create.qr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.d4rk.qrcodescanner.plus.databinding.FragmentCreateQrCodeVeventBinding
import com.d4rk.qrcodescanner.plus.extension.textString
import com.d4rk.qrcodescanner.plus.feature.tabs.create.BaseCreateBarcodeFragment
import com.d4rk.qrcodescanner.plus.model.schema.Schema
import com.d4rk.qrcodescanner.plus.model.schema.VEvent
class CreateQrCodeEventFragment : BaseCreateBarcodeFragment() {
    private lateinit var _binding: FragmentCreateQrCodeVeventBinding
    private val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCreateQrCodeVeventBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextTitle.requestFocus()
        parentActivity.isCreateBarcodeButtonEnabled = true
    }
    override fun getBarcodeSchema(): Schema {
        return VEvent(
            uid = binding.editTextTitle.textString,
            organizer = binding.editTextOrganizer.textString,
            summary = binding.editTextSummary.textString,
            startDate = binding.buttonDateTimeStart.dateTime,
            endDate = binding.buttonDateTimeEnd.dateTime
        )
    }
}