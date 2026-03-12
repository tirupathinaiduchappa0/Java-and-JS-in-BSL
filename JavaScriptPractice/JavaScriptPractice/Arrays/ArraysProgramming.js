//You are given a List<String> in Java that contains a mix of numeric strings and non-numeric strings, for example:List<String> listOfStr = List.of("1", "2", "ramu", "3", "seetha");Write a Java program to collect only the numeric values from the list into a List<Integer> using Java Streams. Strings that cannot be converted to integers should be ignored.
// Expected Output:[1, 2, 3]
let mixArray = ["1", "2", "seetha", "3", "geetha", "4"];
let integersRes = [];

for (let i of mixArray) {
  if (!isNaN(+i)) {
    // Convert i to number with +i and check if it's a number
    integersRes.push(+i); // Convert string to number and add to result
  }
}
console.log("integersRes", integersRes);

//1) find duplicate elements from given array.
const array = [1, 2, 8, 8, 9, 9, 8, 2];
const duplicates = [];
for (let i = 0; i < array.length; i++) {
  for (let j = i + 1; j < array.length; j++) {
    if (array[i] === array[j] && !duplicates.includes(array[i])) {
      duplicates.push(array[i]);
    }
  }
}

const unique = new Set();
const duplis = new Set();
array.forEach((e) => {
  if (unique.has(e)) duplis.add(e);
  unique.add(e);
});
//console.log("unique", [...new Set(unique)], "duplis", [...new Set(duplis)]);
//console.log("duplicates", duplicates);

const findDuplicates = (arr) => {
  const count = {};
  const duplicates = [];

  for (let num of arr) {
    count[num] = (count[num] || 0) + 1;
  }

  for (let key in count) {
    if (count[key] > 1) {
      duplicates.push(Number(key));
    }
  }

  return duplicates;
};

console.log(findDuplicates([1, 2, 3, 2, 4, 5, 3]));

//2) find the common elements between two given arrays.
const array1 = [1, 2, 8, 12, 9, 8];
const array2 = [11, 2, 18, 12, 9, 18];

const CommomElebwTwoArrays = [];

for (let i = 0; i < array1.length; i++) {
  for (j = 0; j < array2.length; j++) {
    if (array1[i] === array2[j] && !CommomElebwTwoArrays.includes(array2[j])) {
      CommomElebwTwoArrays.push(array2[j]);
    }
  }
}

const singleArraDups1 = array1.filter((a) => array2.includes(a));

// console.log(
//   "CommomElebwTwoArrays",
//   CommomElebwTwoArrays,
//   "singleArraDupsi",
//   singleArraDups1
// );
const set11 = [...new Set(array1)];
const set22 = [...new Set(array2)];
const intersectionele = set11.filter((e) => {
  return set22.includes(e);
});

//console.log("intersectiondle", intersectionele);

const set1 = [...new Set(array1)]; //array
const set2 = new Set(array2); //object
//console.log(set1, set2);
const dupds = set1.filter((e) => set2.has(e));
//console.log("duplicates", dupds);

//3) How to find the max and min number from given array.

const findMinMax = (arr) => {
  let min = arr[0];
  let max = arr[0];

  for (let num of arr) {
    if (num > max) max = num;
    if (num < min) min = num;
  }

  return { min, max };
};

console.log(findMinMax([5, 2, 9, 1, 7]));

//console.log("max & min number is:::" + maxNumber, minNumber);

const maxnum = array.reduce((a, b) => (a > b ? a : b));
const minNum = array.reduce((a, b) => (a < b ? a : b));
//console.log("max and min number is:::", maxnum, minNum);
//console.log(Math.max(...array1), Math.min(...array1));
let newArray = [...new Set(array)].sort();
//console.log("min & max", newArray[0], newArray[newArray.length - 1]);
//4)find the second maximum element from given array(Hint:: duplicates remove, sort, find second last)

const secondMaxelementarray = [
  100, 100, 50, 10, 200, 400, 300, 400, 500, 600, 600,
];

