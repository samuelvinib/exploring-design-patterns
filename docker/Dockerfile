# Use uma imagem base que tenha o Java e o Maven instalados
FROM maven:3.8.4-openjdk-11 AS builder

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências do Maven (isso é feito separadamente do código fonte para otimizar o processo de construção da imagem)
RUN mvn dependency:go-offline -B

# Copia todo o código fonte para o diretório de trabalho
COPY src ./src

# Compila o projeto usando o Maven
RUN mvn package -DskipTests

# Define uma nova imagem base que contém apenas o JRE e o PostgreSQL JDBC driver
FROM openjdk:11-jre-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR construído na etapa anterior para o diretório de trabalho
COPY --from=builder /app/target/minha-aplicacao.jar .

# Define as variáveis de ambiente para a conexão com o banco de dados PostgreSQL
ENV DB_URL=jdbc:postgresql://postgres:5432/meu_banco_de_dados
ENV DB_USERNAME=meu_usuario
ENV DB_PASSWORD=minha_senha

# Expor a porta em que a aplicação Spring Boot será executada
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "minha-aplicacao.jar"]
