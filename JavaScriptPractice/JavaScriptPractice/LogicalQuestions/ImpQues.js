//Fang company ques
const magicObject = {
  val: 0,
  get a() {
    return this.val++; //this.val++ is post-increment,Returns the current value,Then increments val by 1
  },
};
//console.log(magicObject.a); //0
//console.log(magicObject.a); //1
//console.log(magicObject.a); //2
//"every" method in js will apply on arrays
let person = [
  { name: "seetha", marks: 35 },
  { name: "seetha", marks: 40 },
  { name: "seetha", marks: 50 },
  { name: "seetha", marks: 60 },
  { name: "seetha", marks: 70 },
  { name: "seetha", marks: 80 },
  { name: "seetha", marks: 90 },
];
const isAllPass = person.every((obj) => {
  return obj.marks >= 35;
});
//console.log("isAllPass", isAllPass);
//vvv Imp
const letters = ["A", "B", "C", "D"];

//console.log(letters.slice(0, 1));
//It dosen't modifys the original array and it will retrun output in new array
//console.log("After slice", letters);
//console.log(letters.splice(0, 1));
// It modifies the exisisting array & return new array with that removed elemet
//console.log("After splice", letters);
letters.unshift("$"); // it will add at starting position.
//console.log("At end", letters);
//vvv Imp

const newLetters = ["A", "B", "C", "D"];
//console.log(newLetters.splice(0, 1));
//console.log(newLetters.slice(0, 1));
newLetters.unshift("$");
//console.log("At end", newLetters);
const newLetters1 = ["A", "B", "C", "D"];
//console.log(newLetters1.splice(0, 1));
//console.log(newLetters1.slice(0, 1));
newLetters1.shift();
//console.log("At end", newLetters1);

//+++++++++++++++++++dWIMM=======
/*console.log(1);
setTimeout(() => {
  console.log(2);
}, 1000);
setTimeout(() => {
  console.log(3);
}, 0);
*/
/*new Promise((resolve, reject) => {
  console.log("Inside Promise");
  resolve("resolved");
  setTimeout(() => {
    console.log(4);
  }, 0);
}).then((data) => {
  setTimeout(() => {
    console.log(5);
  }, 0);
});
console.log(6);
console.log(1);
setTimeout(() => {
  console.log(2);
}, 0);
Promise.resolve().then((data) => {
  setTimeout(() => {
    console.log(3);
  }, 0);
});
console.log(4);
//ouptput=== 1, Inside Promise,6,3,4,5,2
*/
const a = {};
const b = { key: "b" };

const c = { key: "c" };
a[b] = 143; //a["Object Object"] = 143
a[c] = 286; //a["Object Object"] = 286
//console.log("a[b]=======>", a[b]);

let a1 = [1, 2, 3, 4];
let a2 = a1; //Pass by Reference or shallow copy
let a3 = [...a1]; // pass by value or Deep copy
a1[0] = 10;
a2[2] = 20;
a3[5] = 100;
//console.log(a1); //[10,2,20,4]
//console.log(a2); //[10,2,20,4]
//console.log(a3); // [1, 2, 3, 4, undefind, 100];

//Shallow copy-- shares the reference not the values, if you once ,it effects in all the places
let m = { key: "Value" }; // x is an object with a property 'key'
let n = m; // y now references the same object as x
let p = n; // z also references the same object
m.key = "New Value"; // Changes the 'key' property in the shared object
n.key = "Another Value"; // Again modifies the same shared object
//console.log(m.key, n.key, p.key);
//output -- Another Value ,Another Value,Another Value

const flatArray = [1, [1, 2, 3], [1, 2, [7], 0], 9, 8, [5]];

//console.log(flatArray.flat(Infinity));

const fltaArray1 = [
  1,
  2,
  [3, 4],
  [
    [5, 6],
    [7, 8],
  ],
  [3, 5, 9, [9, 0]],
];

//console.log("fltaArray1", fltaArray1.flat(1));

// inside main array nesting is 2 levels [1,2,3, [[1,2]],...etc), so use flat(2)

//inside main array nesting is 3 levels [1,2,3,[[[1,2],311,.....etc), so use flat(3)

