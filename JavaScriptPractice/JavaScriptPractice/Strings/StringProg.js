//10)Find the number of vowels in a given senetence String = "I Love my country";
let str = "I love My country";
let vowels = ["a", "e", "i", "o", "u"];
let strArray = str.toLowerCase().split(" ").join("").split("");
//console.log("split:", strArray);
let vowelsCount = strArray.reduce((count, char) => {
  if (vowels.includes(char)) count += 1;
  return count;
}, 0);
//console.log("vowels count is", vowelsCount);
//11) How many times each vowel is repeated from the given string String = "I Love my country";
let eachVowelsCount = strArray.reduce((acc, char) => {
  if (vowels.includes(char)) {
    acc[char] = (acc[char] || 0) + 1;
  }
  return acc;
}, {});
//console.log("eachvowelsCount", eachVowelsCount);
const nameNaidu = "naiduChappaTirupathiNaidu";
let strl = nameNaidu.split("");
let obj = {};
for (let i = 0; i < strl.length; i++) {
  obj[strl[i]] = (obj[strl[i]] || 0) + 1;
}
//console.log("obj", obj);

//split with captal letters and add spaces and convert all to Lower cases Infor company asked this & code is in java files

const strArr1 = nameNaidu.split("");
let result = "";
for (let c of strArr1) {
  if (c >= "A" && c <= "Z") {
    result += " " + c.toLowerCase();
  } else {
    result += c;
  }
}
//console.log("result::: ", result);
//12) Reverse the given String str = "I love India";
let stringToRev = "I love India";
//console.log(stringToRev.split(" ").join("").split("").reverse().join(""));
const strLengtharray = stringToRev.split(" ").join("").split("");
let revArr = [];
for (let i = stringToRev.length - 1; i >= 0; i--) {
  revArr += strLengtharray[i];
}
//console.log("revarr is:", revArr);
let s = stringToRev.split(" ").join("").split("");
let countEachChar = s.reduce((acc, curr) => {
  acc[curr] = (acc[curr] || 0) + 1;
  return acc;
}, {});
//console.log("countEachChar", countEachChar);

const maxkey = Object.keys(countEachChar).reduce((a, b) =>
  countEachChar[a] > countEachChar[b] ? a : b
);
//console.log("max rep key is:", maxkey, countEachChar[maxkey]);
let maxCount = 0;
let maxRepEle = 0;

for (let i = 0; i < s.length; i++) {
  let cnt = 0;
  for (let j = 0; j < s.length; j++) {
    if (s[i] === s[j]) {
      cnt++;
    }
    if (cnt > maxCount) {
      maxCount = cnt;
      maxRepEle = s[i];
    }
  }
}
//console.log("max Reapted key is:", maxRepEle, maxCount);
//14) Find the Maximum length word from the given String.
let stringsent = "I love my India";
const strar = stringsent.split(" ");

const wordwithLength = strar.reduce((acc, curr) => {
  acc[curr] = curr.length;
  return acc;
}, {});
const MaxLengthwordIs = Object.keys(wordwithLength).reduce((a, b) => {
  return wordwithLength[a] > wordwithLength[b] ? a : b;
});
const wordwithLength1 = stringsent
  .split(" ")
  .reduce((a, b) => (a.length > b.length ? a : b));

//console.log("max length word is:", MaxLengthwordIs);
//console.log("max length word is:", wordwithLength1);

//15) How swap two strings without using third variable.
let a = 5;
let b = 6;
a = a + b; //11
b = a + b; //5
a = a + b; //6
//console.log(a, b);
let x = "Ramu";
let y = "Beemu";
x = x.concat(y);
y = x.substring(0, x.length - y.length);
x = x.substring(y.length);
//console.log(x, y);

//16) How to find given two arrays are equal or Not arr1 = [1,2,3] arr2 = [2,3,1].

const array1 = [1, 2, 3, 4, 5];
const array2 = [2, 1, 3, 5, 4];
const isArraysame = array1.every((curr) => array2.includes(curr));
//console.log("isArraysame", isArraysame);

//17) How to convert first letter of each word in to Uppercase in a given sentense.
const st = "i am good boy";
const firstletterCapital = st
  .split(" ")
  .map((x) =>
    x.substring(0, 1).toUpperCase().concat(x.substring(1).toLowerCase())
  )
  .join(" ");

const firstletterCapital1 = st
  .split(" ")
  .map((x) => x.charAt(0).toUpperCase() + x.slice(1).toLowerCase())
  .join("");

//console.log("firstLetterCapital", firstletterCapital, firstletterCapital1);

