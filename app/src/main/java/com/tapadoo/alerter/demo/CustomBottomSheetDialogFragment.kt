package com.tapadoo.alerter.demo

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tapadoo.alerter.Alerter
import com.tapadoo.alerter.demo.databinding.LayoutModalBottomSheetBinding

class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _binding: LayoutModalBottomSheetBinding? = null
    private val binding: LayoutModalBottomSheetBinding get() = requireNotNull(_binding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LayoutModalBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.btnAlertDefault.setOnClickListener {
            //handle click event
            showAlertDefault(dialog)
        }
        binding.btnAlertColoured.setOnClickListener {
            //handle click event
            showAlertColoured(dialog)
        }
        binding.btnAlertCustomIcon.setOnClickListener {
            //handle click event
            showAlertWithIcon(dialog)
        }
    }

    private fun showAlertDefault(view: Dialog?) {
        view?.let {
            Alerter.create(dialog = it)
                    .setTitle(R.string.title_activity_example)
                    .setText("Alert text...")
                    .show()
        }
    }

    private fun showAlertColoured(view: Dialog?) {
        view?.let {
            Alerter.create(dialog = it)
                    .setTitle("Alert Title")
                    .setText("Alert text...")
                    .setBackgroundColorRes(R.color.colorAccent)
                    .show()
        }
    }

    private fun showAlertWithIcon(view: Dialog?) {
        view?.let {
            Alerter.create(dialog = it)
                    .setText("Alert text...")
                    .setIcon(R.drawable.alerter_ic_mail_outline)
                    .setIconColorFilter(0) // Optional - Removes white tint
                    .setIconSize(R.dimen.custom_icon_size) // Optional - default is 38dp
                    .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}