const secondMaxelementarray1 = [...new Set(secondMaxelementarray)].sort();
// console.log(
//   "secondMaxelementarray",
//   secondMaxelementarray1[secondMaxelementarray1.length - 2]
// );
const secondMaxelementarray2 = [...new Set(secondMaxelementarray)].sort(
  (a, b) => b - a
);
//console.log("secondMaxelementarray2", secondMaxelementarray2[1]);
const noDupsarray = [1, 2, 3, 4, 5, 6];
const x = noDupsarray.splice(noDupsarray.indexOf(Math.max(...noDupsarray)), 1);
//console.log(Math.max(...noDupsarray));

let arrayNum = [34, 7, 23, 62, 32, 5, 62];

let maxN = -Infinity; //Integer.MinValue
let secondMax = -Infinity; //Integer.MaxValue
for (let currentNum of arrayNum) {
  if (currentNum > maxN) {
    secondMax = maxN;
    maxN = currentNum;
  } else if (currentNum > secondMax && currentNum < maxN) {
    secondMax = currentNum;
  }
}

// find Second maximum number if we have duplicate elements
const inp = [1, 2, 4, 4, 7];
let ar = inp.sort((a, b) => a - b);

let ress = ar[ar.length - 1];
for (let i = ar.length - 2; i >= 0; i--) {
  if (ress != inp[i]) {
    ress = inp[i];
    break;
  }
}

//console.log("Max and min is::", maxN, secondMax);

//7)find the smallest missing Number from the given array, i / p: array [3, 5, 4, 7,9, 10].    o/p: 8

const givenArray = [3, 5, 4, 7, 9, 10];
const givenArray1 = [...new Set(givenArray)].sort((a, b) => a - b);
let result = givenArray1[0];
for (let i = 0; i < givenArray1.length - 1; i++) {
  if (givenArray1[i] === result) {
    result++;
  } else {
    // console.log(result);
  }
}

//This logic is posssible if array is sorted only.
let allMissingNums = [];
for (let i = 0; i < givenArray1.length; i++) {
  let currEl = givenArray1[i];
  let nextEl = givenArray1[i + 1];
  for (let j = currEl + 1; j < nextEl; j++) {
    allMissingNums.push(j);
  }
}
//console.log("allMissingNums::: ", allMissingNums);

//First Missing element from array of given odd numbers

const givenArr = [5, 7, 9, 11, 15, 17];
let missingEle = givenArr[0];
for (let i = 0; i < givenArr.length; i++) {
  if (givenArr[i] == missingEle) {
    missingEle += 2;
  } else {
    //console.log("Missing Elemeit is:::", missingEle);
  }
}

//8) find the missing Numbers from the given array i / p: array = [3, 5, 4, 7, 9, 10]   o/p: [6, 8]

const missingElements = [];
for (let i = Math.min(...givenArray1); i < Math.max(...givenArray1); i++) {
  if (givenArray1.indexOf(i) < 0) missingElements.push(i);
}

const missingElements1 = [];
for (let i = Math.min(...givenArray1); i < Math.max(...givenArray1); i++) {
  !givenArray1.includes(i) ? missingElements1.push(1) : "";
}
//console.log("missingElements", missingElements, missingElements1);

const missingElements2 = [];
for (let i = Math.min(...givenArray1); i < Math.max(...givenArray1); i++) {
  if (!givenArray1.includes(i)) {
    missingElements2.push(i);
  }
}
//console.log("missingElements2 Issssssssssssss", missingElements2);

//9) From the given array [3, 4, 2, 5, 7, 13, 2, 5, 78, 9, 23, 23, 28, 4, 12, 3, 7] seperate even and odd numbers and arrange even Numbers in a assending and odd numbers in Desceinding

const arrayOfNumbers = [
  3, 4, 2, 5, 7, 13, 2, 5, 78, 9, 23, 23, 28, 4, 12, 3, 7,
];
const arrayOfNumbers1 = [...new Set(arrayOfNumbers)];
const oddNumbers = [];
const evenNumbers = [];
arrayOfNumbers1.forEach((x) =>
  x % 2 === 0 ? evenNumbers.push(x) : oddNumbers.push(x)
);
// console.log(
//   oddNumbers.sort((a, b) => a - b),
//   evenNumbers.sort((a, b) => b - a)
// );

