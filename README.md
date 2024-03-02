# Projeto Blog API em Kotlin

Este é um projeto de exemplo de uma API de blog desenvolvida em Kotlin com o framework Spring Boot.


### Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e ferramentas:

 **Kotlin**: Uma linguagem de programação moderna, concisa e segura, que roda na máquina virtual Java (JVM).    
**Spring Boot**: Um framework poderoso e flexível para o desenvolvimento de aplicativos Java e Kotlin. Spring Boot simplifica a configuração e o desenvolvimento de aplicativos, oferecendo um conjunto de ferramentas e bibliotecas integradas.
**Spring Data JPA**: Parte do ecossistema Spring, Spring Data JPA oferece uma maneira simplificada de trabalhar com o banco de dados usando a JPA (Java Persistence API). Ele fornece recursos para mapeamento objeto-relacional (ORM), consultas JPQL (Java Persistence Query Language) e muito mais.
**Spring Security**: Uma estrutura de autenticação e autorização robusta para aplicativos Spring. Spring Security oferece recursos para proteger endpoints da API, gerenciar usuários e sessões, autenticar usuários com JWT (JSON Web Tokens) e muito mais.
**H2 Database**: Um banco de dados relacional leve e rápido, adequado para o desenvolvimento e teste de aplicativos. O H2 Database é integrado ao Spring Boot e pode ser usado como um banco de dados embarcado durante o desenvolvimento.
**Docker**: Uma plataforma de código aberto que simplifica o processo de desenvolvimento, implantação e execução de aplicativos em contêineres. O Docker fornece uma maneira consistente de empacotar, distribuir e executar aplicativos em diferentes ambientes.
**Maven**: Uma ferramenta de automação de compilação e gerenciamento de dependências para projetos Java e Kotlin. Maven simplifica o processo de construção, teste e empacotamento de aplicativos, gerenciando eficientemente as dependências do projeto.    

Essas tecnologias foram escolhidas pela sua robustez, comunidade ativa, facilidade de uso e integração, permitindo o desenvolvimento de aplicativos modernos e escaláveis com eficiência.

## Arquitetura

O projeto segue uma arquitetura baseada em Spring Boot, que é um framework Java popular para o desenvolvimento de aplicativos web e APIs RESTful. A arquitetura geral do projeto inclui:

-   **Controller**: Responsável por lidar com requisições HTTP, mapeando-as para métodos específicos do serviço e retornando as respostas apropriadas.
-   **Service**: Contém a lógica de negócios da aplicação, realizando operações como criação, leitura, atualização e exclusão de recursos.
-   **Repository**: Responsável por interagir com o banco de dados, realizando operações de leitura e gravação.
-   **Model**: Define as entidades do domínio, como Post, Comment, User, Category e Tag.
-   **DTO (Data Transfer Object)**: Utilizado para transferir dados entre as camadas da aplicação e para fora dela, ajudando a separar a lógica de negócios das representações dos dados.
    

## Organização do Projeto

A estrutura do projeto segue um padrão comum do Spring Boot:

```sh
└── blog-api-kotlin/
    ├── config.env.example
    ├── package-lock.json
    ├── package.json
    └── src
        ├── main
        │   ├── kotlin
        │   │   └── com
        │   │       └── kotlin
        │   │           └── blog
        │   │               ├── controller
        │   │               │   ├── CategoryController.kt
        │   │               │   ├── CommentController.kt
        │   │               │   ├── PostController.kt
        │   │               │   └── TagController.kt
        │   │               ├── dto
        │   │               │   ├── CategoryRequest.kt
        │   │               │   ├── CommentRequest.kt
        │   │               │   ├── PostRequest.kt
        │   │               │   └── TagRequest.kt
        │   │               ├── model
        │   │               │   ├── Category.kt
        │   │               │   ├── Comment.kt
        │   │               │   ├── Post.kt
        │   │               │   └── Tag.kt
        │   │               ├── repository
        │   │               │   ├── CategoryRepository.kt
        │   │               │   ├── CommentRepository.kt
        │   │               │   ├── PostRepository.kt
        │   │               │   └── TagRepository.kt
        │   │               └── service
        │   │                   ├── CategoryService.kt
        │   │                   ├── CommentService.kt
        │   │                   ├── PostService.kt
        │   │                   └── TagService.kt
        │   └── resources
        │       └── application.properties
        └── test
            └── kotlin
                └── com
                    └── kotlin
                        └── blog
                            └── controller
                                ├── CategoryControllerTest.kt
                                ├── CommentControllerTest.kt
                                ├── PostControllerTest.kt
                                └── TagControllerTest.kt
```

## Como Executar o Projeto

1. Clone o repositório para sua máquina local.
2. Certifique-se de ter o JDK 17 e o Docker instalados.
3. Execute o comando `docker build -t blog-api .` para construir a imagem do Docker.
4. Execute o comando `docker run -p 8080:8080 blog-api` para executar o contêiner Docker.
5. Acesse a API em `http://localhost:8080`.

## Exemplos de Requisições

### Criação de um Post
```bash
curl -X POST \
  http://localhost:8080/posts \
  -H 'Content-Type: application/json' \
  -d '{
    "title": "Novo Post",
    "content": "Conteúdo do post...",
    "userId": 1,
    "categoryIds": [1, 2],
    "tagIds": [1, 2]
}'
```

### Busca de Posts por Palavra-chave
```bash
curl -X GET 'http://localhost:8080/posts/search?keyword=exemplo'
```

### Atualização de Status de um Post
```bash
curl -X PATCH 'http://localhost:8080/posts/1/status?status=PUBLISHED'
```

### Busca Avançada de Posts
```bash
curl -X GET 'http://localhost:8080/posts/advanced?page=0&size=10&keyword=exemplo&category=tecnologia&tag=java&status=published'
```

### Criação de um Comentário
```bash
curl -X POST \
  http://localhost:8080/comments \
  -H 'Content-Type: application/json' \
  -d '{
    "postId": 1,
    "userId": 2,
    "parentId": null,
    "content": "Excelente post!"
}'
```

### Busca de Comentários por ID do Post
```bash
curl -X GET 'http://localhost:8080/comments/post/1'
```

###
```bash
```

## Casos de Uso

1.  **Gerenciamento de Posts**
    -   Criar, atualizar, buscar e deletar posts.
    -   Buscar posts por palavra-chave, categoria, tag e status.
    -   Atualizar status de um post.
  
2.  **Gerenciamento de Comentários**  
    -   Criar, buscar e deletar comentários.
    -   Buscar comentários por ID do post.
    
3.  **Gerenciamento de Categorias e Tags**
    -   Criar, buscar e deletar categorias e tags.
    
4.  **Pesquisa Avançada**
    -   Realizar buscas avançadas de posts utilizando diferentes critérios.
    
5.  **Sistema de Autenticação**
    -   Implementar autenticação de usuários para acesso à API.

### Próximos passos:

 - [ ] Implementar camada de segurança
 - [ ] Incluir validações
	 - [ ] Somente autor do post pode modificar ou deletar
	 - [ ] Posts com status draft serão visíveis apenas para o autor
	 - [ ] Ao remover um usuário os posts dele serão marcados como "inativos"
 - [ ] Adicionar swagger
 - [ ] Escrever os testes
 - [ ] Lidar com as exceções

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir um problema ou enviar um pull request.

## Licença
Este projeto está licenciado sob a Licença MIT.
