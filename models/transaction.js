class Transaction {
    constructor(accountId, type, amount) {
        this.accountId = accountId
        this.type = type
        this.amount = amount
        this.date = new Date()
    }
}

module.exports = Transaction
