import React, { useState } from 'react';

function ArithmeticForm() {
  const [num1, setNum1] = useState('');
  const [num2, setNum2] = useState('');
  const [result, setResult] = useState(null);

  const calculate = (op) => {
    const a = parseFloat(num1);
    const b = parseFloat(num2);
    if (isNaN(a) || isNaN(b)) return;

    switch (op) {
      case '+': setResult(a + b); break;
      case '-': setResult(a - b); break;
      case '*': setResult(a * b); break;
      case '/': setResult(b !== 0 ? a / b : 'Cannot divide by zero'); break;
    }
  };

  return (
    <div>
      <h2>Arithmetic Operations</h2>
      <input type="number" value={num1} onChange={(e) => setNum1(e.target.value)} placeholder="First number" />
      <input type="number" value={num2} onChange={(e) => setNum2(e.target.value)} placeholder="Second number" />
      <div className='btn-group' role="group">
        <button onClick={() => calculate('+')}>Add</button>
        <button onClick={() => calculate('-')}>Subtract</button>
        <button onClick={() => calculate('*')}>Multiply</button>
        <button onClick={() => calculate('/')}>Divide</button>
      </div>
      {result !== null && <p>Result: {result}</p>}
    </div>
  );
}
export default ArithmeticForm;
