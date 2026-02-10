# Spacial BDD Automation Framework – SauceDemo Assignment

## 🎯 Objective

This project is part of a home assignment for the **QA Automation & Testing Lead** position at DotCompliance.

The goal is to demonstrate expertise in scalable and maintainable test automation by building a robust BDD framework for [SauceDemo](https://www.saucedemo.com), covering functional and E2E test scenarios.

---

## ⚙️ Tech Stack

- **Java 21+**
- **Cucumber (BDD)**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Rest Assured**
- **JSON Schema Validator**
- **Maven Surefire**
- **WebDriverManager**
- **Chrome browser**

---

## 📂 Project Structure

```
.
src
 └─ test
    ├─ java
    │  ├─ com.spacial.ui
    │  │  ├─ features          # Cucumber feature files
    │  │  ├─ stepDefinitions   # Step definitions
    │  │  ├─ runners           # Cucumber + TestNG runner
    │  │  ├─ pages             # Page element definitions
    │  │  └─ pageutils         # Page actions / flows
    │  │
    │  ├─ com.spacial.api
    │  │  └─ tests             # API tests (Rest Assured)
    │  │
    │  └─ com.spacial.utils
    │     └─ WebDriverCommonFunc.java
    │
    └─ resources
       └─ schemas              # JSON schemas for API contract validation
      ├── hooks/           → Cucumber Before/After hooks
```

---

## ✅ Implemented Test Coverage (So Far)

## UI Tests (SauceDemo)

Covered scenarios include:

- Successful login (smoke)

- Login failure with invalid credentials (negative)

- Cart badge updates when adding items

- Removing items from cart

- Logout flow

- Full E2E checkout flow (login → add product → checkout → completion)

- Application state reset

## API Tests (JSONPlaceholder)

Covered scenarios include:

- GET /posts/{id} – positive response validation

- GET /posts/{invalidId} – negative / not found

- Contract (schema) validation for API responses

SauceDemo does not expose a public API, therefore JSONPlaceholder is used as a stable public API for demonstration purposes.

_See [TESTPLAN.md](./TESTPLAN.md) for full coverage._

---

🏷️ Tagging Strategy (Cucumber)

UI tests are organized using Cucumber tags for flexible execution:

- @ui – all UI tests

- @smoke – fast smoke tests (CI-friendly)

- @e2e – end-to-end scenarios

- @negative – negative scenarios

- @debug – temporary debugging runs

---

## 🚀 How to Run Tests

# Prerequisites

- Java 17+ (tested with newer versions as well)

- Maven 3.8+

- Google Chrome installed

# In terminal:

```bash
mvn test "-Dcucumber.filter.tags=@ui"
```

```bash
mvn test "-Dcucumber.filter.tags=@smoke"
```

```bash
mvn test "-Dcucumber.filter.tags=@debug"
```

## Run API Tests

# Run a specific API test class:

```bash
mvn test -Dtest=JsonPlaceholderApiTest
```

# Run all API tests:

```bash
mvn test -Dtest=ReqResApiTest
```

---

## 🧪 Test Data

# UI

Username: standard_user

Password: secret_sauce

Checkout details use static test data to keep tests deterministic.

# API

Uses public JSONPlaceholder endpoints.

No authentication required.

## 🛡️ Stability & Anti-Flake Measures

- Stable selectors (id, data-test) used wherever possible

- Explicit waits via shared WebDriver utilities

- No hard sleeps

- Menu-state-aware logic for SauceDemo hamburger menu

- Clean application state reset between scenarios

- No global retries (failures remain meaningful)

## 📌 Known Limitations

- Public demo applications may change without notice

- Visual/UI styling validation is out of scope

- Cross-browser testing is not included (Chrome only)

- Performance and load testing are not included

## 🚀 CI Readiness

# The project is designed for CI pipelines:

# Recommended CI flow:

1. Run @smoke tests on pull requests

2. Run full @ui regression nightly

3. Run API tests as part of PR or nightly jobs

All tests are executed via Maven and are CI-friendly.

## 📈 Future Improvements

- Expand checkout validation scenarios

- Add sorting and inventory validation

- Introduce API schema suite expansion

- Add reporting (Allure / ExtentReports)

- Cross-browser execution

- Dockerized test execution

## 👤 Author

**Or Kowalsky**  
QA Automation Engineer  
Assignment for SPACIAL
