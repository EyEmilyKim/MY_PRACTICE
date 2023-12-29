module.exports = function (io){
    // io 관련 모든 일
    io.on("connection", async(socket)=>{
        console.log("client is connected : ", socket.id);
        
        socket.on("login", async(userName, cb)=>{
            console.log("backend userName : ", userName);

            //User 정보를 저장
            
        })

        socket.on("disconnect", ()=>{
            console.log("user is disconnected : ", socket.id);
        })
    });
};
