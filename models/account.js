class Account {
    constructor(id, name, balance = 0) {
        this.id = id
        this.name = name
        this.balance = balance
    }

    deposit(amount) {
        this.balance += amount
    }

    withdraw(amount) {
        if (amount > this.balance) {
            throw new Error("Insufficient balance")
        }
        this.balance -= amount
    }
}

module.exports = Account
