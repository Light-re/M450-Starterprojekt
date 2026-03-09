# Answer Key (Short)

## 01 DRY Basics
- A: Extract method `isEven(int n)` and iterate over inputs.
- B: Less bug risk, easier maintenance.
- C: Over-abstraction hurts readability (e.g., generic method used only once).

## 02 DRY Java Refactor
- Use a `for` loop over users and print with one shared block.
- Add new user by editing list only.

## 03 SRP
- Violation: calculation + persistence + communication in one class.
- Split: `InvoiceCalculator`, `InvoiceRepository`, `InvoiceNotifier`.
- Testing improves because each unit can be isolated.

## 04 YAGNI
- Only `email` + `password` required by story.
- Remove extra fields until requirement exists.
- Add extra fields only when a concrete story needs them.

## 05 Mockito
- Mock service, inject into controller.
- Stub return values with `when(...).thenReturn(...)`.
- Verify interactions with `verify(service, times(1)).method()`.

## 06 Quick Quiz
1) B (SRP)
2) C (YAGNI)
3) A (DRY)
4) A
5) B
