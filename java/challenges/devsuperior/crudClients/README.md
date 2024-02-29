# 💎 CRUD CLIENTS
📍 WORKSPACE / WORK / LEARNING NOTES / DEVSUPERIOR<br>
📅 Augost 07, 2023 - 🚩 São Paulo, Brazil - 😁 Mauricio Mityo Hidani<br>


## Rodando o desafio

Versões utilizadas no desafio:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.9.4](https://maven.apache.org/docs/3.9.4/release-notes.html)
- [Spring 3.1.2](https://spring.io/projects/spring-boot)

O desafio está armazenado em um diretório específico deste repositório, dessa 
forma para conseguir realizar o git clone deste desafio (clonando apenas este 
desafio), realize os comandos demonstrados logo abaixo: 

```
mkdir myNotes
cd myNotes/

git init
git remote add origin https://github.com/mauricioHidani/MyLearn.git
git config core.sparseCheckout true
echo "java/challenges/devsuperior/crudClients/*" >> .git/info/sparse-checkout
git pull origin main

cd java/challenges/devsuperior/crudClients/

mvn clean install
mvn spring-boot:run
```

Descrição dos comandos:

01. `mkdir myNotes`: cria o diretório para armazenar o desafio;
02. `cd myNotes/`: entra no diretório serparado para a clone do repositório;
03. `git init`: inicia um repositório _git_ no diretório atual;
04. `git remote add origin https://github.com/mauricioHidani/MyLearn.git`: adiciona o endereço remoto do repositório que contém o desafio;
05. `git config core.sparseCheckout true`: configura o _sparse-checkout_ para aceitar que a _clonagem_ de um diretório específico do repositório;
06. `echo "java/challenges/devsuperior/crudClients/*" >> .git/info/sparse-checkout`: atribui a específicação do diretório à configuração do _git_ ao qual será clonado;
07. `git pull origin main`: clona o repositório trazendo apenas o diretório configurado no _sparse-checkout_;
08. `cd java/challenges/devsuperior/crudClients/`: entra na pasta clonada do repositório;
09. `mvn clean install`: o projeto é compilado, testado, empacotado e instalado no repositório local de sua máquina;
10. `mvn spring-boot:run`: roda a aplicação/desafio utilizando o _maven_.


## Endpoints da API CRUD Clients

- Find by Id **GET** | HTTP STATUS 200 OK [http://localhost:8080/clients/1](http://localhost:8080/clients/1)
- Find All **GET** | HTTP STATUS 200 OK [http://localhost:8080/clients?page=0&size=6&sort=name](http://localhost:8080/clients?page=0&size=6&sort=name)
- Insert **POST** | HTTP STATUS 201 CREATED [http://localhost:8080/clients](http://localhost:8080/clients)
- Update by id **PUT** |  HTTP STATUS 200 OK [http://localhost:8080/clients/1](http://localhost:8080/clients/1)
- Delete by id **DELETE** | HTTP STATUS 204 NO CONTENT [http://localhost:8080/clients/1](http://localhost:8080/clients/1):

## Especificações do desafio

Você deverá entregar um projeto Spring Boot contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:

- Busca paginada de recursos 
- Busca de recurso por id 
- Inserir novo recurso 
- Atualizar recurso 
- Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados **H2**, deverá usar **Maven** como gerenciador de dependência, e Java como linguagem.

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir (você deve seguir à risca os nomes de classe e atributos mostrados no diagrama):

```mermaid
erDiagram
    Client {
        BIGINT ID PK
        VARCHAR NAME
        VARCHAR CPF
        DECIMAL INCOME
        DATE BIRTH_DATE
        INT CHILDREN 
    }
```

**Seu projeto deverá fazer um _seed_ de pelo menos _10 clientes_** com dados SIGNIFICATIVOS (não é para usar dados sem significado como “Nome 1”, “Nome 2”, etc.).

**Seu projeto deverá tratar as seguintes exceções:**
- Id não encontrado (para GET por id, PUT e DELETE), retornando código 404. 
- Erro de validação, retornando código 422 e mensagens customizada para cada campo inválido. As regras de validação são: 
  - Nome: não pode ser vazio 
  - Data de nascimento: não pode ser data futura (dica: use @PastOrPresent) 

**Atenção:** crie um novo projeto para este trabalho. Não é para simplesmente acrescentar a classe Client no projeto feitos nas aulas.

**Atenção:** lembre-se de que por padrão a JPA transforma nomes de atributos em camelCase para snake_case, como foi o caso do campo imgUrl das ulas, que no banco de dados tinha o nome _img_url_. **Assim, o campo _birthDate_ acima será criado no banco de dados como _birth_date_, então seu script SQL deverá seguir este padrão**.

**Atenção:** cuidado para não salvar no seu projeto arquivos e pastas que não devem ser salvas no Git, 
tais como a pasta _.metadata_ do Eclipse ou _.idea_ do Intellij. 


## Como o trabalho será corrigido?

### 1) Importação do projeto
O professor deverá ser capaz de fazer um simples clone do projeto Github, e importar e executar o mesmo na IDE sem necessidade de qualquer configuração especial diferente daquelas das aulas.


### 2) Testes manuais no Postman
O professor já terá preparado em seu computador as requisições Postman abaixo. Todas elas deverão funcionar corretamente:


_Busca de cliente por id_
```
GET /clients/1
```

_Busca paginada de clientes_
```
GET /clients?page=0&size=6&sort=name
```


_Inserção de novo cliente_
```json
POST /clients
{
 "name": "Maria Silva",
 "cpf": "12345678901",
 "income": 6500.0,
 "birthDate": "1994-07-20",
 "children": 2
}
```

_Atualização de cliente_
```json
PUT /clients/1
{
 "name": "Maria Silvaaa",
 "cpf": "12345678901",
 "income": 6500.0,
 "birthDate": "1994-07-20",
 "children": 2
}
```

_Deleção de cliente_
```
DELETE /clients/1
```

**CHECKLIST:** 
1. Busca por id retorna cliente existente 
2. Busca por id retorna 404 para cliente inexistente 
3. Busca paginada retorna listagem paginada corretamente 
4. Inserção de cliente insere cliente com dados válidos 
5. Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos 
6. Atualização de cliente atualiza cliente com dados válidos 
7. Atualização de cliente retorna 404 para cliente inexistente 
8. Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos 
9. Deleção de cliente deleta cliente existente 
10. Deleção de cliente retorna 404 para cliente inexistente