# Feira Subscription - Projeto (Entrega)
Este repositório contém:
- Modelos UML (PlantUML) nas raízes: `uml_domain.puml`, `uml_sequence.puml`
- Código-fonte Java (exemplo simples) em `src/main/java/...`
- CSVs para carga: `resources/Plano.csv`, `resources/Produto.csv`
## Como compilar e executar
Requisitos:
- Java 11+ e Maven
No diretório do projeto:
mvn package
java -cp target/feira-subscription-1.0.jar br.ufm.feira.App
