// for(var i =0; i<5; i++){
//     let c = setTimeout(()=>{
//         console.log(i)
//     }, 1000);
// }
// for(let i =0; i<5; i++){
//     setTimeout(()=>{
//         console.log(i)
//     }, 1000);
// }

// for(var i=0; i<5; i++){
//     (function(x){setTimeout(()=>{console.log(x)}, 1000)})(i);
// }

//what will be the order of execution
console.log('1');

setTimeout(()=>{console.log(2)}, 0)

Promise.resolve().then(()=>console.log(3)).then(()=>console.log(4));

async function sample(){
    console.log(5);
    await Promise.resolve().then(()=>console.log(6));
    console.log(7);
}

sample().then(()=>console.log(8)).then(console.log(9));

console.log(10)


// console.log('1');

// setTimeout(()=>{console.log(2)}, 0)

// Promise.resolve().then(()=>console.log(3)).then(()=>console.log(4));

// async function sample(){
//     console.log(5);
//     await Promise.resolve().then(()=>console.log(6));
//     console.log(7);
// }

// sample()

// console.log(8)
