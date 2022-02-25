package br.edu.ifsp.pedrapapeltesourafragments.options

import br.edu.ifsp.pedrapapeltesourafragments.Opcoes
import br.edu.ifsp.pedrapapeltesourafragments.conditions.CondicaoPapel
import br.edu.ifsp.pedrapapeltesourafragments.conditions.CondicaoPedra
import br.edu.ifsp.pedrapapeltesourafragments.conditions.CondicaoTesoura

class OpcaoDoisJogadores {

    /**
     * Verifica as opções escolhidas pela computador
     */
    fun verificaJogoDoisJogadores(jogada: Opcoes, jogadaComputador01: Int): StringBuilder? {
        var opComputador01: Opcoes = Opcoes.NONE
        when (jogadaComputador01) {
            0 -> opComputador01 = Opcoes.PEDRA
            1 -> opComputador01 = Opcoes.PAPEL
            2 -> opComputador01 = Opcoes.TESOURA
            else -> {}
        }
        return mensagemJogo(jogada, opComputador01)
    }

    /**
     * Mensagens das jogadas e mostra os resultados
     */
    private fun mensagemJogo(jogada: Opcoes, jogadaComputador01: Opcoes): StringBuilder? {
        val resultadoSB = StringBuilder()
        val pedra = CondicaoPedra()
        val papel = CondicaoPapel()
        val tesoura = CondicaoTesoura()
        var resposta = ""

        resultadoSB.append("Sua Jogada: ")
        resultadoSB.append(jogada)
        resultadoSB.append('\n')
        resultadoSB.append("Jogada Computador 01: ")
        resultadoSB.append(jogadaComputador01)
        resultadoSB.append('\n')
        resultadoSB.append('\n')

        when (jogada) {
            Opcoes.PEDRA -> resposta = pedra.calculoCondicaoPedraDoisJogadores(jogadaComputador01)
            Opcoes.PAPEL -> resposta = papel.calculoCondicaoPapelDoisJogadores(jogadaComputador01)
            Opcoes.TESOURA -> resposta = tesoura.calculoCondicaoTesouraDoisJogadores(jogadaComputador01)
            else -> {}
        }
        resultadoSB.append(resposta)
        return resultadoSB
    }
}