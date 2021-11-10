import React from "react";
import { Link } from "react-router-dom";
import "./headbar.scss";

const HeadBar = () => {
  return (
    <div className="headbar">
      <h1 className="headbar__logo">Excellent Training</h1>
      <Link
        to="/login"
        className="headbar__logout"
        onClick={() => {
          localStorage.clear();
        }}
      >
        Logout
      </Link>
    </div>
  );
};

export default HeadBar;
