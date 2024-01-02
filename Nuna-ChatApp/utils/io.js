const chatController = require("../Controllers/chat.controller");
const userController = require("../Controllers/user.controller");
const roomController = require("../Controllers/room.controller");

module.exports = function (io) {
  // io 관련 모든 일
  io.on("connection", async (socket) => {
    console.log("client is connected : ", socket.id);

    //룸 정보 보내주기
    socket.emit("rooms", await roomController.getAllRooms());

    //룸 입장하기
    socket.on("joinRoom", async (rid, cb) => {
      console.log("io.js/joinRoom called");
      try {
        const user = await userController.checkUser(socket.id); //일단 유저정보 들고 오기
        await roomController.joinRoom(rid, user); //room,user모델 업데이트
        const userRoomToString = user.room.toString();
        console.log("userRoomTostring", userRoomToString);
        socket.join(userRoomToString); //해당 룸채널 조인
        const welcomeMessage = {
          chat: `${user.name} joined this room`,
          user: { id: null, name: "system" },
        };
        io.to(userRoomToString).emit("message", welcomeMessage); //해당룸에 유저 입장 메세지 보냄
        io.emit("rooms", await roomController.getAllRooms()); //실시간 룸정보 전체 유저들에게 보냄
        cb({ ok: true });
      } catch (error) {
        cb({ ok: false, error: error.message});
      }
    });

    //User 로그인 하면
    socket.on("login", async (userName, cb) => {
      console.log("backend userName : ", userName);
      //User 정보를 저장
      try {
        const user = await userController.saveUser(userName, socket.id);
        
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
    socket.on("leaveRoom", async (user, cb) => {
      // console.log("퇴장하는 user : ", user);
      const leavingMessage = {
        chat: `${user.name} left this room`,
        user: { id: null, name: "system" },
      };
      io.emit("message", leavingMessage);
      cb({ ok: true });
    });

    socket.on("disconnect", () => {
      console.log("user is disconnected : ", socket.id);
    });
  });
};
