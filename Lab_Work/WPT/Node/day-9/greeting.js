function greet() {
    const today = new Date();
    const hour = today.getHours();

    if (hour < 12) {
        console.log("Good Morning");
    } else if (hour < 17) {
        console.log("Good Afternoon");
    } else {
        console.log("Good Evening");
    }
}

module.exports = { greet };
