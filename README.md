# DotCompliance BDD Automation Framework – SauceDemo Assignment

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
- **ExtentReports** *(planned for reporting)*
- **Page Object Model (POM)** for design pattern
- **Java Faker** *(optional for test data generation)*

---

## 📂 Project Structure

```
.
├── pom.xml
├── src/
│   ├── main/java/
│   │   └── com/dotCompliance/
│   │       ├── pages/           → Page Objects
│   │       ├── utils/           → WebDriver + logic utilities
│   ├── test/java/
│   │   └── com/dotCompliance/
│   │       ├── features/        → .feature files (Gherkin syntax)
│   │       ├── stepDefinitions/ → StepDefs for BDD
│   │       ├── runners/         → Cucumber TestNG runner
│   │       ├── hooks/           → Cucumber Before/After hooks
```

---

## ✅ Implemented Test Coverage (So Far)

| Area         | Scenario Example                        |
|--------------|------------------------------------------|
| Login        | Positive/Negative login, locked out user |
| E2E Checkout | Full flow from login to checkout success |
| UI Validations | Product list, filters, cart, social links |
| State Reset  | Reset App State from menu after tests    |

*See [TESTPLAN.md](./TESTPLAN.md) for full coverage.*

---

## 🚀 How to Run Tests

1. Make sure `Java 21+` and `Maven` are installed.
2. In terminal:
   ```bash
   mvn clean test
   ```

> 📢 Tests can be filtered by tag (e.g., `@login`, `@e2e`) once feature files and runners are connected.

---

## 📈 Future Enhancements

- [ ] Add CI/CD via GitHub Actions
- [ ] Integrate ExtentReports or Allure
- [ ] Support multi-browser and environment config

---

## 👤 Author

**Or Kowalsky**  
QA Automation Engineer  
Assignment for DotCompliance  
