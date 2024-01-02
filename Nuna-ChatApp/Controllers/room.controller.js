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
}

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
  if(!room){
    throw new Error("Room not found");
  }
  room.members.remove(user._id);
  await room.save();
  console.log("roomController/leaveRoom done");
};

module.exports = roomController;
