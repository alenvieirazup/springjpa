package br.com.zup.springdata.service;

import br.com.zup.springdata.orm.UnidadeTrabalho;
import br.com.zup.springdata.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private Boolean system = true;
    private final UnidadeTrabalhoRepository UnidadeTrabalhoRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository UnidadeTrabalhoRepository) {
        this.UnidadeTrabalhoRepository = UnidadeTrabalhoRepository;
    }

    public void inicial(Scanner scanner) {
        while(system){
            System.out.println("Qual acao de Unidade de Trabalho deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int acao = scanner.nextInt();

            switch (acao){
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 3 -> visualizar();
                case 4 -> deletar(scanner);
                default -> system = false;
            }
        }
        system = true;
    }

    private void salvar(Scanner scanner) {
        System.out.println("Digite o nome da Unidade de Trabalho");
        String nome = scanner.next();
        System.out.println("Digite o endereco da Unidade de Trabalho");
        String endereco = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setNome(nome);
        unidadeTrabalho.setEndereco(endereco);
        UnidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Digite o nome da Unidade de Trabalho");
        String nome = scanner.next();
        System.out.println("Digite o endereco da Unidade de Trabalho");
        String endereco = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setNome(nome);
        unidadeTrabalho.setEndereco(endereco);
        UnidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Atualizado");
    }

    private void visualizar() {
        Iterable<UnidadeTrabalho> unidadesTrabalho = UnidadeTrabalhoRepository.findAll();
        unidadesTrabalho.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        UnidadeTrabalhoRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
