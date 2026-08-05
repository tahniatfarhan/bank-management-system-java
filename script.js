document.addEventListener('DOMContentLoaded', () => {
    let currentBalance = 5420.00;
    const balanceDisplay = document.getElementById('balance-display');
    const txnTypeSelect = document.getElementById('txn-type');
    const txnAmountInput = document.getElementById('txn-amount');
    const btnExecute = document.getElementById('btn-execute-txn');
    const ledgerList = document.getElementById('ledger-list');
    btnExecute.addEventListener('click', () => {
        const type = txnTypeSelect.value;
        const amount = parseFloat(txnAmountInput.value);
        if (isNaN(amount) || amount <= 0) return;
        if ((type === 'withdraw' || type === 'transfer') && amount > currentBalance) return;
        let sign = '';
        if (type === 'deposit') { currentBalance += amount; sign = '+'; }
        else { currentBalance -= amount; sign = '-'; }
        balanceDisplay.textContent = '$' + currentBalance.toFixed(2);
        const item = document.createElement('div');
        item.className = 'ledger-item';
        item.innerHTML = `<div>${type.toUpperCase()}</div><div>${sign}$${amount.toFixed(2)}</div>`;
        ledgerList.insertBefore(item, ledgerList.firstChild);
    });
});