const express = require("express");

const db = require("./config/db");
const User = db.User;

const apiRouter = express.Router();

apiRouter.get("/users", async (req, res, next) => {
  try {
    const users = await User.findAll();
    res.status(200).json({ users: users });
  } catch (error) {
    console.error(error);
    res.sendStatus(500);
  }
});

apiRouter.get("/users/:userId", async (req, res) => {
  try {
    const user = await User.findByPk(req.params.userId);
    res.status(200).json({ user: user });
  } catch (error) {
    console.error(error);
    res.sendStatus(404);
  }
});

apiRouter.post("/users", async (req, res) => {
  try {
    const user = await User.create({ ...req.body });
    console.log(user);
    res.status(201).json("user created successfully @...!");
  } catch (error) {
    console.error(error);
    res.sendStatus(400);
  }
});

apiRouter.put("/users/edit/:userId", async (req, res) => {
  try {
    const user = await User.update(
      { ...req.body },
      { where: { id: req.params.userId } }
    );
    console.log(user);
    res.status(200).json("user updated successfully @...!");
  } catch (error) {
    console.error(error);
    res.sendStatus(400);
  }
});

apiRouter.delete("/users/delete/:userId", async (req, res) => {
  try {
    const response = await User.destroy({ where: { id: req.params.userId } });
    console.log(response);
    res.status(200).json(`user ${req.params.userId} deleted successfully`);
  } catch (error) {
    console.log(error);
    res.sendStatus(500);
  }
});

module.exports = apiRouter;
