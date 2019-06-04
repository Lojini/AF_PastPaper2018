const express= require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const app = express();

app.use(express.json());

app.use(bodyParser.urlencoded({extend : false}));
app.use(bodyParser.json());

mongoose.connect("mongodb://localhost:27017/practise").then(()=>{
    console.log("Connected to DB");
}).catch(err =>{
    console.log(err);
    process.exit(-1);
});

app.use('/api/courses',require('./app/routes/courseRouter'));

app.listen(3000,err =>{
    if(err){
        console.log(err);
        return;

    }
    console.log("Application running on port 3000");
});
