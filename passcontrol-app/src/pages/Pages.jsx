import React, { useState, useEffect } from "react";

import "./Pages.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Nav from "../components/nav/Nav";

import Home from "./home/Home";
import Follow from "./follow/Follow";
import Manager from "./manager/Manager";

import {
  newPass,
  allNextPass,
  allOldPass,
  nextPass,
  resetPass,
} from "../services/ConnectAPI";

export default function Pages() {
  const [pass, setPass] = useState([]);
  const [listNextPass, setListNextPass] = useState([]);
  const [listOldPass, setListOldPass] = useState([]);
  const [passNext, setPassNext] = useState([]);

  const getNewPass = async (type) => {
    newPass(type).then((response) => {
      setPass(response);
      getAllNextPass();
      getAllOldPass();
    });
  };
  const getAllNextPass = async () => {
    allNextPass().then((response) => {
      setListNextPass(response);
    });
  };
  const getAllOldPass = async () => {
    allOldPass().then((response) => {
      setListOldPass(response);
    });
  };
  const getNextPass = async () => {
    nextPass().then((response) => {
      getAllNextPass();
      getAllOldPass();
      setPassNext(response);
      console.log("pages nextPass", response);
    });
  };
  const deleteAndResetPass = async () => {
    resetPass().then((response) => {
      console.log(response);
    });
  };

  useEffect(() => {}, [pass, listNextPass, listOldPass]);

  return (
    <>
      <BrowserRouter>
        <Nav />
        <div className="Content">
          <Routes>
            <Route
              path="/manager"
              element={
                <Manager
                  service={getNextPass}
                  delete={deleteAndResetPass}
                  nextPassTo={listNextPass}
                  oldPassTo={listOldPass}
                  passNext={passNext}
                />
              }
            />
            <Route
              path="/follow"
              element={
                <Follow nextPassTo={listNextPass} oldPassTo={listOldPass} />
              }
            />
            <Route
              path="/"
              element={<Home service={getNewPass} pass={pass} />}
            />
          </Routes>
        </div>
      </BrowserRouter>
    </>
  );
}
