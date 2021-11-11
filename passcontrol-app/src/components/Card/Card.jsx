import React from "react";
import "./Card.css";

export default function Card(props) {
  return (
    <div className="Card">
      <h1 className="Title">{props.title}</h1>
      <div className="Content-card">{props.children}</div>
    </div>
  );
}
