import React from "react";
import "./Home.css";
import Button from "../../components/button/Button";

import Card from "../../components/Card/Card";

export default function Home(props) {
  return (
    <div className="Content">
      <Card title="Nova Senha">
        <div className="new-pass">
          <Button
            onClick={function (e) {
              props.service("N");
            }}
          >
            1 - Normal
          </Button>
          <Button
            onClick={function (e) {
              props.service("P");
            }}
          >
            2 - Preferêncial
          </Button>
        </div>
        <h2>{props.pass}</h2>
      </Card>
    </div>
  );
}
