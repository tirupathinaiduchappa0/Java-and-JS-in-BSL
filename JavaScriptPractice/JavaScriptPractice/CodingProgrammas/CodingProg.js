const countries = [
  {
    name: "India",
    code: "IN",
    cities: ["Delhi", "Mumbai", "Hyd"],
  },
  {
    name: "Pakistan",
    code: "PAK",
    cities: ["Karachi", "Multan", "Islambad"],
  },
  {
    name: "Usa",
    code: "US",
    cities: ["Newyork", "chichago", "Dallaos"],
  },
  {
    name: "Austarlia",
    code: "Aus",
    cities: ["Sydney", "Kanberra", "Kangrooo0"],
  },
];

// 44) give me one good example for CallBack hell issue and how can you overcome it.
//Callback hell happens in asynchronous programming, not synchronous.Examples:setTimeout,API calls,File reading , Database calls

/*
const MultiplyByTwo = (num, cb) => {
  setTimeout(() => {
    cb(num * 2);
  }, 500);
};

const MultiplyByThree = (num, cb) => {
  setTimeout(() => {
    cb(num * 3);
  }, 500);
};

const MultiplyByFour = (num, cb) => {
  setTimeout(() => {
    cb(num * 4);
  }, 500);
};

const MultiplyByFive = (num, cb) => {
  setTimeout(() => {
    cb(num * 5);
  }, 500);
};
*/

//Callback Hell (Pyramid of Doom)

//Callback hell occurs in asynchronous JavaScript when multiple nested callbacks depend on the result of previous callbacks, //making the code hard to read, debug, and maintain.

/* const Multiply = (num) => {
  MultiplyByTwo(num, (res) => {
    MultiplyByThree(res, (res) => {
      MultiplyByFour(res, (res) => {
        MultiplyByFive(res, (res) => {
          console.log("result is::::::===>", res);
        });
      });
    });
  });
};

Multiply(2); */

const MultiplyByTwo = (num) => {
  setTimeout(() => {
    return new Promise((Resolve, reject) => {
      Resolve(num * 2);
    });
  }, 500);
};

const MultiplyByThree = (num) => {
  setTimeout(() => {
    return new Promise((Resolve, reject) => {
      Resolve(num * 3);
    }, 500);
  });
};

const MultiplyByFour = (num) => {
  return new Promise((Resolve, reject) => {
    setTimeout(() => {
      Resolve(num * 4);
    }, 500);
  });
};

const MultiplyByFive = (num) => {
  return new Promise((Resolve, reject) => {
    setTimeout(() => {
      Resolve(num * 5);
    }, 500);
  });
};

// const Multiply = (num) => {
//   MultiplyByTwo(num)
//     .then((res) => MultiplyByThree(res))
//     .then((res) => MultiplyByFour(res))
//     .then((res) =>
//       MultiplyByFive(res).then((res) => {
//         console.log("ReultIs====>", res);
//       })
//     );
// };
// Multiply(2);

let x = 10;
let y = ++x;
//console.log("y is:: ", y); //11
let z = x++;
//console.log("z is:: ", z); //11
let res = x == y ? z++ : ++z;
//console.log("z is ", z);
//console.log("resitit", res);

let obj = {
  a: "value",
  b: function () {
    return this.a;
  },
};
//console.log("xx is::::::", obj.b());


//Shallow copy means copying only the reference, not the actual object. Multiple variables point to the same memorylocation.

let a = { key: "Value" }; // Step 1: Create an object

let b = a; // Step 2: Assign object reference to b, NO new object is created, b points to the SAME memory location as a

let c = b; //Step 3: Assign reference again, c also points to the SAME object

a.key = "New Value"; // Step 4: Modify the object using 'a'

b.key = "Another Value"; // Step 5: Modify the same object using 'b'

console.log(a.key, ".", b.key, ".", c.key); // Step 6: All variables point to the same object

//output -- Another Value ,Another Value,Another Value

let a1 = [1, 2, 3, 4];
let a2 = a1; //Pass by Reference or shallow copy
let a3 = [...a1]; // pass by value or Deep copy
a1[0] = 10;
a2[2] = 20;
a3[3] = 100;
console.log(a1); //[10,2,20,4]
console.log(a2); //[10,2,20,4]
console.log(a3); // [1, 2, 3,100];


let m = { key: "Value" }; 

let n = { ...m };

let p = { ...n };

m.key = "New Value";

n.key = "Another Value";
//these are deepe copies what are we are trying to change they onle change.

console.log(m.key, ".", n.key, ".", p.key); //New Value ,Another Value, Value
