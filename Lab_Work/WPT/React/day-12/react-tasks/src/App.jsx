import React from 'react';
import './App.css';

import A from './components/A';
import B from './components/B';
import C from './components/C';
import ArithmeticForm from './components/ArithmeticForm';
import FruitList from './components/FruitList';
import MovieForm from './components/MovieForm';

function App() {
  return (
    <div className="container">
      <h1 className="main-title">Component Trees Demo</h1>

      <div className="section">
        {/* (a) A ← B ← C : Done in component nesting */}
        {/* <A /> */}

        {/* (b) Use B and C in A, Use A in App */}
        {/* <A /> */}

        {/* (c) Use A and B and C in App */}
        {/* <A /><B /><C /> */}

        {/* (d) Use A in B and C, Use B and C in App */}
        <B />
        <C />
      </div>

      <div className="section">
        <ArithmeticForm />
      </div>

      <div className="section">
        <FruitList />
      </div>

      <div className="section">
        <MovieForm />
      </div>
    </div>
  );
}

export default App;
