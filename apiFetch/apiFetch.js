let search = document.getElementById("search");
let userId = document.getElementById("userId");

search.addEventListener('click', async function () {

    const id = userId.value;

    const response = 
        await fetch(
            `https://jsonplaceholder.typicode.com/users/${id}`
        );

    const user = await response.json();

    document.getElementById("result").innerHTML = 
        `Name    : ${user.name} <br>
        Username : ${user.username} <br>
        Email    : ${user.email} <br>
        `;

});
