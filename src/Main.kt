import java.util.*

/**
 * Tamanho Máximo para a pilha.
 */
const val TAM = 26
const val NAIPES : List<String> = listOf("")
data class Pilha(
    var topo: Int = 0,
    var cartas: Vector<Carta>
)

data class Carta(var valor: String = "", var naipe: String = "")

fun criarPilha(p: Pilha) {
    p.topo = -1
}
fun criarCartas(){

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
    if (cartaNova.valor > cartaRetirada.valor) {
        inserir(p,cartaRetirada.valor,cartaRetirada.naipe)
        inserir(p, cartaNova.valor, cartaNova.naipe)
    } else {
        inserir(p,cartaRetirada.valor,cartaRetirada.naipe)
        println("Não pode inserir")
    }
}

fun main() {

}