const Course =require('../model/Course');


const courseController = function () {

    this.insert = (data) => {
        return new Promise ((resolve,reject) =>{
             const course =new Course ({
                 name: data.Name,
                 code : data.Code,
                 passMark : data.passMark,
                 lectureInCharge: data.lectureInCharge,
                 subject : data.subject

             });
             course.save().then(() => {
                 resolve ( {status :200,message : "Course added"});
             }).catch(err => {
                 reject({status : 500,message : err});
             })

        });
    }

    this.getAll = () => {
        return new Promise((resolve,reject) => {
            Course.find().then((data) => {
                resolve({status :200,data:data} )
            }).catch(err =>{
                reject({status:500, message : err })
            })
        })
    }

    this.getById = (id) => {
        return new Promise((resolve,reject) => {
            Course.findOne({code :id} ).populate('subject').then((data) => {
                resolve({status :200,data:{subjects:data.subject}});
            }).catch(err => {
                reject({status:500,message : err});
            });
        });
    }


}

module.exports = new courseController;