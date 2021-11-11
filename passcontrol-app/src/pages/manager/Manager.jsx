import React, { useState, useEffect } from "react";
import "./Manager.css";

import Card from "../../components/Card/Card";
import Button from "../../components/button/Button";
import pass from "../../data/pass";

import Following from "../../components/following/Following";

export default function Manager(props) {
  const [actualPass, setActualPass] = useState([]);

  useEffect(() => {}, [props.nextPass, props.oldPass, props.passNext]);

  return (
    <Card title="Chamar">
      <div className="manager">
        <div className="call-next">
          <Button
            onClick={function (e) {
              props.service();
            }}
          >
            Solicitar Próxima Senha
          </Button>
          {/* <h2>{props.passNext}</h2> */}
          <Button
            onClick={function (e) {
              props.delete();
            }}
          >
            Reiniciar Senhar
          </Button>
        </div>
        <hr />
        <Following pass={pass} actualPass={props.passNext} />
      </div>
    </Card>
  );
}