//inside main array nesting is 4 levels [1,2,3,[[[[1,2],3],4]]],.....etc], so use flat(4)
//if we dont know howmany nested arrays theen we use flat(Infinity)
//use flaten array by using custom implementation, not by using inbuilt flat method const flatArraysss = [1, [1, 2, 3], 9, [1, 2, [7], 0], 9, 8, [5]];
let flattendArr = [1, [1, 2, 3], 9, [1, 2, [7], 0], 9, 8, [5]];
let resultArray = [];
function mainArray(inputArr) {
  //From learndepth.com website
  inputArr.forEach((element) => {
    if (Array.isArray(element)) {
      mainArray(element);
    } else {
      resultArray.push(element);
    }
  });
}
mainArray(flattendArr);
//console.log("flattendArr result::", resultArray);

var x = 10;
var fun = function () {
  //Block level is priority, js hoists variable declaration to the top of their scope.
  //console.log("x value is::", x);
  var x = 20;
};
fun();
//currying

let add = function (a) {
  return function (b) {
    return function (c) {
      return a + b + c;
    };
  };
};
//console.log("sum is :::", add(1)(2)(3));

//Curring for infinte series sum(1) (2) (3) (4) (5) (6) (7) (8);

function sum(a) {
  return function (b) {
    return b ? sum(a + b) : a; // here at last b value is undefind so will give crct o/p
  };
}

//console.log("sum in currying is::", sum(1)(2)(3)(4)());

//Even simple with arrow function
const sum2 = (a) => (b) => b ? sum(a + b) : a;

//console.log(sum2(1)(2)(3)(4)()); // 10

function sum1(a) {
  return function (b) {
    if (b === undefined) return a;
    return sum1(a + b);
  };
}

//Each call returns a function that remembers the total.When JavaScript prints it, it converts the function into a number using toString().
//Here see the Differences in i/p
//console.log("sum in currying is::", sum1(1)(2)(3)(4)); // it is not working, ask GPT
//If interviewer asks:

//“How does sum(1)(2)(3)(4) work without ()?”

//You say:

//“Because JavaScript implicitly converts the function to a primitive using toString() or valueOf(), which returns the accumulated sum stored in the closure.”

const sum3 = (a) => {
  const f = (b) => sum3(a + b);
  f.valueOf = () => a;
  return f;
};
console.log("sum in currying without manual stop ():: ", sum3(1)(2)(3)(4)); //(b) => sum3(a+b)
//sum3(1)(2)(3)(4) returns a function, not a number.//For clear exp ask cgpt.

//You overrode valueOf, but console.log does NOT automatically call valueOf() on functions. Instead, it just prints the function itself. use Plus operator or Number jsut befor function.
console.log("sum in currying without manual stop ():: ", +sum3(1)(2)(3)(4));
console.log(
  "sum in currying without manual stop ():: ",
  Number(sum3(1)(2)(3)(4))
);

//33)print the current time in HH:MM:SS in javaScript.

//console.log("check array is string or Not:::", [1, 2, 3] == "1,2,3",[]=="");

let hours = padByZero(new Date().getHours());
let minuts = padByZero(new Date().getMinutes());
let seconds = padByZero(new Date().getSeconds());
function padByZero(input) {
  return input.toString().padStart(2, "0");
}
//console.log(`Time is::::: ${hours}: ${minuts}:${seconds}`);

let hours1 = new Date().getHours();
hours1 = hours1 < 9 ? `0${hours1}` : hours1;
let minutes1 = new Date().getMinutes();
minutes1 = minutes1 < 9 ? `0${minutes1}` : minutes1;
let seconds1 = new Date().getSeconds();
seconds1 = seconds1 < 9 ? `e${seconds1}` : seconds1;

//console.log(`Time is::::: ${hours1}:${minutes1}:${seconds1}`);

//*)create a counter to find the number of days before 2025 Jan 1st. (Ans should in form of 100Days 5Hrs 20Min 3 sec).

