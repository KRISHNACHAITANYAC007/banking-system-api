const Transaction = require("../models/transaction")
const { getAccount } = require("./account")

let transactions = []

function deposit(accountId, amount) {
    const account = getAccount(accountId)

    if (!account) {
        throw new Error("Account not found")
    }

    account.deposit(amount)

    const tx = new Transaction(accountId, "DEPOSIT", amount)
    transactions.push(tx)

    return tx
}

function withdraw(accountId, amount) {
    const account = getAccount(accountId)

    if (!account) {
        throw new Error("Account not found")
    }

    account.withdraw(amount)

    const tx = new Transaction(accountId, "WITHDRAW", amount)
    transactions.push(tx)

    return tx
}

function getTransactions(accountId) {
    return transactions.filter(tx => tx.accountId === accountId)
}

module.exports = {
    deposit,
    withdraw,
    getTransactions
}
