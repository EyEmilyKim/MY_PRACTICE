const Chat = require("../Models/chat");
const chatController = {};

chatController.saveChat = async (message, user) => {
  console.log("saveChat called");
  console.log("user.name : ", user.name);
  console.log("message : ", message);
  const newMessage = new Chat({
    chat: message,
    user: {
      id: user._id,
      name: user.name,
    },
  });
  await newMessage.save();
  return newMessage;
};

module.exports = chatController;
