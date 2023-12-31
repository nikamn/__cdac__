import http from "../http-common";

const getAll = async () => {
  return await http.get("/suppliers");
};

const get = (id) => {
  return http.get(`/suppliers/${id}`);
};

const create = (data) => {
  return http.post("/suppliers", data);
};

const update = (id, data) => {
  return http.put(`/suppliers/edit/${id}`, data);
};

const remove = (id) => {
  return http.delete(`/suppliers/delete/${id}`);
};

const SupplierService = {
  getAll,
  get,
  create,
  update,
  remove,
};

export default SupplierService;
