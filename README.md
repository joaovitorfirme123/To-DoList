# 📝 TaskManager --- To-Do List em Java

Um projeto simples de gerenciamento de tarefas em Java, com persistência
em arquivo.

O programa permite adicionar, listar e marcar tarefas como concluídas,
mantendo os dados mesmo após fechar o sistema.

------------------------------------------------------------------------

## 🚀 Funcionalidades

-   Adicionar novas tarefas\
-   Listar todas as tarefas\
-   Marcar tarefas como concluídas\
-   Salvar dados em arquivo (`tasks.txt`)\
-   Carregar tarefas automaticamente ao iniciar

------------------------------------------------------------------------

## 📌 Estrutura do Projeto

    TaskManager.java
    tasks.txt  (gerado automaticamente)

------------------------------------------------------------------------

## 🧠 Tecnologias Utilizadas

-   Java
-   ArrayList
-   Scanner
-   BufferedWriter / FileWriter
-   BufferedReader / FileReader

------------------------------------------------------------------------

## 🏗️ Como funciona

### ✔️ Classe `Task`

Representa uma tarefa contendo:

-   Descrição
-   Status concluído ou não
-   Método para marcar como concluída
-   toString customizado para exibição

### ✔️ Classe `TaskManager`

Gerencia:

-   Menu interativo no console
-   Lista de tarefas
-   Salvamento em arquivo
-   Carregamento automático das tarefas salvas

------------------------------------------------------------------------

## ▶️ Executando o Projeto

Compile o programa:

    javac TaskManager.java

E execute:

    java TaskManager

------------------------------------------------------------------------

## 💾 Persistência dos Dados

O programa cria/atualiza o arquivo `tasks.txt` com dados no formato:

    descricao;true/false

Exemplo:

    Comprar pão;false
    Estudar Java;true

Quando o programa inicia, ele lê o arquivo e recria as tarefas
automaticamente.

------------------------------------------------------------------------

## 📍 Menu do Sistema

    === To-Do List ===
    1 - Add Task
    2 - List Tasks
    3 - Quit and Save
    4 - Complete Task

------------------------------------------------------------------------

## 🧠 Aprendizados

Com este projeto, aprendi a diferença prática entre Memória Volátil (RAM) e Memória Não-Volátil (Disco). Foi meu primeiro contato com operações de I/O (Input/Output) em Java, essenciais para qualquer software que precise guardar informações a longo prazo.

------------------------------------------------------------------------

## 👨‍💻 Sobre mim

Estudante de programação focado em aprender Java na prática. Gosto de criar ferramentas úteis que resolvem problemas reais, como a necessidade de organizar o dia a dia e aplicar conceitos de persistência de dados.
