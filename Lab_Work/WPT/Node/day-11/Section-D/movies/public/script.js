function submitMovies() {
  const movies = [];
  const movieDivs = document.querySelectorAll(".movie");

  movieDivs.forEach(div => {
    const name = div.querySelector(".name").value;
    const price = parseFloat(div.querySelector(".price").value);
    const seat = parseInt(div.querySelector(".seat").value);

    if (!name || isNaN(price) || isNaN(seat)) {
      console.error("Please fill all fields correctly");
      return;
    }

    movies.push({ name, price, seat });
  });

  if (movies.length !== 3) return;

  const xhr = new XMLHttpRequest();
  xhr.open("POST", "/add-movies", true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      alert("Movies saved successfully");
      loadMovies(); // refresh table
    }
  };
  xhr.send(JSON.stringify(movies));
}

function loadMovies() {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "/movies", true);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      const movies = JSON.parse(xhr.responseText);
      const tbody = document.getElementById("movieTableBody");
      tbody.innerHTML = "";

      movies.forEach(movie => {
        const row = `<tr>
            <td>${movie.name}</td>
            <td>${movie.price}</td>
            <td>${movie.seat}</td>
          </tr>`;
        tbody.innerHTML += row;
      });
    }
  };
  xhr.send();
}

window.onload = loadMovies;
