# Design class diagram for a Restaurant Management System

## Requirements:

1. A restaurant has a name, an address, cuisines served, menu, waiters, chefs.
2. Cuisines can be Italian, French, Chinese, Japanese, Indian, Continental etc.
3. A menu contains a list of dishes divided into multiple sections like Soups, Appetizers etc.
4. A dish has a name, description, type (veg / non-veg / vegan), price, a recipe for the chefs to follow.
5. A dish also has a list of ingredients and its amount required to cook the dish.
6. Ingredients can be measured either in grams for solids or ml (mililitres) for liquids/semiliquids.
7. A waiter has a name, email, phone number and level (Junior, Senior, Manager).
8. A chef has a name, email, phone number and level (Commis Chef, Sous chef, Head Chef, Executive chef).
9. We need to track orders made by customers during their visit so that we can generate a bill at the end. Note:
   customer during a visit will order multiple times and each time an order can contain multiple dishes in it.

## Restaurant

- name
- address
- List<CuisineType> cuisines
- Menu menu
- List<Waiter> waiters
- List<Chef> chefs

## << CuisineType >> enumeration

- Italian
- French
- Chinese
- Japanese
- Indian
- Continental

## Menu

- List<Soup> soups
- List<Appetizer> appetizers
- List<MainCourse> mainCourses
- List<Bread> breads
- List<Dessert> desserts

## << DishType >> enumeration

- veg
- non-veg
- vegan

## abstract class Dish

- name
- description
- DishType type
- price
- recipe
- List<HashMap<Ingredient, Double>> ingredients

## abstract classes Soup, Appetizer, MainCourse, Bread, Dessert

## Each Dish class extends abstract classes Soup, Appetizer, MainCourse, Bread, Dessert

## << IngredientType >> enumeration

- solids
- liquids
- semiliquids

## Ingredient

- name
- IngredientType type
- Double amount

## << WaiterLevel >> enumeration

- Junior
- Senior
- Manager

## Waiter

- name
- email
- phone number
- WaiterLevel level

## << ChefLevel >> enumeration

- Commis Chef
- Sous chef
- Head Chef
- Executive chef

## Chef

- name
- email
- phone number
- ChefLevel level

## Customer

- name
- email

## CustomerSession

- Customer customer
- Restaurant restaurant
- List<Order> orders

## Order

- List<Dish> dishes

## << BillStatus >> enumeration

- Paid
- Unpaid

## << PaymentMode >> enumeration

- Cash
- Card

## Bill

- CustomerSession session
- Double totalPrice
- BillStatus status
- PaymentMode paymentMode
- date
