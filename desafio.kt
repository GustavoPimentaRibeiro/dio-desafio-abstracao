enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(usuario: Aluno) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    var i: Int = 0;
    val formacoes: MutableList<Formacao> = mutableListOf(
        Formacao("Iniciantes", Nivel.BASICO, mutableListOf(
            ConteudoEducacional("Kotlin inicial"),
            ConteudoEducacional("Variáveis Kotlin"),
            ConteudoEducacional("Atribuições Kotlin")
        )),
        Formacao("Carreira Média", Nivel.INTERMEDIARIO, mutableListOf(
            ConteudoEducacional("Kotlin intermediário"),
            ConteudoEducacional("Classes Mutáveis Kotlin"),
            ConteudoEducacional("Tratamento de Exceções Kotlin")
        )),
        Formacao("Avançados", Nivel.DIFICIL, mutableListOf(
            ConteudoEducacional("Kotlin avançado"),
            ConteudoEducacional("Construindo API RESTful"),
            ConteudoEducacional("Construindo uma Aplicação Mobile Completa")
        )),
    )

    println("\nFormacoes:")
    for (formacao in formacoes) {
        when(i) {
            0 -> formacao.matricular(Aluno("Gustavo")).also { formacao.matricular(Aluno("Ana Clara")) }
            1 -> formacao.matricular(Aluno("Gustavo")).also { formacao.matricular(Aluno("Benedito")) }
            2 -> formacao.matricular(Aluno("Gustavo").also { formacao.matricular(Aluno("Soraya")) })
        }
        print("\tNome: ${formacao.nome}\tNivel: ${formacao.nivel}\tInscritos: ")
        for (aluno in formacao.inscritos) {
            print("${aluno.nome} | ")
        }
        print("\n\t\tConteúdos:\n")
        for (conteudo in formacao.conteudos) {
            println("\t\t\tNome: ${conteudo.nome} | Duração: ${conteudo.duracao} minutos")
        }
        println("-------------------------------------------------------------------------------------")
        i++
    }
}
