package br.edu.ifsp.pedrapapeltesourafragments.options

import br.edu.ifsp.pedrapapeltesourafragments.Opcoes
import br.edu.ifsp.pedrapapeltesourafragments.conditions.CondicaoPapel
import br.edu.ifsp.pedrapapeltesourafragments.conditions.CondicaoPedra
import br.edu.ifsp.pedrapapeltesourafragments.conditions.CondicaoTesoura

class OpcaoTresJogadores {

    /**
     * Verifica as opções escolhidas pela computador
     */
    fun verificaJogoTresJogadores(
        jogada: Opcoes,
        jogadaComputador01: Int,
        jogadaComputador02: Int,
    ): StringBuilder? {
        var opComputador01: Opcoes = Opcoes.NONE
        var opComputador02: Opcoes = Opcoes.NONE
        when (jogadaComputador01) {
            0 -> opComputador01 = Opcoes.PEDRA
            1 -> opComputador01 = Opcoes.PAPEL
            2 -> opComputador01 = Opcoes.TESOURA
            else -> {}
        }
        when (jogadaComputador02) {
            0 -> opComputador02 = Opcoes.PEDRA
            1 -> opComputador02 = Opcoes.PAPEL
            2 -> opComputador02 = Opcoes.TESOURA
            else -> {}
        }
        return mensagemJogo(jogada, opComputador01, opComputador02)
    }

    /**
     * Mensagens das jogadas e mostra os resultados
     */
    private fun mensagemJogo(
        jogada: Opcoes,
        jogadaComputador01: Opcoes,
        jogadaComputador02: Opcoes,
    ): StringBuilder? {
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
        resultadoSB.append("Jogada Computador 02: ")
        resultadoSB.append(jogadaComputador02)
        resultadoSB.append('\n')
        resultadoSB.append('\n')

        when (jogada) {
            Opcoes.PEDRA -> resposta = pedra.calculoCondicaoPedra(jogadaComputador01, jogadaComputador02)
            Opcoes.PAPEL -> resposta = papel.calculoCondicaoPapelTresJogadores(jogadaComputador01, jogadaComputador02)
            Opcoes.TESOURA -> resposta = tesoura.calculoCondicaoTesoura(jogadaComputador01, jogadaComputador02)
            else -> {}
        }
        resultadoSB.append(resposta)
        return resultadoSB
    }
}