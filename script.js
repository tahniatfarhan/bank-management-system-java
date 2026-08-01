const customersData = [
    { id: 101, name: "Tahniat Farhan", email: "tahniat@uet.edu.pk", accounts: 2 },
    { id: 102, name: "Ali Ahmed", email: "ali.ahmed@example.com", accounts: 1 },
    { id: 103, name: "Fatima Khan", email: "fatima.k@example.com", accounts: 1 }
];

const accountsData = [
    { accNo: "ACC-90812", customer: "Tahniat Farhan", type: "Savings", balance: "$14,850.00" },
    { accNo: "ACC-90813", customer: "Tahniat Farhan", type: "Checking", balance: "$3,200.50" },
    { accNo: "ACC-44102", customer: "Ali Ahmed", type: "Savings", balance: "$8,920.00" },
    { accNo: "ACC-55219", customer: "Fatima Khan", type: "Checking", balance: "$12,400.00" }
];

function renderCustomers() {
    return `
        <h3><i class="fa-solid fa-users"></i> Registered Bank Customers</h3>
        <table>
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Full Name</th>
                    <th>Email Address</th>
                    <th>Active Accounts</th>
                </tr>
            </thead>
            <tbody>
                ${customersData.map(c => `
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>${c.email}</td>
                        <td>${c.accounts}</td>
                    </tr>
                `).join('')}
            </tbody>
        </table>
    `;
}

function renderAccounts() {
    return `
        <h3><i class="fa-solid fa-wallet"></i> Customer Accounts Overview</h3>
        <table>
            <thead>
                <tr>
                    <th>Account Number</th>
                    <th>Customer Name</th>
                    <th>Account Type</th>
                    <th>Current Balance</th>
                </tr>
            </thead>
            <tbody>
                ${accountsData.map(a => `
                    <tr>
                        <td><code>${a.accNo}</code></td>
                        <td>${a.customer}</td>
                        <td>${a.type}</td>
                        <td><strong>${a.balance}</strong></td>
                    </tr>
                `).join('')}
            </tbody>
        </table>
    `;
}

function renderTransactionDemo() {
    return `
        <h3><i class="fa-solid fa-money-bill-transfer"></i> Transaction Simulator</h3>
        <div style="display: flex; flex-direction: column; gap: 12px; max-width: 400px; margin: 10px 0;">
            <label>Select Account:</label>
            <select id="accSelect" style="padding: 8px; border-radius: 6px; background: #0f172a; color: #fff; border: 1px solid #334155;">
                <option>ACC-90812 (Tahniat Farhan - $14,850.00)</option>
                <option>ACC-90813 (Tahniat Farhan - $3,200.50)</option>
                <option>ACC-44102 (Ali Ahmed - $8,920.00)</option>
            </select>
            <label>Amount ($):</label>
            <input type="number" id="txAmount" value="500" style="padding: 8px; border-radius: 6px; background: #0f172a; color: #fff; border: 1px solid #334155;">
            <div style="display: flex; gap: 10px; margin-top: 10px;">
                <button onclick="performTx('Deposit')" class="gui-btn active" style="flex: 1;">Deposit</button>
                <button onclick="performTx('Withdrawal')" class="gui-btn" style="flex: 1;">Withdraw</button>
            </div>
        </div>
        <div id="txResult" style="margin-top: 15px; font-family: monospace; color: #38bdf8;"></div>
    `;
}

function switchTab(tab) {
    document.querySelectorAll('.gui-btn').forEach(btn => btn.classList.remove('active'));
    event.currentTarget.classList.add('active');
    
    const container = document.getElementById('guiScreen');
    if (tab === 'customers') container.innerHTML = renderCustomers();
    else if (tab === 'accounts') container.innerHTML = renderAccounts();
    else if (tab === 'deposit') container.innerHTML = renderTransactionDemo();
}

function performTx(type) {
    const acc = document.getElementById('accSelect').value.split(' ')[0];
    const amount = document.getElementById('txAmount').value;
    const res = document.getElementById('txResult');
    res.innerHTML = `[SUCCESS] ${type} of $${amount} on ${acc} processed via JDBC DAO Layer!`;
}

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('guiScreen').innerHTML = renderCustomers();
});
