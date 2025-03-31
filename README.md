Test Scenario - Fund Transfer
1️⃣ UI Test (Selenium WebDriver)

Log in to the banking application.

Navigate to the "Fund Transfer" section.

Enter beneficiary details and transfer amount.

Submit the transfer request.

Validate success message.

2️⃣ API Test (Rest Assured)

Validate fund transfer via API (POST request).

Check transaction status via API (GET request).

Ensure transaction details are correctly stored.

📂 Project Structure
📦 Bankingfundtransfer
 ┣ 📂 src/test/java
 ┃ ┣ 📂 uifundtransfer (Selenium UI test)
 ┃ ┣ 📂 apifundtransfer (Rest Assured API test)
 ┃ ┣ 📂 utilities (report )
 ┣ 📜 pom.xml (Dependencies)
 ┗ 📜 testng.xml (Test execution file)
 Summary
✅ UI Automation: Fund transfer via Selenium
✅ API Automation: Validate fund transfer via API
✅ Test Execution: Using Maven & TestNG
✅ Logging & Reporting: Extent Reports
