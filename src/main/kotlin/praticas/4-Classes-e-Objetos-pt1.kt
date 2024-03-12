
// Questão 1
class Produto {
    var nome: String
    var preco: Double

    // Implemente os construtores conforme especificado na questão
    constructor() {
        this.nome = "Produto"
        this.preco = 0.0
    }

    constructor(nome: String) {
        this.nome = nome
        this.preco = 0.0
    }

    constructor(nome: String, preco: Double) {
        this.nome = nome
        this.preco = preco
    }
}


// Questão 2
class Cliente {
    var nome: String = ""
    private var idade: Int = 0

    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão
    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    fun mostrarIdade():Int{
        return idade
    }
}


// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    abstract fun atacar()
}

class Guerreiro : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Guerreiro
        println("O guerreiro está atacando com escudo e espada")
    }
}

class Mago : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Mago
        println("O mago está atacando com magia")
    }
}


// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    abstract fun CalcularArea():Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun CalcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
        return (altura * largura)
    }

}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun CalcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
        return (3.14*raio*raio)
    }
}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    var nomeTitular: String = ""
    var saldo: Double = 0.0
        set(value) {
            if(value < 0){
                field = 0.0
            } else {
                field = value
            }
        }
}
fun main() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    var prod1 = Produto()
    var prod2 = Produto("Vaso")
    var prod3 = Produto("Sofa", 2500.00)

    println("O produto é ${prod1.nome} e custa ${prod1.preco}")
    println("O produto é ${prod2.nome} e custa ${prod2.preco}")
    println("O produto é ${prod3.nome} e custa ${prod3.preco}")

    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    var cliente = Cliente()
    cliente.nome = "amanda"

    println(cliente.mostrarIdade())

    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    var mago = Mago()
    var guerreiro = Guerreiro()

    mago.atacar()
    guerreiro.atacar()

    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    var ret1 = Retangulo(2.0,6.0)
    println(ret1.CalcularArea())
    var cir1 = Circulo(5.0)
    println(cir1.CalcularArea())

    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    var contaBancaria = ContaBancaria()
    contaBancaria.nomeTitular = "amanda"
    contaBancaria.numeroConta = "1265465"
    contaBancaria.saldo = 845212.0

    println("Nome do titula = ${contaBancaria.nomeTitular} e o saldo é de ${contaBancaria.saldo}")
}
