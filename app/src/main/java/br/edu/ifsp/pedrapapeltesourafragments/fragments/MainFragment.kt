package br.edu.ifsp.pedrapapeltesourafragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.edu.ifsp.pedrapapeltesourafragments.Opcoes
import br.edu.ifsp.pedrapapeltesourafragments.R
import br.edu.ifsp.pedrapapeltesourafragments.databinding.FragmentMainBinding
import br.edu.ifsp.pedrapapeltesourafragments.options.OpcaoDoisJogadores
import br.edu.ifsp.pedrapapeltesourafragments.options.OpcaoTresJogadores
import java.util.*

class MainFragment : Fragment() {

    private lateinit var imgPlay01: ImageView
    private lateinit var imgPlay02: ImageView
    private lateinit var result: TextView
    val op3 = OpcaoTresJogadores()
    val op2 = OpcaoDoisJogadores()
    var resultadoSB: StringBuilder? = null
    val random = Random(System.currentTimeMillis())
    var imgJogadaPC = -1
    var imgJogadaPC2 = -1
    var jogadorSelecionado = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

        imgPlay01 = fragmentMainBinding.jogadaComputador01Img.findViewById(R.id.jogadaComputador01Img)
        imgPlay02 = fragmentMainBinding.jogadaComputador02Img.findViewById(R.id.jogadaComputador02Img)
        result = fragmentMainBinding.resultado.findViewById(R.id.resultado)

        fragmentMainBinding.pedraBT.setOnClickListener {
            startGame(Opcoes.PEDRA)
        }

        fragmentMainBinding.papelBT.setOnClickListener {
            startGame(Opcoes.PAPEL)
        }

        fragmentMainBinding.tesouraBT.setOnClickListener {
            startGame(Opcoes.TESOURA)
        }

        return fragmentMainBinding.root
    }

    private fun startGame(jogada: Opcoes) {
        if (jogadorSelecionado == 2) {
            val jogadaComputador01 = random.nextInt(3)
            resultadoSB = op2.verificaJogoDoisJogadores(jogada, jogadaComputador01)

            when (jogadaComputador01) {
                0 -> imgJogadaPC = R.mipmap.pedra
                1 -> imgJogadaPC = R.mipmap.papel
                2 -> imgJogadaPC = R.mipmap.tesoura
                else -> {}
            }
            result()
        } else {
            val jogadaComputador01 = random.nextInt(3)
            val jogadaComputador02 = random.nextInt(3)
            resultadoSB =
                op3.verificaJogoTresJogadores(jogada, jogadaComputador01, jogadaComputador02)

            when (jogadaComputador01) {
                0 -> imgJogadaPC = R.mipmap.pedra
                1 -> imgJogadaPC = R.mipmap.papel
                2 -> imgJogadaPC = R.mipmap.tesoura
                else -> {}
            }

            when (jogadaComputador02) {
                0 -> imgJogadaPC2 = R.mipmap.pedra
                1 -> imgJogadaPC2 = R.mipmap.papel
                2 -> imgJogadaPC2 = R.mipmap.tesoura
                else -> {}
            }
            result()
        }
    }

    private fun result() {
        if (jogadorSelecionado == 2) {
            result.text = resultadoSB.toString()
            imgPlay01.setImageResource(imgJogadaPC)
        } else {
            result.text = resultadoSB.toString()
            imgPlay01.setImageResource(imgJogadaPC)
            imgPlay02.setImageResource(imgJogadaPC2)
        }
    }

}