var x = 1;
function test() {
  console.log(x); // undefind
  var x = 2;
  console.log(x); //2
}
//test();

let y = 10;
{
  console.log(y); //let variables are in the Temporal Dead Zone until initialized.
  //First console.log(y) → ReferenceError
  let y = 20;
  console.log(y); //Second console.log(y) never runs because of the error.
}

var a = 1;
(function () {
  console.log(a); //undefind
  if (true) {
    var a = 2;
    console.log(a); //2
  }
  console.log(a); //2
})();

for (var i = 0; i < 3; i++) {
  setTimeout(() => console.log(i), 100);
} //var is function-scoped not Block scoped → the same i is shared. //Output: 3,3,3

for (let i = 0; i < 3; i++) {
  setTimeout(() => console.log(i), 100); //let is block-scoped → each iteration has its own i. //Output: 0,1,2
}

console.log(a);
const a = 10; //const is in Temporal Dead Zone until initialized → ReferenceError,Cannot access 'a' before initialization

{
  console.log(a); //undefind
  var a = 1;
  console.log(b); //Reference error,Cannot access 'a' before initialization
  let b = 2;
  console.log(c); //never execute coz of above ref error.
  const c = 3;

  var promises = [];
  for (var i = 0; i < 3; i++) {
    //var i is function-scoped → all three callbacks capture the same i, which ends as 3.
    promises.push(Promise.resolve().then(() => console.log(i))); //
  }
  for (let j = 0; j < 3; j++) {
    promises.push(Promise.resolve().then(() => console.log(j)));
    //let j is block-scoped → fresh binding per iteration (0, 1, 2).
  }
  await Promise.all(promises); // What gets printed (order may vary)?
}
