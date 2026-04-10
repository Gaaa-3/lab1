# Assignment 2 — Refactoring Notes

---

## 1. MysteriousNameExample
**Smell:** Method `f` and parameters `a`, `b`, `c`, `x`, `y` reveal nothing about intent.  
**Refactorings:** Rename method → `calculateHalfNetArea`; rename parameters → `width`, `height`, `deduction`; rename locals → `grossArea`, `netArea`.  
**Why better:** The code now reads as its own documentation. No reverse-engineering needed.

---

## 2. DuplicatedCodeExample
**Smell:** Tax and shipping calculations were copy-pasted identically into both `summerInvoice` and `winterInvoice`.  
**Refactorings:** Extract Method → `calculateTax`, `calculateShipping`.  
**Why better:** The shared logic lives in one place. Only the distinct discount rule stays in each seasonal method.

---

## 3. LongFunctionExample
**Smell:** `processOrder` handled discount, shipping, tax, approval status, and summary formatting all in one long block.  
**Refactorings:** Extract Method → `calculateDiscount`, `calculateShipping`, `calculateTax`, `determineApprovalStatus`, `buildSummary`.  
**Why better:** Each method has one job. `processOrder` now reads as a clear high-level sequence of steps.

---

## 4. LongParameterListExample
**Smell:** `registerStudent` took 12 loose primitive parameters.  
**Refactorings:** Introduce Parameter Object → `Address`, `GuardianContact`, `Enrollment`.  
**Why better:** Related data is grouped into meaningful concepts. The call site is far less noisy and the groups can carry their own behavior later.

---

## 5. GlobalDataExample
**Smell:** `currentSemester` and `tuitionRate` were public static fields reachable and mutable from anywhere.  
**Refactorings:** Extract Class → `AcademicConfiguration`; Encapsulate Field; inject config into `BillingService` and `SemesterAdministration`.  
**Why better:** State ownership is clear. Changes go through controlled methods. Both services depend on an object, not globals.

---

## 6. MutableDataExample
**Smell:** `getEnrolledStudents()` returned the live internal list, so callers could silently corrupt state with `.clear()` or `.add()`.  
**Refactorings:** Encapsulate Field — return `Collections.unmodifiableList`.  
**Why better:** Mutations can only happen through `enroll()`. The class fully controls its own state.

---

## 7. DivergentChangeExample
**Smell:** One class mixed report formatting, SQL building, and CSV export — three unrelated reasons to change.  
**Refactorings:** Extract Class → `ExamReportFormatter`, `ExamSqlBuilder`, `ExamCsvExporter`; Move related fields into each.  
**Why better:** Each class changes for exactly one reason. Editing CSV logic cannot accidentally affect SQL logic.

---

## 8. ShotgunSurgeryExample
**Smell:** Course title formatting was duplicated across `Course`, `Invoice`, and `Certificate`. Changing one label required three edits.  
**Refactorings:** Extract Class → `CourseTitle`; Move formatting methods onto it.  
**Why better:** All title formatting rules live in one place. A single change propagates automatically.

---

## 9. FeatureEnvyExample
**Smell:** `ScholarshipCalculator.qualifies()` only accessed `StudentAccount` data and contributed nothing of its own.  
**Refactorings:** Move Method → `qualifiesForScholarship()` into `StudentAccount`; remove now-empty `ScholarshipCalculator`.  
**Why better:** The behavior lives with the data it uses. Client code is simpler and more direct.

---

## 10. DataClumpsExample
**Smell:** `name`, `email`, `phone` traveled together as three separate parameters across every method signature.  
**Refactorings:** Introduce Parameter Object → `ContactInfo`; Move Methods onto it.  
**Why better:** The clump is modeled as one concept. Methods belong to their data. Client code is dramatically shorter.

---

## 11. PrimitiveObsessionExample
**Smell:** `status` and `countryCode` were raw strings with inline string comparisons. Domain rules were scattered in the method body.  
**Refactorings:** Replace Primitive with Object → `StudentStatus` enum, `CountryCode` enum; Extract Class → `DormApplication`.  
**Why better:** Illegal values are impossible at compile time. The eligibility rule belongs to its own object.

---

## 12. RepeatedSwitchesExample
**Smell:** The same `studentType` switch appeared in both `tuitionDiscount` and `dormPriority`. Adding a new type required two synchronized edits.  
**Refactorings:** Replace Conditional with Enum — `StudentType` enum holds both `tuitionDiscount` and `dormPriority` per type.  
**Why better:** A new student type is added in exactly one place. No risk of the two switches drifting out of sync.

