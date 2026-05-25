# Restaurant Inventory Management System (Java)

## Overview
This project is a console-based restaurant inventory management system built in Java. It allows users to manage menu items including food and drink products through a menu-driven interface. The system demonstrates object-oriented programming principles such as inheritance, polymorphism, encapsulation, and file I/O for persistent data storage.

Users can add, remove, search, display, and save menu items to a file, simulating a real-world restaurant inventory system.

---

## Features
- Add food and drink menu items
- Remove items by ID
- Search for items by ID
- List all menu items
- Save inventory to a file
- Load inventory from a file at startup
- Track item price and quantity
- Display detailed item information
- Menu-driven console interface
- Input validation for numeric fields

---

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Inheritance and Polymorphism
- Abstract Classes (MenuItem base structure)
- File I/O (BufferedReader, FileWriter, PrintWriter)
- Exception Handling
- Scanner for user input

---

## Project Structure
src/
├── RestaurantApp.java
├── RestaurantInventory.java
├── MenuItem.java
├── FoodItem.java
├── DrinkItem.java

data/
└── restaurantInventory.csv


---

## Concepts Demonstrated
- Encapsulation of menu item data
- Inheritance (FoodItem and DrinkItem extending MenuItem)
- Polymorphism (handling different item types through a shared base class)
- File persistence using CSV format
- Menu-driven application design
- Input validation and error handling
- Object-oriented system design

---

## How It Works
1. The program starts and loads existing inventory from a CSV file
2. The user is presented with a menu of options
3. The user can:
   - Add new food or drink items
   - Search for items by ID
   - Remove items from inventory
   - View all items in the system
   - Save updates to the CSV file
4. The program continues running until the user chooses to quit
5. All changes are saved for future use

---

## Example Menu

Menu:

1. List all menu items
2. Find a menu item
3. Add a menu item
4. Remove a menu item
5. Save menu items
6. Quit

---

## What I Learned
- How to design multi-class Java applications
- How inheritance simplifies real-world modeling
- How to use file I/O for persistent data storage
- How to structure a menu-driven program
- How polymorphism improves code flexibility
- How to validate and safely process user input

---

## Future Improvements
- Add database support (MySQL or SQLite)
- Add graphical user interface (JavaFX or Swing)
- Add order processing system
- Add customer billing and receipts
- Improve search with partial matching
- Add user roles (admin vs staff)

---

## Author
Lazaro Ramos
