package br.com.zup.springdata;

import br.com.zup.springdata.service.CrudCargoService;
import br.com.zup.springdata.service.CrudFuncionarioService;
import br.com.zup.springdata.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

    private final CrudCargoService crudCargoService;
    private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;
    private final CrudFuncionarioService crudFuncionarioService;

    private Boolean system = true;

    public SpringdataApplication(CrudCargoService crudCargoService, CrudUnidadeTrabalhoService crudUnidadeTrabalhoService, CrudFuncionarioService crudFuncionarioService) {
        this.crudCargoService = crudCargoService;
        this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
        this.crudFuncionarioService = crudFuncionarioService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        while (system) {
            System.out.println("Qual a acao voce quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Unidade de Trabalho");
            System.out.println("3 - Funcionario");
            int opcao = scanner.nextInt();
            System.out.println(opcao);
            switch (opcao) {
                case 1 -> crudCargoService.inicial(scanner);
                case 2 -> crudUnidadeTrabalhoService.inicial(scanner);
                case 3 -> crudFuncionarioService.inicial(scanner);
                default -> system = false;
            }
        }
    }

}
