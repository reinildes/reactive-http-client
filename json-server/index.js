const express = require('express')

const app = express()

app.get('/', (req, res) => {

   res.contentType('application/json')
   res.sendFile(__dirname + '/big.json')

})

app.listen(3000, () => console.log('server started: http://localhost:3000/'))
