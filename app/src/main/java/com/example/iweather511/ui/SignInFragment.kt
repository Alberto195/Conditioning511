package com.example.iweather511.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import com.example.iweather511.databinding.SignInFragmentBinding
import com.example.iweather511.repository.Contract


class SignInFragment : Fragment() {
    private lateinit var customContract: ActivityResultLauncher<Unit>
    private var binding: SignInFragmentBinding? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCustomContract()

        binding?.googleSignInButton?.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        customContract.launch(Unit)
    }

    private fun initCustomContract() {
        customContract = registerForActivityResult(Contract()) { id ->
            println(id)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}