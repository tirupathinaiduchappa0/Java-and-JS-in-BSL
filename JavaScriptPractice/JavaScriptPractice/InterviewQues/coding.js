///// Js is Synchronous single threaded language   //////////

var b = 1;
function outerFun() {
  var b = 2;
  function innerFun() {
    console.log(b);
    b++; //undefined + 1 = NaN
    console.log(b);
    var b = 3;
    console.log(b);
  }
  console.log(b);
  innerFun();
  console.log(b);
}
outerFun();
//Solution:
// - 'var b' inside innerFun is hoisted to the top of the function.
// - The local variable 'b' shadows the outer variable.
// - During first console.log, 'b' is undefined.
// - undefined++ results in NaN.
// - Later, 'b' is assigned 3.

// Q: What is Temporal Dead Zone (TDZ) in JavaScript?

// A:
// Temporal Dead Zone is the time between the hoisting of a variable declared with let or const
// and its initialization. During this period, accessing the variable results in a ReferenceError.

// let and const are hoisted but not initialized, which causes TDZ.

var a = 20;
{
  let a = 10;
  console.log(a); //legal shadowing //o/p: 10
}

let c = 50;
function func() {
  var c = 60;
  console.log(c); //legal shadowing //o/p: 60
}
func();

/*let b=30;
{
    var b=40 //Illegal shadowing
    console.log(b)//Identifier 'b' has already been declared
}*/

/*
WHY This Is Illegal (MOST IMPORTANT PART)
🔴 Key Rule (Interview Gold ⭐)

You cannot shadow a block-scoped variable (let / const) using var.

Why?

let b = 30 → block scoped (global block)

var b = 40 → function scoped (or global)

var ignores block boundaries *******VVVVVIMP

JS sees two declarations of b in same scope

💥 This breaks scoping rules → SyntaxError

7️⃣ Simple Memory Trick 🧠
var  → let   ✅ Allowed
let  → let   ✅ Allowed
var  → var   ✅ Allowed
let  → var   ❌ NOT Allowed


📌 Block-scoped variable cannot be shadowed by function-scoped var 
 What is illegal shadowing in JavaScript?

A:
Illegal shadowing occurs when a variable declared with var tries to shadow
a block-scoped variable (let or const). JavaScript does not allow this
and throws a SyntaxError.*/

let a = 50;
function outest() {
  var c = 20;
  function outer(b) {
    function inner() {
      console.log(a, b, c);
    }
    let a = 10;
    return inner;
  }
  return outer;
}
var close = outest()("seetha");
console.log(close());

function x(b) {
  console.log("x");
  console.log(b);
  b(); // Call the function passed as argument
}

x(function y() {
  console.log("hello");
});

function mul(...params) {
  //Rest operator
  console.log(params);
}
let arr = [1, 2, 3];
mul(...arr); //Spread operator

function add(params) {
  console.log(params);
}
add(...arr);

/*Final Comparison (Crystal Clear)
Function	             Parameter type  	What happens	            Output
mul(...params)	         REST	           Collects all args	        [1,2,3]
add(params)            	Normal	            Takes first value only      	1       

mul uses rest parameter, so all values are collected into an array.
add has a normal parameter, so only the first spread value is assigned.
*/
function test(a, b, c) {
  console.log(a, b, c);
}
test(...[10, 20]);

function test(args) {
  console.log(args.length);
}
test(1, 2, 3, 4);

function test1(...args) {
  console.log(args.length);
}
test1(1, 2, 3, 4);

// Q: Difference between map and forEach in JavaScript?

// A:
// map returns a new array and supports method chaining.
// forEach does not return anything and chaining is not possible.
// map is used for data transformation, while forEach is used for side effects.

function func() {
  console.log("Arguments are::", arguments); // it will work coz it is functon def,stmnt,declaratio.
}
let testArr = [5, 6, 7];
func(testArr);

const func1 = () => {
  console.log("Arguments are::", arguments); // throws error coz it is functon Expression.
};
func1(testArr);
