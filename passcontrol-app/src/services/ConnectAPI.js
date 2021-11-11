import axios from "axios";

const url = "http://www.localhost:8080/";

export const newPass = (type) =>
  axios.post(url + "pass/new", { type: type }).then((response) => {
    return response.data;
  });

export const allNextPass = () =>
  axios.get(url + "pass").then((response) => {
    return response.data;
  });

export const allOldPass = () =>
  axios.get(url + "pass/old").then((response) => {
    return response.data;
  });

export const nextPass = () =>
  axios.get(url + "manager/next-pass").then((response) => {
    console.log("api nextPass", response.data);
    return response.data;
  });

export const resetPass = () =>
  axios.delete(url + "manager/reset-pass").then((response) => {
    return response.data;
  });
