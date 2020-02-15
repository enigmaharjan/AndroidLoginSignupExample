const express = require('express');
const router = express.Router();
const orderModel = require('../models/order');

router.route('/')
    .get(async(req,res)=>{
        const data = await orderModel.find({})
        res.send(data);
    })
    .post(async(req,res)=>{
        console.log(req.body)
        const post = new orderModel({
            userid:req.body.userid,
            instrumentid:req.body.instrumentid,
            cart:false,
            sold:false
        })
        const data = await post.save();
        res.send(data)
    })
router.route('/:id')
    .get(async(req,res)=>{
        console.log(req.params.id)
        try{
        const data = await orderModel.find({userid:"1"})
        res.send(data)
        }
        catch(err){
            console.log("Something is wrong")
            res.send("Something is wrong")
        }
    })  
    .put(async(req,res)=>{
        const data = await orderModel.updateOne({_id:req.params.id},{
            $set:{
                sold:true
            }
        })
        res.send(data)
    })
module.exports = router