import '../styles/App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import { Fruit } from './Fruit';
import MovieForm from './movie.form';

function App() {
  return (
    <Router>
      <div className="container-fluid">
        <div className="row">
          <nav className="col-md-3 col-lg-2 d-md-block bg-light sidebar py-3">
            <ul className="nav flex-column">
              <li className="nav-item">
                <Link to="/movie-form" className="nav-link">Movie Form</Link>
              </li>
              <li className="nav-item">
                <Link to="/fruit" className="nav-link">Fruit</Link>
              </li>
            </ul>
          </nav>

          <main className="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <Routes>
              <Route path="/movie-form" element={<MovieForm />} />
              <Route path="/fruit" element={<Fruit />} />
              <Route path="*" element={<MovieForm />} />
            </Routes>
          </main>
        </div>
      </div>
    </Router>
  );
}

export default App;
