const Room = require("../Models/room");
const roomController = {};

roomController.getAllRooms = async () => {
  const roomList = await Room.find({});
  return roomList;
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

module.exports = roomController;
