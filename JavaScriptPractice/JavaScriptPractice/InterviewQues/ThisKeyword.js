const obj = {
  name: "JS",
  show() {
    console.log(this.name); //JS //this refers to object calling the method
  },
};
obj.show();

const obj1 = {
  name: "React",
  show() {
    console.log(this.name); // undefind
  },
};

const fun = obj1.show;
fun();
//Function is detached from object
//Normal function call → this = window
//window.name is undefined

const obj2 = {
  name: "Angular",
  show: () => {
    console.log(this.name); //undefind
  },
};
obj2.show();
// Arrow functions do not have their own this
// They take this from lexical scope
// Here → global scope
// Arrow function does NOT bind this
// Takes this from global scope
// window.name → undefined

const obj3 = {
  name: "Node",
  show1() {
    console.log(this.name); //Node
  },
  show2: () => {
    console.log(this.name); //undefined
  },
};

obj3.show1();
obj3.show2();

// show1 → normal method → this = obj
// show2 → arrow → this = window

function outer() {
  const inner = () => {
    console.log(this); //Window {}
  };
  inner();
}
outer();

//outer() is normal function → this = window
//Arrow inherits this from outer

const obj4 = {
  name: "JS",
  show() {
    const inner = () => {
      const deep = () => {
        console.log(this.name); //JS
      };
      deep();
    };
    inner();
  },
};
obj4.show();
// Arrow functions keep lexical this
// Ultimately inherited from show() → object

const obj5 = {
  name: "Timeout",
  show() {
    setTimeout(function () {
      console.log(this.name); //undefind
    }, 100);
  },
};
obj5.show();
//setTimeout callback is a normal function
//this = window

const obj6 = {
  name: "Timeout",
  show() {
    setTimeout(() => {
      console.log(this.name); //Timeout
    }, 100);
  },
};
obj6.show();
//Arrow inherits this from show()

function squareIntegersNewObject(obj) {
  const newObj = { ...obj }; // Create a copy

  for (let key in newObj) {
    if (Number.isInteger(newObj[key])) {
      newObj[key] = newObj[key] ** 2;
    }
  }
  return newObj;
}

const person = { name: "Bob", age: 30, score: 80, height: 6.1 };

const updatedPerson = squareIntegersNewObject(person);

console.log("Original:", person); // unchanged
console.log("Updated:", updatedPerson); // only integers squared

// if (typeof obj[key] === 'number') {
//   obj[key] = obj[key] ** 2;  // This will square 5.5(Float) → 30.25 (wrong!)
// }//Not prefer this , prefer above.

const original = {
  name: "Alice",
  age: 25,
  scores: [90, 85, 95],
  address: { city: "Delhi", pin: 110001 },
};

const copy = { ...original }; // Shallow copy

// Change simple values → original unchanged
copy.name = "Bob";
console.log(original.name); // "Alice" ✓ good

// But change nested object/array → affects original!
copy.scores.push(100);
copy.address.city = "Mumbai";

console.log(original.scores); // [90, 85, 95, 100] → changed!
console.log(original.address.city); // "Mumbai" → changed!

const deepCopy = JSON.parse(JSON.stringify(original));
// Now nested changes won't affect original

const obj7 = {
  a: 1,
  b: {
    c: 2,
  },
};

const copy = obj7;
copy.b.c = 10;
console.log(obj7.b.c); //?

const obj8 = { a: 1, b: { c: 2 } };
const copy = { ...obj8 };
copy.b.c = 10;
console.log(obj8.b.c);

const obj9 = { a: 1 };
const copy = Object.assign({}, obj9);
copy.a = 10;
console.log(obj9.a);

//Object.assign performs a shallow copy.
//What gets copied?  Top-level properties are copied, Nested objects are copied by reference
const obj10 = { a: { b: 2 } };
const copy = Object.assign({}, obj10);
copy.a.b = 10;
console.log(obj10.a.b); // 10 //Nested will behave differently.

//Below is Deep Copy
const obj11 = { a: { b: 2 } };
const copy = JSON.parse(JSON.stringify(obj11));
copy.a.b = 10;
console.log(obj11.a.b);

const obj12 = { a: 1, b: { c: 2 } };

const { a } = obj12;
const newObj = { ...obj12 };
newObj.b.c = 10;

console.log(obj12.b.c, a);

const obj13 = { x: { b: 2 } };
const { x } = obj13;
x.b = 10;
 console.log(obj13.x.b);
// - Spread creates shallow copy
// - Destructuring does not copy objects
// - Rest collects remaining values
// - Nested objects always share reference unless deep copied
// - JSON.parse(JSON.stringify()) is common deep copy method


const gen = function*() { yield 1; yield 2; };
console.log(...[gen()]);

function func(...rest) {
  rest.push(4);
  console.log(rest);
}
func(1, 2, 3);

const [[first, ...innerRest], ...outerRest] = [[1, 2, 3], 4, 5];
console.log(innerRest, outerRest);

const arr1 = [1, [2]];
const arr2 = [...arr1];
arr2[1].push(3);
console.log(arr1[1]);
//Answer:[2, 3]
//Explanation: Shallow copy; nested arrays are referenced, not copied.

