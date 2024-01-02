const contacts = [
  {
    fname: "abhijeet",
    lname: "singh",
    address: "near hadapsar",
    pin: "1213",
  },
  {
    fname: "dipak",
    lname: "gore",
    address: "near cdac",
    pin: "142134",
  },
];

const getAllContacts = () => {
  return contacts;
};

const addContact = (user) => {
  contacts.push(user);
};

const userService = { getAllContacts, addContact };
export default userService;
