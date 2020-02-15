const Express = require('express')
const bodyParser = require('body-parser')
const mongoose = require('mongoose')
const cors = require('cors')
const port = 3000;

const url = 'mongodb://localhost:27017/mydb';
const connect = mongoose.connect(url, {
    useNewUrlParser: true,
    useCreateIndex: true
});

connect.then((db) => {
    console.log("Connected to mongodb server");
}, (err) => { console.log(err); });

const express = new Express();
express.use(bodyParser.json())
express.use(cors())

const userRoute = require('./routers/index')
const orderRoute = require('./routers/order')
express.use('/user',userRoute)
express.use('/order', orderRoute)
express.get('/',(req,res)=>{
    res.send("Server is up and running")
})

express.listen(port,'localhost',()=>{
    console.log("Server started at port "+port);
})