let givenNum = 6;
let factorialReasultIs = 1;
let factorialReasultIs1 = 1;

for (let i = givenNum; i >= 1; i--) {
  factorialReasultIs *= i;
}
for (let i = 1; i <= givenNum; i++) {
  factorialReasultIs1 *= i;
}
//console.log("factorialReasultIs", factorialReasultIs, factorialReasultIs1);
//19) find the Maximum repeated element from given array [1, 2, 2, 3, 3, 3, 4, 4, 4, 1, 5, 5, 5, 5, 5];

//VWWVIMP

const arrarel = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5];

let maxCount = 1;
let maxRepNum = 0;
for (let i = 0; i < arrarel.length; i++) {
  let count = 0;
  for (let j = i + 1; j < arrarel.length; j++) {
    if (arrarel[i] === arrarel[j]) {
      count++;
    }
  }
  if (count > maxCount) {
    maxCount = count;
    maxRepNum = arrarel[i];
  }
}
//console.log("maxRepNum", maxRepNum, maxCount);

const maxRepeated = (arr) => {
  const count = {};
  let maxCount = 0;
  let result;

  for (let num of arr) {
    count[num] = (count[num] || 0) + 1;
    if (count[num] > maxCount) {
      maxCount = count[num];
      result = num;
    }
  }

  return result;
};

console.log(maxRepeated([1, 2, 2, 3, 3, 3, 4, 4, 4, 1, 5, 5, 5, 5, 5]));

const ecahNo = arrarel.reduce((acc, curr) => {
  acc[curr] = (acc[curr] || 0) + 1;
  return acc;
}, {});

// console.log("ecahNo", ecahNo);
// console.log(
//   "max Repted ele",
//   Object.keys(ecahNo).reduce((a, b) => (ecahNo[a] > ecahNo[b] ? a : b))
// );
let freq = {};
let maxCnt = 0;
let maxRepN = 0;
for (let curr of arrarel) {
  freq[curr] = (freq[curr] || 0) + 1;
  if (freq[curr] > maxCnt) {
    maxCnt = freq[curr];
    maxRepN = curr;
  }
}
//console.log("freq maxCnt maxRepN ", maxCnt, maxRepN, freq);

//25) Generate a 4 digit Random OTP number.
function generateOtp() {
  return Math.floor(Math.random() * 10000);
}

//console.log("generateOtp()", generateOtp());

//26)print the count and print "Happay Nwe year" msg after 3 second done;
/*
let countDown = 3;
function generateMsg() {
  if (countDown > 0) {
    console.log(countDown);
    I;
    countDown--;
    setTimeout(generateMsg, 1000);
  } else {
    console.log("Happy New Year");
  }
}
generateMsg();
*/
//29) from the given array find the product of even numbers.

const nums = [1, 2, 3, 4, 5, 6, 7, 8];

const productOfEven = nums.reduce((res, num) => {
  if (num % 2 === 0) {
    res = res * num;
  }
  return res;
}, 1);
//console.log("productOfEven", productOfEven);

const productofEven1 = nums
  .filter((a) => a % 2 == 0)
  .reduce((a, b) => a * b, 1);
//console.log("productofEven", productofEven1);

const arrayOfN = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const avgOfNum = arrayOfN.reduce((acc, curr) => {
  acc += curr;
  return acc % arrayOfN.length;
}, 0);
//console.log("avgOfNum", avgOfNum);

let ar1 = [1, 2, 3, 4, 5, 6];
let ar2 = [11, 22, 33, 44, 55, 66];
ar2.push.call(ar2, "$");
ar1.push.apply(ar1, ar2);
//console.log("ar1 is::::::::::::::", ar2);
//console.log("ar1 is::::::::::::::", ar1);

//Convert Given Numaric Number in to Roman Number

