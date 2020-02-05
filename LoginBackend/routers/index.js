const express = require('express')
const router = express.Router();
const userModel = require('../models/index')

router.route('/signup')
    .get(async(req,res)=>{
        const data = await userModel.find({})
        res.send(data)
    })
    .post(async(req,res)=>{
        const post = new userModel({
            fullname:req.body.fullname,
            username:req.body.username,
            email:req.body.email,
            password:req.body.password,
            phone:req.body.phone
        })
        try{
        const data = await post.save();
        if(data!=null){
            res.send({
                status:true,
                message:'Register Successful'
            })
        }
        else{
            res.send({
                status:false,
                message:'Register UnSuccessful'
            })
        }
    }
    catch(err){
        res.send({
            status:false,
            message:'Something is wrong'
        })
    }
    })
router.route('/login')
    .post( async (req,res)=>{
        const username = req.body.email
        const password = req.body.password
        // console.log(req.body)
        const data = await userModel.findOne({username:username})
        // console.log(data)
        if(data!=null){
            if(data.password===password){
                res.send({
                    status:true,
                    message:'Login Successful'
                })
            }
            else{
                res.send({
                    status:false,
                    message:'Password Wrong'
                })
            }
        }
        else{
            res.send({
                status:false,
                message:'User Not Found'
            })
        }
    })

    module.exports = router