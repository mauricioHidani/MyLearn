# 📝EVENTS
📍 MY LEARN / JAVA / CHALLENGES / DESVSUPERIOR / JAVA SPRING ESSENTIAL / DOMAIN MODEL AND ORM<br>
📅 July 25, 2023 - 🚩 São Paulo, Brazil - 🧑‍💻 Mauricio Mityo Hidani<br>


## Rodando o projeto

Versões utilizadas no desafio:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Gradle 8.2.1](https://docs.gradle.org/current/userguide/installation.html)
- [Spring 3.1.2](https://spring.io/projects/spring-boot)

O desafio está armazenado em um diretório específico deste repositório, dessa forma para conseguir realizar o **git clone** deste desafio, clonando apenas este desafio, realize os comandos demonstrados logo abaixo:

```
mkdir myLearn
cd myLearn

git init
git remote add origin https://github.com/mauricioHidani/MyLearn.git
git config core.sparseCheckout true
echo "events/*" >> .git/info/sparse-checkout
git pull origin main

cd events/

gradle build

```

Descrição dos comandos:

1. `mkdir myLearn`: cria um diretório
2. `cd myLearn`: entra no diretório criada
3. `git init`: inicia um repositório _git_ no diretório atual
4. `git remote add origin https://github.com/mauricioHidani/MyLearn.git`: adiciona o endereço remoto do repositório que contém o desafio
5. `git config core.sparseCheckout true`: configura o _sparse-checkout_ para aceitar que a _clonagem_ de um diretório específico do repositório
6. `echo "events/*" >> .git/info/sparse-checkout`: atribui a específicação do diretório à configuração do _git_ que será clonado.
7. `git pull origin main`: clona o repositório trazendo apenas o diretório configurado no _sparse-checkout_
8. `cd events/`: entra no diretório do desafio 
9. `gradle build`: constrói a aplicação/desafio utilizando o _gradle_


Para acessar o H2 e consultar os dados inseridos na base de dados, execute o comando abaixo caso ainda não tenha executado: 

```
gradle run
```

E acesso no navegaro: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)


## Especificações do desafio

Deve-se criar um projeto no Spring Boot com Java e banco de dados H2, e implementar o modelo 
conceitual conforme especificação a seguir. Além disso, você deve fazer o seeding da base de dados 
conforme diagrama de objetos que segue. 

Deseja-se construir um sistema para gerenciar as informações dos participantes das atividades de um 
evento acadêmico. As atividades deste evento podem ser, por exemplo, palestras, cursos, oficinas 
práticas, etc. Cada atividade que ocorre possui nome, descrição, preço, e pode ser dividida em vários 
blocos de horários (por exemplo: um curso de HTML pode ocorrer em dois blocos, sendo necessário 
armazenar o dia e os horários de início de fim do bloco daquele dia). Para cada participante, deseja-se 
cadastrar seu nome e email. 

```mermaid
erDiagram
    Participante}o--|{Atividade: ""
    Atividade||--|{Bloco: ""
    Atividade}o--||Categoria: ""

    Participante {
        Integer id PK
        String nome
        String email
    }

    Atividade {
        Integer id PK
        String nome
        String descricao
        Double preco
    }

    Categoria {
        Integer id PK
        String descricao
    }

    Bloco {
        Integer id PK
        Instant inicio
        Instant fim
    }
```

Instância dos dados para seeding (próxima página):

```mermaid
flowchart LR
    p1["`
        **p1: Participante**
        -----------------------------
        id: 1
        nome: José Silva
        email: jose@gmail.com
    `"]
    p2["`
        **p2: Participante**
        -----------------------------
        id: 2
        nome: Tiago Faria
        email: tiago@gmail.com
    `"]
    p3["`
        **p3: Participante**
        -----------------------------
        id: 3
        nome: Maria do Rosário
        email: maria@gmail.com
    `"]
    p4["`
        **p4: Participante**
        -----------------------------
        id: 4
        nome: Teresa Silva
        email: teresa@gmail.com
    `"]
    b1["`
        **b1: Bloco**
        -----------------------------
        id: 1
        inicio: 25/09/2017 08:00:00
        fim: 25/09/2017 11:00:00
    `"]
    b2["`
        **b2: Bloco**
        -----------------------------
        id: 2
        inicio: 25/09/2017 14:00:00
        fim: 25/09/2017 18:00:00
    `"]
    b3["`
        **b3: Bloco**
        -----------------------------
        id: 3
        inicio: 26/09/2017 08:00:00
        fim: 26/09/2017 11:00:00
    `"]
    a1["`
        **a1: Atividade**
        -----------------------------
        id: 1
        nome: Curso de HTML
        descricao: Aprenda HTML de forma prática
        preco: 80.00
    `"]
    a2["`
        **a2: Atividade**
        -----------------------------
        id: 2
        nome: Oficina de Github
        descricao: Controle versões de seus projetos
        preco: 50.00
    `"]
    c1["`
        **c1: Categoria**
        -----------------------------
        id: 1
        descricao: Curso
    `"]
    c2["`
        **c2: Categoria**
        -----------------------------
        id: 2
        descricao: Oficina
    `"]

    p1 --- a1 --- c1
    p1 --- a2 --- c2
    p2 --- a1
    p3 --- a1
    p3 --- a2
    p4 --- a2

    a1 --- b1
    a2 --- b2
    a2 --- b3
```