# SauceDemo QA Automation Test Plan

## 1. Overview
This document outlines the functional and end-to-end test plan for SauceDemo (https://www.saucedemo.com) as part of the QA Automation & Testing Lead assignment. It includes validation for login flows, product page integrity, UI elements, user-specific behavior, and E2E checkout flows for various user personas.

## 2. Test Categories & Scenarios

| Test Case ID | Description                                 | Type       | Expected Result                                                |
|--------------|---------------------------------------------|------------|----------------------------------------------------------------|
| TC01 | Click login with no credentials | Negative | Error: 'Username is required' + field-level errors |
| TC02 | Login with standard_user and correct password | Positive | Redirect to Products page |
| TC03 | Login with standard_user and no password | Negative | Error: 'Password is required' |
| TC04 | Login with standard_user and incorrect password | Negative | Error: 'Username and password do not match' |
| TC05 | Login with locked_out_user | Negative | Error: 'Sorry, this user has been locked out.' |
| TC06 | Login with problem_user | Positive | Login success; all product images are the same (bug) |
| TC07 | Login with performance_glitch_user | Positive | Login success after delay (~5s) |
| TC08 | E2E flow with performance_glitch_user | E2E | Checkout: Complete! |
| TC09 | Login with error_user | Positive | Landing page validations pass |
| TC10 | E2E flow with error_user | E2E | 503 error on Checkout finish step |
| TC11 | Login with visual_user | Positive | Wrong image on product + misaligned cart |
| TC12 | E2E flow with visual_user | E2E | Checkout button misplaced; flow completes successfully |
| TC13 | Standard user full E2E flow | E2E | Checkout: Complete! |
| TC14 | Validate all Products Page UI components | UI | All expected elements present and functional |
| TC15 | Validate Your Cart Page UI components | UI | All expected elements present and functional |
| TC16 | Validate Checkout: Your Information Page | UI | All expected elements present and functional |
| TC17 | Validate Checkout: Overview Page | UI | All expected elements present and functional |
| TC18 | Validate Checkout: Complete Page | UI | Thank you message shown |
| TC19 | Validate Hamburger menu items | UI | All Items, About, Logout, Reset App State present |
| TC20 | Filter by Name (A to Z) | Functional | Product order is alphabetical ascending |
| TC21 | Filter by Name (Z to A) | Functional | Product order is alphabetical descending |
| TC22 | Filter by Price (low to high) | Functional | Product order from lowest to highest price |
| TC23 | Filter by Price (high to low) | Functional | Product order from highest to lowest price |
