package br.edu.ifsp.pedrapapeltesourafragments.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import br.edu.ifsp.pedrapapeltesourafragments.R
import br.edu.ifsp.pedrapapeltesourafragments.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var radio02Jogador: RadioButton
    private lateinit var radio03Jogador: RadioButton
    private lateinit var radio01Game: RadioButton
    private lateinit var radio03Game: RadioButton
    private lateinit var radio05Game: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

        radio02Jogador = fragmentSettingsBinding.opDois.findViewById(R.id.op_dois)
        radio03Jogador = fragmentSettingsBinding.opTres.findViewById(R.id.op_tres)
        radio01Game = fragmentSettingsBinding.opUmaJogada.findViewById(R.id.op_uma_jogada)
        radio03Game = fragmentSettingsBinding.opTresJogada.findViewById(R.id.op_tres_jogada)
        radio05Game = fragmentSettingsBinding.opCincoJogada.findViewById(R.id.op_cinco_jogada)

        fragmentSettingsBinding.btnCancelSettings.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        fragmentSettingsBinding.btnSaveSettings.setOnClickListener {
            saveSettings()
            activity?.supportFragmentManager?.popBackStack()
        }

        return fragmentSettingsBinding.root
    }

    fun saveSettings() {
        val jogadores = checkNumJogadores()
        val rodadas = checkNumRodadas()
        Log.i("JOGO", "Jogadores - $jogadores | Rodadas - $rodadas")
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