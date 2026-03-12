Array.prototype.myMap = function (callback) {
  // Adding a custom method 'myMap' to Array prototype
  // 'this' refers to the myArray that calls myMap
  // Here: this = myArray

  let output = [];
  for (let i = 0; i < this.length; i++) {
    //this.length = myArray.length which is 5
    output.push(callback(this[i])); //we can pass the index and array also like this callback(this[i],i,this)
    // this[i] = myArray[i],callback(this[i]) applies function to each element
  }
  return output;
};

let myArray = [4, 5, 6, 7, 8];
let result = myArray.myMap((x) => x * x);
// array.myMap(...) calls the function
// Inside myMap: this = array
// x represents each element of array
console.log("Result is:::===>", result);

Array.prototype.myFilter = function (callback) {
  // 'this' refers to the array that calls myFilter
  // Here: this = myArray

  let output = [];
  // Empty array to store filtered elements

  for (let i = 0; i < this.length; i++) {
    // this.length = myArray.length

    if (callback(this[i])) {
      //we can pass the index and array also like this callback(this[i],i,this)
      // callback(this[i]) returns true or false
      // If true → keep the element

      output.push(this[i]);
      // Push the actual element, not true/false
    }
  }

  return output;
  // Return filtered array
};

// Get only EVEN numbers
let result2 = myArray.myFilter((x) => x % 2 === 0);
// x % 2 === 0 → true for even numbers

console.log("Result is:::===>", result2);

Array.prototype.myReduce = function (callback, initialVal) {
  // 'this' refers to the array calling myReduce
  // Here: this = myArray

  let accumulator;
  let startIndex;

  if (initialVal === undefined) {
    // If no initial value is provided
    accumulator = this[0]; // accumulator = first element
    startIndex = 1; // start loop from second element
  } else {
    // If initial value is provided
    accumulator = initialVal;
    startIndex = 0;
  }

  for (let i = startIndex; i < this.length; i++) {
    // Update accumulator using callback
    accumulator = callback(accumulator, this[i], i, this);
  }

  return accumulator;
  // Final accumulated value
};

let result3 = myArray.myReduce((acc, curr) => acc + curr, 0);

console.log("result3", result3);
