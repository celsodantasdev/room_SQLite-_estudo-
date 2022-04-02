package com.example.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sqlcomroom.data.User
import com.example.sqlcomroom.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(
            layoutInflater, container, false
        )

        mainViewModel = MainViewModel(context)

        fun validar(nome: String, sobrenome: String, idade: String): Boolean{
            return !(nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty())
        }

        fun inserirNoBanco(){
            val nome = binding.editNome.toString()
            val sobrenome = binding.editSobreNome.toString()
            val idade = binding.editTextNumber.toString()

            if (validar(nome, sobrenome, idade)){
                val user = User(0, nome, sobrenome, idade.toInt())
                mainViewModel.addUser(user)
                Toast.makeText(context, "Usuário Cadastrado", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}