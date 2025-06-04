function calculate(operation) {
  const num1 = document.getElementById("num1").value;
  const num2 = document.getElementById("num2").value;

  fetch("/calculate", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ num1, num2, operation })
  })
  .then(res => res.json())
  .then(data => {
    document.getElementById("result").innerText = data.error || `Result: ${data.result}`;
  })
  .catch(err => console.error("Error:", err));
}
