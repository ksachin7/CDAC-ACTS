import { useState, useEffect } from "react";
import { ImCross } from "react-icons/im";

export const Fruit = () => {
  const [fruits, setFruits] = useState([]);
  const [fruitInput, setFruitInput] = useState("");
  const [message, setMessage] = useState('');
  const [showFruits, setShowFruits] = useState(false);

  // useEffect(()=>{
  //   getFruits();
  // }, [])

  function save() {
    // if (fruitInput.trim() !== "") setFruits((oldFruits) => [...oldFruits,fruitInput]);
    // debugger
    if (!fruitInput.trim()) {
      console.log("Fruit name is empty. Skipping save.");
      return;
    }
    console.log(fruitInput);
    // fetch(`http://localhost:3000/save?${fruitInput}`, {
    fetch(`http://localhost:3000/save`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name: fruitInput }), // Send fruitInput as JSON
    })
      .then((res) => {
        if (!res.ok) {
          throw new Error("Failed to save fruit");
        }
        return res.json();
      })
      .then((msg) => {
        console.log(msg);
        setFruitInput("");
        // getFruits();
        setMessage(msg);
        // Clear the message after 1 second
        setTimeout(() => {
          setMessage("");
        }, 3000);
      })
      .catch((err) => console.error(err));
  }

  const deleteFruit = (name) => {
    fetch('http://localhost:3000/delete', {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name }),
    })
      .then(res => res.json())
      .then(data => {
        console.log(data);
        // Optionally refresh the fruit list after deletion
        getFruits();
      })
      .catch(err => console.error(err));
  };

  const getFruits = () => {
    fetch("http://localhost:3000/fruits")
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch fruits");
        return res.json();
      })
      .then((data) => {
        console.log("Fetched fruits:", data);
        // Defensive: if received data is array, set directly, else try to find array property 'fruits'
        if (Array.isArray(data)) {
          setFruits(data);
        } else if (data && Array.isArray(data.fruits)) {
          setShowFruits(true)
          showFruits && setFruits(data.fruits);
        } else {
          console.error("Unexpected fruits data structure", data);
          setFruits([]);
        }
      })
      .catch((err) => {
        console.error("Fetch error:", err);
        setFruits([]);
      });
  };

  const toggleFruits = () => {
    if (!showFruits) {
      getFruits()
    }
    setShowFruits(!showFruits)
  }

  return (
    <>
      <div className="container py-5">
        <div className="row">
          <div className="col-md-4">
            <h2>Fruit</h2>
            <input
              className="form-control"
              type="text"
              name="fruit"
              id="fruit"
              placeholder="Enter a fruit name"
              value={fruitInput}
              onChange={(e) => setFruitInput(e.target.value)}
            />
            <button
              className="btn btn-success my-2"
              type="submit"
              onClick={save}
            >
              Save
            </button>
            {message && <p className="text-success">{message}</p>}
          </div>
          <div className="col-md-8 px-5">
            <h2>Fruits List</h2>
            <button className="btn btn-warning" onClick={toggleFruits}>
              {showFruits ? 'Hide Fruits' : 'Show Fruits'}
            </button>
            {showFruits && (
              <ul className="list-unstyled py-3">
                {fruits.map((fruit, idx) => (
                  <li
                    key={idx}
                    className="d-flex justify-content-between align-items-center py-2"
                    style={{ width: '150px', borderBottom: '1px solid #eee' }}
                  >
                    <span style={{ overflow: 'hidden', textOverflow: 'ellipsis' }}>
                      {fruit}
                    </span>
                    <span
                      role="button"
                      style={{ cursor: 'pointer', color: '#dc3545' }}
                      onClick={() => deleteFruit(fruit)}
                    >
                      <ImCross />
                    </span>
                  </li>
                ))}
              </ul>
            )}
          </div>
        </div>
      </div>
    </>
  );
};
