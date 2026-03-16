import { useState } from "react";
import { reloadPage } from "../utils/browser";

function AddItem() {
  const [itemName, setItemName] = useState("");

  function addClicked(event) {
    event.preventDefault();

    fetch(`http://localhost:8080/items/${itemName}`, {
      method: "POST"
    }).then((response) => {
      console.log(response);
      reloadPage();
    });
  }

  return (
    <>
      <h3>Add Item</h3>
      <form className="row">
        <div className="col-6">
          <input
            type="text"
            className="form-control"
            placeholder="Itemname"
            value={itemName}
            onChange={(e) => setItemName(e.target.value)}
          />
        </div>
        <div className="col-6">
          <button className="btn btn-primary" onClick={addClicked}>
            Add
          </button>
        </div>
      </form>
    </>
  );
}

export default AddItem;
