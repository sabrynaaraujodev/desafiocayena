<h1 align="center"> Dasafio Cayena 🌶️ : APIs para cadastro de produtos </h1>


# :hammer: Funcionalidades do projeto

- `Funcionalidade 1`: API para listar, cadastrar, deletar e atualizar produtos (C.R.U.D)

# 📁 Acesso ao projeto

**git clone {URL}**

# 🛠️ Abrir e rodar o projeto

- Para rodar este microserviço se faz necessário ter em sua máquina o MYSql instalado.
- criar o esquema no mysql 
  -     CREATE SCHEMA desafio;
- As configurações de BD estão em dois pontos do projeto 
  - resouces/properties e pom (plugin do flywaydb)
    - se as informações locais forem diferentes é necessario ajustar
      - jdbc:mysql://localhost:3306/desafio
      - username e password
  
- As tabelas fornecedores e produtos são criados através das migrations quando a aplicação é iniciada.
- Executar no terminal o comando "mvn clean install" para instalar e atualizar as dependencias
- Startar o projeto
- Testar chamadas das APIs pelo postman
  - No projeto foi inserido uma collection para ser importada (collection_postman)

# ✔ Técnologias utilizadas

- Java 11
- InteliJ IDEA
- Banco MYSQL
