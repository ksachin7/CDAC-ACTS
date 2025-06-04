import React from 'react';

function MovieTable({ movies }) {
  return (
    <div>
      <h3>Movie List</h3>
      <table border="1">
        <thead>
          <tr>
            <th>Movie</th>
            <th>Actor</th>
            <th>Release</th>
            <th>Type</th>
            <th>State</th>
          </tr>
        </thead>
        <tbody>
          {movies.map((m, i) => (
            <tr key={i}>
              <td>{m.movieName}</td>
              <td>{m.actor}</td>
              <td>{m.release}</td>
              <td>{m.type.join(', ')}</td>
              <td>{m.state}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MovieTable;
