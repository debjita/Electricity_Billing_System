# Electricity_Billing_System

An end to end, user friendly electricity billing system to aid the ease of access of a user in viewing, updating and paying bills at the comfort of their homes. 
Technologies Used: Java Core, Swing, MySQL, JDBC 
OBJECTIVE
Log In/Sign Up to the application to access all the functionalities such as viewing bill summaries, paying the bill at the comfort of your home, etc.
Tables/Components: 
(i)	login – Stores details of all the admins/customers who will sign up for the application. 
(ii)	customer – Stores personal information of all the registered customers.
(iii)	bill – Keeps track of the information of the customers and their payment status. 
(iv)	meter_info – Keeps information related to the meter number of a user.
(v)	Tax: Stores information regarding the taxes added on the final bill .

FUNCTIONS
The entire execution of the project Electricity Billing System starts from Signup.java .
1.Signup:
This is to create an account either as a customer or as an admin. Customers whose information already exists in the database can use this feature to create an account.
Admin can create an account using the option admin in the dropdown.
After creating an account this page will lead to a Login page .

2.Login 
To log in to an already existing account, by giving valid account username and password, wrong credentials will pop a warning message up. This page inquires whether to enter as an admin or as a customer.

3.Home Page (Logged in as an admin)
Manage: To create, view, update details of customers and to maintain proper information about them in the database.
  New Customer: To add information about a Customer.
  Customer Details: To look over the details of the Customer associated with the company.
  Deposit Details: To know the monthly payment status of the customers.
  Calculate Bill: To calculate the bill as per the units consumed by the customer.
  Utility: To access resources such as the web browser, notepad and calculator.
  Logout: To Log out of the application when necessary actions have been performed.

4.Home Page (Logged in as Customer)
  Information: To update and view Information of the Customer.
  User: To View the details of the monthly bill and to pay the bill.
  Report: Generates a detailed report about the divisions and variations of a monthly bill.
  Utility and logout same as that in admin’s home page.

INSTRUCTIONS
Open Electricity_Billing_System package as a Java Project in any of the IDEs (VS Code/NetBeans/Eclipse) for better experience.
Run Signup.java (as implementation starts from this point)