const romanValues = [
  { value: 1000, symbol: "M" },
  { value: 900, symbol: "CM" },
  { value: 500, symbol: "D" },
  { value: 400, symbol: "CD" },
  { value: 100, symbol: "c" },
  { value: 90, symbol: "XC" },
  { value: 50, symbol: "L" },
  { value: 40, symbol: "XL" },
  { value: 10, symbol: "x" },
  { value: 9, symbol: "1X" },
  { value: 5, symbol: "V" },
  { value: 4, symbol: "1V" },
  { value: 1, symbol: "1" },
];
let romanResult;
let numaricNum = 23;
for (let i = 0; i < romanValues.length; i++) {
  while (numaricNum >= romanValues[i].value) {
    romanResult += romanValues[i].symbol;
    numaricNum -= romanValues[i].value;
  }
}
//console.log("romanResult:::::", romanResult);

//39)find the commen elements between two objects.
// input1 = {a: 1, b: 2, c: 3,d:4);
//input2 = { d: 4, e: 5 }; output: { d: 4;}
const input1 = { a: 1, b: 2, c: 3, d: 4 };
const input2 = { d: 4, e: 5 };

const output = Object.keys(input1).reduce((acc, curr) => {
  if (input2.hasOwnProperty(curr) && input1[curr] == input2[curr]) {
    acc[curr] = input1[curr];
  }
  return acc;
}, {});

//console.log(output);

const commonObjects = (obj1, obj2) => {
  const result = {};

  for (let key in obj1) {
    if (obj1[key] === obj2[key]) {
      result[key] = obj1[key];
    }
  }

  return result;
};

console.log(commonObjects({ a: 1, b: 2, c: 3, d: 4 }, { d: 4, e: 5 }));

//console.log("outPutObj::  ",outPutobj);

//40) to find sum of all elements except the current element ip=[1,2,3,4,5,6,7), op= [27, 26, 25, 24, 23, 22, 21]

const exceptCurrEle = [1, 2, 3, 4, 5, 6, 7];
const opSum = exceptCurrEle.map((i) =>
  exceptCurrEle
    .filter((j) => j != i)
    .reduce((acc, curr) => {
      acc += curr;
      return acc;
    }, 0)
);
//console.log("output sum is:::", opSum);

const opProduct = exceptCurrEle.map((i) =>
  exceptCurrEle
    .filter((j) => j != i)
    .reduce((acc, curr) => {
      acc *= curr;
      return acc;
    }, 1)
);

let result1 = [];
for (let i = 0; i < exceptCurrEle.length; i++) {
  let sum = 0;
  for (let j = 0; j < exceptCurrEle.length; j++) {
    if (exceptCurrEle[i] != exceptCurrEle[j]) {
      sum += exceptCurrEle[j];
    }
  }
  result1.push(sum);
}
//console.log("sum of all execpt curr ele:: " , result1)

//console.log("output product is:::", opProduct);
//arr.map(i=>arr.filter(j=> j != i).reduce((a,b)=>a*b));

//3)input= { name:"ramu", age:30,gender:"male"},output=[[name, ramu], [age, 30], [gender, male]];

const personObj = { name: "Ramu", age: 30, gender: "male" };

//console.log(Object.entries(personObj)); //[[name, ramu], [age,30], [gender,male]];
const ObjToArr = Object.keys(personObj).map((key) => {
  const val = personObj[key];
  return [key, val];
});

//console.log("ObjToArr", ObjToArr);

//45) from the given array targetArray = [10, 20, 30, 40, 50, 60, 70, 80, 90];,
//targetSum is 100, output should be in stored in Map or Object[[10, 90], [20, 80], [30, 70], [40, 60], [50, 50], [60, 40], [70, 30], [80, 20]] sotres this output in Map /Object.

const targetArray = [10, 20, 30, 40, 50, 60, 70, 80, 90];
targetSum = 100;
let object = {};
for (let i = 0; i < targetArray.length; i++) {
  for (let j = i + 1; j < targetArray.length; j++) {
    if (targetArray[i] + targetArray[j] === targetSum) {
      object[targetArray[i]] = targetArray[j];
    }
  }
}
//console.log("object", object);

