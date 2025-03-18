# Monefy Test Charters 
The Monefy app is a budgetting app that allows its user/customers to keep track of their spent and earned amounts. Hence, it is paramount to ensure that the core features of Monefy app, namely,  adding expenses, incomes and accounts work properly.

Using a risk based approach, the following test charters were devised to ensure that the main critical business user journeys are tested.

The priority of the charters are as follows and were ordered based on the Criticality of the business feature tested.

## 1. Adding Expenses and Income amounts 💸

|Item | **Description** |
|   :---   | :--- |
| **Objective** |The goal of this testing session is to validate and verify that users of the Monefy iOS mobile App are able to add and view expenses as well as income amounts using the app.|
| **Scope** |Test that users are able to `add` expenses and income amounts using the main add expense and add income buttons located on the main dashboard of the app.| 
| **Duration** |30 - 45 Minutes.| 
| **Persona** |New or existing customer with iOS app installed| 
| **Resources** |iPhone with the latest Monefy iOS app installed| 
| **Test Approach** |Perform exploratory manual testing by navigating to the the `main dashboard` and tapping on the add expense and add income buttons to navigate to the respective add expense and add income screens.| 
| **Expected Outcome 1** |User is able to add an expense and view the correct updated `expense balance` on the main dashboard.|
| **Expected Outcome 2** |User is able to add an income and view the correct updated `income balance` on the main dashboard.|
| **Expected Outcome 3** |User is able to add multiple expenses and incomes and view the correct `net main balance` on the dashboard.|
| **Test Execution notes** |Ensure that all balances (Main net balance, income balance and expenses balance) are always updated correctly.|
| **Additional Information** |Keep a list of all amounts added and the value of the (Main net balance, income balance and expenses balance) before and after each operation.|
| **Post Test Tasks** |Document test exeuction steps and attach  execution evidence. Create tickets for found bugs and inform stakeholders.|

## 2. Account Management Test Charter 📖

|Item | **Description** |
|   :---   | :--- |
| **Objective** |The goal of this testing session is to validate and verify that users of the Monefy iOS mobile App are able to manage their accounts.|
| **Scope** |Test that users are able to `add` accounts from the **Accounts panel**, `merge` existing accounts and `delete` exisiting accounts| 
| **Duration** |30 - 45 Minutes.| 
| **Persona** |New or existing customer with iOS app installed| 
| **Resources** |iPhone with the latest Monefy iOS app installed| 
| **Test Approach** |Perform exploratory manual testing by navigating to the `Accounts Panel` from the `main dashboard` to add accounts and manage accounts via opening each newly added account.| 
| **Expected Outcome 1** |User is able to add accounts with no or with initial balance.|
| **Expected Outcome 2** |User is able to delete accounts.|
| **Expected Outcome 3** |User is able to merge existing accounts into one account without losing balance information.|
| **Test Execution notes** |Ensure the balances of newly added accounts show up correctly on the main dashboard.|
| **Additional Information** |Keep a list of account names and balances added.|
| **Post Test Tasks** |Document test exeuction with execution evidence. Create tickets for found bugs and inform stakeholders.|

# Bugs 🪲
This section documents a bug found when performing the testing sessions defined in the above Test Charters

## 1. Bug Title: Account Balance lost when merging accounts
**Test Charter reference**: `Account Manamgent Test Charter`

**Preconditions**:
    
    1. Install the Monefy app on an iOS device
    2. Create two accounts with an initial balances as provided in the test data table

**Test data**:
|Account Name | Balance |
|   :---   | :--- |
| **Test Account 1** | 10 EUR|
| **Test Account 2** | 15 EUR|

**Steps to reproduce**:
    
    1. Install the Monefy app on an iOS device
    2. Create two accounts with the test data provided above
    3. Assert that the total income and net balance is 25 EUR
    4. Tap on the overlay icon ==> vertical (...) to open the side panel
    5. On the side panel, tap on `Accounts`
    6. In the accounts list, tap on the second account <Test Account 2>
    7. On the Edit account screen, click on the overlay icon ==> vertical (...)
    8. Tap on **Merge** which will navigate the user back to the Edit account screen
    9. On the Edit account screen, a pop up with the name of the first account is visibile, tap on it. 

**Expected**: 

    1. User lands back on the dashboard, the total net and income balance is = 25 EUR (Balance test account 1 + Balance test account 2)
    2. Test Account 2 is no longer present and mereged in Test Account 1

    
**Actual**: 

    1. User lands back on the dashboard, the total net and income balance is only = 10 EUR
    2. Balance information of account 2 has disappeared and not merged in the balance of account 1
    3. Test Account 2 is no longer present 
**Remark**: Test Account 2 must be merged in to Test Account 1 and all balances should be carried over.

## Risks and Mitigation
|Risk Area | Mitigation |
|   :---   | :--- |
| **Monetary records** | Any monetary records or transactions should be dealt with carefully. The Monefy app only provides local storage of data via .csv files. Thorough testing of various app and device states should be done to ensure  monetary related information is never lost|
| **Localization** | The Monefy app provides various currencies, hence great care must be made by ensuring Localization tools are integrated and used to test different currencies, languages and locale settings|
| **Pop up and animations** | The Monefy app relies on alerts, animations and popups. Visual snapshot testing accross multiple operating systems and form factors must be done to ensure proper functionality|
