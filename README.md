# M450 Starterprojekt

![layout](docs/images/layout.png?)

Dieses Projekt soll für das Modul 450 als alternatives Projekt für eine Weiterentwicklung mit Testing dienen.
Für eine flexible Weiterentwicklung ist es sehr einfach gehalten. Es können Items erfasst und gelöscht werden.

Die Applikation ist bereits in Front- sowie Back-End implementiert und für eine Erweiterung bereit.

## wichtige Verzeichnisse

| Ordner                   | Beschreibung                                                |
| ------------------------ | ----------------------------------------------------------- |
| [/docs](/docs/README.md) | Enthält die vollständige Dokumentation des Projektes (TODO) |
| /src                     | Enthält den Source-Code für das Front-End und das Back-End  |

## Applikation starten

### Mit Docker

Ins Verzeichnis gehen wo das `docker-compose.yaml`-file liegt und folgenden Befehl in einer Kommandozeile ausführen

```shell
docker compose up -d
```

### Ohne Docker

Voraussetzungen ist ein installierter MySQL-Server.
Für eine erfolgreiche Verbindung musss noch die `applications.properties`-Datei angepasst werden. Die Datei liegt im Verzeichnis `src/back-end/src/main/resources` Im Speziellen die Einträge für

- `spring.datasource.url`: Serveradresse auf localhost oder entsprechende IP umstellen
- `spring.datasource.username`: falls ein anderer Benutzer für die Verbindung zur Datenbank verwendet wird
- `spring.datasource.password`: entsprechendes Passwort des Benutzers festlegen

#### Front-End starten

Ins Verzeichnis navigieren wo die `package.json`-Datei liegt und folgenden Befehl in einer Kommandozeile ausführen:

```shell
npm install # ist nur einmalig notwendig, beim ersten ausführen
npm run dev # zum Starten jeweils diesen Befehl verwenden
```

#### Back-End starten

Ins Verzeichnis navigieren wo die `pom.xml`-Datei liegt und folgenden Befehl in einer Kommandozeile ausführen:

```shell
mvn clean install # bestenfalls nur einmalig notwendig oder wird evtl. auch durch IDE automatisch gemacht
mvn spring-boot:run
```

## Tests ausführen (ab GitHub-Repo)

Alle Befehle unten werden vom **Repository-Root** ausgeführt.

### Schnellübersicht Befehle

```shell
# 1) Backend Unit- und Mock-Tests
cd src/back-end
mvn test

# 2) Frontend Jest-Tests
cd ../front-end
npm install
npm test

# 3) Frontend Playwright-Tests
npm run test:e2e
```

### Komplettdurchlauf in empfohlener Reihenfolge

```shell
cd src/back-end
mvn test

cd ../front-end
npm install
npm test
npm run test:e2e
```

Hinweis: `npx playwright install` ist nur bei der ersten lokalen Ausführung nötig.

### CI auf GitHub

Automatische Testausführung ist über GitHub Actions konfiguriert:

- `.github/workflows/tests.yml`
- Führt Backend-Tests (Maven), Frontend-Jest und Frontend-Playwright bei Push/Pull-Request aus.
