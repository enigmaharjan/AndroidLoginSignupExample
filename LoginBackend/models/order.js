const mongoose = require('mongoose')
const schema = mongoose.Schema;

const testSchema = new schema({
    userid:{
        type:String,
        require:true
    },
    instrumentid:{
        type:String,
        require:true
    },
    cart:{
        type:Boolean,
        require:true
    },
    sold:{
        type:Boolean,
        require:true
    }
})

const test = mongoose.model('order', testSchema)
module.exports = test