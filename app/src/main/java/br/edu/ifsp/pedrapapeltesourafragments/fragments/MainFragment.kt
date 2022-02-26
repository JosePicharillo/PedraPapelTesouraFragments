package br.edu.ifsp.pedrapapeltesourafragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.edu.ifsp.pedrapapeltesourafragments.Opcoes
import br.edu.ifsp.pedrapapeltesourafragments.R
import br.edu.ifsp.pedrapapeltesourafragments.options.OpcaoDoisJogadores
import br.edu.ifsp.pedrapapeltesourafragments.options.OpcaoTresJogadores
import java.util.*

class MainFragment : Fragment() {

    val op3 = OpcaoTresJogadores()
    val op2 = OpcaoDoisJogadores()
    var resultadoSB: StringBuilder? = null
    val random = Random(System.currentTimeMillis())
    var imgJogadaPC = -1
    var imgJogadaPC2 = -1
    var jogadorSelecionado = 3

    /**
     * Componentes View
     */
    private lateinit var root: View
    private lateinit var btnPedra: ImageButton
    private lateinit var btnPapel: ImageButton
    private lateinit var btnTesoura: ImageButton
    private lateinit var imgPlay01: ImageView
    private lateinit var imgPlay02: ImageView
    private lateinit var result: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        root = inflater.inflate(R.layout.fragment_main, container, false)

        btnPapel = root.findViewById(R.id.papelBT)
        btnPedra = root.findViewById(R.id.pedraBT)
        btnTesoura = root.findViewById(R.id.tesouraBT)
        imgPlay01 = root.findViewById(R.id.jogadaComputador01Img)
        imgPlay02 = root.findViewById(R.id.jogadaComputador02Img)
        result = root.findViewById(R.id.resultado)

        btnPedra.setOnClickListener {
            startGame(Opcoes.PEDRA)
        }

        btnPapel.setOnClickListener {
            startGame(Opcoes.PAPEL)
        }

        btnTesoura.setOnClickListener {
            startGame(Opcoes.TESOURA)
        }

        return root
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
            result.setText(resultadoSB.toString())
            imgPlay01.setImageResource(imgJogadaPC)
        } else {
            result.setText(resultadoSB.toString())
            imgPlay01.setImageResource(imgJogadaPC)
            imgPlay02.setImageResource(imgJogadaPC2)
        }
    }

}