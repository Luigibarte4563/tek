// Accessing Array Elements

let fruits = ["Apple", "Banana", "Orange"];

console.log(fruits[0]);

// Changin Array Values

fruits[1] = "Mango";

console.log(fruits);

// Adding Elements
fruits.push("Berry");

console.log(fruits);

// Removing element
fruits.pop();

console.log(fruits);

// Adding to beginning 
fruits.unshift("Beryna");

console.log(fruits);

// Removing from  the  beginning
fruits.unshift();

console.log(fruits);

// Looping through array
for (let i = 0; i  < fruits.length; i++) {
    console.log(fruits[i]);
}
