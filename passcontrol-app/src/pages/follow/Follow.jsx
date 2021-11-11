import React, { useState, useEffect } from "react";
import "./Follow.css";

import Card from "../../components/Card/Card";

import Following from "../../components/following/Following";

export default function Follow(props) {
  return (
    <Card title="Acompanhento das senhas">
      <Following nextPass={props.nextPassTo} oldPass={props.oldPassTo} />
    </Card>
  );
}
