# Store Management System

A Java-based Store Management System developed to practice Object-Oriented Programming (OOP), file handling, and basic store operations.

## Features

- Add products to the store
- Support different product types:
  - Clothing
  - Electronics
- Search for products
- Remove products
- Manage product stock
- Create customers
- Create customer orders
- Add products and quantities to orders
- Validate available stock
- Calculate order total price
- Process payments
- Checkout orders
- Save products to a text file
- Load products from a text file

## OOP Concepts Used

This project applies several Object-Oriented Programming concepts:

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Composition
- Classes and Objects
- Constructors
- Getters and Setters

## Project Structure

- `Product.java` - Base product class
- `Clothing.java` - Clothing product subclass
- `Electronics.java` - Electronics product subclass
- `Store.java` - Manages products and store operations
- `Customer.java` - Represents customers
- `Order.java` - Manages customer orders
- `OrderItem.java` - Represents a product and quantity inside an order
- `Payment.java` - Handles payment operations
- `FileManager.java` - Saves and loads product data
- `Main.java` - Runs the application and user menu

## Data Persistence

Product data is stored locally using a text file.

The `FileManager` class is responsible for:

- Saving products to `products.txt`
- Loading saved products when the program runs
- Recreating Clothing and Electronics objects from stored data

The `products.txt` file is ignored by Git because it contains runtime data.

## Technologies

- Java
- Object-Oriented Programming
- Java Collections (`ArrayList`)
- File I/O
- Git
- GitHub
- IntelliJ IDEA

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Make sure Java is installed.
4. Run `Main.java`.
5. Use the console menu to interact with the Store Management System.

## Purpose

This project was created as a practical Java OOP project to strengthen programming fundamentals and practice building a complete application using multiple interacting classes, file persistence, and Git version control.
