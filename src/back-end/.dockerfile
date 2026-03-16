FROM maven:3.9.9-eclipse-temurin-21-noble

WORKDIR /starter-project

RUN useradd -m -u 10001 appuser && chown -R appuser:appuser /starter-project

COPY --chown=appuser:appuser --chmod=0550 pom.xml ./
COPY --chown=appuser:appuser --chmod=0550 src ./src

USER appuser

RUN mvn clean install

CMD ["mvn", "spring-boot:run"]