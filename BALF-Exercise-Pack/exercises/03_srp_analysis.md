# Exercise 03 – SRP Analysis

Analyze this class:

```java
public class InvoiceService {
    public void calculateTotal() { /* math */ }
    public void saveToDatabase() { /* db */ }
    public void sendEmail() { /* smtp */ }
}
```

## Tasks
1. Explain why this violates SRP.
2. Propose a split into better classes (names + responsibilities).
3. Explain one testing advantage of the split.
