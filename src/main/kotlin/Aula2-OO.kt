package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 6) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {
            1 -> {
                println("Digite o nome do cachorro: ")
                val nomeAnimal = readLine()!!
                println("Digite a idade do cachorro: ")
                val idadeAnimal = readLine()?.toIntOrNull() ?: 0
                println("Digite a cor do cachorro: ")
                val corAnimal = readLine()!!

                val cachorro = Cachorro(idadeAnimal, corAnimal)
                cachorro.nome = nomeAnimal
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                println("Digite o nome do gato: ")
                val nomeAnimal = readLine()!!
                println("Digite a idade do gato: ")
                val idadeAnimal = readLine()?.toIntOrNull() ?: 0
                println("Digite a cor do gato: ")
                val corAnimal = readLine()!!

                val gato = Gato(idadeAnimal, corAnimal)
                gato.nome = nomeAnimal
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                println("Digite o nome do passaro: ")
                val nomeAnimal = readLine()!!
                println("Digite a idade do passaro: ")
                val idadeAnimal = readLine()?.toIntOrNull() ?: 0
                println("Digite a cor do passaro: ")
                val corAnimal = readLine()!!

                val passaro = Passaro(idadeAnimal, corAnimal)
                passaro.nome = nomeAnimal
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                println("Digite o nome do homem: ")
                val nomeAnimal = readLine()!!
                println("Digite a idade do homem: ")
                val idadeAnimal = readLine()?.toIntOrNull() ?: 0
                println("Digite a cor do homem: ")
                val corAnimal = readLine()!!

                val homem = Passaro(idadeAnimal, corAnimal)
                homem.nome = nomeAnimal
                repositorioAnimal.adicionar(homem)
            }
            5 -> {
                repositorioAnimal.listar()
            }
            6 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            7 -> {
                print("Digite o nome do animal a ser deletado:")
                var animalDeletar = readLine()
                repositorioAnimal.removerAnimal(animalDeletar)
            }
            8 -> {
                print("Digite a cor que deseja filtrar:")
                var corFiltro = readLine()
                repositorioAnimal.listarCor(corFiltro)
            }
            9 -> {
                print("Digite a idade que deseja filtrar:")
                var idadeFiltro = readlnOrNull()?.toInt()
                repositorioAnimal.listarIdade(idadeFiltro)
            }
            10 -> {
                print("Digite o nome do animal que deseja buscar:")
                var nomeFiltro = readLine()
                repositorioAnimal.buscarAnimalPorNome(nomeFiltro)
            }

        }

    }
}

abstract class Animal(var idade: Int, var cor: String) {
    enum class Cores{
        Amarelo, Marrom, Vermelho
    }
    open var nome: String = ""
        get() = "Animal: $field"
        set(valor) {
            field = valor
        }

    abstract fun emitirSom()

    open fun idadeEmAnosHumanos(): Int {
        return (idade * 7)
    }
}

class Cachorro(idade: Int, cor: String) : Animal(idade, cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int, cor: String) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int, cor: String) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}

class Homem(idade: Int, cor: String): Animal(idade, cor){
    override fun emitirSom() {
        println("Olá")
    }

    override fun idadeEmAnosHumanos(): Int {
        return super.idadeEmAnosHumanos()/7
    }

}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Homem")
    println("5 - Listar Animais")
    println("6 - Emitir som")
    println("7 - Deletar Animal")
    println("8 - Listar por Cor")
    println("9 - Listar por Idade")
    println("10 - Buscar por Nome")
    println("11 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun  removerAnimal(nomeDeletar: String?){
        var animalRemover = animais.find { it.nome == nomeDeletar }

        if(animalRemover != null){
            animais.remove(animalRemover)
            println("Animal $nomeDeletar removido com sucesso")
        } else {
            println("Animal não encontrado")
        }
    }

    fun listar() {
        animais.forEach { println("${it.nome}, ${it.idade}, ${it.cor}")}
    }

    fun buscarAnimalPorNome(nomeBusca: String?): Animal?{
        return animais.find { it.nome == nomeBusca }
    }

    fun listarCor(cor: String?){
        val animaisPorCor = animais.filter { it.cor == cor }
        if (animaisPorCor.isEmpty()){
            println("Nenhum animal na cor ${cor}")
        }else{
            animaisPorCor.forEach{
                println("${it.nome}, ${it.idade}, ${it.cor}")
            }
        }
    }

    fun listarIdade(idade: Int?){
        val animaisPorIdade = animais.filter { it.idade == idade }
        if (animaisPorIdade.isEmpty()){
            println("Nenhum animal na idade ${idade}")
        }else{
            animaisPorIdade.forEach{
                println("${it.nome}, ${it.idade}, ${it.cor}")
            }
        }
    }

}

