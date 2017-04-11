let tab = [5, 15, 20];
let extraFind=function(arr,test){
    return arr.reduce((acc, value, index) =>{
        return (!acc && test(value))?{value, index}: acc;
    },undefined);
};
console.log(extraFind(tab, x => x > 10));

let extraMap = function(arr, math){
    return arr.reduce((acc, value) =>{
        return [...acc, math(value)];
    },[]);
}
console.log(extraMap(tab, x => x + 10));