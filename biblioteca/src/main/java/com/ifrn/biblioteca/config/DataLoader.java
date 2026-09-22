package com.ifrn.biblioteca.config;

import com.ifrn.biblioteca.model.*;
import com.ifrn.biblioteca.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmprestimoRepository emprestimoRepository;
    private final ItemEmprestimoRepository itemEmprestimoRepository;

    public DataLoader(
            CategoriaRepository categoriaRepository,
            AutorRepository autorRepository,
            LivroRepository livroRepository,
            UsuarioRepository usuarioRepository,
            EmprestimoRepository emprestimoRepository,
            ItemEmprestimoRepository itemEmprestimoRepository
    ) {
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.itemEmprestimoRepository = itemEmprestimoRepository;
    }

    @Override
    public void run(String... args) {

        // =========================
        // CATEGORIAS
        // =========================

        Categoria tecnologia = new Categoria();
        tecnologia.setNome("Tecnologia");
        tecnologia.setDescricao("Livros de programação e tecnologia");

        Categoria literatura = new Categoria();
        literatura.setNome("Literatura");
        literatura.setDescricao("Livros de literatura");

        categoriaRepository.saveAll(
                List.of(tecnologia, literatura)
        );


        // =========================
        // AUTORES
        // =========================

        Autor herbert = new Autor();
        herbert.setNome("Herbert Schildt");
        herbert.setNacionalidade("Americano");

        Autor robert = new Autor();
        robert.setNome("Robert C. Martin");
        robert.setNacionalidade("Americano");

        Autor machado = new Autor();
        machado.setNome("Machado de Assis");
        machado.setNacionalidade("Brasileiro");

        autorRepository.saveAll(
                List.of(herbert, robert, machado)
        );


        // =========================
        // LIVROS
        // =========================

        Livro java = new Livro();
        java.setIsbn("9780135166307");
        java.setTitulo("Java: The Complete Reference");
        java.setEditora("McGraw-Hill");
        java.setAnoPublicacao(2019);
        java.setNumeroPaginas(1248);
        java.setQuantidadeTotal(5);
        java.setQuantidadeDisponivel(3);
        java.setCategoria(tecnologia);
        java.setAutores(List.of(herbert));

        Livro cleanCode = new Livro();
        cleanCode.setIsbn("9780132350884");
        cleanCode.setTitulo("Clean Code");
        cleanCode.setEditora("Prentice Hall");
        cleanCode.setAnoPublicacao(2008);
        cleanCode.setNumeroPaginas(464);
        cleanCode.setQuantidadeTotal(4);
        cleanCode.setQuantidadeDisponivel(2);
        cleanCode.setCategoria(tecnologia);
        cleanCode.setAutores(List.of(robert));

        Livro domCasmurro = new Livro();
        domCasmurro.setIsbn("9788535910660");
        domCasmurro.setTitulo("Dom Casmurro");
        domCasmurro.setEditora("Companhia das Letras");
        domCasmurro.setAnoPublicacao(1899);
        domCasmurro.setNumeroPaginas(256);
        domCasmurro.setQuantidadeTotal(3);
        domCasmurro.setQuantidadeDisponivel(0);
        domCasmurro.setCategoria(literatura);
        domCasmurro.setAutores(List.of(machado));

        livroRepository.saveAll(
                List.of(java, cleanCode, domCasmurro)
        );


        // =========================
        // USUÁRIOS
        // =========================

        Usuario joao = new Usuario();
        joao.setNome("João Silva");
        joao.setCpf("11111111111");
        joao.setEmail("joao@email.com");
        joao.setTelefone("84999999999");
        joao.setDataCadastro(LocalDate.now());
        joao.setEndereco("Rua A");
        joao.setAtivo(true);

        Usuario maria = new Usuario();
        maria.setNome("Maria Silva");
        maria.setCpf("22222222222");
        maria.setEmail("maria@email.com");
        maria.setTelefone("84888888888");
        maria.setDataCadastro(LocalDate.now());
        maria.setEndereco("Rua B");
        maria.setAtivo(true);

        usuarioRepository.saveAll(
                List.of(joao, maria)
        );


        // =========================
        // EMPRÉSTIMO ATIVO
        // =========================

        Emprestimo emprestimoJoao = new Emprestimo();

        emprestimoJoao.setUsuario(joao);
        emprestimoJoao.setDataEmprestimo(
                LocalDate.now().minusDays(2)
        );
        emprestimoJoao.setDataDevolucaoPrevista(
                LocalDate.now().plusDays(5)
        );
        emprestimoJoao.setStatus(StatusEmprestimo.ATIVO);
        emprestimoJoao.setValorMulta(BigDecimal.ZERO);

        emprestimoRepository.save(emprestimoJoao);


        ItemEmprestimo itemJoao = new ItemEmprestimo();

        itemJoao.setEmprestimo(emprestimoJoao);
        itemJoao.setLivro(java);

        itemEmprestimoRepository.save(itemJoao);


        // =========================
        // EMPRÉSTIMO ATRASADO
        // =========================

        Emprestimo emprestimoMaria = new Emprestimo();

        emprestimoMaria.setUsuario(maria);
        emprestimoMaria.setDataEmprestimo(
                LocalDate.now().minusDays(15)
        );
        emprestimoMaria.setDataDevolucaoPrevista(
                LocalDate.now().minusDays(5)
        );
        emprestimoMaria.setStatus(StatusEmprestimo.ATIVO);
        emprestimoMaria.setValorMulta(BigDecimal.ZERO);

        emprestimoRepository.save(emprestimoMaria);


        ItemEmprestimo itemMaria = new ItemEmprestimo();

        itemMaria.setEmprestimo(emprestimoMaria);
        itemMaria.setLivro(cleanCode);

        itemEmprestimoRepository.save(itemMaria);


        System.out.println("Dados de teste inseridos com sucesso!");
    }
}