let interval = setInterval(() => {
  let targetDate = new Date("Jan 2026 1").getTime();
  let currentDate = new Date().getTime();
  let dateDiff = targetDate - currentDate; //(dateDiff is Milli seconds)
  let days = padByZero(Math.floor(dateDiff / (24 * 60 * 60 * 1000))); // ms/ms
  let hour = padByZero(
    Math.floor((dateDiff % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000)) //dateDiff % oneDayMs → leftover milliseconds after days
    //Divide leftover Ms by oneHourMs
  );
  let min = padByZero(Math.floor((dateDiff % (60 * 60 * 1000)) / (60 * 1000)));
  let second = padByZero(Math.floor((dateDiff % (60 * 1000)) / 1000));
  // console.log(days, hour, min, second);
  document.getElementById(
    "newYear"
  ).innerHTML = `${days}Days:${hour}Hours:${min}Mins:${second}Sec`;
  if (dateDiff < 0) {
    clearInterval(interval);
    document.getElementById("newYear").innerHTML = "Happy New Year";
  }
}, 1000);
//create a function multoplyByTwo (user) that multiples all numaric property values by 2.

let user = {
  name: "ramu",
  salary: 1000,
  age: 20,
  "good hobbies": "chess",
};

for (key in user) {
  if (typeof user[key] === "number") user[key] = 2;
}
//console.log(user);

//5) what is Json.Stringfy and Json.parse? where we are using this.

let student = {
  name: "ramu",
  salary: 1000,
  "good hobbies": "chess",
  age: 20,
};

const strobj = JSON.stringify(student);
//console.log(strobj);
const normalobj = JSON.parse(strobj);
//console.log(normalobj);

// these are used in local storage in application
/*localStorage.setItem("tset", student);
console.log(JSON.parse(localStorage.getItem("test")));
localStorage.setItem("test", normalobj);
console.log(localStorage.getItem("tset"));
localStorage.setItem("strObj", strobj);
console.log(JSON.parse(localStorage.getItem("strobj")));*/

//6) what is output console.log([..."ramu"])? ans: [r,a,m,u]
// let str = "ramu";
// console.log("ramu array is:::", [...str]);

//34) Debounce function impleamentaion and polyfill for it.
//Debiuncing limits the execution of function call and wait for certain amount of time before running it again.NOtebook def follow this.
//Debouncing is a technique to limit how often a function executes.It ensures that a function runs only after a certain delay has passed since the last event.
//Debouncing delays the execution of a function until the user stops triggering the event for a specified time
// let buttonClick = document.getElementById("button-click");
// let btnInc = document.getElementById("btn-inc");
// let debounceInc = document.getElementById("debounce Inc");
// let count = 0;
// let debounceCount = 0;

// const debounceFunction = (cb, d) => {
//   let timer;
//   return function () {
//     if (timer) clearTimeout(timer);
//     timer = setTimeout(() => {
//       cb();
//     }, d);
//   };
// };
// const myDebounce = debounceFunction(() => {
//   debounceInc.innerHTML = ++debounceCount;
// }, 400);
// buttonClick.addEventListener("click", () => {
//   btnInc.innerHTML = ++count;
//   myDebounce();
// });

//Throttlong implementation
//Throttlenig is a technique used to limit the execution of event handler functions even when the event triggers contineously because of user actions. notebook def.

// let throttleCount = 0;
// function ThrottlingFunc(cb, d) {
//   let lastTime = 0;
//   return () => {
//     let currTime = new Date().getTime();
//     if (currTime - lastTime < d) returns;
//     lastTime = currTime;
//     cb();
//   };
// }
// const myThrottling = ThrottlingFunc(() => {
//   debounceInc.innerHTML = ++throttleCount;
// }, 1000);
// buttonClick.addEventListener("click", () => {
//   btnInc.innerHTML = ++count;
//   myThrottling();
// });

//<!-- Event Propagation -- Bubbling, capturing (Trickling) -->
//By default event Bubbling is called(Bottom to top) but if we write {capture: true} as 2nd arg then event capturing Or Trickling (Top to Bottom) is called

let div = document.getElementById("div");
let form = document.getElementById("form");
let button = document.getElementById("button");

// div.addEventListener(
//   "click",
//   () => {
//     alert("div tag called");
//   },
//   { capture: true }
// );

