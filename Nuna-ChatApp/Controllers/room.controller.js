const Room = require("../Models/room");
const roomController = {};

roomController.getAllRooms = async () => {
  const roomList = await Room.find({});
  return roomList;
};

roomController.checkRoom = async (rid) => {
  const room = await Room.findById(rid);
  console.log("checkRoom", room);
  return room;
};

// 룸 새로 만들기
roomController.createRoom = async (rTitle) => {
  console.log("roomController/createRoom called");
  // 이미 존재하는 방제목인지 확인
  let room = await Room.findOne({ title: rTitle });
  // -> 있으면 알려주기
  if (room) {
    throw new Error("이미 존재하는 방 제목입니다.");
  }
  // -> 없으면 새로 방정보 만들기
  else {
    room = new Room({
      title: rTitle,
    });
  }
  await room.save();
  console.log("roomController/createRoom done", room);
  return room;
};

roomController.joinRoom = async (roomId, user) => {
  console.log("roomController/joinRoom called");
  console.log("roomId", roomId);

  const room = await Room.findById(roomId);

  if (!room) {
    throw new Error("해당 방이 없습니다.");
  }
  if (!room.members.includes(user._id)) {
    room.members.push(user._id);
    await room.save();
  }
  user.room = roomId;
  const userRoomToString = user.room.toString();
  await user.save();

  console.log("roomController/joinRoom done");
};

roomController.leaveRoom = async (user) => {
  const room = await Room.findById(user.room);
  if (!room) {
    throw new Error("Room not found");
  }
  room.members.remove(user._id);
  await room.save();
  console.log("roomController/leaveRoom done");
};

module.exports = roomController;
