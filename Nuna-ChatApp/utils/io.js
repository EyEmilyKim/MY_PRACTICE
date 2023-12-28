module.exports = function (io){
    // io 관련 모든 일
    io.on("connection", async(socket)=>{
        console.log("client is connected : ", socket.id);
        
        
        socket.on("disconnect", ()=>{
            console.log("user is disconnected : ", socket.id);
        })
    });
};