//we can use Map in js like in java, at the end we end we need to spreard the map i
// want to see the output otheer wise it will give empty array as outpt

let outptMap = new Map();
for (let i = 0; i < targetArray.length; i++) {
  for (let j = i + 1; j < targetArray.length; j++) {
    if (targetArray[i] + targetArray[j] === targetSum) {
      outptMap.set(targetArray[i], targetArray[j]);
    }
  }
}

//console.log(...outptMap);
//console.log([...outptMap]);

const twoSum3 = (arr, target) => {
  let result = [];
  let seen = new Set();
  for (const ele of arr) {
    let complement = target - ele;
    if (seen.has(complement)) {
      result.push([ele, complement]);
    }
    seen.add(ele);
  }
  return result;
};

const targetArray1 = [10, 20, 30, 40, 50, 60, 70, 80, 90];
targetSum = 100;
//console.log("pairs are::;;;;;", twoSum3(targetArray1, targetSum));

const twoSumIndices = (arr, target) => {
  let result = [];
  let map = new Map();
  for (let i = 0; i < arr.length; i++) {
    let compliment = target - arr[i];
    if (map.has(compliment)) {
      result.push([map.get(compliment), i]);
    }
    map.set(arr[i], i);
  }
  return result;
};
console.log(twoSumIndices(arr, target)); //[[2,7],[7,2]]

let resultt = [];
for (let i = 0; i < targetArray.length; i++) {
  complement = targetSum - targetArray[i];
  if (complement > targetArray[i]) {
    resultt.push([targetArray[i], complement]);
  }
}

//console.log("resultt::: ", resultt);

//46) from 1 to 100 numbers find sum of all even numbers and all odd numbers seperately.
let sumOfEven = 0;
let sumofodd = 0;
for (let i = 1; i <= 100; i++) {
  if (i % 2 == 0) {
    sumOfEven += i;
  } else {
    sumofodd += i;
  }
}
//console.log("sumOfEven", sumOfEven, "sumOfOdd", sumofodd);
let numDivideBy5 = 0;
for (let i = 1; i <= 100; i++) {
  if (i % 5 == 0) {
    numDivideBy5 += i;
  }
}

//console.log("numDivideBy5", numDivideBy5);
//sort array of numbers without using any inbuilt method;

let array22 = [5, 2, 67, 1, 36, 4, 8, 3, 5, 7, 8, 0];

/* console.log(array1.sort((a,b)=>b-a)); */
for (var i = 0; i < array22.length; i++) {
  for (var j = 0; j < array22.length - 1; j++) {
    if (array22[j] > array22[j + 1]) {
      let temp = array22[j];
      array22[j] = array22[j + 1];
      array22[j + 1] = temp;
    }
  }
}
// array22[j] = array22[j] + array22[j + 1];
// array22[j + 1] = array22[j] - array22[j + 1];
// array22[j] = array22[j] - array22[j + 1];
//console.log("jsdjsgbmbmbd", array22);

let s1 = "hello";
let s2 = "world";
s1 = s1 + s2;
s2 = s1.substring(0, s1.length - s2.length);
s1 = s1.substring(s2.length);
//console.log(s1, s2);

const range = Array.from({ length: 10 }, (_, i) => i);
//console.log("range", range);
//convert given array in to object;
const attToobj = ["ramu", "teena", "beemu", "seetha"];

//console.log({ ...attToobj });

//index of each value is starts with their first letter

const opt = attToobj.reduce((acc, curr, i) => {
  acc[i] = curr;
  return acc;
}, {});

const optt = attToObj.reduce((acc, curr) => {
  const FirstLetter = curr[0];
  if (!acc[FirstLetter]) acc[FirstLetter] = [];
  acc[FirstLetter].push(curr);
  return acc;
}, {});

console.log("opttttt is:::", optt);

//console.log("opt is::::::::::", opt);

//index of each value is starts with their first letter

