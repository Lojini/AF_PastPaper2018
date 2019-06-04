const mongoose = require('mongoose');

const subjectSchema = new mongoose.Schema({

    _id : mongoose.Schema.Types.ObjectId,
    name: {
        type:String,
        required :true
    },
    description :{
        type:String,
        required :true
    },
    amount:{
        type:Number
    }
});

module.exports =mongoose.model('Subject',subjectSchema);