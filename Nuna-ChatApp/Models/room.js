const mongoose = require("mongoose");

const roomSchema = new mongoose.Schema(
  {
    title: String,
    members: [
      {
        type: mongoose.Schema.ObjectId,
        unique: true,
        ref: "User",
      },
    ],
  },
  { timestamp: true }
);

module.exports = mongoose.model("Room", roomSchema);
