package br.edu.ifsp.pedrapapeltesourafragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import br.edu.ifsp.pedrapapeltesourafragments.R
import br.edu.ifsp.pedrapapeltesourafragments.data.DatabaseHelper
import br.edu.ifsp.pedrapapeltesourafragments.data.Settings

class SettingsFragment : Fragment() {

    private lateinit var root: View
    private lateinit var btnSave: Button
    private lateinit var btnCancel: Button
    private lateinit var radio02Jogador: RadioButton
    private lateinit var radio03Jogador: RadioButton
    private lateinit var radio01Game: RadioButton
    private lateinit var radio03Game: RadioButton
    private lateinit var radio05Game: RadioButton

    val db = context?.let { DatabaseHelper(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        root = inflater.inflate(R.layout.fragment_settings, container, false)

        btnSave = root.findViewById(R.id.btnSaveSettings)
        btnCancel = root.findViewById(R.id.btnCancelSettings)
        radio02Jogador = root.findViewById(R.id.op_dois)
        radio03Jogador = root.findViewById(R.id.op_tres)
        radio01Game = root.findViewById(R.id.op_uma_jogada)
        radio03Game = root.findViewById(R.id.op_tres_jogada)
        radio05Game = root.findViewById(R.id.op_cinco_jogada)

        btnCancel.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        btnSave.setOnClickListener {
            saveSettings()
            activity?.supportFragmentManager?.popBackStack()
        }

        return root
    }

    fun saveSettings() {
        val jogadores = checkNumJogadores()
        val rodadas = checkNumRodadas()

        val s = Settings(1, jogadores, rodadas)
        db?.updateSettings(s)
    }

    fun checkNumJogadores(): Int {
        var op = 0
        if (radio02Jogador.isChecked) op = 2
        if (radio03Jogador.isChecked) op = 3
        return op
    }

    fun checkNumRodadas(): Int {
        var op2 = 0
        if (radio01Game.isChecked) op2 = 1
        if (radio03Game.isChecked) op2 = 3
        if (radio05Game.isChecked) op2 = 5
        return op2
    }

}