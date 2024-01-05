const config = require("./db.config");

const mysql = require("mysql2/promise");

const Sequelize = require("sequelize");

module.exports = db = {};

async function initialize() {
  try {
    // first action: creat db pool
    const { host, port, user, password, database, dialect } = config.database;

    const pool = mysql.createPool({ host, port, user, password });

    pool
      .query(`CREATE DATABASE IF NOT EXISTS \`${database}\`;`)
      .then(() => {
        console.log("created database successfully @...!");
      })
      .catch((error) => {
        console.log("Error occurred while creating table: ", error);
      });

    // second action: connect to db using Sequelize
    const sequelize = new Sequelize(database, user, password, {
      host: host,
      dialect: dialect,
      pool: {
        max: config.pool.max,
        min: config.pool.min,
        acquire: config.pool.acquire,
        idle: config.pool.idle,
      },
    });

    db.sequelize = sequelize;

    sequelize
      .authenticate()
      .then(() => {
        console.log("Connection has been established successfully @...!");
      })
      .catch((error) => {
        console.error("Unable to connect to the database: ", error);
      });

    // third action: init the User model and add it to exported db object
    db.User = require("../models/user.model.js");
    db.Contact = require("../models/contact.model.js");
    // sync all models with database
    sequelize
      .sync()
      .then(() => {
        console.log("Created tables created successfully @...!");
      })
      .catch((error) => {
        console.error("Unable to create table : ", error);
      });
  } catch (error) {
    console.error(error);
  }
}

initialize();
