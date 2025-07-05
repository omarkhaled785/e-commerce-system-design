# 🛒 E-Commerce Console System

A simple Java console application that simulates an e-commerce system with support for:
- managing products (including expiry dates and shipping requirements),
- customer shopping carts,
- checkout with stock checks, expiry checks, balance verification,
- and a basic shipping service.

---

## 🚀 Features

✅ **Define products** with:
- Name
- Price
- Quantity
- Optional expiry date
- Optional shipping weight

✅ **Customers can:**
- Add products to their own cart (up to available stock)
- Checkout: paying subtotal + flat shipping fee if applicable
- See remaining balance after purchase

✅ **Supports:**
- Expiry check: will not allow checkout of expired products
- Stock check: cannot add more than available quantity
- Balance check: prevents purchase if customer has insufficient funds
- Shipping service prints all items that require shipping, with total weight

---

## 🧩 Technologies
- Java SE (no external libraries)
- Runs entirely in console / terminal

---

## ⚙️ How to run

1. **Clone or download this repository.**
2. Make sure you have Java installed. Check with:
javac -version

3. Open terminal in the project directory.
4. Compile all Java files at once:
5. Run the program:
## 💡 Example console output

- Shipment notice **
- 10x Cheese 3000g
- Total package weight: 3kg

Checkout receipt **

- 2x Cheese 200
- 1x Card 50
- Subtotal 250
- Shipping 30
- Amount 280
- Remaining Balance: 720

## 🙌 Author
- Built BY OMAR KHALED
- Built for the **Fawry Internship program Task** 
