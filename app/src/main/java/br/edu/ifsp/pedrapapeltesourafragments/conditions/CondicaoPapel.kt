package br.edu.ifsp.pedrapapeltesourafragments.conditions

import br.edu.ifsp.pedrapapeltesourafragments.Opcoes

class CondicaoPapel {

    /**
     * Calcula se a condição do jogador for PAPEL (Jogo com 3 Jogadores)
     */
    fun calculoCondicaoPapelTresJogadores(
        jogadaComputador01: Opcoes,
        jogadaComputador02: Opcoes,
    ): String {
        var resposta = ""
        if (jogadaComputador01 === Opcoes.PEDRA && jogadaComputador02 === Opcoes.PEDRA) {
            resposta = "VOCÊ VENCEU"
        }
        if (jogadaComputador01 === Opcoes.PEDRA && jogadaComputador02 === Opcoes.PAPEL) {
            resposta = "EMPATE - VOCÊ E COMPUTADOR 02 EMPATARAM"
        }
        if (jogadaComputador01 === Opcoes.PEDRA && jogadaComputador02 === Opcoes.TESOURA) {
            resposta = "EMPATE"
        }
        if (jogadaComputador01 === Opcoes.PAPEL && jogadaComputador02 === Opcoes.PEDRA) {
            resposta = "EMPATE - VOCÊ E COMPUTADOR 01 EMPATARAM"
        }
        if (jogadaComputador01 === Opcoes.PAPEL && jogadaComputador02 === Opcoes.PAPEL) {
            resposta = "EMPATE - TODOS OS JOGADORES ESCOLHERAM PAPEL"
        }
        if (jogadaComputador01 === Opcoes.PAPEL && jogadaComputador02 === Opcoes.TESOURA) {
            resposta = "VOCÊ PERDEU - COMPUTADOR 02 VENCEU"
        }
        if (jogadaComputador01 === Opcoes.TESOURA && jogadaComputador02 === Opcoes.PEDRA) {
            resposta = "EMPATE"
        }
        if (jogadaComputador01 === Opcoes.TESOURA && jogadaComputador02 === Opcoes.PAPEL) {
            resposta = "VOCÊ PERDEU - COMPUTADOR 01 VENCEU"
        }
        if (jogadaComputador01 === Opcoes.TESOURA && jogadaComputador02 === Opcoes.TESOURA) {
            resposta = "VOCÊ PERDEU - COMPUTADOR 01 E COMPUTADOR 02 EMPATARAM"
        }
        return resposta
    }

    /**
     * Calcula se a condição do jogador for PAPEL (Jogo com 2 Jogadores)
     */
    fun calculoCondicaoPapelDoisJogadores(jogadaComputador01: Opcoes): String {
        var resposta = ""
        if (jogadaComputador01 === Opcoes.PEDRA) {
            resposta = "VOCÊ VENCEU"
        }
        if (jogadaComputador01 === Opcoes.PAPEL) {
            resposta = "EMPATE"
        }
        if (jogadaComputador01 === Opcoes.TESOURA) {
            resposta = "VOCÊ PERDEU"
        }
        return resposta
    }

}