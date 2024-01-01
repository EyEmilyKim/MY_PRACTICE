const chatController = require("../Controllers/chat.controller");
const userController = require("../Controllers/user.controller");

module.exports = function (io) {
  // io 관련 모든 일
  io.on("connection", async (socket) => {
    console.log("client is connected : ", socket.id);

    //User 로그인 하면
    socket.on("login", async (userName, cb) => {
      console.log("backend userName : ", userName);
      //User 정보를 저장
      try {
        const user = await userController.saveUser(userName, socket.id);
        const welcomeMessage = {
          chat: `${user.name} joined this room`,
          user: { id: null, name: "system" },
        };
        io.emit("message", welcomeMessage);
        cb({ ok: true, data: user });
      } catch (error) {
        cb({ ok: false, error: error.message });
      }
    });

    //메시지 들어오면
    socket.on("sendMessage", async (message, cb) => {
      try {
        //socket id 로 유저 찾기
        const user = await userController.checkUser(socket.id);
        //메세지 저장(유저 정보 전달)
        const newMessage = await chatController.saveChat(message, user);
        
        io.emit("message", newMessage);
        cb({ ok: true });
      } catch (error) {
        cb({ ok: false, error: error.message });
      }
    });

    //User 퇴장하면
    socket.on("leaveRoom", async (user, cb)=>{
      // console.log("퇴장하는 user : ", user);
      const leavingMessage = {
        chat: `${user.name} left this room`,
        user: { id: null, name: "system" },
      };
      io.emit("message", leavingMessage);
      cb({ ok: true });
    })

    socket.on("disconnect", () => {
      console.log("user is disconnected : ", socket.id);
    });
  });
};
