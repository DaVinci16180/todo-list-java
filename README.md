# TODO List

## Contextualização do domínio

A vida das pessoas anda cada vez mais corrida e elas ficam cada vez mais atarefadas. Nesse contexto surge a necessidade de métodos que auxiliem na organização de tarefas e aumento da produtividade. No entanto, alguns métodos, embora pareçam práticos, podem se mostrar ineficazes por se tornarem eles mesmos causa de desorganização, seja por excesso de papel ou por uma curva de aprendizado longa. É para resolver esses problemas que entra a necessidade de uma aplicação simples que faça tudo o que uma corriqueira agenda pode fazer.

## Objetivo

Desenvolver uma aplicação que auxilie na organização das tarefas diárias de um individuo, por meio de listas de tarefas ou de afazeres.

## Descrição das funcionalidades

* **Criar múltiplas listas de tarefas**: criar listas de tarefas para diferentes objetivos, como listas para o trabalho, hobbies, livros para ler, etc. Será usada a interface List do Java para essa funcionalidade.
* **Criar tarefas**: criar tarefas dentro das listas. Será usada a interface List do Java para essa funcionalidade.
* **Criar subtarefas dentro de cada tarefa**: criar subtarefas que representam passos para a conclusão da tarefa. Será usada a interface List do Java para essa funcionalidade.
* **Definir nível de prioridade das tarefas**: definir prioridades das tarefas, com tarefas de maior prioridade sendo exibidas no topo da lista.
* **Definir prazo da tarefa**: definir uma data de conclusão das tarefas.
* **Atribuir tags às tarefas**: atribuir etiquetas às tarefas para auxiliar na busca.
* **Pesquisar tarefas por nome e por tags**
* **Deletar e editar tarefas**
* **Deletar e editar listas de tarefas**
* **Deletar e editar subtarefas**

## Classes-entidade

![diagrama-de-classes](https://user-images.githubusercontent.com/42824985/160262460-16d9ac78-bcad-44f9-907b-fd118b3f900d.png)

## Wireframe das telas

![image](https://user-images.githubusercontent.com/42824985/160310681-db791923-3d57-4f9f-a3b0-861c064e810c.png)

![image](https://user-images.githubusercontent.com/42824985/160310691-60e7310f-1ec7-43ae-96f2-bdac1a6a9cb2.png)

## Arquitetura

Para a implementação da aplicação será usado o Spring Boot, um framework do Java para desenvolvimento web que usa o padrão MVC (Model-View-Controller).
