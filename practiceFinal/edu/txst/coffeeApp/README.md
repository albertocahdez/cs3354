# FINAL EXAM: Design Pattern Refactoring

## Description
This Java application allows users to create and customize beverage orders. Currently, the system uses a single, bloated class to handle all beverage types and condiments. The application computes costs based on a base price plus hard-coded logic for attributes.

Your task is to refactor this application using three specific Design Patterns to make the codebase more extensible and maintainable.

## Requirements

### Decorator Pattern

Currently, condiments (e.g., Milk, Mocha, Whip) are handled as boolean attributes within a single Beverage class.

Task: Refactor the design so that each condiment is a Decorator.

Goal: Allow for any combination of condiments to be added to a base beverage dynamically without modifying the base classes.

### Abstract Factory Pattern

The current code instantiates beverages using the new keyword directly in the logic (tight coupling).

Task: Implement an Abstract Factory to handle the creation of the two base beverage types.

Goal: Decouple the client code from the specific concrete classes of the beverages.

### Iterator Pattern

The BeverageOrder class currently exposes its internal collection to compute the total cost.

Task: Modify BeverageOrder to implement the Iterable<Beverage> interface.

Goal: Use the resulting Iterator to traverse the order and compute the total cost, hiding the internal data structure (e.g., ArrayList, LinkedList) from the calculation logic.

## Additional Notes

File Structure: These changes will require creating several new files and modifying existing logic.

GUI Constraint: Do not modify visually the GUI components. The GUI must function exactly as it does now. If your refactoring breaks the GUI's ability to call the necessary methods, points will be deducted.

Code Integrity: Most of the application’s core business logic (prices, names) should remain the same; only the structure and instantiation should change.