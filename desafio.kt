// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel(val descricao: String) {
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado")
}

data class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun cargaHorariaTotal(): Int {
        var total = 0
        for (conteudo in conteudos) {
        	total += conteudo.duracao
        }
        return total
    }
    
    fun listarAlunosMatriculados() {
        println("=".repeat(80))
        println("Curso: $nome")
        val cargaHoraria = cargaHorariaTotal()
        println("Carga horária total: $cargaHoraria hora(s)")
        println("Nível: ${nivel.descricao}")
        println("=".repeat(80))
        println("Conteúdo Educacional:")
        println("")
        conteudos.forEach { conteudo -> println("Nome: ${conteudo.nome} / Duração: ${conteudo.duracao} hora(s)") }
        println("=".repeat(80))
        println("Inscritos:")
        println("")
        inscritos.forEach { aluno -> println("Nome: ${aluno.nome} / Idade: ${aluno.idade}") }
        println("=".repeat(80))
        println("")
    }
}

fun cadastroDeAluno(nome: String, idade: Int): Usuario {
    return Usuario(nome, idade)
}

fun main() {
    val conteudoKotlin11 = ConteudoEducacional("Kotlin - Primeiros Passos 1", 20)
    val conteudoKotlin12 = ConteudoEducacional("Kotlin - Primeiros Passos 2", 20)
    val conteudoKotlin21 = ConteudoEducacional("Kotlin - Intermediário 1", 20)
    val conteudoKotlin22 = ConteudoEducacional("Kotlin - Intermediário 2", 20)
    val conteudoKotlin31 = ConteudoEducacional("Kotlin - Avançado 1", 20)
    val conteudoKotlin32 = ConteudoEducacional("Kotlin - Avançado 2", 20)
    
    val listaConteudoKotlin1: List<ConteudoEducacional> = listOf(conteudoKotlin11, conteudoKotlin12)
    val listaConteudoKotlin2: List<ConteudoEducacional> = listOf(conteudoKotlin21, conteudoKotlin22)
    val listaConteudoKotlin3: List<ConteudoEducacional> = listOf(conteudoKotlin31, conteudoKotlin32)
    
    val formacaoKotlin1 = Formacao("Kotlin Iniciante", Nivel.BASICO, listaConteudoKotlin1)
    val formacaoKotlin2 = Formacao("Kotlin Intermediário", Nivel.INTERMEDIARIO, listaConteudoKotlin2)
    val formacaoKotlin3 = Formacao("Kotlin Avançado", Nivel.AVANCADO, listaConteudoKotlin3)
    
    formacaoKotlin1.matricular(cadastroDeAluno("Usuario1", 17))
    formacaoKotlin1.matricular(cadastroDeAluno("Usuario2", 21))
    
    formacaoKotlin2.matricular(cadastroDeAluno("Usuario3", 25))
    formacaoKotlin2.matricular(cadastroDeAluno("Usuario4", 28))
    
    formacaoKotlin3.matricular(cadastroDeAluno("Usuario5", 43))
    formacaoKotlin3.matricular(cadastroDeAluno("Usuario6", 58))
    
    formacaoKotlin1.listarAlunosMatriculados()
    formacaoKotlin2.listarAlunosMatriculados()
    formacaoKotlin3.listarAlunosMatriculados()
}
