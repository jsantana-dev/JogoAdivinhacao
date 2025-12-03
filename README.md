# 🎯 Jogo de Adivinhação

Um jogo interativo de adivinhação desenvolvido em Java, aplicando conceitos sólidos de Programação Orientada a Objetos e arquitetura em camadas.

## 📋 Sobre o Projeto

Este projeto foi desenvolvido como parte do meu aprendizado em Java, com foco em boas práticas de desenvolvimento, separação de responsabilidades e código limpo. O jogo desafia o jogador a adivinhar um número secreto em diferentes níveis de dificuldade, oferecendo dicas inteligentes durante o jogo.

## ✨ Funcionalidades

- **Três níveis de dificuldade:**
  - 🟢 **Fácil:** Número entre 1 e 50 (12 tentativas)
  - 🟡 **Médio:** Número entre 1 e 500 (10 tentativas)
  - 🔴 **Difícil:** Número entre 1 e 5000 (8 tentativas)

- **Sistema de dicas inteligentes:** Após metade das tentativas, o jogo fornece dicas baseadas em propriedades matemáticas:
  - **Nível Fácil:** Informa se o número é par ou ímpar
  - **Nível Médio:** Indica divisibilidade ou se é primo
  - **Nível Difícil:** Revela se é quadrado perfeito, primo ou a soma dos dígitos

- **Validação robusta:** Tratamento completo de entradas inválidas do usuário
- **Estatísticas da partida:** Exibe resumo detalhado ao final de cada jogo
- **Loop de jogo:** Opção de jogar múltiplas vezes sem reiniciar

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas, organizada da seguinte forma:

```
src/
└── br.com.jogoadvinhacao/
    ├── modelo/          # Camada de domínio
    │   ├── Jogo.java
    │   ├── Dificuldade.java (enum)
    │   └── Estatisticas.java
    │
    ├── servico/         # Lógica de negócio
    │   ├── GeradorNumero.java
    │   └── GeradorDicas.java
    │
    ├── util/            # Utilitários
    │   └── ValidadorEntrada.java
    │
    ├── ui/              # Interface com usuário
    │   └── InterfaceConsole.java
    │
    └── Main.java        # Ponto de entrada
```

### Princípios Aplicados

- **Separação de Responsabilidades:** Cada classe tem uma única responsabilidade bem definida
- **Encapsulamento:** Atributos privados com getters apropriados
- **Enum para Constantes:** Uso de `Dificuldade` enum para evitar magic numbers
- **Injeção de Dependências:** Classes recebem dependências via construtor
- **Facilmente Extensível:** Estrutura preparada para futuras implementações (GUI, multiplayer, persistência)

## 🛠️ Tecnologias Utilizadas

- **Java 8+**
- **IntelliJ IDEA** - IDE
- **Git/GitHub** - Controle de versão
- **JUnit 5** - Testes unitários

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8 ou superior instalado
- IDE Java (IntelliJ IDEA, Eclipse, VS Code) ou terminal

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/jogo-adivinhacao.git
cd jogo-adivinhacao
```

2. Compile o projeto:
```bash
javac -d bin src/br/com/jogoadvinhacao/**/*.java
```

3. Execute a classe Main:
```bash
java -cp bin br.com.jogoadvinhacao.Main
```

**Ou** abra o projeto na sua IDE favorita e execute a classe `Main.java`.

## 🎮 Como Jogar

1. Ao iniciar, escolha o nível de dificuldade (1, 2 ou 3)
2. Digite seu palpite quando solicitado
3. O jogo informará se seu palpite foi alto ou baixo
4. Na metade das tentativas, você receberá uma dica
5. Continue tentando até acertar ou esgotar as tentativas
6. Ao final, visualize suas estatísticas
7. Escolha se deseja jogar novamente

## 🧪 Testes

O projeto inclui testes unitários para garantir a qualidade do código:

```bash
# Executar testes (após implementação do JUnit)
mvn test
```

## 🎯 Melhorias Futuras

- [ ] Interface gráfica (GUI) com JavaFX ou Swing
- [ ] Modo multiplayer (dois jogadores)
- [ ] Sistema de ranking com persistência de dados
- [ ] Níveis personalizados pelo usuário
- [ ] Timer para adicionar desafio extra
- [ ] Histórico de partidas
- [ ] Tema dark/light mode na GUI

## 📚 Aprendizados

Este projeto me permitiu desenvolver e aprimorar:

- ✅ Programação Orientada a Objetos (POO)
- ✅ Princípios SOLID
- ✅ Arquitetura em camadas (MVC-like)
- ✅ Tratamento de exceções
- ✅ Clean Code e boas práticas
- ✅ Versionamento com Git
- ✅ Documentação técnica

## 👨‍💻 Autor

**Jamylle da Silva Santana**
- LinkedIn: https://www.linkedin.com/in/jamylle-santana

---

## 📄 Licença

Este projeto é de código aberto e pode ser usado para aprendizado e melhorias. 🚀


