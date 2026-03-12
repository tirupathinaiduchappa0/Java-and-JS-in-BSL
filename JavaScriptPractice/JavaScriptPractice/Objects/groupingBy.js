//1)Write a JavaScript program to merge both objects by summing the values of matching keys.let a1 = { a: 1, b: 2 }; let a2 = { a: 4, b: 6, c: 3 }; { a: 5, b: 8, c: 3 }

let a1 = { a: 1, b: 2 };
let a2 = { a: 4, b: 6, c: 3 };

let keys = [...new Set([...Object.keys(a1), ...Object.keys(a2)])];
let result = {};
for (let key of keys) {
  result[key] = (a1[key] || 0) + (a2[key] || 0);
}
//console.log(result);

//20)from array of objects groupingBy gender and find howmany male ad femlae objects.
const gender = [
  { name: "ramu", gen: "M", age: 30 },
  { name: "seetha", gen: "F", age: 23 },
  { name: "geetha", gen: "F", age: 33 },
  { name: "sam", gen: "M", age: 13 },
];

const genCnt = gender.reduce((acc, curr) => {
  acc[curr.gen] = (acc[curr.gen] || 0) + 1;
  return acc;
}, {});
//console.log("genCnt::::  ", genCnt);

const genderCount = gender.reduce((acc, curr) => {
  const { gen } = curr;
  if (!acc[gen]) {
    acc[gen] = 0;
  }
  acc[gen]++;
  return acc;
}, {});
//console.log("genderCount", genderCount);

const resulttobj = {};
const resultt = gender.forEach((each) => {
  const { name, ...rest } = each;
  resulttobj[name] = rest;
});
//console.log("resulttobj", resulttobj);

const resulttObj1 = gender.reduce((acc, curr) => {
  const { name, ...rest } = curr;
  if (!acc[name]) {
    acc[name] = [];
  }
  acc[name].push(curr);
  return acc;
}, {});
//console.log("resulttobj1", resulttObj1);

const genderGroupBy = gender.reduce((acc, curr) => {
  const { gen } = curr;
  if (!acc[gen]) {
    acc[gen] = [];
  }
  acc[gen].push(curr);
  return acc;
}, {});
//console.log("genderGroupBy", genderGroupBy);

//Sorting Based on age
//It will modify the exisisting array but i want output in new array?
//Slice will return New Array and it Doesnt modify original array
//Splice will modify exisiting Array and it return new array.
//console.log(gender.sort((a, b) => a.age - b.age));
const sortWithAge = gender.slice().sort((a, b) => a.age - b.age);
//console.log("sortWithAge slice method:::  ", sortWithAge);
const sortWithNameReverse = gender
  .slice()
  .sort((a, b) => a.name.localeCompare(b.name)); //compareTo in Java
//console.log("sortWithNameReverse", sortWithNameReverse);
//sum of ages of all the persons
gender.reduce((acc, curr) => {
  acc += curr.age;
  return acc;
}, 0);
const actors = [
  { name: "prabas", movies: "chatrapathi" },
  { name: "prabas", movies: "bahu1" },
  { name: "prabas", movies: "bahu2" },
  { name: "raviteja", movies: "vikranark" },
  { name: "ntr", movies: "student 1" },
  { name: "ntr", movies: "rrr" },
  { name: "nani", movies: "eega" },
  { name: "charan", movies: "rrr" },
  { name: "charan", movies: "magadeera" },
];

const grpA = actors.reduce((acc, curr) => {
  const { name, movies } = curr;
  if (!acc[name]) {
    acc[name] = [];
  }
  acc[name].push(movies);
  return acc;
}, {});

//console.log("grpA::::", grpA);

const grpByactNmae = actors.reduce((acc, curr) => {
  const { name } = curr;
  if (!acc[name]) acc[name] = [];
  acc[name].push(curr.movies);
  return acc;
}, {});
//console.log("grpByactNmae:::", grpByactNmae);

const NumberofMoviestheyActed = actors.reduce((acc, curr) => {
  const { name } = curr;
  if (!acc[name]) acc[name] = 0;
  acc[name]++;
  return acc;
}, {});
//console.log("NumberofMoviestheyActed:::", NumberofMoviestheyActed);
for (let { name, movies } of actors) {
  //console.log(name, "--", movies);
}
//convert given array in to object;
const attToobj = ["ramu", "teena", "beemu", "seetha"];
//console.log({ ...attToobj });
//index of each value is starts with their first letter
const opt = attToobj.reduce((acc, curr, i) => {
  return { ...acc, [i]: curr };
}, {});
console.log(" rsult1234 is:::::+++", opt);
//index of each value is starts with their first letter
const op = attToobj.reduce((acc, curr) => {
  return { ...acc, [curr[0]]: curr };
}, {});
console.log(" rsult is:::::+++", op);
const optt = attToobj.reduce((acc, curr) => {
  const Firstletter = curr[0];
  if (!acc[Firstletter]) acc[Firstletter] = [];
  acc[Firstletter].push(curr);
  return acc;
}, {});
console.log("opttoptt rsult is::::: +++", optt);