//18) Replace Underscore with space and capitalize the each in given sent, i/p: str = "i_am_good_boy";
const strs = "i_am_good_boy";
let replaceUnderScoreCapitalize = strs
  .split("_") //  .replaceAll("_", "")
  .map((x) =>
    x.substring(0, 1).toUpperCase().concat(x.substring(1).toLowerCase())
  )
  .join(" ");

//console.log("replaceUnderScoreCapitalize", replaceUnderScoreCapitalize);
const strs1 = "i am good boy";
let replaceUnderScoreCapitalize1 = strs1
  .split(" ")
  .map((x) =>
    x.substring(0, 1).toUpperCase().concat(x.substring(1).toLowerCase())
  )
  .join("+");

//console.log("replaceUnderScoreCapitalize", replaceUnderScoreCapitalize1);
//21) Reverese each word in the given sentense.
const sent = "my name is tirupathi naidu";

const revSentense = sent
  .split(" ")
  .map((word) => word.split("").reverse().join(""))
  .join(" ");
//console.log("revSentense", revSentense);

//23) write js prog that returns a passed String with letters in alphabetical order.
const alphasent = "alphabet";
//console.log("word in aplbettical order", alphasent.split("").sort().join(""));
// console.log(
//   "word in aplbettical order",
//   alphasent
//     .split("")
//     .sort((a, b) => b.localeCompare(a))
//     .join("")
// );

//count How Many times "L" repeated in the given String "Hello world".
let strHello = "Hello world";
let cont = 0;
for (let c of strHello.split(" ").join("").split("")) {
  if (c === "l") {
    cont++;
  }
}

//console.log("cont", cont);
//30) array ["Rajini", "Ramu", "Reethu", "Suhash", "Soundarya", "Sree", "Aman", "Amar", "Chiru"], group By first character.
const arrayOfStr = [
  "Rajini",
  "Ramu",
  "Reethu",
  "Suhash",
  "Soundarya",
  "Sree",
  "Aman",
  "Amar",
  "Chiru",
];
const grpByFirstChar = arrayOfStr.reduce((acc, curr) => {
  const firstChar = curr[0];
  if (!acc[firstChar]) acc[firstChar] = [];
  acc[firstChar].push(curr);
  return acc;
}, {});

//console.log("grpByFirstCharacyer", grpByFirstChar);

const strrrr = "This is java code";

const output = strrrr
  .split(" ")
  .join("")
  .split("")
  .reduce((acc, curr) => {
    acc[curr] = (acc[curr] || 0) + 1;
    return acc;
  }, {});
//console.log("output", output);

const maxkey1 = Object.keys(output).reduce((a, b) =>
  output[a] > output[b] ? a : b
);
//console.log(maxkey1);

//47) Reverse the full sentense and each word also from the given sentense
let str2 = "i am not string";
let st22 = str2.split(" ").reverse();
let revrsedword = st22.map((x) => x.split("").reverse().join(""));
//console.log("st is:::::", revrsedword.join(" "));

//48) For the given String s = "I am good", string needs to be reversed and we Need to preserve the spaces. expected o/p: is "d oo gmai";

let str1 = "i am good";

let reversed = str1.split(" ").join("").split("").reverse();
//console.log("reversed", reversed);
let original = str1.split("");
//console.log("original", original);
let index = 0;
for (let i = 0; i < original.length; i++) {
  if (str1.charAt(i) !== " ") {
    original[i] = reversed[index];
    index++;
  }
}
//console.log("original is:::", original.join(""));

// const bracketsCheck = "{[()]}";
// function isvalid(s) {
//   const stack = [];
//   const matchingBrackets = { "}": "{", "]": "[", "}": "{" };

//   for (const ch of s) {
//     if (ch == "{" || ch == "(" || ch == "[") {
//       stack.push(ch);
//     } else if (
//       matchingBrackets[ch] &&
//       stack[stack.length - 1] === matchingBrackets[ch]
//     ) {
//       stack.pop();
//     } else {
//       return false;
//     }

//     return stack.langth === 0;
//   }
// }
// console.log("isvalid(bracketsCheck); is::::", isvalid(bracketsCheck));
//Check this Programme code in Java

const longestSubstringWithoutRepeatingCharacters = (arr) => {
  let result = "";
  for (let i = 0; i < arr.length; i++) {
    let set = new Set();
    let currentStr = "";
    for (let j = i; j < arr.length; j++) {
      if (set.has(arr[j])) {
        break;
      }
      set.add(arr[j]);
      currentStr += arr[j];
    }
    if (currentStr.length > result.length) {
      result = currentStr;
    }
  }
  return result;
};

console.log(longestSubstringWithoutRepeatingCharacters("tirupathinaidu"));
