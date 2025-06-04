import React, { useState } from 'react';
import MovieTable from './MovieTable';

function MovieForm() {
  const [movies, setMovies] = useState([]);
  const [form, setForm] = useState({
    movieName: '', actor: '', release: '', type: [], state: ''
  });

  const handleCheckbox = (e) => {
    const { value, checked } = e.target;
    setForm(prev => ({
      ...prev,
      type: checked
        ? [...prev.type, value]
        : prev.type.filter(t => t !== value)
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setMovies([...movies, form]);
    setForm({ movieName: '', actor: '', release: '', type: [], state: '' });
  };

  return (
    <div>
      <h2>Add Movie</h2>
      <form onSubmit={handleSubmit}>
        <input placeholder="Movie Name" value={form.movieName} onChange={(e) => setForm({ ...form, movieName: e.target.value })} required />
        <input placeholder="Actor" value={form.actor} onChange={(e) => setForm({ ...form, actor: e.target.value })} required />
        <input type="date" value={form.release} onChange={(e) => setForm({ ...form, release: e.target.value })} required />
        <div>
          <label><input type="checkbox" value="2D" onChange={handleCheckbox} />2D</label>
          <label><input type="checkbox" value="3D" onChange={handleCheckbox} />3D</label>
          <label><input type="checkbox" value="IMAX" onChange={handleCheckbox} />IMAX</label>
        </div>
        <select value={form.state} onChange={(e) => setForm({ ...form, state: e.target.value })} required>
          <option value="">Select State</option>
          <option>Maharashtra</option>
          <option>Goa</option>
          <option>Punjab</option>
        </select>
        <button type="submit">Add Movie</button>
      </form>

      <MovieTable movies={movies} />
    </div>
  );
}

export default MovieForm;
