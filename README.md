# Estudo Spring — API Voll.med

Projeto de estudo do curso de **Spring Boot da Alura**, construindo a API REST da clínica fictícia **Voll.med** para praticar os fundamentos de desenvolvimento backend com Java e Spring.

## O que foi criado

- **CRUD de Médicos** (`/medicos`): cadastro, listagem paginada e ordenada por nome, atualização e exclusão lógica (campo `ativo`)
- **CRUD de Pacientes** (`/pacientes`): mesmas operações, seguindo o mesmo padrão
- **DTOs com Java Records** para entrada e saída de dados (`DadosCadastroMedico`, `DadosListagemMedico`, `DadosAtualizarMedico` etc.)
- **Validações com Bean Validation** (`@Valid`, `@NotBlank`, `@Pattern`...) nos dados recebidos pela API
- **Persistência com Spring Data JPA** e MySQL, com entidades `Medico`, `Paciente` e `Endereco` (embutido)
- **Migrations versionadas com Flyway** (`src/main/resources/db/migration`) evoluindo o schema passo a passo
- **Lombok** para reduzir boilerplate nas entidades

## Tecnologias

- Java 17
- Spring Boot (Web MVC, Data JPA, Validation)
- MySQL + Flyway
- Lombok
- Maven

## Como rodar

1. Suba um MySQL local e crie o banco `vollmed_api`
2. Ajuste usuário e senha em `src/main/resources/application.properties` se necessário
3. Execute:

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.
