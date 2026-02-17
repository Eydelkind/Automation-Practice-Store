# Automation Practice Store – UI Test Automation Project

This project contains automated UI tests for the Automation Practice Store demo e-commerce application:

https://automationteststore.com/

The goal of this project is to demonstrate practical UI automation skills using Java, Selenium WebDriver, and TestNG with a clean Page Object Model architecture.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- PageFactory
- WebDriverWait (Explicit Waits)

---

## Project Structure

src/test/java
- base – BaseTest and BasePage classes
- pages – Page Object classes
- tests – Test classes

src/test/resources
- config.properties
- testng.xml

---

## Test Coverage

### Authentication
- Successful login
- Login with invalid credentials
- Logout flow (hover menu interaction)

### Registration
- Successful account creation
- Attempt to register with an already existing email
- Validation of error messages

### Products & Catalog
- Products are displayed on the home page
- Product details page opens correctly
- Validation of description of the product on details page

### Cart
- Add product to cart
- Remove product from cart
- Cart counter updates correctly
- Cart page header validation

### Checkout
- Checkout requires login for unauthenticated users
- Checkout flow validation according to application behavior

---

## Key Automation Practices

- Explicit waits instead of Thread.sleep()
- Stable and semantic locators (avoiding brittle XPath)
- Validation of dynamic UI behavior (cart counter changes)
- Handling hover-based dropdown menus using Actions
- Controlled fallback to JavaScript click where required
- String sanitization before numeric parsing (e.g., removing currency symbols)

---

## How to Run Tests

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run:

