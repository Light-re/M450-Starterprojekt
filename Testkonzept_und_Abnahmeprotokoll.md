# Testkonzept und Abnahmeprotokoll

**Projekt:** M450-Starterprojekt  
**Autoren:** Ajan Neziri & Noé Fratton  
**Datum:** 09.03.2026  
**Version:** 1.1

---

## Inhaltsverzeichnis

1. [Systemanforderungen](#1-systemanforderungen)
2. [Testkonzept](#2-testkonzept)
3. [Abnahmeprotokoll nach HERMES](#3-abnahmeprotokoll-nach-hermes)
4. [Beantwortung der Zusatzfragen](#4-beantwortung-der-zusatzfragen)
5. [Testprotokolle Aufgabe 2](#5-testprotokolle-aufgabe-2)

---

## 1. Systemanforderungen

### 1.1 Grobanforderungen

| ID | Anforderung | Anforderungsart | Wichtigkeit | Dringlichkeit |
| :--- | :--- | :--- | :--- | :--- |
| GA01 | Der Benutzer kann ein neues Item erfassen. | Funktional | Hoch | Hoch |
| GA02 | Der Benutzer kann alle erfassten Items in einer Liste sehen. | Funktional | Hoch | Hoch |
| GA03 | Der Benutzer kann ein bestehendes Item löschen. | Funktional | Mittel | Mittel |
| GA04 | Das System muss eine intuitive Benutzeroberfläche bieten. | Nicht-funktional | Mittel | Niedrig |

### 1.2 Detailanforderungen

**Funktionale Anforderungen (Use Cases):**
- **UC01: Item erfassen:** Der Benutzer gibt einen Namen ein und klickt auf "Add". Das System speichert das Item und aktualisiert die Liste.
- **UC02: Item löschen:** Der Benutzer klickt auf das Löschen-Symbol neben einem Item. Das System entfernt das Item.

**Qualitätsanforderungen (FURPS+):**
- **Functionality:** Create/Read/Delete für Items funktioniert fehlerfrei.
- **Usability:** UI ist selbsterklärend und reagiert unmittelbar.
- **Reliability:** Fehlerfälle führen nicht zum Absturz.
- **Performance:** Darstellung der Liste erfolgt in kurzer Zeit.
- **Supportability:** Code ist testbar und reproduzierbar ausführbar.

---

## 2. Testkonzept

### 2.1 Testziele

- Kernfunktionen (Add, List, Delete) korrekt nachweisen.
- Interaktion zwischen Komponenten und API prüfen.
- Ausführbare Tests inkl. nachvollziehbarer Protokolle bereitstellen.

### 2.2 Teststrategie und Teststufen

- **Unit-Tests Backend (SQ4A):** JUnit 5 auf Model/Controller-Verhalten.
- **Mock-Tests Backend (SQ4B):** Mockito mit `@Mock`, `@Spy`, `@Captor`.
- **Frontend Unit-Tests (SQ5A):** Jest + Testing Library für React-Komponenten.
- **Frontend E2E-Tests (SQ5A):** Playwright für User-Flows.
- **Manuelle Abnahme:** Ergänzende Sichtprüfung nach HERMES.

### 2.3 Testobjekte

- Spring Boot Backend
- React Frontend
- REST-Schnittstelle `/items`

### 2.4 Testabdeckung

| Testfall-ID | Beschreibung | Abgedeckte Anforderung | Ergebnis |
| :--- | :--- | :--- | :--- |
| TF-01 | Neues Item hinzufügen | GA01, UC01 | Erfolgreich |
| TF-02 | Vorhandene Items anzeigen | GA02 | Erfolgreich |
| TF-03 | Item löschen | GA03, UC02 | Erfolgreich |
| TF-04 | Stabilität bei Fehler-/Randfall | Reliability | Erfolgreich (kein Absturz) |

### 2.5 Testumgebung und Infrastruktur

- **Backend:** Maven + JUnit + Mockito
- **Frontend Unit:** Jest + @testing-library/react + jsdom
- **Frontend E2E:** Playwright (Chromium)
- **Artefakte:** Playwright HTML-Report, Screenshots in `docs/images`

### 2.6 Ausführbarkeit ab GitHub-Repository

1. Backend-Tests:
   - `cd src/back-end`
   - `mvn test`

2. Frontend Unit-Tests:
   - `cd src/front-end`
   - `npm install`
   - `npm test`

3. Frontend E2E-Tests:
   - `cd src/front-end`
   - `npm run test:e2e`

4. Automatisierte Ausführung auf GitHub:
   - Workflow: `.github/workflows/tests.yml`
   - Läuft bei Push und Pull Request.

---

## 3. Abnahmeprotokoll nach HERMES

**1. Abnahmegegenstand:** M450-Starterprojekt (Release 1.1)  
**2. Abnahmebeteiligte:** Ajan Neziri, Noé Fratton (Auftragnehmer), Sven Schirmer (Auftraggeber)  
**3. Grundlagen:** Anforderungen und Testkonzept (dieses Dokument)  
**4. Abnahmeverfahren:** Ausführung automatisierter Tests und manuelle Sichtprüfung

### 3.1 Abnahmekriterien mit Mängelklassen

- **Kritischer Mangel:** Add/List/Delete nicht funktionsfähig.
- **Leichter Mangel:** Kleine UX-/Validierungsdefizite ohne Blockierung der Kernfunktion.

### 3.2 Lieferergebnisse und Mängel

| Test-ID | Testfall | Status | Gefundene Mängel | Massnahmen |
| :--- | :--- | :--- | :--- | :--- |
| TF-01 | Neues Item hinzufügen | [ ERFOLGREICH ] | Keine | - |
| TF-02 | Vorhandene Items anzeigen | [ ERFOLGREICH ] | Keine | - |
| TF-03 | Item löschen | [ ERFOLGREICH ] | Keine | - |
| TF-04 | Stabilität bei Randfall | [ ERFOLGREICH ] | Keine kritischen Mängel | Optionale Validierung leerer Namen im Frontend |

### 3.3 Abnahmeergebnis

- [ ] **Abnahme erteilt**
- [x] **Abnahme mit Auflagen** (optionale zusätzliche Eingabevalidierung)
- [ ] **Abnahme verweigert**

---

## 4. Beantwortung der Zusatzfragen

1. **Fehlen noch wichtige Tests?**  
   Security- und Lasttests können später ergänzt werden.
2. **Reicht der Werkzeugkasten aus?**  
   Für den aktuellen Stand ja: JUnit/Mockito/Jest/Playwright decken die Lernziele ab.
3. **Wurde eine Testart weggelassen?**  
   Ja, Last- und Security-Tests sind nicht Bestandteil dieser Abgabe.
4. **Wann wird wie tief getestet?**  
   Unit-Tests bei jeder Änderung, E2E vor Abgabe/Release.
5. **Wie erreicht man gute Testeffizienz?**  
   Durch Automatisierung, klare Testpyramide und reproduzierbare Testdaten.
6. **Welche Tests nach Bugfix oder vor Release?**  
   Selektive Regression + vollständiger E2E-Durchlauf.

---

## 5. Testprotokolle Aufgabe 2

### 5.1 Unit-Tests Backend (SQ4A)

**Befehl:**  
`cd src/back-end && mvn "-Dtest=ch.wiss.m450.starter_project.model.ItemTest,ch.wiss.m450.starter_project.controller.ItemControllerMockTest" test`

**Resultat:**  
`BUILD SUCCESS`  
`Tests run: 7, Failures: 0, Errors: 0, Skipped: 0`

### 5.2 Mockup-Tests mit `@Mock`, `@Spy`, `@Captor` (SQ4B)

**Testklasse:**  
`src/back-end/src/test/java/ch/wiss/m450/starter_project/controller/ItemControllerMockTest.java`

**Nachweis:**
- `@Mock` auf Repository
- `@Spy` auf Testdatenliste
- `@Captor` für gespeichertes `Item`

### 5.3 Jest Frontend-Tests (SQ5A)

**Befehl:**  
`cd src/front-end && npm test -- --runInBand`

**Resultat:**  
`Test Suites: 2 passed, 2 total`  
`Tests: 2 passed, 2 total`

### 5.4 Playwright Frontend-Tests (SQ5A)

**Befehl:**  
`cd src/front-end && npm run test:e2e`

**Resultat:**  
`Running 2 tests`  
`2 passed`

### 5.5 Screenshots der Testergebnisse (SQ3A)

- `docs/images/playwright-item-added.png`
- `docs/images/playwright-item-deleted.png`

### 5.6 Checkliste zu den Bewertungskriterien

- [x] Allg. Doku-Stil (Titel, Inhaltsverzeichnis, Struktur)
- [x] Sinnstiftende einfache Unit-Tests (Backend)
- [x] Sinnstiftende Mockup-Tests mit `@Mock`, `@Spy`, `@Captor`
- [x] Sinnstiftende Jest Frontend-Tests
- [x] Sinnstiftende Playwright Frontend-Tests
- [x] Abnahmeprotokoll plus Screenshots
- [x] Testkonzept aktualisiert
- [x] Tests ab GitHub Repo ausführbar
