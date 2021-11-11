import React, { useState, useEffect } from "react";

import pass from "../../data/pass";

export default function Following(props) {
  const [nextPass, setNextPass] = useState([]);
  const [oldPass, setOldPass] = useState([]);
  const [actualPass, setActualPass] = useState([]);

  nextPass !== props.nextPass && setNextPass(props.nextPass);
  oldPass !== props.oldPass && setOldPass(props.oldPass);
  actualPass !== props.actualPass && setActualPass(props.actualPass);

  useEffect(() => {
    console.log("nextPass>>>", nextPass);
    console.log("oldPass>>>", oldPass);
    console.log("actualPass >>>", actualPass);
  }, [nextPass, oldPass]);

  return (
    <div className="Follow">
      <div className="actual-pass">
        <div className="call-pass">
          <h1 className="title">Próximas</h1>
          <ul className="list" style={{ listStyle: "none" }}>
            {pass.map((pass) => {
              return <li key={pass.id}>{pass.pass}</li>;
            })}
          </ul>
        </div>
        <div className="pass">
          <h2>Atual</h2>
          {actualPass ? (
            <h1>{actualPass}</h1>
          ) : (
            <p style={{ fontSize: "1rem" }}>
              Aguardando Próxima senha ser gerada!
            </p>
          )}
        </div>
      </div>

      <div className="last-pass">
        <h3>Já chamadas</h3>
        <ul style={{ listStyle: "none" }}>
          {pass.map((pass) => {
            return <li key={pass.id}>{pass.pass}</li>;
          })}
        </ul>
      </div>
    </div>
  );
}
