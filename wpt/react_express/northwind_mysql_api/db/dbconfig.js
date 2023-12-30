const mysql = require("mysql2");

const conn = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "root",
  database: "Northwind",
  port: 3306,
});

conn.connect((err) => {
  if (err) {
    console.log(`Database connection failed: `, err);
  } else {
    console.log(`Database connected successfully`);
  }
});

module.exports = conn;
