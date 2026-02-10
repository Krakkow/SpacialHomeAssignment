## 1. Scope & Goal

This assignment delivers a small but production-minded automation suite for SauceDemo UI flows, plus API validation against a stable public API (JSONPlaceholder), focusing on:

High-value coverage (not “test everything”)

Stability and anti-flake UI patterns

Maintainable structure (POM + utilities)

CI-ready execution with tagging and selective runs

Clear assertions + minimal contract validation for API

## 2. What I chose to automate (and why)

UI Automation (SauceDemo)

I automated 5 meaningful UI scenarios that cover the highest-value user journeys and common failure modes:

# E2E checkout flow (Happy path)

Validates the critical business flow: login → add item → cart → checkout → completion, plus app reset for clean state.

# Successful login (Smoke)

A fast gate test verifying that authentication works and navigation to Products succeeds.

# Invalid login (Negative)

Validates error handling and prevents regressions that could break login validation/UI feedback.

# Cart state change (Badge updates)

Validates that adding an item produces a visible state change (cart badge count), which is a common regression point.

# Remove from cart + logout

Validates cart removal behavior (state change to empty), and logout redirection to login page.

These were selected because they:

Exercise the most used flows

Provide fast feedback in CI

Catch typical UI regressions (navigation, state, validation)

API Automation (JSONPlaceholder)

SauceDemo has no public API suitable for testing, so I used JSONPlaceholder as allowed.

I implemented 3 API tests:

# Positive: GET /posts/1 returns expected fields

# Negative: GET /posts/0 (or non-existing post) returns 404

# Contract-like: schema validation for GET /posts/1 response (minimal but stable)

These were selected to demonstrate:

Status code validation

Response body assertions

Basic schema/contract validation

## 3. What I intentionally didn’t automate (and why)

UI (SauceDemo)

Visual/UI layout checks (pixel-level / CSS styling):
Not reliable with Selenium-only; better handled via visual regression tools (Playwright, Percy, Applitools).

Cross-browser matrix (Chrome/Firefox/Safari):
Not included due to time constraints; suite design supports extending driver config.

Exhaustive combinations (all users, all products, all sorting options):
Low ROI for a take-home; would expand coverage via parameterization only after core stability is proven.

Performance testing (page load timings, stress):
Out of scope for a UI-focused suite; better via k6/JMeter and monitoring.

API

Full contract testing across endpoints:
Implemented minimal schema validation only; full contract testing would be done via OpenAPI + schema suite in a real project.

Auth/security testing:
JSONPlaceholder has no auth; in a real system this would include token refresh, RBAC, and negative auth cases.

## 4. Risks & Assumptions

Assumptions

SauceDemo UI is publicly available and stable.

SauceDemo uses stable selectors (id, data-test) suitable for automation.

JSONPlaceholder endpoints remain available and consistent.

Risks

Public apps can change without notice (breaking selectors/endpoints).

UI flakiness due to timing/animation (hamburger menu overlay) — mitigated with menu-state-aware helpers and explicit waits.

Running on different machines may require driver/Chrome version alignment (mitigated via WebDriverManager).

## 5. Stability approach (selectors, waits, retries, data)

Selectors

Prefer stable selectors:

id (e.g., hamburger menu, logout/reset)

data-test when available (SauceDemo provides many)

Avoid brittle CSS chains or DOM-position-based selectors.

Waits / Anti-flake patterns

Use explicit waits via shared WebDriverCommonFunc utilities (e.g., wait for visibility/clickability).

Avoid hard sleeps.

Handle known UI overlays (hamburger menu) with state-aware logic:

Open menu only if closed

Close after reset when needed

Click logout from a known open state

Retries

No global retries enabled by default (keeps failures meaningful).

If retries were introduced later, they would be applied only to known flaky UI transitions and with reporting.

Test data

Hardcoded stable credentials for SauceDemo (standard_user / secret_sauce) because it’s a demo site.

Checkout info uses static values to keep tests deterministic.

## 6. Test Suites & Tagging strategy

Cucumber tags are used to enable selective runs:

@ui — all UI tests

@smoke — quick CI gate suite (login, cart badge, e2e, logout)

@e2e — end-to-end coverage

@negative — negative flows

This supports:

Fast CI runs (@smoke)

Full UI regression (@ui)

Focused debugging (@debug tag can be added temporarily)

## 7. How to run (local & CI)

Local execution

UI tests can be executed via Maven + Cucumber tag filtering

API tests can be executed via Maven -Dtest=...

CI readiness

The project is structured so a CI pipeline can run:

@smoke suite on pull requests

Full @ui suite nightly

API suite as part of PR gate or nightly

## 8. Future considerations (next steps)

Additional UI scenarios

Checkout form validation (missing first name / last name / postal code)

Sorting behavior validation (price low→high, high→low)

Locked-out user flow validation

Inventory item detail page validations

Session behavior (refresh, back/forward navigation)

Additional API scenarios

Expanded schema validation set across multiple endpoints

Negative contract tests (missing required fields)

Response time assertions (non-flaky thresholds)

OpenAPI-based contract tests (if available)

## 9. Automation priorities (if expanding coverage)

Top priorities to automate next:

Checkout validation rules (highest regression risk)

Locked-out user and error messaging (common auth regression)

Sorting (frequent UI regression due to DOM changes)

Item details page (navigation + data integrity)

API schema suite expansion (if real backend exists)
