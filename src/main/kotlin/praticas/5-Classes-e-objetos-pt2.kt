open class Funcionario(var nome: String, var idade:Int){
    init {
        println("${nome} foi registrado com sucesso, sua idade é ${idade}")
    }

    fun apresentar(){
        println("Olá, sou ${nome} e tenho ${idade} anos.")
    }

}

class Gerente(nome: String, idade:Int, var setor: String): Funcionario(nome,idade)
class Desenvolvedor(nome: String, idade:Int, var linguagem: String): Funcionario(nome,idade)
class Analista(nome: String, idade:Int,var area: String): Funcionario(nome,idade)

fun main(){
    val listaFuncionarios: List<Funcionario> = listOf(
        Gerente("Paula",35,"Desenvolvimento"),
        Desenvolvedor("Amanda",28,"Java"),
        Desenvolvedor("Luana",25,"Kotlin"),
        Analista("João",31,"Finanças")
    )

    println()

    listaFuncionarios.forEach{
        if(it is Gerente){
            println("Gerente é ${it.nome}, do setor ${it.setor}.")
            it.apresentar()
        } else if(it is Desenvolvedor){
            println("Desenvolvedor é ${it.nome} e trabalha com ${it.linguagem}.")
            it.apresentar()
        } else if(it is Analista){
            println("Analista é ${it.nome} e é da área de ${it.area}.")
            it.apresentar()
        }
    }

}


/** SISTEMA DE REGISTROS DE FUNCIONÁRIOS
 *
 * Desenvolva um sistema de registro de funcionários para uma empresa.
 * O sistema deverá permitir registrar diferentes tipos de funcionários e apresentar suas informações.
 *
 * Alguns passos abaixo:
 *
 * 1.Crie uma classe base chamada Funcionario com as seguintes propriedades:
 * - Nome (string): o nome do funcionário.
 * - Idade (int): a idade do funcionário.
 *
 * 2.Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Setor (string): o setor em que o gerente trabalha.
 *
 * 3.Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
 *
 * 4.Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Area (string): a área de especialização do analista.
 *
 * 5.Imprima uma mensagem informando que um novo funcionário foi registrado, juntamente com o nome e a idade do
 * funcionário. (Lembre-se do init)
 *
 * 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
 * incluindo o nome e a idade.
 *
 * 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
 * à lista.
 *
 * 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
 * correspondente.
 */