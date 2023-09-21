package com.example.petvip.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.petvip.R
import com.example.petvip.adapter.ServicosAdapter
import com.example.petvip.databinding.ActivityHome2Binding
import com.example.petvip.databinding.ActivityHome2Binding.*
import com.example.petvip.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var  binding: ActivityHome2Binding
    private lateinit var servicosAdapter: ServicosAdapter
    private  val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem-vindo,$nome"

        val recycleViewServicos = binding.recyclerViewServicos
        recycleViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this,listaServicos)
        recycleViewServicos.setHasFixedSize(true)
        recycleViewServicos.adapter = servicosAdapter
        getServicos()

        binding.btAgendar.setOnClickListener{
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }

    }

    private fun getServicos(){
       val servicos1 = Servicos(R.drawable.img1, "Banho e tosa")
        listaServicos.add(servicos1)

        val servicos2 = Servicos(R.drawable.img2, "Tosa")
        listaServicos.add(servicos2)

        val servicos3 = Servicos(R.drawable.img3, "Consulta c/ vet")
        listaServicos.add(servicos3)

        val servicos4 = Servicos(R.drawable.img4, "Day care")
        listaServicos.add(servicos4)
    }
}