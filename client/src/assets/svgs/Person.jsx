import React from "react";

const Person = ({ className }) => {
  return (
    <svg id="icon-user" viewBox="0 0 32 32" className={className}>
      <path d="M18 22.082v-1.649c2.203-1.241 4-4.337 4-7.432 0-4.971 0-9-6-9s-6 4.029-6 9c0 3.096 1.797 6.191 4 7.432v1.649c-6.784 0.555-12 3.888-12 7.918h28c0-4.030-5.216-7.364-12-7.918z"></path>
    </svg>
  );
};

export default Person;