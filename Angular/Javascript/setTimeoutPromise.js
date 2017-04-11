promiseOfTimeOut(1000).then(doItLater);

function promiseOfTimeOut(time){
    return new Promise((resolve, reject) => 
        setTimeout(resolve,time)
    )
}

function doItLater(){
    console.log("hello")
}