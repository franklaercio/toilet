# Toilet

## Problema

Um escritório contém um banheiro que pode ser utilizado tanto por homens quanto por mulheres,mas não
por
ambos ao mesmo tempo. Se um homem estiver no banheiro, outros homens podementrar, porém eventuais
mulheres
que desejem utilizar o banheiro devem esperar ele ficar vazio.Se uma mulher estiver no banheiro,
outras mulheres
podem entrar, porém eventuais homens quedesejem utilizar o banheiro devem esperar ele ficar vazio.
Cada pessoa
(homem ou mulher) podepassar um determinado tempo utilizando o banheiro, que possui uma capacidade
limite
de pessoasque podem utilizá-lo ao mesmo tempo.

## Solução

O algoritmo se baseou no problema do produtor e consumidor apresentado em sala de aula durante a
disciplina de Programação Concorrente. Logo o buffer comum compartilhado é o banheiro, a capacidade
do buffer é quantas pessoas podem acessar simultaneamente o banheiro, os produtores são as pessoas
que estão querendo usar o banheiro e os consumidores são as pessoas que estão saindo do
banheiro. <br>
Além disso, para gerar os genêros e o tempo de uso do banheiro foi utilizada a função random do
Java apenas utilizando a implementação padrão `(new Random())`.

## Sincronização

No projeto foram utilizados dois mecanismos de sincronização: o monitor e o notify.

- O monitor foi utilizado nos métodos `use()` e `exit()`, pois é onde pode-se entrar e sair do
  banheiro. Logo, deve-se ser feita uma sincronização no buffer compartilhado para que o produtor
  não produza demais e nem consumidor fique sem consumir, evitando assim o problema de starvation.
- O notify foi implementado para notificar a outros produtores que estejam aguardando usar o buffer
  que podem entrar no banheiro. Além disso, ele foi utilizado quando o banheiro estava ocupado com o
  método `wait()`, para aguardar que o banheiro esteja livre para uso.

## Corretude

A corretude do programa é garantida pelos mecanismos de controle para saber se o buffer está vazio
ou ocupado. Caso o buffer esteja ocupado é necessário aguardar o buffer ter espaço, que é liberado
no método `exit()` e se o buffer estiver vazio a thread fica aguardando os consumidores.

## Dificuldades

As dificuldades foram principalmente enfrentadas no mecanismo de sincronização, pois estava
ocorrendo deadlock e na implementação do tempo de uso do banheiro, pois tivemos que adaptar a
solução com uma nova classe `Person()` que tem os atributos de gênero e tempo de uso do banheiro.

## Instruções de como executar

- Ter o Java 17 ou posterior instalado na máquina
- Fazer o download do código fonte
- Executar o projeto Java
- Caso queira alterar a quantidade da capacidade ou número de pessoas, deve-se ajustar a classe Main
  do projeto