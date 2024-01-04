const btn = document.getElementById("btn");
const task = document.getElementById("task");
const list = document.getElementById("list");

window.addEventListener("DOMContentLoaded", setupItems);


// console.log(list);
btn.addEventListener("click", addTask);

function addTask() {

    const items = getLocalStorage() ?? 0;
    const id = items.length + 1;
    const value = task.value;
    createTask(id, value);
    addToLocalStorage(id, value);
    task.value = "";

}
function createTask(id, value) {
  console.log(list);
  console.log(task.value);
  const element = document.createElement("li");

  const attr = document.createAttribute("data-id");
  attr.value = id;
  element.setAttributeNode(attr);
  element.innerHTML = `${value}
    
      <button type="button" class="edit-btn">
        <i class="fas fa-edit"></i>
      </button>
  
      <button type="button" class="delete-btn">
        <i class="fas fa-trash"></i>
      </button>
    
    `;

  const deleteBtn = element.querySelector(".delete-btn");
  deleteBtn.addEventListener("click", deleteItem);
  const editBtn = element.querySelector(".edit-btn");
  editBtn.addEventListener("click", editItem);

  list.appendChild(element);
}
function deleteItem(e) {
  console.log("delete");

  console.log(e.currentTarget);
  const element = e.currentTarget.parentElement;
  const id = element.dataset.id;
  //   console.log("ghsds " + id);
  list.removeChild(element);
  removeFromLocalStorage(id);
}
function editItem(e) {
  
const element = e.currentTarget.parentElement;
  let id = element.dataset.id;
  element.className="done";
  
 
}

//local storage functions

function addToLocalStorage(id, value) {
  const storedList = { id, value };
  let items = getLocalStorage();
  items.push(storedList);
  console.log(items);
  localStorage.setItem("list", JSON.stringify(items));
}

function removeFromLocalStorage(id) {
  let items = getLocalStorage();
  console.log(items, id);
  items = items.filter(function (item) {
    if (item.id != id) {
      console.log("matched");
      return item;
    }
    console.log("filter");
  });
  console.log(items, id);
  localStorage.setItem("list", JSON.stringify(items));
}
function getLocalStorage() {
  return localStorage.getItem("list")
    ? JSON.parse(localStorage.getItem("list"))
    : [];
}

function setupItems() {
  let items = getLocalStorage();
  if (items.length > 0) {
    items.forEach(function (item) {
      createTask(item.id, item.value);
    });
  }
}