div.addEventListener(
  "click",
  () => {
    //event.stopPropagation();
    alert("div tag called");
  },
  { captrue: true }
);

form.addEventListener("click", () => {
  // event.stopPropagation();
  alert("form tag called");
});

button.addEventListener("click", () => {
  // event.stopPropagation();
  alert("button tag called");
});
//Event Delegation
//here we need to add eventListner to the parent element insted of adding descendent elements

let mobileContainer = document.querySelector(".mobileContainer");
mobileContainer.addEventListener("click", () => {
  console.log(event.target.tagName, "tag name is:::");
  console.log(event.target.closest("SPAN"), "span tag is:::");
  if (event.target.tagName == "SPAN" || event.target.closest("SPAN")) {
    window.location.href = "/" + event.target.className;
  }
});

//<!-- 34) create a model which needs to close on click of negative space? -->
let openModal = document.querySelector(".openModal");
let container = document.querySelector(".modal-container");
openModal.addEventListener("click", (e) => {
  toggleModel(true);
  e.stopPropagation(); // prevent immediate close
});

function toggleModel(toggle) {
  container.style.display = toggle ? "flex" : "none";
}
container.addEventListener("click", (e) => {
  e.stopPropagation(); // prevent immediate close
});

// Click anywhere else → CLOSE modal
document.addEventListener("click", () => {
  toggleModel(false);
});

//4) question is destructre the above data. If the above person data is null then how you can destructre it

// const personData = {
//   name: "seetha",
//   address: {
//     street: "wallstreet",
//     personaAddress: {
//       Mobile: "7995600550",
//     },
//   },
// };
//const { name, address: { street, personaAddress: {Mobile } } } = personData;
// console.log("name, street, Mobile", name, street, Mobile);
//if person data is null then by doing this way it will not break our app

const personData = null;
const { name, address } = { ...personData };
const { street, personaAddress } = { ...address };
const { Mobile } = { ...personaAddress };
//console.log("name, street, Mobile", name, street, Mobile);

//43)Give one best example for arrow function over normal functin and normal function over arrow function.

const numb = [1, 2, 3, 4, 5, 6];
const numMulByTwoArrow = numb.map((i) => i * 2);
//console.log("numMulByTwoArrow", numMulByTwoArrow);
const numMulByTwoNormal = numb.map(function sum(num) {
  return num * 2;
});

//console.log("numMužbyTwoNormal", numMulByTwoNormal);

// const btn = document.getElementById("btn");
// btn.addEventListener("click", function () {
// this.innerHTML = "Clicked By Normal function";
// })

btn.addEventListener("click", () => {
  //this keyword will not werk here, it will come from window object
  this.innerHTML = "Clicked";
  //if you want to work write like this way
  //btn.innerHTML = "clicked by arrow function";
});
//Good question it is not returning 0, it is returning e along with arrowFunction ()

function sayHi() {
  return () => 0;
}
const yy = sayHi();
//console.log("typeof zero", yy, typeof yy);

const Arrayofobj = [
  { names: "ramu", genders: "male" },
  { name: "rita", genders: "female" },
  { name: "gita", genders: "female" },
  { name: "sita", genders: "female" },
];
const CountGender = Arrayofobj.reduce((acc, curr) => {
  acc[curr.genders] = (acc[curr.genders] || 0) + 1;
  return acc;
}, {});
//console.log("CountGender:::::::::::", CountGender);

//convert given array in to object;
const attToObj = ["ramu", "teena", "beemu", "seetha", "rajkumar"];
//console.log({ ...attToObj });
//index of each value is starts with their first letter
const opt = attToObj.reduce((acc, curr, i) => {
  return { ...acc, [i]: curr };
}, {});
//console.log(opt);
//index of each value is starts with their first letter
const op = attToObj.reduce((acc, curr) => {
  return { ...acc, [curr[0]]: curr };
}, {});
//console.log(op);

const optt = attToObj.reduce((acc, curr) => {
  const FirstLetter = curr[0];
  if (!acc[FirstLetter]) acc[FirstLetter] = [];
  acc[FirstLetter].push(curr);
  return acc;
}, {});

//console.log("opttttt is:::", optt);
