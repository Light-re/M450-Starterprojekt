# BALF SideQuest – Lösungen

## BALF (Be a Lazy Fuck)
BALF kombiniert die Prinzipien **DRY**, **SRP** und **YAGNI** mit dem Ziel, einfache, wartbare und effiziente Lösungen zu bauen:

- **DRY**: Wiederholungen vermeiden (Code kapseln, bestehende Libraries nutzen)
- **SRP**: Jede Klasse/Methode hat genau eine Aufgabe
- **YAGNI**: Nur das implementieren, was aktuell wirklich gebraucht wird

---

## Aufgabe 1 (DRY)
### Problem
Im Beispiel wird die gleiche Ausgabelogik mehrfach geschrieben.

### Bessere Alternative
Siehe: [aufgabe1/DRYExampleRefactored.java](aufgabe1/DRYExampleRefactored.java)

**Warum DRY-konform?**
- Eingaben liegen in einer Datenstruktur
- Die Ausgabe läuft über eine Schleife
- Kein Copy-Paste von nahezu identischem Code

---

## Aufgabe 2 (DRY)
### Problem
`displayTasks()` wiederholt denselben Block für `t1`, `t2`, `t3`.

### Bessere Alternative
Siehe: [aufgabe2/TaskManagerRefactored.java](aufgabe2/TaskManagerRefactored.java)

**Warum DRY-konform?**
- Tasks werden in einer `List<Task>` gehalten
- Ausgabe erfolgt einheitlich in einer Schleife
- Neue Tasks erfordern keine zusätzliche Copy-Paste-Ausgabe

---

## Aufgabe 3 (SRP)
### Wie verstösst der Code gegen SRP?
`UserAccount` hat mindestens zwei Verantwortlichkeiten:
1. Zustandsverwaltung (`name`, `email`, Setter)
2. Validierungslogik (Business-Regeln inkl. Regex)

Wenn sich Validierungsregeln ändern, muss dieselbe Klasse geändert werden, obwohl sich die eigentliche Datenstruktur nicht geändert hat.

### Besserer Vorschlag (ohne Code)
- `UserAccount`: Nur Daten/Domain-Zustand halten
- `UserAccountValidator`: Nur Validierung übernehmen
- Optional: `EmailValidator` separat, falls E-Mail-Regeln an mehreren Stellen gebraucht werden

So bleibt jede Klasse auf eine klar abgegrenzte Verantwortung fokussiert.

---

## Aufgabe 4 (YAGNI)
### Wie verletzt die Klasse YAGNI?
Die User Story verlangt nur: **E-Mail + Passwort** erfassen.
Die Felder `name` und `geb_datum` sind aktuell nicht gefordert und erhöhen Komplexität ohne unmittelbaren Nutzen.

### Bessere Alternative
Siehe: [aufgabe4/UserRefactored.java](aufgabe4/UserRefactored.java)

**Warum YAGNI-konform?**
- Nur benötigte Felder (`email`, `password`)
- Zusätzliche Felder erst hinzufügen, wenn eine konkrete Anforderung sie verlangt

---

## Aufgabe 5 (Prinzip auswählen)
### Gegebene Auswahl
A) DRY  
B) YAGNI  
C) SRP

### Richtige Auswahl: **C) SRP**
**Begründung:**
`transferTo(...)` greift direkt in den Zustand eines anderen `Account`-Objekts ein (`getBalance()/setBalance()`). Dadurch übernimmt eine Methode mehr als eine klar abgegrenzte Verantwortung und verletzt die saubere Objektkapselung.

Zusätzlich ist die Logik fachlich unvollständig: Beim Transfer wird beim Sender nicht abgezogen.

### Besserer Ansatz
- `withdraw(amount)` beim Sender
- `deposit(amount)` beim Empfänger
- `transferTo` koordiniert nur diese beiden klaren Schritte

---

## Aufgabe 6 (Prinzip auswählen)
### Gegebene Auswahl
A) DRY  
B) SRP  
C) YAGNI

### Richtige Auswahl: **B) SRP**
**Begründung:**
`UtilityClass` enthält fachlich nicht zusammengehörige Aufgaben:
- Ausgabe (`printMessage`)
- Mathematik (`addTwoNumbers`, `calculateCirclePerimeter`)
- Zufallsgenerierung (`generateRandomNumber`)

Das sind mehrere Verantwortlichkeiten in einer Klasse.

### Besserer Ansatz
Aufteilen in spezialisierte Klassen, z. B.:
- `MessagePrinter`
- `MathUtils`
- `RandomService`

So bleiben Änderungen lokal und die Klasse ist leichter testbar.
