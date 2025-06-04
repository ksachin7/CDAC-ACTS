import { useState } from "react";

function MovieForm() {
  const [movieData, setMovieData] = useState([]);

  function save(e) {
    e.preventDefault();

    let movie_name = e.target.Name.value;
    let actors = e.target.actors.value;
    let released = e.target.released.value;

    let checkboxes = document.querySelectorAll(
      "input[name='check_type']:checked"
    );
    let type = Array.from(checkboxes)
      .map((cb) => cb.value)
      .join(", ");

    let lang =
      document.querySelector("input[name='language']:checked")?.value || "N/A";
    let rawRuntime = e.target.runtime.value;
    let runtime = rawRuntime
      ? new Date(rawRuntime).toLocaleString("en-US", {
          dateStyle: "medium",
          timeStyle: "short",
        })
      : "N/A";

    const newMovie = { movie_name, actors, released, type, lang, runtime };
    setMovieData((prevMovies) => [...prevMovies, newMovie]);

    console.log(movieData);
    e.target.reset();
  }

  return (
    <>
      <div className="container my-5 bg-white bg-gradient">
        <div className="row">
          <div className="col-md-5" style={{ maxWidth: "700px" }}>
            <h1 className="text-center mb-4">Movies</h1>

            <form
              id="form-data"
              className="bg-light bg-gradient border p-5 rounded shadow "
              action="/submit"
              method="POST"
              onSubmit={save}
            >
              <div className="mb-3">
                <label htmlFor="name" className="form-label">
                  Name
                </label>
                <input
                  type="text"
                  name="Name"
                  id="name"
                  className="form-control"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="actors" className="form-label">
                  Actors
                </label>
                <input
                  type="text"
                  name="actors"
                  id="actors"
                  className="form-control"
                />
              </div>

              <div className="mb-3">
                <label htmlFor="released" className="form-label">
                  Released
                </label>
                <input
                  type="text"
                  name="released"
                  id="released"
                  className="form-control"
                />
              </div>

              <div className="mb-3">
                <label className="form-label d-block">Movie Type</label>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    name="check_type"
                    value="2D"
                    id="2D"
                  />
                  <label className="form-check-label" htmlFor="2D">
                    2D
                  </label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    name="check_type"
                    value="3D"
                    id="3D"
                  />
                  <label className="form-check-label" htmlFor="3D">
                    3D
                  </label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    name="check_type"
                    value="IMAX"
                    id="IMAX"
                  />
                  <label className="form-check-label" htmlFor="IMAX">
                    IMAX
                  </label>
                </div>
              </div>

              <div className="mb-3">
                <label className="form-label d-block">Language</label>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="language"
                    id="english"
                    className="form-check-input"
                    value="English"
                  />
                  <label className="form-check-label" htmlFor="english">
                    English
                  </label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="language"
                    id="hindi"
                    className="form-check-input"
                    value="Hindi"
                  />
                  <label className="form-check-label" htmlFor="hindi">
                    Hindi
                  </label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="language"
                    id="other"
                    className="form-check-input"
                    value="Other"
                  />
                  <label className="form-check-label" htmlFor="other">
                    Other
                  </label>
                </div>
              </div>

              <div className="mb-3">
                <label htmlFor="runtime" className="form-label">
                  Runtime
                </label>
                <input
                  type="datetime-local"
                  name="runtime"
                  id="runtime"
                  className="form-control"
                />
              </div>

              <button type="submit" className="btn btn-primary">
                Save
              </button>
            </form>
          </div>

          <div className="col-md-7 mt-5">
            <h2 className="mb-2">Movie List</h2>
            <table className="table table-bordered table-striped" id="movies">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Actors</th>
                  <th>Released</th>
                  <th>Type</th>
                  <th>Language</th>
                  <th>Runtime</th>
                </tr>
              </thead>
              <tbody id="t-body">
                {movieData?.map((m, index) => (
                  <tr key={index}>
                    <td>{m.movie_name}</td>
                    <td>{m.actors}</td>
                    <td>{m.released}</td>
                    <td>{m.type}</td>
                    <td>{m.lang}</td>
                    <td>{m.runtime}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
}

export default MovieForm;
