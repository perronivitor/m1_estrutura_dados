import java.util.*

/**
 * Tamanho Máximo para a pilha.
 */
const val TAM = 26
const val OURO = "O"
const val ESPADA = "E"
const val COPAS = "C"
const val PAUS = "P"

val valores = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "D", "J", "Q", "K")
val naipes = listOf(OURO, ESPADA, COPAS, PAUS)

fun criarCartas(): List<Carta> {
    val baralho = mutableListOf<Carta>()
    for (valor in valores) {
        for (naipe in naipes) {
            val carta = Carta(valor, naipe)
            baralho.add(carta)
        }
    }
    return baralho
}

/**
 * Função retorna True,se pilha for vazia.
 */
fun vazia(p: Pilha) = p.topo == -1

/**
 * Função retorna True,se pilha estiver cheia
 */
fun cheia(p: Pilha) = p.topo == TAM

/**
 * Retorna String contendo msg de sucesso ou falha.
 */
fun inserir(p: Pilha, valor: String, naipe: String) =
    if (cheia(p)) {
        println("Falha ao inserir,pilha já está cheia")
        false
    } else {
        p.topo += 1 //Acrescento um ao topo
        p.cartas[p.topo].valor = valor
        p.cartas[p.topo].naipe = naipe
        println("Inserido [$valor|$naipe]")
        true
    }

/**
 * Retira carda informada e retorna a própria carta para ser realocado.
 */
fun retirar(p: Pilha): Carta? {
    return if (vazia(p)) {
        println("Falha ao retirar, pilha vazia!!")
        null //Retorno
    } else {
        val carta = Carta()
        carta.valor = p.cartas[p.topo].valor
        carta.valor = p.cartas[p.topo].valor
        println("Retirado [${carta.valor}|${carta.naipe}]!!")
        carta //Retorno
    }
}

fun inserirCrescente(p: Pilha, cartaNova: Carta) {
    val cartaRetirada = retirar(p) ?: return//Se retornar uma carta adiciona a váriável,se não sai da função
    if (cartaNova.valor > cartaRetirada.valor
        && verificaPesoNaipe(cartaNova.naipe) > verificaPesoNaipe(cartaRetirada.naipe)
    ) {
        inserir(p, cartaRetirada.valor, cartaRetirada.naipe)
        inserir(p, cartaNova.valor, cartaNova.naipe)
    } else {
        inserir(p, cartaRetirada.valor, cartaRetirada.naipe)
        println("Não pode inserir")
    }
}

/**
 * Função responsável por dar um peso para auxiliar na hora do calculo para os valores de cartas
 * que são expressos por letras.
 */
fun verificaPesoValorEspecificos(valor: String): Int {
    //Tipo Switch-Case do Java , ele retornara o valor de onde ele entrar
    return when (valor) {
        "A" -> 1
        "2" -> 2
        "3" -> 3
        "4" -> 4
        "5" -> 5
        "6" -> 6
        "7" -> 7
        "8" -> 8
        "9" -> 9
        "D" -> 10
        "J" -> 11
        "Q" -> 12
        else -> 13
    }
}

fun verificaPesoNaipe(naipe: String): Int {
    //Tipo Switch Case do Java , ele retornara o valor de onde ele entrar
    return when (naipe) {
        OURO -> 1
        ESPADA -> 2
        COPAS -> 3
        PAUS -> 4
        else -> -1
    }
}

/**
 * Retorna 1 se corresponder aos naipes de OURO E COPAS -> VERMELHO,
 * 2 se for ESPADAS ou PAUS ->PRETOS.
 */
fun verificaCorNaipe(naipe: String) = if (naipe == OURO || naipe == COPAS) 1 else 2


fun inserirOrdemDecrescenteNaipeDif(p: Pilha, cartaNova: Carta) {
    val cartaRetirada = retirar(p) ?: return//Se retornar uma carta adiciona a váriável,se não sai da função
    //Verifico se carta nova é menos carta que já estava na pilha e se os naipes são de cores diferentes
    if (cartaNova.valor < cartaRetirada.valor
        && verificaCorNaipe(cartaNova.naipe) != verificaCorNaipe(cartaRetirada.naipe)
    ) {
        inserir(p, cartaRetirada.valor, cartaRetirada.naipe)
        inserir(p, cartaNova.valor, cartaNova.naipe)
    } else {
        inserir(p, cartaRetirada.valor, cartaRetirada.naipe)
        println("Não pode inserir")
    }
}

fun gerarQuatroPilhasCrescentesMesmoNaipe(){

}

fun gerarOitoPilhasDecrescentesNaipesDif(){

}


fun main() {

}