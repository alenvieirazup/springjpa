package br.com.zup.springdata;

import br.com.zup.springdata.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

    private final CrudCargoService crudCargoService;
    private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;
    private final CrudFuncionarioService crudFuncionarioService;
    private final RelatoriosService relatoriosService;
    private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

    private Boolean system = true;

    public SpringdataApplication(CrudCargoService crudCargoService,
                                 CrudUnidadeTrabalhoService crudUnidadeTrabalhoService,
                                 CrudFuncionarioService crudFuncionarioService,
                                 RelatoriosService relatoriosService,
                                 RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
        this.crudCargoService = crudCargoService;
        this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
        this.crudFuncionarioService = crudFuncionarioService;
        this.relatoriosService = relatoriosService;
        this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
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
            System.out.println("4 - Relatorios");
            System.out.println("5 - Relatorio dinamico");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> crudCargoService.inicial(scanner);
                case 2 -> crudUnidadeTrabalhoService.inicial(scanner);
                case 3 -> crudFuncionarioService.inicial(scanner);
                case 4 -> relatoriosService.inicial(scanner);
                case 5 -> relatorioFuncionarioDinamico.inicial(scanner);
                default -> system = false;
            }
        }
    }

}