---

## 13. LoopsExample
**Smell:** Manual for-each loop with a mutable accumulator list hid a simple filter-and-map transformation.  
**Refactorings:** Replace Loop with Pipeline (Stream).  
**Why better:** The stream reads as a direct description of the intent — filter by GPA, collect names — with no control flow noise.

---

## 14. LazyElementExample
**Smell:** `StudentNameFormatter` existed only to call `String.trim()` — no real abstraction, no variation.  
**Refactorings:** Inline Class — replace the formatter call with a direct `.trim()`.  
**Why better:** One less class to navigate. The code is simpler and just as clear.

---

## 15. SpeculativeGeneralityExample
**Smell:** `NotificationChannel.send()` carried `futureTemplate`, `encrypted`, and `urgent` parameters that `EmailChannel` silently ignored.  
**Refactorings:** Remove Parameter (Change Method Signature) — stripped all unused parameters.  
**Why better:** The interface matches actual usage. No imaginary requirements pollute the design.

---

## 16. TemporaryFieldExample
**Smell:** `examRoom` and `onlineMeetingLink` were both instance fields but only one mattered depending on the mode used.  
**Refactorings:** Extract Class → `OnsiteExam`, `OnlineExam`; Move field and logic into each.  
**Why better:** Each class owns exactly the fields it uses. No field is ever irrelevant or misleadingly null.

---

## 17. MessageChainsExample
**Smell:** `university.getDepartment().getCoordinator().getOffice().getPhoneNumber()` coupled the client to the full internal object graph.  
**Refactorings:** Hide Delegate — added `getCoordinatorPhoneNumber()` on `University`.  
**Why better:** The client asks for what it needs. Internal structure can change without affecting the caller.

---

## 18. MiddleManExample
**Smell:** `StudentPortal` only forwarded `findGrade()` to `TranscriptService` — pure delegation with zero added value.  
**Refactorings:** Remove Middle Man — inline `StudentPortal`; client talks to `TranscriptService` directly.  
**Why better:** One less indirection layer with no behavioral cost.

---

## 19. InsiderTradingExample
**Smell:** `AuditService` directly read and wrote `BankAccount`'s package-private fields, creating tight structural coupling.  
**Refactorings:** Encapsulate Field; Move Method — `freezeIfNegative()` moved into `BankAccount`; added `getStatus()`.  
**Why better:** `BankAccount` controls its own state. `AuditService` tells the account what to do instead of reaching in.

---

## 20. LargeClassExample
**Smell:** One class held enrollment, staffing, finance, help desk, facilities, payroll, and website responsibilities.  
**Refactorings:** Extract Class → `AcademicRegistry`, `FinanceOffice`, `HelpDesk`, `FacilitiesService`, `HrPayroll`; Move related fields and methods into each.  
**Why better:** Each class has one responsibility. Changes to payroll cannot affect enrollment logic.

---

## 21. AlternativeClassesWithDifferentInterfacesExample
**Smell:** `ZoomClassroom.beginSession()` and `TeamsClassroom.openMeeting()` did the same thing under different method names. Clients couldn't treat them uniformly.  
**Refactorings:** Extract Interface → `Classroom` with `start()`; Rename methods to match.  
**Why better:** Both implementations are substitutable. Client code works with `Classroom` without branching.

---

## 22. DataClassExample
**Smell:** `StudentRecord` was a passive bag of public fields. All behavior lived in three separate classes that reached into the data.  
**Refactorings:** Move Method — moved `isEligibleForHonors`, `tuitionDiscountPercent`, `describeAcademicStanding` into `StudentRecord`; Encapsulate Fields.  
**Why better:** Data and behavior are together. The separate evaluator classes are no longer needed.

---

## 23. RefusedBequestExample
**Smell:** `Penguin` extended `Bird` but threw `UnsupportedOperationException` from `fly()`, breaking the inherited contract.  
**Refactorings:** Extract Superclass → `FlyingBird` between `Bird` and flying birds; Push Down `fly()` to `FlyingBird`; `Penguin` extends `Bird` only.  
**Why better:** The hierarchy reflects reality. `Penguin` never inherits behavior it cannot support. LSP is respected.

---

## 24. CommentsExample
**Smell:** Three inline comments explained what each calculation step did, compensating for unclear code rather than improving it.  
**Refactorings:** Extract Method → `applyVipDiscount`, `applyBulkDiscount`, `applyTax`; comments removed.  
**Why better:** Method names communicate intent directly. The comments are no longer needed, and the main method reads as a clean sequence.
