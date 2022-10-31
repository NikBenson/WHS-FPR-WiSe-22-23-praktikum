# 1. Praktikum

Nik Benson (202123513)
Fortgeschrittene Programmierung im WiSe 22/23

## Aufgabe 1

Der Dokumentation ist zu entnehmen, dass `Math.pow` einen `double` zurück gibt.
Da ein Datenverlust (Nachkommastellen) nicht ausgeschlossen ist, ist der Cast notwendig.
Weniger ersichtlich ist der Datenverlust im zweiten Ausdruck. Allerdings beinhaltet ein `long` 64 bit und ein `int` lediglich 32 bit.
Somit müssen wir dem Compiler auch hier unsere Sicherheit mitteilen, damit das Programm Kompiliert.

```java
long l = (long) Math.pow(3, 22);
int i = (int) l;

System.out.printf("long l = %d\n", l);
System.out.printf("int i = %d\n", i);
```

Fehlerfrei ist die Funktion allerdings noch nicht, wie an der ausgabe zu erkennen ist:

```java
long l = 31381059609
int i = 1316288537
```

`l` ist größer als `Integer.MAX_VALUE`, weshalb nur die ersten bytes interpretiert werden.
Dies führt im Gegensatz zum Abrunden des ersten Casts zu einem fatalen semantischen Fehler.
