# Mockito Dokumentation für M450 Starterprojekt

## Teil 1 - Theorie

### 1. Grundlagen von Mockito

Mockito ist ein beliebtes Java-Framework für das Erstellen von Mock-Objekten in Unit-Tests. Es ermöglicht es, Abhängigkeiten zu simulieren, um isolierte Tests zu schreiben, ohne echte Datenbanken oder externe Services zu benötigen.

**Hauptfunktionen:**
- Erstellung von Mock-Objekten
- Definition von Verhalten für Mock-Methoden
- Verifikation von Methodenaufrufen
- Spying auf echten Objekten

**Vorteile:**
- Schnellere Tests (keine I/O-Operationen)
- Isolierte Tests (keine Seiteneffekte)
- Einfache Reproduktion von Edge-Cases

### 2. Mockito Annotationen

#### @Mock
Erstellt ein Mock-Objekt einer Klasse oder eines Interfaces. Alle Methoden des Mocks geben Standardwerte zurück (null, 0, false), es sei denn, sie werden konfiguriert.

```java
@Mock
private ItemRepository itemRepository;
```

#### @Spy
Erstellt ein Spy-Objekt, das ein echtes Objekt umhüllt. Methoden verhalten sich wie das echte Objekt, können aber überschrieben werden.

```java
@Spy
private ItemService itemService;
```

#### @Captor
Fängt Argumente von Methodenaufrufen ein, um sie später zu überprüfen.

```java
@Captor
private ArgumentCaptor<Item> itemCaptor;
```

#### @InjectMocks
Injiziert Mock-Objekte in das zu testende Objekt. Mockito sucht nach Feldern mit @Mock und injiziert sie automatisch.

```java
@InjectMocks
private ItemController itemController;
```

### 3. Unterschied zwischen @Mock und @Spy

**@Mock:** Vollständiges Mock-Objekt. Alle Methoden müssen konfiguriert werden, sonst geben sie Standardwerte zurück.

**@Spy:** Umhüllt ein echtes Objekt. Methoden verhalten sich echt, können aber für spezifische Tests überschrieben werden.

**Beispiel:**

```java
@Mock
List<String> mockList = Mockito.mock(List.class);
// mockList.size() gibt 0 zurück

@Spy
List<String> spyList = Mockito.spy(new ArrayList<>());
spyList.add("test");
// spyList.size() gibt 1 zurück
```

### 4. Vergleich Unit-Tests SideQuest 4A vs 4B

**SideQuest 4A (ohne Mockito):**
- Tests benötigen echte Datenbankverbindungen
- Langsamer durch I/O-Operationen
- Schwieriger, Edge-Cases zu testen
- Abhängig von externen Ressourcen

**SideQuest 4B (mit Mockito):**
- Mock-Objekte für Datenbank-Interaktionen
- Schnellere, isolierte Tests
- Einfache Simulation von Fehlerszenarien
- Bessere Testabdeckung ohne Seiteneffekte

**Nutzen von Mockito:**
- Erhöht Testgeschwindigkeit und Zuverlässigkeit
- Ermöglicht Testing von Business-Logik ohne Infrastruktur
- Vereinfacht das Testen von Ausnahmefällen

## Teil 2 - Praxis

### 1. Analyse bestehender Tests

Die bestehenden Tests (StarterProjectApplicationTests) sind leer und führen nur einen Context-Start-Test durch. Sie können mit Mockito optimiert werden, indem echte Abhängigkeiten gemockt werden.

### 2. Analyse auf neue Komponenten

Das Projekt hat ItemController, der ItemRepository verwendet. ItemController kann mit gemocktem ItemRepository getestet werden. Zusätzlich können Services oder Validatoren hinzugefügt werden, die mit Mockito getestet werden.

### 3. Implementierte Unit-Tests mit Mockito

**ItemControllerTest.java:**
- Verwendet @Mock für ItemRepository
- Verwendet @InjectMocks für ItemController
- Testet alle CRUD-Operationen

**ItemServiceTest.java:**
- Verwendet @Mock für ItemRepository
- Verwendet @Spy für ItemService (@InjectMocks mit @Spy)
- Demonstriert Spy-Funktionalität mit realen Methodenaufrufen

Beide Tests verwenden @Mock und @Spy wie gefordert.