const { createAccount } = require("./routes/account")
const { deposit, withdraw, getTransactions } = require("./routes/transaction")

const acc = createAccount("Krishna")

deposit(acc.id, 5000)
withdraw(acc.id, 2000)

console.log(getTransactions(acc.id))
