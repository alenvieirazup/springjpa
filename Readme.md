# Spring Data JPA

Projeto para assimilar o conteúdo do curso [Spring Data JPA: Repositórios, Consultas, Projeções e Specifications](https://cursos.alura.com.br/course/spring-data-jpa).

## Tecnologias utilizadas:
- Java 17
- Maven
- MariaDB
- Spring Data JPA
## Rodando o projeto através de containers:
```bash
# Contruindo uma imagem da aplicação java
$ docker build -t alenvieirazup/springjpa .
# Exportando variaveis de ambiente
$ export MYSQL_ROOT_PASSWORD=CHANGEME
$ export MYSQL_DATABASE=CHANGEME 
$ export MYSQL_USER=CHANGEME 
$ export MYSQL_PASSWORD=CHANGEME
# Executando o projeto coordenando os containers
$ docker-compose run springjpa
```