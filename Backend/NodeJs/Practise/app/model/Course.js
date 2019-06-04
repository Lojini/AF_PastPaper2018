const mongoose = require('mongoose');
const Subject = require('./Subject');
const courseSchema = new mongoose.Schema ({

    code : {
        type:String,
        required : true
    },
    name : {
        type:String,
        required:true
    },
    passMark : {
        type: Number,

    },
    lectureInCharge:{
        type:String
    },
    subject :[{
        type: mongoose.Schema.Types.ObjectId,
        ref : 'Subject'

    }]


});

module.exports = mongoose.model('Course',courseSchema);