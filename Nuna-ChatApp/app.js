const express = require("express")
const mongoose = require("mongoose")
require('dotenv').config()
const cors = require("cors")
const app = express()
app.use(cors())


mongoose.connect(process.env.DB)
    .then(()=>console.log("몽고디비에 연결되었습니다!"))
    .catch((err)=>console.log("몽고디비 연결 오류 : ", err));


module.exports = app
