class Taxonomia(
    val reino: String,
    val filo: String,
    val classe: String,
    val ordem: String,
    val familia: String,
    val genero: String,
    val especie: String
) {
    override fun toString(): String {
        return "$reino > $filo > $classe > $ordem > $familia > $genero > $especie"
    }
}

class Animal(
    val apelido: String,
    val origem: String,
    val dieta: String,
    val tipoGaiola: String,
    val localizacao: String,
    val taxonomia: Taxonomia
) {
    override fun toString(): String {
        return """
            Apelido: $apelido
            Origem: $origem
            Dieta: $dieta
            Tipo da Gaiola: $tipoGaiola
            Localização: $localizacao
            Taxonomia: $taxonomia
        """.trimIndent()
    }
}

class Zoologico {
    private val animais = mutableListOf<Animal>()

    fun cadastrarAnimal(animal: Animal) {
        animais.add(animal)
    }

    fun listarAnimais() {
        if (animais.isEmpty()) {
            println("Nenhum animal cadastrado no zoológico.")
        } else {
            animais.forEach { animal ->
                println(animal)
                println("-------------")
            }
        }
    }
}

class ZoologicoApp {
    private val zoologico = Zoologico()

    fun iniciar() {
        while (true) {
            exibirMenu()
            val opcao = lerEntrada("Escolha uma opção").toIntOrNull()
            
            when (opcao) {
                1 -> cadastrarNovoAnimal()
                2 -> listarAnimais()
                3 -> {
                    println("Saindo do sistema.")
                    break
                }
                else -> println("Opção inválida. Tente novamente.")
            }
        }
    }

    private fun exibirMenu() {
        println("\n--- Menu do Zoológico ---")
        println("1 - Cadastrar novo animal")
        println("2 - Listar animais cadastrados")
        println("3 - Sair")
    }

    private fun cadastrarNovoAnimal() {
        println("\n--- Cadastro de Animal ---")

        val apelido = lerEntrada("Apelido")
        val origem = lerEntrada("Origem")
        val dieta = lerEntrada("Dieta")
        val tipoGaiola = lerEntrada("Tipo da Gaiola")
        val localizacao = lerEntrada("Localização")

        val reino = lerEntrada("Reino")
        val filo = lerEntrada("Filo")
        val classe = lerEntrada("Classe")
        val ordem = lerEntrada("Ordem")
        val familia = lerEntrada("Família")
        val genero = lerEntrada("Gênero")
        val especie = lerEntrada("Espécie")

        val taxonomia = Taxonomia(reino, filo, classe, ordem, familia, genero, especie)
        val animal = Animal(apelido, origem, dieta, tipoGaiola, localizacao, taxonomia)

        zoologico.cadastrarAnimal(animal)

        println("Animal cadastrado com sucesso!")
    }

    private fun listarAnimais() {
        println("\n--- Lista de Animais ---")
        zoologico.listarAnimais()
    }

    private fun lerEntrada(mensagem: String): String {
        print("$mensagem: ")
        return readLine() ?: ""
    }
}

fun main() {
    val app = ZoologicoApp()
    app.iniciar()  
}