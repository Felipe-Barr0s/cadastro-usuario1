#  Cadastro de Usuários – API Backend (Java + Spring Boot)

Este projeto é uma API REST desenvolvida em **Java** utilizando **Spring Boot**, com o objetivo de fornecer funcionalidades completas de gerenciamento de usuários.  
A aplicação implementa operações de criação, consulta, atualização e remoção de usuários, seguindo boas práticas de arquitetura e utilizando banco de dados **H2 em memória** para facilitar testes e desenvolvimento.

---

##  Funcionalidades Principais

A API permite realizar operações básicas de CRUD (Create, Read, Update, Delete) sobre usuários:

- **Criar usuário**
- **Buscar usuário por e-mail**
- **Atualizar usuário pelo ID**
- **Excluir usuário por e-mail**

Essas operações são expostas através da camada controller e tratadas pela camada de serviço, que utiliza o repositório JPA para persistência dos dados.

---

##  Arquitetura do Projeto

O projeto segue uma estrutura limpa, dividida em camadas:

### **Controller**
Responsável por receber e responder requisições HTTP.

Endpoints disponíveis:

- **POST** `/usuario` – cria um novo usuário
- **GET** `/usuario?email=` – busca usuário por e-mail
- **DELETE** `/usuario?email=` – remove usuário por e-mail
- **PUT** `/usuario?id=` – atualiza usuário pelo ID

### **Service**
Contém as regras de negócio e faz a mediação entre controller e repository.

Funções principais:
- Salvar usuários
- Buscar usuários por e-mail
- Deletar usuários por e-mail
- Atualizar dados de um usuário existente

### **Repository**
Interface responsável pela comunicação com o banco utilizando Spring Data JPA.

Métodos:
- `findByEmail`
- `deleteByEmail`
- Métodos herdados de `JpaRepository`

---

##  Banco de Dados

A aplicação utiliza o **H2 Database (in-memory)** para facilitar o desenvolvimento.

Configurações principais:

- URL: `jdbc:h2:mem:usuarios`
- Console H2: `/h2-console`
- Usuário: `felipe`
- Senha: `1234`

---

## Como Executar

### **Pré-requisitos**
- Java **17+**
- Maven ou IDE de sua preferência

### **Executando o projeto**

```bash
mvn spring-boot:run
