import React, { useState } from 'react';

function FruitList() {
  const [fruit, setFruit] = useState('');
  const [fruits, setFruits] = useState([]);

  const addFruit = (e) => {
    e.preventDefault();
    if (fruit.trim()) {
      setFruits([...fruits, fruit.trim()]);
      setFruit('');
    }
  };

  return (
    <div>
      <h2>Fruit List</h2>
      <form onSubmit={addFruit}>
        <input value={fruit} onChange={(e) => setFruit(e.target.value)} placeholder="Enter fruit name" />
        <button type="submit">Add</button>
      </form>
      <ul>
        {fruits.map((f, i) => <li key={i}>{f}</li>)}
      </ul>
    </div>
  );
}
export default FruitList;
