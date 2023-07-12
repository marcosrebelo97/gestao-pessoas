<h2 align="center"> Sistema de Gerenciamento de Pessoas </h2> <br/>

  - O projeto consiste no desenvolvimento de uma API REST para um sistema de gestão de dados pessoais e residenciais. A aplicação permite a interação com usuários através das funcionalidades de cadastro, atualização de informações e buscas específicas. 
   
  - ### Modelo Conceitual:

      ![image](https://github.com/marcosrebelo97/gestao-pessoas/assets/37541973/a8ba640d-9550-46a6-94b6-8ebd6e17b958)
 
  - ### Postman Collection:

      [![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/19986209-c20edb2e-1be0-4059-a4e2-36cca29e80c7?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D19986209-c20edb2e-1be0-4059-a4e2-36cca29e80c7%26entityType%3Dcollection%26workspaceId%3Df3ebd102-7eba-4911-8348-205a6bbb21c6)

  - ### Endpoints RESTs API:
    | Rest  | Request         | Funcionalidade |
    |-------|-----------------| ------- |
    | GET   | Listar Pessoas  | Retorna a lista completa de pessoas cadastradas |
    | GET   | Buscar Pessoa por ID | Retorna dados de uma pessoa específica com base no seu ID |
    | GET   | Buscar Pessoa e seus Endereços | Retorna dados de uma pessoa e os endereços vínculados ao seu ID |
    | POST  | Cadastrar Pessoa | Realiza o cadastro dos dados de uma pessoa |
    | POST  | Cadastrar Endereço | Realiza o cadastro dos dados de um endereço |
    | PUT   | Editar Pessoa | Efetua alteração dos dados de uma pessoa |
    | GET   | Endereço Principal | Retorna o endereço principal de uma pessoa |

  ## Tecnologias | Implantação em produção
  - Java (JDK 17)
  - Spring Boot
  - Spring Data JPA
  - Spring Boot Web
  - Maven
  - H2 Database
  - PostgreSQL
  - ORM
