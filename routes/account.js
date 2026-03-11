const Account = require("../models/account")

let accounts = []
let idCounter = 1

function createAccount(name) {
    const account = new Account(idCounter++, name)
    accounts.push(account)
    return account
}

function getAccount(id) {
    return accounts.find(acc => acc.id === id)
}

module.exports = {
    createAccount,
    getAccount
}
