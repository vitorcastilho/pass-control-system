import React from "react";

import { Link } from "react-router-dom";
import Button from "../button/Button";

export default function Nav() {
  return (
    <nav className="Nav">
      <Link to="/">
        <Button>Retirar Senha</Button>
      </Link>

      <Link to="/follow">
        <Button>Acompanhar Senhas</Button>
      </Link>

      <Link to="/manager">
        <Button>Gerente</Button>
      </Link>
    </nav>
  );
}
