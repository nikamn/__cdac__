import http from "../http-common";

const getAll = () => {
    return http.get("/suppliers");
}

const get = (id) => {
    return http.get(`/suppliers/${id}`);
}

const create = (data) => {
    return http.post("/suppliers", data);
}

const update = (id, data) => {
    return http.put(`/suppliers/${id}`, data);
}

const remove = (id) => {
    return http.delete(`/suppliers/${id}`);
}

const SupplierService = {
    getAll, get, create, update, remove
}

export default  SupplierService();