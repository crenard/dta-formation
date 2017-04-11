fetch('https://jsonplaceholder.typicode.com/photos')
.then(resp => resp.json())
.then(photos => photos.map(item => item.title))
.then(names => console.log(names))