const op = attToobj.reduce((acc, curr) => {
  acc[curr[0]] = curr;
  return acc;
}, {});
//console.log(op);

//17) Find fibanoci series of length 10 ?

const seq = [0, 1];
const fibLength = 10;
for (let i = 2; i < fibLength; i++) {
  let nextFibanoci = seq[i - 1] + seq[i - 2];
  seq.push(nextFibanoci);
}
//console.log(seq);

//write programme to find output from below programme 1/p:"abbbcccadeff",o/p:

const str = "abbbcccadeff";
let count = 1;
let resultArr = "";
for (let i = 0; i < str.length; i++) {
  if (str[i] === str[i + 1]) {
    count++;
  } else {
    resultArr += str[i] + count;
    count = 1;
  }
}

console.log("result", resultArr);

const arrofEle = [1, 2, 3, 4, 5];
let resultArrOfElemts = [];
for (let i = 0; i < arrofEle.length; i++) {
  let product = 1;
  for (let j = 0; j < arrofEle.length; j++) {
    if (arrofEle[i] != arrofEle[j]) {
      product *= arrofEle[j];
    }
  }
  resultArrOfElemts[i] = product;
}

console.log("product of all elememts except current", resultArrOfElemts);

const arr = [3, 6, 30, 0, -1, 7];

for (let i = 0; i < arr.length; i++) {
  for (let j = 0; j < arr.length - 1; j++) {
    if (arr[j] > arr[j + 1]) {
      let temp = arr[j];
      arr[j] = arr[j + 1];
      arr[j + 1] = temp;
      //[arr[j], arr[j + 1]] = [arr[j + 1], arr[j]]
    }
  }
}

console.log("numbers in sorting order isttt ", arr);
//“Given an array of numbers, write a JavaScript program to categorize the elements into three groups: numbers between 1 and 99, numbers between 100 and 199, and numbers greater than or equal to 200, and store the result in a nested array.”
//i/P:let arr1 = [1, 2, 4, 5, 100, 102, 105, 200, 201]; o/p:[ [ 1, 2, 4, 5 ], [ 100, 102, 105 ], [ 200, 201 ] ]

let array6 = [100, 1, 200, 2, 4, 5, 102, 201, 105];
let result6 = [];
let ZeroToHunderd = [];
let HunderdToTwoHund = [];
let morrethan200 = [];
for (let i of array6) {
  if (i > 0 && i < 100) {
    ZeroToHunderd.push(i);
  } else if (i >= 100 && i < 200) {
    HunderdToTwoHund.push(i);
  } else {
    morrethan200.push(i);
  }
}
result6.push(ZeroToHunderd, HunderdToTwoHund, morrethan200);

//console.log("result is::", result6);

let ZeroToHunderd1 = array6.filter((i) => i > 0 && i < 100);
let HunderdToTwoHund1 = array6.filter((i) => i >= 100 && i < 200);
let morrethan2001 = array6.filter((i) => i >= 200);

let result7 = [ZeroToHunderd1, HunderdToTwoHund1, morrethan2001];

//console.log("result is::", result7);

let result8 = array6.reduce(
  (acc, i) => {
    if (i > 0 && i < 100) acc[0].push(i);
    else if (i >= 100 && i < 200) acc[1].push(i);
    else acc[2].push(i);
    return acc;
  },
  [[], [], []]
);

//console.log("result is::", result8);

let arrayAngram = ["eat", "tea", "ate", "max", "axm", "box", "xob", "oxb"];

const groupByAnagram = (array) => {
  let result = {};
  for (let each of array) {
    let sortedArr = each.split("").sort().join("");
    if (!result[sortedArr]) {
      result[sortedArr] = [];
    }
    result[sortedArr].push(each);
  }
  return Object.values(result);
};

//console.log(groupByAnagram(arrayAngram));


function reverseArrayInPlace(arr) {
  for (let i = 0; i < arr.length / 2; i++) {
    let temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
  }
  return arr;
}

console.log(reverseArrayInPlace([1, 2, 3, 4])); // [4, 3, 2, 1]

